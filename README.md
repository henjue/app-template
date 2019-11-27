# app 空架子

本着多用官方少用第三方的原则

## 1、framework
开发语言：kotlin  
主框架：jetpack全家桶,dagger2  
主要第三方框架：gson,retrofit,rxjava  
项目主要架构：mvvm  
包说明：
```
xxx.xxx.xxx  //基础包(一把同applicationId)
        ├── common  //公共代码
        ├── db   //数据库相关
        ├── di   //dagger2 依赖注入配置
        ├── ext  //kotlin 扩展
        ├── network   //网络相关，如service,response,request等
        └── ui  //客户端主要业余逻辑代码(一级包按功能划分,二级包为MVVM)
            ├── common  //公共和基础
            │   ├── model
            │   ├── view
            │   └── vm
            └── main  //主模块
            │   ├── model
            │   ├── view
            │   └── vm
            └── user  //用户相关
                ├── model
                ├── view
                └── vm                
```
资源说明：
按照android官方规范通过资源目录后缀做样式，版本，屏幕等适配,如values-v19,values-v23等