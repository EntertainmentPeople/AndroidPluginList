package son.ysy.plugin.dependencies

sealed class AndroidDependency(
    val group: String,
    val name: String,
    var version: String
) {

    object AndroidX {
        /**
         * https://developer.android.com/jetpack/androidx/releases/appcompat
         */
        object Appcompat : AndroidDependency("androidx.appcompat", "appcompat", "1.3.0-alpha02")

        /**
         * https://developer.android.com/jetpack/androidx/releases/core
         */
        object CoreKtx : AndroidDependency("androidx.core", "core-ktx", "1.5.0-alpha04")

        /**
         * 异步加载布局
         * https://developer.android.com/jetpack/androidx/releases/asynclayoutinflater
         */
        object AsyncInflater : AndroidDependency(
            "androidx.asynclayoutinflater",
            "asynclayoutinflater",
            "1.0.0"
        )

        /**
         *  https://developer.android.com/jetpack/androidx/releases/activity
         */
        object Activity : AndroidDependency(
            "androidx.activity",
            "activity-ktx",
            "1.2.0-beta01"
        )
    }

    object Test {
        object Junit : AndroidDependency("junit", "junit", "4.13")
        object JunitExt : AndroidDependency("androidx.test.ext", "junit", "1.1.2-rc02")
        object Espresso : AndroidDependency("androidx.test.espresso", "espresso-core", "3.3.0-rc02")
    }

    /**
     * 多功能工具包
     * https://github.com/Blankj/AndroidUtilCode
     */
    object AndroidUtil : AndroidDependency("com.blankj", "utilcodex", "1.30.0")

    /**
     * app启动初始化管理
     * https://github.com/YummyLau/Anchors/blob/master/README-zh.md
     */
    object Anchors : AndroidDependency("com.effective.android", "anchors", "1.1.2")

    /**
     * 持久KV数据存储
     * https://github.com/Tencent/MMKV/blob/master/readme_cn.md
     */
    object Mmkv : AndroidDependency("com.tencent", "mmkv-static", "1.2.4")

    /**
     * 颜色帮助库
     * https://github.com/JorgeCastilloPrz/AndroidColorX
     */
    object ColorKtx : AndroidDependency("me.jorgecastillo", "androidcolorx", "0.2.0")

    /**
     * 背景生成工具库
     * https://github.com/JavaNoober/BackgroundLibrary
     */
    object Background : AndroidDependency("com.noober.background", "core", "1.6.5")

    /**
     * 二维码扫描
     * https://github.com/jenly1314/ZXingLite
     */
    object QrScanner : AndroidDependency("com.king.zxing", "zxing-lite", "1.1.9-androidx")

    /**
     * 时间处理库
     * https://github.com/JodaOrg/joda-time
     */
    object JodaTime : AndroidDependency("joda-time", "joda-time", "2.10.8")

    /**
     * 自动消失LiveData
     * https://github.com/KunMinX/UnPeek-LiveData
     */
    object UnPeekLiveData : AndroidDependency(
        "com.kunminx.archi",
        "unpeek-livedata",
        "4.4.1-beta1"
    )

    /**
     * 内存泄露监控
     * https://square.github.io/leakcanary/getting_started/
     */
    object LeakCanary : AndroidDependency("com.squareup.leakcanary", "leakcanary-android", "2.5")

    val newest: String
        get() = build(version)

    private fun build(version: String) = "$group:$name:$version"
    fun custom(version: String) {
        this.version = version
    }

    /**
     *  https://developer.android.com/jetpack/androidx/releases/fragment
     */
    sealed class Fragment(
        name: String
    ) : AndroidDependency("androidx.fragment", name, "1.3.0-beta01") {
        object Core : Fragment("fragment")

        object Test : Fragment("fragment-testing")
    }

    /**
     * 组件化实现方案
     * https://github.com/xiaojinzi123/Component
     */
    sealed class Component(
        name: String
    ) : AndroidDependency("com.github.xiaojinzi123.Component", name, "v1.8.3.5-androidx-java8") {

        object Core : Component("component-impl")
        object Compiler : Component("component-compiler")
        object Plugin : Component("component-plugin")
    }

    /**
     * kotlin协程
     * https://github.com/Kotlin/kotlinx.coroutines
     */
    sealed class Coroutines(
        name: String
    ) : AndroidDependency("org.jetbrains.kotlinx", name, "1.4.1") {
        object Core : Coroutines("kotlinx-coroutines-android")
        object Test : Coroutines("kotlinx-coroutines-test")
    }

    /**
     * RecyclerView适配库
     * https://github.com/airbnb/epoxy
     */
    sealed class Epoxy(
        name: String
    ) : AndroidDependency("com.airbnb.android", name, "4.1.0") {
        object Core : Epoxy("epoxy")
        object Compiler : Epoxy("epoxy-processor")
        object Glide : Epoxy("epoxy-glide-preloading")
    }

    /**
     *Glide图片加载
     *  https://github.com/bumptech/glide
     */
    sealed class Glide(
        name: String
    ) : AndroidDependency("com.github.bumptech.glide", name, "4.11.0") {
        object Core : Glide("glide")
        object Compiler : Glide("compiler")
        object OkHttp : Glide("okhttp3-integration")
        object Annotation : Glide("annotations")

        /**
         * 图片转换库
         * https://github.com/wasabeef/glide-transformations
         */
        object Transformation : AndroidDependency("jp.wasabeef", "glide-transformations", "4.3.0")
    }

    /**
     *json解析库
     * https://github.com/square/moshi
     */
    sealed class MoShi(
        name: String
    ) : AndroidDependency("com.squareup.moshi", name, "1.11.0") {
        object Core : MoShi("moshi")
        object Compiler : MoShi("moshi-kotlin-codegen")
    }

    /**
     * https://github.com/JetBrains/kotlin
     */
    sealed class Kotlin(
        name: String
    ) : AndroidDependency("org.jetbrains.kotlin", name, "1.4.10") {
        object Stdlib : Kotlin("kotlin-stdlib")
        object Reflect : Kotlin("kotlin-reflect")
    }

    /**
     * 依赖注入库
     * https://github.com/InsertKoinIO/koin
     */
    sealed class Koin(
        name: String
    ) : AndroidDependency("org.koin", name, "2.2.0-rc-4") {
        object Core : Koin("koin-core")
        object Scope : Koin("koin-androidx-scope")
        object ViewModel : Koin("koin-androidx-viewmodel")
        object Ext : Koin("koin-androidx-ext")
        object Test : Koin("koin-test")
    }

    /**
     *  https://developer.android.com/jetpack/androidx/releases/lifecycle
     */
    sealed class Lifecycle(
        name: String
    ) : AndroidDependency("androidx.lifecycle", name, "2.3.0-beta01") {
        object ViewModel : Lifecycle("lifecycle-viewmodel-ktx")
        object Common : Lifecycle("lifecycle-common")
        object LiveData : Lifecycle("lifecycle-livedata-ktx")
        object Runtime : Lifecycle("lifecycle-runtime-ktx")
        object SavedState : Lifecycle("lifecycle-viewmodel-savedstate")
        object Process : Lifecycle("lifecycle-process")
        object Service : Lifecycle("lifecycle-service")
    }

    /**
     * https://github.com/square/okhttp
     */
    sealed class OkHttp(
        name: String
    ) : AndroidDependency("com.squareup.okhttp3", name, "4.9.0") {
        object Core : OkHttp("okhttp")
        object Mock : OkHttp("mockwebserver")
        object Interceptor : OkHttp("logging-interceptor")
    }

    /**
     * https://github.com/airbnb/paris
     */
    sealed class Paris(
        name: String
    ) : AndroidDependency("com.airbnb.android", name, "1.7.1") {
        object Core : Paris("paris")
        object Compiler : Paris("paris-processor")
    }

    /**
     *网络请求
     * https://github.com/square/retrofit
     */
    sealed class Retrofit(
        name: String
    ) : AndroidDependency("com.squareup.retrofit2", name, "2.9.0") {
        object Core : Retrofit("retrofit")
        object MoShi : Retrofit("converter-moshi")
    }

    /**
     * sqlite数据库
     * https://developer.android.com/jetpack/androidx/releases/room
     */
    sealed class Room(
        name: String
    ) : AndroidDependency("androidx.room", name, "2.2.5") {
        object Core : Room("room-runtime")
        object Ktx : Room("room-ktx")
        object Compiler : Room("room-compiler")
        object Test : Room("room-testing")
    }

    class View {

        /**
         * https://github.com/material-components/material-components-android
         */
        object Material : AndroidDependency(
            "com.google.android.material",
            "material",
            "1.3.0-alpha03"
        )

        /**
         * https://developer.android.com/jetpack/androidx/releases/viewpager2
         */
        object ViewPager2 : AndroidDependency(
            "androidx.viewpager2",
            "viewpager2",
            "1.1.0-alpha01"
        )

        /**
         * 约束布局
         * https://developer.android.com/jetpack/androidx/releases/constraintlayout
         */
        object ConstraintLayout : AndroidDependency(
            "androidx.constraintlayout",
            "constraintlayout",
            "2.0.4"
        )

        /**
         * https://developer.android.com/jetpack/androidx/releases/recyclerview
         */
        object RecyclerView : AndroidDependency(
            "androidx.recyclerview",
            "recyclerview",
            "1.2.0-alpha06"
        )

        /**
         * 底部导航
         *https://github.com/Ashok-Varma/BottomNavigation
         */
        object BottomNavigation : AndroidDependency(
            "com.ashokvarma.android",
            "bottom-navigation-bar",
            "2.2.0"
        )

        /**
         * 动画框架
         *  https://github.com/airbnb/lottie-android
         */
        object LottieView : AndroidDependency(
            "com.airbnb.android",
            "lottie",
            "3.4.4"
        )

        /**
         * 高斯模糊
         *  https://github.com/Dimezis/BlurView
         */
        object BlurView : AndroidDependency(
            "com.eightbitlab",
            "blurview",
            "1.6.5"
        )

        /**
         * 下拉刷新控件
         *  https://developer.android.com/jetpack/androidx/releases/swiperefreshlayout
         */
        object SwipeRefreshLayout : AndroidDependency(
            "androidx.swiperefreshlayout",
            "swiperefreshlayout",
            "1.2.0-alpha01"
        )

        /**
         * 跑马灯控件
         *  https://github.com/sunfusheng/MarqueeView
         */
        object MarqueeView : AndroidDependency(
            "com.sunfusheng",
            "MarqueeView",
            "1.4.1"
        )

        /**
         * 轮播控件
         *  https://github.com/youth5201314/banner
         */
        object BannerView : AndroidDependency(
            "com.github.xiaohaibin",
            "XBanner",
            "androidx_v1.1.0"
        )

        /**
         * 阴影控件
         */
        object ShadowLayout : AndroidDependency(
            "com.github.lihangleo2",
            "ShadowLayout",
            "3.1.2"
        )

        /**
         * webView
         */
        object AgentWeb : AndroidDependency(
            "com.just.agentweb",
            "agentweb",
            "4.1.4"
        )

        /**
         * FlexBox
         */
        object FlexBox : AndroidDependency("com.google.android", "flexbox", "2.0.1")
    }

    /**
     * 弹窗框架
     * https://github.com/li-xiaojun/XPopup
     */
    sealed class XPopup(
        name: String
    ) : AndroidDependency("com.lxj", name, "2.1.15") {
        object Core : XPopup("xpopup")
    }

    /**
     * 任务管理器
     * https://developer.android.com/jetpack/androidx/releases/work
     */
    sealed class WorkerManager(
        name: String
    ) : AndroidDependency("androidx.work", name, "2.5.0-beta01") {
        object Core : WorkerManager("work-runtime-ktx")
        object AndroidTest : WorkerManager("work-testing")
    }

    /**
     * 网络请求监控
     * https://github.com/ChuckerTeam/chucker
     */
    sealed class Chucker(name: String) : AndroidDependency(
        "com.github.chuckerteam.chucker",
        name,
        "library"
    ) {
        object Debug : Chucker("library")
        object Release : Chucker("library-no-op")
    }

    /**
     * 奔溃日志收集
     * https://github.com/iqiyi/xCrash/blob/master/README.zh-CN.md
     */
    object XCrash : AndroidDependency("com.iqiyi.xcrash", "xcrash-android-lib", "3.0.0")

    /**
     * Alerter弹窗
     * https://github.com/Tapadoo/Alerter
     */
    object Alerter : AndroidDependency("com.tapadoo.android", "alerter", "6.2.1")
}
