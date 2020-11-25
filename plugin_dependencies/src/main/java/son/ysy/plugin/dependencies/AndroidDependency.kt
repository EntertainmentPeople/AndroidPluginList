package son.ysy.plugin.dependencies

import kotlin.String
import kotlin.Suppress

@Suppress("MemberVisibilityCanBePrivate", "unused")
abstract class AndroidDependency private constructor(
    val group: String,
    val module: String,
    var version: String
) {
    val fullMaven: String
        get() = build(version)

    private fun build(version: String) = """$group:$module:$version"""

    fun customVersion(version: String) {
        this.version = version
    }

    object Single {
        /**
         * https://developer.android.com/jetpack/androidx/releases/activity
         */
        object Activity : AndroidDependency("androidx.activity", "activity-ktx", "1.2.0-beta01")

        /**
         * Alerter弹窗
         * https://github.com/Tapadoo/Alerter
         */
        object Alerter : AndroidDependency("com.tapadoo.android", "alerter", "6.2.1")

        /**
         * app启动初始化管理
         * https://github.com/YummyLau/Anchors/blob/master/README-zh.md
         */
        object Anchors : AndroidDependency("com.effective.android", "anchors", "1.1.2")

        /**
         * 多功能工具包
         * https://github.com/Blankj/AndroidUtilCode
         */
        object AndroidUtil : AndroidDependency("com.blankj", "utilcodex", "1.30.5")

        /**
         * https://developer.android.com/jetpack/androidx/releases/appcompat
         */
        object Appcompat : AndroidDependency("androidx.appcompat", "appcompat", "1.3.0-alpha02")

        /**
         * 背景生成工具库
         * https://github.com/JavaNoober/BackgroundLibrary
         */
        object Background : AndroidDependency("com.noober.background", "core", "1.6.5")

        /**
         * 颜色帮助库
         * https://github.com/JorgeCastilloPrz/AndroidColorX
         */
        object ColorKtx : AndroidDependency("me.jorgecastillo", "androidcolorx", "0.2.0")

        /**
         * https://developer.android.com/jetpack/androidx/releases/core
         */
        object CoreKtx : AndroidDependency("androidx.core", "core-ktx", "1.5.0-alpha05")

        /**
         * 多媒体选择库
         * https://github.com/yangpeixing/YImagePicker
         */
        object ImagePicker :
            AndroidDependency("com.ypx.yimagepicker", "androidx", "3.1.4")

        /**
         * 时间处理库
         * https://github.com/JodaOrg/joda-time
         */
        object JodaTime : AndroidDependency("joda-time", "joda-time", "2.10.8")

        /**
         * 内存泄露监控
         * https://square.github.io/leakcanary/getting_started/
         */
        object LeakCanary : AndroidDependency(
            "com.squareup.leakcanary",
            "leakcanary-android",
            "2.5"
        )

        /**
         * 持久KV数据存储
         * https://github.com/Tencent/MMKV/blob/master/readme_cn.md
         */
        object Mmkv : AndroidDependency("com.tencent", "mmkv-static", "1.2.4")

        /**
         * 二维码扫描
         * https://github.com/jenly1314/ZXingLite
         */
        object QrScanner :
            AndroidDependency("com.king.zxing", "zxing-lite", "1.1.9-androidx")

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
         * 微信开发Sdk
         * https://developers.weixin.qq.com/doc/oplatform/Mobile_App/Resource_Center_Homepage.html
         */
        object WeChat : AndroidDependency(
            "com.tencent.mm.opensdk",
            "wechat-sdk-android-without-mta",
            "6.6.5"
        )

        /**
         * 奔溃日志收集
         * https://github.com/iqiyi/xCrash/blob/master/README.zh-CN.md
         */
        object XCrash : AndroidDependency(
            "com.iqiyi.xcrash",
            "xcrash-android-lib",
            "3.0.0"
        )

        /**
         * 弹窗框架
         * https://github.com/li-xiaojun/XPopup
         */
        object XPopup : AndroidDependency("com.lxj", "xpopup", "2.2.5")
    }

    object View {
        /**
         * 浏览器
         * https://github.com/Justson/AgentWeb
         */
        object AgentWeb : AndroidDependency("com.just.agentweb", "agentweb", "4.1.4")

        /**
         * 轮播控件
         * https://github.com/xiaohaibin/XBanner/tree/androidX
         */
        object BannerView : AndroidDependency(
            "com.github.xiaohaibin",
            "XBanner",
            "androidx_v1.1.2"
        )

        /**
         * 高斯模糊
         * https://github.com/Dimezis/BlurView
         */
        object BlurView : AndroidDependency("com.eightbitlab", "blurview", "1.6.5")

        /**
         * 底部导航
         * https://github.com/Ashok-Varma/BottomNavigation
         */
        object BottomNavigation : AndroidDependency(
            "com.ashokvarma.android",
            "bottom-navigation-bar",
            "2.2.0"
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
         * 流式布局
         * https://github.com/google/flexbox-layout
         */
        object FlexBox : AndroidDependency("com.google.android", "flexbox", "2.0.1")

        /**
         * 动画框架
         * https://github.com/airbnb/lottie-android
         */
        object LottieView : AndroidDependency("com.airbnb.android", "lottie", "3.5.0")

        /**
         * 跑马灯控件
         * https://github.com/sunfusheng/MarqueeView
         */
        object MarqueeView : AndroidDependency("com.sunfusheng", "MarqueeView", "1.4.1")

        /**
         * https://github.com/material-components/material-components-android
         */
        object Material : AndroidDependency(
            "com.google.android.material",
            "material",
            "1.3.0-alpha03"
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
         * 阴影控件
         * https://github.com/lihangleo2/ShadowLayout
         */
        object ShadowLayout : AndroidDependency(
            "com.github.lihangleo2",
            "ShadowLayout",
            "3.1.5"
        )

        /**
         * 下拉刷新控件
         * https://developer.android.com/jetpack/androidx/releases/swiperefreshlayout
         */
        object SwipeRefreshLayout : AndroidDependency(
            "androidx.swiperefreshlayout",
            "swiperefreshlayout",
            "1.2.0-alpha01"
        )

        /**
         * https://developer.android.com/jetpack/androidx/releases/viewpager2
         */
        object ViewPager2 : AndroidDependency(
            "androidx.viewpager2",
            "viewpager2",
            "1.1.0-alpha01"
        )
    }

    /**
     * 网络请求监控
     * https://github.com/ChuckerTeam/chucker
     */
    object Chucker {
        object Debug : AndroidDependency(
            "com.github.chuckerteam.chucker",
            "library",
            "3.4.0"
        )

        object Release : AndroidDependency(
            "com.github.chuckerteam.chucker",
            "library-no-op",
            "3.4.0"
        )
    }

    /**
     * 组件化实现方案
     * https://github.com/xiaojinzi123/Component
     */
    object Component {
        object Compiler : AndroidDependency(
            "com.github.xiaojinzi123.Component",
            "component-compiler",
            "v1.8.3.5-androidx-java8"
        )

        object Core : AndroidDependency(
            "com.github.xiaojinzi123.Component",
            "component-impl",
            "v1.8.3.5-androidx-java8"
        )

        object Plugin : AndroidDependency(
            "com.github.xiaojinzi123.Component",
            "component-plugin",
            "v1.8.3.5-androidx-java8"
        )
    }

    /**
     * 协程
     * https://github.com/Kotlin/kotlinx.coroutines
     */
    object Coroutines {
        object Core : AndroidDependency(
            "org.jetbrains.kotlinx",
            "kotlinx-coroutines-android",
            "1.4.1"
        )

        object Test : AndroidDependency(
            "org.jetbrains.kotlinx",
            "kotlinx-coroutines-test",
            "1.4.1"
        )
    }

    /**
     * 文件下载与上传
     * https://github.com/AriaLyy/Aria
     */
    object DownloadAndUpload {
        object Compiler : AndroidDependency("com.arialyy.aria", "compiler", "3.8.15")

        object Core : AndroidDependency("com.arialyy.aria", "core", "3.8.15")

        object Ftp : AndroidDependency("com.arialyy.aria", "ftpComponent", "3.8.15")

        object M3u8 : AndroidDependency("com.arialyy.aria", "m3u8Component", "3.8.15")

        object Sftp : AndroidDependency("com.arialyy.aria", "sftpComponent", "3.8.15")
    }

    /**
     * RecyclerView适配库
     * https://github.com/airbnb/epoxy
     */
    object Epoxy {
        object Compiler :
            AndroidDependency("com.airbnb.android", "epoxy-processor", "4.2.0")

        object Core : AndroidDependency("com.airbnb.android", "epoxy", "4.2.0")

        object Glide : AndroidDependency(
            "com.airbnb.android",
            "epoxy-glide-preloading",
            "4.2.0"
        )
    }

    /**
     * https://developer.android.com/jetpack/androidx/releases/fragment
     */
    object Fragment {
        object Core : AndroidDependency("androidx.fragment", "fragment", "1.3.0-beta01")

        object Test : AndroidDependency(
            "androidx.fragment",
            "fragment-testing",
            "1.3.0-beta01"
        )
    }

    /**
     * 图片加载
     * https://github.com/bumptech/glide
     */
    object Glide {
        object Annotation : AndroidDependency(
            "com.github.bumptech.glide",
            "annotations",
            "4.11.0"
        )

        object Compiler :
            AndroidDependency("com.github.bumptech.glide", "compiler", "4.11.0")

        object Core : AndroidDependency("com.github.bumptech.glide", "glide", "4.11.0")

        object OkHttp : AndroidDependency(
            "com.github.bumptech.glide",
            "okhttp3-integration",
            "4.11.0"
        )

        /**
         * 图片变换库
         * https://github.com/wasabeef/glide-transformations
         */
        object Transformations : AndroidDependency(
            "jp.wasabeef",
            "glide-transformations",
            "4.3.0"
        )

        /**
         * Gpu处理图片效果
         * https://github.com/wasabeef/glide-transformations
         */
        object GpuImage : AndroidDependency(
            "jp.co.cyberagent.android",
            "gpuimage",
            "2.1.0"
        )
    }

    /**
     * 依赖注入库
     * https://github.com/InsertKoinIO/koin
     */
    object Koin {
        object Core : AndroidDependency("org.koin", "koin-core", "2.2.0")

        object Ext : AndroidDependency("org.koin", "koin-androidx-ext", "2.2.0")

        object Scope : AndroidDependency("org.koin", "koin-androidx-scope", "2.2.0")

        object Test : AndroidDependency("org.koin", "koin-test", "2.2.0")

        object ViewModel : AndroidDependency(
            "org.koin",
            "koin-androidx-viewmodel",
            "2.2.0"
        )
    }

    /**
     * https://github.com/JetBrains/kotlin
     */
    object Kotlin {
        object Reflect : AndroidDependency(
            "org.jetbrains.kotlin",
            "kotlin-reflect",
            "1.4.20"
        )

        object Stdlib : AndroidDependency(
            "org.jetbrains.kotlin",
            "kotlin-stdlib",
            "1.4.20"
        )
    }

    /**
     * https://developer.android.com/jetpack/androidx/releases/lifecycle
     */
    object Lifecycle {
        object Common : AndroidDependency(
            "androidx.lifecycle",
            "lifecycle-common",
            "2.3.0-beta01"
        )

        object LiveData : AndroidDependency(
            "androidx.lifecycle",
            "lifecycle-livedata-ktx",
            "2.3.0-beta01"
        )

        object Process : AndroidDependency(
            "androidx.lifecycle",
            "lifecycle-process",
            "2.3.0-beta01"
        )

        object Runtime : AndroidDependency(
            "androidx.lifecycle",
            "lifecycle-runtime-ktx",
            "2.3.0-beta01"
        )

        object SavedState : AndroidDependency(
            "androidx.lifecycle",
            "lifecycle-viewmodel-savedstate",
            "2.3.0-beta01"
        )

        object Service : AndroidDependency(
            "androidx.lifecycle",
            "lifecycle-service",
            "2.3.0-beta01"
        )

        object ViewModel : AndroidDependency(
            "androidx.lifecycle",
            "lifecycle-viewmodel-ktx",
            "2.3.0-beta01"
        )
    }

    /**
     * json解析库
     * https://github.com/square/moshi
     */
    object MoShi {
        object Compiler : AndroidDependency(
            "com.squareup.moshi",
            "moshi-kotlin-codegen",
            "1.11.0"
        )

        object Core : AndroidDependency("com.squareup.moshi", "moshi", "1.11.0")
    }

    /**
     * https://github.com/square/okhttp
     */
    object OkHttp {
        object Core : AndroidDependency("com.squareup.okhttp3", "okhttp", "4.9.0")

        object Interceptor : AndroidDependency(
            "com.squareup.okhttp3",
            "logging-interceptor",
            "4.9.0"
        )

        object Mock : AndroidDependency("com.squareup.okhttp3", "mockwebserver", "4.9.0")
    }

    /**
     * https://github.com/airbnb/paris
     */
    object Paris {
        object Compiler : AndroidDependency(
            "com.airbnb.android",
            "paris-processor",
            "1.7.2"
        )

        object Core : AndroidDependency("com.airbnb.android", "paris", "1.7.2")
    }

    /**
     * 网络请求
     * https://github.com/square/retrofit
     */
    object Retrofit {
        object Core : AndroidDependency("com.squareup.retrofit2", "retrofit", "2.9.0")

        object MoShi : AndroidDependency(
            "com.squareup.retrofit2",
            "converter-moshi",
            "2.9.0"
        )
    }

    /**
     * Sqlite数据库
     * https://developer.android.com/jetpack/androidx/releases/room
     */
    object Room {
        object Compiler : AndroidDependency("androidx.room", "room-compiler", "2.2.5")

        object Core : AndroidDependency("androidx.room", "room-runtime", "2.2.5")

        object Ktx : AndroidDependency("androidx.room", "room-ktx", "2.2.5")

        object Test : AndroidDependency("androidx.room", "room-testing", "2.2.5")
    }

    /**
     * 任务管理器
     * https://developer.android.com/jetpack/androidx/releases/work
     */
    object WorkManager {
        object Core : AndroidDependency(
            "androidx.work",
            "work-runtime-ktx",
            "2.5.0-beta01"
        )

        object Test : AndroidDependency(
            "androidx.work",
            "work-testing",
            "2.5.0-beta01"
        )
    }

    object Test {
        /**
         * UI自动化测试
         * https://mvnrepository.com/artifact/androidx.test.espresso/espresso-core
         */
        object Espresso : AndroidDependency(
            "androidx.test.espresso",
            "espresso-core",
            "3.3.0"
        )

        /**
         * 单元测试
         * https://mvnrepository.com/artifact/junit/junit
         */
        object Junit : AndroidDependency("junit", "junit", "4.13.1")

        /**
         * 单元测试扩展
         * https://mvnrepository.com/artifact/androidx.test.ext/junit-ktx
         */
        object JunitExt : AndroidDependency("androidx.test.ext", "junit-ktx", "1.1.2")
    }
}
