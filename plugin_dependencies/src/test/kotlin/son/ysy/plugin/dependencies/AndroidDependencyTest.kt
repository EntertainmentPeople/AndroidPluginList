package son.ysy.plugin.dependencies

import com.squareup.kotlinpoet.*
import com.squareup.moshi.Moshi
import junit.framework.TestCase
import org.junit.Test
import son.ysy.plugin.dependencies.model.AndroidDependencyModel
import son.ysy.plugin.dependencies.model.single.SingleDependency
import java.io.File
import java.lang.Error
import kotlin.random.Random

class AndroidDependencyTest : TestCase() {


    private object DependencyProperties {
        const val KEY_GROUP = "group"
        const val KEY_MODULE = "module"
        const val KEY_VERSION = "version"
        const val KEY_FULL_MAVEN = "fullMaven"
    }

    private object DependencyFunctions {
        const val KEY_BUILD = "build"
        const val KEY_CUSTOM_VERSION = "customVersion"
    }

    private object DependencyClasses {
        val KEY_CLASS_TOP = "AndroidDependency${Random.nextInt(1, 10000)}"
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
        //声明AndroidDependency fullMaven计算属性
        androidDependencyClassBuilder.addProperty(
            PropertySpec.builder(DependencyProperties.KEY_FULL_MAVEN, String::class)
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
                .build()
        )
        buildSingleClassSpec(DependencyClasses.KEY_CLASS_SINGLE, dependencyModel.single)
            .apply(androidDependencyClassBuilder::addType)

        buildSingleClassSpec(DependencyClasses.KEY_CLASS_VIEW, dependencyModel.view)
            .apply(androidDependencyClassBuilder::addType)

        dependencyModel.group
            .map { group ->
                val groupBuilder = TypeSpec.objectBuilder(group.name)
                getKDoc(group.remark, group.link)?.apply(groupBuilder::addKdoc)

                group.modules
                    .map { child ->
                        val childBuilder = TypeSpec.objectBuilder(child.name)
                            .superclass(ClassName("", DependencyClasses.KEY_CLASS_TOP))
                            .addSuperclassConstructorParameter("%S", child.group ?: group.group)
                            .addSuperclassConstructorParameter("%S", child.module)
                            .addSuperclassConstructorParameter("%S", child.version ?: group.version)
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
            "son.ysy.plugin.dependencies",
            DependencyClasses.KEY_CLASS_TOP
        ).addType(androidDependencyClassBuilder.build())
            .build()
        val dir = File(
            File("").absolutePath, "src${File.separator}main${File.separator}java${File.separator}"
        )
        fileSpec.writeTo(System.out)
        fileSpec.writeTo(dir)
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
}