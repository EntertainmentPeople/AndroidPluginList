# Android自写插件

1. ## 仓库地址
    
    `https://packages.aliyun.com/maven/repository/2013042-release-exUXVM`

   ### project build.gradle.kts

   ```
   buildscript {
      apply(from = file("mavenConfig.gradle.kts"))
      repositories {
         maven(url = extra.get("mavenUrl").toString()) {
            credentials {
                username = extra.get("mavenUserName").toString()
                password = extra.get("mavenPassword").toString()
            }
         }
      }
   }
   ```

2. ## 模块说明
   1. ### [dependencies](/plugin_dependencies/readme.md)
       - 三方依赖库版本整理

   2. ### [build](/plugin_build/readme.md)
       - 打包构建参数