package son.ysy.plugin.dependencies

import com.squareup.kotlinpoet.*
import com.squareup.moshi.Moshi
import junit.framework.TestCase
import org.junit.Test
import son.ysy.plugin.dependencies.model.AndroidDependencyModel
import son.ysy.plugin.dependencies.model.single.SingleDependency
import java.io.File
import java.lang.Error

class AndroidDependencyTest : TestCase() {

    private object DependencyValues {
        val packageList = listOf("son", "ysy", "plugin", "dependencies")
    }

    private object DependencyProperties {
        const val KEY_GROUP = "group"
        const val KEY_MODULE = "module"
        const val KEY_VERSION = "version"
        const val KEY_FULL_GRADLE = "fullGradle"
    }

    private object DependencyFunctions {
        const val KEY_BUILD = "build"
        const val KEY_CUSTOM_VERSION = "customVersion"
    }

    private object DependencyClasses {
        const val KEY_CLASS_TOP = "AndroidDependencyAutoCreated"
        const val KEY_CLASS_SINGLE = "Single"
        const val KEY_CLASS_VIEW = "View"
        const val KEY_CLASS_TEST = "Test"
    }

    private val jsonAdapter = Moshi.Builder().build().adapter(AndroidDependencyModel::class.java)

    /**
     * 从Resource文件夹读取json文件
     */
    private fun getJsonFromResource(): String {
        return Thread.currentThread()
            .contextClassLoader
            .getResourceAsStream("dependencies.json")
            ?.reader()
            ?.readText()
            ?: throw Error("读取json失败")
    }

    private fun getDependencyModelFromJson(json: String): AndroidDependencyModel {
        return jsonAdapter.fromJson(json) ?: throw Error("json转换model失败")
    }

    private fun getDependencyModel(): AndroidDependencyModel {
        return getDependencyModelFromJson(getJsonFromResource())
    }

    /**
     * json文件排序
     */
    @Test
    fun testSortedJson() {
        getDependencyModel().sorted()
            .run(jsonAdapter::toJson)
            .apply(::println)
    }

    @Test
    fun testCreateAll() {
        testCreateKt()
        testCreateMd()
    }

    @Test
    fun testCreateKt() {
        val dependencyModel = getDependencyModel()
        //声明AndroidDependency类
        val androidDependencyClassBuilder = TypeSpec.classBuilder(DependencyClasses.KEY_CLASS_TOP)
        androidDependencyClassBuilder.addAnnotation(
            AnnotationSpec.builder(Suppress::class)
                .addMember("%S,%S", "MemberVisibilityCanBePrivate", "unused")
                .build()
        )
        //声明AndroidDependency为抽象类
        androidDependencyClassBuilder.addModifiers(KModifier.ABSTRACT)
        //声明AndroidDependency构造函数
        androidDependencyClassBuilder.primaryConstructor(
            FunSpec.constructorBuilder()
                .addParameter(DependencyProperties.KEY_GROUP, String::class)
                .addParameter(DependencyProperties.KEY_MODULE, String::class)
                .addParameter(DependencyProperties.KEY_VERSION, String::class)
                .addModifiers(KModifier.PRIVATE)
                .build(),
        )
        //声明AndroidDependency group属性
        androidDependencyClassBuilder.addProperty(
            PropertySpec.builder(DependencyProperties.KEY_GROUP, String::class)
                .initializer(DependencyProperties.KEY_GROUP)
                .build()
        )
        //声明AndroidDependency module属性
        androidDependencyClassBuilder.addProperty(
            PropertySpec.builder(DependencyProperties.KEY_MODULE, String::class)
                .initializer(DependencyProperties.KEY_MODULE)
                .build()
        )
        //声明AndroidDependency version属性
        androidDependencyClassBuilder.addProperty(
            PropertySpec.builder(DependencyProperties.KEY_VERSION, String::class)
                .initializer(DependencyProperties.KEY_VERSION)
                .mutable()
                .build()
        )
        //声明AndroidDependency build私有方法
        androidDependencyClassBuilder.addFunction(
            FunSpec.builder(DependencyFunctions.KEY_BUILD)
                .addParameter(DependencyProperties.KEY_VERSION, String::class)
                .addModifiers(KModifier.PRIVATE)
                .addCode(
                    "return %P",
                    "\$${DependencyProperties.KEY_GROUP}" +
                            ":" +
                            "\$${DependencyProperties.KEY_MODULE}" +
                            ":" +
                            "\$${DependencyProperties.KEY_VERSION}"
                )
                .build()
        )
        //声明AndroidDependency fullGradle计算属性
        androidDependencyClassBuilder.addProperty(
            PropertySpec.builder(DependencyProperties.KEY_FULL_GRADLE, String::class)
                .getter(
                    FunSpec.getterBuilder()
                        .addCode("return build(${DependencyProperties.KEY_VERSION})")
                        .build()
                )
                .build()
        )
        //声明AndroidDependency customVersion公共方法
        androidDependencyClassBuilder.addFunction(
            FunSpec.builder(DependencyFunctions.KEY_CUSTOM_VERSION)
                .addParameter(DependencyProperties.KEY_VERSION, String::class)
                .addStatement("this.${DependencyProperties.KEY_VERSION}=${DependencyProperties.KEY_VERSION}")
                .addCode(
                    "return ${DependencyFunctions.KEY_BUILD}(${DependencyProperties.KEY_VERSION})"
                ).returns(String::class)
                .build()
        )
        buildSingleClassSpec(DependencyClasses.KEY_CLASS_SINGLE, dependencyModel.single)
            .apply(androidDependencyClassBuilder::addType)

        buildSingleClassSpec(DependencyClasses.KEY_CLASS_VIEW, dependencyModel.view)
            .apply(androidDependencyClassBuilder::addType)

        dependencyModel.group
            .map { group ->
                val groupBuilder = TypeSpec.classBuilder(group.name)
                    .addModifiers(KModifier.SEALED)
                    .primaryConstructor(
                        FunSpec.constructorBuilder()
                            .addParameter(DependencyProperties.KEY_MODULE, String::class)
                            .build()
                    ).superclass(ClassName("", DependencyClasses.KEY_CLASS_TOP))
                    .addSuperclassConstructorParameter("%S", group.group)
                    .addSuperclassConstructorParameter(DependencyProperties.KEY_MODULE)
                    .addSuperclassConstructorParameter("%S", group.version)

                getKDoc(group.remark, group.link)?.apply(groupBuilder::addKdoc)

                group.modules
                    .map { child ->
                        val childBuilder = TypeSpec.objectBuilder(child.name)
                        if (!child.group.isNullOrBlank() && !child.version.isNullOrBlank()) {
                            childBuilder.superclass(ClassName("", DependencyClasses.KEY_CLASS_TOP))
                                .addSuperclassConstructorParameter("%S", child.group)
                                .addSuperclassConstructorParameter("%S", child.version)
                        } else {
                            childBuilder.superclass(ClassName("", group.name))
                        }
                        childBuilder.addSuperclassConstructorParameter("%S", child.module)


                        getKDoc(child.remark, child.link)?.apply(childBuilder::addKdoc)
                        childBuilder.build()
                    }.forEach {
                        groupBuilder.addType(it)
                    }
                groupBuilder.build()
            }.forEach {
                androidDependencyClassBuilder.addType(it)
            }


        buildSingleClassSpec(DependencyClasses.KEY_CLASS_TEST, dependencyModel.test)
            .apply(androidDependencyClassBuilder::addType)

        val fileSpec = FileSpec.builder(
            DependencyValues.packageList.joinToString("."),
            DependencyClasses.KEY_CLASS_TOP
        ).addType(androidDependencyClassBuilder.build())
            .build()

        val rootPathList = listOf("src", "test", "kotlin")

        fileSpec.writeTo(System.out)
        fileSpec.writeTo(File(rootPathList.joinToString(File.separator)))
    }

    private fun getKDoc(remark: String?, link: String?) = listOf(remark, link)
        .mapNotNull { it }
        .joinToString("\n")
        .ifBlank { null }

    private fun buildSingleClassSpec(className: String, list: List<SingleDependency>): TypeSpec {
        //声明类
        val singleClassBuilder = TypeSpec.objectBuilder(className)

        list.map { single ->
            val objectBuilder = TypeSpec.objectBuilder(single.name)
                .superclass(ClassName("", DependencyClasses.KEY_CLASS_TOP))
                .addSuperclassConstructorParameter("%S", single.group)
                .addSuperclassConstructorParameter("%S", single.module)
                .addSuperclassConstructorParameter("%S", single.version)

            getKDoc(single.remark, single.link)
                ?.apply(objectBuilder::addKdoc)
            objectBuilder.build()
        }.forEach {
            singleClassBuilder.addType(it)
        }
        return singleClassBuilder.build()
    }

    @Test
    fun testCreateMd() {
        val dependencyModel = getDependencyModel()

        val sb = StringBuilder()

        sb.appendMdLine("# 三方依赖库版本整理(${dependencyModel.version})")

        createSingleMd(dependencyModel.single, sb)
        sb.append("\n")
        createSingleMd(dependencyModel.view, sb)
        dependencyModel.group.forEach { group ->
            sb.append("\n")
            val groupName = group.name.takeIf {
                group.link.isNullOrBlank()
            } ?: "[${group.name}](${group.link})"

            sb.appendMdLine("|$groupName|${group.group}|${group.remark ?: ""}|")
            sb.appendMdLine("|:-:|:-:|:-:|")

            group.modules.forEach { child ->
                val childName = child.name.takeIf { child.link.isNullOrBlank() }
                    ?: "[${child.name}](${child.group})"
                val childModule = child.module.takeIf {
                    child.group.isNullOrBlank() || child.version.isNullOrBlank()
                } ?: "${child.group}:${child.module}:${child.version}"
                val childVersion = group.version.takeIf {
                    child.remark.isNullOrBlank()
                } ?: child.remark
                sb.appendMdLine("|$childName|$childModule|$childVersion|")
            }
        }
        sb.append("\n")
        createSingleMd(dependencyModel.test, sb)

        File("ReadMe.auto.md").writeText(sb.toString())
    }

    private fun StringBuilder.appendMdLine(line: String) {
        append(line)
        append("  \n")
    }

    private fun createSingleMd(list: List<SingleDependency>, sb: StringBuilder) {
        sb.appendMdLine("|name|group|module|version|remark|")
        sb.appendMdLine("|:-:|:-:|:-:|:-:|:-:|")
        list.forEach { single ->
            val name = single.name.takeIf {
                single.link.isNullOrBlank()
            } ?: "[${single.name}](${single.link})"
            val singleLine =
                listOf(
                    name,
                    single.group,
                    single.module,
                    single.version,
                    single.remark ?: ""
                ).joinToString(separator = "|", postfix = "|", prefix = "|")
            sb.appendMdLine(
                singleLine,
            )
        }
    }
}