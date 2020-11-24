# 三方依赖库版本整理

1. ## 仓库配置
   
   1. ### project build.gradle.kts
   
        ```
        buildscript {
            dependencies {
                classpath("son.ysy.plugin:dependencies:1.3.4")
            }
        }
        ```

2. ## 插件列表
   |                             引用                             |    最新版本    |       备注        |
   | :----------------------------------------------------------: | :------------: | :---------------: |
   | [Activity](https://developer.android.com/jetpack/androidx/releases/activity) |  1.2.0-beta01  |                   |
   |        [Alerter](https://github.com/Tapadoo/Alerter)         |     6.2.1      |    Alerter弹窗    |
   | [Anchors](https://github.com/YummyLau/Anchors/blob/master/README-zh.md) |     1.1.2      | app启动初始化管理 |
   |   [AndroidUtil](https://github.com/Blankj/AndroidUtilCode)   |     1.30.4     |   多功能工具包    |
   | [Appcompat](https://developer.android.com/jetpack/androidx/releases/appcompat) | 1.3.0-alpha02  |                   |
   | [Background](https://github.com/JavaNoober/BackgroundLibrary) |     1.6.5      |  背景生成工具库   |
   | [ColorKtx](https://github.com/JorgeCastilloPrz/AndroidColorX) |     0.2.0      |    颜色帮助库     |
   | [CoreKtx](https://developer.android.com/jetpack/androidx/releases/core) | 1.5.0-alpha05  |                   |
   |       [JodaTime](https://github.com/JodaOrg/joda-time)       |     2.10.8     |    时间处理库     |
   | [LeakCanary](https://square.github.io/leakcanary/getting_started/) |      2.5       |   内存泄露监控    |
   | [Mmkv](https://github.com/Tencent/MMKV/blob/master/readme_cn.md) |     1.2.4      |  持久KV数据存储   |
   |     [QrScanner](https://github.com/jenly1314/ZXingLite)      | 1.1.9-androidx |    二维码扫描     |
   | [UnPeekLiveData](https://github.com/KunMinX/UnPeek-LiveData) |  4.4.1-beta1   | 自动消失LiveData  |
   | [WeChat](https://developers.weixin.qq.com/doc/oplatform/Mobile_App/Resource_Center_Homepage.html) |     6.6.5      |    微信开发Sdk    |
   | [XCrash](https://github.com/iqiyi/xCrash/blob/master/README.zh-CN.md) |     3.0.0      |   奔溃日志收集    |
   |        [XPopup](https://github.com/li-xiaojun/XPopup)        |     2.2.5      |     弹窗框架      |
   
   | Chucker | com.github.chuckerteam.chucker | [网络请求监控](https://github.com/ChuckerTeam/chucker) |
   | :-----: | :----------------------------: | :----------------------------------------------------: |
   |  Debug  |            library             |                         3.3.0                          |
   | Release |         library-no-op          |                         3.3.0                          |
   
   | Component | com.github.xiaojinzi123.Component | [组件化实现方案](https://github.com/xiaojinzi123/Component) |
   | :-------: | :-------------------------------: | :---------------------------------------------------------: |
   |   Core    |          component-impl           |                   v1.8.3.5-androidx-java8                   |
   | Compiler  |        component-compiler         |                   v1.8.3.5-androidx-java8                   |
   |  Plugin   |         component-plugin          |                   v1.8.3.5-androidx-java8                   |
   
   | Coroutines |   org.jetbrains.kotlinx    | [协程](https://github.com/Kotlin/kotlinx.coroutines) |
   | :--------: | :------------------------: | :--------------------------------------------------: |
   |    Core    | kotlinx-coroutines-android |                        1.4.1                         |
   |    Test    |  kotlinx-coroutines-test   |                        1.4.1                         |
   
   | Download | com.arialyy.aria | [文件下载](https://github.com/AriaLyy/Aria) |
   | :------: | :--------------: | :-----------------------------------------: |
   |   Core   |       core       |                   3.8.15                    |
   | Compiler |     compiler     |                   3.8.15                    |
   |   Ftp    |   ftpComponent   |                   3.8.15                    |
   |   Sftp   |  sftpComponent   |                   3.8.15                    |
   |   M3u8   |  m3u8Component   |                   3.8.15                    |
   
   |  Epoxy   |   com.airbnb.android   | [RecyclerView适配库](https://github.com/airbnb/epoxy) |
   | :------: | :--------------------: | :---------------------------------------------------: |
   |   Core   |         epoxy          |                         4.1.0                         |
   | Compiler |    epoxy-processor     |                         4.1.0                         |
   |  Glide   | epoxy-glide-preloading |                         4.1.0                         |
   
   | Fragment | androidx.fragment | [Fragment](https://developer.android.com/jetpack/androidx/releases/fragment) |
   | :------: | :---------------: | :--------------------------------------------------------------------------: |
   |   Core   |     fragment      |                                 1.3.0-beta01                                 |
   |   Test   | fragment-testing  |                                 1.3.0-beta01                                 |
   
   |           Glide            |     com.github.bumptech.glide     |         [Glide](https://github.com/bumptech/glide)         |
   | :------------------------: | :-------------------------------: | :--------------------------------------------------------: |
   |            Core            |               glide               |                           4.11.0                           |
   |          Compiler          |             compiler              |                           4.11.0                           |
   |           OkHttp           |        okhttp3-integration        |                           4.11.0                           |
   |         Annotation         |            annotations            |                           4.11.0                           |
   | Transformation(图片转换库) | jp.wasabeef:glide-transformations | [4.3.0](https://github.com/wasabeef/glide-transformations) |
   
   |   Koin    |        org.koin         | [依赖注入库](https://github.com/InsertKoinIO/koin) |
   | :-------: | :---------------------: | :------------------------------------------------: |
   |   Core    |        koin-core        |                       2.2.0                        |
   |   Scope   |   koin-androidx-scope   |                       2.2.0                        |
   | ViewModel | koin-androidx-viewmodel |                       2.2.0                        |
   |    Ext    |    koin-androidx-ext    |                       2.2.0                        |
   |   Test    |        koin-test        |                       2.2.0                        |
   
   | Kotlin  | org.jetbrains.kotlin | [Kotlin](https://github.com/JetBrains/kotlin) |
   | :-----: | :------------------: | :-------------------------------------------: |
   | Stdlib  |    kotlin-stdlib     |                    1.4.20                     |
   | Reflect |    kotlin-reflect    |                    1.4.20                     |
   
   | Lifecycle  |       androidx.lifecycle       | [Lifecycle](https://developer.android.com/jetpack/androidx/releases/lifecycle) |
   | :--------: | :----------------------------: | :----------------------------------------------------------------------------: |
   | ViewModel  |    lifecycle-viewmodel-ktx     |                                  2.3.0-beta01                                  |
   |   Common   |        lifecycle-common        |                                  2.3.0-beta01                                  |
   |  LiveData  |     lifecycle-livedata-ktx     |                                  2.3.0-beta01                                  |
   |  Runtime   |     lifecycle-runtime-ktx      |                                  2.3.0-beta01                                  |
   | SavedState | lifecycle-viewmodel-savedstate |                                  2.3.0-beta01                                  |
   |  Process   |       lifecycle-process        |                                  2.3.0-beta01                                  |
   |  Service   |       lifecycle-service        |                                  2.3.0-beta01                                  |
   
   |  MoShi   |  com.squareup.moshi  | [json解析库](https://github.com/square/moshi) |
   | :------: | :------------------: | :-------------------------------------------: |
   |   Core   |        moshi         |                    1.11.0                     |
   | Compiler | moshi-kotlin-codegen |                    1.11.0                     |
   
   |   OkHttp    | com.squareup.okhttp3 | [OkHttp](https://github.com/square/okhttp) |
   | :---------: | :------------------: | :----------------------------------------: |
   |    Core     |        okhttp        |                   4.9.0                    |
   |    Mock     |    mockwebserver     |                   4.9.0                    |
   | Interceptor | logging-interceptor  |                   4.9.0                    |
   
   |  Paris   | com.airbnb.android | [Paris](https://github.com/airbnb/paris) |
   | :------: | :----------------: | :--------------------------------------: |
   |   Core   |       paris        |                  1.7.1                   |
   | Compiler |  paris-processor   |                  1.7.1                   |
   
   | Retrofit | com.squareup.retrofit2 | [网络请求](https://github.com/square/retrofit) |
   | :------: | :--------------------: | :--------------------------------------------: |
   |   Core   |        retrofit        |                     2.9.0                      |
   |  MoShi   |    converter-moshi     |                     2.9.0                      |
   
   |   Room   | androidx.room | [sqlite数据库](https://developer.android.com/jetpack/androidx/releases/room) |
   | :------: | :-----------: | :--------------------------------------------------------------------------: |
   |   Core   | room-runtime  |                                    2.2.5                                     |
   |   Ktx    |   room-ktx    |                                    2.2.5                                     |
   | Compiler | room-compiler |                                    2.2.5                                     |
   |   Test   | room-testing  |                                    2.2.5                                     |
   
   | 测试组件 |         group          |    module     |    版本    |     备注     |
   | :------: | :--------------------: | :-----------: | :--------: | :----------: |
   |  Junit   |         junit          |     junit     |   4.13.1   |   单元测试   |
   | JunitExt |   androidx.test.ext    |     junit     | 1.1.2-rc02 |              |
   | Espresso | androidx.test.espresso | espresso-core | 3.3.0-rc02 | 自动化UI测试 |
   
   |        引用        |            group            |        module         |                                            版本                                             |     备注     |
   | :----------------: | :-------------------------: | :-------------------: | :-----------------------------------------------------------------------------------------: | :----------: |
   |      AgentWeb      |      com.just.agentweb      |       agentweb        |                        [4.1.4](https://github.com/Justson/AgentWeb)                         |   WebView    |
   |     BannerView     |    com.github.xiaohaibin    |        XBanner        |           [androidx_v1.1.0](https://github.com/xiaohaibin/XBanner/tree/androidX)            |   轮播控件   |
   |      BlurView      |       com.eightbitlab       |       blurview        |                        [1.6.5](https://github.com/Dimezis/BlurView)                         |   高斯模糊   |
   |  BottomNavigation  |   com.ashokvarma.android    | bottom-navigation-bar |                  [2.2.0](https://github.com/Ashok-Varma/BottomNavigation)                   |   底部导航   |
   |  ConstraintLayout  |  androidx.constraintlayout  |   constraintlayout    |      [2.0.4](https://developer.android.com/jetpack/androidx/releases/constraintlayout)      |   约束布局   |
   |      FlexBox       |     com.google.android      |        flexbox        |                      [2.0.1](https://github.com/google/flexbox-layout)                      |   流式布局   |
   |     LottieView     |     com.airbnb.android      |        lottie         |                      [3.4.4](https://github.com/airbnb/lottie-android)                      |   动画框架   |
   |    MarqueeView     |       com.sunfusheng        |      MarqueeView      |                     [1.4.1](https://github.com/sunfusheng/MarqueeView)                      |  跑马灯控件  |
   |      Material      | com.google.android.material |       material        |     [1.3.0-alpha03](https://github.com/material-components/material-components-android)     |              |
   |    RecyclerView    |    androidx.recyclerview    |     recyclerview      |    [1.2.0-alpha06](https://developer.android.com/jetpack/androidx/releases/recyclerview)    |              |
   |    ShadowLayout    |    com.github.lihangleo2    |     ShadowLayout      |                     [3.1.2](https://github.com/lihangleo2/ShadowLayout)                     |   阴影控件   |
   | SwipeRefreshLayout | androidx.swiperefreshlayout |  swiperefreshlayout   | [1.2.0-alpha01](https://developer.android.com/jetpack/androidx/releases/swiperefreshlayout) | 下拉刷新控件 |
   |     ViewPager2     |     androidx.viewpager2     |      viewpager2       |     [1.1.0-alpha01](https://developer.android.com/jetpack/androidx/releases/viewpager2)     |              |
   
   | WorkManager |  androidx.work   | [任务管理器](https://developer.android.com/jetpack/androidx/releases/work) |
   | :---------: | :--------------: | :------------------------------------------------------------------------: |
   |    Core     | work-runtime-ktx |                                2.5.0-beta01                                |
   |    Test     |   work-testing   |                                2.5.0-beta01                                |
   