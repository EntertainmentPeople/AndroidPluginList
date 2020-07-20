# 打包构建参数

1. ## 仓库配置
   
   1. ### project build.gradle.kts
   
        ```
        buildscript {
            dependencies {
                classpath("son.ysy.plugin:build:1.0.0")
            }
        }
        ```

   2. ### module build.gradle.kts

        ```
        plugins {
            id("son.ysy.plugin.build")
        }
        ```
   