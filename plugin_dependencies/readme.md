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
      - Appcompat  
      - CoreKtx
      - AsyncInflater  
        异步加载布局

   2. Component  
        组件化实现方案

      - Core
      - Compiler
      - Plugin

   3. Coroutines  
        kotlin协程

      - Core
      - Test

   4. Epoxy  
        RecyclerView适配库

      - Core
      - Compiler
      - Glide

   5. Glide  
        Glide图片加载

      - Core
      - Compiler
      - OkHttp
      - Annotation
      - Transformation  
            图片转换库

   6. MoShi  
        json解析库

      - Core
      - Compiler

   7. Kotlin
      - Stdlib
      - Reflect

   8. Koin  
        依赖注入库

      - Scope
      - ViewModel
      - Ext

   9. Lifecycle
      - ViewModel
      - Common
      - LiveData
      - Runtime
      - SavedState
      - Process
      - Service

   10. OkHttp
       - Core
       - Mock
       - Interceptor

   11. Paris
       - Core
       - Compiler

   12. Retrofit
        网络请求

       - Core
       - MoShi
   13. Room
        sqlite数据库

       - Core
       - Ktx
       - Compiler

   14. Test
       - Junit
       - JunitExt
       - Espresso

   15. View
       - ViewPager2
       - ConstraintLayout  
            约束布局
       - Recyclerview
       - BottomNavigation
            底部导航
       - LottieView
            动画框架
       - BlurView
            高斯模糊
       - RealTimeBlurView
            实时背景高斯模糊

   16. XPopup  
        弹窗框架
       - Core
   
   17. AndroidUtil  
        多功能工具包

   18. Anchors  
        app启动初始化管理
    
   19. Mmkv  
        持久KV数据存储

   20. ColorKtx  
        颜色帮助库
    
   21. Background  
        背景生成工具库
    
   22. QrScanner  
        二维码扫描

   23. JodaTime  
        时间处理库
   
   24. UnPeekLiveData  
        自动消失LiveData