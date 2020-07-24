# 三方依赖库版本整理

1. ## 仓库配置
   
   1. ### project build.gradle.kts
   
        ```
        buildscript {
            dependencies {
                classpath("son.ysy.plugin:dependencies:1.0.0")
            }
        }
        ```

   2. ### module build.gradle.kts

        ```
        plugins {
            id("son.ysy.plugin.dependencies")
        }
        ```
2. ## 插件列表
   1. AndroidX
      - [Appcompat](https://developer.android.com/jetpack/androidx/releases/appcompat)  
      - [CoreKtx](https://developer.android.com/jetpack/androidx/releases/core)
      - [AsyncInflater](https://developer.android.com/jetpack/androidx/releases/asynclayoutinflater)  
        异步加载布局

   2. [Component](https://github.com/xiaojinzi123/Component)  
        组件化实现方案

      - Core
      - Compiler
      - Plugin

   3. [Coroutines](https://github.com/Kotlin/kotlinx.coroutines)  
        kotlin协程

      - Core
      - Test

   4. [Epoxy](https://github.com/airbnb/epoxy)  
        RecyclerView适配库

      - Core
      - Compiler
      - Glide

   5. [Glide](https://github.com/bumptech/glide)  
        Glide图片加载

      - Core
      - Compiler
      - OkHttp
      - Annotation
      - [Transformation](https://github.com/wasabeef/glide-transformations)  
            图片转换库

   6. [MoShi](https://github.com/square/moshi)  
        json解析库

      - Core
      - Compiler

   7. [Kotlin](https://github.com/JetBrains/kotlin)
      - Stdlib
      - Reflect

   8. [Koin](https://github.com/InsertKoinIO/koin)  
        依赖注入库

      - Scope
      - ViewModel
      - Ext

   9. [Lifecycle](https://developer.android.com/jetpack/androidx/releases/lifecycle)
      - ViewModel
      - Common
      - LiveData
      - Runtime
      - SavedState
      - Process
      - Service

   10. [OkHttp](https://github.com/square/okhttp)
       - Core
       - Mock
       - Interceptor

   11. [Paris](https://github.com/airbnb/paris)
       - Core
       - Compiler

   12. [Retrofit](https://github.com/square/retrofit)
        网络请求

       - Core
       - MoShi

   13. [Room](https://developer.android.com/jetpack/androidx/releases/room)
        sqlite数据库

       - Core
       - Ktx
       - Compiler

   14. Test
       - Junit
       - JunitExt
       - Espresso

   15. View
       - [ViewPager2](https://developer.android.com/jetpack/androidx/releases/viewpager2)
       - [ConstraintLayout](https://developer.android.com/jetpack/androidx/releases/constraintlayout)  
            约束布局
       - [Recyclerview](https://developer.android.com/jetpack/androidx/releases/recyclerview)
       - [BottomNavigation](https://github.com/Ashok-Varma/BottomNavigation)  
            底部导航
       - [LottieView](https://github.com/airbnb/lottie-android)  
            动画框架
       - [BlurView](https://github.com/HokoFly/HokoBlur)  
            高斯模糊
       - [RealTimeBlurView](https://github.com/mmin18/RealtimeBlurView)  
            实时背景高斯模糊

   16. [XPopup](https://github.com/li-xiaojun/XPopup)  
        弹窗框架
       - Core

   17. [WorkerManager](https://developer.android.com/jetpack/androidx/releases/work)  
        任务管理器

   18. [AndroidUtil](https://github.com/Blankj/AndroidUtilCode)  
        多功能工具包

   19. [Anchors](https://github.com/YummyLau/Anchors/blob/master/README-zh.md)  
        app启动初始化管理
    
   20. [Mmkv](https://github.com/Tencent/MMKV/blob/master/readme_cn.md)  
        持久KV数据存储

   21. [ColorKtx](https://github.com/JorgeCastilloPrz/AndroidColorX)  
        颜色帮助库
    
   22. [Background](https://github.com/JavaNoober/BackgroundLibrary)  
        背景生成工具库
    
   23. [QrScanner](https://github.com/jenly1314/ZXingLite)  
        二维码扫描

   24. [JodaTime](https://github.com/JodaOrg/joda-time)  
        时间处理库
   
   25. [UnPeekLiveData](https://github.com/KunMinX/UnPeek-LiveData)  
        自动消失LiveData

   26. [LeakCanary](https://square.github.io/leakcanary/getting_started/)
        内存泄露监控