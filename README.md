- [一 硅谷课堂](#一-硅谷课堂)
  - [项目概述](#项目概述)
  - [前置知识储备](#前置知识储备)
  - [硅谷课堂功能架构图](#硅谷课堂功能架构图)
  - [项目技术介绍](#项目技术介绍)
  - [产品图](#产品图)

- [二 `MyBatisPlus`](#二-mybatisplus)
  - [1 `MyBatisPlus` 简介](#1-mybatisplus-简介)
    - [1.1 概述](#11-概述)
  - [1.2 特性](#12-特性)
  - [2 `MyBatisPlus` 入门](#2-mybatisplus-入门)
    - [2.1 创建测试数据库和表](#21-创建测试数据库和表)
    - [2.2 创建项目和添加依赖](#22-创建项目和添加依赖)
      - [2.2.1 前置目录](#221-前置目录)
      - [2.2.2 创建项目模块](#222-创建项目模块)
      - [2.2.3 项目引入依赖](#223-项目引入依赖)
    - [2.3 配置文件](#23-配置文件)
    - [2.4 编写代码](#24-编写代码)
  - [3 MyBatisPlus 实现 CRUD 操作](#3-mybatisplus-实现-crud-操作)
    - [3.1 插入操作](#31-插入操作)
    - [3.2 主键策略](#32-主键策略)
    - [3.3 根据 id 更新操作](#33-根据-id-更新操作)
    - [3.4 分页查询](#34-分页查询)
    - [3.5 根据 `id` 删除记录](#35-根据-id-删除记录)
    - [3.6 批量删除](#36-批量删除)
    - [3.7 逻辑删除（更新/修改数据）](#37-逻辑删除更新修改数据)
      - [3.7.1 数据库中添加 `deleted` 字段](#371-数据库中添加-deleted-字段)
      - [3.7.2 实体类添加 `deleted` 属性](#372-实体类添加-deleted-属性)
      - [3.7.3 `application.yml` 配置删除标志](#373-applicationyml-配置删除标志)
      - [3.7.4 测试](#374-测试)
  - [4 `MyBatisPlus` 条件构造器](#4-mybatisplus-条件构造器)
    - [4.1 `AbstractWrapper`](#41-abstractwrapper)
    - [4.2 `QueryWrapper` 使用](#42-querywrapper-使用)
    - [4.3 `LambdaQueryWrapper` 使用](#43-lambdaquerywrapper-使用)
  - [5 `MybatisPuls` 对 `service` 的封装](#5-mybatispuls-对-service-的封装)
    - [5.1 新建 `UserService` 接口](#51-新建-userservice-接口)
    - [5.2 新建 `UserServiceImpl`](#52-新建-userserviceimpl)
    - [5.3 测试: 新建 `ServiceTestsDemo` 类](#53-测试-新建-servicetestsdemo-类)

- [三 开发讲师管理接口](#三-开发讲师管理接口)
  - [1 前后端分离开发](#1-前后端分离开发)
  - [2 搭建后端环境 - 基于 `Maven` 聚合工程](#2-搭建后端环境---基于-maven-聚合工程)
    - [2.1 创建数据库和表](#21-创建数据库和表)
    - [2.2 `Maven` 聚合工程](#22-maven-聚合工程)
      - [2.2.1 新建父工程 `ggkt_parent`](#221-新建父工程-ggkt_parent)
      - [2.2.2 新建子模块 `model`](#222-新建子模块-model)
      - [2.2.3 新建子模块 `service`](#223-新建子模块-service)
      - [2.2.4 新建子模块 `service_vod`](#224-新建子模块-service_vod)
      - [2.2.5 新建子模块 `common`](#225-新建子模块-common)
      - [2.2.6 新建子模块 `service_utils`](#226-新建子模块-service_utils)
  - [3 `service_vod` 工程中使用 `mp` 的代码生成器](#3-service_vod-工程中使用-mp-的代码生成器)
    - [3.1 追加依赖](#31-追加依赖)
    - [3.2 新建 `CodeGet` 类](#32-新建-codeget-类)
  - [4 接口](#4-接口)
    - [4.1 查询所有教师接口, 修改 `TeacherController`](#41-查询所有教师接口-修改-teachercontroller)
    - [4.2 逻辑删除教师接口, 修改 `TeacherController`](#42-逻辑删除教师接口-修改-teachercontroller)
  - [5 配置 `Swagger2` 生成 `API` 接口文档](#5-配置-swagger2-生成-api-接口文档)
    - [5.1 概述](#51-概述)
    - [5.2 配置 `Swagger2`](#52-配置-swagger2)
      - [5.2.1 `service_utils` 工程中](#521-service_utils-工程中)
      - [5.2.2 `service` 工程中](#522-service-工程中)
      - [5.2.3 `service_vod` 工程中](#523-service_vod-工程中)
    - [5.3 使用 `Swagger2`](#53-使用-swagger2)
      - [5.3.1 可视化页面](#531-可视化页面)
      - [5.3.2 相关注解](#532-相关注解)
    - [5.4 使用注解](#54-使用注解)
  - [6 统一返回结果](#6-统一返回结果)
    - [6.1 规则](#61-规则)
    - [6.2 新建统一返回结果类 `Result`](#62-新建统一返回结果类-result)
    - [6.3 使用 `Result`, 修改 `TeacherController`](#63-使用-result-修改-teachercontroller)
  - [7 条件分页查询讲师接口](#7-条件分页查询讲师接口)
    - [7.1 配置`vodConfig`](#71-配置vodconfig)
    - [7.2 查询条件对象 `TeacherQueryVo`](#72-查询条件对象-teacherqueryvo)
    - [7.3 条件查询分页接口](#73-条件查询分页接口)
  - [8 添加讲师接口](#8-添加讲师接口)
  - [9 修改讲师接口](#9-修改讲师接口)
    - [9.1 根据 `id` 查询讲师接口](#91-根据-id-查询讲师接口)
  - [10 批量删除接口](#10-批量删除接口)
  - [11 统一异常处理](#11-统一异常处理)
    - [11.1 全局异常处理](#111-全局异常处理)
    - [11.2 特定异常处理](#112-特定异常处理)
    - [11.3 自定义异常处理](#113-自定义异常处理)
      - [11.3.1 自定义异常处理](#1131-自定义异常处理)
      - [11.3.2 新建自定义异常类 `GgktException`](#1132-新建自定义异常类-ggktexception)
      - [11.3.3 测试](#1133-测试)

- [四 前端基础知识](#四-前端基础知识)
  - [1 开发工具和 `ES6`](#1-开发工具和-es6)
    - [1.1 下载](#11-下载)
    - [1.2 使用 `VS Code`](#12-使用-vs-code)
      - [1.2.2 插件安装](#122-插件安装)
      - [1.2.3 工作区](#123-工作区)
      - [1.2.4 新建文件](#124-新建文件)
      - [1.2.5 浏览器访问](#125-浏览器访问)
      - [1.2.6 自动保存](#126-自动保存)
    - [1.3 `ES6` 语法](#13-es6-语法)
      - [1.3.1 `let` 声明变量](#131-let-声明变量)
      - [1.3.2 `const` 声明常量（只读变量）](#132-const-声明常量只读变量)
      - [1.3.3 03-解构赋值](#133-03-解构赋值)
      - [1.3.4 04-模板字符串](#134-04-模板字符串)
      - [1.3.5 05-方法简写](#135-05-方法简写)
      - [1.3.6  06-对象拓展运算符](#136--06-对象拓展运算符)
      - [1.3.7 07-箭头函数](#137-07-箭头函数)
  - [2 `Vue`](#2-vue)
    - [2.1 `Vue.js` 是什么](#21-vuejs-是什么)
    - [2.2 初始化 `Vue.js`](#22-初始化-vuejs)
      - [!img](#)
    - [2.3 配置代码片段](#23-配置代码片段)
    - [2.4 `Vue` 指令](#24-vue-指令)
      - [2.4.1 `03-v-bind`](#241-03-v-bind)
      - [2.4.2 `04-v-model`](#242-04-v-model)
      - [2.4.3 `05-v-on`](#243-05-v-on)
      - [2.4.4 `06-vue-if`](#244-06-vue-if)
      - [2.4.5 `07-v-for`](#245-07-v-for)
      - [2.4.6 08-生命周期](#246-08-生命周期)
      - [2.4.7 09-组件](#247-09-组件)
      - [2.4.8 10-路由](#248-10-路由)
      - [2.4.9 `11-axios`](#249-11-axios)
    - [2.5 `element-ui`](#25-element-ui)
  - [3 `Node.js`](#3-nodejs)
    - [3.1 什么是 `Node.js`](#31-什么是-nodejs)
    - [3.2 `Node.js` 安装](#32-nodejs-安装)
      - [3.2.1 下载](#321-下载)
    - [3.3 入门](#33-入门)
  - [4 `NPM`](#4-npm)
    - [4.1 什么是 `NPM`](#41-什么是-npm)
    - [4.2 `NPM` 工具的安装位置](#42-npm-工具的安装位置)
    - [4.3 使用 `NPM`](#43-使用-npm)
    - [4.4 `NPM` 镜像](#44-npm-镜像)
    - [4.5 使用 `npm install` 命令](#45-使用-npm-install-命令)
    - [4.6 其他命令](#46-其他命令)
  - [5 模块化开发](#5-模块化开发)
    - [5.1 `ES5` 写法](#51-es5-写法)
    - [5.2 `ES6` 写法](#52-es6-写法)
    - [5.3 `ES6` 转 `ES5`](#53-es6-转-es5)
      - [5.3.1 安装 `Babel`](#531-安装-babel)
      - [5.3.2 安装 `Babel` 报错 `Error: EACCES: permission denied`](#532-安装-babel-报错-error-eacces-permission-denied)
      - [5.3.3 配置](#533-配置)
      - [5.3.4 安装转码器](#534-安装转码器)
    - [5.4 `ES6` 第二种写法](#54-es6-第二种写法)

- [五 讲师管理模块前端](#五-讲师管理模块前端)
  - [1  `vue-admin-template` 模板](#1--vue-admin-template-模板)
  - [2 搭建环境](#2-搭建环境)
  - [3 用户登录退出](#3-用户登录退出)
    - [3.1 请求及数据](#31-请求及数据)
    - [3.2 后台登录代码](#32-后台登录代码)
      - [3.2.1 新建 `UserLoginController`](#321-新建-userlogincontroller)
      - [3.2.2 修改 `Result` 默认成功状态码为 `20000`， 失败 `20001`](#322-修改-result-默认成功状态码为-20000-失败-20001)
      - [3.2.3 修改前端请求路径](#323-修改前端请求路径)
      - [3.2.4 修改前端请求接口](#324-修改前端请求接口)
      - [3.2.5 测试](#325-测试)
      - [3.2.6 退出](#326-退出)
  - [4 安装插件`ESLint`](#4-安装插件eslint)
  - [5 讲师前端列表功能](#5-讲师前端列表功能)
    - [5.1 添加讲师路由](#51-添加讲师路由)
    - [5.2 新建路由对应的页面](#52-新建路由对应的页面)
      - [5.2.1 `form`](#521-form)
      - [5.2.2 `list`](#522-list)
    - [5.3 讲师分页列表 `list.vue`](#53-讲师分页列表-listvue)
      - [5.3.1 新建请求接口文件 `teacher.js`](#531-新建请求接口文件-teacherjs)
      - [5.3.2 调用请求接口获取并显示数据 `list.vue`](#532-调用请求接口获取并显示数据-listvue)
    - [5.4 删除讲师](#54-删除讲师)
      - [5.4.1 API](#541-api)
      - [5.4.2 方法](#542-方法)
    - [5.5 添加讲师](#55-添加讲师)
      - [5.5.1 API](#551-api)
      - [](#)
      - [5.5.2 `form` 表单](#552-form-表单)
    - [5.6 修改讲师](#56-修改讲师)
      - [5.6.1 API](#561-api)
      - [5.6.2 路由](#562-路由)
      - [5.6.3 `from.vue` 的修改 - 数据回显](#563-fromvue-的修改---数据回显)
      - [5.6.4 `from.vue` 的修改 - 修改功能](#564-fromvue-的修改---修改功能)
    - [5.7 批量删除](#57-批量删除)
      - [5.7.1 API](#571-api)
      - [5.7.2 代码](#572-代码)
  - [后台项目打包问题](#后台项目打包问题)
    - [追加依赖](#追加依赖)

- [六 整合腾讯云对象存储](#六-整合腾讯云对象存储)
    - [1 腾讯云对象存储 `COS`](#1-腾讯云对象存储-cos)
        - [1.1 开通 `COS`](#11-开通-cos)
        - [1.2 创建存储桶](#12-创建存储桶)
        - [1.3 访问管理](#13-访问管理)
        - [1.4 秘钥](#14-秘钥)
        - [1.5 `SDK`](#15-sdk)
        - [1.6 测试上传](#16-测试上传)
    - [2 `service_utils` 工程](#2-service_utils-工程)
        - [2.1 依赖](#21-依赖)
        - [2.2 新建工具 `GgktUtil`](#22-新建工具-ggktutil)
    - [3 `service_vod` 工程](#3-service_vod-工程)
        - [3.1 新建 `CosProperties`](#31-新建-cosproperties)
        - [3.2 配置](#32-配置)
        - [3.3 测试上传](#33-测试上传)
        - [3.4 上传接口](#34-上传接口)
            - [3.4.1 新建 `FileUploadController`](#341-新建-fileuploadcontroller)
            - [3.4.2 新建 `FileService`](#342-新建-fileservice)
            - [2.4.3 新建 `FileServiceImpl`](#243-新建-fileserviceimpl)
            - [2.4.4 修改 `Result`](#244-修改-result)
    - [4 上传讲师头像](#4-上传讲师头像)
    - [4.1 代码](#41-代码)
    - [5 父组件样式作用到子组件](#5-父组件样式作用到子组件)
        - [5.1 `::v-deep` 修饰符](#51-v-deep-修饰符)
        - [5.2 `/deep/` 修饰符](#52-deep-修饰符)
        - [5.3 `>>>` 修饰符](#53--修饰符)
    - [修改](#修改)
        - [1.6 测试上传](#16-测试上传-1)
    - [2 `service_utils` 工程](#2-service_utils-工程-1)
        - [2.1 依赖](#21-依赖-1)
        - [2.2 新建工具 `GgktUtil`](#22-新建工具-ggktutil-1)
    - [3 `service_vod` 工程](#3-service_vod-工程-1)
        - [3.1 新建 `CosProperties`](#31-新建-cosproperties-1)
        - [3.2 配置](#32-配置-1)
        - [3.3 测试上传](#33-测试上传-1)
        - [3.4 上传接口](#34-上传接口-1)
            - [3.4.1 新建 `FileUploadController`](#341-新建-fileuploadcontroller-1)
            - [3.4.2 新建 `FileService`](#342-新建-fileservice-1)
            - [2.4.3 新建 `FileServiceImpl`](#243-新建-fileserviceimpl-1)
            - [2.4.4 修改 `Result`](#244-修改-result-1)
    - [4 上传讲师头像](#4-上传讲师头像-1)
    - [4.1 代码](#41-代码-1)
    - [5 父组件样式作用到子组件](#5-父组件样式作用到子组件-1)
        - [5.1 `::v-deep` 修饰符](#51-v-deep-修饰符-1)
        - [5.2 `/deep/` 修饰符](#52-deep-修饰符-1)
        - [5.3 `>>>` 修饰符](#53--修饰符-1)
    - [修改](#修改-1)

- [七 课堂分类管理模块](#七-课堂分类管理模块)
  - [1 课程分类管理模块需求](#1-课程分类管理模块需求)
    - [1.1 课程分类列表功能](#11-课程分类列表功能)
    - [1.2 课程分类导出功能](#12-课程分类导出功能)
    - [1.3 课程分类导入功能](#13-课程分类导入功能)
    - [1.4 `EasyExcel` 技术](#14-easyexcel-技术)
  - [2 接口](#2-接口)
    - [2.1 代码生成器](#21-代码生成器)
      - [2.1.1 控制器](#211-控制器)
      - [2.1.2 服务接口](#212-服务接口)
      - [2.1.3 服务实现类](#213-服务实现类)
      - [2.1.4 `Mapper` 接口](#214-mapper-接口)
  - [3 前端显示](#3-前端显示)
    - [3.1 第一步 路由](#31-第一步-路由)
    - [3.2 第二步 对应的页面](#32-第二步-对应的页面)
    - [3.3 第三步 API 请求接口](#33-第三步-api-请求接口)
  - [4 `EasyExcel`](#4-easyexcel)
    - [4.1 什么是 `EasyExcel`](#41-什么是-easyexcel)
    - [4.2 为什么使用 `EasyExcel`（特点）](#42-为什么使用-easyexcel特点)
      - [4.3 怎么使用 `EasyExcel`](#43-怎么使用-easyexcel)
      - [4.3.1 第一步 引入依赖](#431-第一步-引入依赖)
    - [4.4 写 `Excel`](#44-写-excel)
      - [4.4.1 第一步 创建 `excel` 对应的实体对象](#441-第一步-创建-excel-对应的实体对象)
      - [4.4.2 第二步 写入](#442-第二步-写入)
    - [4.5 读取 `Excel`](#45-读取-excel)
      - [4.5.1 JDK8+, 新建测试类](#451-jdk8-新建测试类)
  - [5 课程分类中的导出功能](#5-课程分类中的导出功能)
    - [5.1 实体类 `SubjectEeVo`](#51-实体类-subjecteevo)
    - [5.2 控制类](#52-控制类)
    - [5.3 服务接口](#53-服务接口)
    - [5.4 服务实现](#54-服务实现)
    - [5.5 前端](#55-前端)
  - [6 课程分类导入](#6-课程分类导入)
    - [6.1 控制类](#61-控制类)
    - [6.2 服务接口](#62-服务接口)
    - [6.3 服务实现](#63-服务实现)
    - [6.4 前端](#64-前端)
  - [知识点](#知识点)
    - [代码检查（默认开启）](#代码检查默认开启)

- [八 点播管理模块](#八-点播管理模块)
  - [1 点播管理模块需求](#1-点播管理模块需求)
  - [2 生成代码](#2-生成代码)
  - [3 课程列表](#3-课程列表)
    - [3.1 接口](#31-接口)
      - [3.1.1 控制类](#311-控制类)
      - [3.1.2 服务实现](#312-服务实现)
    - [3.2 前端](#32-前端)
      - [3.2.1 第一步 路由](#321-第一步-路由)
      - [3.2.2 第二步 创建 `List.vue`](#322-第二步-创建-listvue)
      - [3.2.3 第三步 API](#323-第三步-api)
  - [4 课程添加](#4-课程添加)
    - [4.1 接口](#41-接口)
      - [4.1.1 控制类 `CourseController`](#411-控制类-coursecontroller)
      - [4.1.2 服务实现](#412-服务实现)
    - [4.2 前端](#42-前端)
      - [4.2.1 `API`](#421-api)
      - [4.2.2 `List.vue` 关键代码](#422-listvue-关键代码)
      - [4.2.3 新建 `Form.vue` 页面](#423-新建-formvue-页面)
  - [5 修改课程基本信息](#5-修改课程基本信息)
    - [5.1 接口](#51-接口)
      - [5.1.1 控制层 `CourseController`](#511-控制层-coursecontroller)
      - [5.1.2 服务实现](#512-服务实现)
    - [5.2 前端](#52-前端)
      - [5.2.1 `API`](#521-api)
      - [5.2.2 修改 `Info.vue`](#522-修改-infovue)
  - [6 编辑课程大纲](#6-编辑课程大纲)
    - [6.1 章节接口](#61-章节接口)
      - [6.1.1 控制类 ChapterController](#611-控制类-chaptercontroller)
      - [6.2.2 服务实现](#622-服务实现)
    - [6.2 课程视频接口](#62-课程视频接口)
      - [6.2.1 控制类 `VideoController`](#621-控制类-videocontroller)
    - [6.3 前端](#63-前端)
      - [6.3.1 `API`](#631-api)
      - [6.3.2 `Chapter.vue`](#632-chaptervue)
  - [7 发布课程](#7-发布课程)
    - [7.1 接口](#71-接口)
      - [7.1.1 控制类 `CourseController`](#711-控制类-coursecontroller)
      - [7.1.2 服务实现](#712-服务实现)
      - [7.1.3 `CourseMapper`](#713-coursemapper)
      - [7.1.4 `CourseMapper.xml`](#714-coursemapperxml)
    - [7.2 `service_vod` 追加依赖](#72-service_vod-追加依赖)
    - [7.3 配置](#73-配置)
    - [7.4 前端](#74-前端)
      - [7.4.1 `API`](#741-api)
      - [7.4.2 `Publish.vue`](#742-publishvue)
  - [8 课程删除功能](#8-课程删除功能)
    - [8.1 接口](#81-接口)
      - [8.1.1 控制类](#811-控制类)
      - [8.1.2 服务实现](#812-服务实现)
    - [8.2 前端](#82-前端)
      - [8.2.1 `API`](#821-api)
      - [8.2.2 追加代码 `course/List.vue`](#822-追加代码-courselistvue)
  - [9 课程统计](#9-课程统计)
    - [9.1 生成代码](#91-生成代码)
      - [](#)
    - [9.2 接口](#92-接口)
      - [9.2.1 控制类](#921-控制类)
      - [9.2.2 服务实现](#922-服务实现)
      - [9.2.3 `Mapper` 接口](#923-mapper-接口)
      - [9.2.4 `Mapper.xml`](#924-mapperxml)
    - [9.3 前端](#93-前端)
      - [9.3.1 安装 `echarts` 插件](#931-安装-echarts-插件)
      - [9.3.2 `API`](#932-api)
      - [9.3.3 `Chart.vue`](#933-chartvue)

- [八-1 腾讯云视频点播](#八-1-腾讯云视频点播)
  - [1 腾讯云点播介绍](#1-腾讯云点播介绍)
    - [1.1 开通`云点播`服务](#11-开通云点播服务)
    - [1.2 管理控制台](#12-管理控制台)
    - [1.3 上传视频](#13-上传视频)
  - [2 使用`云点播`](#2-使用云点播)
    - [2.1 `Java SDK`](#21-java-sdk)
    - [2.2 示例 - 上传视频, 指定任务流](#22-示例---上传视频-指定任务流)
    - [2.3 示例 - 删除视频](#23-示例---删除视频)
    - [2.4 客户端上传](#24-客户端上传)
      - [2.4.1 `Java` 签名示例](#241-java-签名示例)
    - [2.5 `Web` 端上传示例](#25-web-端上传示例)
  - [3 `service_vod` 工程使用`云点播`上传、删除视频](#3-service_vod-工程使用云点播上传删除视频)
    - [3.1 引入依赖](#31-引入依赖)
    - [3.2 接口](#32-接口)
      - [3.2.1 工具类](#321-工具类)
      - [3.2.2 控制类](#322-控制类)
      - [3.2.3 服务实现类](#323-服务实现类)
    - [3.3 前端](#33-前端)
      - [3.3.1 `API`](#331-api)
      - [3.3.2 修改 `Form.vue`](#332-修改-formvue)
  - [4 删除课程、章节、小节](#4-删除课程章节小节)
    - [4.1删除课程和删除小节](#41删除课程和删除小节)
      - [4.1.1 控制类 `VideoController`](#411-控制类-videocontroller)
      - [4.1.2 服务实现](#412-服务实现)
    - [4.2 删除章节](#42-删除章节)
      - [4.2.1 控制类 `ChapterController`](#421-控制类-chaptercontroller)
      - [4.2.2 服务实现](#422-服务实现)
      - [4.2.3 `VideoServiceImpl`](#423-videoserviceimpl)

- [九 整合注册中心和网关](#九-整合注册中心和网关)
    - [1 `Spring Cloud` 相关概念](#1-spring-cloud-相关概念)
        - [1.1、什么是 `Spring Cloud`](#11什么是-spring-cloud)
        - [1.2 `Spring Cloud` 和 `Spring Boot` 关系](#12-spring-cloud-和-spring-boot-关系)
        - [1.3 `Spring Cloud` 相关基础服务组件](#13-spring-cloud-相关基础服务组件)
    - [2 搭建 `Nacos` 服务](#2-搭建-nacos-服务)
        - [2.1 `Nacos` 概述](#21-nacos-概述)
            - [2.1.1 基本概念](#211-基本概念)
            - [2.1.2 常见的注册中心](#212-常见的注册中心)
            - [2.1.3`Nacos` 结构图](#213nacos-结构图)
        - [2.2 `Nacos`下载和安装](#22-nacos下载和安装)
            - [2.2.1 下载地址和版本](#221-下载地址和版本)
            - [2.2.2 启动 `Nacos` 服务](#222-启动-nacos-服务)
            - [`**Linux**`/`**Unix**`/`**Mac**`](#linuxunixmac)
        - [2.3 `Nocas` 服务注册](#23-nocas-服务注册)
            - [2.3.1 追加依赖 `service`](#231-追加依赖-service)
            - [2.3.2 配置 `service_vod`](#232-配置-service_vod)
            - [2.3.3 开启 `Nacos`](#233-开启-nacos)
    - [3 整合 `Spring Cloud GateWay` 网关](#3-整合-spring-cloud-gateway-网关)
        - [3.1 网关基本概念](#31-网关基本概念)
            - [3.1.1 `Gateway` 概述](#311-gateway-概述)
            - [3.1.2 `Gateway` 核心概念](#312-gateway-核心概念)
        - [3.2 使用网关 `gateway`](#32-使用网关-gateway)
            - [3.2.1 在 `ggkt_parent` 下创建子模块 `service_gateway`](#321-在-ggkt_parent-下创建子模块-service_gateway)
            - [3.2.2 依赖](#322-依赖)
            - [3.2.3 创建启动类](#323-创建启动类)
            - [3.2.4 配置文件 `application.yml`](#324-配置文件-applicationyml)
            - [3.2.5 创建测试类](#325-创建测试类)
        - [3.3 网关解决跨域问题](#33-网关解决跨域问题)
            - [3.3.1 跨域概述](#331-跨域概述)
            - [3.3.2 创建配置类 `CorsConfig`](#332-创建配置类-corsconfig)
        - [3.4 修改前端接口](#34-修改前端接口)
            - [2.3.2 配置 `service_vod`](#232-配置-service_vod-1)
            - [2.3.3 开启 `Nacos`](#233-开启-nacos-1)
    - [3 整合 `Spring Cloud GateWay` 网关](#3-整合-spring-cloud-gateway-网关-1)
        - [3.1 网关基本概念](#31-网关基本概念-1)
            - [3.1.1 `Gateway` 概述](#311-gateway-概述-1)
            - [3.1.2 `Gateway` 核心概念](#312-gateway-核心概念-1)
        - [3.2 使用网关 `gateway`](#32-使用网关-gateway-1)
            - [3.2.1 在 `ggkt_parent` 下创建子模块 `service_gateway`](#321-在-ggkt_parent-下创建子模块-service_gateway-1)
            - [3.2.2 依赖](#322-依赖-1)
            - [3.2.3 创建启动类](#323-创建启动类-1)
            - [3.2.4 配置文件 `application.yml`](#324-配置文件-applicationyml-1)
            - [3.2.5 创建测试类](#325-创建测试类-1)
        - [3.3 网关解决跨域问题](#33-网关解决跨域问题-1)
            - [3.3.1 跨域概述](#331-跨域概述-1)
            - [3.3.2 创建配置类 `CorsConfig`](#332-创建配置类-corsconfig-1)
        - [3.4 修改前端接口](#34-修改前端接口-1)

- [十 订单管理模块](#十-订单管理模块)
  - [1 环境准备](#1-环境准备)
    - [1.1 数据库表 `order_info`](#11-数据库表-order_info)
    - [1.2 创建订单模块](#12-创建订单模块)
    - [1.3 生成代码](#13-生成代码)
    - [1.4 创建启动类 `ServiceOrderApplication`](#14-创建启动类-serviceorderapplication)
    - [1.5 创建配置类 `application.yml`](#15-创建配置类-applicationyml)
    - [1.6 创建测试类 `OrderApplicationTest`](#16-创建测试类-orderapplicationtest)
    - [1.7 新建配置类 `MybatisPlusConfig`](#17-新建配置类-mybatisplusconfig)
  - [2 订单列表接口](#2-订单列表接口)
    - [2.1 控制类](#21-控制类)
    - [2.2 服务实现类](#22-服务实现类)
  - [3 网关配置新服务](#3-网关配置新服务)
  - [4 订单列表前端](#4-订单列表前端)
    - [4.1 `API`](#41-api)
    - [4.2 路由](#42-路由)
    - [4.3 创建对应页面](#43-创建对应页面)

- [十一 营销管理模块](#十一-营销管理模块)
  - [1 环境准备](#1-环境准备)
    - [1.1 数据库](#11-数据库)
    - [](#)
    - [1.2 创建工程模块 `service_activity`](#12-创建工程模块-service_activity)
    - [1.3 生成代码](#13-生成代码)
    - [1.4 新建启动类 `ServiceActivityApplication`](#14-新建启动类-serviceactivityapplication)
    - [1.5 新建配置文件 `application.yml`](#15-新建配置文件-applicationyml)
    - [1.6 新建测试文件 `ServiceActivityApplicationTest`](#16-新建测试文件-serviceactivityapplicationtest)
    - [1.7 新建 `MP` 配置文件](#17-新建-mp-配置文件)
    - [1.8 配置网关](#18-配置网关)
  - [2 优惠券接口](#2-优惠券接口)
    - [2.1 控制类](#21-控制类)
    - [2.2 服务实现类](#22-服务实现类)
  - [3 获取用户信息接口](#3-获取用户信息接口)
    - [3.1 环境准备](#31-环境准备)
      - [3.1.1 数据库](#311-数据库)
      - [3.1.2 创建工程模块 `service_user`](#312-创建工程模块-service_user)
      - [3.1.3 生成代码](#313-生成代码)
      - [3.1.4 新建启动类 `ServiceUserApplication`](#314-新建启动类-serviceuserapplication)
      - [3.1.5 新建配置文件 `application.yml`](#315-新建配置文件-applicationyml)
      - [3.1.6 新建测试文件 `ServiceActivityApplicationTest`](#316-新建测试文件-serviceactivityapplicationtest)
      - [3.1.7 新建 `MP` 配置文件](#317-新建-mp-配置文件)
      - [3.1.8 配置网关](#318-配置网关)
    - [3.2 接口](#32-接口)
      - [3.2.1 控制类](#321-控制类)
  - [4 创建模块定义远程接口](#4-创建模块定义远程接口)
    - [4.1 创建模块](#41-创建模块)
    - [4.2 `service_client` 依赖](#42-service_client-依赖)
    - [4.3 定义远程调用接口](#43-定义远程调用接口)
  - [5 `service_activity` 工程](#5-service_activity-工程)
    - [5.1 引入依赖](#51-引入依赖)
    - [5.2 启动类添加注解](#52-启动类添加注解)
    - [5.3 服务实现](#53-服务实现)
  - [6 优惠券前端](#6-优惠券前端)
    - [6.1 `API`](#61-api)
    - [6.2 路由](#62-路由)
    - [6.3 页面](#63-页面)
      - [6.3.1 List](#631-list)
      - [6.3.2 `Form.vue`](#632-formvue)
      - [6.3.3 `Show.vue`](#633-showvue)

- [十二 公众号菜单管理](#十二-公众号菜单管理)
  - [1 申请测试公众号](#1-申请测试公众号)
  - [2 需求分析](#2-需求分析)
    - [2.1 微信自定义菜单说明](#21-微信自定义菜单说明)
    - [2.2 硅谷课堂自定义菜单](#22-硅谷课堂自定义菜单)
    - [2.3 数据格式](#23-数据格式)
      - [2.3.1 数据库表](#231-数据库表)
    - [2.4 管理页面](#24-管理页面)
  - [3. 搭建菜单管理后端环境](#3-搭建菜单管理后端环境)
    - [3.1 创建模块 `service_wechat`](#31-创建模块-service_wechat)
    - [3.2 依赖](#32-依赖)
    - [3.3 生成代码](#33-生成代码)
    - [3.4 启动类](#34-启动类)
    - [3.5 配置文件 `application.yml`](#35-配置文件-applicationyml)
    - [3.6 测试类 `ServiceWechatApplicationTest`](#36-测试类-servicewechatapplicationtest)
    - [3.7 配置网关](#37-配置网关)
  - [4 菜单管理接口](#4-菜单管理接口)
    - [4.1 控制类](#41-控制类)
    - [4.2 服务实现类](#42-服务实现类)
  - [5 同步菜单（获取 `access_token`）](#5-同步菜单获取-access_token)
    - [5.1 接口调用请求说明](#51-接口调用请求说明)
    - [5.2 `service_wechat` 添加配置](#52-service_wechat-添加配置)
    - [5.3 添加依赖](#53-添加依赖)
    - [5.4 新建属性文件 `WxMpProperties`](#54-新建属性文件-wxmpproperties)
    - [5.5 新建微信配置类 `WxMpConfiguration`](#55-新建微信配置类-wxmpconfiguration)
    - [5.6 控制类](#56-控制类)
    - [5.7 服务实现类](#57-服务实现类)
  - [6 公众号菜单删除](#6-公众号菜单删除)
    - [6.1 控制类](#61-控制类)
    - [6.2 服务实现类](#62-服务实现类)
  - [7 前端代码](#7-前端代码)
    - [7.1 `API`](#71-api)
    - [7.2 路由](#72-路由)
    - [7.3 `List.vue`](#73-listvue)
  - [8 公众号同步菜单效果图](#8-公众号同步菜单效果图)

- [十三 公众号消息](#十三-公众号消息)
  - [1 公众号消息回复、自定义菜单回复、关注、取消关注](#1-公众号消息回复自定义菜单回复关注取消关注)
  - [1 消息接入](#1-消息接入)
    - [1.1 公众号服务器配置](#11-公众号服务器配置)
    - [1.2 验证来自微信服务器消息](#12-验证来自微信服务器消息)
      - [1.2.1 新建 `MessageController` <`service_wechat` 工程>](#121-新建-messagecontroller-service_wechat-工程)
      - [1.2.2 修改路由](#122-修改路由)
      - [1.2.3 `application.yml` 追加配置](#123-applicationyml-追加配置)
      - [1.2.4 追加代码 `token` 属性](#124-追加代码-token-属性)
      - [1.2.5 微信配置类中配置 `Token`](#125-微信配置类中配置-token)
    - [1.3 测试公众号连接服务器](#13-测试公众号连接服务器)
  - [2 回复图文消息（NEWS）和文本消息（TEXT）](#2-回复图文消息news和文本消息text)
    - [2.1 微信配置类中配置 `WxMpMessageRouter`](#21-微信配置类中配置-wxmpmessagerouter)
      - [2.1.1 新建日志类 `LogHandler`](#211-新建日志类-loghandler)
      - [2.1.2 新建消息回复类 `MsgHandler`](#212-新建消息回复类-msghandler)
      - [2.1.3 新建抽象类 `AbstractHandler`](#213-新建抽象类-abstracthandler)
      - [2.1.4 新建工具类 `JsonUtils`](#214-新建工具类-jsonutils)
      - [2.1.5 新建 `TextBuilder` 类](#215-新建-textbuilder-类)
      - [2.1.6 新建 `AbstractBuilder` 类](#216-新建-abstractbuilder-类)
    - [2.2 远程调用接口](#22-远程调用接口)
      - [2.2.1 `service_wechat`消息类, 远程调用 `service_vod`中的接口获取数据](#221-service_wechat消息类-远程调用-service_vod中的接口获取数据)
      - [2.2.2 查询课程回复信息 `MsgHandler`](#222-查询课程回复信息-msghandler)
    - [2.3 测试回复](#23-测试回复)
  - [3 接收事件推送](#3-接收事件推送)
    - [3.1 关注/取消关注事件](#31-关注取消关注事件)
      - [3.1.1 配置](#311-配置)
      - [3.1.2 新建关注处理类](#312-新建关注处理类)
      - [3.1.3 新建取消关注处理类](#313-新建取消关注处理类)
      - [3.1.4 测试取消关注](#314-测试取消关注)
      - [3.1.5 测试关注](#315-测试关注)
    - [3.2 自定义菜单事件](#32-自定义菜单事件)
      - [3.2.1 配置](#321-配置)
      - [3.2.2 新建自定义菜单事件处理类](#322-新建自定义菜单事件处理类)
      - [3.2.3 测试](#323-测试)
  - [4 公众号模板消息](#4-公众号模板消息)
    - [4.1 实现目标](#41-实现目标)
    - [4.2 模板消息实现](#42-模板消息实现)
    - [4.3 申请模板消息](#43-申请模板消息)
    - [4.4、添加模板消息](#44添加模板消息)
  - [5. 公众号测试号申请模板消息](#5-公众号测试号申请模板消息)
    - [5.1 新增测试模板](#51-新增测试模板)
    - [5.2 填写信息](#52-填写信息)
      - [5.2.1 下载模板示例](#521-下载模板示例)
      - [5.2.2 填写模板标题和模板内容](#522-填写模板标题和模板内容)
  - [6 模板消息接口](#6-模板消息接口)
    - [6.1 追加代码 `MessageController`](#61-追加代码-messagecontroller)
    - [6.2 新建服务类](#62-新建服务类)
    - [6.3 新建服务实现类](#63-新建服务实现类)
    - [6.4 新建属性配置类](#64-新建属性配置类)
    - [6.5 `application.yml` 配置](#65-applicationyml-配置)
    - [6.6 测试](#66-测试)
    - [6.7 公众号显示](#67-公众号显示)

- [十四 公众号授权](#十四-公众号授权)
    - [1 需求描述](#1-需求描述)
        - [1.1 思路](#11-思路)
            - [1.1.1 第三步 - 微信端授权显示](#111-第三步---微信端授权显示)
        - [1.2 微信提示错误信息 10003](#12-微信提示错误信息-10003)
    - [2 授权登录](#2-授权登录)
        - [2.1 配置授权回调授权](#21-配置授权回调授权)
            - [2.1.1 在公众号正式号配置](#211-在公众号正式号配置)
        - [2.2 部署公众号前端页面](#22-部署公众号前端页面)
        - [2.3 前端处理](#23-前端处理)
            - [2.3.1 全局处理授权登录, 处理登录页面: `/src/App.vue`](#231-全局处理授权登录-处理登录页面-srcappvue)
            - [2.3.2 前端代码示例](#232-前端代码示例)
    - [3 授权登录接口](#3-授权登录接口)
        - [3.1 `application.yml` 配置](#31-applicationyml-配置)
        - [3.2 `WxProperties` 属性配置类](#32-wxproperties-属性配置类)
        - [3.3 新建控制类 `WechatController`](#33-新建控制类-wechatcontroller)
        - [3.4 `service_wachet` 依赖](#34-service_wachet-依赖)
        - [3.5 远程接口](#35-远程接口)
        - [3.6 `service_user` 控制类](#36-service_user-控制类)
    - [4 使用 `token`](#4-使用-token)
        - [4.1 `JWT` 介绍](#41-jwt-介绍)
        - [4.2 `JWT` 的原理](#42-jwt-的原理)
            - [4.2.1 公共部分](#421-公共部分)
            - [4.2.2 私有部分](#422-私有部分)
            - [4.2.3 签名部分](#423-签名部分)
        - [4.3 整合 `JWT`](#43-整合-jwt)
            - [4.3.1 在 `service_utils` 模块添加依赖](#431-在-service_utils-模块添加依赖)
            - [4.3.2 新建 `JWT` 工具类](#432-新建-jwt-工具类)
    - [5 新建前端项目](#5-新建前端项目)
        - [1.1 使用 `vue ui`](#11-使用-vue-ui)
            - [1.1.1 导入项目](#111-导入项目)
        - [1.2 新建代码规范](#12-新建代码规范)
        - [1.3 路由](#13-路由)
            - [1.3.1 安装路由](#131-安装路由)
            - [1.3.2 新建路由配置](#132-新建路由配置)
            - [1.3.3 新建页面](#133-新建页面)
            - [1.3.4 启用路由](#134-启用路由)
        - [5.4 引导用户进入授权页面同意授权](#54-引导用户进入授权页面同意授权)
            - [5.4.1 `App.js`](#541-appjs)
    - [6 测试](#6-测试)

- [十五 点播课程模块-微信支付](#十五-点播课程模块-微信支付)
- [1 课程列表和详情](#1-课程列表和详情)
  - [1.1 目标](#11-目标)
  - [1.2 接口](#12-接口)
    - [1.2.1 追加代码 `CourseApiController`控制类](#121-追加代码-courseapicontroller控制类)
    - [1.2.2 服务接口](#122-服务接口)
    - [1.2.3 服务实现类](#123-服务实现类)
    - [1.2.4 `Mapper` 接口](#124-mapper-接口)
    - [1.2.5 `Mapper.xml`](#125-mapperxml)
  - [1.3 前端](#13-前端)
    - [1.3.1 路由](#131-路由)
    - [1.3.2 页面](#132-页面)
    - [1.3.3 使用  `Vant` 移动组件库](#133-使用--vant-移动组件库)
    - [1.3.4 使用 `scss`](#134-使用-scss)
    - [1.3.5 网络请求 `axios`](#135-网络请求-axios)
    - [1.3.6 `store`](#136-store)
    - [](#)
    - [1.3.7 `API`](#137-api)
    - [1.3.8 `App.vue` 使用 `store`](#138-appvue-使用-store)
  - [2 点播视频播放](#2-点播视频播放)
    - [2.1 目标](#21-目标)
    - [2.2 接口](#22-接口)
      - [2.2.1 新建 `VodApiController` 控制类](#221-新建-vodapicontroller-控制类)
      - [2.2.2 服务接口](#222-服务接口)
      - [2.2.3 服务实现类](#223-服务实现类)
      - [2.2.4 `application.yml` 配置](#224-applicationyml-配置)
    - [2.3 前端](#23-前端)
      - [2.3.1 `API` 新建 `vod.js`](#231-api-新建-vodjs)
      - [2.3.2 修改 `Detail.vue` 中 `play` 方法](#232-修改-detailvue-中-play-方法)
      - [2.3.3 新建页面 `play.vue`](#233-新建页面-playvue)
      - [2.3.4 对应路由](#234-对应路由)
      - [2.3.5 引入 `js` `css`](#235-引入-js-css)
  - [3 付费观看点播课程](#3-付费观看点播课程)
    - [3.1 目标](#31-目标)
      - [3.1.1 思路](#311-思路)
    - [3.2 接口](#32-接口)
      - [3.2.1 新建 `OrderInfoApiController` 控制类](#321-新建-orderinfoapicontroller-控制类)
      - [3.2.2 服务接口](#322-服务接口)
      - [3.2.3 服务实现](#323-服务实现)
      - [3.2.4 新建 `OrderNoUtils`](#324-新建-ordernoutils)
      - [3.2.5 引入依赖](#325-引入依赖)
      - [3.2.6 主启动类添加注解](#326-主启动类添加注解)
    - [3.3 远程接口](#33-远程接口)
      - [3.3.1 根据 `ID` 查询课程](#331-根据-id-查询课程)
      - [3.3.2 优惠券远程接口](#332-优惠券远程接口)
    - [3.4 `token` 获取当前用户 `id`](#34-token-获取当前用户-id)
      - [3.4.1 添加依赖](#341-添加依赖)
      - [3.4.2 新建 `LoginWebMvcConfigurerImpl`](#342-新建-loginwebmvcconfigurerimpl)
      - [3.4.3 新建 `UserLoginInterceptor` 拦截器](#343-新建-userlogininterceptor-拦截器)
      - [3.4.4 新建 `AuthContextHolder`](#344-新建-authcontextholder)
      - [3.4.5 前端实现 <已完成>](#345-前端实现-已完成)
  - [4 微信支付](#4-微信支付)
    - [4.1 接口文档](#41-接口文档)
    - [4.2 公众号配置](#42-公众号配置)
      - [4.2.1 绑定域名](#421-绑定域名)
      - [4.2.2 商户平台配置支付目录](#422-商户平台配置支付目录)
    - [4.3 创建订单支付接口](#43-创建订单支付接口)
      - [4.3.1 新建 `WXPayController`](#431-新建-wxpaycontroller)
      - [4.3.2 新建服务接口](#432-新建服务接口)
      - [4.3.3 新建服务实现](#433-新建服务实现)
      - [4.3.4 新建`HttpClientUtils`](#434-新建httpclientutils)
    - [4.4 引入依赖](#44-引入依赖)
    - [4.5 获取正式公众号里自己微信的`openid`（示例）](#45-获取正式公众号里自己微信的openid示例)
      - [4.5.1 配置文件修改为支付公众号](#451-配置文件修改为支付公众号)
      - [4.5.2 新建控制类](#452-新建控制类)
    - [4.6 路由和对应页面和对应的`API`](#46-路由和对应页面和对应的api)
      - [4.6.1 支付下单页面 `Trade.vue`](#461-支付下单页面-tradevue)
      - [4.6.2 支付页面 `Pay.vue`](#462-支付页面-payvue)
      - [4.6.3 `order.js`](#463-orderjs)
      - [4.6.4 `coupon.js`](#464-couponjs)
    - [4.7 订单详情接口](#47-订单详情接口)
      - [4.7.1 追加代码 控制类](#471-追加代码-控制类)
      - [4.7.2 服务接口类](#472-服务接口类)
      - [4.7.3 服务实现类](#473-服务实现类)
    - [4.8 查询支付结果](#48-查询支付结果)
      - [4.8.1 追加代码 控制类](#481-追加代码-控制类)
      - [4.8.2 服务接口类](#482-服务接口类)
      - [4.8.3 服务实现类](#483-服务实现类)
      - [4.8.4 服务接口类](#484-服务接口类)
      - [4.8.5 服务实现类](#485-服务实现类)

- [十六 直播管理模块和公众号观看、分享](#十六-直播管理模块和公众号观看分享)
  - [数据库表](#数据库表)
  - [1 欢拓云直播](#1-欢拓云直播)
    - [1.1 创建直播](#11-创建直播)
    - [1.2 观看直播](#12-观看直播)
    - [1.3 获取 `open id` 和 `open taken`](#13-获取-open-id-和-open-taken)
    - [1.4 下载 `SDK`](#14-下载-sdk)
  - [2 新建模块 `service_live`](#2-新建模块-service_live)
    - [2.1 依赖](#21-依赖)
    - [2.2 复制 `SDK` 文件到项目中](#22-复制-sdk-文件到项目中)
    - [2.3 新建 `application.yml`](#23-新建-applicationyml)
    - [2.4 启动类](#24-启动类)
    - [2.5 生成代码](#25-生成代码)
      - [2.5.1 修改控制层](#251-修改控制层)
      - [2.5.2 删除 `entity`, 修改所有生成文件中对应 `entity`的引用](#252-删除-entity-修改所有生成文件中对应-entity的引用)
    - [2.6 网关配置](#26-网关配置)
  - [3 直播课程列表](#3-直播课程列表)
    - [3.1 接口](#31-接口)
      - [3.1.1 控制层](#311-控制层)
      - [3.1.2 服务接口](#312-服务接口)
      - [3.1.3 服务实现类](#313-服务实现类)
    - [3.2 远程接口](#32-远程接口)
      - [3.2.1 `service_live` 添加依赖](#321-service_live-添加依赖)
      - [3.2.2 定义接口](#322-定义接口)
    - [3.3 全局统一返回结果](#33-全局统一返回结果)
    - [3.4 常量类](#34-常量类)
  - [4 直播课程添加](#4-直播课程添加)
    - [4.1 接口](#41-接口)
      - [4.1.1 控制类](#411-控制类)
      - [4.1.2 服务接口](#412-服务接口)
      - [4.1.3 服务实现类](#413-服务实现类)
    - [4.2 欢拓云属性配置类](#42-欢拓云属性配置类)
      - [4.2.1 `application.yml` 配置](#421-applicationyml-配置)
    - [4.3 欢拓云 `SDK` 配置类](#43-欢拓云-sdk-配置类)
    - [4.4 常量](#44-常量)
  - [5 直播课程删除](#5-直播课程删除)
    - [5.1 接口](#51-接口)
      - [5.1.1 控制类](#511-控制类)
      - [5.1.2 服务接口](#512-服务接口)
      - [5.1.3 服务实现类](#513-服务实现类)
    - [5.2 常量](#52-常量)
    - [6 直播课程修改](#6-直播课程修改)
    - [6.1 接口](#61-接口)
      - [6.1.1 控制层](#611-控制层)
      - [6.1.2 服务接口](#612-服务接口)
      - [6.1.3 服务实现](#613-服务实现)
    - [6.2 常量](#62-常量)
  - [7 查看账号](#7-查看账号)
    - [7.1 接口](#71-接口)
      - [7.1.1 控制层](#711-控制层)
      - [7.1.2 服务接口](#712-服务接口)
      - [7.1.3 服务实现](#713-服务实现)
  - [8 配置信息](#8-配置信息)
    - [8.1 查询配置信息](#81-查询配置信息)
      - [8.1.1 控制层](#811-控制层)
      - [8.1.2 服务接口](#812-服务接口)
      - [8.1.3 服务实现](#813-服务实现)
      - [8.1.4 根据直播课程 id 查询配置信息](#814-根据直播课程-id-查询配置信息)
      - [8.1.5 根据直播课程 id 查询直播课程商品列表](#815-根据直播课程-id-查询直播课程商品列表)
    - [8.2 修改直播配置信息](#82-修改直播配置信息)
      - [8.2.1 控制层](#821-控制层)
      - [8.2.2 服务接口](#822-服务接口)
      - [8.2.3 服务实现](#823-服务实现)
  - [9 获取最近直播课程](#9-获取最近直播课程)
    - [9.1 控制层](#91-控制层)
    - [9.2 服务接口](#92-服务接口)
    - [9.3 服务实现](#93-服务实现)
    - [9.4 `mapper` 接口](#94-mapper-接口)
    - [9.5 `mapper.xml`](#95-mapperxml)
    - [9.6 `DateUtil`](#96-dateutil)
  - [10 获取所有课程](#10-获取所有课程)
    - [10.1 控制层](#101-控制层)
    - [10.2 服务接口](#102-服务接口)
    - [10.3 服务实现](#103-服务实现)
    - [10.4 后台管理系统-菜单管理-菜单列表](#104-后台管理系统-菜单管理-菜单列表)
  - [11 后台管理系统-直播管理模块前端](#11-后台管理系统-直播管理模块前端)
    - [11.1 配置路由](#111-配置路由)
    - [11.2 新建页面](#112-新建页面)
      - [11.2.1 `course/List.vue`](#1121-courselistvue)
      - [11.2.2 `Config.vue`](#1122-configvue)
    - [11.3 `API`](#113-api)
      - [11.3.1 追加代码 `api`](#1131-追加代码-api)
  - [12 测试直播管理模块](#12-测试直播管理模块)
    - [12.1 列表显示](#121-列表显示)
    - [12.2 `Bug`分页显示异常](#122-bug分页显示异常)
      - [12.2.1 `Bug`修复 - `MybatisPlus` 分页插件](#1221-bug修复---mybatisplus-分页插件)
    - [12.3 测试添加直播](#123-测试添加直播)
      - [12.3.1 `Bug`时间显示错误](#1231-bug时间显示错误)
    - [12.4 修改直播](#124-修改直播)
      - [12.4.1 修复`Bug`](#1241-修复bug)
      - [12.4.2 修改成功](#1242-修改成功)
  - [13 微信公众号直播观看](#13-微信公众号直播观看)
    - [13.1 欢拓云观看端集成`WebSDK`](#131-欢拓云观看端集成websdk)
      - [13.1.1 获取用户`access_token`](#1311-获取用户access_token)
      - [13.1.2 下载前端SDK](#1312-下载前端sdk)
      - [12.1.3 使用快捷模板](#1213-使用快捷模板)
    - [13.2 前端整合](#132-前端整合)
      - [13.2.1 新建直播播放页面 `live.html`](#1321-新建直播播放页面-livehtml)
      - [13.2.2 新建直播播放 `LiveInfo.vue`](#1322-新建直播播放-liveinfovue)
      - [13.2.3 新建 `API`](#1323-新建-api)
      - [13.2.4 新建工具 `wxShare.js`](#1324-新建工具-wxsharejs)
    - [13.3 对应接口](#133-对应接口)
      - [13.3.1 控制层](#1331-控制层)
      - [13.3.2 服务接口](#1332-服务接口)
      - [13.3.3 服务实现](#1333-服务实现)
    - [13.4 测试公众号直播观看](#134-测试公众号直播观看)
      - [13.4.1 管理后台添加直播](#1341-管理后台添加直播)
      - [13.4.2 公众号设置路径](#1342-公众号设置路径)
      - [13.4.3 登录开播并打开公众号点击测试直播菜单](#1343-登录开播并打开公众号点击测试直播菜单)
  - [14 微信网页开发-使用微信分享功能](#14-微信网页开发-使用微信分享功能)
    - [14.1 使用微信 `JS-SDK`](#141-使用微信-js-sdk)
      - [14.1.1 绑定域名](#1411-绑定域名)
      - [14.1.2 引入`JS`文件](#1412-引入js文件)
    - [14.2 新建微信配置文件 `wxShare.js`](#142-新建微信配置文件-wxsharejs)
    - [14.3 点播课程详情分享](#143-点播课程详情分享)
      - [14.3.1 引入 `wxShare.js`](#1431-引入-wxsharejs)
      - [14.3.2 `methods`](#1432-methods)
    - [14.4 新建`API`, `share.js`](#144-新建api-sharejs)
    - [14.5 获取签名](#145-获取签名)
      - [14.5.1 控制层 - 新建 `ShareController`类](#1451-控制层---新建-sharecontroller类)
      - [14.5.2 新建工具类 `Base64Util`](#1452-新建工具类-base64util)
    - [14.6 测试](#146-测试)

# 一 硅谷课堂

## 项目概述

- 硅谷课堂是一款基于微信公众号 `B2C` 模式的在线学习平台, 该平台包含两大部分

  - 后台管理系统
  - 公众号系服务

- 平台会定期推出直播或点播课程, 为学员构建一个全方位的在线学习平台



## 前置知识储备

- `Java` 基础
- `JavaWeb`
- `SSM` 框架
- `SpringBoot`
- `SpringCloud`
- `MySQL` 数据库
- `Docker`
- `K8S`



## 硅谷课堂功能架构图

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/12811585/1663752125991-a6719003-4621-4123-bf09-b9344b02b6dc.jpeg)



## 项目技术介绍

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/12811585/1663757854692-db5e7c88-16e3-4b55-ac86-23f09b268f3a.jpeg)



## 产品图

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1663752546515-1910d428-6a51-4d5c-a722-39614dda6e22.png)



![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1663752572827-849b7f3a-b56b-477d-9acd-104a41257a6b.png)

# 二 `MyBatisPlus`

```
git checkout -b 1.0.0_ggkt_mp_demo
```

## 1 `MyBatisPlus` 简介

### 1.1 概述

官网: https://baomidou.com/

`MyBatisPlus`（`MP`）是一个 `MyBatis` 的增强根据, 在 MyBatis 的基础上只做增强不做改变, 为简化开发、提高效率而生



## 1.2 特性

- **无侵入性**: 只做增强不做改变, 引入它不会对现有工程产生影响, 如丝般顺滑
- **损耗小**: 启动即会自动注入基本 `CURD`, 性能基本无损耗, 直接面向对象操作
- **强大的** `**CRUD**` **操作**: 内置通用 Mapper、通用 `Service`, 仅仅通过少量配置即可实现单表大部分 `CRUD` 操作,  更有强大的条件构造器, 满足各类使用需求
- **支持** `**Lambda**` **形式调用**: 通过 `Lambda` 表达式, 方便的编写各类查询条件, 无需再担心字段写错
- **支持多种数据库**: 支持 `MySQL`、`MariaDB`、`Oracle`、`DB2`、`H2`、`HSQL`、`SQLLite`、`Postgre`、`SQLServer2005`、`SQLServer` 等多种数据库
- **支持主键自动生成**: 支持多达 4 种主键策略（内含分布式唯一 ID 生成器 - `Sequence`）, 可自由配置, 完美解决主键问题
- **支持** `**XML**` **热加载**: `Mapper` 对应的 `XML` 支持热加载, 对于简单的 `CRUD` 操作, 甚至可以无 `XML` 启动
- **支持** `**ActiveRecord**` **模式**: 支持 `RctiveRecord` 形式调用, 实体类只需继承 `Model` 类即可进行强大的 `CRUD` 操作



## 2 `MyBatisPlus` 入门

### 2.1 创建测试数据库和表

```plsql
DROP DATABASE IF EXISTS mybatis_plus;
CREATE DATABASE mybatis_plus;
USE mybatis_plus;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` BIGINT(20) NOT NULL,
  `name` VARCHAR(255) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `email` VARCHAR(255) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`id`, `name`, `age`, `email`) VALUES (1, 'jone', 18, 'test1@baomidou.com');
INSERT INTO `user` (`id`, `name`, `age`, `email`) VALUES (2, 'jack', 19, 'test2@baomidou.com');
INSERT INTO `user` (`id`, `name`, `age`, `email`) VALUES (3, 'Tom', 20, 'test3@baomidou.com');
INSERT INTO `user` (`id`, `name`, `age`, `email`) VALUES (4, 'Sandy', 21, 'test4@baomidou.com');
INSERT INTO `user` (`id`, `name`, `age`, `email`) VALUES (5, 'Billie', 22, 'test5@baomidou.com');
COMMIT;
```



### 2.2 创建项目和添加依赖

- `SpringBoot` 版本: `2.2.1.RELEASE`

#### 2.2.1 前置目录

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1663764407655-f203c9c9-ad22-46f4-b142-3383786c62f4.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664826789254-e3e5a6dc-23a0-473b-abe3-cc3be2548485.png)

- 删除 `src` 目录
- 新建 `ggkt.sql`

```java
DROP DATABASE IF EXISTS mybatis_plus;
CREATE DATABASE mybatis_plus;
USE mybatis_plus;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` BIGINT(20) NOT NULL,
  `name` VARCHAR(255) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `email` VARCHAR(255) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`id`, `name`, `age`, `email`) VALUES (1, 'jone', 18, 'test1@baomidou.com');
INSERT INTO `user` (`id`, `name`, `age`, `email`) VALUES (2, 'jack', 19, 'test2@baomidou.com');
INSERT INTO `user` (`id`, `name`, `age`, `email`) VALUES (3, 'Tom', 20, 'test3@baomidou.com');
INSERT INTO `user` (`id`, `name`, `age`, `email`) VALUES (4, 'Sandy', 21, 'test4@baomidou.com');
INSERT INTO `user` (`id`, `name`, `age`, `email`) VALUES (5, 'Billie', 22, 'test5@baomidou.com');
COMMIT;
```

- 新建 `.gitignore`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664826978305-3cbb6507-d8aa-439e-8f7a-28ce9b3c0947.png)

- 勾选 `Java` 和 `Example user templdate`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664827084271-cc1824c5-b3c7-4974-93d2-c4cade57f8c4.png)



```latex
### Java template
# Compiled class file
*.class

# Log file
*.log

# BlueJ files
*.ctxt

# Mobile Tools for Java (J2ME)
.mtj.tmp/

# Package Files #
*.jar
*.war
*.nar
*.ear
*.zip
*.tar.gz
*.rar

# virtual machine crash logs, see http://www.java.com/en/download/help/error_hotspot.xml
hs_err_pid*

### Example user template template
### Example user template

# IntelliJ project files
.idea
*.iml
out
gen
### Example user template template
### Example user template

# IntelliJ project files
.idea
*.iml
out
gen
### Java template
# Compiled class file
*.class

# Log file
*.log

# BlueJ files
*.ctxt

# Mobile Tools for Java (J2ME)
.mtj.tmp/

# Package Files #
*.jar
*.war
*.nar
*.ear
*.zip
*.tar.gz
*.rar

# virtual machine crash logs, see http://www.java.com/en/download/help/error_hotspot.xml
hs_err_pid*
```

- 上传到 `GitHub`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1663764677488-7172e74e-ca95-47b8-ad9a-d41a8b90a314.png)

- 令牌

```git
git remote set-url origin https://令牌@github.com/用户名/ggkt.git
```

- 在 `GitHub` 上创建`README.md`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1663765723875-4a177883-cadd-417f-b2f0-095f1e9ab79c.png)

- 项目更新一下: `git pull`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664827902015-a948fefc-715d-4202-aa8c-f1be0873aecb.png)



#### 2.2.2 创建项目模块

```
git checkout -b 1.0.0_ggkt_mp_demo
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1663766189207-8f6146a8-0da1-443f-8839-db8a76de25ff.png)

- `ggkt_mp_demo`
- `com.atguigu`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664827984743-febd0c26-6660-47ac-a7ed-6c33db015734.png)



#### 2.2.3 项目引入依赖

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.2.1.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.atguigu</groupId>
    <artifactId>ggkt_mp_demo</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>ggkt_mp_demo</name>
    <description>Demo project for Spring Boot</description>
    <properties>
        <java.version>1.8</java.version>
        <mybatis.version>3.3.1</mybatis.version>
        <druid.version>1.1.17</druid.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <!-- MyBatis Plus -->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>${mybatis.version}</version>
        </dependency>

        <!-- MySQL 驱动-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>

        <!-- 整合数据库连接池 -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid-spring-boot-starter</artifactId>
            <version>${druid.version}</version>
        </dependency>

        <!-- lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>
```



### 2.3 配置文件

- 将 `application.properties` 改为 `application.yml`
- 配置数据库

```yaml
server:
  port: 1000

# 生成的公钥
public-key: MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAMNXQuj4GCqDt+t3ex6W9u5hf50/o/JZKS6C0lKlzzUXvWHqAhJxqWoa3C2+Jp+CUtJhugMtTpeLMf5+Acokg8ECAwEAAQ==

spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://175.178.174.83:3306/mybatis_plus?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8&useSSL=false
    username: root
    # 生成的加密后的密码
    password: lEdXTUweRH6bqzFKEy07vHkzKrziXqkHBQNwjK6FohatpabGU+2uxc73RZftE1vD3F5GDPZDhNg6vebNTNAOcA==
    # 配置 connection-properties，启用加密，配置公钥。
    druid:
      connection-properties: config.decrypt=true;config.decrypt.key=${public-key}
      # 启用ConfigFilter
      filter:
        config:
          enabled: true
```



### 2.4 编写代码

1. 扫描 `mapper`

```java
package com.atguigu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * `@MapperScan("com.atguigu.mybatisplus.mapper")`: 指定扫描包下的 mapper 文件
 */
@SpringBootApplication
@MapperScan("com.atguigu.mapper")
public class GgktMpDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GgktMpDemoApplication.class, args);
    }

}
```



1. 创建实体类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664828278517-066b8639-e255-448b-8339-277a0dd467a4.png)

```java
package com.atguigu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 陈江林
 * @date 2022/9/22 12:49
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private Long id;
    private String name;
    private Integer age;
    private String email;

}
```



1. 创建 `mapper`

```java
package com.atguigu.mapper;

import com.atguigu.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @author 陈江林
 * @date 2022/9/22 12:51
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
}
```



1. 功能参数 - 查询所有记录

```java
package com.atguigu;

import com.atguigu.entity.User;
import com.atguigu.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GgktMpDemoApplicationTests {

    @Autowired
    private UserMapper userMapper;
    
    @Test
    void contextLoads() {
    }

    /**
     * 查询所有用户
     */
    @Test
    public void findAll() {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::print);
    }

}
```



1. 查看 `sql` 输出日志, `application.yml `配置

```yaml
# MyBatis 日志
mybatis-plus:
	configuration:
  	log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
```



## 3 MyBatisPlus 实现 CRUD 操作

- `CRUD`: 增加(`Create`)、读取(`Read`)、更新(`Update`)和删除(`Delete`)

### 3.1 插入操作

```java
/**
 * 添加用户
 */
@Test
public void addUser() {
    User user = new User(null, "尚硅谷", 9, "atguigu.com");
    int rows = userMapper.insert(user);
    System.out.println("rows:" + rows);
    // 添加成功后, 把添加之后生成的 id 值, 回填到 user 对象中
    System.out.println(user);
}
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664828641554-877ccefe-8a24-4345-9d5b-7f699c9afad6.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1663828267712-1bbdc654-2a93-43c2-8a83-938c89b64fcc.png)



### 3.2 主键策略

- `MyBatis-plus` 默认的主键策略是: `ID_WORKER` 全局唯一 ID
- 自增策略

  - 需要主键自增需要配置如下主键策略

    - 数据库设置主键自增
    - 实体字段中配置 `@TableId(type = IdType.AUTO)`

| **@TableId(type = IdType.AUTO)** | **说明**                                                     |
| -------------------------------- | ------------------------------------------------------------ |
| **IdType.**`**ASSIGN_ID**`       | `MP` **默认策略**, 生成 19 位数字值                          |
| **IdType.**`**ASSIGN_UUID**`     | 生成数字和字母的值                                           |
| **IdType.**`**AUTO**`            | 自增表主键字段必须设置成自动增长（`AUTO_INCREMENT`）表主键字段类型 `int` 类型 |
| **IdType.**`**INPUT**`           | 输入: 需要自己手动输入 `ID` 值                               |
| **IdType.**`**NONE**`            | 没有策略                                                     |



### 3.3 根据 id 更新操作

- 注意: `update` 生成的 `SQL` 是动态 `SQL`: `UPDATE uesr SET age=? WHERE id=?`

```java
/**
 * 根据 Id 修改
 */
@Test
public void testUpdateById() {
    // 1 根据 id 查询记录
    User user = userMapper.selectById(1572834755096702978L);

    // 2 设置修改的值
    user.setAge(18);

    // 3 调用方法修改
    int result = userMapper.updateById(user);
    System.out.println(result);
}
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664828744270-80c71782-135e-4758-9d8a-ebf400bb78d2.png)



### 3.4 分页查询

- `Mybatis Plus` 自带分页插件, 只要简单的配置即可实现分页功能

1. 创建配置类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664828469154-bb0d3467-a1d0-430a-a741-5097ed475c74.png)

```java
package com.atguigu.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatisPlus 配置文件
 * 
 * @author 陈江林
 * @date 2022/10/4 04:20
 */
@Configuration
public class MpConfig {

    /**
     * 分页插件
     * `@Bean`: 将对象注册到 IOC 容器中
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        // 返回分页对象
        return new PaginationInterceptor();
    }

}
```

1. 分页查询

```java
/**
 * 分页查询
 */
@Test
public void findPage() {
    // 创建配置对象, 传递两个参数: 当前页 每页显示记录数
    Page<User> page = new Page<>(1, 3);
    // 调用 MP 方法实现分页
    userMapper.selectPage(page, null);
    // IPage<User> pageModel = userMapper.selectPage(page, null);
    List<User> list = page.getRecords();
    System.out.println(list);

    System.out.println(page.getCurrent());
    System.out.println(page.getPages());
    System.out.println(page.getSize());
    System.out.println(page.getTotal());
    System.out.println(page.hasNext());
    System.out.println(page.hasPrevious());
}
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664828827014-eec37176-baba-4a75-b86b-3e4aec0e3387.png)

### 3.5 根据 `id` 删除记录

```java
/**
 * 根据 Id 删除
 */
@Test
public void deleteByIdeById() {
    userMapper.deleteById(1572834755096702978L);
}
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664828889674-ebec33bb-d6ad-446d-a473-ef0797eda210.png)

### 3.6 批量删除

```java
/**
 * 批量删除
 */
@Test
public void deleteBatch() {
    int rows = userMapper.deleteBatchIds(Arrays.asList(1, 2));
    System.out.println(rows);
}
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664828958777-b9c98ad6-1aed-4caa-ad70-b8a7de35b233.png)



### 3.7 逻辑删除（更新/修改数据）

- 在表中添加字段, 作为逻辑删除的标志

1. 约定规则: [{0: 没有删除}, {1: 已经删除}]
2. 一般数据标志 0
3. 删除: 把标志改为 1



#### 3.7.1 数据库中添加 `deleted` 字段

```java
ALTER TABLE `user` ADD COLUMN `deleted` boolean
```

- 修改值为 `0`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664829098861-6fa88e37-ef76-493e-99c9-1812802fb803.png)

#### 3.7.2 实体类添加 `deleted` 属性

```java
/**
 * 逻辑删除 [{0: "没有删除"}, {1: "已经删除"}]
 */
@TableLogic
private Integer deleted;
```



#### 3.7.3 `application.yml` 配置删除标志

```yaml
mybatis-plus:
	global-config:
  	db-config:
    	# 1 表示已经删除, 默认为1 
    	logic-delete-value: 1
    	# 0 表示没有删除, 默认为 0
    	logic-not-delete-value: 0
```



#### 3.7.4 测试

- 再执行删除, 本质会是修改 `deleted`, 改为 1

1. 先添加一条数据

```java
/**
 * 添加用户
 */
@Test
public void addUser() {
    User user = new User(null, "尚硅谷", 9, "atguigu.com", 0);
    int rows = userMapper.insert(user);
    System.out.println("rows:" + rows);
    // 添加成功后, 把添加之后生成的 id 值, 回填到 user 对象中
    System.out.println(user);
}
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664829226380-44b6a2d4-d9f8-4cf5-972e-6daadf344577.png)



1. 删除操作, 多个条件 `deleted=0`

```java
/**
 * 根据 Id 删除
 */
@Test
public void deleteByIdeById() {
    userMapper.deleteById(1577034147517198337L);
}
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664829396748-4c51c7e9-e250-431c-92db-374fad9955de.png)



1. 查询操作, 多个条件 `deleted=0`

```java
/**
 * 查询所有用户
 */
@Test
public void findAll() {
    List<User> userList = userMapper.selectList(null);
    userList.forEach(System.out::print);
}
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664829461604-dd00549b-ba2b-4616-8859-422e8220852a.png)



## 4 `MyBatisPlus` 条件构造器

- 类图

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664183308126-57a722ca-6694-4866-a91d-c118f18c5e43.png)

| **类名**                |                                 | **说明**                                                     |
| ----------------------- | ------------------------------- | ------------------------------------------------------------ |
| `Wrapper`               | **条件构造抽象类**              | 最顶端父类                                                   |
| `AbstractWrapper`       | **查询条件封装**                | 生成 `sql` 的 `where` 条件                                   |
| `**QueryWrapper**`      | **对象封装操作类**              | 不是用 `lambda` 语法                                         |
| `UpdateWrapper`         | `**Update**` **条件封装**       | 用于 `Entity` 对象更新操作                                   |
| `AbstractLambdaWrapper` |                                 | `Lambda` 语法使用 `Wrapper`统一处理解析 `lambda` 获取 `column` |
| `LambdaQueryWrapper`    | 继承 `AbstractLambdaWrapper` 类 | `Lambda` 语法使用 `Wrapper`                                  |
| `LambdaUpdateWrapper`   | 继承 `AbstractLambdaWrapper` 类 | `Lambda` 更新封装                                            |

注意: 以下条件构造器的方法入参中的 `column` 均表示数据库字段



### 4.1 `AbstractWrapper`

| **方法名**   | **作用**   |
| ------------ | ---------- |
| `eq`         | `=`        |
| `ne`         | `<>`       |
| `gt`         | `>`        |
| `ge`         | `>=`       |
| `lt`         | `<`        |
| `le`         | `<=`       |
| `like`       | `%值%`     |
| `notLike`    | `NOT %值%` |
| `likeLeft`   | `%值`      |
| `likeRight`  | `值%`      |
| `between`    |            |
| `notBetween` |            |
| `and`        | `AND`      |
| `or`         | `OR`       |



### 4.2 `QueryWrapper` 使用

```java
/**
 * QueryWrapper 使用
 */
@Test
public void testSelect() {
    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    queryWrapper.ge("age", 18);
    List<User> users = userMapper.selectList(queryWrapper);
    System.out.println(users);
}
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664829616343-1130c274-65a9-42bd-983c-9da9171871e7.png)



### 4.3 `LambdaQueryWrapper` 使用

```java
/**
 * LambdaQueryWrapper 使用
 */
@Test
public void testLambdaQuery() {
    LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper.eq(User::getAge, 30);
    queryWrapper.like(User::getName, "张");
    List<User> list = userMapper.selectList(queryWrapper);
    System.out.println(list);
}
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664829683943-a887182f-015c-4731-9225-84d77de09cfa.png)



## 5 `MybatisPuls` 对 `service` 的封装

- 无需主动注入 `mapper`, `ServiceImpl` 会自动注入

```java
// 省略注入 mapper
// @Autowired 
// private UserMapper userMapper;
```

### 5.1 新建 `UserService` 接口

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664829716732-6cb0ea91-41a1-417c-bf52-5f10e8ad78b9.png)

```java
package com.atguigu.service;

import com.atguigu.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author 陈江林
 * @date 2022/10/1 07:42
 */
public interface UserService extends IService<User> {
}
```



### 5.2 新建 `UserServiceImpl`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664829751863-a50ca5ba-740b-45e9-a044-77dfcc3835ef.png)

```java
package com.atguigu.service.impl;

import com.atguigu.entity.User;
import com.atguigu.mapper.UserMapper;
import com.atguigu.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author 陈江林
 * @date 2022/10/1 07:43
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
```



### 5.3 测试: 新建 `ServiceTestsDemo` 类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664581618309-2a87c262-7cb8-490a-8f43-5254270a77a9.png)

```java
package com.atguigu;

import com.atguigu.entity.User;
import com.atguigu.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author 陈江林
 * @date 2022/10/1 07:46
 */
@SpringBootTest
public class ServiceTestsDemo {

    @Autowired
    private UserService userService;

    @Test
    public void test() {
        List<User> list = userService.list();
        System.out.println(list);
    }

}
```

- 运行结果:

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664830148121-f88924a7-7a53-4238-a6b1-2ec2a2af187a.png)


# 三 开发讲师管理接口

```
git checkout -b 2.0.0_teacher_interface
```

## 1 前后端分离开发

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/12811585/1664586904550-ceab2622-d33e-44f4-b306-89f06555bb7d.jpeg)



## 2 搭建后端环境 - 基于 `Maven` 聚合工程

### 2.1 创建数据库和表

```plsql
/*
SQLyog Ultimate - MySQL GUI v8.2 
MySQL - 5.7.29-32-log : Database - glkt_vod
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`glkt_vod` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `glkt_vod`;

/*Table structure for table `chapter` */

DROP TABLE IF EXISTS `chapter`;

CREATE TABLE `chapter` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `course_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '课程ID',
  `title` varchar(50) NOT NULL COMMENT '章节名称',
  `sort` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '显示排序',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_course_id` (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='课程';

/*Data for the table `chapter` */

insert  into `chapter`(`id`,`course_id`,`title`,`sort`,`create_time`,`update_time`,`is_deleted`) values (1,18,'第七章：I/O流',7,'2021-11-05 03:05:51','2021-12-01 05:48:44',0),(2,2,'第一章节',0,'2021-11-05 03:05:51','2021-11-05 03:38:14',0),(3,3,'第一章',0,'2021-11-05 03:05:51','2021-11-05 03:38:24',0),(4,4,'第一章',0,'2021-11-05 03:05:51','2021-11-05 03:38:34',0),(5,14,'第一章：HTML',0,'2021-11-05 03:05:51','2021-11-05 03:05:51',0),(6,14,'第二章：CSS',0,'2021-11-05 03:05:51','2021-11-05 03:05:51',0),(7,5,'第一章',0,'2021-11-05 03:05:51','2021-11-05 03:38:50',0),(8,15,'第一章',0,'2021-11-05 03:05:51','2021-11-05 03:39:03',0),(9,6,'数据仓库基础',0,'2021-11-05 03:05:51','2021-11-05 03:39:14',0),(10,7,'课程基础',0,'2021-11-05 03:05:51','2021-11-05 03:39:26',0),(11,8,'介绍及原理',0,'2021-11-05 03:05:51','2021-11-05 03:39:38',0),(12,1,'spark介绍',0,'2021-11-05 03:05:51','2021-11-05 03:39:50',0),(15,18,'第一章：Java入门',1,'2021-11-05 03:05:51','2021-12-01 05:48:35',0),(16,18,'第二章：控制台输入和输出',2,'2021-11-05 03:05:51','2021-12-01 05:48:36',0),(17,18,'第三章：控制流',3,'2021-11-05 03:05:51','2021-12-01 05:48:36',0),(18,18,'第四章：类的定义',4,'2021-11-05 03:05:51','2021-12-01 05:48:38',0),(19,18,'第五章：数组',5,'2021-11-05 03:05:51','2021-12-01 05:48:41',0),(20,18,'第六章：继承',6,'2021-11-05 03:05:51','2021-12-01 05:48:42',0),(65,19,'入门及安装配置',0,'2021-11-22 11:10:56','2021-11-22 11:10:56',0),(66,19,'mysql原理',1,'2021-11-22 11:11:17','2021-11-22 11:11:17',0);

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `course_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '课程id',
  `teacher_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '讲师id',
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '会员id',
  `nickname` varchar(50) DEFAULT NULL COMMENT '会员昵称',
  `avatar` varchar(255) DEFAULT NULL COMMENT '会员头像',
  `content` varchar(500) DEFAULT NULL COMMENT '评论内容',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_course_id` (`course_id`),
  KEY `idx_teacher_id` (`teacher_id`),
  KEY `idx_member_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='评论';

/*Data for the table `comment` */

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `teacher_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '课程讲师ID',
  `subject_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '课程专业ID',
  `subject_parent_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '课程专业父级ID',
  `title` varchar(50) NOT NULL COMMENT '课程标题',
  `price` decimal(10,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '课程销售价格，设置为0则可免费观看',
  `lesson_num` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '总课时',
  `duration_sum` int(11) NOT NULL DEFAULT '0' COMMENT '视频总时长（秒）',
  `cover` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '课程封面图片路径',
  `buy_count` bigint(10) unsigned NOT NULL DEFAULT '0' COMMENT '销售数量',
  `view_count` bigint(10) unsigned NOT NULL DEFAULT '0' COMMENT '浏览数量',
  `status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '课程状态 0未发布 1已发布',
  `publish_time` datetime DEFAULT NULL COMMENT '课程发布时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_title` (`title`),
  KEY `idx_subject_id` (`subject_id`),
  KEY `idx_teacher_id` (`teacher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='课程';

/*Data for the table `course` */

insert  into `course`(`id`,`teacher_id`,`subject_id`,`subject_parent_id`,`title`,`price`,`lesson_num`,`duration_sum`,`cover`,`buy_count`,`view_count`,`status`,`publish_time`,`create_time`,`update_time`,`is_deleted`) values (1,1,16,14,'Spark','21800.00',0,100000,'https://online-teach-file.oss-cn-beijing.aliyuncs.com/cover/2021/08/10/39e51c23-e2fa-4a8a-9239-3c0d5268f34d.jpg',1679,34634,1,'2021-11-05 11:30:14','2021-11-05 03:05:16','2021-11-24 06:37:39',0),(2,1,2,1,'java基础课程','19800.00',2,100000,'https://online-teach-file.oss-cn-beijing.aliyuncs.com/cover/2021/08/09/bd89ae0b-e660-47fd-9ed7-ad8733a46c65.jpg',5999,10048,0,NULL,'2021-11-05 03:05:16','2021-11-24 06:37:37',0),(3,1,15,14,'尚硅谷大数据技术之Flume（2019新版）','20800.00',0,100000,'https://online-teach-file.oss-cn-beijing.aliyuncs.com/cover/2021/08/09/806572e0-6d85-485e-8784-d2cb4716a881.jpg',4234,23780,0,NULL,'2021-11-05 03:05:16','2021-11-24 06:37:36',0),(4,2,15,14,'尚硅谷大数据技术之HBase（2019新版）','19800.00',0,100000,'https://online-teach-file.oss-cn-beijing.aliyuncs.com/cover/2021/08/09/a16c5694-3037-4330-b1c5-438052081fcb.jpg',6675,90383,0,NULL,'2021-11-05 03:05:16','2021-11-24 06:37:34',0),(5,1,1,2,'尚硅谷大数据技术之Kafka（2019新版）','22800.00',0,100000,'https://online-teach-file.oss-cn-beijing.aliyuncs.com/cover/2021/08/09/f5ada6ba-8d12-4c00-8ad9-6a521f71b0da.jpg',2349,13546,0,NULL,'2021-11-05 03:05:16','2021-11-24 06:37:33',0),(6,2,15,14,'尚硅谷大数据项目之电商数仓','21800.00',0,100000,'https://online-teach-file.oss-cn-beijing.aliyuncs.com/cover/2021/08/10/dd2da284-b37f-4818-ba9a-c55667837f5a.jpg',898,8977,0,NULL,'2021-11-05 03:05:16','2021-11-24 06:37:32',0),(7,2,15,14,'尚硅谷大数据技术之Sqoop','23800.00',0,100000,'https://online-teach-file.oss-cn-beijing.aliyuncs.com/cover/2021/08/10/9452b057-6ad6-4600-891e-b168083fee4d.jpg',1286,45695,0,NULL,'2021-11-05 03:05:16','2021-11-24 06:37:31',0),(8,1,16,14,'大数据Scala入门到精通（新版）','0.00',0,100000,'https://online-teach-file.oss-cn-beijing.aliyuncs.com/cover/2021/08/10/f2cd321f-6378-4e92-8515-0b8f42f2770b.jpg',900,15496,0,NULL,'2021-11-05 03:05:16','2021-11-24 06:37:13',0),(14,1,4,3,'XHTML CSS2 JS整站制作教程课程学习','21800.00',3,100000,'https://online-teach-file.oss-cn-beijing.aliyuncs.com/cover/2021/08/09/2829c8d1-f16f-44a4-96cd-d13b451a8d56.jpg',3452,21010,0,NULL,'2021-11-05 03:05:16','2021-11-24 06:37:28',0),(15,2,2,1,'  14417人 分享 收藏 SpringMVC','22800.00',23,100000,'https://online-teach-file.oss-cn-beijing.aliyuncs.com/cover/2021/08/09/273ddd90-5ef7-40e5-9ffd-86e8175fc229.jpg',892,9107,0,NULL,'2021-11-05 03:05:16','2021-11-24 06:37:24',0),(18,2,2,1,'Java精品课程','22800.00',20,100000,'https://online-teach-file.oss-cn-beijing.aliyuncs.com/cover/2021/08/09/e4ee03d7-52bd-41ca-99f9-04dc23250a71.jpg',6784,67629,1,'2021-11-19 14:16:19','2021-11-05 03:05:16','2021-11-24 06:37:25',0),(19,1,2,1,'JAVA之Mysql基础','1000.00',10,100201,'http://47.93.148.192:9000/gmall/20211122/1504320cbe2b246514.jpg',0,155,1,'2021-11-25 09:57:42','2021-11-22 11:09:22','2021-11-25 01:57:39',0);

/*Table structure for table `course_collect` */

DROP TABLE IF EXISTS `course_collect`;

CREATE TABLE `course_collect` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `course_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '课程讲师ID',
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '会员ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='课程收藏';

/*Data for the table `course_collect` */

/*Table structure for table `course_description` */

DROP TABLE IF EXISTS `course_description`;

CREATE TABLE `course_description` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `course_id` bigint(20) DEFAULT NULL,
  `description` text COMMENT '课程简介',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COMMENT='课程简介';

/*Data for the table `course_description` */

insert  into `course_description`(`id`,`course_id`,`description`,`create_time`,`update_time`,`is_deleted`) values (1,1,'<p>本套Java视频完全针对零基础学员，课堂实录，自发布以来，好评如潮！Java视频中注重与学生互动，讲授幽默诙谐、细致入微，覆盖Java基础所有核心知识点，同类Java视频中也是代码量大、案例多、实战性强的。同时，本Java视频教程注重技术原理剖析，深入JDK源码，辅以代码实战贯穿始终，用实践驱动理论，并辅以必要的代码练习。</p>','2021-11-05 03:29:33','2021-11-08 11:27:01',0),(2,2,'<p>本套Java视频完全针对零基础学员，课堂实录，自发布以来，好评如潮！Java视频中注重与学生互动，讲授幽默诙谐、细致入微，覆盖Java基础所有核心知识点，同类Java视频中也是代码量大、案例多、实战性强的。同时，本Java视频教程注重技术原理剖析，深入JDK源码，辅以代码实战贯穿始终，用实践驱动理论，并辅以必要的代码练习。</p>','2021-11-05 03:30:07','2021-11-08 11:27:04',0),(3,3,'<p>本套Java视频完全针对零基础学员，课堂实录，自发布以来，好评如潮！Java视频中注重与学生互动，讲授幽默诙谐、细致入微，覆盖Java基础所有核心知识点，同类Java视频中也是代码量大、案例多、实战性强的。同时，本Java视频教程注重技术原理剖析，深入JDK源码，辅以代码实战贯穿始终，用实践驱动理论，并辅以必要的代码练习。</p>','2021-11-05 03:30:47','2021-11-08 11:27:07',0),(4,4,'<p>本套Java视频完全针对零基础学员，课堂实录，自发布以来，好评如潮！Java视频中注重与学生互动，讲授幽默诙谐、细致入微，覆盖Java基础所有核心知识点，同类Java视频中也是代码量大、案例多、实战性强的。同时，本Java视频教程注重技术原理剖析，深入JDK源码，辅以代码实战贯穿始终，用实践驱动理论，并辅以必要的代码练习。</p>\n<p>------------------------------------</p>\n<p>视频特点：</p>\n<p>通过学习本Java视频教程，大家能够真正将Java基础知识学以致用、活学活用，构架Java编程思想，牢牢掌握\"源码级\"的Javase核心技术，并为后续JavaWeb等技术的学习奠定扎实基础。<br /><br />1.通俗易懂，细致入微：每个知识点高屋建瓴，深入浅出，简洁明了的说明问题<br />2.具实战性：全程真正代码实战，涵盖上百个企业应用案例及练习<br />3.深入：源码分析，更有 Java 反射、动态代理的实际应用等<br />4.登录尚硅谷官网，技术讲师免费在线答疑</p>\n','2021-11-05 03:33:18','2021-11-08 11:25:23',0),(5,5,'<p>本套Java视频完全针对零基础学员，课堂实录，自发布以来，好评如潮！Java视频中注重与学生互动，讲授幽默诙谐、细致入微，覆盖Java基础所有核心知识点，同类Java视频中也是代码量大、案例多、实战性强的。同时，本Java视频教程注重技术原理剖析，深入JDK源码，辅以代码实战贯穿始终，用实践驱动理论，并辅以必要的代码练习。</p>','2021-11-05 03:41:05','2021-11-08 11:27:10',0),(6,6,'<p>本套Java视频完全针对零基础学员，课堂实录，自发布以来，好评如潮！Java视频中注重与学生互动，讲授幽默诙谐、细致入微，覆盖Java基础所有核心知识点，同类Java视频中也是代码量大、案例多、实战性强的。同时，本Java视频教程注重技术原理剖析，深入JDK源码，辅以代码实战贯穿始终，用实践驱动理论，并辅以必要的代码练习。</p>','2021-11-05 03:41:27','2021-11-08 11:27:12',0),(7,7,'<p>本套Java视频完全针对零基础学员，课堂实录，自发布以来，好评如潮！Java视频中注重与学生互动，讲授幽默诙谐、细致入微，覆盖Java基础所有核心知识点，同类Java视频中也是代码量大、案例多、实战性强的。同时，本Java视频教程注重技术原理剖析，深入JDK源码，辅以代码实战贯穿始终，用实践驱动理论，并辅以必要的代码练习。</p>','2021-11-05 03:41:43','2021-11-08 11:27:22',0),(8,8,'<p>本套Java视频完全针对零基础学员，课堂实录，自发布以来，好评如潮！Java视频中注重与学生互动，讲授幽默诙谐、细致入微，覆盖Java基础所有核心知识点，同类Java视频中也是代码量大、案例多、实战性强的。同时，本Java视频教程注重技术原理剖析，深入JDK源码，辅以代码实战贯穿始终，用实践驱动理论，并辅以必要的代码练习。</p>\n<p>------------------------------------</p>\n<p>视频特点：</p>\n<p>通过学习本Java视频教程，大家能够真正将Java基础知识学以致用、活学活用，构架Java编程思想，牢牢掌握\"源码级\"的Javase核心技术，并为后续JavaWeb等技术的学习奠定扎实基础。<br /><br />1.通俗易懂，细致入微：每个知识点高屋建瓴，深入浅出，简洁明了的说明问题<br />2.具实战性：全程真正代码实战，涵盖上百个企业应用案例及练习<br />3.深入：源码分析，更有 Java 反射、动态代理的实际应用等<br />4.登录尚硅谷官网，技术讲师免费在线答疑</p>','2021-11-05 03:42:01','2021-11-08 11:25:30',0),(9,14,'<p>本套Java视频完全针对零基础学员，课堂实录，自发布以来，好评如潮！Java视频中注重与学生互动，讲授幽默诙谐、细致入微，覆盖Java基础所有核心知识点，同类Java视频中也是代码量大、案例多、实战性强的。同时，本Java视频教程注重技术原理剖析，深入JDK源码，辅以代码实战贯穿始终，用实践驱动理论，并辅以必要的代码练习。</p>','2021-11-05 03:42:16','2021-11-08 11:27:24',0),(10,15,'<p>本套Java视频完全针对零基础学员，课堂实录，自发布以来，好评如潮！Java视频中注重与学生互动，讲授幽默诙谐、细致入微，覆盖Java基础所有核心知识点，同类Java视频中也是代码量大、案例多、实战性强的。同时，本Java视频教程注重技术原理剖析，深入JDK源码，辅以代码实战贯穿始终，用实践驱动理论，并辅以必要的代码练习。</p>','2021-11-05 03:42:32','2021-11-08 11:27:26',0),(11,18,'<p>本套Java视频完全针对零基础学员，课堂实录，自发布以来，好评如潮！Java视频中注重与学生互动，讲授幽默诙谐、细致入微，覆盖Java基础所有核心知识点，同类Java视频中也是代码量大、案例多、实战性强的。同时，本Java视频教程注重技术原理剖析，深入JDK源码，辅以代码实战贯穿始终，用实践驱动理论，并辅以必要的代码练习。</p>','2021-11-05 03:42:51','2021-11-08 11:27:28',0),(12,19,' 数据库就像一棵常青的技能树，无论是初级程序员还是CTO、首席架构师都能从中汲取足够的技术养料。菜鸟往往积累单点技术，如 DML、DDL、存储过程和函数、约束、索引的数据结构，老鸟则需要吃透底层原理，数据库事务ACID如何实现？锁机制与MVCC又是怎么回事？分布式场景下数据库怎么优化保持高性能？\n      知道怎么用是一方面，知道为什么则是更为稀缺的能力。程序员核心能力中至关重要的一点：精通数据库。精通意味着：第一，形成知识网，更灵活地应对突发问题；第二，懂底层原理，更自由地应对复杂多变的业务场景。','2021-11-22 11:09:22','2021-11-22 11:09:22',0);

/*Table structure for table `subject` */

DROP TABLE IF EXISTS `subject`;

CREATE TABLE `subject` (
  `id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '主键',
  `title` varchar(10) NOT NULL COMMENT '类别名称',
  `parent_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '父ID',
  `sort` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '排序字段',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='课程科目';

/*Data for the table `subject` */

insert  into `subject`(`id`,`title`,`parent_id`,`sort`,`create_time`,`update_time`,`is_deleted`) values (1,'后端开发',0,1,'2019-09-29 15:47:25','2019-09-29 15:47:25',0),(2,'Java',1,1,'2019-09-29 15:47:25','2019-09-29 15:47:25',0),(3,'前端开发',0,3,'2019-09-29 15:47:25','2019-09-29 15:47:25',0),(4,'JavaScript',3,4,'2019-09-29 15:47:25','2019-09-29 15:47:25',0),(5,'云计算',0,5,'2019-09-29 15:47:25','2021-11-12 07:13:22',1),(6,'Docker',5,5,'2019-09-29 15:47:25','2019-09-29 15:47:25',0),(7,'Linux',5,6,'2019-09-29 15:47:25','2019-09-29 15:47:25',0),(8,'系统/运维',0,7,'2019-09-29 15:47:25','2021-11-12 07:12:54',1),(9,'Linux',8,7,'2019-09-29 15:47:25','2019-09-29 15:47:25',0),(10,'Windows',8,8,'2019-09-29 15:47:25','2019-09-29 15:47:25',0),(11,'数据库',0,9,'2019-09-29 15:47:25','2019-09-29 15:47:25',0),(12,'MySQL',11,9,'2019-09-29 15:47:25','2019-09-29 15:47:25',0),(13,'MongoDB',11,10,'2019-09-29 15:47:25','2019-09-29 15:47:25',0),(14,'大数据',0,11,'2019-09-29 15:47:25','2019-09-29 15:47:25',0),(15,'Hadoop',14,11,'2019-09-29 15:47:25','2019-09-29 15:47:25',0),(16,'Spark',14,12,'2019-09-29 15:47:25','2019-09-29 15:47:25',0),(17,'人工智能',0,13,'2019-09-29 15:47:25','2021-11-12 03:30:34',1),(18,'Python',17,13,'2019-09-29 15:47:25','2019-09-29 15:47:25',0),(19,'编程语言',0,14,'2019-09-29 15:47:25','2021-11-12 03:29:04',1),(20,'Java',19,14,'2019-09-29 15:47:25','2019-09-29 15:47:25',0),(21,'Python',19,2,'2019-09-30 16:19:22','2019-09-30 16:19:22',0),(22,'HTML/CSS',19,3,'2019-09-30 16:19:22','2019-09-30 16:19:22',0);

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) NOT NULL COMMENT '讲师姓名',
  `intro` varchar(500) NOT NULL DEFAULT '' COMMENT '讲师简介',
  `career` varchar(500) DEFAULT NULL COMMENT '讲师资历,一句话说明讲师',
  `level` int(10) unsigned NOT NULL COMMENT '头衔 1高级讲师 2首席讲师',
  `avatar` varchar(255) DEFAULT NULL COMMENT '讲师头像',
  `sort` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '排序',
  `join_date` date DEFAULT NULL COMMENT '入驻时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='讲师';

/*Data for the table `teacher` */

insert  into `teacher`(`id`,`name`,`intro`,`career`,`level`,`avatar`,`sort`,`join_date`,`create_time`,`update_time`,`is_deleted`) values (1,'张老师','高级讲师','高级讲师',1,'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIB1WtJibSTqXvnJccFhOR1cSpVpdQ3BP5eTPCUO9CyI1feDefMoUFyA4E2C1oe2j8VMLrtAyBricvA/132',0,'2021-11-02','2021-11-05 03:18:36','2021-11-08 01:50:46',0),(2,'李老师','高级讲师','高级讲师',1,'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIB1WtJibSTqXvnJccFhOR1cSpVpdQ3BP5eTPCUO9CyI1feDefMoUFyA4E2C1oe2j8VMLrtAyBricvA/132',0,'2021-11-02','2021-11-05 03:18:51','2021-11-08 01:50:49',0),(4,'钟老师','高级讲师','高级讲师',1,'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIB1WtJibSTqXvnJccFhOR1cSpVpdQ3BP5eTPCUO9CyI1feDefMoUFyA4E2C1oe2j8VMLrtAyBricvA/132',0,'2021-11-02','2021-11-08 05:51:21','2021-11-08 06:24:28',0),(5,'钱老师','钱老师','钱老师',1,'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eo8uwBUP6f5JtibWlkmpPAVjsSsibMaFupwFRyo2Vr5Gkc33uctiasfOFgZADd5X1NYP82bKYjMDbFnA/132',3,'2021-11-01','2021-11-22 13:26:58','2021-11-23 10:26:54',0),(6,'宋老师','宋老师','宋老师',1,'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eo8uwBUP6f5JtibWlkmpPAVjsSsibMaFupwFRyo2Vr5Gkc33uctiasfOFgZADd5X1NYP82bKYjMDbFnA/132',4,'2021-11-02','2021-11-23 10:25:58','2021-11-23 10:26:53',0);

/*Table structure for table `video` */

DROP TABLE IF EXISTS `video`;

CREATE TABLE `video` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `course_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '课程ID',
  `chapter_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '章节ID',
  `title` varchar(50) NOT NULL COMMENT '节点名称',
  `video_source_id` varchar(100) DEFAULT NULL COMMENT '云端视频资源',
  `video_original_name` varchar(100) DEFAULT NULL COMMENT '原始文件名称',
  `sort` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '排序字段',
  `play_count` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '播放次数',
  `is_free` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否可以试听：0收费 1免费',
  `duration` float NOT NULL DEFAULT '0' COMMENT '视频时长（秒）',
  `size` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '视频源文件大小（字节）',
  `version` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT '乐观锁',
  `status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_course_id` (`course_id`),
  KEY `idx_chapter_id` (`chapter_id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='课程视频';

/*Data for the table `video` */

insert  into `video`(`id`,`course_id`,`chapter_id`,`title`,`video_source_id`,`video_original_name`,`sort`,`play_count`,`is_free`,`duration`,`size`,`version`,`status`,`create_time`,`update_time`,`is_deleted`) values (1,18,16,'第一节','3b71d85d93554e7dbb59becdf823f63d','',0,0,1,0,0,1,0,'2021-11-05 03:06:04','2021-12-03 10:17:54',0),(2,14,5,'html基础','3b71d85d93554e7dbb59becdf823f63d','',0,0,1,0,0,1,0,'2021-11-05 03:06:04','2021-12-03 10:17:55',0),(4,18,26,'IO高级','3b71d85d93554e7dbb59becdf823f63d','视频',1,0,1,0,0,1,0,'2021-11-05 03:06:04','2021-12-03 10:17:56',0),(5,18,16,'IO流基础','3b71d85d93554e7dbb59becdf823f63d','视频.mp4',0,0,1,0,0,1,0,'2021-11-05 03:06:04','2021-12-03 10:17:56',0),(6,2,2,'第一课时','3b71d85d93554e7dbb59becdf823f63d','eae2b847ef8503b81f5d5593d769dde2.mp4',0,0,0,0,0,1,0,'2021-11-05 03:06:04','2021-12-03 10:17:58',0),(7,2,2,'第二课时','3b71d85d93554e7dbb59becdf823f63d','eae2b847ef8503b81f5d5593d769dde2.mp4',0,0,0,0,0,1,0,'2021-11-05 03:06:04','2021-12-03 10:17:57',0),(8,2,2,'第三课时','3b71d85d93554e7dbb59becdf823f63d','eae2b847ef8503b81f5d5593d769dde2.mp4',0,0,0,0,0,1,0,'2021-11-05 03:06:04','2021-12-03 10:18:20',0),(9,2,2,'第四课时','3b71d85d93554e7dbb59becdf823f63d','eae2b847ef8503b81f5d5593d769dde2.mp4',0,0,0,0,0,1,0,'2021-11-05 03:06:04','2021-12-03 10:18:20',0),(10,2,2,'第五课时','3b71d85d93554e7dbb59becdf823f63d','eae2b847ef8503b81f5d5593d769dde2.mp4',5,0,0,0,0,1,0,'2021-11-05 03:06:04','2021-12-03 10:18:19',0),(11,3,3,'01-尚硅谷-Flume（课程介绍）','3b71d85d93554e7dbb59becdf823f63d','01-尚硅谷-Flume（课程介绍）.avi',0,0,1,0,0,1,0,'2021-11-05 03:06:04','2021-12-03 10:18:21',0),(12,3,3,'02-尚硅谷-Flume（概念）','3b71d85d93554e7dbb59becdf823f63d','02-尚硅谷-Flume（概念）.avi',1,0,0,0,0,1,0,'2021-11-05 03:06:04','2021-12-03 10:18:21',0),(13,3,3,'03-尚硅谷-Flume（概念）','3b71d85d93554e7dbb59becdf823f63d','03-尚硅谷-Flume（架构）.avi',2,0,0,0,0,1,0,'2021-11-05 03:06:04','2021-12-03 10:18:22',0),(14,4,4,'01_尚硅谷_HBase_课程介绍','3b71d85d93554e7dbb59becdf823f63d','',0,0,1,0,0,1,0,'2021-11-05 03:06:04','2021-12-03 10:18:23',0),(15,4,4,'02_尚硅谷_HBase_介绍','3b71d85d93554e7dbb59becdf823f63d','',0,0,0,0,0,1,0,'2021-11-05 03:06:04','2021-12-03 10:18:23',0),(16,4,4,'03_尚硅谷_HBase_特点','3b71d85d93554e7dbb59becdf823f63d','',0,0,0,0,0,1,0,'2021-11-05 03:06:04','2021-12-03 10:18:24',0),(17,5,7,'01_尚硅谷_Kafka_课程介绍','3b71d85d93554e7dbb59becdf823f63d','',0,0,1,0,0,1,0,'2021-11-05 03:06:04','2021-12-03 10:18:16',0),(18,5,7,'02_尚硅谷_Kafka_消息队列介绍','3b71d85d93554e7dbb59becdf823f63d','',0,0,0,0,0,1,0,'2021-11-05 03:06:04','2021-12-03 10:18:15',0),(19,5,7,'03_尚硅谷_Kafka_概念','3b71d85d93554e7dbb59becdf823f63d','',0,0,0,0,0,1,0,'2021-11-05 03:06:04','2021-12-03 10:18:14',0),(20,14,6,'CSS基础','3b71d85d93554e7dbb59becdf823f63d','',0,0,0,0,0,1,0,'2021-11-05 03:06:04','2021-12-03 10:18:14',0),(21,15,8,'spring mvc基础','3b71d85d93554e7dbb59becdf823f63d','',0,0,1,0,0,1,0,'2021-11-05 03:06:04','2021-12-03 10:18:13',0),(22,15,8,'spring mvc集成','3b71d85d93554e7dbb59becdf823f63d','',0,0,0,0,0,1,0,'2021-11-05 03:06:04','2021-12-03 10:18:13',0),(23,6,9,'01_数仓项目_课程介绍','3b71d85d93554e7dbb59becdf823f63d','',0,0,0,0,0,1,0,'2021-11-05 03:06:04','2021-12-03 10:18:12',0),(24,6,9,'02_数仓项目_采集课程介绍','3b71d85d93554e7dbb59becdf823f63d','',0,0,1,0,0,1,0,'2021-11-05 03:06:04','2021-12-03 10:18:12',0),(25,6,9,'03_数仓项目_数仓概念_业务数据','3b71d85d93554e7dbb59becdf823f63d','',0,0,0,0,0,1,0,'2021-11-05 03:06:04','2021-12-03 10:18:11',0),(26,7,10,'01_尚硅谷_Sqoop_课程介绍','3b71d85d93554e7dbb59becdf823f63d','',0,0,0,0,0,1,0,'2021-11-05 03:06:04','2021-12-03 10:18:10',0),(27,7,10,'02_尚硅谷_Sqoop_安装','3b71d85d93554e7dbb59becdf823f63d','',0,0,1,0,0,1,0,'2021-11-05 03:06:04','2021-12-03 10:18:10',0),(28,7,10,'03_尚硅谷_Sqoop_原理','3b71d85d93554e7dbb59becdf823f63d','',0,0,1,0,0,1,0,'2021-11-05 03:06:04','2021-12-03 10:18:09',0),(29,8,11,'01 - Scala - 语言介绍','3b71d85d93554e7dbb59becdf823f63d','',0,0,1,0,0,1,0,'2021-11-05 03:06:04','2021-12-03 10:18:09',0),(30,8,11,'02 - Scala - map集合','3b71d85d93554e7dbb59becdf823f63d','',0,0,0,0,0,1,0,'2021-11-05 03:06:04','2021-12-03 10:18:08',0),(31,1,12,'01_Spark之课程体系介绍','3b71d85d93554e7dbb59becdf823f63d','',0,0,1,0,0,1,0,'2021-11-05 03:06:04','2021-12-03 10:18:08',0),(32,1,12,'02_Spark之课程原理','3b71d85d93554e7dbb59becdf823f63d','',0,0,0,0,0,1,0,'2021-11-05 03:06:04','2021-12-03 10:18:07',0),(33,18,15,'第一节：Java简介','3b71d85d93554e7dbb59becdf823f63d','1',1,1000,1,100,0,1,0,'2021-11-05 03:06:04','2021-12-01 05:45:14',0),(34,18,15,'第二节：表达式和赋值语句','3b71d85d93554e7dbb59becdf823f63d','7 - How Do I Find Time for My ',2,999,1,100,0,1,0,'2021-11-05 03:06:04','2021-12-03 10:18:06',0),(35,18,15,'第三节：String类','3b71d85d93554e7dbb59becdf823f63d','eae2b847ef8503b81f5d5593d769dde2.mp4',3,888,0,100,0,1,0,'2021-11-05 03:06:04','2021-12-01 05:45:16',0),(36,18,15,'第四节：程序风格','3b71d85d93554e7dbb59becdf823f63d','00-day10总结.avi',4,666,0,100,0,1,0,'2021-11-05 03:06:04','2021-12-01 05:45:17',0),(37,19,65,'mysql安装','3b71d85d93554e7dbb59becdf823f63d',NULL,0,0,1,0,0,1,0,'2021-11-22 11:12:11','2021-12-03 10:18:02',0),(38,19,65,'mysql配置','3b71d85d93554e7dbb59becdf823f63d','3.msyql配置.avi',1,0,1,0,0,1,0,'2021-11-22 11:15:52','2021-12-03 10:18:03',0),(39,19,66,'mysql内部结构','3b71d85d93554e7dbb59becdf823f63d','4.mysql的内部结构.avi',0,0,1,0,0,1,0,'2021-11-22 11:17:34','2021-12-03 10:18:04',0),(40,19,66,'认识索引','3b71d85d93554e7dbb59becdf823f63d','8.认识索引.avi',1,0,0,0,0,1,0,'2021-11-22 11:18:45','2021-12-03 10:18:05',0),(41,19,66,'导入测试数据','a4b66c13cfaf4071bdb7ce988e7d7444','13.导入50w条记录.avi',0,0,0,201.2,0,1,0,'2021-12-16 16:15:59','2021-12-16 16:15:59',0);

/*Table structure for table `video_visitor` */

DROP TABLE IF EXISTS `video_visitor`;

CREATE TABLE `video_visitor` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `course_id` bigint(20) DEFAULT NULL COMMENT '课程id',
  `video_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '视频id',
  `user_id` varchar(50) NOT NULL DEFAULT '0' COMMENT '来访者用户id',
  `nick_name` varchar(100) DEFAULT NULL COMMENT '昵称',
  `join_time` varchar(30) DEFAULT NULL COMMENT '进入时间',
  `leave_time` varchar(30) DEFAULT NULL COMMENT '离开的时间',
  `duration` bigint(20) DEFAULT NULL COMMENT '用户停留的时间(单位：秒)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COMMENT='视频来访者记录表';

/*Data for the table `video_visitor` */

insert  into `video_visitor`(`id`,`course_id`,`video_id`,`user_id`,`nick_name`,`join_time`,`leave_time`,`duration`,`create_time`,`update_time`,`is_deleted`) values (1,19,37,'1','晴天','2021-11-22 21:39:27.089',NULL,4,'2021-11-22 13:39:27','2021-11-22 13:39:27',0),(2,19,38,'1','晴天','2021-11-20 21:39:32.071','2021-11-22 21:44:24.026',696,'2021-11-22 13:39:32','2021-11-25 02:12:41',0),(3,7,26,'1','晴天','2021-11-23 18:09:46.899','2021-11-23 18:10:13.004',5,'2021-11-23 10:09:47','2021-11-23 10:09:47',0),(4,19,38,'24','简','2021-11-23 18:14:53.542',NULL,2,'2021-11-23 10:14:53','2021-11-23 10:14:53',0),(5,19,37,'27','******','2021-11-23 18:54:29.848','2021-11-23 18:54:34.864',3,'2021-11-23 10:54:29','2021-11-23 10:54:29',0),(6,19,37,'1','晴天','2021-11-21 18:55:12.082','2021-11-23 18:56:16.536',33,'2021-11-23 10:55:12','2021-11-25 02:02:25',0),(7,19,38,'1','晴天','2021-11-22 18:55:13.395','2021-11-23 18:56:45.709',706,'2021-11-23 10:55:13','2021-11-25 02:02:31',0),(8,19,37,'1','晴天','2021-11-23 18:56:13.368','2021-11-23 18:58:18.665',13,'2021-11-23 10:56:13','2021-11-23 10:56:13',0),(9,19,39,'1','晴天','2021-11-23 18:56:21.513','2021-11-23 18:56:43.032',313,'2021-11-23 10:56:21','2021-11-25 02:02:12',0),(10,19,40,'1','晴天','2021-11-21 18:56:32.061','2021-11-23 18:56:37.113',202,'2021-11-23 10:56:32','2021-11-25 02:02:55',0),(11,19,40,'1','晴天','2021-11-23 18:58:23.67','2021-11-23 19:38:19.261',114,'2021-11-23 10:58:23','2021-11-23 10:58:23',0),(12,19,40,'1','晴天','2021-11-24 10:11:44.531','2021-11-24 10:11:44.531',115,'2021-11-24 02:11:58','2021-11-25 02:03:06',0),(13,19,38,'1','晴天','2021-11-26 09:11:55.905','2021-11-26 21:05:35.152',943,'2021-11-26 01:12:12','2021-11-26 01:37:30',0),(14,4,15,'1','晴天','2021-11-26 17:07:25.349','2021-11-26 17:07:45.149',304,'2021-11-26 09:07:25','2021-11-26 09:07:25',0),(15,8,30,'1','晴天','2021-11-26 17:14:35.189',NULL,2,'2021-11-26 09:14:35','2021-11-26 09:14:35',0),(16,19,37,'29',NULL,'2021-11-26 18:38:39.719',NULL,3,'2021-11-26 10:38:39','2021-11-26 10:38:39',0),(17,19,38,'1','晴天','2021-11-27 08:02:41.382',NULL,944,'2021-11-27 00:02:41','2021-11-27 00:02:41',0),(18,18,33,'1','晴天','2021-12-01 13:49:37.599',NULL,11,'2021-12-01 05:49:36','2021-12-01 05:49:36',0),(19,18,33,'1','晴天','2021-12-01 13:49:32.6',NULL,6,'2021-12-01 05:49:36','2021-12-01 05:49:36',0),(20,18,33,'1','晴天','2021-12-01 13:49:27.665',NULL,1,'2021-12-01 05:49:37','2021-12-01 05:49:37',0),(21,18,34,'1','晴天','2021-12-01 13:52:02.601','2021-12-01 13:52:14.295',13,'2021-12-01 05:52:02','2021-12-01 05:52:02',0),(22,19,38,'1','晴天','2021-12-16 09:26:31.258',NULL,1,'2021-12-16 09:26:31','2021-12-16 09:26:31',0),(23,19,37,'27','我是','2021-12-28 11:42:31.06',NULL,95,'2021-12-28 11:42:31','2021-12-28 11:42:31',0);

/*Table structure for table `video_visitor_max_view` */

DROP TABLE IF EXISTS `video_visitor_max_view`;

/*!50001 DROP VIEW IF EXISTS `video_visitor_max_view` */;
/*!50001 DROP TABLE IF EXISTS `video_visitor_max_view` */;

/*!50001 CREATE TABLE  `video_visitor_max_view`(
 `max_id` bigint(20) unsigned ,
 `course_id` bigint(20) ,
 `video_id` bigint(20) ,
 `user_id` varchar(50) 
)*/;

/*View structure for view video_visitor_max_view */

/*!50001 DROP TABLE IF EXISTS `video_visitor_max_view` */;
/*!50001 DROP VIEW IF EXISTS `video_visitor_max_view` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`shangguigu`@`%` SQL SECURITY DEFINER VIEW `video_visitor_max_view` AS select max(`video_visitor`.`id`) AS `max_id`,`video_visitor`.`course_id` AS `course_id`,`video_visitor`.`video_id` AS `video_id`,`video_visitor`.`user_id` AS `user_id` from `video_visitor` group by `video_visitor`.`course_id`,`video_visitor`.`video_id`,`video_visitor`.`user_id` */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
```



### 2.2 `Maven` 聚合工程

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664594937539-93463afb-d9d1-4c88-a2b7-848101f682e5.png)

------

- `com.atguigu.ggkt`

| **工程名称**         | **描述**                                       |
| -------------------- | ---------------------------------------------- |
| `ggkt_parent`        | 父工程, `pom` 类型, 统一管理依赖版本和公共依赖 |
| **子模块**           |                                                |
| `modol`              |                                                |
| `service`            | 所有微服务模块, `pom` 工程                     |
| `common`             | 公共模块                                       |
| common 中子模块      |                                                |
| `service_utils`      | 视频点播公共模块                               |
| **service 中子模块** |                                                |
| `service_vod`        | 视频点播                                       |
|                      |                                                |



#### 2.2.1 新建父工程 `ggkt_parent`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664589847927-a8d8d343-f849-4579-a675-12d3bfaa0413.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665206898473-92a6f3e8-d01a-427e-8f38-8c1863d1e4bc.png)

- 删除 `src` 目录
- 修改`SpringBoot` 版本: `2.2.1.RELEASE`
- 修改 `pom.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.2.1.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.atguigu</groupId>
    <artifactId>ggkt_parent</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>ggkt_parent</name>
    <description>Demo project for Spring Boot</description>

    <properties>
        <skipTests>true</skipTests>
        <java.version>1.8</java.version>
        <cloud.version>Hoxton.RELEASE</cloud.version>
        <alibaba.version>2.2.0.RELEASE</alibaba.version>
        <mybatis-plus.version>3.4.1</mybatis-plus.version>
        <mysql.version>5.1.46</mysql.version>
        <swagger.version>2.9.2</swagger.version>
        <jwt.version>0.7.0</jwt.version>
        <fastjson.version>1.2.29</fastjson.version>
        <httpclient.version>4.5.1</httpclient.version>
        <easyexcel.version>2.2.0-beta2</easyexcel.version>
        <aliyun.version>4.5.14</aliyun.version>
        <jodatime.version>2.10.1</jodatime.version>
        <jwt.version>0.7.0</jwt.version>
        <xxl-job.version>2.3.0</xxl-job.version>
        <aliyun.oss.version>3.9.0</aliyun.oss.version>
    </properties>

    <!--配置 dependencyManagement 锁定依赖的版本-->
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>

            <dependency>
                <groupId>com.alibaba.cloud</groupId>
                <artifactId>spring-cloud-alibaba-dependencies</artifactId>
                <version>${alibaba.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>

            <!--mybatis-plus 持久层-->
            <dependency>
                <groupId>com.baomidou</groupId>
                <artifactId>mybatis-plus-boot-starter</artifactId>
                <version>${mybatis-plus.version}</version>
            </dependency>

            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <version>${mysql.version}</version>
            </dependency>

            <dependency>
                <groupId>com.github.xiaoymin</groupId>
                <artifactId>knife4j-spring-boot-starter</artifactId>
                <version>2.0.8</version>
            </dependency>

            <dependency>
                <groupId>io.jsonwebtoken</groupId>
                <artifactId>jjwt</artifactId>
                <version>${jwt.version}</version>
            </dependency>

            <dependency>
                <groupId>org.apache.httpcomponents</groupId>
                <artifactId>httpclient</artifactId>
                <version>${httpclient.version}</version>
            </dependency>

            <dependency>
                <groupId>com.alibaba</groupId>
                <artifactId>fastjson</artifactId>
                <version>${fastjson.version}</version>
            </dependency>

            <dependency>
                <groupId>com.alibaba</groupId>
                <artifactId>easyexcel</artifactId>
                <version>${easyexcel.version}</version>
            </dependency>
            <dependency>
                <groupId>com.aliyun</groupId>
                <artifactId>aliyun-java-sdk-core</artifactId>
                <version>${aliyun.version}</version>
            </dependency>

            <!--aliyunOSS-->
            <dependency>
                <groupId>com.aliyun.oss</groupId>
                <artifactId>aliyun-sdk-oss</artifactId>
                <version>${aliyun.oss.version}</version>
            </dependency>

            <!--日期时间工具-->
            <dependency>
                <groupId>joda-time</groupId>
                <artifactId>joda-time</artifactId>
                <version>${jodatime.version}</version>
            </dependency>

            <dependency>
                <groupId>com.xuxueli</groupId>
                <artifactId>xxl-job-core</artifactId>
                <version>${xxl-job.version}</version>
            </dependency>
            <!--swagger-->
            <dependency>
                <groupId>io.springfox</groupId>
                <artifactId>springfox-swagger2</artifactId>
                <version>${swagger.version}</version>
            </dependency>
            <!--swagger ui-->
            <dependency>
                <groupId>io.springfox</groupId>
                <artifactId>springfox-swagger-ui</artifactId>
                <version>${swagger.version}</version>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>
```



#### 2.2.2 新建子模块 `model`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664593089643-8d8cd590-a89e-49f9-b58b-97e2438d0c66.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665206916401-a9c754b3-7b0e-491b-82f6-f1024fcb8bae.png)

- 追加依赖 `pom.xml`

```xml
<dependencies>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
    </dependency>
    <!--mybatis-plus-->
    <dependency>
        <groupId>com.baomidou</groupId>
        <artifactId>mybatis-plus-boot-starter</artifactId>
        <scope>provided </scope>
    </dependency>
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>easyexcel</artifactId>
        <scope>provided </scope>
    </dependency>
    <dependency>
        <groupId>com.github.xiaoymin</groupId>
        <artifactId>knife4j-spring-boot-starter</artifactId>
        <!--在引用时请在maven中央仓库搜索2.X最新版本号-->
        <scope>provided</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-mongodb</artifactId>
        <scope>provided </scope>
    </dependency>
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>fastjson</artifactId>
        <scope>provided </scope>
    </dependency>
    <!--创建索引库的-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-elasticsearch</artifactId>
        <scope>provided </scope>
    </dependency>
</dependencies>
```

- 复制代码, 粘贴到 `java` 目录下: [📎com.zip](https://www.yuque.com/attachments/yuque/0/2022/zip/12811585/1664593432509-0c7d4fba-6512-493c-811a-034fdea41d90.zip)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664593497194-22c640c0-3d02-48d1-97f5-6b8dd532898a.png)

- 新建空配置文件 `application.yml`
- 新建 `Test` 类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664595172693-d38e06aa-6be3-4bad-9c55-76668905e3f2.png)

```java
package com.atguigu.ggkt;

/**
 * @author 陈江林
 * @date 2022/10/4 05:13
 */
public class Test {
}
```



#### 2.2.3 新建子模块 `service`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665206926128-07283358-58cd-4f0f-9b45-b1b20ea0d3c6.png)

- 删除 `src` 目录
- 追加依赖 `pom.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>ggkt_parent</artifactId>
        <groupId>com.atguigu</groupId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>service</artifactId>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>

    <dependencies>
        <!--数据载体-->
        <dependency>
            <groupId>com.atguigu</groupId>
            <artifactId>model</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>

        <!--web 需要启动项目-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!--mybatis-plus-->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
        </dependency>

        <!--mysql-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>

        <!-- 服务注册 -->
        <!--        <dependency>-->
        <!--            <groupId>com.alibaba.cloud</groupId>-->
        <!--            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>-->
        <!--        </dependency>-->

        <!-- 服务调用feign -->
        <!--        <dependency>-->
        <!--            <groupId>org.springframework.cloud</groupId>-->
        <!--            <artifactId>spring-cloud-starter-openfeign</artifactId>-->
        <!--        </dependency>-->

        <!-- 流量控制 -->
        <!--        <dependency>-->
        <!--            <groupId>com.alibaba.cloud</groupId>-->
        <!--            <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>-->
        <!--        </dependency>-->

        <!--开发者工具-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <optional>true</optional>
        </dependency>
    </dependencies>

</project>
```



#### 2.2.4 新建子模块 `service_vod`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665206933714-d99bd66f-0ee3-45f7-9040-ea133c0b713e.png)

- 新建启动类 `ServiceVodApplication`

```java
package com.atguigu.ggkt.vod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 陈江林
 * @date 2022/10/2 06:27
 */
@SpringBootApplication
public class ServiceVodApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceVodApplication.class, args);
    }

}
```



- 新建配置文件 `application.yml`

```yaml
# 服务端口
server:
  port: 8301

spring:
  application:
    # 服务名
    name: service-vod
  # 环境设置：dev、test、prod
  profiles:
    active: dev
  # mysql数据库连接
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://localhost:3306/glkt_vod?characterEncoding=utf-8&useSSL=false
    username: root
    password: 12345678
  #返回json的全局时间格式
  jackson:
    date-format: yyyy-MM-dd HH:mm:ss
    time-zone: GMT+8

  #mybatis日志
mybatis-plus:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
```



- 新建配置类 `VodConfig`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664663499222-86507aa2-326a-46b8-82ea-4d898ff3da1e.png)

```java
package com.atguigu.ggkt.vod.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 陈江林
 * @date 2022/10/2 06:30
 */
@Configuration
@MapperScan("com.atguigu.ggkt.vod.mapper")
public class VodConfig {
}
```



#### 2.2.5 新建子模块 `common`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665206942489-15eefaf6-02bf-49bc-9d45-68ca73891351.png)

- 追加依赖 `pom.xml`

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <scope>provided </scope>
    </dependency>

    <!--mybatis-plus-->
    <dependency>
        <groupId>com.baomidou</groupId>
        <artifactId>mybatis-plus-boot-starter</artifactId>
        <scope>provided </scope>
    </dependency>

    <!--lombok用来简化实体类：需要安装lombok插件-->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
    </dependency>

    <!--swagger-->
    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-swagger2</artifactId>
    </dependency>
    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-swagger-ui</artifactId>
    </dependency>

    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>fastjson</artifactId>
    </dependency>
</dependencies>
```

- 删除 `src` 目录

#### 2.2.6 新建子模块 `service_utils`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665206949049-21651fe6-2e65-4ab9-9b63-ae56a88a7e90.png)

- 新建空配置文件

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664667696007-5d741a8d-7c69-4ed0-b0fa-2c7af089ebc3.png)

- 新建测试类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664667722401-3204ec9e-bada-4d57-a207-152c4dd81171.png)

```java
package com.atguigu.ggkt;

/**
 * @author 陈江林
 * @date 2022/10/4 05:22
 */
public class Test {
}
```

## 3 `service_vod` 工程中使用 `mp` 的代码生成器

### 3.1 追加依赖

```xml
<dependencies>
    <dependency>
        <groupId>com.baomidou</groupId>
        <artifactId>mybatis-plus-generator</artifactId>
        <version>3.3.1</version>
    </dependency>
    <dependency>
        <groupId>org.apache.velocity</groupId>
        <artifactId>velocity-engine-core</artifactId>
        <version>2.0</version>
    </dependency>
</dependencies>
```



### 3.2 新建 `CodeGet` 类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664832228705-dc89b0d2-e4e6-430c-ba62-57aa8cf67544.png)

```java
package com.atguigu.ggkt;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * 代码生成器
 *
 * @author 陈江林
 * @date 2022/10/1 11:38
 */
public class CodeGet {

    public static void main(String[] args) {

        // 1、创建代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 2、全局配置
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        //gc.setOutputDir(projectPath + "/src/main/java");
        gc.setOutputDir("/Users/chenjianglin/Documents/IdeaProjects/ggkt/ggkt_parent/service/service_vod" + "/src/main/java");

        //去掉Service接口的首字母I
        gc.setServiceName("%sService");
        // 作者
        gc.setAuthor("陈江林");
        gc.setOpen(false);
        mpg.setGlobalConfig(gc);

        // 3、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/glkt_vod");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("12345678");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        // 4、包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.atguigu.ggkt");
        //模块名
        pc.setModuleName("vod");
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);

        // 5、策略配置
        StrategyConfig strategy = new StrategyConfig();

        // 表名
        strategy.setInclude("teacher");
        //数据库表映射到实体的命名策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //数据库表字段映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // lombok 模型 @Accessors(chain = true) setter链式操作
        strategy.setEntityLombokModel(true);
        //restful api风格控制器
        strategy.setRestControllerStyle(true);
        //url中驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);

        mpg.setStrategy(strategy);

        // 6、执行
        mpg.execute();
    }

}
```

- 删除生成的 `entity`, 使用 `model` 模块中的实体类

```java
import com.atguigu.ggkt.model.vod.Teacher;
```

- 修改 `TeacherController`

```java
package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.vod.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-01
 */
@RestController
@RequestMapping("/admin/vod/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

}
```

- 修改 `TeacherService`

```java
package com.atguigu.ggkt.vod.service;

import com.atguigu.ggkt.model.vod.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-01
 */
public interface TeacherService extends IService<Teacher> {

}
```

- 修改 `TeacherServiceImpl`

```java
package com.atguigu.ggkt.vod.service.impl;

import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.ggkt.vod.mapper.TeacherMapper;
import com.atguigu.ggkt.vod.service.TeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-01
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

}
```

- 修改 `TeacherMapper`

```java
package com.atguigu.ggkt.vod.mapper;

import com.atguigu.ggkt.model.vod.Teacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 讲师 Mapper 接口
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-01
 */
public interface TeacherMapper extends BaseMapper<Teacher> {

}
```



## 4 接口

### 4.1 查询所有教师接口, 修改 `TeacherController`

```java
package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.ggkt.vod.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-01
 */
@RestController
@RequestMapping("/admin/vod/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /**
     * 查询所有老师
     *
     * @return {@link List}<{@link Teacher}>
     */
    @GetMapping("/findAll")
    public List<Teacher> findAllTeacher() {
        return teacherService.list();
    }

}
```



### 4.2 逻辑删除教师接口, 修改 `TeacherController`

```java
package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.ggkt.vod.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-01
 */
@RestController
@RequestMapping("/admin/vod/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /**
     * 查询所有老师
     *
     * @return {@link List}<{@link Teacher}>
     */
    @GetMapping("/findAll")
    public List<Teacher> findAllTeacher() {
        return teacherService.list();
    }

    /**
     * 通过 id 删除教师
     *
     * @param id id
     * @return boolean
     */
    @DeleteMapping("/remove/{id}")
    public boolean removeTeacherById(@PathVariable("id") Long id) {
        return teacherService.removeById(id);
    }

}
```

- 整合 `Swagger2` 进行接口测试
- 因为删除讲师接口是 `delete` 提交方式, 使用浏览器无法直接访问测试, 可以通过工具测试, 比如 `Postman`, 也可以通过整合 `Swagger2` 进行测试



## 5 配置 `Swagger2` 生成 `API` 接口文档

### 5.1 概述

- 前后端分离开发中, `api` 文档是最好的沟通方式
- `Swagger2` 是一个规范和完整的框架, 用于生成、描述、调用和可视化 `RESTful` 风格的 `Web` 服务

  - 及时性

    - 接口变更后, 能够及时准确地通知相关前后端开发人员

  - 规范性

    - 保证接口的规范性, 如接口的地址、请求方式、参数及响应格式和错误信息

  - 一致性

    - 接口信息一致, 不会出现因开发人员拿到的文档版本不一致, 而出现分歧

  - 可测性

    - 直接在接口文档上进行测试, 以方便理解业务



### 5.2 配置 `Swagger2`

#### 5.2.1 `service_utils` 工程中

- 新建类 `Swagger2Config`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664667038546-1634ea8b-ea46-48c3-b40a-67bfe9f1e0f4.png)

```java
package com.atguigu.ggkt.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * `@EnableSwagger2` 开启 `Swagger2` 功能
 * 
 * @author 陈江林
 * @date 2022/10/2 07:29
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket webApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("ggkt")
                .apiInfo(webApiInfo())
                .select()
                //只显示api路径下的页面
                //.paths(Predicates.and(PathSelectors.regex("/api/.*")))
                .build();
    }

    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("网站-API文档")
                .description("本文档描述了网站微服务接口定义")
                .version("1.0")
                .contact(new Contact("atguigu", "http://atguigu.com", "atguigu.com"))
                .build();
    }

}
```



#### 5.2.2 `service` 工程中

- 追加依赖

```xml
<!--工具-->
<dependency>
    <groupId>com.atguigu</groupId>
    <artifactId>service_utils</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```



#### 5.2.3 `service_vod` 工程中

- 为了加载 `Swagger2Config` 类, 配置扫描规则 `@ComponentScan(basePackages = "com.atguigu.ggkt")`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664667537651-64f99b94-1b8f-4fc0-876d-b9a1eabf292a.png)

```java
package com.atguigu.ggkt.vod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 陈江林
 * @date 2022/10/2 06:27
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.atguigu.ggkt")
public class ServiceVodApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceVodApplication.class, args);
    }

}
```



### 5.3 使用 `Swagger2`

#### 5.3.1 可视化页面

- 可视化页面, 固定的访问路径: `ip:端口号/swagger-ui.html`
- 访问 `localhost:8301/swagger-ui.html`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664668074192-4ab35a42-740d-4b76-8aca-438de1d2d3d9.png)

- 点击 `**Try it out**`**, 再点击** `**Execute**`

  - **有参数则输入参数**

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664668212277-8bacf026-56a7-4283-9816-152bbca656ab.png)



- 点击 `**Try it out**`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664668235447-4e2cbb1f-440c-4503-9816-2fdf17f6d4f0.png)



- **点击** `**Execute**`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664668271679-1e6b32f0-556b-4a53-ab69-eeca3babe21e.png)



#### 5.3.2 相关注解

| **注解**       | **说明**     |
| -------------- | ------------ |
| `@Api`         | 定义在类上   |
| `@ApiOperatin` | 定义在方法上 |
| `@ApiParam`    | 定义在参数上 |



### 5.4 使用注解

- 修改 `TeacherController`

```java
package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.ggkt.vod.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-01
 */
@Api(tags = "讲师管理接口")
@RestController
@RequestMapping("/admin/vod/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /**
     * 查询所有讲师
     *
     * @return {@link List}<{@link Teacher}>
     */
    @ApiOperation("查询所有讲师")
    @GetMapping("/findAll")
    public List<Teacher> findAllTeacher() {
        return teacherService.list();
    }

    /**
     * 通过 id 逻辑删除讲师
     *
     * @param id id
     * @return boolean
     */
    @ApiOperation("通过 id 逻辑删除讲师")
    @DeleteMapping("/remove/{id}")
    public boolean removeTeacherById(
            @ApiParam(name = "id", value = "ID", required = true)
            @PathVariable("id") Long id) {
        return teacherService.removeById(id);
    }

}
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664674072534-9fc3a6bd-37a4-4e1f-9342-95e234913ebd.png)



## 6 统一返回结果

- 所有接口返回相同格式的 `JSON` 数据

### 6.1 规则

**列表**

```json
{
  "code": 200,
  "message": "成功",
	"data": [
    {
      "id": 2,
      "name": "欧阳老师",
      "intro": "高级讲师":
    }
  ],
  "ok": true
}
```

**分页:**

```json
{
  "code": 200,
  "message": "成功",
  "data": {
    "records": [
      {
        "id": 2,
        "name": "欧阳老师",
        "intro": "高级讲师"
      },
      {
        "id": 4,
        "name": "上官老师",
        "intro": "高级讲师"
      },
      {
        "id": 5,
        "name": "东方老师",
        "intro": "高级老师"
      }
    ],
    "total": 10,
    "size": 3,
    "current": 1,
    "orders": [],
    "hitCount": false,
    "searchCount": true,
    "pages": 2
  },
  "ok": true
}
```

**没有返回数据**

```json
{
  "code": 200,
  "message": "成功",
  "data": null,
  "ok": true
}
```

**失败**

```json
{
  "code": 201,
  "message": "失败",
  "data": null,
  "ok": false
}
```



### 6.2 新建统一返回结果类 `Result`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664832957389-9fb86b0b-ef18-4d9c-a8f3-123081c274d8.png)

```java
package com.atguigu.ggkt.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 结果
 * 统一返回结果类, 全局统一返回结果
 *
 * @author 陈江林
 * @date 2022/10/2 09:36
 */
@ApiModel(value = "全局统一返回结果")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    /**
     * 状态码
     */
    @ApiModelProperty(value = "返回码")
    private Integer code;

    /**
     * 返回消息（成功、失败...）
     */
    @ApiModelProperty(value = "返回消息")
    private String message;

    /**
     * 返回数据
     */
    @ApiModelProperty(value = "返回数据")
    private T data;

    /**
     * 成功的方法, 没有 data 数据
     *
     * @return {@link Result}<{@link T}>
     */
    public static <T> Result<T> ok() {
        return Result.ok(null);
    }

    /**
     * 成功的方法, 有 data 数据
     *
     * @return {@link Result}<{@link T}>
     */
    public static <T> Result<T> ok(T data) {
        return new Result<>(200, "成功", data);
    }

    /**
     * 失败的方法, 没有 data 数据
     *
     * @return {@link Result}<{@link T}>
     */
    public static <T> Result<T> fail() {
        return Result.fail(null);
    }

    /**
     * 失败的方法, 有 data 数据
     *
     * @return {@link Result}<{@link T}>
     */
    public static <T> Result<T> fail(T data) {
        return new Result<>(201, "失败", data);
    }

    /**
     * 修改状态码
     *
     * @param code 状态码
     * @return {@link Result}<{@link T}>
     */
    public Result<T> code(Integer code) {
        this.setCode(code);
        return this;
    }

    /**
     * 修改消息
     *
     * @param message 消息
     * @return {@link Result}<{@link T}>
     */
    public Result<T> message(String message) {
        this.setMessage(message);
        return this;
    }

}
```



### 6.3 使用 `Result`, 修改 `TeacherController`

```java
package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vod.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-01
 */
@Api(tags = "讲师管理接口")
@RestController
@RequestMapping("/admin/vod/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /**
     * 查询所有讲师
     *
     * @return {@link List}<{@link Teacher}>
     */
    @ApiOperation("查询所有讲师")
    @GetMapping("/findAll")
    public Result<List<Teacher>> findAllTeacher() {
        List<Teacher> list = teacherService.list();
        return Result.ok(list).message("查询数据成功");
    }

    /**
     * 通过 id 逻辑删除讲师
     *
     * @param id id
     * @return boolean
     */
    @ApiOperation("通过 id 逻辑删除讲师")
    @DeleteMapping("/remove/{id}")
    public Result removeTeacherById(
            @ApiParam(name = "id", value = "ID", required = true)
            @PathVariable("id") Long id) {
        boolean b = teacherService.removeById(id);
        if (b) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

}
```



## 7 条件分页查询讲师接口

### 7.1 配置`vodConfig`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664767097460-32efb7f1-e478-45fa-89dc-0966757d750f.png)

```java
package com.atguigu.ggkt.vod.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 陈江林
 * @date 2022/10/2 06:30
 */
@Configuration
@MapperScan("com.atguigu.ggkt.vod.mapper")
public class VodConfig {

    /**
     * 分页拦截器
     *
     * @return {@link PaginationInterceptor}
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
    
}
```



### 7.2 查询条件对象 `TeacherQueryVo`

```java
package com.atguigu.ggkt.vo.vod;

import lombok.Data;
import io.swagger.annotations.ApiModelProperty;

@Data
public class TeacherQueryVo {
	
	@ApiModelProperty(value = "讲师姓名")
	private String name;

	@ApiModelProperty(value = "头衔 1高级讲师 2首席讲师")
	private Integer level;

	@ApiModelProperty(value = "入驻时间")
	private String joinDateBegin;

	@ApiModelProperty(value = "入驻时间")
	private String joinDateEnd;


}
```



### 7.3 条件查询分页接口

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664767748027-7afff9f4-e773-4deb-8ff0-9c555ca31bb0.png)

```java
package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vo.vod.TeacherQueryVo;
import com.atguigu.ggkt.vod.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-01
 */
@Api(tags = "讲师管理接口")
@RestController
@RequestMapping("/admin/vod/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /**
     * 查询所有讲师
     *
     * @return {@link List}<{@link Teacher}>
     */
    @ApiOperation("查询所有讲师")
    @GetMapping("/findAll")
    public Result<List<Teacher>> findAllTeacher() {
        List<Teacher> list = teacherService.list();
        return Result.ok(list).message("查询数据成功");
    }

    /**
     * 通过 id 逻辑删除讲师
     *
     * @param id id
     * @return boolean
     */
    @ApiOperation("通过 id 逻辑删除讲师")
    @DeleteMapping("/remove/{id}")
    public Result removeTeacherById(
            @ApiParam(name = "id", value = "ID", required = true)
            @PathVariable("id") Long id) {
        boolean b = teacherService.removeById(id);
        if (b) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }
    
    /**
     * 条件查询分页列表
     *
     * @param current        查询页数
     * @param limit          查询数量
     * @param teacherQueryVo 查询条件对象
     * @return {@link Result}
     */
    @ApiOperation(value = "条件查询分页")
    @GetMapping("/findQueryPage/{current}/{limit}")
    public Result<IPage<Teacher>> index(
            @PathVariable Long current,
            @PathVariable Long limit,
            TeacherQueryVo teacherQueryVo) {
        Page<Teacher> pageParam = new Page<>(current, limit);
        if (null == teacherQueryVo) {
            IPage<Teacher> pageModel = teacherService.page(pageParam);
            return Result.ok(pageModel);
        } else {
            // 获取条件
            String name = teacherQueryVo.getName();
            Integer level = teacherQueryVo.getLevel();
            String joinDateBegin = teacherQueryVo.getJoinDateBegin();
            String joinDateEnd = teacherQueryVo.getJoinDateEnd();
            // 进行非空判断, 条件封装
            LambdaQueryWrapper<Teacher> wrapper = new LambdaQueryWrapper<>();
            if (!StringUtils.isEmpty(name)) {
                wrapper.like(Teacher::getName, name);
            }

            if (!StringUtils.isEmpty(level)) {
                wrapper.eq(Teacher::getLevel, level);
            }

            if (!StringUtils.isEmpty(joinDateBegin)) {
                wrapper.ge(Teacher::getJoinDate, joinDateBegin);
            }

            if (!StringUtils.isEmpty(joinDateEnd)) {
                wrapper.le(Teacher::getJoinDate, joinDateEnd);
            }

            // 调用方法分页查询
            IPage<Teacher> pageModel = teacherService.page(pageParam, wrapper);
            return Result.ok(pageModel);
        }
    }

}
```



## 8 添加讲师接口

```java
/**
 * 新增讲师
 *
 * @param teacher 讲师对象
 * @return {@link Result}
 */
@ApiOperation(value = "新增讲师")
@PostMapping("/save")
public Result saveTeacher(@RequestBody Teacher teacher) {
    // 执行保存操作
    boolean isSuccess = teacherService.save(teacher);
    // 判断是否执行成功
    if (isSuccess) {
        return Result.ok();
    } else {
        return Result.fail();
    }
}
```



## 9 修改讲师接口

```java
/**
 * 修改讲师信息
 *
 * @param teacher 讲师对象
 * @return {@link Result}
 */
@ApiOperation(value = "修改讲师信息")
@PutMapping("/update")
public Result updateTeacher(@RequestBody Teacher teacher) {
    // 执行修改操作
    boolean isSuccess = teacherService.updateById(teacher);
    // 判断是否执行成功
    if (isSuccess) {
        return Result.ok();
    } else {
        return Result.fail();
    }
}
```



### 9.1 根据 `id` 查询讲师接口

```java
/**
 * 根据 id 查询讲师
 *
 * @param id id
 * @return {@link Result}<{@link Teacher}>
 */
@ApiOperation(value = "根据 id 查询讲师")
@GetMapping("/get/{id}")
public Result<Teacher> get(@PathVariable Long id) {
    // 根据 id 获取讲师对象
    Teacher teacher = teacherService.getById(id);
    return Result.ok(teacher);
}
```



## 10 批量删除接口

```java
/**
 * 批量删除讲师
 *
 * @param idList id 列表
 * @return {@link Result}
 */
@ApiOperation(value = "批量删除讲师")
@DeleteMapping("/batch/remove")
public Result batchRemove(@RequestBody List<Long> idList) {
    // 执行删除操作
    boolean isSuccess = teacherService.removeByIds(idList);
    // 判断是否执行成功
    if (isSuccess) {
        return Result.ok();
    } else {
        return Result.fail();
    }
}
```



## 11 统一异常处理

### 11.1 全局异常处理

- 新建异常处理类 `GlobalExceptionHandler`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664770148572-47f4a72a-0241-4896-8c55-52e48d1f4d54.png)

```java
package com.atguigu.ggkt.exception;

import com.atguigu.ggkt.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局统一异常处理
 *    
 * @author 陈江林
 * @date 2022/10/3 12:08
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 全局异常处理
     *
     * @param e e
     * @return {@link Result}
     */
    @ExceptionHandler(Exception.class)
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.fail().message("程序遇到一点点意外! 请稍后再试");
    }

}
```

- 测试

```java
/**
 * 查询所有讲师
 *
 * @return {@link List}<{@link Teacher}>
 */
@ApiOperation("查询所有讲师")
@RequestMapping("/findAll")
public Result<List<Teacher>> findAllTeacher() {
    // 模拟异常
    int i = 10/0;
    
    List<Teacher> list = teacherService.list();
    return Result.ok(list).message("查询数据成功");
}
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664834615229-403b3777-4613-4ae3-a934-2c2e308db861.png)



### 11.2 特定异常处理

```java
/**
 * 特定异常处理
 *
 * @param e e
 * @return {@link Result}
 */
@ExceptionHandler(ArithmeticException.class)
public Result error(ArithmeticException e) {
    e.printStackTrace();
    return Result.fail().message("执行 ArithmeticException 异常处理");
}
```

- 测试

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664834490112-e10b3549-263b-4ec0-b791-638814d9de73.png)



### 11.3 自定义异常处理

#### 11.3.1 自定义异常处理

```java
/**
 * 自定义异常处理
 *
 * @param e e
 * @return {@link Result}
 */
@ExceptionHandler(GgktException.class)
public Result error(GgktException e) {
    e.printStackTrace();
    return Result.fail().code(e.getCode()).message(e.getMsg());
}
```

#### 11.3.2 新建自定义异常类 `GgktException`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664792330145-d7865d40-afa7-418e-91ed-0b48490d144c.png)

```java
package com.atguigu.ggkt.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 自定义异常
 *
 * @author 陈江林
 * @date 2022/10/3 18:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GgktException extends RuntimeException {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 消息
     */
    private String msg;

}
```



#### 11.3.3 测试

```java
// 模拟异常
try {
    int i = 10/0;
} catch (Exception e) {
    // 抛出异常
    throw new GgktException(201, "执行自定义异常处理");
}
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664834371379-7f16b2fd-9b13

# 四 前端基础知识

```
git checkout -b 3.0.0_base
```

## 1 开发工具和 `ES6`

### 1.1 下载

- 下载地址:`https://code.visualstudio.com`



### 1.2 使用 `VS Code`

#### 1.2.2 插件安装

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664838247965-1cda5e7c-6fd5-43c7-8823-fa8c9bb80da8.png)

- `Chinese`
- `Live Server`
- `Vetur`
- `vue-helper`



#### 1.2.3 工作区

1. 创建空文件夹
2. 使用 `vs` 打开空文件夹
3. 把空文件夹保存为工作区

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664838833469-bab36fcd-188b-460b-b2c4-8627fcf35315.png)



#### 1.2.4 新建文件

1. 新建 `test` 文件夹
2. 新建 `01.js` 文件
3. 新建 `001.css` 文件
4. 新建 `hello.html` 文件

- 使用 `!` 号快捷生成 `html` 代码

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664839011444-f0bd3269-b9ed-48ea-ad94-3fb06ce5d4db.png)

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>hello vscode!</h1>
</body>
</html>
```



#### 1.2.5 浏览器访问

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664839102924-400840ac-65bd-44cb-98ff-68988d015794.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664839121637-9d15be57-1b11-4432-bdc8-0eb98d6f3523.png)



#### 1.2.6 自动保存

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664839233500-c01db87b-6766-4579-9a0f-9c10b36c9472.png)



### 1.3 `ES6` 语法

- `ECMAScript 6.0` 简称 `ES6` 是 `JavaScript` 语言的下一代标准, 已经在 2015 年 6 月正式发布了
- 它的目标是使等 `JavaScript` 语言可以用来编写复杂的大型应用程序, 成为企业级开发语言
- `es6` 浏览器兼容性差, 而 `es5` 兼容性很好, 所以在实际开发中, 编写 `es6` 需要使用 `babel` 工具将 `ES6` 转换为 `ES5`

**JavaScript 三大组成部分**

1. `ECMAScritp`: 语句语法规范
2. `BOM`: 浏览器对象模型 - `location`
3. `DOM`: 文档对象模型 - `document`



#### 1.3.1 `let` 声明变量

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664840627921-5b169561-9c42-4b15-bffe-887420989708.png)

**特点**

1. **具有作用范围**
2. **不能重复定义**



```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <script>
        // es6 定义变量 let
        // let 定义变量具有作用范围
        {
            var a = 1
            let b = 2
        }

        console.log(a);
        // b is not defined
        console.log(b);

        // var 可以声明多次
        // let 只能声明一次
        var m = 1
        var m = 2

        let n = 3
        // 报错, 不能重复定义 n
        // let n = 4
        onsole.log(m)  // 2
        console.log(n)  // Identifier 'n' has already been declared
    </script>
</body>
</html>
```



#### 1.3.2 `const` 声明常量（只读变量）

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664840868218-a47d57d1-f7db-4f24-a4c3-b152a317f433.png)

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <script>
        // 常量定义赋值, 不能改变值
        // 错误, 常量必须初始化
        // const p;
        const p = "3.1415926";
        // 错误, 不可修改
        p = 3;
        console.log(p);
    </script>
</body>
</html>
```



#### 1.3.3 03-解构赋值

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <script>
        // 传统方式
        let user = {name: 'luck', age: 20};
        let name1 = user.name;
        let age1 = user.age;
        console.log(name1);
        console.log(age1);

        // es6 写法
        let {name, age} = user;
        console.log(name1);
        console.log(age1);
    </script>
</body>
</html>
```



#### 1.3.4 04-模板字符串

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <script>
        // 模板字符串 ``
        let name = "mary"
        let age = 20
        // 定义方法
        function f1() {
            return "have fun"
        }

        let info = `name is ${name}, age is ${age + 1}, ${f1()}`
        // name is mary, age is 21, have fun
        console.log(info);
    </script>
</body>
</html>
 
```



#### 1.3.5 05-方法简写

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <script>
        // 定义对象, 属性和方法
        const person = {
            // 定义属性
            name: 'lucy',
            // 定义方法
            sayHi() {
                console.log('h1')
            }
        }

        // 获取属性值
        let name1 = person.name
        // lucy
        console.log(name1) 
        // 调用方法
        // hi
        person.sayHi()

    </script>
</body>
</html>
```



#### 1.3.6  06-对象拓展运算符

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <script>
        let person = {name: 'Amy', age: 15}
        let someone = { ...person}
        // {name: 'Amy', age: 15}
        console.log(someone);
    </script>
</body>
</html>
```



#### 1.3.7 07-箭头函数

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <script>
        // 定义方法
        var f1 = function(a) {
            return a
        }

        // 10
        console.log(f1(10));

        // 箭头函数
        var f11 = a => a

        // 20
        console.log(f11(20));

        var f2 = function(a, b) {
            return a + b;
        }

        var f21 = (a, b) => a + b
        // 3
        console.log(f21(1, 2));
    </script>
</body>
</html>
```



## 2 `Vue`

### 2.1 `Vue.js` 是什么

- `Vue` (读音 `/vju/`, 类似于 `view`) 是一套用于构建用户界面的渐进式框架
- `Vue`的核心只关注视图层, 不仅易于上手, 还便于与第三方库或既有项目整合
- 当与现代化工具链以及各种支持类库结合使用时, `Vue` 也完全能够为复杂的单页应用提供驱动

官网: `https://cn.vuejs.org`



### 2.2 初始化 `Vue.js`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664843528892-994da8b2-76fa-433e-a937-24da4e56a628.png)

[📎vue.min.js](https://www.yuque.com/attachments/yuque/0/2022/js/12811585/1664843516540-3559be52-3106-4e39-88c5-7f009cfc015f.js)

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <script src="./vue.min.js"></script>
    <div id="app">
        <!-- 插值表达式 -->
        {{message}}
    </div>
    <script>
        new Vue({
            el: '#app',
            data: {
                message: 'hello vue'
            }
        })
    </script>
</body>
</html>
```

#### ![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664843573417-40a81ab0-b1cd-4237-a001-d324113fac25.png)



### 2.3 配置代码片段

```json
{
    "vue htm": {
        "scope": "html",
        "prefix": "vuehtml",
        "body": [
            "<!DOCTYPE html>",
            "<html lang=\"en\">",
            "",
            "<head>",
            "    <meta charset=\"UTF-8\">",
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">",
            "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">",
            "    <title>Document</title>",
            "</head>",
            "",
            "<body>",
            "    <div id=\"app\">",
            "",
            "    </div>",
            "    <script src=\"vue.min.js\"></script>",
            "    <script>",
            "        new Vue({",
            "            el: '#app',",
            "            data: {",
            "                $1",
            "            }",
            "        })",
            "    </script>",
            "</body>",
            "",
            "</html>",
        ],
        "description": "my vue template in html"
    }
}
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664845143947-83842dfd-b5cb-41c0-bf4e-3ba752b3c452.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664845314785-7214eb6b-d283-49eb-9010-99c2cb410a8b.png)



### 2.4 `Vue` 指令

| **指令**  | **声明** |
| --------- | -------- |
| `v-bind`  | 单项绑定 |
| `v-model` | 双向绑定 |
| `v-on`    | 绑定事件 |
| `v-if`    | 条件判断 |
| `v-for`   | 循环     |

#### 2.4.1 `03-v-bind`

```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>

<body>
    <div id="app">
        <input type="text" v-bind:value="message" />
        <br/>
        <input type="text" :value="message" />
    </div>
    <script src="vue.min.js"></script>
    <script>
        new Vue({
            el: '#app',
            data: {
                message: 'hello vue'
            }
        })
    </script>
</body>

</html>
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664845808242-bdeaa84f-44e9-48df-b01d-0021449609a4.png)



#### 2.4.2 `04-v-model`

```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>

<body>
    <div id="app">
        <input type="text" :value="message">
        <br/>
        {{message}}
        <br/>
        <input type="text" v-model="message">
    </div>
    <script src="vue.min.js"></script>
    <script>
        new Vue({
            el: '#app',
            data: {
                message: 'hello vue'
            }
        })
    </script>
</body>

</html>
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664845908828-4296bc84-8c5f-4dc7-bf35-4c4fb4ad60ea.png)



#### 2.4.3 `05-v-on`

```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>

<body>
<div id="app">
    <input type="button" value="b1" v-on:click="search()" />
    <br/>
    <input type="button" value="b2" @click="search()" />
</div>
<script src="vue.min.js"></script>
<script>
    new Vue({
        el: '#app',
        data: {
            message: ''
        },
        methods: {
            search() {
                console.log('search......');
            }
        }
    })
</script>
</body>

</html>
```



#### 2.4.4 `06-vue-if`

```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>

<body>
    <div id="app">
        <input type="checkbox" v-model="ok" />
        <br/>
        <h1 v-if="ok">选中了</h1>
        <h1 v-else="ok">没有选中</h1>
    </div>
    <script src="vue.min.js"></script>
    <script>
        new Vue({
            el: '#app',
            data: {
                ok: false
            }
        })
    </script>
</body>

</html>
```



#### 2.4.5 `07-v-for`

```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>

<body>
<div id="app">
    <table>
        <tr v-for="(user, index) in userList">
            <td>{{index}}</td>
            <td>{{user.id}}</td>
            <td>{{user.username}}</td>
        </tr>
    </table>
</div>
<script src="vue.min.js"></script>
<script>
    new Vue({
        el: '#app',
        data: {
            userList: [
                {id: 1, username: 'helen'},
                {id: 2, username: 'peter'},
                {id: 3, username: 'andy'}
            ]
        }
    })
</script>
</body>

</html>
```



#### 2.4.6 08-生命周期

```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>

<body>
<div id="app">

</div>
<script src="vue.min.js"></script>
<script>
    new Vue({
        el: '#app',
        data: {},
        // 在渲染之前执行
        created() {
            console.log("created....")
        },
        // 在渲染之后执行
        mounted() {
            console.log("mounted....")
        },
    })
</script>
</body>

</html>
```



#### 2.4.7 09-组件

```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>

<body>
<div id="app">
    <atguigu></atguigu>
</div>
<script src="vue.min.js"></script>
<script>
    new Vue({
        el: '#app',
        data: {},
        // 定义组件
        components: {
            // 组件名称
            atguigu: {
                // 组件内容
                template: '<ul><li>首页</li><li>学员管理</li></ul>'
            }
        }
    })
</script>
</body>

</html>
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664847877452-1977e240-951b-4319-9ed4-be9f747eb541.png)



#### 2.4.8 10-路由

[📎vue-router.min.js](https://www.yuque.com/attachments/yuque/0/2022/js/12811585/1664848062166-6b8ce6a3-c815-45aa-a87e-342668611f08.js)

```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>

<body>
<div id="app">
    <h1>Hello App!</h1>
    <p>
        <!-- 使用 router-link 组件来导航. -->
        <!-- 通过传入 `to` 属性指定链接. -->
        <!-- <router-link> 默认会被渲染成一个 `<a>` 标签 -->
        <router-link to="/">首页</router-link>
        <router-link to="/student">会员管理</router-link>
        <router-link to="/teacher">讲师管理</router-link>
    </p>
    <!-- 路由出口 -->
    <!-- 路由匹配到的组件将渲染在这里 -->
    <router-view></router-view>
</div>
<script src="vue.min.js"></script>
<script src="vue-router.min.js"></script>
<script>
    // 1. 定义（路由）组件。
    // 可以从其他文件 import 进来
    const Welcome = {template: '<div>欢迎</div>'}
    const Student = {template: '<div>student list</div>'}
    const Teacher = {template: '<div>teacher list</div>'}
    // 2. 定义路由
    // 每个路由应该映射一个组件。
    const routes = [
        {path: '/', redirect: '/welcome'}, //设置默认指向的路径
        {path: '/welcome', component: Welcome},
        {path: '/student', component: Student},
        {path: '/teacher', component: Teacher}
    ]
    // 3. 创建 router 实例，然后传 `routes` 配置
    const router = new VueRouter({
        routes // （缩写）相当于 routes: routes
    })
    // 4. 创建和挂载根实例。
    // 从而让整个应用都有路由功能
    const app = new Vue({
        el: '#app',
        router
    })
    // 现在，应用已经启动了！
</script>
</body>

</html>
```



#### 2.4.9 `11-axios`

[📎axios.min.js](https://www.yuque.com/attachments/yuque/0/2022/js/12811585/1664848359804-8a6d98a8-8334-4ecc-bdba-1e0fee98d8e5.js)

```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>

<body>
<div id="app">
    <table>
        <tr v-for="user in userList">
            <td>{{user.name}}</td>
            <td>{{user.age}}</td>
        </tr>
    </table>
</div>
<script src="vue.min.js"></script>
<script src="axios.min.js"></script>
<script>
    new Vue({
        el: '#app',
        data: {
            userList: {}
        },
        created() {
            this.getList()
        },
        methods: {
            getList() {
                axios.get('data.json')
                    // 请求成功
                    .then(response => {
                        console.log(response)
                        this.userList = response.data.data.items
                        console.log(this.userList)
                    })
                    // 请求失败
                    .catch(error => {
                        console.log(error)
                    })
            }
        }
    })
</script>
</body>

</html>
```

- `data.json`

```json
{
  "success": "ok",
  "code": 200,
  "data": {
    "items": [
      {
        "name": "luck",
        "age": 20
      },
      {
        "name": "mary",
        "age": 30
      },
      {
        "name": "jack",
        "age": 40
      }
    ]
  }
}
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664848943394-1b37ebd9-ca83-44af-a9a3-f62f37b17915.png)



### 2.5 `element-ui`

- `element-ui` 是饿了么前端出品的基于 `Vue.js` 的后台组件库, 方便程序员进行页面快速布局和构建
- 官网:

  - 基于 Vue 2.x`https://element-cn.eleme.io/#/zh-CN`
  - 基于 Vue 3.x `https://element-plus.gitee.io/zh-CN/`



## 3 `Node.js`

### 3.1 什么是 `Node.js`

- 简单的说 `Node.js` 就是运行在服务端的 `JavaScript`
- `Node.js` 是一个事件驱动 `I/O` 服务端 `JavaScript` 环境, 基于`Google` 的 `V8` 引擎



### 3.2 `Node.js` 安装

#### 3.2.1 下载

官网: `https://nodejs.org/en/`



### 3.3 入门

- 新建 `app.js`

```javascript
console.log('hello node.js')
```

- 进入窗口输入

```shell
node app.js
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664849810083-da9761f1-ae34-4423-a3b8-66004c69b635.png)



## 4 `NPM`

### 4.1 什么是 `NPM`

- `NPM` 全称 `Node Package Manager`, 是 `Node.js` 包管理工具, 是全球最大的模块生态系统, 里面所有的模块都是开源免费的; 也是 `Node.js` 的包管理工具, 相当于后端的 `Maven`



### 4.2 `NPM` 工具的安装位置

- `Node.js` 默认安装的 `NPM` 包和工具的位置:  `node_modules`
- 查看 `npm` 版本: `npm -v`



### 4.3 使用 `NPM`

1. 建立一个空文件夹 `npmdemo`，在命令提示符进入该文件夹  执行命令初始化

```shell
npm init
```

1. 按照提示输入相关信息，如果是用默认值则直接回车即可。

- `name`: 项目名称
- `version`: 项目版本号
- `description`: 项目描述
- `keywords`: {`Array`}关键词，便于用户搜索到我们的项目
- 最后会生成 `package.json` 文件，这个是包的配置文件，相当于`maven` 的 `pom.xml`

  - 我们之后也可以根据需要进行修改

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664850405230-0c30f38d-3a90-4687-9599-8f9d578d581f.png)

**快捷命令:** `**npm init -y**`

- 都使用默认值



### 4.4 `NPM` 镜像

- `NPM` 官方的管理的包都是从 `http://npmjs.com` 下载的, 国内速度很满
- 推荐使用淘宝 `NPM` 镜像 `http://npm.taobao.org/`

  - 淘宝的 `NPM` 镜像是一个完整的 `npmjs.com` 镜像, 同步频率 10 分钟一次, 尽量保证与官网一致

**设置镜像地址**

```shell
# 之后 npm install 都会从淘宝镜像下载
npm config set registry https://registry.npm.taobao.org 
# 查看 npm 配置信息
npm config list
```



### 4.5 使用 `npm install` 命令

```shell
#使用 npm install 安装依赖包的最新版，
#模块安装的位置：项目目录\node_modules
#安装会自动在项目目录下添加 package-lock.json文件，这个文件帮助锁定安装包的版本
#同时package.json 文件中，依赖包会被添加到dependencies节点下，类似maven中的 <dependencies>
npm install jquery
#npm管理的项目在备份和传输的时候一般不携带node_modules文件夹
npm install #根据package.json中的配置下载依赖，初始化项目
#如果安装时想指定特定的版本
npm install jquery@2.1.x
# 局部安装-开发时依赖
#devDependencies节点：开发时的依赖包，项目打包到生产环境的时候不包含的依赖
#使用 -D参数将依赖添加到devDependencies节点
npm install --save-dev eslint
#或
npm install -D eslint
# 运行时依赖
npm install --save axios

#全局安装
#Node.js全局安装的npm包和工具的位置：用户目录\AppData\Roaming\npm\node_modules
#一些命令行工具常使用全局安装的方式
npm install -g webpack
#或
npm install --global webpack
```

### 4.6 其他命令

```shell
# 更新包（更新到最新版本）
npm update 包名
# 全局更新
npm update -g 包名
# 卸载包
npm uninstall 包名
# 全局卸载
npm uninstall -g 包名
```



## 5 模块化开发

- 后端模块化开发: 三层、类与类之间 对象之间的调用
- 前端模块化开发: `JS` 文件之间的方法调用

  - `ES6` 的模块化无法在 `Node.js` 中执行, 需要用到 `Babel` 转换成 `ES5` 后再执行

### 5.1 `ES5` 写法

- 新建`moduledemo`文件夹执行 `npm init -y`
- 在 `moduledemo` 下创建 `es5` 文件夹
- `moduledemo`

  - `es5`

    - `01.js`

```javascript
const sum = function(a, b) {
  return parseInt(a) + parseInt(b);
}

const subtract = function(a, b) {
  return parseInt(a) - parseInt(b);
}

// 导出 - 设置那些方法可以被其他 js 调用
module.exports = {
  sum,
  subtract
}
```

    - `02.js`

```javascript
// 引入 01 文件
const m = require('./01.js')

// 方法调用
const v1 = m.sum(1, 2)
const v2 = m.subtract(3, 1)

console.log(v1)
console.log(v2)
```

- `node 02.js`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664924596721-dcf04a6f-11cd-4c6c-a4dc-4dc12e54e1ce.png)



### 5.2 `ES6` 写法

- `moduledemo`

  - `es6-1`

    - `001.js`

```javascript
export function add() {
  console.log('add...')
}

export function update() {
  console.log('update...')
}
```

    - `002.js`

```javascript
// 引入
import {add, update} from "./001.js"

// 调用
add()
update()
```

- `node 002.js`: 报错, 不支持 `ES6` 模块化, 需要转换成 `ES5`



### 5.3 `ES6` 转 `ES5`

#### 5.3.1 安装 `Babel`

```shell
npm install -g babel-cli
# 查看是否安装成功
babel --version
```



#### 5.3.2 安装 `Babel` 报错 `Error: EACCES: permission denied`

```shell
sudo npm install -g babel-cli 
```



#### 5.3.3 配置

- `Babel` 的配置文件是 `.babelrc`, 存放在项目的根目录下
- `presets` 字段设定转码规则
- `moduledemo`

  - `.babelrc`

```json
{
  "presets": ["es2015"],
  "plugins": []
}
```



#### 5.3.4 安装转码器

```shell
npm install --save-dev babel-preset-es2015
```

- 转码

```shell
# 创建一个文件夹，转码到这个目录
mkdir bes6-1
# --out-dir 或 -d 参数指定输出目录
babel es6-1 -d bes6-1
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664926787995-56fd5188-ee5b-422f-8588-083d4c8ca498.png)

- `moduledemo`

  - `bes6-1`

    - 生成的 `001.js`

```javascript
'use strict';

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.add = add;
exports.update = update;
function add() {
  console.log('add...');
}

function update() {
  console.log('update...');
}
```

    - 生成的 `002.js`

```javascript
"use strict";

var _ = require("./001.js");

// 调用
(0, _.add)(); // 引入

(0, _.update)();
```

- `node bes6-1/002.js`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664926820334-54abc30b-ba30-4478-a258-543258707f65.png)



### 5.4 `ES6` 第二种写法

- `moduledemo`

  - `es6-2`

    - `1.js`

```javascript
export default {
    list() {
        console.log('list...')
    },
    save() {
        console.log('save...')
    }
}
```

    - `2.js`

```javascript
import user from "./1.js"
user.list()
user.save()
```

- `mkdir bes6-2`
- `babel es6-2 -d bes6-2`
- `node bes6-2/2.js`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664927261729-3d70d936-e7cf-43c9-953f-d8f904b29cc5.png)

#  五 讲师管理模块前端

```
git checkout -b 4.0.0_vue-admin-template
```

## 1  `vue-admin-template` 模板

- `vue-admin-template` 是基于 `vue-element-admin` 的一套后台管理系统基础模板（最少精简版）, 可作为模板进行二次开发
- `GitHub` 模板: `https://github.com/PanjiaChen/vue-admin-template`



## 2 搭建环境

```bash
# 克隆项目
git clone https://github.com/PanJiaChen/vue-admin-template.git

# 进入项目目录
cd vue-admin-template

# 安装依赖
npm install

# 建议不要直接使用 cnpm 安装以来，会有各种诡异的 bug。可以通过如下操作解决 npm 下载速度慢的问题
npm install --registry=https://registry.npm.taobao.org

# 启动服务
npm run dev
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664968088002-3010edb6-c576-4094-bbe9-9fc747a7a3ef.png)



## 3 用户登录退出

### 3.1 请求及数据

- http://localhost:9528/dev-api/vue-admin-template/user/login

```json
{
  "code":20000,
  "data":{"token":"admin-token"}
}
```

- http://localhost:9528/dev-api/vue-admin-template/user/info?token=admin-token

```json
{
  "code":20000,
  "data":
  	{
      "roles":["admin"],
      "introduction":"I am a super administrator",
      "avatar":"https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif",
      "name":"Super Admin"
    }
}
```



### 3.2 后台登录代码

#### 3.2.1 新建 `UserLoginController`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664970533906-d770416a-177e-4f8b-b86f-ee95db4a39ff.png)

```java
@Api(tags = "用户登录")
@RequestMapping("/admin/vod/user")
@RestController
public class UserLoginController {

    
    @PostMapping("/login")
	public Result<Map<String, Object>> login() {
        Map<String, Object> map = new HashMap<>();
        map.put("token", "admin-token");
        return Result.ok(map);
    }

    @GetMapping("/info")
    public Result info() {
        Map<String, Object> map = new HashMap<>();
        map.put("roles", "admin");
        map.put("introduction", "I am a super administrator");
        map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("name", "Super Admin");
        return Result.ok(map);
    }
    
}
```

#### 3.2.2 修改 `Result` 默认成功状态码为 `20000`， 失败 `20001`

```java
package com.atguigu.ggkt.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 结果
 * 统一返回结果类, 全局统一返回结果
 *
 * @author 陈江林
 * @date 2022/10/2 09:36
 */
@ApiModel(value = "全局统一返回结果")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    /**
     * 状态码
     */
    @ApiModelProperty(value = "返回码")
    private Integer code;

    /**
     * 返回消息（成功、失败...）
     */
    @ApiModelProperty(value = "返回消息")
    private String message;

    /**
     * 返回数据
     */
    @ApiModelProperty(value = "返回数据")
    private T data;

    /**
     * 成功的方法, 没有 data 数据
     *
     * @return {@link Result}<{@link T}>
     */
    public static <T> Result<T> ok() {
        return Result.ok(null);
    }

    /**
     * 成功的方法, 有 data 数据
     *
     * @return {@link Result}<{@link T}>
     */
    public static <T> Result<T> ok(T data) {
        return new Result<>(20000, "成功", data);
    }

    /**
     * 失败的方法, 没有 data 数据
     *
     * @return {@link Result}<{@link T}>
     */
    public static <T> Result<T> fail() {
        return Result.fail(null);
    }

    /**
     * 失败的方法, 有 data 数据
     *
     * @return {@link Result}<{@link T}>
     */
    public static <T> Result<T> fail(T data) {
        return new Result<>(20001, "失败", data);
    }

    /**
     * 修改状态码
     *
     * @param code 状态码
     * @return {@link Result}<{@link T}>
     */
    public Result<T> code(Integer code) {
        this.setCode(code);
        return this;
    }

    /**
     * 修改消息
     *
     * @param message 消息
     * @return {@link Result}<{@link T}>
     */
    public Result<T> message(String message) {
        this.setMessage(message);
        return this;
    }

}
```



#### 3.2.3 修改前端请求路径

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664970949565-ac2914f5-84c4-48e5-b6f9-9cb861c342cb.png)

```latex
# just a flag
ENV = 'development'

# base api
#VUE_APP_BASE_API = '/dev-api'
VUE_APP_BASE_API = 'http://localhost:8301'
```



#### 3.2.4 修改前端请求接口

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664971052157-ec27ae07-7670-46d5-9427-e7c46905d2b7.png)

```javascript
import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/admin/vod/user/login',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  return request({
    url: '/admin/vod/user/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/vue-admin-template/user/logout',
    method: 'post'
  })
}
```



#### 3.2.5 测试

前端`npm run dev`

**报错: 跨域问题: 端口号不一致**

- **以下有一个不同都会出现跨域问题**

  - 访问协议: `http` `https`
  - 访问 `ip`
  - 端口号: `9528` `8301`

- 跨域本质: 浏览器对 `ajax` 请求一种限制



**解决**

- `Controller` 添加注解 `@CrossOrigin`

```java
package com.atguigu.ggkt.vod.controller;

import com.atguigu.ggkt.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈江林
 * @date 2022/10/5 19:31
 */
@Api("用户登录")
@RestController
@RequestMapping("/admin/vod/user")
@CrossOrigin
public class UserLoginController {

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public Result<Map<String, Object>> login() {
        Map<String, Object> map = new HashMap<>();
        map.put("token", "admin-token");
        return Result.ok(map);
    }

    @ApiOperation("用户信息")
    @GetMapping("/info")
    public Result<Map<String, Object>> info() {
        Map<String, Object> map = new HashMap<>();
        map.put("roles", "admin");
        map.put("introduction", "I am a super administrator");
        map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("name", "Super Admin");
        return Result.ok(map);
    }

}
```

- `TeacherController`

```java
package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.exception.GgktException;
import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vo.vod.TeacherQueryVo;
import com.atguigu.ggkt.vod.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-01
 */
@Api(tags = "讲师管理接口")
@RestController
@RequestMapping("/admin/vod/teacher")
@CrossOrigin
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /**
     * 查询所有讲师
     *
     * @return {@link List}<{@link Teacher}>
     */
    @ApiOperation("查询所有讲师")
    @GetMapping("/findAll")
    public Result<List<Teacher>> findAllTeacher() {
        // 模拟异常
        try {
            // int i = 10/0;
        } catch (Exception e) {
            // 抛出异常
            throw new GgktException(201, "执行自定义异常处理");
        }

        List<Teacher> list = teacherService.list();
        return Result.ok(list).message("查询数据成功");
    }

    /**
     * 通过 id 逻辑删除讲师
     *
     * @param id id
     * @return boolean
     */
    @ApiOperation("通过 id 逻辑删除讲师")
    @DeleteMapping("/remove/{id}")
    public Result removeTeacherById(
            @ApiParam(name = "id", value = "ID", required = true)
            @PathVariable("id") Long id) {
        boolean b = teacherService.removeById(id);
        if (b) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    /**
     * 条件查询分页列表
     *
     * @param page           查询页数
     * @param limit          查询数量
     * @param teacherQueryVo 查询条件对象
     * @return {@link Result}
     */
    @ApiOperation(value = "获取分页列表")
    @GetMapping("/{page}/{limit}")
    public Result<IPage<Teacher>> index(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,
            @ApiParam(name = "teacherVo", value = "查询对象", required = false)
            @RequestBody(required = false) TeacherQueryVo teacherQueryVo) {
        //创建page对象，传递当前页和每页记录数
        Page<Teacher> pageParam = new Page<>(page, limit);
        //获取条件值
        //讲师名称
        String name = teacherQueryVo.getName();
        //讲师级别
        Integer level = teacherQueryVo.getLevel();
        //开始时间
        String joinDateBegin = teacherQueryVo.getJoinDateBegin();
        //结束时间
        String joinDateEnd = teacherQueryVo.getJoinDateEnd();
        //封装条件
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(name)) {
            wrapper.like("name", name);
        }
        if (!StringUtils.isEmpty(level)) {
            wrapper.eq("level", level);
        }
        if (!StringUtils.isEmpty(joinDateBegin)) {
            wrapper.ge("join_date", joinDateBegin);
        }
        if (!StringUtils.isEmpty(joinDateEnd)) {
            wrapper.le("join_date", joinDateEnd);
        }
        //调用方法得到分页查询结果
        IPage<Teacher> pageModel = teacherService.page(pageParam, wrapper);
        return Result.ok(pageModel);
    }

    /**
     * 新增讲师
     *
     * @param teacher 讲师对象
     * @return {@link Result}
     */
    @ApiOperation(value = "新增讲师")
    @PostMapping("/save")
    public Result saveTeacher(@RequestBody Teacher teacher) {
        // 执行保存操作
        boolean isSuccess = teacherService.save(teacher);
        // 判断是否执行成功
        if (isSuccess) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    /**
     * 修改讲师信息
     *
     * @param teacher 讲师对象
     * @return {@link Result}
     */
    @ApiOperation(value = "修改讲师信息")
    @PutMapping("/update")
    public Result updateTeacher(@RequestBody Teacher teacher) {
        // 执行修改操作
        boolean isSuccess = teacherService.updateById(teacher);
        // 判断是否执行成功
        if (isSuccess) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    /**
     * 根据 id 查询讲师
     *
     * @param id id
     * @return {@link Result}<{@link Teacher}>
     */
    @ApiOperation(value = "根据 id 查询讲师")
    @GetMapping("/get/{id}")
    public Result<Teacher> get(@PathVariable Long id) {
        // 根据 id 获取讲师对象
        Teacher teacher = teacherService.getById(id);
        return Result.ok(teacher);
    }

    /**
     * 批量删除讲师
     *
     * @param idList id 列表
     * @return {@link Result}
     */
    @ApiOperation(value = "批量删除讲师")
    @DeleteMapping("/batch/remove")
    public Result batchRemove(@RequestBody List<Long> idList) {
        // 执行删除操作
        boolean isSuccess = teacherService.removeByIds(idList);
        // 判断是否执行成功
        if (isSuccess) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

}
```



#### 3.2.6 退出

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664973729879-31ccab88-d396-497b-a525-0e563ce5015d.png)

```javascript
  // user logout
  logout({ commit, state }) {
    return new Promise((resolve, reject) => {
      // logout(state.token).then(() => {
      removeToken() // must remove  token  first
      resetRouter()
      commit('RESET_STATE')
      resolve()
      // }).catch(error => {
      //   reject(error)
      // })
    })
  }
```



## 4 安装插件`ESLint`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1664974405068-deb0f4b5-20f0-4c0e-b566-458ee24991fd.png)

`VSCode` 进行扩展设置，依次点击 文件 > 首选项 > 设置

打开 `VSCode` 配置文件(`settings.json`),添加如下配置

```json
    "files.autoSave":"off",
    "eslint.validate": [
       "javascript",
       "javascriptreact",
       "html",
       { "language": "vue", "autoFix": true }
     ],
     "eslint.options": {
        "plugins": ["html"]
     }
```

这样每次保存的时候就可以根据根目录下`.eslintrc.js`你配置的`eslint`规则来检查和做一些简单的`fix`



## 5 讲师前端列表功能

### 5.1 添加讲师路由

- `router` > `index.js` 中

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665111334330-ad2745d7-9696-4f99-9ad5-d466160304db.png)

```javascript
{
  path: '/vod',
  component: Layout,
  redirect: '/vod/teacher/list',
  name: 'vod',
  meta: { title: '点播管理', icon: 'el-icon-s-help' },
  children: [
    {
      path: 'teacher/list',
      name: 'TeacherList',
      component: () => import('@/views/vod/teacher/list'),
      meta: { title: '讲师列表', icon: 'table' }
    },
    {
      path: 'teacher/create',
      name: 'TeacherCreate',
      component: () => import('@/views/vod/teacher/form'),
      meta: { title: '添加讲师', icon: 'tree' }
    }
  ]
},
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665111503785-21aa949f-574c-410f-bf42-18e8e8843c75.png)



### 5.2 新建路由对应的页面

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665113013322-e2ef216d-17a3-4a3e-ad2b-9afc21b2012d.png)

#### 5.2.1 `form`

```vue
<template>
  <div class="app-container">
    讲师表单
  </div>
</template>


<script>
export default {
  name: "form"
}
</script>

<style scoped>

</style>
```



#### 5.2.2 `list`

```vue
<template>
  <div class="app-container">
    讲师列表
  </div>
</template>


<script>
export default {
  name: "list"
}
</script>

<style scoped>

</style>
```



### 5.3 讲师分页列表 `list.vue`

#### 5.3.1 新建请求接口文件 `teacher.js`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665116130877-03cc6e38-7176-42f2-9fb7-0512591bb78d.png)

```javascript
import request from '@/utils/request'

const api_name = '/admin/vod/teacher';
export default {
  // current 当前页, limit 每页记录数, searchObj 条件对象
  getList(current, limit, searchObj) {
    return request({
      url: `${api_name}/${current}/${limit}`,
      method: 'post',
      data: searchObj
    })
  }
}
```



#### 5.3.2 调用请求接口获取并显示数据 `list.vue`







### 5.4 删除讲师

#### 5.4.1 API

```javascript
import request from '@/utils/request'

const api_name = '/admin/vod/teacher';
export default {
  // current 当前页, limit 每页记录数, searchObj 条件对象
  getList(current, limit, params) {
    return request({
      url: `${api_name}/findQueryPage/${current}/${limit}`,
      method: 'get',
      params
    })
  },
  removeById(id) {
    return request({
      url: `${api_name}/remove/${id}`,
      method: 'delete'
    })
  }
}
```



#### 5.4.2 方法

```javascript
// 根据 id 删除数据
removeById(id) {
  this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning'
  }).then(() => {
    return teacherApi.removeById(id)
  }).then((response) => {
    this.getTeacherList()
    this.$message.success(response.message)
  })
}
```



### 5.5 添加讲师

- 注意: 讲师名称(`name`) 是唯一的, 如果`李老师`被删除, 因为是逻辑删除, 所以`添加讲师`时`李老师`是无法添加成功的

#### 5.5.1 API

```javascript
// 讲师添加
saveTeacher(data) {
  return request({
    url: `${api_name}/save`,
    method: 'post',
    data
  })
}
```

####  

#### 5.5.2 `form` 表单

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665223204439-9ea8a8ac-a6b3-4828-9222-fc245b87806e.png)

```vue
<template>
  <div class="app-container">
    <!-- 输入表单 -->
    <el-form label-width="120px">
      <el-form-item label="讲师名称">
        <el-input v-model="teacher.name"/>
      </el-form-item>
      <el-form-item label="入驻时间">
        <el-date-picker v-model="teacher.joinDate" value-format="yyyy-MM-dd"/>
      </el-form-item>
      <el-form-item label="讲师排序">
        <el-input-number v-model="teacher.sort" :min="0"/>
      </el-form-item>
      <el-form-item label="讲师头衔">
        <el-select v-model="teacher.level">
          <!--
            数据类型一定要和取出的json中的一致，否则没法回填
            因此，这里value使用动态绑定的值，保证其数据类型是number
            -->
          <el-option :value="1" label="高级讲师"/>
          <el-option :value="2" label="首席讲师"/>
        </el-select>
      </el-form-item>
      <el-form-item label="讲师简介">
        <el-input v-model="teacher.intro"/>
      </el-form-item>
      <el-form-item label="讲师资历">
        <el-input v-model="teacher.career" :rows="10" type="textarea"/>
      </el-form-item>

      <!-- 讲师头像 -->
      <!--      <el-form-item label="讲师头像">-->
      <!--      </el-form-item>-->

      <el-form-item>
        <el-button type="primary" @click="saveOrUpdate()">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import teacherApi from '@/api/vod/teacher'

export default {
  name: "list",
  created() {
  },
  data() {
    return {
      teacher: {
        sort: 0,
        level: 1
      }
    }
  },
  methods: {
    // 保存数据
    saveOrUpdate() {
      teacherApi.saveTeacher(this.teacher)
        .then(response => {
          // 提示
          this.$message.success("添加成功!");
          // 跳转列表页面
          this.$router.push({path: "/vod/teacher/list"});
        })
    }
  }
}

</script>
```



### 5.6 修改讲师

#### 5.6.1 API

```javascript
import request from '@/utils/request'

const api_name = '/admin/vod/teacher';
export default {
  // current 当前页, limit 每页记录数, searchObj 条件对象
  getList(current, limit, params) {
    return request({
      url: `${api_name}/findQueryPage/${current}/${limit}`,
      method: 'get',
      params
    })
  },
  removeById(id) {
    return request({
      url: `${api_name}/remove/${id}`,
      method: 'delete'
    })
  },
  // 讲师添加
  saveTeacher(data) {
    return request({
      url: `${api_name}/save`,
      method: 'post',
      data
    })
  },
  // 讲师修改
  updateTeacher(data) {
    return request({
      url: `${api_name}/update`,
      method: 'put',
      data
    })
  },
  // 根据 id 获取讲师信息
  getTeacherById(id) {
    return request({
      url: `${api_name}/get/${id}`,
      method: 'get'
    })
  }
}
```



#### 5.6.2 路由

```javascript
{
  path: 'teacher/edit/:id',
  name: 'TeacherEdit',
  component: () => import('@/views/vod/teacher/form'),
  meta: {title: '编辑讲师'},
  hidden: true
}
```



#### 5.6.3 `from.vue` 的修改 - 数据回显

```vue
created() {
  // 获取路径 id 值, 根据 id 查询数据
  const id = this.$route.params.id
  if (id) {
    teacherApi.getTeacherById(id)
      .then(response => {
        this.teacher = response.data
      })
  }
}
```



#### 5.6.4 `from.vue` 的修改 - 修改功能

```javascript
methods: {
  // 添加
  save() {
    teacherApi.saveTeacher(this.teacher)
      .then(response => {
        // 提示
        this.$message.success("添加成功!");
        // 跳转列表页面
        this.$router.push({path: "/vod/teacher/list"});
      })
  },
  // 修改
  update() {
    teacherApi.updateTeacher(this.teacher)
      .then(response => {
        // 提示
        this.$message.success("修改成功!");
        // 跳转列表页面
        this.$router.push({path: "/vod/teacher/list"});
      })
  },
  // 保存或修改
  saveOrUpdate() {
    if (this.teacher.id) {
      this.update()
    } else {
      this.save()
    }
  }
}
```



### 5.7 批量删除

#### 5.7.1 API

```javascript
// 批量删除
batchRemove(data) {
  return request({
    url: `${api_name}/batch/remove`,
    method: 'delete',
    data
  })
}
```



#### 5.7.2 代码

- 在 `el-table` 中添加属性 `@selection-change="handleSelectionChange"`

```vue
<!-- 工具按钮 -->
<el-card class="operate-container" shadow="never">
  <i class="el-icon-tickets" style="margin-top: 5px"></i>
  <span style="margin-top: 5px">数据列表</span>
  <el-button class="btn-add" @click="add()" style="margin-left: 10px;">添加</el-button>
  <el-button class="btn-add" @click="batchRemove()" >批量删除</el-button>
</el-card>
// 复选框触发事件
handleSelectionChange(selection) {
  this.multipleSelection = selection
},
add() {
  // 跳转到添加页面
  this.$router.push({path: "/vod/teacher/create"})
},
// 批量删除
batchRemove() {
  if (this.multipleSelection.length === 0) {
    this.$message.warning('请选择要删除的记录!')
    return
  }
  this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning'
  }).then(() => {
    const idList = []
    // 遍历数组将 id 取出并存储到 idList 中
    this.multipleSelection.forEach(teacher => idList.push(teacher.id))
    // 批量删除
    return teacherApi.batchRemove(idList)
  }).then((response) => {
    this.getTeacherList()
    this.$message.success("批量删除成功")
  })
}
```



## 后台项目打包问题

### 追加依赖

- `model` 工程
- `service_utils` 工程

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <configuration>
                <!-- 取消查找本项目下的Main方法：为了解决Unable to find main class的问题 -->
                <mainClass>none</mainClass>
                <!-- 为了解决依赖模块找不到此模块中的类或属性 -->
                <classifier>execute</classifier>
            </configuration>
            <executions>
                <execution>
                    <goals>
                        <goal>repackage</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

# 六 整合腾讯云对象存储

```
git checkout -b 5.0.0_cos_subject
```



## 1 腾讯云对象存储 `COS`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665289529200-3cdee8cb-f509-4c36-9b84-131f8b42bc3a.png)



- 文档: `https://cloud.tencent.com/document/product/436/10199`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665290564890-b1076c89-b83c-4c4b-ab08-07fc4e72ce3e.png)

### 1.1 开通 `COS`

- 点击`立即使用`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665289558131-e50ec189-9021-477c-a6af-8f7973eaa4e8.png)



### 1.2 创建存储桶

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665291176707-34f48f89-0e11-4e66-869e-2284b7bb8d68.png)

此处为语雀加密文本卡片，点击链接查看：https://www.yuque.com/lingchen-bf1rc/hoahc6/oiumqc#LAtVh

### 1.3 访问管理

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665290371149-fd136231-c3b4-4b52-9446-8dae7fa6b459.png)



### 1.4 秘钥

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665294030878-f8122979-5657-4e2d-b4f8-7740949374cc.png)

此处为语雀加密文本卡片，点击链接查看：https://www.yuque.com/lingchen-bf1rc/hoahc6/oiumqc#zhMCL

### 1.5 `SDK`

```xml
<!-- 腾讯云对象存储 -->
<dependency>
    <groupId>com.qcloud</groupId>
    <artifactId>cos_api</artifactId>
    <version>5.6.75</version>
</dependency>
```



### 1.6 测试上传

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665293776332-6547f053-3856-4b22-8ce8-6c12d0df553a.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665293750121-cb7c7dca-577b-4d2e-baff-7139ffde4790.png)

- `Region` 地域

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665294238303-d97fca74-a4ee-4745-a874-aa51fe68f2d0.png)

```java
package com.atguigu.ggkt;

import com.alibaba.fastjson.JSON;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;

import java.io.File;

/**
 * @author 陈江林
 * @date 2022/10/9 13:34
 */
public class TestCos {

    public static void main(String[] args) {
        // 1 初始化用户身份信息（secretId, secretKey）。
        // SECRETID 和 SECRETKEY请登录访问管理控制台 https://console.cloud.tencent.com/cam/capi 进行查看和管理
        String secretId = "id";
        String secretKey = "key";
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        // 2 设置 bucket 的地域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region("ap-beijing");
        ClientConfig clientConfig = new ClientConfig(region);
        // 这里建议设置使用 https 协议
        // 从 5.6.54 版本开始，默认使用了 https
        clientConfig.setHttpProtocol(HttpProtocol.https);
        // 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);

        // 指定要上传的文件
        File localFile = new File("/Users/chenjianglin/Desktop/01.png");
        // 指定文件将要存放的存储桶
        String bucketName = "ggkt-atguigu-1301043802";
        // 指定文件上传到 COS 上的路径，即对象键。例如对象键为folder/picture.jpg，则表示将文件 picture.jpg 上传到 folder 路径下
        String key = "/2022/01/01.png";
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        // 上传
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        System.out.println(JSON.toJSONString(putObjectResult));
    }

}
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665295001466-99907acf-73d7-4d34-89cb-d6e785082858.png)



## 2 `service_utils` 工程

### 2.1 依赖

```xml
<dependencies>
    <!-- 腾讯云对象存储 -->
    <dependency>
        <groupId>com.qcloud</groupId>
        <artifactId>cos_api</artifactId>
        <version>5.6.75</version>
    </dependency>
</dependencies>
```



### 2.2 新建工具 `GgktUtil`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665303728713-b056bc98-de4d-4aec-a7ee-747fd953c45d.png)

```java
package com.atguigu.ggkt.util;

import com.atguigu.ggkt.result.Result;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.model.StorageClass;
import com.qcloud.cos.region.Region;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 硅谷课堂工具类
 *
 * @author 陈江林
 * @date 2022/10/9 15:30
 */
public class GgktUtil {

    /**
     * 专门负责上传文件到 COS 服务器的工具方法
     *
     * @param bucketName
     * @param region
     * @param bucketDomain
     * @param secretId
     * @param secretKey
     * @param inputStream  要上传文件的输入流
     * @param originalName 要上传文件的原始文件名
     * @return {@link Result}<{@link String}>
     */
    public static Result<String> uploadFilterCos(String bucketName,
                                                 String region,
                                                 String bucketDomain,
                                                 String secretId,
                                                 String secretKey,
                                                 InputStream inputStream,
                                                 String originalName) {
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        Region region1 = new Region(region);
        ClientConfig clientConfig = new ClientConfig(region1);
        // 从 5.6.54 版本开始，默认使用了 https
        clientConfig.setHttpProtocol(HttpProtocol.https);
        // 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);

        // 生成生成文件的目录
        String folderName = new SimpleDateFormat("yyyyMMdd").format(new Date());
        // 使用 UUID 生成文件主体名称
        String fileMainName = UUID.randomUUID().toString().replace("_", "");
        // 从原始文件名中获取文件扩展名
        String extensionName = originalName.substring(originalName.lastIndexOf("."));
        // 使用目录、文件主体名称、文件扩展名称拼接得到对象名称
        String key = folderName + "/" + fileMainName + extensionName;

        try {
            ObjectMetadata objectMetadata = new ObjectMetadata();
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, inputStream, objectMetadata);
            // 设置存储类型（如有需要，不需要请忽略此行代码）, 默认是标准(Standard), 低频(standard_ia)
            putObjectRequest.setStorageClass(StorageClass.Standard_IA);
            // 上传
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
            String cosFileAccessPath = bucketDomain + "/" + key;
            // 返回上传文件的访问路径
            return Result.ok(cosFileAccessPath);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(e.getMessage());
        }
    }

}
```



## 3 `service_vod` 工程

### 3.1 新建 `CosProperties`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665303943821-a1c07cb9-cce2-4ec5-b407-5fa374a49805.png)

```java
package com.atguigu.ggkt.vod.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 腾讯云对象存储 COS 的属性配置文件
 *
 * @author 陈江林
 * @date 2022/10/9 14:36
 */
@Data
@Component
@ConfigurationProperties(prefix = "tencent.cos")
public class CosProperties {

    /**
     * 所属地域
     */
    private String region;

    /**
     * 秘钥标识
     */
    private String secretId;

    /**
     * 秘钥
     */
    private String secretKey;

    /**
     * Bucket 名称
     */
    private String bucketName;

    /**
     * Bucket 域名
     */
    private String bucketDomain;

}
```



### 3.2 配置

```yaml
spring:
  # 上传文件配置
  servlet:
    multipart:
      max-file-size: 1024MB
      max-request-size: 1024MB

# 腾讯云 COS 对象存储
tencent:
  cos:
    region: 所属地域
    secret-id: 访问标识
    secret-key: 访问秘钥
    bucket-name: Bucket 名称
    bucket-domain: Bucket 域名
```

此处为语雀加密文本卡片，点击链接查看：https://www.yuque.com/lingchen-bf1rc/hoahc6/oiumqc#AWFpl



### 3.3 测试上传

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665304155444-d961911d-cc94-4b0e-a18b-c0413a3d694a.png)

```java
package com.atguigu.ggkt;

import com.alibaba.fastjson.JSON;
import com.atguigu.ggkt.vod.config.CosProperties;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author 陈江林
 * @date 2022/10/9 13:34
 */
@SpringBootTest
public class TestCos {

    @Autowired
    private CosProperties cosProperties;

    @org.junit.jupiter.api.Test
    public void TestCos() {
        // 指定要上传的文件
        File localFile = new File("/Users/chenjianglin/Desktop/01.png");
        
        // 1 初始化用户身份信息（secretId, secretKey）。
        // SECRETID 和 SECRETKEY请登录访问管理控制台 https://console.cloud.tencent.com/cam/capi 进行查看和管理
        String secretId = cosProperties.getSecretId();
        String secretKey = cosProperties.getSecretKey();
        // 指定文件将要存放的存储桶
        String bucketName = cosProperties.getBucketName();

        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        // 2 设置 bucket 的地域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region(cosProperties.getRegion());
        ClientConfig clientConfig = new ClientConfig(region);
        // 这里建议设置使用 https 协议
        // 从 5.6.54 版本开始，默认使用了 https
        clientConfig.setHttpProtocol(HttpProtocol.https);
        // 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);

        // 指定文件上传到 COS 上的路径，即对象键。例如对象键为folder/picture.jpg，则表示将文件 picture.jpg 上传到 folder 路径下
        // 生成生成文件的目录
        String folderName = new SimpleDateFormat("yyyyMMdd").format(new Date());
        // 使用 UUID 生成文件主体名称
        String fileMainName = UUID.randomUUID().toString().replace("_", "");
        // 使用目录、文件主体名称、文件扩展名称拼接得到对象名称
        String key = folderName + "/" + fileMainName + ".png";

        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        // 上传
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        System.out.println(JSON.toJSONString(putObjectResult));
    }

}
```



### 3.4 上传接口

#### 3.4.1 新建 `FileUploadController`

```java
package com.atguigu.ggkt.vod.controller;

import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vod.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 陈江林
 * @date 2022/10/9 14:49
 */
@Api(tags = "文件上传接口")
@RestController
@RequestMapping("/admin/vod/file")
public class FileUploadController {

    @Autowired
    private FileService fileService;

    @ApiOperation("文件上传")
    @PostMapping("/upload")
    public Result<String> uploadFile(MultipartFile file) {
        String url = fileService.upload(file);
        return Result.ok(url).message("上传文件成功!");
    }

}
```



#### 3.4.2 新建 `FileService`

```java
package com.atguigu.ggkt.vod.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author 陈江林
 * @date 2022/10/9 14:51
 */
public interface FileService {

    /**
     * 上传文件
     *
     * @param file 文件
     * @return {@link String}
     */
    String upload(MultipartFile file);

}
```



#### 2.4.3 新建 `FileServiceImpl`

```java
package com.atguigu.ggkt.vod.service.impl;

import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.util.GgktUtil;
import com.atguigu.ggkt.vod.config.CosProperties;
import com.atguigu.ggkt.vod.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author 陈江林
 * @date 2022/10/9 14:51
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private CosProperties cosProperties;

    @Override
    public String upload(MultipartFile file) {
        try {
            // 上传文件
            Result<String> result = GgktUtil.uploadFilterCos(cosProperties.getBucketName(),
                    cosProperties.getRegion(),
                    cosProperties.getBucketDomain(),
                    cosProperties.getSecretId(),
                    cosProperties.getSecretKey(),
                    file.getInputStream(),
                    file.getOriginalFilename());
            // 如果上传成功则返回文件路径
            if (result.getMessage().equals(Result.SUCCESS)) {
                return result.getData();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
```



#### 2.4.4 修改 `Result`

```java
public static final String SUCCESS = "成功";
public static final String FAILED = "失败";
package com.atguigu.ggkt.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 结果
 * 统一返回结果类, 全局统一返回结果
 *
 * @author 陈江林
 * @date 2022/10/2 09:36
 */
@ApiModel(value = "全局统一返回结果")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    public static final String SUCCESS = "成功";
    public static final String FAILED = "失败";

    /**
     * 状态码
     */
    @ApiModelProperty(value = "返回码")
    private Integer code;

    /**
     * 返回消息（成功、失败...）
     */
    @ApiModelProperty(value = "返回消息")
    private String message;

    /**
     * 返回数据
     */
    @ApiModelProperty(value = "返回数据")
    private T data;

    /**
     * 成功的方法, 没有 data 数据
     *
     * @return {@link Result}<{@link T}>
     */
    public static <T> Result<T> ok() {
        return Result.ok(null);
    }

    /**
     * 成功的方法, 有 data 数据
     *
     * @return {@link Result}<{@link T}>
     */
    public static <T> Result<T> ok(T data) {
        return new Result<>(20000, SUCCESS, data);
    }

    /**
     * 失败的方法, 没有 data 数据
     *
     * @return {@link Result}<{@link T}>
     */
    public static <T> Result<T> fail() {
        return Result.fail(null);
    }

    /**
     * 失败的方法, 有 data 数据
     *
     * @return {@link Result}<{@link T}>
     */
    public static <T> Result<T> fail(T data) {
        return new Result<>(20001, FAILED, data);
    }

    /**
     * 修改状态码
     *
     * @param code 状态码
     * @return {@link Result}<{@link T}>
     */
    public Result<T> code(Integer code) {
        this.setCode(code);
        return this;
    }

    /**
     * 修改消息
     *
     * @param message 消息
     * @return {@link Result}<{@link T}>
     */
    public Result<T> message(String message) {
        this.setMessage(message);
        return this;
    }

}
```



## 4 上传讲师头像

## 4.1 代码

```vue
      <!-- 讲师头像 -->
      <el-form-item label="讲师头像">
        <el-upload
          class="avatar-uploader"
          action="http://localhost:8301/admin/vod/file/upload"
          :show-file-list="false"
          :on-success="handleAvatarSuccess"
          :on-error="handleAvatarError"
          :before-upload="beforeAvatarUpload">
          <img v-if="teacher.avatar" :src="teacher.avatar" class="avatar">
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
      </el-form-item>
```

- 方法

```javascript
// 上传成功触发
    handleAvatarSuccess(res, file) {
      if (res.code === 20000) {
        this.teacher.avatar = res.data
        // 强制重新渲染
        this.$forceUpdate()
      } else {
        this.$message.error('上传失败（非0）')
      }
    },
    handleAvatarError() {
      this.$message.error('上传失败（http 失败）')
    },
    // 上传之前触发, 用于校验
    beforeAvatarUpload(file) {
      const isJPG = file.type === 'image/jpeg';
      const isLt2M = file.size / 1024 / 1024 < 2;
      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!');
      }

      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!');
      }

      return isJPG && isLt2M;
    }
```

- 样式

```css
<style scoped>
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}

.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}

.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}

.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>
```



## 5 父组件样式作用到子组件

### 5.1 `::v-deep` 修饰符

### 5.2 `/deep/` 修饰符

### 5.3 `>>>` 修饰符

```css
<style scoped>
>>> .avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}

>>> .avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}

.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}

.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>
```



## 修改

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665304123179-db9e824a-1a63-429d-b78c-66779763db8c.png)

```java
package com.atguigu.ggkt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 陈江林
 * @date 2022/10/2 06:27
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.atguigu")
public class ServiceVodApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceVodApplication.class, args);
    }

}
```# 六 整合腾讯云对象存储

```
git checkout -b 5.0.0_cos_subject
```



## 1 腾讯云对象存储 `COS`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665289529200-3cdee8cb-f509-4c36-9b84-131f8b42bc3a.png)



- 文档: `https://cloud.tencent.com/document/product/436/10199`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665290564890-b1076c89-b83c-4c4b-ab08-07fc4e72ce3e.png)

### 1.1 开通 `COS`

- 点击`立即使用`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665289558131-e50ec189-9021-477c-a6af-8f7973eaa4e8.png)



### 1.2 创建存储桶

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665291176707-34f48f89-0e11-4e66-869e-2284b7bb8d68.png)

此处为语雀加密文本卡片，点击链接查看：https://www.yuque.com/lingchen-bf1rc/hoahc6/oiumqc#LAtVh

### 1.3 访问管理

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665290371149-fd136231-c3b4-4b52-9446-8dae7fa6b459.png)



### 1.4 秘钥

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665294030878-f8122979-5657-4e2d-b4f8-7740949374cc.png)

此处为语雀加密文本卡片，点击链接查看：https://www.yuque.com/lingchen-bf1rc/hoahc6/oiumqc#zhMCL

### 1.5 `SDK`

```xml
<!-- 腾讯云对象存储 -->
<dependency>
    <groupId>com.qcloud</groupId>
    <artifactId>cos_api</artifactId>
    <version>5.6.75</version>
</dependency>
```



### 1.6 测试上传

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665293776332-6547f053-3856-4b22-8ce8-6c12d0df553a.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665293750121-cb7c7dca-577b-4d2e-baff-7139ffde4790.png)

- `Region` 地域

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665294238303-d97fca74-a4ee-4745-a874-aa51fe68f2d0.png)

```java
package com.atguigu.ggkt;

import com.alibaba.fastjson.JSON;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;

import java.io.File;

/**
 * @author 陈江林
 * @date 2022/10/9 13:34
 */
public class TestCos {

    public static void main(String[] args) {
        // 1 初始化用户身份信息（secretId, secretKey）。
        // SECRETID 和 SECRETKEY请登录访问管理控制台 https://console.cloud.tencent.com/cam/capi 进行查看和管理
        String secretId = "id";
        String secretKey = "key";
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        // 2 设置 bucket 的地域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region("ap-beijing");
        ClientConfig clientConfig = new ClientConfig(region);
        // 这里建议设置使用 https 协议
        // 从 5.6.54 版本开始，默认使用了 https
        clientConfig.setHttpProtocol(HttpProtocol.https);
        // 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);

        // 指定要上传的文件
        File localFile = new File("/Users/chenjianglin/Desktop/01.png");
        // 指定文件将要存放的存储桶
        String bucketName = "ggkt-atguigu-1301043802";
        // 指定文件上传到 COS 上的路径，即对象键。例如对象键为folder/picture.jpg，则表示将文件 picture.jpg 上传到 folder 路径下
        String key = "/2022/01/01.png";
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        // 上传
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        System.out.println(JSON.toJSONString(putObjectResult));
    }

}
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665295001466-99907acf-73d7-4d34-89cb-d6e785082858.png)



## 2 `service_utils` 工程

### 2.1 依赖

```xml
<dependencies>
    <!-- 腾讯云对象存储 -->
    <dependency>
        <groupId>com.qcloud</groupId>
        <artifactId>cos_api</artifactId>
        <version>5.6.75</version>
    </dependency>
</dependencies>
```



### 2.2 新建工具 `GgktUtil`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665303728713-b056bc98-de4d-4aec-a7ee-747fd953c45d.png)

```java
package com.atguigu.ggkt.util;

import com.atguigu.ggkt.result.Result;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.model.StorageClass;
import com.qcloud.cos.region.Region;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 硅谷课堂工具类
 *
 * @author 陈江林
 * @date 2022/10/9 15:30
 */
public class GgktUtil {

    /**
     * 专门负责上传文件到 COS 服务器的工具方法
     *
     * @param bucketName
     * @param region
     * @param bucketDomain
     * @param secretId
     * @param secretKey
     * @param inputStream  要上传文件的输入流
     * @param originalName 要上传文件的原始文件名
     * @return {@link Result}<{@link String}>
     */
    public static Result<String> uploadFilterCos(String bucketName,
                                                 String region,
                                                 String bucketDomain,
                                                 String secretId,
                                                 String secretKey,
                                                 InputStream inputStream,
                                                 String originalName) {
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        Region region1 = new Region(region);
        ClientConfig clientConfig = new ClientConfig(region1);
        // 从 5.6.54 版本开始，默认使用了 https
        clientConfig.setHttpProtocol(HttpProtocol.https);
        // 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);

        // 生成生成文件的目录
        String folderName = new SimpleDateFormat("yyyyMMdd").format(new Date());
        // 使用 UUID 生成文件主体名称
        String fileMainName = UUID.randomUUID().toString().replace("_", "");
        // 从原始文件名中获取文件扩展名
        String extensionName = originalName.substring(originalName.lastIndexOf("."));
        // 使用目录、文件主体名称、文件扩展名称拼接得到对象名称
        String key = folderName + "/" + fileMainName + extensionName;

        try {
            ObjectMetadata objectMetadata = new ObjectMetadata();
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, inputStream, objectMetadata);
            // 设置存储类型（如有需要，不需要请忽略此行代码）, 默认是标准(Standard), 低频(standard_ia)
            putObjectRequest.setStorageClass(StorageClass.Standard_IA);
            // 上传
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
            String cosFileAccessPath = bucketDomain + "/" + key;
            // 返回上传文件的访问路径
            return Result.ok(cosFileAccessPath);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(e.getMessage());
        }
    }

}
```



## 3 `service_vod` 工程

### 3.1 新建 `CosProperties`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665303943821-a1c07cb9-cce2-4ec5-b407-5fa374a49805.png)

```java
package com.atguigu.ggkt.vod.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 腾讯云对象存储 COS 的属性配置文件
 *
 * @author 陈江林
 * @date 2022/10/9 14:36
 */
@Data
@Component
@ConfigurationProperties(prefix = "tencent.cos")
public class CosProperties {

    /**
     * 所属地域
     */
    private String region;

    /**
     * 秘钥标识
     */
    private String secretId;

    /**
     * 秘钥
     */
    private String secretKey;

    /**
     * Bucket 名称
     */
    private String bucketName;

    /**
     * Bucket 域名
     */
    private String bucketDomain;

}
```



### 3.2 配置

```yaml
spring:
  # 上传文件配置
  servlet:
    multipart:
      max-file-size: 1024MB
      max-request-size: 1024MB

# 腾讯云 COS 对象存储
tencent:
  cos:
    region: 所属地域
    secret-id: 访问标识
    secret-key: 访问秘钥
    bucket-name: Bucket 名称
    bucket-domain: Bucket 域名
```

此处为语雀加密文本卡片，点击链接查看：https://www.yuque.com/lingchen-bf1rc/hoahc6/oiumqc#AWFpl



### 3.3 测试上传

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665304155444-d961911d-cc94-4b0e-a18b-c0413a3d694a.png)

```java
package com.atguigu.ggkt;

import com.alibaba.fastjson.JSON;
import com.atguigu.ggkt.vod.config.CosProperties;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author 陈江林
 * @date 2022/10/9 13:34
 */
@SpringBootTest
public class TestCos {

    @Autowired
    private CosProperties cosProperties;

    @org.junit.jupiter.api.Test
    public void TestCos() {
        // 指定要上传的文件
        File localFile = new File("/Users/chenjianglin/Desktop/01.png");
        
        // 1 初始化用户身份信息（secretId, secretKey）。
        // SECRETID 和 SECRETKEY请登录访问管理控制台 https://console.cloud.tencent.com/cam/capi 进行查看和管理
        String secretId = cosProperties.getSecretId();
        String secretKey = cosProperties.getSecretKey();
        // 指定文件将要存放的存储桶
        String bucketName = cosProperties.getBucketName();

        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        // 2 设置 bucket 的地域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region(cosProperties.getRegion());
        ClientConfig clientConfig = new ClientConfig(region);
        // 这里建议设置使用 https 协议
        // 从 5.6.54 版本开始，默认使用了 https
        clientConfig.setHttpProtocol(HttpProtocol.https);
        // 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);

        // 指定文件上传到 COS 上的路径，即对象键。例如对象键为folder/picture.jpg，则表示将文件 picture.jpg 上传到 folder 路径下
        // 生成生成文件的目录
        String folderName = new SimpleDateFormat("yyyyMMdd").format(new Date());
        // 使用 UUID 生成文件主体名称
        String fileMainName = UUID.randomUUID().toString().replace("_", "");
        // 使用目录、文件主体名称、文件扩展名称拼接得到对象名称
        String key = folderName + "/" + fileMainName + ".png";

        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        // 上传
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        System.out.println(JSON.toJSONString(putObjectResult));
    }

}
```



### 3.4 上传接口

#### 3.4.1 新建 `FileUploadController`

```java
package com.atguigu.ggkt.vod.controller;

import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vod.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 陈江林
 * @date 2022/10/9 14:49
 */
@Api(tags = "文件上传接口")
@RestController
@RequestMapping("/admin/vod/file")
public class FileUploadController {

    @Autowired
    private FileService fileService;

    @ApiOperation("文件上传")
    @PostMapping("/upload")
    public Result<String> uploadFile(MultipartFile file) {
        String url = fileService.upload(file);
        return Result.ok(url).message("上传文件成功!");
    }

}
```



#### 3.4.2 新建 `FileService`

```java
package com.atguigu.ggkt.vod.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author 陈江林
 * @date 2022/10/9 14:51
 */
public interface FileService {

    /**
     * 上传文件
     *
     * @param file 文件
     * @return {@link String}
     */
    String upload(MultipartFile file);

}
```



#### 2.4.3 新建 `FileServiceImpl`

```java
package com.atguigu.ggkt.vod.service.impl;

import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.util.GgktUtil;
import com.atguigu.ggkt.vod.config.CosProperties;
import com.atguigu.ggkt.vod.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author 陈江林
 * @date 2022/10/9 14:51
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private CosProperties cosProperties;

    @Override
    public String upload(MultipartFile file) {
        try {
            // 上传文件
            Result<String> result = GgktUtil.uploadFilterCos(cosProperties.getBucketName(),
                    cosProperties.getRegion(),
                    cosProperties.getBucketDomain(),
                    cosProperties.getSecretId(),
                    cosProperties.getSecretKey(),
                    file.getInputStream(),
                    file.getOriginalFilename());
            // 如果上传成功则返回文件路径
            if (result.getMessage().equals(Result.SUCCESS)) {
                return result.getData();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
```



#### 2.4.4 修改 `Result`

```java
public static final String SUCCESS = "成功";
public static final String FAILED = "失败";
package com.atguigu.ggkt.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 结果
 * 统一返回结果类, 全局统一返回结果
 *
 * @author 陈江林
 * @date 2022/10/2 09:36
 */
@ApiModel(value = "全局统一返回结果")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    public static final String SUCCESS = "成功";
    public static final String FAILED = "失败";

    /**
     * 状态码
     */
    @ApiModelProperty(value = "返回码")
    private Integer code;

    /**
     * 返回消息（成功、失败...）
     */
    @ApiModelProperty(value = "返回消息")
    private String message;

    /**
     * 返回数据
     */
    @ApiModelProperty(value = "返回数据")
    private T data;

    /**
     * 成功的方法, 没有 data 数据
     *
     * @return {@link Result}<{@link T}>
     */
    public static <T> Result<T> ok() {
        return Result.ok(null);
    }

    /**
     * 成功的方法, 有 data 数据
     *
     * @return {@link Result}<{@link T}>
     */
    public static <T> Result<T> ok(T data) {
        return new Result<>(20000, SUCCESS, data);
    }

    /**
     * 失败的方法, 没有 data 数据
     *
     * @return {@link Result}<{@link T}>
     */
    public static <T> Result<T> fail() {
        return Result.fail(null);
    }

    /**
     * 失败的方法, 有 data 数据
     *
     * @return {@link Result}<{@link T}>
     */
    public static <T> Result<T> fail(T data) {
        return new Result<>(20001, FAILED, data);
    }

    /**
     * 修改状态码
     *
     * @param code 状态码
     * @return {@link Result}<{@link T}>
     */
    public Result<T> code(Integer code) {
        this.setCode(code);
        return this;
    }

    /**
     * 修改消息
     *
     * @param message 消息
     * @return {@link Result}<{@link T}>
     */
    public Result<T> message(String message) {
        this.setMessage(message);
        return this;
    }

}
```



## 4 上传讲师头像

## 4.1 代码

```vue
      <!-- 讲师头像 -->
      <el-form-item label="讲师头像">
        <el-upload
          class="avatar-uploader"
          action="http://localhost:8301/admin/vod/file/upload"
          :show-file-list="false"
          :on-success="handleAvatarSuccess"
          :on-error="handleAvatarError"
          :before-upload="beforeAvatarUpload">
          <img v-if="teacher.avatar" :src="teacher.avatar" class="avatar">
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
      </el-form-item>
```

- 方法

```javascript
// 上传成功触发
    handleAvatarSuccess(res, file) {
      if (res.code === 20000) {
        this.teacher.avatar = res.data
        // 强制重新渲染
        this.$forceUpdate()
      } else {
        this.$message.error('上传失败（非0）')
      }
    },
    handleAvatarError() {
      this.$message.error('上传失败（http 失败）')
    },
    // 上传之前触发, 用于校验
    beforeAvatarUpload(file) {
      const isJPG = file.type === 'image/jpeg';
      const isLt2M = file.size / 1024 / 1024 < 2;
      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!');
      }

      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!');
      }

      return isJPG && isLt2M;
    }
```

- 样式

```css
<style scoped>
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}

.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}

.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}

.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>
```



## 5 父组件样式作用到子组件

### 5.1 `::v-deep` 修饰符

### 5.2 `/deep/` 修饰符

### 5.3 `>>>` 修饰符

```css
<style scoped>
>>> .avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}

>>> .avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}

.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}

.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>
```



## 修改

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665304123179-db9e824a-1a63-429d-b78c-66779763db8c.png)

```java
package com.atguigu.ggkt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 陈江林
 * @date 2022/10/2 06:27
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.atguigu")
public class ServiceVodApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceVodApplication.class, args);
    }

}
```

# 七 课堂分类管理模块

```
git checkout -b 6.0.0_subject
```

## 1 课程分类管理模块需求

### 1.1 课程分类列表功能

- 树形显示

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665365443994-1825f20f-2292-43de-b246-06baf8e7dd44.png)

- 官方示例

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665366251381-18e8a33e-be86-433e-8a14-bef2c7e3b8cb.png)

支持树类型的数据的显示。当 row 中包含 children 字段时，被视为树形数据。渲染树形数据时，必须要指定 row-key。支持子节点数据异步加载。设置 Table 的 lazy 属性为 true 与加载函数 load 。通过指定 row 中的 hasChildren 字段来指定哪些行是包含子节点。children 与 hasChildren 都可以通过 tree-props 配置。

```vue
<template>
<div>
  <el-table
    :data="tableData"
    style="width: 100%;margin-bottom: 20px;"
    row-key="id"
    border
    default-expand-all
    :tree-props="{children: 'children', hasChildren: 'hasChildren'}">
    <el-table-column
      prop="date"
      label="日期"
      sortable
      width="180">
    </el-table-column>
    <el-table-column
      prop="name"
      label="姓名"
      sortable
      width="180">
    </el-table-column>
    <el-table-column
      prop="address"
      label="地址">
    </el-table-column>
  </el-table>

  <el-table
    :data="tableData1"
    style="width: 100%"
    row-key="id"
    border
    lazy
    :load="load"
    :tree-props="{children: 'children', hasChildren: 'hasChildren'}">
    <el-table-column
      prop="date"
      label="日期"
      width="180">
    </el-table-column>
    <el-table-column
      prop="name"
      label="姓名"
      width="180">
    </el-table-column>
    <el-table-column
      prop="address"
      label="地址">
    </el-table-column>
  </el-table>
</div>
</template>
<script>
  export default {
    data() {
      return {
        tableData: [{
          id: 1,
          date: '2016-05-02',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          id: 2,
          date: '2016-05-04',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1517 弄'
        }, {
          id: 3,
          date: '2016-05-01',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1519 弄',
          children: [{
              id: 31,
              date: '2016-05-01',
              name: '王小虎',
              address: '上海市普陀区金沙江路 1519 弄'
            }, {
              id: 32,
              date: '2016-05-01',
              name: '王小虎',
              address: '上海市普陀区金沙江路 1519 弄'
          }]
        }, {
          id: 4,
          date: '2016-05-03',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1516 弄'
        }],
        tableData1: [{
          id: 1,
          date: '2016-05-02',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          id: 2,
          date: '2016-05-04',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1517 弄'
        }, {
          id: 3,
          date: '2016-05-01',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1519 弄',
          hasChildren: true
        }, {
          id: 4,
          date: '2016-05-03',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1516 弄'
        }]
      }
    },
    methods: {
      load(tree, treeNode, resolve) {
        setTimeout(() => {
          resolve([
            {
              id: 31,
              date: '2016-05-01',
              name: '王小虎',
              address: '上海市普陀区金沙江路 1519 弄'
            }, {
              id: 32,
              date: '2016-05-01',
              name: '王小虎',
              address: '上海市普陀区金沙江路 1519 弄'
            }
          ])
        }, 1000)
      }
    },
  }
</script>
```

### 1.2 课程分类导出功能

- 导出到 `excel`



### 1.3 课程分类导入功能

- 把 `excel` 添加数据库表



### 1.4 `EasyExcel` 技术





## 2 接口

### 2.1 代码生成器

- `setInclude("subject");`

  - 删除实体类
  - 使用 model 中的实体类

    - `@TableField(exist = false)` 表示数据库中没有该字段

#### 2.1.1 控制器

```java
package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.model.vod.Subject;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vod.service.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程分类 前端控制器
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-10
 */
@Api(tags = "课程分类")
@RestController
@RequestMapping("/admin/vod/subject")
@CrossOrigin
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @ApiOperation("课程分类列表")
    @GetMapping("/getChildSubject/{id}")
    public Result<List<Subject>> getChildSubject(@PathVariable Long id) {
        List<Subject> list = subjectService.selectSubjectList(id);
        return Result.ok(list);
    }

}
```

#### 2.1.2 服务接口

```java
package com.atguigu.ggkt.vod.service;

import com.atguigu.ggkt.model.vod.Subject;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程分类 服务类
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-10
 */
public interface SubjectService extends IService<Subject> {

    /**
     * 查询课程分类列表
     *
     * @param id id
     * @return {@link List}<{@link Subject}>
     */
    List<Subject> selectSubjectList(Long id);
}
```

#### 2.1.3 服务实现类

```java
package com.atguigu.ggkt.vod.service.impl;

import com.atguigu.ggkt.model.vod.Subject;
import com.atguigu.ggkt.vod.mapper.SubjectMapper;
import com.atguigu.ggkt.vod.service.SubjectService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 课程分类 服务实现类
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-10
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    @Override
    public List<Subject> selectSubjectList(Long id) {
        LambdaQueryWrapper<Subject> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Subject::getParentId, id);
        List<Subject> list = baseMapper.selectList(wrapper);
        list.forEach(subject -> {
            // 判断是否有子数据, 如果有设置 hashChildren = true
            Long subjectId = subject.getId();
            // 查询
            boolean isChild = this.isChildren(subjectId);
            subject.setHasChildren(isChild);
        });

        return list;
    }

    /**
     * 判断是否有子数据
     *
     * @param subjectId 对象 id
     * @return boolean
     */
    public boolean isChildren(Long subjectId) {
        LambdaQueryWrapper<Subject> wrapper = new LambdaQueryWrapper();
        wrapper.eq(Subject::getParentId, subjectId);
        Integer count = baseMapper.selectCount(wrapper);
        return count > 0;
    }

}
```



#### 2.1.4 `Mapper` 接口

```xml
package com.atguigu.ggkt.vod.mapper;

import com.atguigu.ggkt.model.vod.Subject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 课程分类 Mapper 接口
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-10
 */
public interface SubjectMapper extends BaseMapper<Subject> {

}
```



## 3 前端显示

### 3.1 第一步 路由

```javascript
  {
    path: '/subject',
    component: Layout,
    redirect: '/subject/list',
    name: '课程分类管理',
    alwaysShow: true,
    meta: {title: '课程分类管理', icon: 'example'},
    children: [
      {
        path: 'list',
        name: '课程分类列表',
        component: () => import('@/views/vod/subject/list'),
        meta: {title: '课程分类列表', icon: 'table'}
      }
    ]
  },
```



### 3.2 第二步 对应的页面

- 新建 `src/views/vod/subject/list.vue`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665377911820-9410bd04-d374-4cd6-ac0b-9ca8644db9ed.png)

```vue
<template>
  <div class="app-container">
    <el-table
      :data="list"
      style="width: 100%"
      row-key="id"
      border
      lazy
      :load="load"
      :tree-props="{children: 'children', hasChildren: 'hasChildren'}">
      <el-table-column
        prop="title"
        label="名称"
        width="180">
      </el-table-column>
      <el-table-column
        prop="createTime"
        label="创建时间"
        width="180">
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import subjectApi from '@/api/vod/subject'

export default {
  name: 'list',
  data() {
    return {
      list: [] //数据字典列表数组
    }
  },
  created() {
    this.getSubList(0)
  },
  methods: {
    //数据字典列表
    getSubList(id) {
      subjectApi.getList(id)
        .then(response => {
          this.list = response.data
        })
    },
    load(tree, treeNode, resolve) {
      subjectApi.getList(tree.id).then(response => {
        resolve(response.data)
      })
    }
  }
}
</script>

<style scoped>

</style>
```



### 3.3 第三步 API 请求接口

- 新建 `src/api/vod/subject.js`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665378024479-30d15157-9112-4e05-9715-65071ef5e9ee.png)

```javascript
import request from '@/utils/request'

const api_name = '/admin/vod/subject';
export default {
  // current 当前页, limit 每页记录数, searchObj 条件对象
  getList(id) {
    return request({
      url: `${api_name}/getChildSubject/${id}`,
      method: 'get'
    })
  }
}
```



## 4 `EasyExcel`

### 4.1 什么是 `EasyExcel`

- `EasyExcel` 是阿里巴巴开源的一个 `excel` 处理框架, **以使用简单, 节省内存著称**
- `EasyExcel` 能大大减少占用内存的注意原因是解析 `Excel` 时没有将文件数据一次性全部加载到内存中, 而是从磁盘上一行行读取数据, 逐个解析



### 4.2 为什么使用 `EasyExcel`（特点）

- `java` 领域解析、生成 `Excel` 比较有名的框架有 `Apache poi`、`jxl` 等。但它们都存在一个严重的问题就是非常的耗内存。如果系统并发量不大的话还可以, 但并发上来后一定会 `OOM` 或者 `JVM` 频繁的 `full gc`
- `EasyExcel` 采用一行一行的解析模式, 并将一行的解析结果及**观察者**的模式通知处理（`AnalysisEventListener`）
- `EasyExcel` 是一个基于 `java` 的简单、省内存的读写 `Excel` 的开源项目。可以在尽可能节约内存的情况下支持读写百 `M` 的 `Excel`
- `03` 版依赖 `POI` 的 `sax` 模式，在上层做了模型转换的封装，让使用者更加简单方便

#### 4.3 怎么使用 `EasyExcel`

#### 4.3.1 第一步 引入依赖

```xml
<!-- 腾讯云 COS 对象存储 -->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>easyexcel</artifactId>
    <version>3.1.1</version>
</dependency>
```



### 4.4 写 `Excel`

```java
/**
 * 最简单的写
 * <p>1. 创建excel对应的实体对象 参照{@link com.alibaba.easyexcel.test.demo.write.DemoData}
 * <p>2. 直接写即可
 */
@Test
public void simpleWrite() {
    String fileName = TestFileUtil.getPath() + "write" + System.currentTimeMillis() + ".xlsx";
    // 这里 需要指定写用哪个class去读，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
    // 如果这里想使用03 则 传入excelType参数即可
    EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(data());
}
```



#### 4.4.1 第一步 创建 `excel` 对应的实体对象

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665380385953-05267d12-02a1-47ea-a234-51bd56c88274.png)

```java
package com.atguigu.ggkt.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * EasyExcel 测试实体类
 *
 * @author 陈江林
 * @date 2022/10/10 13:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @ExcelProperty("用户编号")
    private Integer id;

    @ExcelProperty("用户名称")
    private String name;

}
```



#### 4.4.2 第二步 写入

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665380445848-fa95ac37-335d-4dec-aa28-fbe32546aedc.png)

```java
package com.atguigu.ggkt;

import com.alibaba.excel.EasyExcel;
import com.atguigu.ggkt.excel.User;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试 EasyExcel 写入 Excel
 *
 * @author 陈江林
 * @date 2022/10/10 13:40
 */
public class TestWrite {

    public static void main(String[] args) {
        String fileName = TestWrite.class.getResource("/").getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        System.out.println(fileName);
        EasyExcel.write(fileName, User.class)
                .sheet("模板")
                .doWrite(() -> {
                    // 分页查询数据
                    return data();
                });

        try {
            // 打开文件
            Desktop.getDesktop().open(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<User> data() {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User(i, "lucy" + i);
            list.add(user);
        }

        return list;
    }

}
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665381166537-0df69068-e9d7-4f72-876c-61134f3097fd.png)



### 4.5 读取 `Excel`

- 官方实例

```java
    /**
     * 最简单的读
     * <p>1. 创建excel对应的实体对象 参照{@link DemoData}
     * <p>2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link DemoDataListener}
     * <p>3. 直接读即可
     */
    @Test
    public void simpleRead() {
        String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet().doRead();
    }
```



#### 4.5.1 JDK8+, 新建测试类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665381258861-106cb434-6758-47de-a672-ff19cb88b7bb.png)

```java
package com.atguigu.ggkt;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.fastjson.JSON;
import com.atguigu.ggkt.excel.User;
import lombok.extern.slf4j.Slf4j;

/**
 * 测试 EasyExcel 读取 Excel
 *
 * @author 陈江林
 * @date 2022/10/10 13:53
 */
@Slf4j
public class TestRead {

    public static void main(String[] args) {
        // 写法1：JDK8+ ,不用额外写一个DemoDataListener
        // since: 3.0.0-beta1
        String fileName = "/Users/chenjianglin/IdeaProjects/ggkt/ggkt_parent/service/service_vod/target/test-classes/simpleWrite1665381066271.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        // 这里每次会读取100条数据 然后返回过来 直接调用使用数据就行
        EasyExcel.read(fileName, User.class, new PageReadListener<User>(dataList -> {
            for (User user : dataList) {
                log.info("读取到一条数据{}", JSON.toJSONString(user));
            }
        })).sheet().doRead();
    }

}
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665381487368-99397d65-79f6-4c52-8b55-5fd8c269e48b.png)



## 5 课程分类中的导出功能

### 5.1 实体类 `SubjectEeVo`

### 5.2 控制类

```java
    @ApiOperation("课程分类导出")
    @GetMapping("/exportData")
    public void exportData(HttpServletResponse response) {
        subjectService.exportData(response);
    }
```

### 5.3 服务接口

```java
    /**
     * 导出数据为 Excel 文件
     *
     * @param response 响应
     */
    void exportData(HttpServletResponse response);
```

### 5.4 服务实现

```java
    @Override
    public void exportData(HttpServletResponse response) {
        try {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("课程分类", "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");

            List<Subject> dictList = baseMapper.selectList(null);
            List<SubjectEeVo> dictVoList = new ArrayList<>(dictList.size());
            for (Subject dict : dictList) {
                SubjectEeVo dictVo = new SubjectEeVo();
                BeanUtils.copyProperties(dict, dictVo);
                dictVoList.add(dictVo);
            }

            EasyExcel.write(response.getOutputStream(), SubjectEeVo.class).sheet("课程分类").doWrite(dictVoList);
        } catch (Exception e) {
            throw new GgktException(20001, "导出失败");
        }
    }
```



### 5.5 前端

```html
<div class="el-toolbar">
    <div class="el-toolbar-body" style="justify-content: flex-start;">
      <el-button type="text" @click="exportData"><i class="fa fa-plus"/> 导出</el-button>
    </div>
</div>
```

- 对应的数据

```javascript
data() {
  return {
    basePath: process.env.VUE_APP_BASE_API
  }
}
```

- 对应方法

```javascript
// 导出数据为 Excel 文件
exportData() {
  window.open(this.basePath + "/admin/vod/subject/exportData")
}
```



## 6 课程分类导入

### 6.1 控制类

```java
    @ApiOperation("课程分类导入")
    @PostMapping("/importData")
    public Result importData(MultipartFile file) {
        subjectService.importData(file);
        return Result.ok();
    }
```

### 6.2 服务接口

```java
    /**
     * 导入数据
     *
     * @param file 文件
     */
    void importData(MultipartFile file);
```

### 6.3 服务实现

```java
    @Override
    public void importData(MultipartFile file) {
        try {
            EasyExcel.read(file.getInputStream(), SubjectEeVo.class, new PageReadListener<SubjectEeVo>(dataList -> {
                dataList.forEach(subjectEeVo -> {
                    Subject subject = new Subject();
                    Date date = new Date();
                    subject.setCreateTime(date);
                    subject.setUpdateTime(date);
                    BeanUtils.copyProperties(subjectEeVo, subject);
                    subjectMapper.insert(subject);
                });
            })).sheet().doRead();
        } catch (Exception e) {
            throw new GgktException(20001, "导入失败");
        }
    }
```



### 6.4 前端

```html
<el-button type="text" @click="importData"><i class="fa fa-plus"/> 导入</el-button>
```

- 对应的数据

```javascript
data() {
    return {
        dialogImportVisible: false
    }
},
```

- 对应的方法

```javascript
  	// 上传文件
    onUploadSuccess(response) {
      // 清空上传列表
      this.$refs.upload.clearFiles();
      if (response.code === 20000) {
        this.$message.success('导入成功')
        this.dialogImportVisible = false
        this.getSubList(0)
      } else {
        this.$message.error('导入失败')
      }
    },
    handleError() {
      this.$message.error('上传失败')
    },
    // 上传之前触发
    beforeUpload(file) {
      const isJPG = file.type === 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet';
      const isLt2M = file.size / 1024 < 500;
      if (!isJPG) {
        this.$message.error('上传文件只能是 xls 格式!');
      }

      if (!isLt2M) {
        this.$message.error('上传文件大小不能超过 500KB!');
      }

      return isJPG && isLt2M;
    }
```

- 弹出层

```html
  	<!-- 弹出框 -->
    <el-dialog title="导入" :visible.sync="dialogImportVisible" width="480px">
      <el-form label-position="right" label-width="170px">
        <el-form-item label="文件">
          <el-upload
            ref="upload"
            :multiple="false"
            :on-error="handleError"
            :before-upload="beforeUpload"
            :on-success="onUploadSuccess"
            :action="basePath + '/admin/vod/subject/importData'"
            class="upload-demo">
            <el-button size="small" type="primary">点击上传</el-button>
            <div slot="tip" class="el-upload__tip">只能上传xls文件，且不超过500kb</div>
          </el-upload>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogImportVisible = false">取消</el-button>
      </div>
    </el-dialog>
```



## 知识点

### 代码检查（默认开启）

- 关闭代码检查:`vue.config.js` 文件 `lintOnSve: false`

# 八 点播管理模块

```
git checkout -b 7.0.0_video
```

## 1 点播管理模块需求

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665389316943-f9b5c91c-0686-40ac-a6b4-e8fbbc4ceffb.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665389468053-7b5c4222-bafc-42bd-8805-60787601fef6.png)



## 2 生成代码

```
setInclude("course", "course_description", "chapter", "video")
```

- 删除 `entity`
- 删除 `CourseDescriptionController`
- 修改代码中的实体类



## 3 课程列表

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665449902027-c2ccf561-ab30-4b22-8628-b64f38894130.png)

### 3.1 接口

#### 3.1.1 控制类

```java
package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vo.vod.CourseQueryVo;
import com.atguigu.ggkt.vod.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-11
 */
@Api(tags = "点播课程")
@RestController
@RequestMapping("/admin/vod/course")
@CrossOrigin
public class CourseController {

    @Autowired
    private CourseService courseService;

    @ApiOperation("点播课程列表")
    @GetMapping("/{page}/{limit}")
    public Result<Map<String, Object>> courseList(@PathVariable Long page,
                                                  @PathVariable Long limit,
                                                  CourseQueryVo courseQueryVo) {
        Map<String, Object> map = courseService.findPageCourse(page, limit, courseQueryVo);
        return Result.ok(map);
    }

}
```



#### 3.1.2 服务实现

```java
package com.atguigu.ggkt.vod.service.impl;

import com.atguigu.ggkt.model.vod.Course;
import com.atguigu.ggkt.model.vod.Subject;
import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.ggkt.vo.vod.CourseQueryVo;
import com.atguigu.ggkt.vod.mapper.CourseMapper;
import com.atguigu.ggkt.vod.service.CourseService;
import com.atguigu.ggkt.vod.service.SubjectService;
import com.atguigu.ggkt.vod.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-11
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private SubjectService subjectService;

    @Override
    public Map<String, Object> findPageCourse(Long page, Long limit, CourseQueryVo courseQueryVo) {
        Map<String, Object> map = new HashMap<>();
        Page<Course> pageParam = new Page<>(page, limit);
        LambdaQueryWrapper<Course> wrapper = new LambdaQueryWrapper<>();
        if (courseQueryVo != null) {
            // 获取条件值
            String title = courseQueryVo.getTitle();
            Long subjectId = courseQueryVo.getSubjectId();
            Long subjectParentId = courseQueryVo.getSubjectParentId();
            Long teacherId = courseQueryVo.getTeacherId();

            // 判断条件
            if (!StringUtils.isEmpty(title)) {
                wrapper.like(Course::getTitle, title);
            }

            if (!StringUtils.isEmpty(subjectId)) {
                wrapper.eq(Course::getSubjectId, subjectId);
            }

            if (!StringUtils.isEmpty(subjectParentId)) {
                wrapper.eq(Course::getSubjectParentId, subjectParentId);
            }

            if (!StringUtils.isEmpty(teacherId)) {
                wrapper.eq(Course::getTeacherId, teacherId);
            }
        }

        // 查询数据
        Page<Course> pages = baseMapper.selectPage(pageParam, wrapper);
        Long totalCount = pages.getTotal();
        Long totalPage = pages.getPages();
        List<Course> list = pages.getRecords();

        // 查询数据里面有几个 id
        // 讲师 id, 课程分类 id（一层 和 而层）
        // 获取这些 id 对应的名称, 进行封装, 最终显示
        list.forEach(course -> {
            // 封装数据
            // 根据讲师 id 获取讲师名称
            Teacher teacher = teacherService.getById(course.getTeacherId());
            if (teacher != null) {
                String name = teacher.getName();
                course.getParam().put("teacherName", name);
            }

            // 根据课程分类 id 获取课程分类名称
            Subject subjectOne = subjectService.getById(course.getSubjectParentId());
            if (subjectOne != null) {
                course.getParam().put("subjectParentTitle", subjectOne.getTitle());
            }

            Subject subjectTwo = subjectService.getById(course.getSubjectId());
            if (subjectTwo != null) {
                course.getParam().put("subjectTitle", subjectTwo.getTitle());
            }
        });

        map.put("total", totalCount);
        map.put("page", totalPage);
        map.put("records", list);
        return map;
    }
    
}
```



### 3.2 前端

#### 3.2.1 第一步 路由

```javascript
  // 课程管理
  {
    path: '/vod/course',
    component: Layout,
    redirect: '/vod/course/list',
    name: 'Course',
    meta: {
      title: '点播管理',
      icon: 'el-icon-bank-card'
    },
    alwaysShow: true,
    children: [
      {
        path: 'list',
        name: 'CourseList',
        component: () => import('@/views/vod/course/List'),
        meta: {title: '课程列表', icon: 'table'}
      },
      {
        path: 'info',
        name: 'CourseInfo',
        component: () => import('@/views/vod/course/Form'),
        meta: {title: '发布课程'},
        hidden: true
      },
      {
        path: 'info/:id',
        name: 'CourseInfoEdit',
        component: () => import('@/views/vod/course/Form'),
        meta: {title: '编辑课程'},
        hidden: true
      },
      {
        path: 'chapter/:id',
        name: 'CourseChapterEdit',
        component: () => import('@/views/vod/course/Form'),
        meta: {title: '编辑大纲'},
        hidden: true
      },
      {
        path: 'chart/:id',
        name: 'CourseChart',
        component: () => import('@/views/vod/course/Chart'),
        meta: {title: '课程统计'},
        hidden: true
      }
    ]
  },
```



#### 3.2.2 第二步 创建 `List.vue`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665448604819-204d0f84-e830-4fb0-8f97-7b9681fd6ffc.png)

```vue
<template>
  <div class="app-container">
    <!--查询表单-->
    <el-card class="operate-container" shadow="never">
      <el-form :inline="true" class="demo-form-inline">

        <!-- 所属分类：级联下拉列表 -->
        <!-- 一级分类 -->
        <el-form-item label="课程类别">
          <el-select
            v-model="searchObj.subjectParentId"
            placeholder="请选择"
            @change="subjectLevelOneChanged">
            <el-option
              v-for="subject in subjectList"
              :key="subject.id"
              :label="subject.title"
              :value="subject.id"/>
          </el-select>

          <!-- 二级分类 -->
          <el-select v-model="searchObj.subjectId" placeholder="请选择">
            <el-option
              v-for="subject in subjectLevelTwoList"
              :key="subject.id"
              :label="subject.title"
              :value="subject.id"/>
          </el-select>
        </el-form-item>

        <!-- 标题 -->
        <el-form-item label="课程信息">
          <el-input v-model="searchObj.title" placeholder="课程标题"/>
        </el-form-item>
        <!-- 讲师 -->
        <el-form-item label="讲师">
          <el-select
            v-model="searchObj.teacherId"
            placeholder="请选择讲师">
            <el-option
              v-for="teacher in teacherList"
              :key="teacher.id"
              :label="teacher.name"
              :value="teacher.id"/>
          </el-select>
        </el-form-item>

        <el-button type="primary" icon="el-icon-search" @click="fetchData()">查询</el-button>
        <el-button type="default" @click="resetData()">清空</el-button>
      </el-form>
    </el-card>

    <!-- 工具按钮 -->
    <el-card class="operate-container" shadow="never">
      <i class="el-icon-tickets" style="margin-top: 5px"></i>
      <span style="margin-top: 5px">数据列表</span>
      <el-button class="btn-add" @click="add()">添加</el-button>
    </el-card>

    <!-- 表格 -->
    <el-table :data="list" border stripe>
      <el-table-column label="#" width="50">
        <template slot-scope="scope">
          {{ (page - 1) * limit + scope.$index + 1 }}
        </template>
      </el-table-column>

      <el-table-column label="封面" width="200" align="center">
        <template slot-scope="scope">
          <img :src="scope.row.cover" alt="scope.row.title" width="100%">
        </template>
      </el-table-column>
      <el-table-column label="课程信息">
        <template slot-scope="scope">
          <a href="">{{ scope.row.title }}</a>
          <p>
            分类：{{ scope.row.param.subjectParentTitle }} > {{ scope.row.param.subjectTitle }}
          </p>
          <p>
            课时：{{ scope.row.lessonNum }} /
            浏览：{{ scope.row.viewCount }} /
            付费学员：{{ scope.row.buyCount }}
          </p>
        </template>
      </el-table-column>
      <el-table-column label="讲师" width="100" align="center">
        <template slot-scope="scope">
          {{ scope.row.param.teacherName }}
        </template>
      </el-table-column>
      <el-table-column label="价格(元)" width="100" align="center">
        <template slot-scope="scope">
          <!-- {{ typeof '0' }}  {{ typeof 0 }} {{ '0' == 0 }} -->
          <!-- {{ typeof scope.row.price }}
          {{ typeof Number(scope.row.price) }}
          {{ typeof Number(scope.row.price).toFixed(2) }} -->

          <el-tag v-if="Number(scope.row.price) === 0" type="success">免费</el-tag>

          <!-- 前端解决保留两位小数的问题 -->
          <!-- <el-tag v-else>{{ Number(scope.row.price).toFixed(2) }}</el-tag> -->

          <!-- 后端解决保留两位小数的问题，前端不用处理 -->
          <el-tag v-else>{{ scope.row.price }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="status" label="课程状态" width="100" align="center">
        <template slot-scope="scope">
          <el-tag :type="scope.row.status === 0 ? 'warning' : 'success'">{{
              scope.row.status === 0 ? '未发布' : '已发布'
            }}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column label="发布时间" width="140" align="center">
        <template slot-scope="scope">
          {{ scope.row.createTime ? scope.row.createTime.substr(0, 16) : '' }}
        </template>
      </el-table-column>

      <el-table-column label="操作" width="210" align="center">
        <template slot-scope="scope">
          <router-link :to="'/vod/course/info/'+scope.row.id">
            <el-button type="text" icon="el-icon-edit">修改</el-button>
          </router-link>
          <router-link :to="'/vod/course/chapter/'+scope.row.id">
            <el-button type="text" icon="el-icon-edit">编辑大纲</el-button>
          </router-link>
          <router-link :to="'/vod/course/chart/'+scope.row.id">
            <el-button type="text" icon="el-icon-edit">课程统计</el-button>
          </router-link>
          <el-button type="text" icon="el-icon-delete" @click="removeById(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页组件 -->
    <el-pagination
      :current-page="page"
      :total="total"
      :page-size="limit"
      :page-sizes="[5, 10, 20, 30, 40, 50, 100]"
      style="padding: 30px 0; text-align: center;"
      layout="total, sizes, prev, pager, next, jumper"
      @size-change="changePageSize"
      @current-change="changeCurrentPage"
    />
  </div>
</template>

<script>
import courseApi from '@/api/vod/course'
import teacherApi from '@/api/vod/teacher'
import subjectApi from '@/api/vod/subject'

export default {
  name: "List",
  data() {
    return {
      // 课程列表
      list: [],
      // 总记录数
      total: 0,
      // 页码
      page: 1,
      // 每页记录数
      limit: 10,
      searchObj: {
        // 解决查询表单无法选中二级类别
        subjectId: ''
      },
      /* 查询条件 */
      // 讲师列表
      teacherList: [],
      // 一级分类列表
      subjectList: [],
      // 二级分类列表
      subjectLevelTwoList: []
    }
  },

  created() {
    this.fetchData()
    // 初始化分类列表
    this.initSubjectList()
    // 获取讲师列表
    this.initTeacherList()
  },

  methods: {
    fetchData() {
      courseApi.getPageList(this.page, this.limit, this.searchObj).then(response => {
        this.list = response.data.records
        console.log(this.list)
        this.total = response.data.total
      })
    },

    initTeacherList() {
      teacherApi.getAllTeacher().then(response => {
        this.teacherList = response.data
      })
    },

    initSubjectList() {
      subjectApi.getList(0).then(response => {
        this.subjectList = response.data
      })
    },

    subjectLevelOneChanged(value) {
      subjectApi.getList(value).then(response => {
        this.subjectLevelTwoList = response.data
        this.searchObj.subjectId = ''
      })
    },

    add() {
      // 跳转到 Form 页面
      this.$router.push({path: '/vod/course/info'})
    },

    // 每页记录数改变，size：回调参数，表示当前选中的“每页条数”
    changePageSize(size) {
      this.limit = size
      this.fetchData()
    },

    // 改变页码，page：回调参数，表示当前选中的“页码”
    changeCurrentPage(page) {
      this.page = page
      this.fetchData()
    },

    // 重置表单
    resetData() {
      this.searchObj = {}
      this.subjectLevelTwoList = [] // 二级分类列表
      this.fetchData()
    }
  }
}
</script>

<style scoped>

</style>
```



#### 3.2.3 第三步 API

- 新建 `course.js`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665448576056-0634f1fd-404f-48bb-9b00-ff0d838f216f.png)

```javascript
import request from '@/utils/request'

const api_name = '/admin/vod/course'

export default {
  //课程列表
  getPageList(page, limit, params) {
    return request({
      url: `${api_name}/${page}/${limit}`,
      method: 'get',
      params
    })
  }
}
```

- 追加代码

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665448687265-1c572cda-20dc-41e5-8d14-e4155e27d84b.png)

```javascript
// 获取所有讲师
  getAllTeacher() {
    return request({
      url: `${api_name}/findAll`,
      method: 'get'
    })
  }
```



## 4 课程添加

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665450450829-c39c876f-a37b-4324-bb66-78cda6926e88.png)

### 4.1 接口

#### 4.1.1 控制类 `CourseController`

```java
@ApiOperation("添加课程基本信息")
@PostMapping("/save")
public Result<Long> save(@RequestBody CourseFormVo courseFormVo) {
    Long courseId = courseService.saveCourseInfo(courseFormVo);
    return Result.ok(courseId);
}
```



#### 4.1.2 服务实现

```java
@Override
public Long saveCourseInfo(CourseFormVo courseFormVo) {
    // 添加课程基本信息, 操作 course 表
    Course course = new Course();
    BeanUtils.copyProperties(courseFormVo, course);
    baseMapper.insert(course);
    // 添加课程描述信息, 操作 course_description
    CourseDescription courseDescription = new CourseDescription();
    courseDescription.setDescription(courseFormVo.getDescription());
    // 设置课程的 id
    courseDescription.setId(course.getId());
    courseDescriptionService.save(courseDescription);

    return course.getId();
}
```



### 4.2 前端

#### 4.2.1 `API`

- 追加代码 `course.js`

```javascript
//添加课程基本信息
saveCourseInfo(data) {
  return request({
    url: `${api_name}/save`,
    method: 'post',
    data
  })
}
```



#### 4.2.2 `List.vue` 关键代码

```javascript
add() {
  // 跳转到 Form 页面
  this.$router.push({path: '/vod/course/info'})
},
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665450426483-532cb2e8-4f31-44fd-a3b2-7921b2120cd5.png)



#### 4.2.3 新建 `Form.vue` 页面

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665449160991-d8a5f6ec-ab20-4f56-bc56-55ebfe0d1bff.png)

```vue
<template>
  <div class="app-container">
    <h2 style="text-align: center;">发布新课程</h2>
    <el-steps :active="active" finish-status="success" simple style="margin-bottom: 40px">
      <el-step title="填写课程基本信息"/>
      <el-step title="创建课程大纲"/>
      <el-step title="发布课程"/>
    </el-steps>
    <!-- 填写课程基本信息 -->
    <info v-if="active === 0"/>
    <!-- 创建课程大纲 -->
    <chapter v-if="active === 1"/>
    <!-- 发布课程 -->
    <Publish v-if="active === 2 || active === 3"/>
  </div>
</template>

<script>
// 引入子组件
import Info from '@/views/vod/course/components/Info'
import Chapter from '@/views/vod/course/components/Chapter'
import Publish from '@/views/vod/course/components/Publish'

export default {
  name: "Form",
  // 注册子组件
  components: {Info, Chapter, Publish},
  data() {
    return {
      active: 0,
      courseId: null
    }
  },
  created() {
    // 获取路由id
    if (this.$route.params.id) {
      this.courseId = this.$route.params.id
    }

    if (this.$route.name === 'CourseInfoEdit') {
      this.active = 0
    }

    if (this.$route.name === 'CourseChapterEdit') {
      this.active = 1
    }
  }
}
</script>

<style scoped>

</style>
```

- 新建 `components/Info` 页面

```vue
<template>
  <div class="app-container">
    <!-- 课程信息表单 -->
    <el-form label-width="120px">
      <el-form-item label="课程标题">
        <el-input v-model="courseInfo.title" placeholder=" 示例：机器学习项目课：从基础到搭建项目视频课程。专业名称注意大小写"/>
      </el-form-item>
      <!-- 课程讲师 -->
      <el-form-item label="课程讲师">
        <el-select
          v-model="courseInfo.teacherId"
          placeholder="请选择">
          <el-option
            v-for="teacher in teacherList"
            :key="teacher.id"
            :label="teacher.name"
            :value="teacher.id"/>
        </el-select>
      </el-form-item>
      <!-- 所属分类：级联下拉列表 -->
      <el-form-item label="课程类别">
        <!-- 一级分类 -->
        <el-select
          v-model="courseInfo.subjectParentId"
          placeholder="请选择"
          @change="subjectChanged">
          <el-option
            v-for="subject in subjectList"
            :key="subject.id"
            :label="subject.title"
            :value="subject.id"/>
        </el-select>
        <!-- 二级分类 -->
        <el-select v-model="courseInfo.subjectId" placeholder="请选择">
          <el-option
            v-for="subject in subjectLevelTwoList"
            :key="subject.id"
            :label="subject.title"
            :value="subject.id"/>
        </el-select>
      </el-form-item>
      <el-form-item label="总课时">
        <el-input-number :min="0" v-model="courseInfo.lessonNum" controls-position="right" placeholder="请填写课程的总课时数"/>
      </el-form-item>
      <!-- 课程简介-->
      <el-form-item label="课程简介">
        <el-input v-model="courseInfo.description" type="textarea" rows="5"/>
      </el-form-item>
      <!-- 课程封面 -->
      <el-form-item label="课程封面">
        <el-upload
          :show-file-list="false"
          :on-success="handleCoverSuccess"
          :before-upload="beforeCoverUpload"
          :on-error="handleCoverError"
          :action="BASE_API + '/admin/vod/file/upload?module=cover'"
          class="cover-uploader">
          <img v-if="courseInfo.cover" :src="courseInfo.cover">
          <i v-else class="el-icon-plus avatar-uploader-icon"/>
        </el-upload>
      </el-form-item>
      <el-form-item label="课程价格">
        <el-input-number :min="0" v-model="courseInfo.price" controls-position="right" placeholder="免费课程请设置为0元"/>
        元
      </el-form-item>
    </el-form>

    <div style="text-align:center">
      <el-button :disabled="saveBtnDisabled" type="primary" @click="saveAndNext()">保存并下一步</el-button>
    </div>
  </div>
</template>
<script>
import courseApi from '@/api/vod/course'
import teacherApi from '@/api/vod/teacher'
import subjectApi from '@/api/vod/subject'

export default {
  name: 'Info',
  data() {
    return {
      BASE_API: process.env.VUE_APP_BASE_API,
      // 按钮是否禁用
      saveBtnDisabled: false,
      // 表单数据
      courseInfo: {
        price: 0,
        lessonNum: 0,
        // 以下解决表单数据不全时insert语句非空校验
        teacherId: '',
        subjectId: '',
        subjectParentId: '',
        cover: '',
        description: ''
      },
      // 讲师列表
      teacherList: [],
      // 一级分类列表
      subjectList: [],
      // 二级分类列表
      subjectLevelTwoList: []
    }
  },
  created() {
    // 初始化分类列表
    this.initSubjectList()
    // 获取讲师列表
    this.initTeacherList()
  },
  methods: {
    // 获取讲师列表
    initTeacherList() {
      teacherApi.getAllTeacher().then(response => {
        this.teacherList = response.data
      })
    },

    // 初始化分类列表
    initSubjectList() {
      subjectApi.getList(0).then(response => {
        this.subjectList = response.data
      })
    },

    // 选择一级分类，切换二级分类
    subjectChanged(value) {
      subjectApi.getList(value).then(response => {
        this.courseInfo.subjectId = ''
        this.subjectLevelTwoList = response.data
      })
    },

    // 上传成功回调
    handleCoverSuccess(res, file) {
      this.courseInfo.cover = res.data
    },

    // 上传校验
    beforeCoverUpload(file) {
      const isJPG = file.type === 'image/jpeg'
      const isLt2M = file.size / 1024 / 1024 < 2

      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!')
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!')
      }
      return isJPG && isLt2M
    },

    // 错误处理
    handleCoverError() {
      this.$message.error('上传失败2')
    },

    // 保存并下一步
    saveAndNext() {
      this.saveBtnDisabled = true
      if (!this.$parent.courseId) {
        this.saveData()
      } else {
        //this.updateData()
      }
    },

    // 保存
    saveData() {
      courseApi.saveCourseInfo(this.courseInfo).then(response => {
        this.$message.success(response.message)
        this.$parent.courseId = response.data // 获取courseId
        this.$parent.active = 1 // 下一步
      })
    }
  }
}
</script>

<style scoped>
.tinymce-container {
  position: relative;
  line-height: normal;
}

.cover-uploader .avatar-uploader-icon {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;

  font-size: 28px;
  color: #8c939d;
  width: 640px;
  height: 357px;
  line-height: 357px;
  text-align: center;
}

.cover-uploader .avatar-uploader-icon:hover {
  border-color: #409EFF;
}

.cover-uploader img {
  width: 640px;
  height: 357px;
  display: block;
}
</style>
```

- 新建 `components/Chapter.vue` 页面
- 新建 `components/Publish.vue` 页面



## 5 修改课程基本信息

- 回显课程基本信息

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665452852438-bd7b8a5e-e377-4f4e-ac99-b31984c46f29.png)

### 5.1 接口

#### 5.1.1 控制层 `CourseController`

```java
@ApiOperation("根据 id 获取课程信息")
@GetMapping("/get/{id}")
public Result<CourseFormVo> get(@PathVariable Long id) {
    CourseFormVo courseFormVo = courseService.getCourseInfoById(id);
    return Result.ok(courseFormVo);
}

@ApiOperation("修改课程信息")
@PutMapping("/update")
public Result get(@RequestBody CourseFormVo courseFormVo) {
    courseService.updateCourseId(courseFormVo);
    return Result.ok();
}
```



#### 5.1.2 服务实现

```java
    @Override
    public CourseFormVo getCourseInfoById(Long id) {
        // 查询课程信息
        Course course = baseMapper.selectById(id);

        // 查询课程描述信息
        CourseDescription courseDescription = courseDescriptionService.getById(id);

        // 封装数据
        CourseFormVo courseFormVo = new CourseFormVo();
        if (course != null) {
            BeanUtils.copyProperties(course, courseFormVo);
        }

        if (courseDescription != null) {
            courseFormVo.setDescription(courseDescription.getDescription());
        }

        return courseFormVo;
    }

    @Override
    public void updateCourseId(CourseFormVo courseFormVo) {
        // 修改课程基本信息
        Course course = new Course();
        BeanUtils.copyProperties(courseFormVo, course);
        baseMapper.updateById(course);

        // 修改课程的描述信息
        CourseDescription description = new CourseDescription();
        description.setDescription(courseFormVo.getDescription());
        courseDescriptionService.updateById(description);
    }
```



### 5.2 前端

#### 5.2.1 `API`

```javascript
// 根据 id 获取课程信息
getCourseInfoById(id) {
  return request({
    url: `${api_name}/get/${id}`,
    method: 'get'
  })
},
// 根据 id 修改课程信息
updateCourseInfoById(data) {
  return request({
    url: `${api_name}/update`,
    method: 'put',
    data
  })
}
```



#### 5.2.2 修改 `Info.vue`

```javascript
  created() {
    if (this.$parent.courseId) {
      // 修改, 数据回显
      this.fetchCourseInfoById(this.$parent.courseId);
    } else {
      // 新增
      // 初始化分类列表
      this.initSubjectList()
    }

    // 获取讲师列表
    this.initTeacherList()
  },
  methods: {
    // 保存并下一步
    saveAndNext() {
      this.saveBtnDisabled = true
      if (!this.$parent.courseId) {
        this.saveData()
      } else {
        this.updateData()
      }
    },
    // 修改
    updateData() {
      courseApi.updateCourseInfoById(this.courseInfo).then(response => {
        this.$message.success(response.message)
        // 下一步
        this.$parent.active = 1
      })
    },
    // 获取课程信息
    fetchCourseInfoById(id) {
      courseApi.getCourseInfoById(id)
        .then(response => {
          this.courseInfo = response.data
          // 初始化分类列表
          subjectApi.getList(0)
            .then(response => {
              this.subjectList = response.data
              // 填充二级菜单: 遍历一级菜单列表
              this.subjectList.forEach(subject => {
                // 找到和 courseInfo.subjectParentId 一致的父类记录
                if (subject.id === this.courseInfo.subjectParentId) {
                  // 拿到当前类别下的字类别列表
                  subjectApi.getList(subject.id)
                    .then(response => {
                      this.subjectLevelTwoList = response.data
                    })
                }
              })
            })
        })
    }
  }
```



##  6 编辑课程大纲

### 6.1 章节接口

#### 6.1.1 控制类 ChapterController

```java
package com.atguigu.ggkt.vod.controller;

import com.atguigu.ggkt.model.vod.Chapter;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vo.vod.ChapterVo;
import com.atguigu.ggkt.vod.service.ChapterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 章节 前端控制器
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-11
 */
@Api(tags = "章节")
@RestController
@RequestMapping("/admin/vod/chapter")
@CrossOrigin
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    @ApiOperation("根据课程 id 获取大纲列表（章节和小节列表）")
    @GetMapping("/getNestedTreeList/{courseId}")
    public Result<List<ChapterVo>> get(@PathVariable Long courseId) {
        List<ChapterVo> list = chapterService.getTreeList(courseId);
        return Result.ok(list);
    }

    @ApiOperation("添加章节")
    @PostMapping("/save")
    public Result add(@RequestBody Chapter chapter) {
        chapterService.save(chapter);
        return Result.ok();
    }

    @ApiOperation("根据课程 id 获取章节")
    @GetMapping("/get/{id}")
    public Result<Chapter> getById(@PathVariable Long id) {
        Chapter chapter = chapterService.getById(id);
        return Result.ok(chapter);
    }

    @ApiOperation("修改章节信息")
    @PutMapping("/update")
    public Result update(@RequestBody Chapter chapter) {
        chapterService.updateById(chapter);
        return Result.ok();
    }

    @ApiOperation("删除章节")
    @DeleteMapping("/remove/{id}")
    public Result remove(@PathVariable Long id) {
        chapterService.removeById(id);
        return Result.ok();
    }

}
```



#### 6.2.2 服务实现

```java
package com.atguigu.ggkt.vod.service.impl;

import com.atguigu.ggkt.model.vod.Chapter;
import com.atguigu.ggkt.model.vod.Video;
import com.atguigu.ggkt.vo.vod.ChapterVo;
import com.atguigu.ggkt.vo.vod.VideoVo;
import com.atguigu.ggkt.vod.mapper.ChapterMapper;
import com.atguigu.ggkt.vod.service.ChapterService;
import com.atguigu.ggkt.vod.service.VideoService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 章节 服务实现类
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-11
 */
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements ChapterService {

    @Autowired
    private VideoService videoService;

    @Override
    public List<ChapterVo> getTreeList(Long courseId) {
        // 定义最终数据
        List<ChapterVo> chapterVoList = new ArrayList<>();

        // 根据 courseId 获取所有章节
        LambdaQueryWrapper<Chapter> wrapperChapter = new LambdaQueryWrapper<>();
        // eq(=)
        wrapperChapter.eq(Chapter::getCourseId, courseId);
        // 查询章节
        List<Chapter> chapterList = baseMapper.selectList(wrapperChapter);

        // 根据 course 获取所有小节
        LambdaQueryWrapper<Video> wrapperVideo = new LambdaQueryWrapper<>();
        // eq(=)
        wrapperVideo.eq(Video::getCourseId, courseId);
        // 查询小节
        List<Video> videoList = videoService.list(wrapperVideo);

        // 封装数据
        // 遍历所有章节
        chapterList.forEach(chapter -> {
            // 创建一个章节视图对象
            ChapterVo chapterVo = new ChapterVo();
            // 复制属性
            BeanUtils.copyProperties(chapter, chapterVo);
            // 存储章节视图对象
            chapterVoList.add(chapterVo);

            // 封装章节 > 小节
            List<VideoVo> videoVoList = new ArrayList<>();
            // 遍历小节
            videoList.forEach(video -> {
                // 判断该小节在那个章节下面
                if (chapter.getId().equals(video.getChapterId())) {
                    // 创建一个小节视图对象
                    VideoVo videoVo = new VideoVo();
                    // 复制属性
                    BeanUtils.copyProperties(video, videoVo);
                    // 存储小节视图对象
                    videoVoList.add(videoVo);
                }
            });

            // 存储小节, 该章节 > 小节集合
            chapterVo.setChildren(videoVoList);
        });

        return chapterVoList;
    }
}
```



### 6.2 课程视频接口

#### 6.2.1 控制类 `VideoController`

```java
package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.model.vod.Video;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vod.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-11
 */
@Api(tags = "课程小结（课时）")
@RestController
@RequestMapping(value = "/admin/vod/video")
@CrossOrigin
public class VideoController {

    @Autowired
    private VideoService videoService;

    @ApiOperation(value = "获取")
    @GetMapping("/get/{id}")
    public Result get(@PathVariable Long id) {
        Video video = videoService.getById(id);
        return Result.ok(video);
    }

    @ApiOperation(value = "新增")
    @PostMapping("/save")
    public Result save(@RequestBody Video video) {
        videoService.save(video);
        return Result.ok(null);
    }

    @ApiOperation(value = "修改")
    @PutMapping("/update")
    public Result updateById(@RequestBody Video video) {
        videoService.updateById(video);
        return Result.ok(null);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/remove/{id}")
    public Result remove(@PathVariable Long id) {
        videoService.removeById(id);
        return Result.ok(null);
    }

}
```



### 6.3 前端

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665454833590-f4529599-18fa-4974-9443-a46b9ade95f9.png)



#### 6.3.1 `API`

- 新建 `chapter.js`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665453640202-362ea3ad-56e2-44f3-b139-f633776e7a21.png)

```javascript
import request from '@/utils/request'

const api_name = '/admin/vod/chapter'

export default {

  getNestedTreeList(courseId) {
    return request({
      url: `${api_name}/getNestedTreeList/${courseId}`,
      method: 'get'
    })
  },

  removeById(id) {
    return request({
      url: `${api_name}/remove/${id}`,
      method: 'delete'
    })
  },

  save(chapter) {
    return request({
      url: `${api_name}/save`,
      method: 'post',
      data: chapter
    })
  },

  getById(id) {
    return request({
      url: `${api_name}/get/${id}`,
      method: 'get'
    })
  },

  updateById(chapter) {
    return request({
      url: `${api_name}/update`,
      method: 'put',
      data: chapter
    })
  }
}
```

- 新建 `video.js`

```javascript
import request from '@/utils/request'

const api_name = '/admin/vod/video'

export default {

  save(video) {
    return request({
      url: `${api_name}/save`,
      method: 'post',
      data: video
    })
  },

  getById(id) {
    return request({
      url: `${api_name}/get/${id}`,
      method: 'get'
    })
  },

  updateById(video) {
    return request({
      url: `${api_name}/update`,
      method: 'put',
      data: video
    })
  },

  removeById(id) {
    return request({
      url: `${api_name}/remove/${id}`,
      method: 'delete'
    })
  }
}
```



#### 6.3.2 `Chapter.vue`

- 子组件

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665454445833-4caddcab-8fc8-43b7-a2fb-4ccbb5149196.png)

```vue
<template>
  <div class="app-container">

    <!-- 添加章节按钮 -->
    <div>
      <el-button type="primary" @click="addChapter()">添加章节</el-button>
    </div>

    <!-- 章节列表 -->
    <ul class="chapterList">
      <li
        v-for="chapter in chapterList"
        :key="chapter.id">
        <p>
          {{ chapter.title }}
          <span class="acts">
            <el-button type="text" @click="addVideo(chapter.id)">添加课时</el-button>
            <el-button type="text" @click="editChapter(chapter.id)">编辑</el-button>
            <el-button type="text" @click="removeChapterById(chapter.id)">删除</el-button>
          </span>
        </p>
        <!-- 视频 -->
        <ul class="chapterList videoList">
          <li
            v-for="video in chapter.children"
            :key="video.id">
            <p>
              {{ video.title }}
              <el-tag v-if="!video.videoSourceId" size="mini" type="danger">
                {{ '尚未上传视频' }}
              </el-tag>
              <span class="acts">
                <el-tag v-if="video.isFree" size="mini" type="success">{{ '免费观看' }}</el-tag>
                <el-button type="text" @click="editVideo(chapter.id, video.id)">编辑</el-button>
                <el-button type="text" @click="removeVideoById(video.id)">删除</el-button>
              </span>
            </p>
          </li>
        </ul>
      </li>
    </ul>
    <!-- 章节表单对话框 -->
    <chapter-form ref="chapterForm" />
    <!-- 课时表单对话框 -->
    <video-form ref="videoForm" />
    <div style="text-align:center">
      <el-button type="primary" @click="prev()">上一步</el-button>
      <el-button type="primary" @click="next()">下一步</el-button>
    </div>
  </div>
</template>
<script>
import chapterApi from '@/api/vod/chapter'
import videoApi from '@/api/vod/video'

// 引入组件
import ChapterForm from '@/views/vod/course/components/Chapter/Form'
import VideoForm from '@/views/vod/course/components/Video/Form'

export default {
  // 注册组件
  components: { ChapterForm, VideoForm },
  data() {
    return {
      chapterList: [] // 章节嵌套列表
    }
  },
  created() {
    this.fetchNodeList()
  },
  methods: {
    // 获取章节小节数据
    fetchNodeList() {
      chapterApi.getNestedTreeList(this.$parent.courseId).then(response => {
        this.chapterList = response.data
      })
    },
    //删除章节
    removeChapterById(chapterId) {
      this.$confirm('此操作将永久删除该章节，是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        return chapterApi.removeById(chapterId)
      }).then(response => {
        this.fetchNodeList()
        this.$message.success(response.message)
      }).catch((response) => {
        if (response === 'cancel') {
          this.$message.info('取消删除')
        }
      })
    },
    // 添加章节
    addChapter() {
      this.$refs.chapterForm.open()
    },
    // 编辑章节
    editChapter(chapterId) {
      this.$refs.chapterForm.open(chapterId)
    },
    // 添加课时
    addVideo(chapterId) {
      this.$refs.videoForm.open(chapterId)
    },
    // 编辑课时
    editVideo(chapterId, videoId) {
      this.$refs.videoForm.open(chapterId, videoId)
    },
    // 删除课时
    removeVideoById(videoId) {
      this.$confirm('此操作将永久删除该课时, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        return videoApi.removeById(videoId)
      }).then(response => {
        this.fetchNodeList()
        this.$message.success(response.message)
      }).catch((response) => {
        if (response === 'cancel') {
          this.$message.info('取消删除')
        }
      })
    },
    // 上一步
    prev() {
      this.$parent.active = 0
    },
    // 下一步
    next() {
      this.$parent.active = 2
    }
  }
}
</script>
<style scoped>
.chapterList{
    position: relative;
    list-style: none;
    margin: 0;
    padding: 0;
}
.chapterList li{
  position: relative;
}
.chapterList p{
  float: left;
  font-size: 20px;
  margin: 10px 0;
  padding: 10px;
  height: 70px;
  line-height: 50px;
  width: 100%;
  border: 1px solid #DDD;
}
.chapterList .acts {
    float: right;
    font-size: 14px;
}

.videoList{
  padding-left: 50px;
}
.videoList p{
  float: left;
  font-size: 14px;
  margin: 10px 0;
  padding: 10px;
  height: 50px;
  line-height: 30px;
  width: 100%;
  border: 1px dashed #DDD;
}
</style>
```

- `ChapterForm`

```vue
<template>
  <!-- 添加和修改章节表单 -->
  <el-dialog :visible="dialogVisible" title="添加章节" @close="close()">
    <el-form :model="chapter" label-width="120px">
      <el-form-item label="章节标题">
        <el-input v-model="chapter.title"/>
      </el-form-item>
      <el-form-item label="章节排序">
        <el-input-number v-model="chapter.sort" :min="0"/>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="close()">取 消</el-button>
      <el-button type="primary" @click="saveOrUpdate()">确 定</el-button>
    </div>
  </el-dialog>
</template>

<script>
import chapterApi from '@/api/vod/chapter'

export default {
  name: "ChapterForm",
  data() {
    return {
      dialogVisible: false,
      chapter: {
        sort: 0
      }
    }
  },
  methods: {
    open(chapterId) {
      this.dialogVisible = true
      if (chapterId) {
        chapterApi.getById(chapterId).then(response => {
          this.chapter = response.data.item
        })
      }
    },

    close() {
      this.dialogVisible = false
      // 重置表单
      this.resetForm()
    },

    resetForm() {
      this.chapter = {
        sort: 0
      }
    },

    saveOrUpdate() {
      if (!this.chapter.id) {
        this.save()
      } else {
        this.update()
      }
    },

    save() {
      this.chapter.courseId = this.$parent.$parent.courseId
      chapterApi.save(this.chapter).then(response => {
        this.$message.success(response.message)
        // 关闭组件
        this.close()
        // 刷新列表
        this.$parent.fetchNodeList()
      })
    },

    update() {
      chapterApi.updateById(this.chapter).then(response => {
        this.$message.success(response.message)
        // 关闭组件
        this.close()
        // 刷新列表
        this.$parent.fetchNodeList()
      })
    }
  }
}
</script>

<style scoped>

</style>
```

- `VideoForm`

```vue
<template>
  <!-- 添加和修改课时表单 -->
  <el-dialog :visible="dialogVisible" title="添加课时" @close="close()">
    <el-form :model="video" label-width="120px">
      <el-form-item label="课时标题">
        <el-input v-model="video.title"/>
      </el-form-item>
      <el-form-item label="课时排序">
        <el-input-number v-model="video.sort" :min="0"/>
      </el-form-item>
      <el-form-item label="是否免费">
        <el-radio-group v-model="video.isFree">
          <el-radio :label="0">免费</el-radio>
          <el-radio :label="1">默认</el-radio>
        </el-radio-group>
      </el-form-item>

      <!-- 上传视频 -->
      <el-form-item label="上传视频">
        <el-upload
          ref="upload"
          :auto-upload="false"
          :on-success="handleUploadSuccess"
          :on-error="handleUploadError"
          :on-exceed="handleUploadExceed"
          :file-list="fileList"
          :limit="1"
          :before-remove="handleBeforeRemove"
          :on-remove="handleOnRemove"
          :action="BASE_API+'/admin/vod/upload'">
          <el-button slot="trigger" size="small" type="primary">选择视频</el-button>
          <el-button
            :disabled="uploadBtnDisabled"
            style="margin-left: 10px;"
            size="small"
            type="success"
            @click="submitUpload()">上传
          </el-button>
        </el-upload>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="close()">取 消</el-button>
      <el-button type="primary" @click="saveOrUpdate()">确 定</el-button>
    </div>
  </el-dialog>
</template>

<script>
import videoApi from '@/api/vod/video'

export default {
  name: "VideoForm",
  data() {
    return {
      BASE_API: process.env.VUE_APP_BASE_API,
      dialogVisible: false,
      video: {
        sort: 0,
        free: false
      },
      fileList: [], // 上传文件列表
      uploadBtnDisabled: false
    }
  },

  methods: {
    open(chapterId, videoId) {
      this.dialogVisible = true
      this.video.chapterId = chapterId
      if (videoId) {
        videoApi.getById(videoId).then(response => {
          this.video = response.data
          // 回显
          if (this.video.videoOriginalName) {
            this.fileList = [{'name': this.video.videoOriginalName}]
          }
        })
      }
    },

    close() {
      this.dialogVisible = false
      // 重置表单
      this.resetForm()
    },

    resetForm() {
      this.video = {
        sort: 0,
        free: false
      }

      this.fileList = [] // 重置视频上传列表
    },

    saveOrUpdate() {
      if (!this.video.id) {
        this.save()
      } else {
        this.update()
      }
    },

    save() {
      this.video.courseId = this.$parent.$parent.courseId
      videoApi.save(this.video).then(response => {
        this.$message.success(response.message)
        // 关闭组件
        this.close()
        // 刷新列表
        this.$parent.fetchNodeList()
      })
    },

    update() {
      videoApi.updateById(this.video).then(response => {
        this.$message.success(response.message)
        // 关闭组件
        this.close()
        // 刷新列表
        this.$parent.fetchNodeList()
      })
    },

    // 上传多于一个视频
    handleUploadExceed(files, fileList) {
      this.$message.warning('想要重新上传视频，请先删除已上传的视频')
    },

    // 上传
    submitUpload() {
      this.uploadBtnDisabled = true
      this.$refs.upload.submit() // 提交上传请求
    },

    // 视频上传成功的回调
    handleUploadSuccess(response, file, fileList) {
      this.uploadBtnDisabled = false
      this.video.videoSourceId = response.data
      this.video.videoOriginalName = file.name
    },

    // 失败回调
    handleUploadError() {
      this.uploadBtnDisabled = false
      this.$message.error('上传失败2')
    },

    // 删除视频文件确认
    handleBeforeRemove(file, fileList) {
      return this.$confirm(`确定移除 ${file.name}？`)
    },

    // 执行视频文件的删除
    handleOnRemove(file, fileList) {
      if (!this.video.videoSourceId) {
        return
      }
    }
  }
}
</script>

<style scoped>

</style>
```



## 7 发布课程



### 7.1 接口

#### 7.1.1 控制类 `CourseController`

```java
@ApiOperation("根据 id 查询发布课程信息")
@GetMapping("/getCoursePublishVo/{id}")
public Result<CoursePublishVo> getCoursePublishVo(@PathVariable Long id) {
	CoursePublishVo coursePublishVo = courseService.getCoursePublishVo(id);
    return Result.ok(coursePublishVo);
}

@ApiOperation("课程最终发布")
@PutMapping("/publishCourse/{id}")
public Result publishCourse(@PathVariable Long id) {
	courseService.publishCourse(id);
    return Result.ok();
}
```



#### 7.1.2 服务实现

```java
    @Override
    public CoursePublishVo getCoursePublishVo(Long id) {
        return baseMapper.selectCoursePublishVoById(id);
    }

    @Override
    public void publishCourse(Long id) {
        Course course = baseMapper.selectById(id);
        // 已经发布
        course.setStatus(1);
        course.setPublishTime(new Date());
        baseMapper.updateById(course);
    }
```



#### 7.1.3 `CourseMapper`

```xml
package com.atguigu.ggkt.vod.mapper;

import com.atguigu.ggkt.model.vod.Course;
import com.atguigu.ggkt.vo.vod.CoursePublishVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-11
 */
public interface CourseMapper extends BaseMapper<Course> {

    /**
     * 根据 id 查询发布课程信息
     *
     * @param id id
     * @return {@link CoursePublishVo}
     */
    CoursePublishVo selectCoursePublishVoById(Long id);

}
```

#### 7.1.4 `CourseMapper.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.atguigu.ggkt.vod.mapper.CourseMapper">

    <select id="selectCoursePublishVoById" resultType="com.atguigu.ggkt.vo.vod.CoursePublishVo"
            parameterType="java.lang.Long">
        SELECT c.id,
               c.title,
               c.cover,
               c.lesson_num AS lessonNum,
               c.price,
               t.name       AS teacherName,
               s1.title     AS subjectParentTitle,
               s2.title     AS subjectTitle
        FROM `course` c
                 LEFT OUTER JOIN `teacher` t ON c.teacher_id = t.id
                 LEFT OUTER JOIN `subject` s1 ON c.subject_id = s1.id
                 LEFT OUTER JOIN `subject` s2 ON c.subject_id = s2.id
        WHERE c.id = #{id}
    </select>

</mapper>
```



### 7.2 `service_vod` 追加依赖

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
    <resources>
        <resource>
            <directory>src/main/java</directory>
            <includes>
                <include>**/*.yml</include>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
            </includes>
            <filtering>false</filtering>
        </resource>
        <resource>
            <directory>src/main/resources</directory>
            <includes> <include>**/*.yml</include>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
            </includes>
            <filtering>false</filtering>
        </resource>
    </resources>
</build>
```



### 7.3 配置

```yaml
mybatis-plus:
	# mapper.xml 位置
  mapper-locations: classpath:com/atguigu/ggkt/vod/mapper/xml/*.xml
```



### 7.4 前端

#### 7.4.1 `API`

- 追加代码 `course.js`

```javascript
//获取发布课程信息  
getCoursePublishById(id) {
  return request({
    url: `${api_name}/getCoursePublishVo/${id}`,
    method: 'get'
  })
},
//发布课程  
publishCourseById(id) {
  return request({
    url: `${api_name}/publishCourse/${id}`,
    method: 'put'
  })
}
```



#### 7.4.2 `Publish.vue`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665465224802-45826ef0-bd52-4166-bf59-7eebe5289f82.png)

```vue
<template>
  <div class="app-container">
    <!--课程预览-->
    <div class="ccInfo">
      <img :src="coursePublish.cover">
      <div class="main">
        <h2>{{ coursePublish.title }}</h2>
        <p class="gray"><span>共{{ coursePublish.lessonNum }}课时</span></p>
        <p><span>所属分类：{{ coursePublish.subjectParentTitle }} — {{ coursePublish.subjectTitle }}</span></p>
        <p>课程讲师：{{ coursePublish.teacherName }}</p>
        <h3 class="red">￥{{ coursePublish.price }}</h3>
      </div>
    </div>
    <div style="text-align:center">
      <el-button type="primary" @click="prev()">上一步</el-button>
      <el-button :disabled="publishBtnDisabled" type="primary" @click="publish()">发布课程</el-button>
    </div>
  </div>
</template>

<script>
import courseApi from '@/api/vod/course'

export default {
  name: "Publish",
  data() {
    return {
      publishBtnDisabled: false, // 按钮是否禁用
      coursePublish: {}
    }
  },
  created() {
    if (this.$parent.courseId) {
      this.fetchCoursePublishById(this.$parent.courseId)
    }
  },
  methods: {
    // 获取课程发布信息
    fetchCoursePublishById(id) {
      courseApi.getCoursePublishById(id).then(response => {
        this.coursePublish = response.data
      })
    },
    // 上一步
    prev() {
      this.$parent.active = 1
    },
    // 下一步
    publish() {
      this.publishBtnDisabled = true
      courseApi.publishCourseById(this.$parent.courseId).then(response => {
        this.$parent.active = 3
        this.$message.success(response.message)
        this.$router.push({path: '/vod/course/list'})
      })
    }
  }
}
</script>
<style scoped>
.ccInfo {
  background: #f5f5f5;
  padding: 20px;
  overflow: hidden;
  border: 1px dashed #DDD;
  margin-bottom: 40px;
  position: relative;
}

.ccInfo img {
  background: #d6d6d6;
  width: 500px;
  height: 278px;
  display: block;
  float: left;
  border: none;
}

.ccInfo .main {
  margin-left: 520px;
}

.ccInfo .main h2 {
  font-size: 28px;
  margin-bottom: 30px;
  line-height: 1;
  font-weight: normal;
}

.ccInfo .main p {
  margin-bottom: 10px;
  word-wrap: break-word;
  line-height: 24px;
  max-height: 48px;
  overflow: hidden;
}

.ccInfo .main p {
  margin-bottom: 10px;
  word-wrap: break-word;
  line-height: 24px;
  max-height: 48px;
  overflow: hidden;
}

.ccInfo .main h3 {
  left: 540px;
  bottom: 20px;
  line-height: 1;
  font-size: 28px;
  color: #d32f24;
  font-weight: normal;
  position: absolute;
}
</style>

<style scoped>

</style>
```



## 8 课程删除功能

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665468726150-55f150a7-4c4a-498b-9ad8-288edb1247a2.png)

### 8.1 接口

#### 8.1.1 控制类

```java
@ApiOperation("根据 id 删除课程")
@DeleteMapping("/remove/{id}")
public Result remove(@PathVariable Long id) {
    courseService.removeCourseById(id);
    return Result.ok();
}
```



#### 8.1.2 服务实现

- `CourseServiceImpl`

```java
    @Override
    public void removeCourseById(Long id) {
        // 根据课程 id 删除小节
        videoService.removeVideoByCourseId(id);
        // 根据课程 id 删除章节
        chapterService.removeChapterByCourseId(id);
        // 根据课程 id 删除课程描述
        courseDescriptionService.removeById(id);
        // 根据课程 id 删除课程
        baseMapper.deleteById(id);
    }
```

- `VideoServiceImpl`

```java
    @Override
    public void removeVideoByCourseId(Long id) {
        // 创建条件对象
        LambdaQueryWrapper<Video> wrapper = new LambdaQueryWrapper<>();
        // eq(=)
        wrapper.eq(Video::getCourseId, id);
        // 执行删除操作
        baseMapper.delete(wrapper);
    }
```

- `ChapterServiceImpl`

```java
    @Override
    public void removeChapterByCourseId(Long id) {
        // 创建条件对象
        LambdaQueryWrapper<Chapter> wrapper = new LambdaQueryWrapper<>();
        // eq(=)
        wrapper.eq(Chapter::getCourseId, id);
        // 执行删除操作
        baseMapper.delete(wrapper);
    }
```



### 8.2 前端

#### 8.2.1 `API`

- `course.js`

```javascript
// 根据 id 删除数据
removeById(id) {
  return request({
    url: `${api_name}/remove/${id}`,
    method: 'delete'
  })
}
```



#### 8.2.2 追加代码 `course/List.vue`

```javascript
methods: {
	// 根据id删除数据
 	removeById(id) {
 	  this.$confirm('此操作将永久删除该课程，以及该课程下的章节和视频，是否继续?', '提示', {
 	    confirmButtonText: '确定',
 	    cancelButtonText: '取消',
 	    type: 'warning'
 	  }).then(() => {
 	    return courseApi.removeById(id)
 	  }).then(response => {
 	    this.fetchData()
 	    this.$message.success(response.message)
 	  }).catch((response) => { // 失败
 	    if (response === 'cancel') {
 	      this.$message.info('取消删除')
 	    }
 	  })
 	}
}
```



## 9 课程统计

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665473671431-353ef28e-e075-4def-af51-6673cba1229f.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665474322949-bac1730d-c2a3-4d94-bae5-2dd3098383da.png)

### 9.1 生成代码

- `strategy.setInclude("video_visitor");`

#### 

### 9.2 接口

#### 9.2.1 控制类

```java
package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vod.service.VideoVisitorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 课程统计 前端控制器
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-11
 */
@Api(tags = "课程统计")
@RestController
@RequestMapping("/admin/vod/videoVisitor")
@CrossOrigin
public class VideoVisitorController {

    @Autowired
    private VideoVisitorService videoVisitorService;

    @ApiOperation("获取课程统计数据")
    @GetMapping("/findCount/{courseId}/{startDate}/{endDate}")
    public Result<Map<String, Object>> findCount(@PathVariable Long courseId,
                                                 @PathVariable String startDate,
                                                 @PathVariable String endDate) {
        Map<String, Object> map = videoVisitorService.findCount(courseId, startDate, endDate);
        return Result.ok(map);
    }

}
```



#### 9.2.2 服务实现

```java
    @Override
    public Map<String, Object> findCount(Long courseId, String startDate, String endDate) {
        // 创建 Map 对象
        Map<String, Object> map = new HashMap<>();
        // 查询数据
        List<VideoVisitorCountVo> videoVisitorCountVoList = baseMapper.findCount(courseId, startDate, endDate);
        // Echarts 需要两个集合(日期, 数据)
        List<String> dateList = videoVisitorCountVoList.stream()
                .map(videoVisitorCountVo -> {
                    Date joinTime = videoVisitorCountVo.getJoinTime();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String format = simpleDateFormat.format(joinTime);
                    return format;
                })
                .collect(Collectors.toList());
        List<Integer> dataList = videoVisitorCountVoList.stream()
                .map(VideoVisitorCountVo::getUserCount).collect(Collectors.toList());

        map.put("xData", dateList);
        map.put("yData", dataList);
        return map;
    }
```



#### 9.2.3 `Mapper` 接口

```java
    /**
     * 获取课程统计数据
     *
     * @param courseId  课程 id
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return {@link List}<{@link VideoVisitorCountVo}>
     */
    List<VideoVisitorCountVo> findCount(
            @Param("courseId") Long courseId,
            @Param("startDate") String startDate,
            @Param("endDate") String endDate);
```



#### 9.2.4 `Mapper.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.atguigu.ggkt.vod.mapper.VideoVisitorMapper">

    <select id="findCount" resultType="com.atguigu.ggkt.vo.vod.VideoVisitorCountVo">
        SELECT
        DATE(join_time) AS joinTime,
        COUNT(*) AS userCount
        FROM video_visitor
        <where>
            <if test="startDate != null and startDate != ''">
                AND DATE(join_time) >= #{startDate}
            </if>
            <if test="endDate != null and endDate != ''">
                AND DATE(join_time) &lt;= #{endDate}
            </if>
            and course_id=#{courseId}
        </where>
        GROUP BY DATE(join_time)
        ORDER BY DATE(join_time)
    </select>

</mapper>
```



### 9.3 前端

#### 9.3.1 安装 `echarts` 插件

- 官网: `https://echarts.apache.org/handbook/zh/basics/import`

```bash
npm install --save echarts@4.1.0
```



#### 9.3.2 `API`

- 新建 `videoVisitor.js`

```javascript
import request from '@/utils/request'

const api_name = '/admin/vod/videoVisitor'

export default {
  // 查询课程统计数据
  findCount(courseId, startDate, endDate) {
    return request({
      url: `${api_name}/findCount/${courseId}/${startDate}/${endDate}`,
      method: 'get'
    })
  }
}
```



#### 9.3.3 `Chart.vue`

```vue
<template>
  <div class="app-container">
    <!--表单-->
    <el-form :inline="true" class="demo-form-inline">
      <el-form-item>
        <el-date-picker
          v-model="startDate"
          type="date"
          placeholder="选择开始日期"
          value-format="yyyy-MM-dd"/>
      </el-form-item>
      <el-form-item>
        <el-date-picker
          v-model="endDate"
          type="date"
          placeholder="选择截止日期"
          value-format="yyyy-MM-dd"/>
      </el-form-item>
      <el-button
        :disabled="btnDisabled"
        type="primary"
        icon="el-icon-search"
        @click="showChart()">查询
      </el-button>
    </el-form>
    <div id="chart" class="chart" style="height:500px;"/>
  </div>
</template>
<script>
import echarts from 'echarts'
import api from '@/api/vod/videoVisitor'

export default {
  data() {
    return {
      courseId: '',
      startDate: '',
      endDate: '',
      btnDisabled: false
    }
  },
  created() {
    this.courseId = this.$route.params.id
    // 初始化最近十天数据
    let currentDate = new Date();
    this.startDate = this.dateFormat(new Date(currentDate.getTime() - 7 * 24 * 3600 * 1000))
    this.endDate = this.dateFormat(currentDate)
    this.showChart()
  },
  methods: {
    showChart() {
      api.findCount(this.courseId, this.startDate, this.endDate).then(response => {
        this.setChartData(response.data)
      })
    },
    setChartData(data) {
      // 基于准备好的dom，初始化echarts实例
      var myChart = echarts.init(document.getElementById('chart'))
      // 指定图表的配置项和数据
      var option = {
        title: {
          text: '观看课程人数统计'
        },
        xAxis: {
          data: data.xData
        },
        yAxis: {
          minInterval: 1
        },
        series: [{
          type: 'line',
          data: data.yData
        }]
      }
      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option)
    },
    dateFormat(date) {
      let fmt = 'YYYY-mm-dd'
      let ret;
      const opt = {
        "Y+": date.getFullYear().toString(),        // 年
        "m+": (date.getMonth() + 1).toString(),     // 月
        "d+": date.getDate().toString(),            // 日
        "H+": date.getHours().toString(),           // 时
        "M+": date.getMinutes().toString(),         // 分
        "S+": date.getSeconds().toString()          // 秒
        // 有其他格式化字符需求可以继续添加，必须转化成字符串
      }
      
      for (let k in opt) {
        ret = new RegExp("(" + k + ")").exec(fmt);
        if (ret) {
          fmt = fmt.replace(ret[1], (ret[1].length == 1) ? (opt[k]) : (opt[k].padStart(ret[1].length, "0")))
        }
      }
      
      return fmt;
    }
  }
}
</script>
```

# 八-1 腾讯云视频点播

```
git checkout -b 8.0.0_vod_api
```



## 1 腾讯云点播介绍

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665490381025-f5c17fb4-7243-42a8-a567-28549834a22c.png)

- 文档: https://cloud.tencent.com/document/product/266/8757

### 1.1 开通`云点播`服务

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665490629964-84ef90d4-c078-4f2c-b88f-835e2b489512.png)



### 1.2 管理控制台

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665491155641-502a9046-82b6-46ee-88a7-6d5d189d167c.png)



### 1.3 上传视频

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665491248954-642097d0-51ec-4140-b8d4-92fe3eee8b72.png)



## 2 使用`云点播`

### 2.1 `Java SDK`

```xml
<!-- 腾讯云 VOD 云点播 -->
<dependency>
    <groupId>com.qcloud</groupId>
    <artifactId>vod_api</artifactId>
    <version>2.1.4</version>
</dependency>
```



### 2.2 示例 - 上传视频, 指定任务流

- 只支持本地视频上传

```java
VodUploadClient client = new VodUploadClient("your secretId", "your secretKey");
VodUploadRequest request = new VodUploadRequest();
request.setMediaFilePath("/data/videos/Wildlife.wmv");
request.setProcedure("Your Procedure Name");
try {
    VodUploadResponse response = client.upload("ap-guangzhou", request);
    logger.info("Upload FileId = {}", response.getFileId());
} catch (Exception e) {
    // 业务方进行异常处理
    logger.error("Upload Err", e);
}
```



### 2.3 示例 - 删除视频

文档: `https://console.cloud.tencent.com/api/explorer?Product=vod&Version=2018-07-17&Action=DeleteMedia`

```java
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.vod.v20180717.VodClient;
import com.tencentcloudapi.vod.v20180717.models.*;

public class DeleteMedia
{
    public static void main(String [] args) {
        try{
            // 实例化一个认证对象，入参需要传入腾讯云账户secretId，secretKey,此处还需注意密钥对的保密
            // 密钥可前往https://console.cloud.tencent.com/cam/capi网站进行获取
            Credential cred = new Credential("SecretId", "SecretKey");
            // 实例化一个http选项，可选的，没有特殊需求可以跳过
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("vod.tencentcloudapi.com");
            // 实例化一个client选项，可选的，没有特殊需求可以跳过
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            // 实例化要请求产品的client对象,clientProfile是可选的
            VodClient client = new VodClient(cred, "", clientProfile);
            // 实例化一个请求对象,每个接口都会对应一个request对象
            DeleteMediaRequest req = new DeleteMediaRequest();
            req.setFileId("123");
            // 返回的resp是一个DeleteMediaResponse的实例，与请求对象对应
            DeleteMediaResponse resp = client.DeleteMedia(req);
            // 输出json格式的字符串回包
            System.out.println(DeleteMediaResponse.toJsonString(resp));
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }
    }
}
```



### 2.4 客户端上传

#### 2.4.1 `Java` 签名示例

```java
import java.util.Random;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Encoder;
// 签名工具类
class Signature {
   private String secretId;
   private String secretKey;
   private long currentTime;
   private int random;
   private int signValidDuration;
    private static final String HMAC_ALGORITHM = "HmacSHA1"; //签名算法
   private static final String CONTENT_CHARSET = "UTF-8";
    public static byte[] byteMerger(byte[] byte1, byte[] byte2) {
       byte[] byte3 = new byte[byte1.length + byte2.length];
       System.arraycopy(byte1, 0, byte3, 0, byte1.length);
       System.arraycopy(byte2, 0, byte3, byte1.length, byte2.length);
       return byte3;
   }
    // 获取签名
   public String getUploadSignature() throws Exception {
       String strSign = "";
       String contextStr = "";
        // 生成原始参数字符串
       long endTime = (currentTime + signValidDuration);
       contextStr += "secretId=" + java.net.URLEncoder.encode(secretId, "utf8");
       contextStr += "&currentTimeStamp=" + currentTime;
       contextStr += "&expireTime=" + endTime;
       contextStr += "&random=" + random;
        try {
           Mac mac = Mac.getInstance(HMAC_ALGORITHM);
           SecretKeySpec secretKey = new SecretKeySpec(this.secretKey.getBytes(CONTENT_CHARSET), mac.getAlgorithm());
           mac.init(secretKey);
            byte[] hash = mac.doFinal(contextStr.getBytes(CONTENT_CHARSET));
           byte[] sigBuf = byteMerger(hash, contextStr.getBytes("utf8"));
           strSign = base64Encode(sigBuf);
           strSign = strSign.replace(" ", "").replace("\n", "").replace("\r", "");
       } catch (Exception e) {
           throw e;
       }
       return strSign;
   }
    private String base64Encode(byte[] buffer) {
       BASE64Encoder encoder = new BASE64Encoder();
       return encoder.encode(buffer);
   }
    public void setSecretId(String secretId) {
       this.secretId = secretId;
   }
    public void setSecretKey(String secretKey) {
       this.secretKey = secretKey;
   }
    public void setCurrentTime(long currentTime) {
       this.currentTime = currentTime;
   }
    public void setRandom(int random) {
       this.random = random;
   }
    public void setSignValidDuration(int signValidDuration) {
       this.signValidDuration = signValidDuration;
   }
}
public class Test {
   public static void main(String[] args) {
       Signature sign = new Signature();
       // 设置 App 的云 API 密钥
       sign.setSecretId("个人 API 密钥中的 Secret Id");
       sign.setSecretKey("个人 API 密钥中的 Secret Key");
       sign.setCurrentTime(System.currentTimeMillis() / 1000);
       sign.setRandom(new Random().nextInt(java.lang.Integer.MAX_VALUE));
       sign.setSignValidDuration(3600 * 24 * 2); // 签名有效期：2天
        try {
           String signature = sign.getUploadSignature();
           System.out.println("signature : " + signature);
       } catch (Exception e) {
           System.out.print("获取签名失败");
           e.printStackTrace();
       }
   }
}
```



### 2.5 `Web` 端上传示例

```html
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>QCloud VIDEO UGC UPLOAD SDK</title>
  <link href="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
  <style type="text/css">
    .text-danger {
      color: red;
    }

    .control-label {
      text-align: left !important;
    }

    #resultBox {
      width: 100%;
      height: 300px;
      border: 1px solid #888;
      padding: 5px;
      overflow: auto;
      margin-bottom: 20px;
    }

    .uploaderMsgBox {
      width: 100%;
      border-bottom: 1px solid #888;
    }

    .cancel-upload {
      text-decoration: none;
      cursor: pointer;
    }
  </style>
</head>
<body>
  <div id="content">
    <div class="container">
      <h1>UGC-Uploader</h1>
    </div>
  </div>
  <div class="container" id="main-area">
    <div class="row" style="padding:10px;">
      <p>
        示例1点击“直接上传视频”按钮即可上传视频。<br>。
      </p>
    </div>
    <form ref="vExample">
      <input type="file" style="display:none;" ref="vExampleFile" @change="vExampleUpload" />
    </form>
    <div class="row" style="padding:10px;">
      <h4>示例1：直接上传视频</h4>
      <a href="javascript:void(0);" class="btn btn-default" @click="vExampleAdd">直接上传视频</a>
    </div>
      <!-- 上传信息组件	 -->
      <div class="uploaderMsgBox" v-for="uploaderInfo in uploaderInfos">
        <div v-if="uploaderInfo.videoInfo">
          视频名称：{{uploaderInfo.videoInfo.name + '.' + uploaderInfo.videoInfo.type}}；
          上传进度：{{Math.floor(uploaderInfo.progress * 100) + '%'}}；
          fileId：{{uploaderInfo.fileId}}；
          上传结果：{{uploaderInfo.isVideoUploadCancel ? '已取消' : uploaderInfo.isVideoUploadSuccess ? '上传成功' : '上传中'}}；
          <br>
          地址：{{uploaderInfo.videoUrl}}；
          <a href="javascript:void(0);" class="cancel-upload" v-if="!uploaderInfo.isVideoUploadSuccess && !uploaderInfo.isVideoUploadCancel" @click="uploaderInfo.cancel()">取消上传</a><br>
        </div>
        <div v-if="uploaderInfo.coverInfo">
          封面名称：{{uploaderInfo.coverInfo.name}}；
          上传进度：{{Math.floor(uploaderInfo.coverProgress * 100) + '%'}}；
          上传结果：{{uploaderInfo.isCoverUploadSuccess ? '上传成功' : '上传中'}}；
          <br>
          地址：{{uploaderInfo.coverUrl}}；
          <br>
        </div>
      </div>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/es6-promise@4/dist/es6-promise.auto.js"></script>
  <script src="//cdnjs.cloudflare.com/ajax/libs/vue/2.5.21/vue.js"></script>
  <script src="//cdnjs.cloudflare.com/ajax/libs/axios/0.18.0/axios.js"></script>
  <script src="https://cdn-go.cn/cdn/vod-js-sdk-v6/latest/vod-js-sdk-v6.js"></script>

  <script type="text/javascript">

    ;(function () {

      /**
       * 计算签名。调用签名接口获取
      **/
      function getSignature() {
        return axios.get("http://localhost:8301/admin/vod/user/sign").then(response =>{
          return response.data.data
        })
      };
      var app = new Vue({
        el: '#main-area',
        data: {
          uploaderInfos: [],

          vcExampleVideoName: '',
          vcExampleCoverName: '',

          cExampleFileId: '',
        },
        created: function () {
          this.tcVod = new TcVod.default({
            getSignature: getSignature
          })
        },
        methods: {
          /**
           * vExample示例。添加视频
          **/
          vExampleAdd: function () {
            this.$refs.vExampleFile.click()
          },
          /**
           * vExample示例。上传视频过程。
          **/
          vExampleUpload: function () {
            var self = this;
            var mediaFile = this.$refs.vExampleFile.files[0]

            var uploader = this.tcVod.upload({
              mediaFile: mediaFile,
            })
            uploader.on('media_progress', function (info) {
              uploaderInfo.progress = info.percent;
            })
            uploader.on('media_upload', function (info) {
              uploaderInfo.isVideoUploadSuccess = true;
            })

            console.log(uploader, 'uploader')

            var uploaderInfo = {
              videoInfo: uploader.videoInfo,
              isVideoUploadSuccess: false,
              isVideoUploadCancel: false,
              progress: 0,
              fileId: '',
              videoUrl: '',
              cancel: function() {
                uploaderInfo.isVideoUploadCancel = true;
                uploader.cancel()
              },
            }

            this.uploaderInfos.push(uploaderInfo)
            uploader.done().then(function(doneResult) {
              console.log('doneResult', doneResult)
              uploaderInfo.fileId = doneResult.fileId;
              return doneResult.video.url;
            }).then(function (videoUrl) {
              uploaderInfo.videoUrl = videoUrl
              self.$refs.vExample.reset();
            })
          },
          // cExample 上传过程
          cExampleUpload: function() {
            var self = this;
            var coverFile = this.$refs.cExampleCover.files[0];

            var uploader = this.tcVod.upload({
              fileId: this.cExampleFileId,
              coverFile: coverFile,
            })
            uploader.on('cover_progress', function(info) {
              uploaderInfo.coverProgress = info.percent;
            })
            uploader.on('cover_upload', function(info) {
              uploaderInfo.isCoverUploadSuccess = true;
            })
            console.log(uploader, 'uploader')

            var uploaderInfo = {
              coverInfo: uploader.coverInfo,
              isCoverUploadSuccess: false,
              coverProgress: 0,
              coverUrl: '',
              cancel: function () {
                uploader.cancel()
              },
            }

            this.uploaderInfos.push(uploaderInfo)

            uploader.done().then(function (doneResult) {
              console.log('doneResult', doneResult)
              uploaderInfo.coverUrl = doneResult.cover.url;
              self.$refs.cExample.reset();
            })
          },
        },
      })
    })();

  </script>
  <!-- Global site tag (gtag.js) - Google Analytics -->
  <script async src="https://www.googletagmanager.com/gtag/js?id=UA-26476625-7"></script>
  <script>
    // add by alsotang@gmail.com
    window.dataLayer = window.dataLayer || [];
    function gtag(){dataLayer.push(arguments);}
    gtag('js', new Date());
    gtag('config', 'UA-26476625-7');
  </script>
</body>
</html>
```



## 3 `service_vod` 工程使用`云点播`上传、删除视频

### 3.1 引入依赖

```xml
<!-- 腾讯云 VOD 云点播 -->
<dependency>
    <groupId>com.qcloud</groupId>
    <artifactId>vod_api</artifactId>
    <version>2.1.4</version>
    <exclusions>
        <exclusion>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-log4j12</artifactId>
        </exclusion>
    </exclusions>
</dependency>
```



### 3.2 接口

#### 3.2.1 工具类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665498473937-da22dd02-592e-49cc-b767-efc2a2c68c62.png)

```java
package com.atguigu.ggkt.util;

import sun.misc.BASE64Encoder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * 签名工具类
 *
 * @author 陈江林
 * @date 2022/10/11 22:17
 */
public class Signature {

    private String secretId;
    private String secretKey;
    private long currentTime;
    private int random;
    private int signValidDuration;

    //签名算法
    private static final String HMAC_ALGORITHM = "HmacSHA1";
    private static final String CONTENT_CHARSET = "UTF-8";

    public static byte[] byteMerger(byte[] byte1, byte[] byte2) {
        byte[] byte3 = new byte[byte1.length + byte2.length];
        System.arraycopy(byte1, 0, byte3, 0, byte1.length);
        System.arraycopy(byte2, 0, byte3, byte1.length, byte2.length);
        return byte3;
    }

    // 获取签名
    public String getUploadSignature() throws Exception {
        String strSign = "";
        String contextStr = "";
        // 生成原始参数字符串
        long endTime = (currentTime + signValidDuration);
        contextStr += "secretId=" + java.net.URLEncoder.encode(secretId, "utf8");
        contextStr += "&currentTimeStamp=" + currentTime;
        contextStr += "&expireTime=" + endTime;
        contextStr += "&random=" + random;
        // 设置任务流
        contextStr += "&procedure=LongVideoPreset";

        try {
            Mac mac = Mac.getInstance(HMAC_ALGORITHM);
            SecretKeySpec secretKey = new SecretKeySpec(this.secretKey.getBytes(CONTENT_CHARSET), mac.getAlgorithm());
            mac.init(secretKey);
            byte[] hash = mac.doFinal(contextStr.getBytes(CONTENT_CHARSET));
            byte[] sigBuf = byteMerger(hash, contextStr.getBytes("utf8"));
            strSign = base64Encode(sigBuf);
            strSign = strSign.replace(" ", "").replace("\n", "").replace("\r", "");
        } catch (Exception e) {
            throw e;
        }
        return strSign;
    }

    private String base64Encode(byte[] buffer) {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(buffer);
    }

    public void setSecretId(String secretId) {
        this.secretId = secretId;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    public void setRandom(int random) {
        this.random = random;
    }

    public void setSignValidDuration(int signValidDuration) {
        this.signValidDuration = signValidDuration;
    }
}
```



#### 3.2.2 控制类

```java
package com.atguigu.ggkt.vod.controller;

import com.atguigu.ggkt.exception.GgktException;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.util.Signature;
import com.atguigu.ggkt.vod.config.CosProperties;
import com.atguigu.ggkt.vod.service.VodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * 腾讯云点播 控制类
 *
 * @author 陈江林
 * @date 2022/10/11 21:25
 */
@Api(tags = "腾讯云点播")
@RestController
@RequestMapping("/admin/vod")
@CrossOrigin
public class VodController {

    @Autowired
    private VodService vodService;

    @Autowired
    private CosProperties cosProperties;

    @ApiOperation("客户端上传视频签名")
    @GetMapping("/getSign")
    public Result getSign() {
        Signature sign = new Signature();
        // 设置 App 的云 API 密钥
        sign.setSecretId(cosProperties.getSecretId());
        sign.setSecretKey(cosProperties.getSecretKey());
        sign.setCurrentTime(System.currentTimeMillis() / 1000);
        sign.setRandom(new Random().nextInt(java.lang.Integer.MAX_VALUE));
        // 签名有效期：2天
        sign.setSignValidDuration(3600 * 24 * 2);

        try {
            String signature = sign.getUploadSignature();
            return Result.ok(signature);
        } catch (Exception e) {
            throw new GgktException(20001, "获取签名失败");
        }
    }

    @ApiOperation("上传视频")
    @PostMapping("/upload")
    public Result<String> upload() {
        String fileId = vodService.uploadVideo();
        return Result.ok(fileId);
    }

    @ApiOperation("删除视频")
    @DeleteMapping("/remove/{fileId}")
    public Result remove(@PathVariable String fileId) {
        vodService.removeByFileId(fileId);
        return Result.ok();
    }

}
```



#### 3.2.3 服务实现类

```java
package com.atguigu.ggkt.vod.service.impl;

import com.atguigu.ggkt.exception.GgktException;
import com.atguigu.ggkt.vod.config.CosProperties;
import com.atguigu.ggkt.vod.service.VodService;
import com.qcloud.vod.VodUploadClient;
import com.qcloud.vod.model.VodUploadRequest;
import com.qcloud.vod.model.VodUploadResponse;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.vod.v20180717.VodClient;
import com.tencentcloudapi.vod.v20180717.models.DeleteMediaRequest;
import com.tencentcloudapi.vod.v20180717.models.DeleteMediaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 腾讯云点播 服务实现类
 *
 * @author 陈江林
 * @date 2022/10/11 21:34
 */
@Service
public class VodServiceImpl implements VodService {

    @Autowired
    private CosProperties cosProperties;

    @Override
    public String uploadVideo() {
        VodUploadClient client = new VodUploadClient(cosProperties.getSecretId(), cosProperties.getSecretKey());
        VodUploadRequest request = new VodUploadRequest();
        request.setMediaFilePath("/opt/video/test.mov");
        request.setProcedure("LongVideoPreset");
        try {
            VodUploadResponse response = client.upload("ap-guangzhou", request);
            // 返回上传后的视频 id
            return response.getFileId();
        } catch (Exception e) {
            throw new GgktException(20001, "视频上传失败");
        }
    }

    @Override
    public void removeByFileId(String fileId) {
        try {
            // 实例化一个认证对象，入参需要传入腾讯云账户secretId，secretKey,此处还需注意密钥对的保密
            // 密钥可前往https://console.cloud.tencent.com/cam/capi网站进行获取
            Credential cred = new Credential(cosProperties.getSecretId(), cosProperties.getSecretKey());
            // 实例化一个http选项，可选的，没有特殊需求可以跳过
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("vod.tencentcloudapi.com");
            // 实例化一个client选项，可选的，没有特殊需求可以跳过
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            // 实例化要请求产品的client对象,clientProfile是可选的
            VodClient client = new VodClient(cred, "", clientProfile);
            // 实例化一个请求对象,每个接口都会对应一个request对象
            DeleteMediaRequest req = new DeleteMediaRequest();
            req.setFileId(fileId);
            // 返回的resp是一个DeleteMediaResponse的实例，与请求对象对应
            DeleteMediaResponse resp = client.DeleteMedia(req);
            // 输出json格式的字符串回包
            System.out.println(DeleteMediaResponse.toJsonString(resp));
        } catch (TencentCloudSDKException e) {
            throw new GgktException(20001, "删除上传失败");
        }
    }

}
```



### 3.3 前端

#### 3.3.1 `API`

- 新建 `vod.js`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665496405219-76d4d6f6-e76a-4983-8cdc-279b39caf61d.png)

```javascript
import request from '@/utils/request'

const api_name = '/admin/vod'

export default {
  // 根据文件 id 删除
  removeByFileId(fileId) {
    return request({
      url: `${api_name}/remove/${fileId}`,
      method: 'delete'
    })
  }
}
```



#### 3.3.2 修改 `Form.vue`

- 导入 `API`

```javascript
import vodApi from '@/api/vod/vod'
```

- 删除方法

```vue
// 执行视频文件的删除
handleOnRemove(file, fileList) {
  if (!this.video.videoSourceId) {
    return
  }
  
  vodApi.removeByFileId(this.video.videoSourceId).then(response => {
    this.video.videoSourceId = ''
    this.video.videoOriginalName = ''
    videoApi.updateById(this.video)
    this.$message.success(response.message)
  })
}
```



## 4 删除课程、章节、小节

- 删除章节并删除对应的所有小节和视频
- 删除小节并删除对应视频

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665566281919-2780e1a2-e8f5-4c0b-bfe3-014660d1b2f4.png)



- 删除课程并删除对应的章节、小节、视频

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665566746891-b08cf637-d7bd-4091-976c-2d5983b6d1ec.png)



### 4.1删除课程和删除小节

#### 4.1.1 控制类 `VideoController`

```java
    @ApiOperation(value = "删除")
    @DeleteMapping("/remove/{id}")
    public Result remove(@PathVariable Long id) {
        videoService.removeVideoById(id);
        return Result.ok();
    }
```



#### 4.1.2 服务实现

```java
package com.atguigu.ggkt.vod.service.impl;

import com.atguigu.ggkt.model.vod.Video;
import com.atguigu.ggkt.vod.mapper.VideoMapper;
import com.atguigu.ggkt.vod.service.VideoService;
import com.atguigu.ggkt.vod.service.VodService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-11
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

    @Autowired
    private VodService vodService;

    @Override
    public void removeVideoByCourseId(Long id) {
        // 创建条件对象
        LambdaQueryWrapper<Video> wrapper = new LambdaQueryWrapper<>();
        // eq(=)
        wrapper.eq(Video::getCourseId, id);

        // 根据课程 id 查询所有小节
        List<Video> videos = baseMapper.selectList(wrapper);
        // 遍历所有小节 - 删除视频
        videos.forEach(video -> {
            // 获取视频 id
            String videoSourceId = video.getVideoSourceId();
            // 如果视频 id 不为空
            if (!StringUtils.isEmpty(video)) {
                // 删除腾讯云视频
                vodService.removeByFileId(videoSourceId);
            }
        });

        // 根据课程 id 删除所有小节
        baseMapper.delete(wrapper);
    }

    @Override
    public void removeVideoById(Long id) {
        // id 查询小节信息
        Video video = baseMapper.selectById(id);
        // 获取 video 中视频 id
        String videoSourceId = video.getVideoSourceId();
        // 判断视频 id 是否为空
        if (!StringUtils.isEmpty(videoSourceId)) {
            // 视频 id 不为空, 调用方法删除腾讯云中的视频
            vodService.removeByFileId(videoSourceId);
        }

        // 根据 id 删除小节
        baseMapper.deleteById(id);
    }

}
```



### 4.2 删除章节

#### 4.2.1 控制类 `ChapterController`

```java
    @ApiOperation("删除章节")
    @DeleteMapping("/remove/{id}")
    public Result remove(@PathVariable Long id) {
        chapterService.removeChapterById(id);
        return Result.ok();
    }
```

#### 4.2.2 服务实现

```java
    @Override
    public void removeChapterById(Long id) {
        // 根据 id 删除章节
        baseMapper.deleteById(id);
        // 根据章节 id 删除对应的小节及视频
        videoService.removeVideoByChapterId(id);
    }
```



#### 4.2.3 `VideoServiceImpl`

```java
@Override
public void removeVideoByChapterId(Long id) {
    // 创建条件对象
    LambdaQueryWrapper<Video> wrapper = new LambdaQueryWrapper<>();
    // 章节 id
    wrapper.eq(Video::getChapterId, id);
    // 查询该章节所有小节
    List<Video> videos = baseMapper.selectList(wrapper);
    // 循环删除视频
    videos.forEach(video -> {
        // 获取 video 中视频 id
        String videoSourceId = video.getVideoSourceId();
        // 判断视频 id 是否为空
        if (!StringUtils.isEmpty(videoSourceId)) {
            // 视频 id 不为空, 调用方法删除腾讯云中的视频
            vodService.removeByFileId(videoSourceId);
        }
    });
    // 根据章节 id 删除所有小节
    baseMapper.delete(wrapper);
}
```

# 九 整合注册中心和网关

```
git checkout -b 9.0.0_nacos_gateway
```

## 1 `Spring Cloud` 相关概念

### 1.1、什么是 `Spring Cloud`

- `Spring Cloud `是一系列框架的集合。它利用 `Spring Boot` 的开发便利性简化了分布式系统基础设施的开发，如服务发现、服务注册、配置中心、消息总线、负载均衡、 熔断器、数据监控等，都可以用`Spring Boot` 的开发风格做到一键启动和部署。`Spring` 并没有重复制造轮子，它只是将目前各家公司开发的比较成熟、经得起实际考验的服务框架组合起来，通过 `SpringBoot` 风格进行再封装屏蔽掉了复杂的配置和实现原理，最终给开发者留出了一套简单易懂、易部署和易维护的分布式系统开发工具包



### 1.2 `Spring Cloud` 和 `Spring Boot` 关系

- `Spring Boot` 是 `Spring` 的一套快速配置脚手架，可以基于 `Spring Boot` 快速开发单个微服务，`Spring Cloud `是一个基于 `Spring Boot` 实现的开发工具；`Spring Boot` 专注于快速、方便集成的单个微服务个体，`Spring Cloud `关注全局的服务治理框架； `Spring Boot` 使用了默认大于配置的理念，很多集成方案已经帮你选择好了，能不配置就不配置，`Spring Cloud` 很大的一部分是基于 `Spring Boot` 来实现，必须基于 `Spring Boot` 开发。可以单独使用 `Spring Boot` 开发项目，但是 `Spring Cloud` 离不开 `Spring Boot`



### 1.3 `Spring Cloud` 相关基础服务组件

- 服务发现——`Netflix Eureka` （`Nacos`）
- 服务调用——`Netflix Feign`
- 熔断器——`Netflix Hystrix`
- 服务网关——`Spring Cloud GateWay`
- 分布式配置——`Spring Cloud Config `（`Nacos`）
- 消息总线 —— `Spring Cloud Bus` （`Nacos`）



## 2 搭建 `Nacos` 服务

### 2.1 `Nacos` 概述

#### 2.1.1 基本概念

- `Nacos` 是阿里巴巴推出来的一个新开源项目，是一个更易于构建云原生应用的动态服务发现、配置管理和服务管理平台。
- `Nacos` 致力于帮助您发现、配置和管理微服务。
- `Nacos` 提供了一组简单易用的特性集，帮助您快速实现动态服务发现、服务配置、服务元数据及流量管理。
- `Nacos` 帮助您更敏捷和容易地构建、交付和管理微服务平台。
- `Nacos` 是构建以“服务”为中心的现代应用架构 (例如微服务范式、云原生范式) 的服务基础设施。



#### 2.1.2 常见的注册中心

1. `Eureka`（原生，2.0 遇到性能瓶颈，停止维护）
2. `Zookeeper`（支持，专业的独立产品。例如：`dubbo`）
3. `Consul`（原生，`GO` 语言开发）
4.  `Nacos`



- 相对于 `Spring Cloud Eureka` 来说，`Nacos` 更强大。
- `Nacos` = `Spring Cloud Eureka `+ `Spring Cloud Config`
- `Nacos` 可以与 `Spring, Spring Boot`, `Spring Cloud` 集成，并能代替 `Spring Cloud Eureka`, `Spring Cloud Config`
- 通过 `Nacos Server` 和 `spring-cloud-starter-alibaba-nacos-discovery` 实现服务的注册与发现



#### 2.1.3`Nacos` 结构图

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665477111286-e5868ef4-7fdc-4f91-9c74-1ceb09bf67fb.png)

### 2.2 `Nacos`下载和安装

#### 2.2.1 下载地址和版本

- 下载地址：https://github.com/alibaba/nacos/releases
- 下载版本：`nacos-server-1.1.4.tar.gz` 或 `nacos-server-1.1.4.zip`，解压任意目录即可



#### 2.2.2 启动 `Nacos` 服务

#### `**Linux**`/`**Unix**`/`**Mac**`

启动命令(`standalone` 代表着单机模式运行，非集群模式)

启动命令：`sh startup.sh -m standalone`



- 内存问题报错
- 修改 `startup.sh`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665590476274-83a71699-a8e1-4707-a910-92fd38b6370a.png)

`Xms` 是指设定程序启动时占用内存大小

`Xmx` 是指设定程序运行期间最大可占用的内存大小

`Xmn` 新生代的大小



```
**Windows**
```

启动方式，`cmd` 打开，执行命令： `startup.cmd -m standalone`

访问：`http://localhost:8848/nacos`

用户名密码：`nacos`/`nacos`



![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665477494594-47515dfd-1a14-4517-b3ed-a394b453d0c5.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665477504819-8739d94f-5c52-4be1-a362-8075662dbf52.png)



### 2.3 `Nocas` 服务注册

#### 2.3.1 追加依赖 `service`

```xml
<!-- 服务注册 -->
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
</dependency>

<!-- 服务调用 feign -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
```



#### 2.3.2 配置 `service_vod`

```yaml
# nacos 服务地址
spring:
	cloud:
  	nacos:
    	discovery:
      	server-addr: 127.0.0.1:8848
```



#### 2.3.3 开启 `Nacos`

- 启动类添加注解 `@EnableDiscoveryClient`

```java
package com.atguigu.ggkt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 陈江林
 * @date 2022/10/2 06:27
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.atguigu")
@EnableDiscoveryClient
public class ServiceVodApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceVodApplication.class, args);
    }

}
```



## 3 整合 `Spring Cloud GateWay` 网关

### 3.1 网关基本概念

#### 3.1.1 `Gateway` 概述

- `Spring cloud gateway` 是 `spring` 官方基于 `Spring 5.0`、`Spring Boot 2.0` 和 `Project Reactor` 等技术开发的网关，`Spring Cloud Gateway` 旨在为微服务架构提供简单、有效和统一的 `API` 路由管理方式，`Spring Cloud Gateway` 作为 `Spring Cloud` 生态系统中的网关，目标是替代 `Netflix Zuul`, 其不仅提供统一的路由方式，并且还基于 `Filter` 链的方式提供了网关基本的功能，例如：安全、监控/埋点、限流等

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665583715788-0b62f968-2c41-4931-8107-992282bf8916.png)

#### 3.1.2 `Gateway` 核心概念

- 网关提供 `API` 全托管服务，丰富的 `API` 管理功能，辅助企业管理大规模的 `API`, 以降低管理成本和安全风险，包括协议适配、协议转发、安全策略、防刷、流量、监控日志等贡呢。
- 一般来说网关对外暴露的URL或者接口信息, 我们统称为路由信息。如果研发过网关中间件或者使用过 `Zuul` 的人，会知道网关的核心是 `Filter` 以及 `Filter Chain`（`Filter` 责任链）
- `Sprig Cloud Gateway` 也具有路由和 `Filter` 的概念。



下面介绍一下 `Spring Cloud Gateway` 中几个重要的概念

1. 路由

1. 1. 路由是网关最基础的部分，路由信息有一个ID、一个目的URL、一组断言和一组 `Filter` 组成。如果断言路由为真，则说明请求的 `URL` 和配置匹配

1. 断言

1. 1. `Java8` 中的断言函数。`Spring Cloud Gateway` 中的断言函数输入类型是 `Spring5.0` 框架中的 `ServerWebExchange`
2. `Spring Cloud Gateway` 中的断言函数允许开发者去定义匹配来自于 `http request`中的任何信息，比如请求头和参数等。

1. 过滤器

1. 1. 一个标准的 `Spring webFilter`
2. `Spring cloud gateway` 中的 `filter` 分为两种类型的 `Filter`，分别是 `Gateway Filter` 和 `Global Filter`
3. 过滤器 `Filter` 将会对请求和响应进行修改处理

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665583697696-62adc1ff-ad54-425d-b028-fc7bb7a7682c.png)



- 如图所示，`Spring cloud Gateway` 发出请求。
- 然后再由 `Gateway Handler Mapping` 中找到与请求相匹配的路由，将其发送到 `Gateway web handler`。
- `Handler`再通过指定的过滤器链将请求发送到实际的服务执行业务逻辑，然后返回



### 3.2 使用网关 `gateway`

#### 3.2.1 在 `ggkt_parent` 下创建子模块 `service_gateway`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665586377854-1bcda766-2dc1-49d3-b928-03e1145ac01b.png)

#### 3.2.2 依赖

```xml
<dependencies>
    <dependency>
        <groupId>com.atguigu</groupId>
        <artifactId>service_utils</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </dependency>

    <!-- 网关 -->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-gateway</artifactId>
    </dependency>

    <!-- 服务注册 -->
    <dependency>
        <groupId>com.alibaba.cloud</groupId>
        <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
    </dependency>
</dependencies>
```



#### 3.2.3 创建启动类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665586720767-889f7322-1aac-443e-9a6b-8098ddde3023.png)

```java
package com.atguigu.ggkt.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 陈江林
 * @date 2022/10/12 22:53
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApiGateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGateWayApplication.class, args);
    }
    
}
```



#### 3.2.4 配置文件 `application.yml`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665586735396-e4f6839a-602f-454e-bb75-f8e82c3ef384.png)

```yaml
# 服务端口
server:
	port: 8333

spring:
	# 服务名
	application:
		name: service-gateway
	# nacos服务地址
	cloud:
		nacos:
			discovery:
				server-addr: 127.0.0.1:8848
		# 使用服务发现路由
		gateway:
			discovery:
				locator:
					enabled: true
			# service-vod 模块配置
			# 设置路由id
			routes[0]:
				id: service-vod
				# 设置路由的uri
				uri: lb://service-vod
				# 设置路由断言,代理 servicerId 为 auth-service 的 /auth/ 路径
				predicates: Path=/*/vod/**
```



#### 3.2.5 创建测试类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665586556369-c888face-8b27-409a-9399-1cc1a5000b1c.png)

```java
package com.atguigu.ggkt.gateway;

/**
 * @author 陈江林
 * @date 2022/10/12 22:55
 */
public class ApiGateWayApplicationTest {
}
```





### 3.3 网关解决跨域问题

#### 3.3.1 跨域概述

- 跨域本质是浏览器对于 `ajax` 请求的一种安全限制：一个页面发起的 `ajax` 请求，只能是与当前页域名相同的路径，这能有效的阻止跨站攻击。

    - 因此：跨域问题 是针对 `ajax` 的一种限制。但是这却给我们的开发带来了不便，而且在实际生产环境中，肯定会有很多台服务器之间交互，地址和端口都可能不同。

- 之前我们通过服务器添加注解实现，现在我们跨域通过网关来解决跨域问题



#### 3.3.2 创建配置类 `CorsConfig`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665586764267-1e61de40-c2b1-43c9-b1a6-4104955a9d0b.png)

```java
package com.atguigu.ggkt.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.pattern.PathPatternParser;

/**
 * 跨域配置类
 *
 * @author 陈江林
 * @date 2022/10/12 22:59
 */
@Configuration
public class CorsConfig {

    /**
     * 处理跨域
     *
     * @return {@link CorsWebFilter}
     */
    @Bean
    public CorsWebFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedMethod("*");
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
        source.registerCorsConfiguration("/**", config);
        return new CorsWebFilter(source);
    }
    
}
```

- 删除所有注解 `@CrossOrigin`



### 3.4 修改前端接口

```latex
VUE_APP_BASE_API = 'http://localhost:8333'
```# 九 整合注册中心和网关

```
git checkout -b 9.0.0_nacos_gateway
```

## 1 `Spring Cloud` 相关概念

### 1.1、什么是 `Spring Cloud`

- `Spring Cloud `是一系列框架的集合。它利用 `Spring Boot` 的开发便利性简化了分布式系统基础设施的开发，如服务发现、服务注册、配置中心、消息总线、负载均衡、 熔断器、数据监控等，都可以用`Spring Boot` 的开发风格做到一键启动和部署。`Spring` 并没有重复制造轮子，它只是将目前各家公司开发的比较成熟、经得起实际考验的服务框架组合起来，通过 `SpringBoot` 风格进行再封装屏蔽掉了复杂的配置和实现原理，最终给开发者留出了一套简单易懂、易部署和易维护的分布式系统开发工具包



### 1.2 `Spring Cloud` 和 `Spring Boot` 关系

- `Spring Boot` 是 `Spring` 的一套快速配置脚手架，可以基于 `Spring Boot` 快速开发单个微服务，`Spring Cloud `是一个基于 `Spring Boot` 实现的开发工具；`Spring Boot` 专注于快速、方便集成的单个微服务个体，`Spring Cloud `关注全局的服务治理框架； `Spring Boot` 使用了默认大于配置的理念，很多集成方案已经帮你选择好了，能不配置就不配置，`Spring Cloud` 很大的一部分是基于 `Spring Boot` 来实现，必须基于 `Spring Boot` 开发。可以单独使用 `Spring Boot` 开发项目，但是 `Spring Cloud` 离不开 `Spring Boot`



### 1.3 `Spring Cloud` 相关基础服务组件

- 服务发现——`Netflix Eureka` （`Nacos`）
- 服务调用——`Netflix Feign`
- 熔断器——`Netflix Hystrix`
- 服务网关——`Spring Cloud GateWay`
- 分布式配置——`Spring Cloud Config `（`Nacos`）
- 消息总线 —— `Spring Cloud Bus` （`Nacos`）



## 2 搭建 `Nacos` 服务

### 2.1 `Nacos` 概述

#### 2.1.1 基本概念

- `Nacos` 是阿里巴巴推出来的一个新开源项目，是一个更易于构建云原生应用的动态服务发现、配置管理和服务管理平台。
- `Nacos` 致力于帮助您发现、配置和管理微服务。
- `Nacos` 提供了一组简单易用的特性集，帮助您快速实现动态服务发现、服务配置、服务元数据及流量管理。
- `Nacos` 帮助您更敏捷和容易地构建、交付和管理微服务平台。 
- `Nacos` 是构建以“服务”为中心的现代应用架构 (例如微服务范式、云原生范式) 的服务基础设施。



#### 2.1.2 常见的注册中心

1. `Eureka`（原生，2.0 遇到性能瓶颈，停止维护）
2. `Zookeeper`（支持，专业的独立产品。例如：`dubbo`）
3. `Consul`（原生，`GO` 语言开发）
4.  `Nacos`



- 相对于 `Spring Cloud Eureka` 来说，`Nacos` 更强大。
- `Nacos` = `Spring Cloud Eureka `+ `Spring Cloud Config`
- `Nacos` 可以与 `Spring, Spring Boot`, `Spring Cloud` 集成，并能代替 `Spring Cloud Eureka`, `Spring Cloud Config`
- 通过 `Nacos Server` 和 `spring-cloud-starter-alibaba-nacos-discovery` 实现服务的注册与发现



#### 2.1.3`Nacos` 结构图

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665477111286-e5868ef4-7fdc-4f91-9c74-1ceb09bf67fb.png)

### 2.2 `Nacos`下载和安装

#### 2.2.1 下载地址和版本

- 下载地址：https://github.com/alibaba/nacos/releases
- 下载版本：`nacos-server-1.1.4.tar.gz` 或 `nacos-server-1.1.4.zip`，解压任意目录即可



#### 2.2.2 启动 `Nacos` 服务

#### `**Linux**`/`**Unix**`/`**Mac**`

启动命令(`standalone` 代表着单机模式运行，非集群模式)

启动命令：`sh startup.sh -m standalone`



- 内存问题报错
- 修改 `startup.sh`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665590476274-83a71699-a8e1-4707-a910-92fd38b6370a.png)

`Xms` 是指设定程序启动时占用内存大小

`Xmx` 是指设定程序运行期间最大可占用的内存大小

`Xmn` 新生代的大小



```
**Windows**
```

启动方式，`cmd` 打开，执行命令： `startup.cmd -m standalone`

访问：`http://localhost:8848/nacos`

用户名密码：`nacos`/`nacos`



![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665477494594-47515dfd-1a14-4517-b3ed-a394b453d0c5.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665477504819-8739d94f-5c52-4be1-a362-8075662dbf52.png)



### 2.3 `Nocas` 服务注册 

#### 2.3.1 追加依赖 `service`

```xml
<!-- 服务注册 -->
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
</dependency>

<!-- 服务调用 feign -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
```



#### 2.3.2 配置 `service_vod`

```yaml
# nacos 服务地址
spring:
	cloud:
  	nacos:
    	discovery:
      	server-addr: 127.0.0.1:8848
```



#### 2.3.3 开启 `Nacos`

- 启动类添加注解 `@EnableDiscoveryClient`

```java
package com.atguigu.ggkt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 陈江林
 * @date 2022/10/2 06:27
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.atguigu")
@EnableDiscoveryClient
public class ServiceVodApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceVodApplication.class, args);
    }

}
```



## 3 整合 `Spring Cloud GateWay` 网关

### 3.1 网关基本概念

#### 3.1.1 `Gateway` 概述

- `Spring cloud gateway` 是 `spring` 官方基于 `Spring 5.0`、`Spring Boot 2.0` 和 `Project Reactor` 等技术开发的网关，`Spring Cloud Gateway` 旨在为微服务架构提供简单、有效和统一的 `API` 路由管理方式，`Spring Cloud Gateway` 作为 `Spring Cloud` 生态系统中的网关，目标是替代 `Netflix Zuul`, 其不仅提供统一的路由方式，并且还基于 `Filter` 链的方式提供了网关基本的功能，例如：安全、监控/埋点、限流等

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665583715788-0b62f968-2c41-4931-8107-992282bf8916.png)

#### 3.1.2 `Gateway` 核心概念

- 网关提供 `API` 全托管服务，丰富的 `API` 管理功能，辅助企业管理大规模的 `API`, 以降低管理成本和安全风险，包括协议适配、协议转发、安全策略、防刷、流量、监控日志等贡呢。
- 一般来说网关对外暴露的URL或者接口信息, 我们统称为路由信息。如果研发过网关中间件或者使用过 `Zuul` 的人，会知道网关的核心是 `Filter` 以及 `Filter Chain`（`Filter` 责任链）
- `Sprig Cloud Gateway` 也具有路由和 `Filter` 的概念。



下面介绍一下 `Spring Cloud Gateway` 中几个重要的概念

1. 路由

1. 1. 路由是网关最基础的部分，路由信息有一个ID、一个目的URL、一组断言和一组 `Filter` 组成。如果断言路由为真，则说明请求的 `URL` 和配置匹配

1. 断言

1. 1. `Java8` 中的断言函数。`Spring Cloud Gateway` 中的断言函数输入类型是 `Spring5.0` 框架中的 `ServerWebExchange`
2. `Spring Cloud Gateway` 中的断言函数允许开发者去定义匹配来自于 `http request`中的任何信息，比如请求头和参数等。

1. 过滤器

1. 1. 一个标准的 `Spring webFilter`
2. `Spring cloud gateway` 中的 `filter` 分为两种类型的 `Filter`，分别是 `Gateway Filter` 和 `Global Filter`
3. 过滤器 `Filter` 将会对请求和响应进行修改处理

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665583697696-62adc1ff-ad54-425d-b028-fc7bb7a7682c.png)



- 如图所示，`Spring cloud Gateway` 发出请求。
- 然后再由 `Gateway Handler Mapping` 中找到与请求相匹配的路由，将其发送到 `Gateway web handler`。
- `Handler`再通过指定的过滤器链将请求发送到实际的服务执行业务逻辑，然后返回



### 3.2 使用网关 `gateway`

#### 3.2.1 在 `ggkt_parent` 下创建子模块 `service_gateway`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665586377854-1bcda766-2dc1-49d3-b928-03e1145ac01b.png)

#### 3.2.2 依赖

```xml
<dependencies>
    <dependency>
        <groupId>com.atguigu</groupId>
        <artifactId>service_utils</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </dependency>

    <!-- 网关 -->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-gateway</artifactId>
    </dependency>

    <!-- 服务注册 -->
    <dependency>
        <groupId>com.alibaba.cloud</groupId>
        <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
    </dependency>
</dependencies>
```



#### 3.2.3 创建启动类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665586720767-889f7322-1aac-443e-9a6b-8098ddde3023.png)

```java
package com.atguigu.ggkt.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 陈江林
 * @date 2022/10/12 22:53
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApiGateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGateWayApplication.class, args);
    }
    
}
```



#### 3.2.4 配置文件 `application.yml`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665586735396-e4f6839a-602f-454e-bb75-f8e82c3ef384.png)

```yaml
# 服务端口
server:
	port: 8333

spring:
	# 服务名
	application:
		name: service-gateway
	# nacos服务地址
	cloud:
		nacos:
			discovery:
				server-addr: 127.0.0.1:8848
		# 使用服务发现路由
		gateway:
			discovery:
				locator:
					enabled: true
			# service-vod 模块配置
			# 设置路由id
			routes[0]:
				id: service-vod
				# 设置路由的uri
				uri: lb://service-vod
				# 设置路由断言,代理 servicerId 为 auth-service 的 /auth/ 路径
				predicates: Path=/*/vod/**
```



#### 3.2.5 创建测试类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665586556369-c888face-8b27-409a-9399-1cc1a5000b1c.png)

```java
package com.atguigu.ggkt.gateway;

/**
 * @author 陈江林
 * @date 2022/10/12 22:55
 */
public class ApiGateWayApplicationTest {
}
```





### 3.3 网关解决跨域问题

#### 3.3.1 跨域概述

- 跨域本质是浏览器对于 `ajax` 请求的一种安全限制：一个页面发起的 `ajax` 请求，只能是与当前页域名相同的路径，这能有效的阻止跨站攻击。

    - 因此：跨域问题 是针对 `ajax` 的一种限制。但是这却给我们的开发带来了不便，而且在实际生产环境中，肯定会有很多台服务器之间交互，地址和端口都可能不同。

- 之前我们通过服务器添加注解实现，现在我们跨域通过网关来解决跨域问题



#### 3.3.2 创建配置类 `CorsConfig`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665586764267-1e61de40-c2b1-43c9-b1a6-4104955a9d0b.png)

```java
package com.atguigu.ggkt.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.pattern.PathPatternParser;

/**
 * 跨域配置类
 *
 * @author 陈江林
 * @date 2022/10/12 22:59
 */
@Configuration
public class CorsConfig {

    /**
     * 处理跨域
     *
     * @return {@link CorsWebFilter}
     */
    @Bean
    public CorsWebFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedMethod("*");
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
        source.registerCorsConfiguration("/**", config);
        return new CorsWebFilter(source);
    }
    
}
```

- 删除所有注解 `@CrossOrigin`



### 3.4 修改前端接口

```latex
VUE_APP_BASE_API = 'http://localhost:8333'
```
# 十 订单管理模块

```
git checkout -b 10.0.0_order
```



## 1 环境准备

### 1.1 数据库表 `order_info`

```plsql
/*
SQLyog Ultimate - MySQL GUI v8.2 
MySQL - 5.7.29-32-log : Database - glkt_order
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
DROP DATABASE IF EXISTS `glkt_order`;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`glkt_order` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `glkt_order`;

/*Table structure for table `order_detail` */

DROP TABLE IF EXISTS `order_detail`;

CREATE TABLE `order_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `course_id` bigint(20) DEFAULT NULL COMMENT '课程id',
  `course_name` varchar(4000) DEFAULT NULL COMMENT '课程名称',
  `cover` varchar(255) DEFAULT NULL COMMENT '课程封面',
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `origin_amount` decimal(16,2) DEFAULT NULL COMMENT '原始金额',
  `coupon_reduce` decimal(16,2) DEFAULT NULL COMMENT '优惠劵减免金额',
  `final_amount` decimal(16,2) DEFAULT NULL COMMENT '最终金额',
  `session_id` varchar(4000) DEFAULT NULL COMMENT '会话id 当前会话id 继承购物车中会话id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_oid_cid` (`order_id`,`course_id`),
  KEY `idx_cid` (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='订单明细 订单明细';

/*Data for the table `order_detail` */

insert  into `order_detail`(`id`,`course_id`,`course_name`,`cover`,`order_id`,`user_id`,`origin_amount`,`coupon_reduce`,`final_amount`,`session_id`,`create_time`,`update_time`,`is_deleted`) values (1,19,'JAVA之Mysql基础','http://47.93.148.192:9000/gmall/20211122/1504320cbe2b246514.jpg',1,1,'1000.00','0.00','1000.00',NULL,'2021-11-22 13:38:47','2021-11-26 03:07:25',0),(2,7,'尚硅谷大数据技术之Sqoop','https://online-teach-file.oss-cn-beijing.aliyuncs.com/cover/2021/08/10/9452b057-6ad6-4600-891e-b168083fee4d.jpg',2,1,'23800.00','0.00','23800.00',NULL,'2021-11-23 10:09:08','2021-11-26 03:08:05',0),(3,19,'JAVA之Mysql基础','http://47.93.148.192:9000/gmall/20211122/1504320cbe2b246514.jpg',3,25,'1000.00','0.00','1000.00',NULL,'2021-11-23 10:54:51','2021-11-26 03:07:26',0),(4,18,'Java精品课程','https://online-teach-file.oss-cn-beijing.aliyuncs.com/cover/2021/08/09/e4ee03d7-52bd-41ca-99f9-04dc23250a71.jpg',4,1,'22800.00','0.00','22800.00',NULL,'2021-11-23 10:57:27','2021-11-26 03:07:41',0),(5,19,'JAVA之Mysql基础','http://47.93.148.192:9000/gmall/20211122/1504320cbe2b246514.jpg',5,27,'1000.00','0.00','1000.00',NULL,'2021-11-23 10:57:52','2021-11-26 03:07:27',0),(6,4,'尚硅谷大数据技术之HBase（2019新版）','https://online-teach-file.oss-cn-beijing.aliyuncs.com/cover/2021/08/09/a16c5694-3037-4330-b1c5-438052081fcb.jpg',6,1,'19800.00','0.00','19800.00',NULL,'2021-11-26 08:56:07','2021-11-26 08:56:07',0),(7,19,'JAVA之Mysql基础','http://47.93.148.192:9000/gmall/20211122/1504320cbe2b246514.jpg',7,29,'1000.00','0.00','1000.00',NULL,'2021-11-26 10:35:46','2021-11-26 10:35:46',0),(8,19,'JAVA之Mysql基础','http://47.93.148.192:9000/gmall/20211122/1504320cbe2b246514.jpg',8,32,'1000.00','0.00','1000.00',NULL,'2021-12-28 15:25:01','2021-12-28 15:25:01',0);

/*Table structure for table `order_info` */

DROP TABLE IF EXISTS `order_info`;

CREATE TABLE `order_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `nick_name` varchar(30) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `origin_amount` decimal(10,2) DEFAULT NULL COMMENT '原始金额',
  `coupon_reduce` decimal(10,2) DEFAULT NULL COMMENT '优惠券减免',
  `final_amount` decimal(10,2) DEFAULT NULL COMMENT '最终金额',
  `order_status` varchar(20) DEFAULT NULL COMMENT '订单状态',
  `out_trade_no` varchar(50) DEFAULT NULL COMMENT '订单交易编号（第三方支付用)',
  `trade_body` varchar(200) DEFAULT NULL COMMENT '订单描述(第三方支付用)',
  `session_id` varchar(100) DEFAULT NULL COMMENT 'session id',
  `province` varchar(20) DEFAULT NULL COMMENT '地区id',
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
  `expire_time` datetime DEFAULT NULL COMMENT '失效时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_uid` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='订单表 订单表';

/*Data for the table `order_info` */

insert  into `order_info`(`id`,`user_id`,`nick_name`,`phone`,`origin_amount`,`coupon_reduce`,`final_amount`,`order_status`,`out_trade_no`,`trade_body`,`session_id`,`province`,`pay_time`,`expire_time`,`create_time`,`update_time`,`is_deleted`) values (1,1,'晴天','15010546384','1000.00','500.00','500.00','1','20211122213847830','JAVA之Mysql基础',NULL,'成都','2021-11-22 21:39:12',NULL,'2021-11-22 13:38:47','2021-11-22 13:39:12',0),(2,1,'晴天','15010546384','23800.00','0.00','23800.00','1','20211123180908744','尚硅谷大数据技术之Sqoop',NULL,'成都','2021-11-23 18:09:32',NULL,'2021-11-23 10:09:08','2021-11-23 10:09:32',0),(3,25,'晨','13810168266','1000.00','0.00','1000.00','1','20211123185451570','JAVA之Mysql基础',NULL,'','2021-11-23 18:55:04',NULL,'2021-11-23 10:54:51','2021-11-23 10:55:04',0),(4,1,'晴天','15069352568','22800.00','500.00','22300.00','0','20211123185726513','Java精品课程',NULL,'成都',NULL,NULL,'2021-11-23 10:57:26','2021-11-23 10:57:26',0),(5,27,'******','17512080612','1000.00','500.00','500.00','0','20211123185752103','JAVA之Mysql基础',NULL,'',NULL,NULL,'2021-11-23 10:57:52','2021-11-23 10:57:52',0),(6,1,'晴天',NULL,'19800.00','0.00','19800.00','1','20211126165606808','尚硅谷大数据技术之HBase（2019新版）',NULL,'成都','2021-11-26 16:56:25',NULL,'2021-11-26 08:56:07','2021-11-26 08:56:24',0),(7,29,NULL,'13500009888','1000.00','0.00','1000.00','1','20211126183546799','JAVA之Mysql基础',NULL,'','2021-11-26 18:36:14',NULL,'2021-11-26 10:35:46','2021-11-26 10:36:13',0),(8,32,'',NULL,'1000.00','0.00','1000.00','0','20211228152501327','JAVA之Mysql基础',NULL,'',NULL,NULL,'2021-12-28 15:25:01','2021-12-28 15:25:01',0);

/*Table structure for table `payment_info` */

DROP TABLE IF EXISTS `payment_info`;

CREATE TABLE `payment_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `out_trade_no` varchar(50) DEFAULT NULL COMMENT '对外业务编号',
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) DEFAULT NULL,
  `alipay_trade_no` varchar(50) DEFAULT NULL COMMENT '支付宝交易编号',
  `total_amount` decimal(10,2) DEFAULT NULL COMMENT '支付金额',
  `trade_body` varchar(200) DEFAULT NULL COMMENT '交易内容',
  `payment_type` varchar(20) DEFAULT NULL,
  `payment_status` varchar(20) DEFAULT NULL COMMENT '支付状态',
  `callback_content` varchar(1000) DEFAULT NULL COMMENT '回调信息',
  `callback_time` datetime DEFAULT NULL COMMENT '回调时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_oid` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='支付信息表';

/*Data for the table `payment_info` */

insert  into `payment_info`(`id`,`out_trade_no`,`order_id`,`user_id`,`alipay_trade_no`,`total_amount`,`trade_body`,`payment_type`,`payment_status`,`callback_content`,`callback_time`,`create_time`,`update_time`,`is_deleted`) values (1,'20211122213847830',1,1,NULL,'0.01','JAVA之Mysql基础','2','2','{transaction_id=4200001236202111223264279278, nonce_str=60QD7Oevf9wU02zc, trade_state=SUCCESS, bank_type=OTHERS, openid=oQTXC56A4KDJuNRgj7hSoOqbxtDw, sign=1D685646F5D4D5BB4AEA9A3285A322B0, return_msg=OK, fee_type=CNY, mch_id=1481962542, cash_fee=1, out_trade_no=20211122213847830, cash_fee_type=CNY, appid=wxf913bfa3a2c7eeeb, total_fee=1, trade_state_desc=支付成功, trade_type=JSAPI, result_code=SUCCESS, attach=, time_end=20211122213909, is_subscribe=Y, return_code=SUCCESS}','2021-11-22 21:39:12','2021-11-22 21:38:55','2021-11-22 13:39:12',0),(2,'20211123180908744',2,1,NULL,'0.01','尚硅谷大数据技术之Sqoop','2','2','{transaction_id=4200001120202111230211882387, nonce_str=wn4XulMGtpBWmHvP, trade_state=SUCCESS, bank_type=OTHERS, openid=oQTXC56A4KDJuNRgj7hSoOqbxtDw, sign=0F505EC786ECC4C649578D8A71DE139C, return_msg=OK, fee_type=CNY, mch_id=1481962542, cash_fee=1, out_trade_no=20211123180908744, cash_fee_type=CNY, appid=wxf913bfa3a2c7eeeb, total_fee=1, trade_state_desc=支付成功, trade_type=JSAPI, result_code=SUCCESS, attach=, time_end=20211123180927, is_subscribe=Y, return_code=SUCCESS}','2021-11-23 18:09:32','2021-11-23 18:09:15','2021-11-23 10:09:32',0),(3,'20211123185451570',3,25,NULL,'0.01','JAVA之Mysql基础','2','2','{transaction_id=4200001123202111233106099225, nonce_str=VNHOOhJVvGW8V0xo, trade_state=SUCCESS, bank_type=OTHERS, openid=oQTXC5zyE9p-gp7T_qUnFlv8VbB0, sign=CE0049BC9A1922CF70F423AC406BEB88, return_msg=OK, fee_type=CNY, mch_id=1481962542, cash_fee=1, out_trade_no=20211123185451570, cash_fee_type=CNY, appid=wxf913bfa3a2c7eeeb, total_fee=1, trade_state_desc=支付成功, trade_type=JSAPI, result_code=SUCCESS, attach=, time_end=20211123185502, is_subscribe=N, return_code=SUCCESS}','2021-11-23 18:55:04','2021-11-23 18:54:53','2021-11-23 10:55:04',0),(4,'20211123185726513',4,1,NULL,'0.01','Java精品课程','2','1',NULL,NULL,'2021-11-23 18:57:30','2021-11-23 10:57:30',0),(5,'20211123185752103',5,27,NULL,'0.01','JAVA之Mysql基础','2','1',NULL,NULL,'2021-11-23 18:57:53','2021-11-23 10:57:53',0),(6,'20211126165606808',6,1,NULL,'0.01','尚硅谷大数据技术之HBase（2019新版）','2','2','{transaction_id=4200001146202111266807786474, nonce_str=xTJGeq7F0Dz0c0U8, trade_state=SUCCESS, bank_type=OTHERS, openid=oQTXC56A4KDJuNRgj7hSoOqbxtDw, sign=201D5B989A83376A3AA34DFDAB457CFF, return_msg=OK, fee_type=CNY, mch_id=1481962542, cash_fee=1, out_trade_no=20211126165606808, cash_fee_type=CNY, appid=wxf913bfa3a2c7eeeb, total_fee=1, trade_state_desc=支付成功, trade_type=JSAPI, result_code=SUCCESS, attach=, time_end=20211126165619, is_subscribe=Y, return_code=SUCCESS}','2021-11-26 16:56:24','2021-11-26 16:56:09','2021-11-26 08:56:24',0),(7,'20211126183546799',7,29,NULL,'0.01','JAVA之Mysql基础','2','2','{transaction_id=4200001228202111261700574727, nonce_str=pzhJ1kkbfSwFMslY, trade_state=SUCCESS, bank_type=OTHERS, openid=oQTXC51A-QwGey9bsMH0rwP6pj0g, sign=5B8528ED454C09E24F4297A97345FD87, return_msg=OK, fee_type=CNY, mch_id=1481962542, cash_fee=1, out_trade_no=20211126183546799, cash_fee_type=CNY, appid=wxf913bfa3a2c7eeeb, total_fee=1, trade_state_desc=支付成功, trade_type=JSAPI, result_code=SUCCESS, attach=, time_end=20211126183611, is_subscribe=Y, return_code=SUCCESS}','2021-11-26 18:36:14','2021-11-26 18:35:48','2021-11-26 10:36:13',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
```

### 1.2 创建订单模块

- `service` -> `service_order`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665618391558-72097ea4-6190-4a02-be3d-412f1f7c7d60.png)

### 1.3 生成代码

- 数据库 `glkt_order`
- `"order_info", "order_detail"`

- 删除实体
- 删除 `OrderDetailController`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665619389584-0607c535-43b8-4e26-a9c8-98c719d47bcd.png)



### 1.4 创建启动类 `ServiceOrderApplication`

```java
package com.atguigu.ggkt.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 陈江林
 * @date 2022/10/13 07:53
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ServiceOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceOrderApplication.class, args);
    }

}
```

### 1.5 创建配置类 `application.yml`

```yaml
# 服务端口
server:
  port: 8302

spring:
  application:
    name: service-order
  # 环境设置：dev、test、prod
  profiles:
    active:
      dev
  # mysql数据库连接
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://localhost:3306/glkt_order?characterEncoding=utf-8&useSSL=false
    username: root
    password: 12345678
  #返回json的全局时间格式
  jackson:
    date-format: yyyy-MM-dd HH:mm:ss
    time-zone: GMT+8
  # nacos 地址
  cloud:
    nacos:
      discovery:
        server-addr: 127.0.0.1:8848

  #mybatis日志
mybatis-plus:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
  mapper-locations: classpath:com/atguigu/ggkt/order/mapper/xml/*.xml
```

### 1.6 创建测试类 `OrderApplicationTest`

```java
package com.atguigu.ggkt.order;

/**
 * @author 陈江林
 * @date 2022/10/13 08:00
 */
public class OrderApplicationTest {
}
```



### 1.7 新建配置类 `MybatisPlusConfig`

```java
package com.atguigu.ggkt.order.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisPlus 配置类
 *
 * @author 陈江林
 * @date 2022/10/13 08:16
 */
@Configuration
@MapperScan("com.atguigu.ggkt.order.mapper")
public class MybatisPlusConfig {

    /**
     * 版本要求：3.4.0 版本以上
     * 新的分页插件,一缓和二缓遵循 mybatis 的规则, 需要设置 MybatisConfiguration#useDeprecatedExecutor = false 避免缓存出现问题(该属性会在旧插件移除后一同移除)
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.H2));
        return interceptor;
    }

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> configuration.setUseDeprecatedExecutor(false);
    }

}
```

## 2 订单列表接口

### 2.1 控制类

```java
package com.atguigu.ggkt.order.controller;


import com.atguigu.ggkt.order.service.OrderInfoService;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vo.order.OrderInfoQueryVo;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-13
 */
@RestController
@RequestMapping("/admin/order/orderInfo")
public class OrderInfoController {

    @Autowired
    private OrderInfoService orderInfoService;

    @GetMapping("/{page}/{limit}")
    public Result<Map<String, Object>> listOrder(
            @ApiParam(name = "page", value = "当前页码")
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数")
            @PathVariable Long limit,

            @ApiParam(name = "orderInfoQueryVo", value = "查询条件对象")
            OrderInfoQueryVo orderInfoQueryVo
    ) {
        Map<String, Object> map = orderInfoService.selectOrderInfoPage(page, limit, orderInfoQueryVo);
        return Result.ok(map);
    }

}
```



### 2.2 服务实现类

```java
package com.atguigu.ggkt.order.service.impl;

import com.atguigu.ggkt.model.order.OrderDetail;
import com.atguigu.ggkt.model.order.OrderInfo;
import com.atguigu.ggkt.order.mapper.OrderInfoMapper;
import com.atguigu.ggkt.order.service.OrderDetailService;
import com.atguigu.ggkt.order.service.OrderInfoService;
import com.atguigu.ggkt.vo.order.OrderInfoQueryVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-13
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {

    @Autowired
    private OrderDetailService orderDetailService;

    @Override
    public Map<String, Object> selectOrderInfoPage(Long page, Long limit, OrderInfoQueryVo orderInfoQueryVo) {
        Map<String, Object> map = new HashMap<>();
        // 创建条件对象
        LambdaQueryWrapper<OrderInfo> wrapper = new LambdaQueryWrapper<>();
        // 创建分页对象
        IPage<OrderInfo> pageParam = new Page<>(page, limit);

        // 判断查询条件
        if (orderInfoQueryVo != null) {
            Long userId = orderInfoQueryVo.getUserId();
            String outTradeNo = orderInfoQueryVo.getOutTradeNo();
            String phone = orderInfoQueryVo.getPhone();
            String createTimeEnd = orderInfoQueryVo.getCreateTimeEnd();
            String createTimeBegin = orderInfoQueryVo.getCreateTimeBegin();
            Integer orderStatus = orderInfoQueryVo.getOrderStatus();

            if (!StringUtils.isEmpty(orderStatus)) {
                wrapper.eq(OrderInfo::getOrderStatus, orderStatus);
            }

            if (!StringUtils.isEmpty(userId)) {
                wrapper.eq(OrderInfo::getUserId, userId);
            }

            if (!StringUtils.isEmpty(outTradeNo)) {
                wrapper.eq(OrderInfo::getOutTradeNo, outTradeNo);
            }

            if (!StringUtils.isEmpty(phone)) {
                wrapper.eq(OrderInfo::getPhone, phone);
            }

            if (!StringUtils.isEmpty(createTimeBegin)) {
                wrapper.ge(OrderInfo::getCreateTime, createTimeBegin);
            }

            if (!StringUtils.isEmpty(createTimeEnd)) {
                wrapper.le(OrderInfo::getCreateTime, createTimeEnd);
            }
        }

        // 分页查询
        IPage<OrderInfo> pages = baseMapper.selectPage(pageParam, wrapper);
        long totalCount = pages.getTotal();
        long pageCount = pages.getPages();
        List<OrderInfo> records = pages.getRecords();
        // 订单里面包含详情内容，封装详情数据，根据订单id查询详情
        records.forEach(orderInfo -> {
            // 订单 id
            Long id = orderInfo.getId();
            // 根据订单 id 查询订单详情
            LambdaQueryWrapper<OrderDetail> lambdaQueryWrapper = new LambdaQueryWrapper();
            lambdaQueryWrapper.eq(OrderDetail::getOrderId, id);
            OrderDetail orderDetail = orderDetailService.getOne(lambdaQueryWrapper);
            if(orderDetail != null) {
                String courseName = orderDetail.getCourseName();
                orderInfo.getParam().put("courseName", courseName);
            }
        });

        // 所有需要数据封装map集合，最终返回
        map.put("total", totalCount);
        map.put("pageCount", pageCount);
        map.put("records", records);
        return map;
    }
}
```



## 3 网关配置新服务

```yaml
routes[1]:
	id: service-order
	uri: lb://service-order
	predicates: Path=/admin/order/**
```



## 4 订单列表前端

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665634339054-fd36b6db-0703-485a-b8e1-733fef08b36f.png)

### 4.1 `API`

- `orderInfo.js`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665633377994-5a5162b6-5721-4fdb-89e5-b3427a05753c.png)

```javascript
import request from '@/utils/request'

const api_name = '/admin/order/orderInfo'

export default {

  getPageList(page, limit, params) {
    return request({
      url: `${api_name}/${page}/${limit}`,
      method: 'get',
      params
    })
  }
}
```



### 4.2 路由

```javascript
  {
    path: '/order/orderinfo',
    component: Layout,
    redirect: '/order/orderinfo/List',
    name: 'Order',
    meta: { title: '订单管理', icon: 'el-icon-truck' },
    alwaysShow: true,
    children: [
      {
        path: 'List',
        name: 'OrderInfoList',
        component: () => import('@/views/order/orderinfo/List'),
        meta: { title: '订单列表' }
      }
    ]
  },
```



### 4.3 创建对应页面

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665636154984-dc203c54-0c98-4b4b-ada1-88109770e354.png)

```vue
<template>
  <div class="app-container">
    <el-card class="operate-container" shadow="never">
      <el-form :inline="true" class="demo-form-inline">
        <el-form-item>
          <el-input v-model="searchObj.outTradeNo" placeholder="订单号"/>
        </el-form-item>
        <el-form-item>
          <el-input v-model="searchObj.phone" placeholder="手机"/>
        </el-form-item>
        <el-form-item>
          <el-date-picker
            v-model="searchObj.createTimeBegin"
            type="date"
            placeholder="选择下单开始日期"
            value-format="yyyy-MM-dd"/>
        </el-form-item>
        <el-form-item>
          <el-date-picker
            v-model="searchObj.createTimeEnd"
            type="date"
            placeholder="选择截止日期"
            value-format="yyyy-MM-dd"/>
        </el-form-item>
        <el-form-item>
          <el-select v-model="searchObj.orderStatus" placeholder="订单状态" class="v-select patient-select">
            <el-option
              v-for="item in statusList"
              :key="item.status"
              :label="item.name"
              :value="item.status">
            </el-option>
          </el-select>
        </el-form-item>
        <el-button type="primary" icon="el-icon-search" @click="fetchData()">查询</el-button>
        <el-button type="default" @click="resetData()">清空</el-button>
      </el-form>
    </el-card>
    <!-- 列表 -->
    <el-table
      v-loading="listLoading"
      :data="list"
      border
      fit
      highlight-current-row>
      <el-table-column
        label="序号"
        width="60"
        align="center">
        <template slot-scope="scope">
          {{ (page - 1) * limit + scope.$index + 1 }}
        </template>
      </el-table-column>
      <el-table-column prop="outTradeNo" label="订单号" width="160"/>
      <el-table-column prop="courseName" label="课程名称" width="160">
        <template slot-scope="scope">
          {{ scope.row.param.courseName }}
        </template>
      </el-table-column>
      <el-table-column prop="finalAmount" label="订单金额" width="90"/>
      <el-table-column prop="nickName" label="下单用户"/>
      <el-table-column prop="phone" label="用户手机"/>
      <el-table-column prop="payTime" label="支付时间" width="156"/>
      <el-table-column prop="orderStatus" label="订单状态">
        <template slot-scope="scope">
          {{ scope.row.orderStatus == 0 ? '未支付' : '已支付' }}
        </template>
      </el-table-column>
      <el-table-column prop="createTime" label="下单时间" width="156"/>
    </el-table>
    <!-- 分页组件 -->
    <el-pagination
      :current-page="page"
      :total="total"
      :page-size="limit"
      :page-sizes="[5, 10, 20, 30, 40, 50, 100]"
      style="padding: 30px 0; text-align: center;"
      layout="sizes, prev, pager, next, jumper, ->, total, slot"
      @current-change="fetchData"
      @size-change="changeSize"
    />
  </div>
</template>
<script>
import orderInfoApi from '@/api/order/orderInfo'

export default {
  data() {
    return {
      listLoading: true, // 数据是否正在加载
      list: null, // banner列表
      total: 0, // 数据库中的总记录数
      page: 1, // 默认页码
      limit: 10, // 每页记录数
      searchObj: {}, // 查询表单对象
      statusList: [
        {
          'status': 0,
          'name': '未支付'
        },
        {
          'status': 1,
          'name': '已支付'
        }
      ]
    }
  },
  // 生命周期函数：内存准备完毕，页面尚未渲染
  created() {
    this.fetchData()
  },
  // 生命周期函数：内存准备完毕，页面渲染成功
  mounted() {
    console.log('list mounted......')
  },
  methods: {
    // 当页码发生改变的时候
    changeSize(size) {
      this.limit = size
      this.fetchData(1)
    },
    // 加载banner列表数据
    fetchData(page = 1) {
      // 异步获取远程数据（ajax）
      this.page = page
      orderInfoApi.getPageList(this.page, this.limit, this.searchObj).then(
        response => {
          this.list = response.data.records
          this.total = response.data.total
          // 数据加载并绑定成功
          this.listLoading = false
        }
      )
    },
    // 重置查询表单
    resetData() {
      console.log('重置查询表单')
      this.searchObj = {}
      this.fetchData()
    }
  }
}
</script>

<style scoped>

</style>
```

# 十一 营销管理模块

```
git checkout -b 11.0.0_activity
```

## 1 环境准备

### 1.1 数据库

```plsql
/*
SQLyog Ultimate - MySQL GUI v8.2 
MySQL - 5.7.29-32-log : Database - glkt_activity
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
DROP DATABASE IF EXISTS `glkt_activity`;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`glkt_activity` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `glkt_activity`;

/*Table structure for table `coupon_info` */

DROP TABLE IF EXISTS `coupon_info`;

CREATE TABLE `coupon_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `coupon_type` tinyint(3) NOT NULL DEFAULT '1' COMMENT '购物券类型 1 注册卷 2：推荐赠送卷',
  `coupon_name` varchar(100) DEFAULT NULL COMMENT '优惠卷名字',
  `amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '金额',
  `condition_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '使用门槛 0->没门槛',
  `start_time` date DEFAULT NULL COMMENT '可以领取的开始日期',
  `end_time` date DEFAULT NULL COMMENT '可以领取的结束日期',
  `range_type` tinyint(3) NOT NULL DEFAULT '1' COMMENT '使用范围[1->全场通用]',
  `rule_desc` varchar(200) DEFAULT NULL COMMENT '规则描述',
  `publish_count` int(11) NOT NULL DEFAULT '1' COMMENT '发行数量',
  `per_limit` int(11) NOT NULL DEFAULT '1' COMMENT '每人限领张数',
  `use_count` int(11) NOT NULL DEFAULT '0' COMMENT '已使用数量',
  `receive_count` int(11) NOT NULL DEFAULT '0' COMMENT '领取数量',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `publish_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '发布状态[0-未发布，1-已发布]',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0' COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='优惠券信息';

/*Data for the table `coupon_info` */

insert  into `coupon_info`(`id`,`coupon_type`,`coupon_name`,`amount`,`condition_amount`,`start_time`,`end_time`,`range_type`,`rule_desc`,`publish_count`,`per_limit`,`use_count`,`receive_count`,`expire_time`,`publish_status`,`create_time`,`update_time`,`is_deleted`) values (1,1,'双十一新用户注册赠送100元卷','100.00','0.00','2021-06-03','2022-07-10',2,'双十一新用户注册赠送100元卷，全程通用，没有限制',100,1,0,3,'2021-07-02 00:00:00',1,'2021-06-06 18:29:14','2021-11-12 08:30:39',0),(2,1,'双十一推荐课程并购买600福利卷','600.00','0.00','2021-08-04','2022-10-06',2,'双十一推荐课程，新用户购买并支付，赠送推荐人600福利卷，全程通用，没有限制',100,1,0,4,'2022-08-26 00:00:00',1,'2021-08-17 11:35:56','2021-11-12 08:31:37',0),(3,2,'国庆新用户注册赠送100元卷','100.00','0.00','2021-09-05','2022-10-06',1,'国庆新用户注册赠送100元卷，全程通用，没有限制',100,1,0,4,'2021-10-07 00:00:00',1,'2021-09-28 06:14:38','2021-11-12 08:31:10',0),(4,1,'国庆推荐课程并购买500福利卷','500.00','0.00','2021-09-27','2022-09-23',1,'双十一推荐课程，新用户购买并支付，赠送推荐人500福利卷，全程通用，没有限制',100,1,0,25,'2022-09-30 00:00:00',1,'2021-09-28 06:50:17','2021-11-12 08:31:16',0);

/*Table structure for table `coupon_use` */

DROP TABLE IF EXISTS `coupon_use`;

CREATE TABLE `coupon_use` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `coupon_id` bigint(20) DEFAULT NULL COMMENT '购物券ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单ID',
  `coupon_status` varchar(10) DEFAULT NULL COMMENT '购物券状态（1：未使用 2：已使用）',
  `get_time` datetime DEFAULT NULL COMMENT '获取时间',
  `using_time` datetime DEFAULT NULL COMMENT '使用时间',
  `used_time` datetime DEFAULT NULL COMMENT '支付时间',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COMMENT='优惠券领用表';

/*Data for the table `coupon_use` */

insert  into `coupon_use`(`id`,`coupon_id`,`user_id`,`order_id`,`coupon_status`,`get_time`,`using_time`,`used_time`,`expire_time`,`create_time`,`update_time`,`is_deleted`) values (1,1,1,NULL,'0','2021-11-10 09:02:23',NULL,NULL,'2021-07-02 00:00:00','2021-11-10 09:02:23','2021-11-22 07:59:00',0),(2,1,1,NULL,'0','2021-11-10 09:02:23',NULL,NULL,'2022-07-02 00:00:00','2021-11-10 09:02:28','2021-11-22 07:59:02',0),(5,4,1,4,'1','2021-11-12 16:37:00','2021-11-23 18:57:27',NULL,'2022-09-30 00:00:00','2021-11-12 08:36:58','2021-11-23 10:57:27',0),(9,4,1,1,'1','2021-11-22 14:50:05','2021-11-22 21:38:48','2021-11-22 21:39:12','2022-09-30 00:00:00','2021-11-22 14:50:05','2021-11-22 13:39:12',0),(27,4,24,NULL,'0','2021-11-23 18:14:01',NULL,NULL,'2022-09-30 00:00:00','2021-11-23 10:14:01','2021-11-23 10:14:01',0),(28,4,25,NULL,'0','2021-11-23 18:49:01',NULL,NULL,'2022-09-30 00:00:00','2021-11-23 10:49:00','2021-11-23 10:49:00',0),(29,4,26,NULL,'0','2021-11-23 18:49:03',NULL,NULL,'2022-09-30 00:00:00','2021-11-23 10:49:03','2021-11-23 10:49:03',0),(30,4,27,5,'1','2021-11-23 18:50:03','2021-11-23 18:57:52',NULL,'2022-09-30 00:00:00','2021-11-23 10:50:02','2021-11-23 10:57:52',0),(31,4,28,NULL,'0','2021-11-23 18:52:49',NULL,NULL,'2022-09-30 00:00:00','2021-11-23 10:52:49','2021-11-23 10:52:49',0),(32,4,29,NULL,'0','2021-11-26 08:57:40',NULL,NULL,'2022-09-30 00:00:00','2021-11-26 00:57:39','2021-11-26 00:57:39',0),(33,4,29,NULL,'0','2021-11-26 18:33:04',NULL,NULL,'2022-09-30 00:00:00','2021-11-26 10:33:03','2021-11-26 10:33:03',0),(34,4,30,NULL,'0','2021-11-26 18:34:12',NULL,NULL,'2022-09-30 00:00:00','2021-11-26 10:34:11','2021-11-26 10:34:11',0),(35,4,31,NULL,'0','2021-11-28 16:46:53',NULL,NULL,'2022-09-30 00:00:00','2021-11-28 08:46:53','2021-11-28 08:46:53',0),(36,4,32,NULL,'0','2021-12-28 12:29:18',NULL,NULL,'2022-09-30 00:00:00','2021-12-28 12:29:17','2021-12-28 12:29:17',0),(37,4,33,NULL,'0','2022-01-05 14:35:16',NULL,NULL,'2022-09-30 00:00:00','2022-01-05 14:35:15','2022-01-05 14:35:15',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
```

###  

### 1.2 创建工程模块 `service_activity`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665640096641-3ab6407d-baae-4dbd-8f53-c8b72772256a.png)



### 1.3 生成代码

- 工程路径
- 数据库名称
- 表名 `strategy.setInclude("coupon_info", "coupon_use");`

1. 删除 `entity`
2. 删除 `CouponUseController`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665640376776-814aa924-c197-4beb-a465-b009dee1923f.png)



### 1.4 新建启动类 `ServiceActivityApplication`

```java
package com.atguigu.ggkt.activity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 陈江林
 * @date 2022/10/13 13:54
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ServiceActivityApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceActivityApplication.class, args);
    }
    
}
```



### 1.5 新建配置文件 `application.yml`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665640589613-83f7b885-4c0f-49ea-9f7b-b0a67643a377.png)

```yaml
# 服务端口
server:
  port: 8303

spring:
  application:
    name: service_activity
  # 环境设置：dev、test、prod
  profiles:
    active:
      dev
  # mysql数据库连接
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://localhost:3306/glkt_activity?characterEncoding=utf-8&useSSL=false
    username: root
    password: 12345678
  #返回json的全局时间格式
  jackson:
    date-format: yyyy-MM-dd HH:mm:ss
    time-zone: GMT+8
  # nacos 地址
  cloud:
    nacos:
      discovery:
        server-addr: 127.0.0.1:8848

  #mybatis日志
mybatis-plus:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
  mapper-locations: classpath:com/atguigu/ggkt/activity/mapper/xml/*.xml
```



### 1.6 新建测试文件 `ServiceActivityApplicationTest`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665640608820-b89cc5f0-6ae4-48df-a262-3e51eea3b75a.png)

```java
package com.atguigu.ggkt.activity;

/**
 * @author 陈江林
 * @date 2022/10/13 13:56
 */
public class ServiceActivityApplicationTest {
}
```



### 1.7 新建 `MP` 配置文件

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665640692789-3b578780-de1c-4321-ab92-25a0dc8cd24c.png)

```java
package com.atguigu.ggkt.activity.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisPlus 配置类
 * 
 * @author 陈江林
 * @date 2022/10/13 13:57
 */
@Configuration
@MapperScan("com.atguigu.ggkt.activity.mapper")
public class MybatisPlusConfig {

    /**
     * 版本要求：3.4.0 版本以上
     * 新的分页插件,一缓和二缓遵循 mybatis 的规则, 需要设置 MybatisConfiguration#useDeprecatedExecutor = false 避免缓存出现问题(该属性会在旧插件移除后一同移除)
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.H2));
        return interceptor;
    }

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> configuration.setUseDeprecatedExecutor(false);
    }

}
```



### 1.8 配置网关

```yaml
routes[2]:
  id: service-activity
  uri: lb://service-activity
  predicates: Path=/admin/activity/**
```



## 2 优惠券接口

### 2.1 控制类

```java
package com.atguigu.ggkt.activity.controller;


import com.atguigu.ggkt.activity.service.CouponInfoService;
import com.atguigu.ggkt.model.activity.CouponInfo;
import com.atguigu.ggkt.model.activity.CouponUse;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vo.activity.CouponUseQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 优惠券信息 前端控制器
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-13
 */
@Api(tags = "优惠券")
@RestController
@RequestMapping("/admin/activity/couponInfo")
public class CouponInfoController {

    @Autowired
    private CouponInfoService couponInfoService;

    @ApiOperation(value = "获取分页列表")
    @GetMapping("/{page}/{limit}")
    public Result index(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit) {
        Page<CouponInfo> pageParam = new Page<>(page, limit);
        IPage<CouponInfo> pageModel = couponInfoService.page(pageParam);
        return Result.ok(pageModel);
    }

    @ApiOperation(value = "获取优惠券")
    @GetMapping("/get/{id}")
    public Result get(@PathVariable String id) {
        CouponInfo couponInfo = couponInfoService.getById(id);
        return Result.ok(couponInfo);
    }

    @ApiOperation(value = "新增优惠券")
    @PostMapping("/save")
    public Result save(@RequestBody CouponInfo couponInfo) {
        couponInfoService.save(couponInfo);
        return Result.ok();
    }

    @ApiOperation(value = "修改优惠券")
    @PutMapping("/update")
    public Result updateById(@RequestBody CouponInfo couponInfo) {
        couponInfoService.updateById(couponInfo);
        return Result.ok();
    }

    @ApiOperation(value = "删除优惠券")
    @DeleteMapping("/remove/{id}")
    public Result remove(@PathVariable String id) {
        couponInfoService.removeById(id);
        return Result.ok();
    }

    @ApiOperation(value = "根据id列表删除优惠券")
    @DeleteMapping("/batchRemove")
    public Result batchRemove(@RequestBody List<String> idList) {
        couponInfoService.removeByIds(idList);
        return Result.ok();
    }

    @ApiOperation(value = "获取分页列表")
    @GetMapping("/couponUse/{page}/{limit}")
    public Result index(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,
            @ApiParam(name = "couponUseVo", value = "查询对象", required = false)
                    CouponUseQueryVo couponUseQueryVo) {
        Page<CouponUse> pageParam = new Page<>(page, limit);
        IPage<CouponUse> pageModel = couponInfoService.selectCouponUsePage(pageParam, couponUseQueryVo);
        return Result.ok(pageModel);
    }
}
```



### 2.2 服务实现类





## 3 获取用户信息接口

### 3.1 环境准备

#### 3.1.1 数据库

```plsql
/*
SQLyog Ultimate - MySQL GUI v8.2 
MySQL - 5.7.29-32-log : Database - glkt_user
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
DROP DATABASE IF EXISTS `glkt_user`;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`glkt_user` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `glkt_user`;

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `phone` varchar(200) DEFAULT NULL COMMENT '手机号',
  `password` varchar(200) DEFAULT NULL COMMENT '用户密码',
  `name` varchar(200) DEFAULT NULL COMMENT '用户姓名',
  `nick_name` varchar(100) DEFAULT NULL COMMENT '昵称',
  `sex` tinyint(3) DEFAULT NULL COMMENT '性别',
  `avatar` varchar(200) DEFAULT NULL COMMENT '头像',
  `province` varchar(30) DEFAULT NULL,
  `subscribe` tinyint(3) NOT NULL DEFAULT '0' COMMENT '0：未订阅 1：已订阅',
  `open_id` varchar(45) DEFAULT NULL COMMENT '小程序open id',
  `union_id` varchar(45) DEFAULT NULL COMMENT '微信开放平台unionID',
  `recommend_id` bigint(20) DEFAULT NULL COMMENT '推荐人用户id',
  `status` tinyint(3) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

/*Data for the table `user_info` */

insert  into `user_info`(`id`,`phone`,`password`,`name`,`nick_name`,`sex`,`avatar`,`province`,`subscribe`,`open_id`,`union_id`,`recommend_id`,`status`,`create_time`,`update_time`,`is_deleted`) values (1,'15611248741',NULL,NULL,'晴天',1,'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIB1WtJibSTqXvnJccFhOR1cSpVpdQ3BP5eTPCUO9CyI1feDefMoUFyA4E2C1oe2j8VMLrtAyBricvA/132','成都',0,'oQTXC56A4KDJuNRgj7hSoOqbxtDw',NULL,NULL,NULL,'2021-10-21 07:19:29','2021-11-23 11:32:44',0),(24,'13562359685',NULL,NULL,'简',0,'https://thirdwx.qlogo.cn/mmopen/vi_32/2GVkdw3J3kLruw37EYdW6RsFNUEL5mX5K3tgDolibM8hYICibPXpFIneMzyQpkFI0TsnE8R5ryUMvriaBmBNmNOsQ/132','',0,'oQTXC51A-QwGey9bsMH0rwP6pj0g0',NULL,1,NULL,'2021-11-23 10:14:00','2021-11-26 10:31:55',0),(25,'13810168266',NULL,NULL,'晨',0,'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIB1WtJibSTqXsnvhFoEV7vpEMZkCfT0E9ib1TnUFHUYSppWy575onuuEDH8NRwU4aDj8PwXjQjY9OA/132','',0,'oQTXC5zyE9p-gp7T_qUnFlv8VbB0',NULL,1,NULL,'2021-11-23 10:49:00','2021-11-26 08:45:40',0),(26,'13716962779',NULL,NULL,'张晓飞',0,'https://thirdwx.qlogo.cn/mmopen/vi_32/vByI6bJx9js2GLBicLYGXJKy5cnRq9ojCBNmk3Zesakia8eShdfwV6JLfIumJyEPtLerUlQDwcF6ng8OuugaKEjg/132','',0,'oQTXC5xUafs2LDYATkXsXigZkE98',NULL,1,NULL,'2021-11-23 10:49:03','2021-11-26 08:45:40',0),(27,'17512080612',NULL,NULL,'我是',0,'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqhPquGcKzauUrwFxf82UfZVGbXApUU2vXhnQ7ZmSyHkGnPpUibahRs49vJcibTp1Co8iawppr0McL2A/132','',0,'oQTXC5znK6fxptadSmzTwjNIPbKo',NULL,1,NULL,'2021-11-23 10:50:02','2021-11-26 08:45:41',0),(28,'15901520518',NULL,NULL,'婷儿姐',0,'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIVXAe2FkRhjYicibOVzMZrsEaObjmNMes9ru9ZNjx6WXt6aQSQsiccw25r2FzeGIqlUcYson4uQ8Bcw/132','',0,'oQTXC51Qq1bxuVcpivsiW3xeC6Us',NULL,1,NULL,'2021-11-23 10:52:48','2021-11-26 08:45:42',0),(29,'13500009888',NULL,NULL,'吧',0,'https://thirdwx.qlogo.cn/mmopen/vi_32/2GVkdw3J3kLruw37EYdW6RsFNUEL5mX5K3tgDolibM8hYICibPXpFIneMzyQpkFI0TsnE8R5ryUMvriaBmBNmNOsQ/132','',0,'oQTXC51A-QwGey9bsMH0rwP6pj0g',NULL,NULL,NULL,'2021-11-26 10:33:03','2021-11-26 10:39:46',0),(30,'13766816630',NULL,NULL,'环',0,'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTInJ6LZx4So2d41ZWmv0z9hmM4yaE2dn2gvBeiasssw66NQCibuou4icHyMhjdu9ZQR6xiav2qswyNylA/132','',0,'oQTXC5x67M6p0kvuP8aDUrz3WZPg',NULL,NULL,NULL,'2021-11-26 10:34:11','2021-11-26 10:39:52',0),(31,NULL,NULL,NULL,'ya',0,'https://thirdwx.qlogo.cn/mmopen/vi_32/fw0kHmJ1rqCwcibxTYUTBZ3KltT74MG7hnhCRd5EAazTDibckZ4gKR11iaVa1dM8BiccZXpnXv2rVnJLDltB7mCnrA/132','',0,'oQTXC51_nDWnWRosSd-LxCfq_5l0',NULL,NULL,NULL,'2021-11-28 08:46:52','2021-11-28 08:46:52',0),(32,'15611248741',NULL,NULL,'',0,'','',1,'oQTXC56lAy3xMOCkKCImHtHoLLN4',NULL,NULL,NULL,'2021-12-28 12:29:17','2021-12-28 12:29:17',0),(33,'13521096172',NULL,NULL,'testatguigu',0,'','',0,'oQTXC52GRKUUFk6WVH4yF22R3NlM',NULL,NULL,NULL,'2022-01-05 14:35:15','2022-01-05 14:35:15',0);

/*Table structure for table `user_login_log` */

DROP TABLE IF EXISTS `user_login_log`;

CREATE TABLE `user_login_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `ip` varchar(64) DEFAULT NULL COMMENT '登录ip',
  `city` varchar(64) DEFAULT NULL COMMENT '登录城市',
  `type` tinyint(1) DEFAULT NULL COMMENT '登录类型【0-web，1-移动】',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0' COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户登陆记录表';

/*Data for the table `user_login_log` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
```



#### 3.1.2 创建工程模块 `service_user`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665641605224-06103bf5-a90d-4cf8-bdfb-d3fa353fd70c.png)



#### 3.1.3 生成代码

- 工程路径
- 数据库名称
- 表名 `strategy.setInclude("user_info");`

1. 删除 `entity`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665641749528-8e7c9dd5-5628-4633-a514-1f8b370d4269.png)



#### 3.1.4 新建启动类 `ServiceUserApplication`

```java
package com.atguigu.ggkt.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 陈江林
 * @date 2022/10/13 14:16
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ServiceUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceUserApplication.class, args);
    }

}
```



#### 3.1.5 新建配置文件 `application.yml`

```yaml
# 服务端口
server:
  port: 8304

spring:
  application:
    name: service_user
  # 环境设置：dev、test、prod
  profiles:
    active:
      dev
  # mysql数据库连接
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://localhost:3306/glkt_user?characterEncoding=utf-8&useSSL=false
    username: root
    password: 12345678
  #返回json的全局时间格式
  jackson:
    date-format: yyyy-MM-dd HH:mm:ss
    time-zone: GMT+8
  # nacos 地址
  cloud:
    nacos:
      discovery:
        server-addr: 127.0.0.1:8848

  #mybatis日志
mybatis-plus:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
  mapper-locations: classpath:com/atguigu/ggkt/user/mapper/xml/*.xml
```



#### 3.1.6 新建测试文件 `ServiceActivityApplicationTest`

```java
package com.atguigu.ggkt.user;

/**
 * @author 陈江林
 * @date 2022/10/13 14:17
 */
public class ServiceUserApplicationTest {
}
```



#### 3.1.7 新建 `MP` 配置文件

```java
package com.atguigu.ggkt.user.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisPlus 配置类
 * 
 * @author 陈江林
 * @date 2022/10/13 14:18
 */
@Configuration
@MapperScan("com.atguigu.ggkt.user.mapper")
public class MybatisPlusConfig {

    /**
     * 版本要求：3.4.0 版本以上
     * 新的分页插件,一缓和二缓遵循 mybatis 的规则, 需要设置 MybatisConfiguration#useDeprecatedExecutor = false 避免缓存出现问题(该属性会在旧插件移除后一同移除)
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.H2));
        return interceptor;
    }

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> configuration.setUseDeprecatedExecutor(false);
    }

}
```



#### 3.1.8 配置网关

```yaml
routes[3]:
  id: service-user
  uri: lb://service-user
  predicates: Path=/admin/user/**
```



### 3.2 接口

#### 3.2.1 控制类

```java
package com.atguigu.ggkt.user.controller;


import com.atguigu.ggkt.model.user.UserInfo;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.user.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-13
 */
@Api(tags = "用户信息")
@RestController
@RequestMapping("/admin/user/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation("获取用户")
    @GetMapping("/inner/getById/{id}")
    public Result<UserInfo> getById(@PathVariable Long id) {
        UserInfo userInfo = userInfoService.getById(id);
        return Result.ok(userInfo);
    }

}
```



## 4 创建模块定义远程接口

### 4.1 创建模块

- `ggkt_parent` -> `service_client` -> `service_user_client`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665642931814-b19f9656-1857-45e0-b1ec-01bcb0487396.png)

- 删除 `src`, 再创建子模块

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665643001407-b5ed97ac-7aba-43d6-9939-62c51c533857.png)

- 创建空配置文件 `application.yml`
- 创建测试文件

```java
package com.atguigu.ggkt.client.user;

/**
 * @author 陈江林
 * @date 2022/10/13 14:58
 */
public class ClientTest {
}
```

### 4.2 `service_client` 依赖

```xml
<dependencies>
    <dependency>
        <groupId>com.atguigu</groupId>
        <artifactId>service_utils</artifactId>
        <version>0.0.1-SNAPSHOT</version>
        <scope>provided </scope>
    </dependency>

    <dependency>
        <groupId>com.atguigu</groupId>
        <artifactId>model</artifactId>
        <version>0.0.1-SNAPSHOT</version>
        <scope>provided</scope>
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <scope>provided </scope>
    </dependency>

    <!-- 服务调用feign -->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-openfeign</artifactId>
        <scope>provided </scope>
    </dependency>
</dependencies>

<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <configuration>
                <!-- 取消查找本项目下的Main方法：为了解决Unable to find main class的问题 -->
                <mainClass>none</mainClass>
                <!-- 为了解决依赖模块找不到此模块中的类或属性 -->
                <classifier>execute</classifier>
            </configuration>
            <executions>
                <execution>
                    <goals>
                        <goal>repackage</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```



### 4.3 定义远程调用接口

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665643069535-ff8b4144-447a-4ee7-811e-647c49b23349.png)

```java
package com.atguigu.ggkt.client.user;

import com.atguigu.ggkt.model.user.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 远程调用接口
 *
 * @author 陈江林
 * @date 2022/10/13 14:37
 */
@FeignClient(value = "service-user")
public interface UserInfoFeignClient {

    /**
     * 根据 id 查询用户数据
     *
     * @param id id
     * @return {@link UserInfo}
     */
    @GetMapping("/admin/user/userInfo/inner/getById/{id}")
    UserInfo getById(@PathVariable Long id);

}
```



## 5 `service_activity` 工程

### 5.1 引入依赖

```xml
<dependencies>
    <!-- 远程调用 -->
    <dependency>
        <groupId>com.atguigu</groupId>
        <artifactId>service_user_client</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </dependency>
</dependencies>
```



### 5.2 启动类添加注解

```java
package com.atguigu.ggkt.activity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 陈江林
 * @date 2022/10/13 13:54
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.atguigu")
@ComponentScan(basePackages = "com.atguigu")
public class ServiceActivityApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceActivityApplication.class, args);
    }

}
```



### 5.3 服务实现

```java
package com.atguigu.ggkt.activity.service.impl;

import com.atguigu.ggkt.activity.mapper.CouponInfoMapper;
import com.atguigu.ggkt.activity.service.CouponInfoService;
import com.atguigu.ggkt.activity.service.CouponUseService;
import com.atguigu.ggkt.client.user.UserInfoFeignClient;
import com.atguigu.ggkt.model.activity.CouponInfo;
import com.atguigu.ggkt.model.activity.CouponUse;
import com.atguigu.ggkt.model.user.UserInfo;
import com.atguigu.ggkt.vo.activity.CouponUseQueryVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 优惠券信息 服务实现类
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-13
 */
@Service
public class CouponInfoServiceImpl extends ServiceImpl<CouponInfoMapper, CouponInfo> implements CouponInfoService {
    @Autowired
    private CouponUseService couponUseService;

    @Autowired
    private UserInfoFeignClient userInfoFeignClient;

    @Override
    public IPage<CouponUse> selectCouponUsePage(Page<CouponUse> pageParam1, CouponUseQueryVo couponUseQueryVo) {
        // 创建条件对象
        LambdaQueryWrapper<CouponUse> wrapper = new LambdaQueryWrapper<>();
        IPage<CouponUse> pageParam = new Page<>(1, 2);
        if (couponUseQueryVo != null) {
            // 获取条件
            Long couponId = couponUseQueryVo.getCouponId();
            String couponStatus = couponUseQueryVo.getCouponStatus();
            String getTimeBegin = couponUseQueryVo.getGetTimeBegin();
            String getTimeEnd = couponUseQueryVo.getGetTimeEnd();

            if (!StringUtils.isEmpty(couponId)) {
                wrapper.eq(CouponUse::getCouponId, couponId);
            }

            if (!StringUtils.isEmpty(couponStatus)) {
                wrapper.eq(CouponUse::getCouponStatus, couponStatus);
            }

            if (!StringUtils.isEmpty(getTimeBegin)) {
                wrapper.ge(CouponUse::getGetTime, getTimeBegin);
            }

            if (!StringUtils.isEmpty(getTimeEnd)) {
                wrapper.le(CouponUse::getGetTime, getTimeEnd);
            }
        }

        // 调用方法查询
        IPage<CouponUse> page = couponUseService.page(pageParam, wrapper);
        // 封装用户昵称和手机号
        List<CouponUse> couponUseList = page.getRecords();
        // 遍历
        couponUseList.forEach(couponUse -> {
            // 获取用户 id
            Long userId = couponUse.getUserId();
            if (!StringUtils.isEmpty(userId)) {
                // 调用远程接口获取用户信息
                UserInfo userInfo = userInfoFeignClient.getById(userId);
                if (userInfo != null) {
                    couponUse.getParam().put("nickName", userInfo.getNickName());
                    couponUse.getParam().put("phone", userInfo.getPhone());
                }
            }
        });

        return page;
    }
}
```



## 6 优惠券前端

### 6.1 `API`

- `api` -> `activity` -> `couponInfo.js`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665644604255-3023e66e-1ac0-4853-8a45-f382872c7f8a.png)

```javascript
import request from '@/utils/request'

const api_name = '/admin/activity/couponInfo'

export default {

  getPageList(page, limit) {
    return request({
      url: `${api_name}/${page}/${limit}`,
      method: 'get'
    })
  },
  getById(id) {
    return request({
      url: `${api_name}/get/${id}`,
      method: 'get'
    })
  },

  save(data) {
    return request({
      url: `${api_name}/save`,
      method: 'post',
      data
    })
  },

  updateById(role) {
    return request({
      url: `${api_name}/update`,
      method: 'put',
      data: role
    })
  },
  removeById(id) {
    return request({
      url: `${api_name}/remove/${id}`,
      method: 'delete'
    })
  },
  removeRows(data) {
    return request({
      url: `${api_name}/batchRemove`,
      method: 'delete',
      data
    })
  },

  getPageCouponUseList(page, limit, params) {
    return request({
      url: `${api_name}/couponUse/${page}/${limit}`,
      method: 'get',
      params
    })
  }
}
```



### 6.2 路由

```javascript
{
    path: '/activity/couponinfo',
    component: Layout,
    redirect: '/couponinfo/List',
    name: 'Activity',
    meta: { title: '营销活动管理', icon: 'el-icon-football' },
    alwaysShow: true,
    children: [
      {
        path: 'List',
        name: 'CouponInfo',
        component: () => import('@/views/activity/couponinfo/List'),
        meta: { title: '优惠券列表' }
      },
      {
        path: 'add',
        name: 'CouponInfoAdd',
        component: () => import('@/views/activity/couponinfo/Form'),
        meta: { title: '添加' },
        hidden: true
      },
      {
        path: 'edit/:id',
        name: 'CouponInfoEdit',
        component: () => import('@/views/activity/couponinfo/Form'),
        meta: { title: '编辑', noCache: true },
        hidden: true
      },
      {
        path: 'show/:id',
        name: 'CouponInfoShow',
        component: () => import('@/views/activity/couponinfo/Show'),
        meta: { title: '详情', noCache: true },
        hidden: true
      }
    ]
  },
```



### 6.3 页面

#### 6.3.1 List

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665644863964-b7469ede-a69a-4500-9dd2-11726c69f9e7.png)

```vue
<template>
  <div class="app-container">

    <!-- 工具条 -->
    <el-card class="operate-container" shadow="never">
      <i class="el-icon-tickets" style="margin-top: 5px"></i>
      <span style="margin-top: 5px">数据列表</span>
      <el-button class="btn-add" size="mini" @click="add()">添加</el-button>
    </el-card>

    <!-- banner列表 -->
    <el-table
      v-loading="listLoading"
      :data="list"
      element-loading-text="数据正在加载......"
      border
      fit
      highlight-current-row>

      <el-table-column
        label="序号"
        width="70"
        align="center">
        <template slot-scope="scope">
          {{ (page - 1) * limit + scope.$index + 1 }}
        </template>
      </el-table-column>

      <el-table-column prop="couponName" label="购物券名称"/>
      <el-table-column prop="couponType" label="购物券类型">
        <template slot-scope="scope">
          {{ scope.row.couponType == 'REGISTER' ? '注册卷' : '推荐赠送卷' }}
        </template>
      </el-table-column>
      <el-table-column label="规则">
        <template slot-scope="scope">
          {{ '现金卷：' + scope.row.amount + '元' }}
        </template>
      </el-table-column>
      <el-table-column label="使用范围 ">
        所有商品
      </el-table-column>
      <el-table-column prop="publishCount" label="发行数量"/>
      <el-table-column prop="expireTime" label="过期时间"/>
      <el-table-column prop="createTime" label="创建时间"/>
      <el-table-column label="操作" width="150" align="center">
        <template slot-scope="scope">
          <router-link :to="'/activity/couponInfo/edit/'+scope.row.id">
            <el-button size="mini" type="text">修改</el-button>
          </router-link>
          <el-button size="mini" type="text" @click="removeDataById(scope.row.id)">删除</el-button>
          <router-link :to="'/activity/couponInfo/show/'+scope.row.id">
            <el-button size="mini" type="text">详情</el-button>
          </router-link>
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页组件 -->
    <el-pagination
      :current-page="page"
      :total="total"
      :page-size="limit"
      :page-sizes="[5, 10, 20, 30, 40, 50, 100]"
      style="padding: 30px 0; text-align: center;"
      layout="sizes, prev, pager, next, jumper, ->, total, slot"
      @current-change="fetchData"
      @size-change="changeSize"
    />
  </div>
</template>

<script>
import api from '@/api/activity/couponInfo'

export default {
  data() {
    return {
      listLoading: true, // 数据是否正在加载
      list: null, // banner列表
      total: 0, // 数据库中的总记录数
      page: 1, // 默认页码
      limit: 10, // 每页记录数
      searchObj: {}, // 查询表单对象
      multipleSelection: [] // 批量选择中选择的记录列表
    }
  },

  // 生命周期函数：内存准备完毕，页面尚未渲染
  created() {
    console.log('list created......')
    this.fetchData()
  },

  // 生命周期函数：内存准备完毕，页面渲染成功
  mounted() {
    console.log('list mounted......')
  },

  methods: {
    // 当页码发生改变的时候
    changeSize(size) {
      console.log(size)
      this.limit = size
      this.fetchData(1)
    },

    add() {
      this.$router.push({path: '/activity/couponInfo/add'})
    },

    // 加载banner列表数据
    fetchData(page = 1) {
      console.log('翻页。。。' + page)
      // 异步获取远程数据（ajax）
      this.page = page

      api.getPageList(this.page, this.limit, this.searchObj).then(
        response => {
          this.list = response.data.records
          this.total = response.data.total

          // 数据加载并绑定成功
          this.listLoading = false
        }
      )
    },

    // 重置查询表单
    resetData() {
      console.log('重置查询表单')
      this.searchObj = {}
      this.fetchData()
    },

    // 根据id删除数据
    removeDataById(id) {
      // debugger
      this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => { // promise
        // 点击确定，远程调用ajax
        return api.removeById(id)
      }).then((response) => {
        this.fetchData(this.page)
        if (response.code) {
          this.$message({
            type: 'success',
            message: '删除成功!'
          })
        }
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    }
  }
}
</script>
```



#### 6.3.2 `Form.vue`

```vue
<template>
  <div class="app-container">
    <el-form label-width="120px">

      <el-form-item label="优惠券名称">
        <el-input v-model="couponInfo.couponName"/>
      </el-form-item>
      <el-form-item label="优惠券类型">
        <el-radio-group v-model="couponInfo.couponType">
          <el-radio label="1">注册卷</el-radio>
          <el-radio label="2">推荐购买卷</el-radio>
        </el-radio-group>
      </el-form-item>

      <el-form-item label="发行数量">
        <el-input v-model="couponInfo.publishCount"/>
      </el-form-item>
      <el-form-item label="领取时间">
        <el-date-picker
          v-model="couponInfo.startTime"
          type="date"
          placeholder="选择开始日期"
          value-format="yyyy-MM-dd"/>
        至
        <el-date-picker
          v-model="couponInfo.endTime"
          type="date"
          placeholder="选择开始日期"
          value-format="yyyy-MM-dd"/>
      </el-form-item>
      <el-form-item label="过期时间">
        <el-date-picker
          v-model="couponInfo.expireTime"
          type="datetime"
          placeholder="选择开始日期"
          value-format="yyyy-MM-dd HH:mm:ss"/>
      </el-form-item>
      <el-form-item label="直播详情">
        <el-input v-model="couponInfo.ruleDesc" type="textarea" rows="5"/>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="saveOrUpdate">保存</el-button>
        <el-button @click="back">返回</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import api from '@/api/activity/couponInfo'

const defaultForm = {
  id: '',
  couponType: '1',
  couponName: '',
  amount: '0',
  conditionAmount: '0',
  startTime: '',
  endTime: '',
  rangeType: '1',
  ruleDesc: '',
  publishCount: '',
  perLimit: '1',
  useCount: '0',
  receiveCount: '',
  expireTime: '',
  publishStatus: ''
}

export default {
  data() {
    return {
      couponInfo: defaultForm,
      saveBtnDisabled: false,

      keyword: '',
      skuInfoList: []
    }
  },

  // 监听器
  watch: {
    $route(to, from) {
      console.log('路由变化......')
      console.log(to)
      console.log(from)
      this.init()
    }
  },

  // 生命周期方法（在路由切换，组件不变的情况下不会被调用）
  created() {
    console.log('form created ......')
    this.init()
  },

  methods: {

    // 表单初始化
    init() {
      // debugger
      if (this.$route.params && this.$route.params.id) {
        const id = this.$route.params.id
        this.fetchDataById(id)
      } else {
        // 对象拓展运算符：拷贝对象，而不是赋值对象的引用
        this.couponInfo = {...defaultForm}
      }
    },

    saveOrUpdate() {
      this.saveBtnDisabled = true // 防止表单重复提交
      if (!this.couponInfo.id) {
        this.saveData()
      } else {
        this.updateData()
      }
    },

    // 新增
    saveData() {
      api.save(this.couponInfo).then(response => {
        // debugger
        if (response.code) {
          this.$message({
            type: 'success',
            message: response.message
          })
          this.$router.push({path: '/activity/couponInfo/list'})
        }
      })
    },

    // 根据id更新记录
    updateData() {
      api.updateById(this.couponInfo).then(response => {
        debugger
        if (response.code) {
          this.$message({
            type: 'success',
            message: response.message
          })
          this.$router.push({path: '/activity/couponInfo/list'})
        }
      })
    },

    back() {
      this.$router.push({path: '/activity/couponInfo/list'})
    },

    // 根据id查询记录
    fetchDataById(id) {
      api.getById(id).then(response => {
        // debugger
        this.couponInfo = response.data
      })
    }
  }
}
</script>
```



#### 6.3.3 `Show.vue`

```vue
<template>
  <div class="app-container">

    <h4>优惠券信息</h4>
    <table class="table table-striped table-condenseda table-bordered" width="100%">
      <tbody>
      <tr>
        <th width="15%">优惠券名称</th>
        <td width="35%"><b style="font-size: 14px">{{ couponInfo.couponName }}</b></td>
        <th width="15%">优惠券类型</th>
        <td width="35%">
          {{ couponInfo.couponType == 'REGISTER' ? '注册卷' : '推荐赠送卷' }}
        </td>
      </tr>
      <tr>
        <th>发行数量</th>
        <td>{{ couponInfo.publishCount }}</td>
        <th>每人限领次数</th>
        <td>{{ couponInfo.perLimit }}</td>
      </tr>
      <tr>
        <th>领取数量</th>
        <td>{{ couponInfo.receiveCount }}</td>
        <th>使用数量</th>
        <td>{{ couponInfo.useCount }}</td>
      </tr>
      <tr>
        <th>领取时间</th>
        <td>{{ couponInfo.startTime }}至{{ couponInfo.endTime }}</td>
        <th>过期时间</th>
        <td>{{ couponInfo.expireTime }}</td>
      </tr>
      <tr>
        <th>规则描述</th>
        <td colspan="3">{{ couponInfo.ruleDesc }}</td>
      </tr>
      </tbody>
    </table>

    <h4>
      优惠券发放列表&nbsp;&nbsp;&nbsp;
    </h4>
    <el-table
      v-loading="listLoading"
      :data="list"
      stripe
      border
      style="width: 100%;margin-top: 10px;">

      <el-table-column
        label="序号"
        width="70"
        align="center">
        <template slot-scope="scope">
          {{ (page - 1) * limit + scope.$index + 1 }}
        </template>
      </el-table-column>
      <el-table-column prop="param.nickName" label="用户昵称"/>
      <el-table-column prop="param.phone" label="手机号"/>
      <el-table-column label="使用状态">
        <template slot-scope="scope">
          {{ scope.row.couponStatus == 'NOT_USED' ? '未使用' : '已使用' }}
        </template>
      </el-table-column>
      <el-table-column prop="getTime" label="获取时间"/>
      <el-table-column prop="usingTime" label="使用时间"/>
      <el-table-column prop="usedTime" label="支付时间"/>
      <el-table-column prop="expireTime" label="过期时间"/>
    </el-table>
    <!-- 分页组件 -->
    <el-pagination
      :current-page="page"
      :total="total"
      :page-size="limit"
      :page-sizes="[5, 10, 20, 30, 40, 50, 100]"
      style="padding: 30px 0; text-align: center;"
      layout="sizes, prev, pager, next, jumper, ->, total, slot"
      @current-change="fetchData"
      @size-change="changeSize"
    />

    <div style="margin-top: 15px;">
      <el-form label-width="0px">
        <el-form-item>
          <el-button @click="back">返回</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import api from '@/api/activity/couponInfo'

export default {
  data() {
    return {
      listLoading: false, // 数据是否正在加载

      couponId: null,
      couponInfo: {},

      list: null, // banner列表
      total: 0, // 数据库中的总记录数
      page: 1, // 默认页码
      limit: 10, // 每页记录数
      searchObj: {} // 查询表单对象
    }
  },

  // 监听器
  watch: {
    $route(to, from) {
      console.log('路由变化......')
      console.log(to)
      console.log(from)
      this.init()
    }
  },

  // 生命周期方法（在路由切换，组件不变的情况下不会被调用）
  created() {
    console.log('form created ......')
    this.couponId = this.$route.params.id
    // 获取优惠券信息
    this.fetchDataById()
    this.fetchData()
  },

  methods: {

    // 根据id查询记录
    fetchDataById() {
      api.getById(this.couponId).then(response => {
        //
        this.couponInfo = response.data
      })
    },

    // 当页码发生改变的时候
    changeSize(size) {
      console.log(size)
      this.limit = size
      this.fetchData(1)
    },

    // 加载banner列表数据
    fetchData(page = 1) {
      console.log('翻页。。。' + page)
      // 异步获取远程数据（ajax）
      this.page = page
      this.searchObj.couponId = this.couponId
      api.getPageCouponUseList(this.page, this.limit, this.searchObj).then(
        response => {
          this.list = response.data.records
          this.total = response.data.total

          // 数据加载并绑定成功
          this.listLoading = false
        }
      )
    },

    back() {
      this.$router.push({path: '/activity/couponInfo/list'})
    }
  }
}
</script>

<style>
.app-container h4 {
  color: #606266;
}
</style>
```



# 十二 公众号菜单管理

```
git checkout -b 12.0.0_wechat_menu
```

## 1 申请测试公众号

地址: `https://mp.weixin.qq.com/debug/cgi-bin/sandbox?t=sandbox/login&token=399029368&lang=zh_CN`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665665862557-4724de8c-1330-4f37-8b50-a6ce3205efe7.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665719469246-fa0dde81-4437-4b6f-99f1-51b832d2938c.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665729221890-c2ab98dc-9c72-43ee-abd1-46e911c95b76.png)

## 2 需求分析

### 2.1 微信自定义菜单说明

- 微信自定义菜单文档地址: `https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Creating_Custom-Defined_Menu.html`
- 微信自定义菜单注意事项

1. 自定义菜单最多包括 `3` 个一级菜单，每个一级菜单最多包含 `5` 个二级菜单。
2. 一级菜单最多 `4` 个汉字，二级菜单最多 `8` 个汉字，多出来的部分将会以“...”代替。
3. 创建自定义菜单后，菜单的刷新策略是，在用户进入公众号会话页或公众号 `profile` 页时，如果发现上一次拉取菜单的请求在 `5` 分钟以前，就会拉取一下菜单，如果菜单有更新，就会刷新客户端的菜单。测试时可以尝试取消关注公众账号后再次关注，则可以看到创建后的效果。



### 2.2 硅谷课堂自定义菜单

1. 一级菜单: 直播、课程、我的
2. 二级菜单: 根据一级菜单动态设置二级菜单, 直播（近期直播课程）, 课程（课程分类）， 我的（我的订单, 我的课程, 我的优惠券及关于我们）

说明:

1. 二级菜单可以是网页类型, 点击跳转 `H5` 页面
2. 二级菜单可以是消息类型, 点击返回消息



### 2.3 数据格式

- 自定义菜单通过后台管理设置到数据库表, 数据配置好后, 通过微信接口推送菜单数据到微信平台

#### 2.3.1 数据库表

```plsql
/*
SQLyog Ultimate - MySQL GUI v8.2 
MySQL - 5.7.29-32-log : Database - glkt_wechat
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
DROP DATABASE IF EXISTS `glkt_wechat`;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`glkt_wechat` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `glkt_wechat`;

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
                        `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
                        `parent_id` bigint(20) DEFAULT NULL COMMENT '上级id',
                        `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
                        `type` varchar(10) DEFAULT NULL COMMENT '类型',
                        `url` varchar(100) DEFAULT NULL COMMENT '网页 链接，用户点击菜单可打开链接',
                        `meun_key` varchar(20) DEFAULT NULL COMMENT '菜单KEY值，用于消息接口推送',
                        `sort` tinyint(3) DEFAULT NULL COMMENT '排序',
                        `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                        `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                        `is_deleted` tinyint(3) NOT NULL DEFAULT '0',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='微信公众号菜单';

/*Data for the table `menu` */

insert  into `menu`(`id`,`parent_id`,`name`,`type`,`url`,`meun_key`,`sort`,`create_time`,`update_time`,`is_deleted`) values (1,0,'直播',NULL,NULL,NULL,1,'2021-11-24 08:41:53','2021-11-24 08:44:55',0),(2,0,'课程',NULL,NULL,NULL,2,'2021-11-24 08:41:57','2021-11-25 01:33:52',0),(3,0,'我的',NULL,NULL,NULL,3,'2021-11-24 08:42:00','2021-11-25 01:34:16',0),(4,3,'关于我们','click',NULL,'aboutUs',10,'2021-11-24 08:42:05','2021-11-24 08:45:00',0),(5,1,'微服务架构演进','view','/liveInfo/3','',2,'2021-11-24 10:29:12','2021-11-25 01:26:13',0),(6,1,'大数据Spark全面分析','view','/liveInfo/2','',4,'2021-11-24 10:29:24','2021-11-25 01:27:05',0),(7,2,'后端开发','view','/course/1','',1,'2021-11-24 10:31:48','2021-11-25 01:27:06',0),(8,2,'大数据','view','/course/14','',2,'2021-11-24 10:31:59','2021-11-25 01:27:07',0),(9,3,'我的订单','view','/order','',1,'2021-11-25 01:19:25','2021-11-25 01:27:07',0),(10,3,'我的课程','view','/myCourse','',2,'2021-11-25 01:26:51','2021-11-25 01:26:51',0),(11,1,'全部列表','view','/live','',6,'2021-11-25 01:41:47','2021-11-25 01:41:47',0),(12,3,'我的优惠券','view','/coupon',NULL,3,'2021-11-26 08:52:27','2021-11-26 08:52:40',0),(13,1,'11月26日晚8点电商分享','view','/liveInfo/8','',1,'2021-11-26 09:21:39','2021-11-26 09:21:39',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
```



### 2.4 管理页面

1. 页面功能 `列表`、`添加`、`修改`、`删除`是对 `menu` 表的操作
2. 页面功能 `同步菜单`、`删除菜单` 是对微信平台接口操作

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665666624771-8c606297-bba4-4ca4-b476-391802182bb4.png)





## 3. 搭建菜单管理后端环境

### 3.1 创建模块 `service_wechat`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665667550216-fb844cd8-5c50-4126-bb49-501782e86cb8.png)

### 3.2 依赖

```xml
<dependencies>
    <!-- 微信公众号 Java SDK -->
    <dependency>
        <groupId>com.github.binarywang</groupId>
        <artifactId>weixin-java-mp</artifactId>
        <version>4.1.0</version>
    </dependency>
</dependencies>
```



### 3.3 生成代码

- 数据库 `glkt_wechat`
- 数据库表 `strategy.setInclude("menu");`
- 模块名称 `service_wechat`
- 模块名`wechat`



1. 删除 `entity`

### 3.4 启动类

```java
package com.atguigu.ggkt.wechat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 陈江林
 * @date 2022/10/13 21:26
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.atguigu")
@MapperScan("com.atguigu.ggkt.wechat.mapper")
@ComponentScan(basePackages = "com.atguigu")
public class ServiceWechatApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceWechatApplication.class, args);
    }
    
}
```



### 3.5 配置文件 `application.yml`

```yaml
# 服务端口
server:
  port: 8305

spring:
  application:
    name: service-wechat
  # 环境设置：dev、test、prod
  profiles:
    active:
      dev
  # mysql数据库连接
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://localhost:3306/glkt_user?characterEncoding=utf-8&useSSL=false
    username: root
    password: 12345678
  #返回json的全局时间格式
  jackson:
    date-format: yyyy-MM-dd HH:mm:ss
    time-zone: GMT+8
  # nacos 地址
  cloud:
    nacos:
      discovery:
        server-addr: 127.0.0.1:8848

  #mybatis日志
mybatis-plus:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
  mapper-locations: classpath:com/atguigu/ggkt/user/mapper/xml/*.xml
```



### 3.6 测试类 `ServiceWechatApplicationTest`

```java
package com.atguigu.ggkt.wechat;

/**
 * @author 陈江林
 * @date 2022/10/13 21:29
 */
public class ServiceWechatApplicationTest {
}
```



### 3.7 配置网关

```yaml
routes[4]:
	id: service-wechat
	uri: lb://service-wechat
	predicates: Path=/admin/wechat/**
```



## 4 菜单管理接口

### 4.1 控制类

```java
package com.atguigu.ggkt.wechat.controller;

import com.atguigu.ggkt.model.wechat.Menu;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vo.wechat.MenuVo;
import com.atguigu.ggkt.wechat.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 微信公众号菜单 前端控制器
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-13
 */
@Api(tags = "微信公众号菜单")
@RestController
@RequestMapping("/admin/wechat/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @ApiOperation("获取所有菜单，按照一级和二级菜单封装")
    @GetMapping("/findMenuInfo")
    public Result<List<MenuVo>> findMenuInfo() {
        List<MenuVo> list = menuService.findMenuInfo();
        return Result.ok(list);
    }

    @ApiOperation("获取所有一级菜单")
    @GetMapping("/findOneMenuInfo")
    public Result<List<Menu>> findOneMenuInfo() {
        List<Menu> list = menuService.findMenuOneInfo();
        return Result.ok(list);
    }

    @ApiOperation(value = "获取")
    @GetMapping("/get/{id}")
    public Result<Menu> get(@PathVariable Long id) {
        Menu menu = menuService.getById(id);
        return Result.ok(menu);
    }

    @ApiOperation(value = "新增")
    @PostMapping("/save")
    public Result save(@RequestBody Menu menu) {
        menuService.save(menu);
        return Result.ok();
    }

    @ApiOperation(value = "修改")
    @PutMapping("/update")
    public Result updateById(@RequestBody Menu menu) {
        menuService.updateById(menu);
        return Result.ok();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/remove/{id}")
    public Result remove(@PathVariable Long id) {
        menuService.removeById(id);
        return Result.ok();
    }

    @ApiOperation(value = "根据id列表删除")
    @DeleteMapping("/batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList) {
        menuService.removeByIds(idList);
        return Result.ok();
    }
}
```



### 4.2 服务实现类

```java
package com.atguigu.ggkt.wechat.service.impl;

import com.atguigu.ggkt.model.wechat.Menu;
import com.atguigu.ggkt.vo.wechat.MenuVo;
import com.atguigu.ggkt.wechat.mapper.MenuMapper;
import com.atguigu.ggkt.wechat.service.MenuService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 微信公众号菜单 服务实现类
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-13
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Override
    public List<Menu> findMenuOneInfo() {
        // 创建条件对象
        LambdaQueryWrapper<Menu> wrapper = new LambdaQueryWrapper();
        // eq(=)
        wrapper.eq(Menu::getParentId, 0);
        // 查询并返回
        return baseMapper.selectList(wrapper);
    }

    @Override
    public List<MenuVo> findMenuInfo() {
        // 查询所有菜单数据（包含一级和二级）
        List<MenuVo> menuVoList = baseMapper.selectList(Wrappers.emptyWrapper()).stream()
                // 将对象转换成 MenuVo
                .map(menu -> {
                    MenuVo menuVo = new MenuVo();
                    BeanUtils.copyProperties(menu, menuVo);
                    return menuVo;
                })
                .collect(Collectors.toList());

        // 取出二级菜单
        List<MenuVo> menuVoTwoList = menuVoList.stream()
                .filter(menu -> !menu.getParentId().equals(0L))
                .collect(Collectors.toList());

        // 取出一级菜单并遍历找到对应的二级菜单
        return menuVoList.stream()
                // 从所有菜单数据中取出一级菜单（parent_id = 0）
                .filter(menu -> menu.getParentId().equals(0L))
                // 遍历
                .peek(menuVo -> {
                    // 获取当前一级菜单的 id
                    Long id = menuVo.getId();
                    menuVoTwoList.stream()
                            // 过滤出对应的二级菜单
                            .filter(menuVoTwo -> menuVoTwo.getParentId().equals(id))
                            // 将对应的二级菜单存储到一级菜单的子集合中
                            .forEach(menuVoTwo -> {
                                if (menuVo.getChildren() == null) {
                                    menuVo.setChildren(new ArrayList<>());
                                }

                                menuVo.getChildren().add(menuVoTwo);
                            });
                })
                .collect(Collectors.toList());
    }

}
```





## 5 同步菜单（获取 `access_token`）

- 进行菜单同步的时候, 需要获取到公众号的 `access_token`, 通过 `access_token` 进行菜单同步
- 接口文档: `https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Get_access_token.html`

### 5.1 接口调用请求说明

- `https` 请求方式: `GET` `https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET`

**参数说明**

| **参数**   | **是否必须** | **说明**                              |
| ---------- | ------------ | ------------------------------------- |
| grant_type | 是           | 获取access_token填写client_credential |
| appid      | 是           | 第三方用户唯一凭证                    |
| secret     | 是           | 第三方用户唯一凭证密钥，即appsecret   |

**返回说明**

- 正常情况下，微信会返回下述 JSON 数据包给公众号：

```json
{"access_token":"ACCESS_TOKEN","expires_in":7200}
```

**参数说明**

| **参数**     | **说明**               |
| ------------ | ---------------------- |
| access_token | 获取到的凭证           |
| expires_in   | 凭证有效时间，单位：秒 |

错误时微信会返回错误码等信息，JSON数据包示例如下（该示例为 AppID 无效错误）:

```json
{"errcode":40013,"errmsg":"invalid appid"} 
```

**返回码说明**

| **返回码** | **说明**                                                     |
| ---------- | ------------------------------------------------------------ |
| -1         | 系统繁忙，此时请开发者稍候再试                               |
| 0          | 请求成功                                                     |
| 40001      | AppSecret错误或者 AppSecret 不属于这个公众号，请开发者确认 AppSecret 的正确性 |
| 40002      | 请确保grant_type字段值为client_credential                    |
| 40164      | 调用接口的 IP 地址不在白名单中，请在接口 IP 白名单中进行设置。 |
| 89503      | 此 IP 调用需要管理员确认,请联系管理员                        |
| 89501      | 此 IP 正在等待管理员确认,请联系管理员                        |
| 89506      | 24小时内该 IP 被管理员拒绝调用两次，24小时内不可再使用该 IP 调用 |
| 89507      | 1小时内该 IP 被管理员拒绝调用一次，1小时内不可再使用该 IP 调用 |



### 5.2 `service_wechat` 添加配置

```yaml
wx:
  mp:
    # 公众号的 appid
    app-id: wxc2d7509ddd5c9418
    # 公众号的 appsecret
    secret: 92197f5f41d968266f1ba20b12293574
```



### 5.3 添加依赖

```xml
<!-- 导入配置文件处理器, 配置文件进行绑定 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-configuration-processor</artifactId>
    <optional>true</optional>
</dependency>
```



### 5.4 新建属性文件 `WxMpProperties`

```java
package com.atguigu.ggkt.wechat.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 微信公众号属性配置类
 *
 * @author 陈江林
 * @date 2022/10/14 15:27
 */
@Data
@Component
@ConfigurationProperties("wx.mp")
public class WxMpProperties {

    /**
     * 公众号的 appid
     */
    private String appId;

    /**
     * 公众号的 appsecret
     */
    private String secret;

}
```



### 5.5 新建微信配置类 `WxMpConfiguration`

```java
package com.atguigu.ggkt.wechat.config;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

/**
 * 微信配置类
 *
 * @author 陈江林
 * @date 2022/10/14 15:27
 */
@Configuration
public class WxMpConfiguration {

    @Autowired
    private WxMpProperties wxMpProperties;

    @Bean
    public WxMpService wxMpService() {
        WxMpService service = new WxMpServiceImpl();
        WxMpDefaultConfigImpl configStorage = new WxMpDefaultConfigImpl();
        configStorage.setAppId(wxMpProperties.getAppId());
        configStorage.setSecret(wxMpProperties.getSecret());
        service.setWxMpConfigStorage(configStorage);

        return service;
    }

}
```



### 5.6 控制类

```java
@ApiOperation("公众号菜单同步")
@GetMapping("/syncMenu")
public Result syncMenu() {
    menuService.syncMenu();
    return Result.ok();
}
```



### 5.7 服务实现类

```java
@Override
    public void syncMenu() {
        // 获取所有菜单
        List<MenuVo> menuVoList = this.findMenuInfo();
        // 封装数据
        // 创建 button 数组
        JSONArray buttonList = new JSONArray();
        menuVoList.stream()
                .forEach(menuVo -> {
                    // 一级菜单
                    // 创建一级菜单对象
                    JSONObject oneObject = new JSONObject();
                    oneObject.put("name", menuVo.getName());
                    // 二级菜单
                    // 创建二级菜单数组
                    JSONArray twoArray = new JSONArray();
                    menuVo.getChildren().forEach(menuVoTwo -> {
                        // 获取对象属性
                        String name = menuVoTwo.getName();
                        String type = menuVoTwo.getType();
                        // 创建二级菜单对象
                        JSONObject twoObject = new JSONObject();
                        twoObject.put("type", type);
                        twoObject.put("name", name);
                        // 判断类型
                        // view 表示网页类型，click 表示点击类型，miniprogram 表示小程序类型
                        String view = "view";
                        String click = "click";
                        if (view.equals(type)) {
                            twoObject.put("url", "http://ggkt2.vipgz1.91tunnel.com/#" + menuVoTwo.getUrl());
                        } else if (click.equals(type)) {
                            twoObject.put("key", menuVoTwo.getMeunKey());
                        }

                        twoArray.add(twoObject);
                    });

                    oneObject.put("sub_button", twoArray);
                    buttonList.add(oneObject);
                });

        JSONObject button = new JSONObject();
        button.put("button", buttonList);
        try {
            // 同步菜单
            wxMpService.getMenuService().menuCreate(button.toJSONString());
        } catch (WxErrorException e) {
            throw new GgktException(20001, "公众号菜单同步失败");
        }
    }
```



##  6 公众号菜单删除

### 6.1 控制类

```java
@ApiOperation("公众号菜单删除")
@GetMapping("/removeMenu")
public Result removeMenu() {
    menuService.removeMenu();
    return Result.ok();
}
```



### 6.2 服务实现类

```java
@Override
public void removeMenu() {
    try {
        wxMpService.getMenuService().menuDelete();
    } catch (WxErrorException e) {
        throw new GgktException(20001, "公众号菜单删除失败");
    }
}
```



## 7 前端代码

### 7.1 `API`

- 新建 `menu.js`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665745839842-c6dddb3f-ca34-4d08-b565-21be264b2337.png)

```javascript
import request from '@/utils/request'

const api_name = '/admin/wechat/menu'

export default {
	// 查询所有菜单
  findMenuInfo() {
    return request({
      url: `${api_name}/findMenuInfo`,
      method: `get`
    })
  },
	// 查询一级菜单
  findOneMenuInfo() {
    return request({
      url: `${api_name}/findOneMenuInfo`,
      method: `get`
    })
  },
	
  save(menu) {
    return request({
      url: `${api_name}/save`,
      method: `post`,
      data: menu
    })
  },

  getById(id) {
    return request({
      url: `${api_name}/get/${id}`,
      method: `get`
    })
  },

  updateById(data) {
    return request({
      url: `${api_name}/update`,
      method: `put`,
      data
    })
  },
	// 公众号菜单同步
  syncMenu() {
    return request({
      url: `${api_name}/syncMenu`,
      method: `get`
    })
  },

  removeById(id) {
    return request({
      url: `${api_name}/remove/${id}`,
      method: 'delete'
    })
  },
	// 公众号菜单删除
  removeMenu() {
    return request({
      url: `${api_name}/removeMenu`,
      method: `delete`
    })
  }
}
```



### 7.2 路由

```javascript
{
    path: '/wechat/menu',
    component: Layout,
    redirect: '/wechat/menu/List',
    name: 'Wechat',
    meta: {
      title: '菜单管理',
      icon: 'el-icon-refrigerator'
    },
    alwaysShow: true,
    children: [
      {
        path: 'List',
        name: 'WechatMenuList',
        component: () => import('@/views/wechat/menu/List'),
        meta: { title: '菜单列表' }
      }
    ]
},
```



### 7.3 `List.vue`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665745822340-553008b7-325c-4e85-8d3b-4b7cb4e83dae.png)

```vue
<template>
  <div class="app-container">

    <!-- 工具条 -->
    <el-card class="operate-container" shadow="never">
      <i class="el-icon-tickets" style="margin-top: 5px"></i>
      <span style="margin-top: 5px">数据列表</span>
      <el-button class="btn-add" size="mini" @click="remove" style="margin-left: 10px;">删除菜单</el-button>
      <el-button class="btn-add" size="mini" @click="syncMenu">同步菜单</el-button>
      <el-button class="btn-add" size="mini" @click="add">添 加</el-button>
    </el-card>

    <el-table
      :data="list"
      style="width: 100%;margin-bottom: 20px;"
      row-key="id"
      border
      default-expand-all
      :tree-props="{children: 'children'}">

      <el-table-column label="名称" prop="name" width="350"></el-table-column>
      <el-table-column label="类型" width="100">
        <template slot-scope="scope">
          {{ scope.row.type == 'view' ? '链接' : scope.row.type == 'click' ? '事件' : '' }}
        </template>
      </el-table-column>
      <el-table-column label="菜单URL" prop="url"></el-table-column>
      <el-table-column label="菜单KEY" prop="meunKey" width="130"></el-table-column>
      <el-table-column label="排序号" prop="sort" width="70"></el-table-column>
      <el-table-column label="操作" width="170" align="center">
        <template slot-scope="scope">
          <el-button v-if="scope.row.parentId > 0" type="text" size="mini" @click="edit(scope.row.id)">修改</el-button>
          <el-button v-if="scope.row.parentId > 0" type="text" size="mini" @click="removeDataById(scope.row.id)">删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog title="添加/修改" :visible.sync="dialogVisible" width="40%">
      <el-form ref="flashPromotionForm" label-width="150px" size="small" style="padding-right: 40px;">

        <el-form-item label="选择一级菜单">
          <el-select
            v-model="menu.parentId"
            placeholder="请选择">
            <el-option
              v-for="item in list"
              :key="item.id"
              :label="item.name"
              :value="item.id"/>
          </el-select>
        </el-form-item>
        <el-form-item v-if="menu.parentId == 1" label="菜单名称">
          <el-select
            v-model="menu.name"
            placeholder="请选择"
            @change="liveCourseChanged">
            <el-option
              v-for="item in liveCourseList"
              :key="item.id"
              :label="item.courseName"
              :value="item"/>
          </el-select>
        </el-form-item>
        <el-form-item v-if="menu.parentId == 2" label="菜单名称">
          <el-select
            v-model="menu.name"
            placeholder="请选择"
            @change="subjectChanged">
            <el-option
              v-for="item in subjectList"
              :key="item.id"
              :label="item.title"
              :value="item"/>
          </el-select>
        </el-form-item>
        <el-form-item v-if="menu.parentId == 3" label="菜单名称">
          <el-input v-model="menu.name"/>
        </el-form-item>
        <el-form-item label="菜单类型">
          <el-radio-group v-model="menu.type">
            <el-radio label="view">链接</el-radio>
            <el-radio label="click">事件</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item v-if="menu.type == 'view'" label="链接">
          <el-input v-model="menu.url"/>
        </el-form-item>
        <el-form-item v-if="menu.type == 'click'" label="菜单KEY">
          <el-input v-model="menu.meunKey"/>
        </el-form-item>
        <el-form-item label="排序">
          <el-input v-model="menu.sort"/>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false" size="small">取 消</el-button>
        <el-button type="primary" @click="saveOrUpdate()" size="small">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>
<script>
import menuApi from '@/api/wechat/menu'
//import liveCourseApi from '@/api/live/liveCourse'
import subjectApi from '@/api/vod/subject'

const defaultForm = {
  id: null,
  parentId: 1,
  name: '',
  nameId: null,
  sort: 1,
  type: 'view',
  meunKey: '',
  url: ''
}
export default {

  // 定义数据
  data() {
    return {
      list: [],

      liveCourseList: [],
      subjectList: [],

      dialogVisible: false,
      menu: defaultForm,
      saveBtnDisabled: false
    }
  },

  // 当页面加载时获取数据
  created() {
    this.fetchData()
    // this.fetchLiveCourse()
    this.fetchSubject()
  },

  methods: {
    // 调用api层获取数据库中的数据
    fetchData() {
      console.log('加载列表')
      menuApi.findMenuInfo().then(response => {
        this.list = response.data
        console.log(this.list)
      })
    },

    // fetchLiveCourse() {
    //   liveCourseApi.findLatelyList().then(response => {
    //     this.liveCourseList = response.data
    //     this.liveCourseList.push({'id': 0, 'courseName': '全部列表'})
    //   })
    // },

    fetchSubject() {
      console.log('加载列表')
      subjectApi.getList(0).then(response => {
        this.subjectList = response.data
      })
    },

    syncMenu() {
      this.$confirm('你确定上传菜单吗, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        return menuApi.syncMenu();
      }).then((response) => {
        this.fetchData()
        this.$message.success(response.message)
      }).catch(error => {
        console.log('error', error)
        // 当取消时会进入catch语句:error = 'cancel'
        // 当后端服务抛出异常时：error = 'error'
        if (error === 'cancel') {
          this.$message.info('取消上传')
        }
      })
    },

    // 根据id删除数据
    removeDataById(id) {
      // debugger
      this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => { // promise
        // 点击确定，远程调用ajax
        return menuApi.removeById(id)
      }).then((response) => {
        this.fetchData(this.page)
        if (response.code) {
          this.$message({
            type: 'success',
            message: '删除成功!'
          })
        }
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },

    // -------------
    add() {
      this.dialogVisible = true
      this.menu = Object.assign({}, defaultForm)
    },

    edit(id) {
      this.dialogVisible = true
      this.fetchDataById(id)
    },

    saveOrUpdate() {
      this.saveBtnDisabled = true // 防止表单重复提交

      if (!this.menu.id) {
        this.saveData()
      } else {
        this.updateData()
      }
    },

    // 新增
    saveData() {
      menuApi.save(this.menu).then(response => {
        if (response.code) {
          this.$message({
            type: 'success',
            message: response.message
          })
          this.dialogVisible = false;
          this.fetchData(this.page)
        }
      })
    },

    // 根据id更新记录
    updateData() {
      menuApi.updateById(this.menu).then(response => {
        if (response.code) {
          this.$message({
            type: 'success',
            message: response.message
          })
          this.dialogVisible = false;
          this.fetchData(this.page)
        }
      })
    },

    // 根据id查询记录
    fetchDataById(id) {
      menuApi.getById(id).then(response => {
        this.menu = response.data
      })
    },

    subjectChanged(item) {
      console.info(item)
      this.menu.name = item.title
      this.menu.url = '/course/' + item.id
    },

    liveCourseChanged(item) {
      console.info(item)
      this.menu.name = item.courseName
      if (item.id == 0) {
        this.menu.url = '/live'
      } else {
        this.menu.url = '/liveInfo/' + item.id
      }

    }
  }
}
</script>
```



## 8 公众号同步菜单效果图

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665748105525-3c6d9053-36e5-4d0f-b9ed-981727df74d8.png)


# 十三 公众号消息

```
git checkout -b 13.0.0_wechat_message
```

## 1 公众号消息回复、自定义菜单回复、关注、取消关注

## 1 消息接入

参考文档: `https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Access_Overview.html`

接入微信公众号平台开发, 开发者需要按照如下步骤完成

1. 填入服务器配置
2. 验证服务器地址的有效性
3. 依据接口文档实现业务逻辑



### 1.1 公众号服务器配置

- 在**测试管理** -> **接口配置信息,** 点击**修改**按钮

  - 填写服务器地址 `URL` 和 `Token`

    - `URL`: 开发者用来接收微信消息和事件的接口
    - `Token`: 由开发者任意填写, 用作生成签名

  -   - 该 `Token` 会和接口 `URL` 中包含的 `Token` 进行对比, 从而验证安全性

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665750038600-b48640bb-9956-49bf-9c10-0a68511398e0.png)



### 1.2 验证来自微信服务器消息

1. 开发者提交`URL`、`Token` 信息后, 微信服务器将发生 `GET` 请求到填写的服务器地址 `URL` 上, `GET` 请求携带参数如下

| **参数**    | **描述**                                                     |
| ----------- | ------------------------------------------------------------ |
| `signature` | 微信加密签名，`signature`结合了开发者填写的 `token` 参数和请求中的 `timestamp` 参数、`nonce`参数。 |
| `timestamp` | 时间戳                                                       |
| `nonce`     | 随机数                                                       |
| `echostr`   | 随机字符串                                                   |

- 开发者通过检验 `signature` 对请求进行校验（下面有校验方式）。
- 若确认此次 `GET` 请求来自微信服务器，请原样返回 `**echostr**` 参数内容，则接入生效，成为开发者成功，否则接入失败。加密/校验流程如下：

1. 将`token`、`timestamp`、`nonce`三个参数进行字典序排序
2. 将三个参数字符串拼接成一个字符串进行`sha1`加密
3. 开发者获得加密后的字符串可与 `signature` 对比，标识该请求来源于微信



#### 1.2.1 新建 `MessageController` <`service_wechat` 工程>

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665813225663-17289d00-bee4-48c1-972d-558f04f0771b.png)

```java
package com.atguigu.ggkt.wechat.controller;

import com.atguigu.ggkt.wechat.utils.SHA1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 微信公众号 URL
 *
 * @author 陈江林
 * @date 2022/10/15 13:43
 */
@Slf4j
@RestController
@RequestMapping("/api/wechat/message")
public class MessageController {

    @Autowired
    private WxMpService wxService;

    @GetMapping(produces = "text/plain;charset=utf-8")
    public String authGet(@RequestParam(name = "signature", required = false) String signature,
                          @RequestParam(name = "timestamp", required = false) String timestamp,
                          @RequestParam(name = "nonce", required = false) String nonce,
                          @RequestParam(name = "echostr", required = false) String echostr) {

        log.info("\n接收到来自微信服务器的认证消息：[{}, {}, {}, {}]", signature,
                timestamp, nonce, echostr);
        if (StringUtils.isAnyBlank(signature, timestamp, nonce, echostr)) {
            throw new IllegalArgumentException("请求参数非法，请核实!");
        }

        // 需要配置 token
        if (wxService.checkSignature(timestamp, nonce, signature)) {
            return echostr;
        }

        return "非法请求";
    }
    
}
```

#### 1.2.2 修改路由

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665817458051-64d6b0fe-86e7-4798-ad2e-706192d20d7a.png)

```yaml
# 路由配置
routes: [
  { id: service-vod, uri: lb://service-vod, predicates: Path=/**/vod/** },
  { id: service-order, uri: lb://service-order, predicates: Path=/**/order/** },
  { id: service-activity, uri: lb://service-activity, predicates: Path=/**/activity/** },
  { id: service-user, uri: lb://service-user, predicates: Path=/**/user/** },
  { id: service-wechat, uri: lb://service-wechat, predicates: Path=/**/wechat/** },
]
```

#### 1.2.3 `application.yml` 追加配置

```yaml
wx:
  mp:
    # 公众号的 token
    token: ggkt
```

#### 1.2.4 追加代码 `token` 属性

```java
package com.atguigu.ggkt.wechat.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 微信公众号属性配置类
 *
 * @author 陈江林
 * @date 2022/10/14 15:27
 */
@Data
@Component
@ConfigurationProperties("wx.mp")
public class WxMpProperties {

    /**
     * 公众号的 appid
     */
    private String appId;

    /**
     * 公众号的 appsecret
     */
    private String secret;

    /**
     * 公众号的 token
     */
    private String token;

}
```



#### 1.2.5 微信配置类中配置 `Token`

```java
package com.atguigu.ggkt.wechat.config;

import com.atguigu.ggkt.wechat.handler.*;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static me.chanjar.weixin.common.api.WxConsts.EventType;
import static me.chanjar.weixin.common.api.WxConsts.EventType.SUBSCRIBE;
import static me.chanjar.weixin.common.api.WxConsts.EventType.UNSUBSCRIBE;
import static me.chanjar.weixin.common.api.WxConsts.XmlMsgType.EVENT;

/**
 * 微信配置类
 *
 * @author 陈江林
 * @date 2022/10/14 15:27
 */
@Configuration
public class WxMpConfiguration {

    @Autowired
    private WxMpProperties wxMpProperties;
    
    @Autowired
    private LogHandler logHandler;
    
    @Autowired
    private MsgHandler msgHandler;

    @Bean
    public WxMpService wxMpService() {
        WxMpService service = new WxMpServiceImpl();
        WxMpDefaultConfigImpl configStorage = new WxMpDefaultConfigImpl();
        configStorage.setAppId(wxMpProperties.getAppId());
        configStorage.setSecret(wxMpProperties.getSecret());
        configStorage.setToken(wxMpProperties.getToken());
//        configStorage.setAesKey(wxMpProperties.getAesKey());
        service.setWxMpConfigStorage(configStorage);

        return service;
    }

}
```



### 1.3 测试公众号连接服务器

注意: 公众号先填写 `URL`, `Token`, 等下配置好服务器再提交

- `URL`: `https://www.th668.top/api/wechat/message`
- `Token`: `ggkt`
- **配置**`**Nginx**`

```nginx
	# 配置 Https, 证书上传至 /usr/local/nginx/conf/ 文件夹下
  server {
    listen 443 ssl;
    server_name localhost;
    ssl_certificate      7984367_www.th668.top.pem;
    ssl_certificate_key  7984367_www.th668.top.key;

    #root /data/wwwroot/default;
    root /usr/local/nginx/html;
    index index.html index.htm index.php;
    #error_page 404 /404.html;
    #error_page 502 /502.html;
    location /nginx_status {
      stub_status on;
      access_log off;
      allow 127.0.0.1;
      deny all;
    }
  
    location ~ [^/]\.php(/|$) {
      #fastcgi_pass remote_php_ip:9000;
      fastcgi_pass unix:/dev/shm/php-cgi.sock;
      fastcgi_index index.php;
      include fastcgi.conf;
    }
  
    location ~ .*\.(gif|jpg|jpeg|png|bmp|swf|flv|mp4|ico)$ {
      expires 30d;
      access_log off;
    }
  
    location ~ .*\.(js|css)?$ {
      expires 7d;
      access_log off;
    }
  
    location ~ ^/(\.user.ini|\.ht|\.git|\.svn|\.project|LICENSE|README.md) {
      deny all;
    }
  
    location /.well-known {
      allow all;
    }

    # 微信公众号 api
    location /api/wechat/message {
       proxy_pass http://127.0.0.1:8333$request_uri;
    }
}
```

- 重启 `Nginx`: `systemctl restart nginx`
- 点击提交

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665817959596-5c2df0b1-b248-40b9-8d22-0fdef8d0910e.png)

- 日志信息（成功）:

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665818267997-d01c806c-e610-4c15-b971-e097e7711309.png)

- 配置成功

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665818476589-868e8fac-b060-4ea6-a311-8deb3864cfbf.png)



## 2 回复图文消息（NEWS）和文本消息（TEXT）

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665839991086-e0a5464e-7120-44d5-b242-dc4e7f72fc6c.png)

### 2.1 微信配置类中配置 `WxMpMessageRouter`

```java
package com.atguigu.ggkt.wechat.config;

import com.atguigu.ggkt.wechat.handler.*;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static me.chanjar.weixin.common.api.WxConsts.EventType;
import static me.chanjar.weixin.common.api.WxConsts.EventType.SUBSCRIBE;
import static me.chanjar.weixin.common.api.WxConsts.EventType.UNSUBSCRIBE;
import static me.chanjar.weixin.common.api.WxConsts.XmlMsgType.EVENT;

/**
 * 微信配置类
 *
 * @author 陈江林
 * @date 2022/10/14 15:27
 */
@Configuration
public class WxMpConfiguration {

    @Autowired
    private WxMpProperties wxMpProperties;
    
    @Autowired
    private LogHandler logHandler;
    
    @Autowired
    private MsgHandler msgHandler;

    @Bean
    public WxMpService wxMpService() {
        WxMpService service = new WxMpServiceImpl();
        WxMpDefaultConfigImpl configStorage = new WxMpDefaultConfigImpl();
        configStorage.setAppId(wxMpProperties.getAppId());
        configStorage.setSecret(wxMpProperties.getSecret());
        configStorage.setToken(wxMpProperties.getToken());
//        configStorage.setAesKey(wxMpProperties.getAesKey());
        service.setWxMpConfigStorage(configStorage);

        return service;
    }

    @Bean
    public WxMpMessageRouter messageRouter(WxMpService wxMpService) {
        final WxMpMessageRouter newRouter = new WxMpMessageRouter(wxMpService);

        // 记录所有事件的日志 （异步执行）
        newRouter.rule().handler(logHandler).next();

        // 默认, 消息回复
        newRouter.rule().async(false).handler(msgHandler).end();

        return newRouter;
    }

}
```



#### 2.1.1 新建日志类 `LogHandler`

```java
package com.atguigu.ggkt.wechat.handler;

import com.atguigu.ggkt.wechat.utils.JsonUtils;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@Component
public class LogHandler extends AbstractHandler {
    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService wxMpService,
                                    WxSessionManager sessionManager) {
        this.logger.info("\n接收到请求消息，内容：{}", JsonUtils.toJson(wxMessage));
        return null;
    }

}
```



#### 2.1.2 新建消息回复类 `MsgHandler`

```java
package com.atguigu.ggkt.wechat.handler;

import com.atguigu.ggkt.client.course.CourseFeignClient;
import com.atguigu.ggkt.wechat.builder.TextBuilder;
import com.atguigu.ggkt.wechat.utils.JsonUtils;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

import static me.chanjar.weixin.common.api.WxConsts.XmlMsgType;

/**
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@Component
public class MsgHandler extends AbstractHandler {

    @Autowired
    private CourseFeignClient courseFeignClient;

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) {

        if (!wxMessage.getMsgType().equals(XmlMsgType.EVENT)) {
            //TODO 可以选择将消息保存到本地
        }

        //TODO 组装回复消息
        String content = "收到信息内容：" + JsonUtils.toJson(wxMessage);

        return new TextBuilder().build(content, wxMessage, weixinService);
    }

}
```



#### 2.1.3 新建抽象类 `AbstractHandler`

```java
package com.atguigu.ggkt.wechat.handler;

import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
public abstract class AbstractHandler implements WxMpMessageHandler {
    protected Logger logger = LoggerFactory.getLogger(getClass());
}
```



#### 2.1.4 新建工具类 `JsonUtils`

```java
package com.atguigu.ggkt.wechat.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
public class JsonUtils {
    public static String toJson(Object obj) {
        Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .disableHtmlEscaping()
            .create();
        return gson.toJson(obj);
    }
}
```



#### 2.1.5 新建 `TextBuilder` 类

```java
package com.atguigu.ggkt.wechat.builder;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutTextMessage;

/**
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
public class TextBuilder extends AbstractBuilder {

    @Override
    public WxMpXmlOutMessage build(String content, WxMpXmlMessage wxMessage,
                                   WxMpService service) {
        WxMpXmlOutTextMessage m = WxMpXmlOutMessage.TEXT().content(content)
                .fromUser(wxMessage.getToUser()).toUser(wxMessage.getFromUser())
                .build();
        return m;
    }

}
```

#### 2.1.6 新建 `AbstractBuilder` 类

```java
package com.atguigu.ggkt.wechat.builder;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
public abstract class AbstractBuilder {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    public abstract WxMpXmlOutMessage build(String content,
                                            WxMpXmlMessage wxMessage, WxMpService service);
}
```



### 2.2 远程调用接口

#### 2.2.1 `service_wechat`消息类, 远程调用 `service_vod`中的接口获取数据

1. `service_vod` 新建控制类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665836670931-72974ddc-bd5f-48b5-b50e-e16e1fb855e8.png)

```java
package com.atguigu.ggkt.vod.api;

import com.atguigu.ggkt.model.vod.Course;
import com.atguigu.ggkt.vod.service.CourseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 微信公众号接口 课程信息
 *
 * @author 陈江林
 * @date 2022/10/15 14:00
 */
@Slf4j
@Api(tags = "微信公众号接口 课程信息")
@RestController
@RequestMapping("/api/vod/course")
public class CourseApiController {

    @Autowired
    private CourseService courseService;

    @ApiOperation("根据关键字查询课程")
    @GetMapping("/inner/findByKeyword/{keyword}")
    public List<Course> findByKeyword(
            @ApiParam(value = "关键字", required = true)
            @PathVariable String keyword) {
        log.info("根据关键字查询课程");
        QueryWrapper<Course> queryWrapper = new QueryWrapper();
        queryWrapper.like("title", keyword);
        List<Course> list = courseService.list(queryWrapper);
        return list;
    }

}
```

1. 创建模块 `service_course_client`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665836768715-d0f47fad-f648-423f-8cd7-9159423380bd.png)

- `pom.xml`

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <configuration>
                <!-- 取消查找本项目下的Main方法：为了解决Unable to find main class的问题 -->
                <mainClass>none</mainClass>
                <!-- 为了解决依赖模块找不到此模块中的类或属性 -->
                <classifier>execute</classifier>
            </configuration>
            <executions>
                <execution>
                    <goals>
                        <goal>repackage</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```



1. 新建接口类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665836947791-cf0ac8bb-c42b-4cb6-bafd-129712c3964d.png)

```java
package com.atguigu.ggkt.client.course;

import com.atguigu.ggkt.model.vod.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author 陈江林
 * @date 2022/10/15 14:05
 */
@FeignClient(value = "service-vod")
public interface CourseFeignClient {

    /**
     * 根据关键字查询课程
     *
     * @param keyword 关键字
     * @return {@link List}<{@link Course}>
     */
    @GetMapping("/api/vod/course/inner/findByKeyword/{keyword}")
    List<Course> findByKeyword(@PathVariable String keyword);

}
```

1. `service_wechat` 工程引入`service_course_client` 依赖

```xml
<!-- 远程接口 -->
<dependency>
    <groupId>com.atguigu</groupId>
    <artifactId>service_course_client</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```



#### 2.2.2 查询课程回复信息 `MsgHandler`

```java
package com.atguigu.ggkt.wechat.handler;

import com.atguigu.ggkt.client.course.CourseFeignClient;
import com.atguigu.ggkt.model.vod.Course;
import com.atguigu.ggkt.wechat.builder.TextBuilder;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutNewsMessage.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static me.chanjar.weixin.common.api.WxConsts.XmlMsgType;

/**
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@Component
public class MsgHandler extends AbstractHandler {

    @Autowired
    private CourseFeignClient courseFeignClient;

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) {

        if (!wxMessage.getMsgType().equals(XmlMsgType.EVENT)) {
            //TODO 可以选择将消息保存到本地
        }

        //TODO 组装回复消息
        // String content = JsonUtils.toJson(wxMessage);

        // 默认回复文本信息
        String content = "请重新输入关键字，没有匹配到相关视频课程";

        // 搜索课程信息
        WxMpXmlOutMessage courseWxMpXmlOutMessage = course(wxMessage);
        // 如果有则回复图文信息
        if (courseWxMpXmlOutMessage != null) {
            return courseWxMpXmlOutMessage;
        }

        return new TextBuilder().build(content, wxMessage, weixinService);
    }

    /**
     * 搜索课程信息, 回复用户
     * 图文消息个数；当用户发送文本、图片、语音、视频、图文、地理位置这六种消息时，开发者只能回复1条图文消息；
     * 其余场景最多可回复8条图文消息
     *
     * @param wxMessage
     * @return {@link WxMpXmlOutMessage}
     */
    public WxMpXmlOutMessage course(WxMpXmlMessage wxMessage) {
        List<Course> courseList = courseFeignClient.findByKeyword(wxMessage.getContent());
        if (CollectionUtils.isEmpty(courseList)) {
            return null;
        }

        List<Item> itemList = new ArrayList<>();
        courseList.forEach(course -> {
            // 获取课程属性
            String title = course.getTitle();
            String cover = course.getCover();
            String url = "http://glkt.atguigu.cn/#/liveInfo/" + course.getId();
            // 创建对象
            Item item = new Item();
            item.setTitle(title);
            item.setDescription(title);
            item.setPicUrl(cover);
            item.setUrl(url);

            itemList.add(item);
        });

        return WxMpXmlOutMessage.NEWS().articles(itemList)
                .fromUser(wxMessage.getToUser()).toUser(wxMessage.getFromUser())
                .build();
    }
}
```



### 2.3 测试回复

- 在公众号输入关键字，返回搜索的课程信息

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665843676564-4f0323f3-2984-4774-b583-a0c105b76641.png)

## 3 接收事件推送

### 3.1 关注/取消关注事件

#### 3.1.1 配置

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665844586158-1e4971a1-34a7-4011-88d7-b50652bdab22.png)

```java
// 关注事件
newRouter.rule().async(false).msgType(EVENT).event(SUBSCRIBE).handler(this.subscribeHandler).end();

// 取消关注事件
newRouter.rule().async(false).msgType(EVENT).event(UNSUBSCRIBE).handler(this.unsubscribeHandler).end();
```



#### 3.1.2 新建关注处理类

```java
package com.atguigu.ggkt.wechat.handler;

import com.atguigu.ggkt.wechat.builder.TextBuilder;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@Component
public class SubscribeHandler extends AbstractHandler {

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) throws WxErrorException {

        this.logger.info("新关注用户 OPENID: " + wxMessage.getFromUser());

        // 获取微信用户基本信息
        try {
            WxMpUser userWxInfo = weixinService.getUserService()
                .userInfo(wxMessage.getFromUser(), null);
            if (userWxInfo != null) {
                // TODO 可以添加关注用户到本地数据库
            }
        } catch (WxErrorException e) {
            if (e.getError().getErrorCode() == 48001) {
                this.logger.info("该公众号没有获取用户信息权限！");
            }
        }


        WxMpXmlOutMessage responseResult = null;
        try {
            responseResult = this.handleSpecial(wxMessage);
        } catch (Exception e) {
            this.logger.error(e.getMessage(), e);
        }

        if (responseResult != null) {
            return responseResult;
        }

        try {
            return new TextBuilder().build("感谢你关注“硅谷课堂”，可以根据关键字搜索您想看的视频教程，如：JAVA基础、Spring boot、大数据等", wxMessage, weixinService);
        } catch (Exception e) {
            this.logger.error(e.getMessage(), e);
        }

        return null;
    }

    /**
     * 处理特殊请求，比如如果是扫码进来的，可以做相应处理
     */
    private WxMpXmlOutMessage handleSpecial(WxMpXmlMessage wxMessage)
        throws Exception {
        //TODO
        return null;
    }

}
```

#### 3.1.3 新建取消关注处理类

```java
package com.atguigu.ggkt.wechat.handler;

import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@Component
public class UnsubscribeHandler extends AbstractHandler {

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService wxMpService,
                                    WxSessionManager sessionManager) {
        String openId = wxMessage.getFromUser();
        this.logger.info("取消关注用户 OPENID: " + openId);
        // TODO 可以更新本地数据库为取消关注状态
        return null;
    }

}
```

#### 3.1.4 测试取消关注

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665845490779-5f15121f-f4c2-425d-9675-764f7a350762.png)

#### 3.1.5 测试关注

```
新关注用户 OPENID: oWyia6Mig1f8x9QOcJigHDNHVr-I
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665846716810-c78c6cfd-bc4b-46e8-984e-5428a62b735c.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665845518440-95506a59-82c6-4f4e-9495-eaab8a7f520f.png)



### 3.2 自定义菜单事件

#### 3.2.1 配置

```java
// 自定义菜单事件
newRouter.rule().async(false).msgType(EVENT).event(EventType.CLICK).handler(this.menuHandler).end();
```



#### 3.2.2 新建自定义菜单事件处理类

```java
package com.atguigu.ggkt.wechat.handler;

import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.stereotype.Component;

import java.util.Map;

import static me.chanjar.weixin.common.api.WxConsts.EventType;

/**
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@Component
public class MenuHandler extends AbstractHandler {

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) {
        String msg = String.format("type:%s, event:%s, key:%s",
                wxMessage.getMsgType(), wxMessage.getEvent(),
                wxMessage.getEventKey());

        if (EventType.VIEW.equals(wxMessage.getEvent())) {
            return null;
        }

        String eventKey = wxMessage.getEventKey();
        if ("aboutUs".equals(eventKey)) {
            msg = aboutUs();
        }

        return WxMpXmlOutMessage.TEXT().content(msg)
                .fromUser(wxMessage.getToUser()).toUser(wxMessage.getFromUser())
                .build();
    }

    /**
     * 关于我们
     *
     * @return
     */
    private String aboutUs() {
        return "硅谷课堂现开设Java、HTML5前端+全栈、大数据、全链路UI/UE设计、人工智能、大数据运维+Python自动化、Android+HTML5混合开发等多门课程；同时，通过视频分享、谷粒学苑在线课堂、大厂学苑直播课堂等多种方式，满足了全国编程爱好者对多样化学习场景的需求，已经为行业输送了大量IT技术人才。";
    }

}
```

#### 3.2.3 测试

- 点击我的 -> 关于我们，返回关于我们的介绍

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665844813984-9d4d8892-0f07-4a8c-9919-dd0d4ceb856f.png)



## 4 公众号模板消息

### 4.1 实现目标

- 购买课程支付成功微信推送消息

### 4.2 模板消息实现

- 接口文档：`https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Template_Message_Interface.html`

### 4.3 申请模板消息

- 首先我们需要知道，模板消息是需要申请的。
- 但是我们在申请时还是有一些东西要注意，这个在官方的文档有非常详细的说明。

```
https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Template_Message_Operation_Specifications.html
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665844990348-40f5ebc3-c677-4f7f-8a0d-9d66a83b641b.png)

- 这个大家好好看看。选择行业的时候可要谨慎些，因为这个一个月只可以修改一次。
- 下面看看在哪里申请，硅谷课堂已经申请过，忽略

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665845008602-6dd0aeef-4849-447e-bb0c-fe919589fe90.png)

- 申请之后就耐心等待，审核通过之后就会出现“广告与服务”模板消息的菜单。

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665845023840-07b77fbf-89ca-4269-b85c-172f11c7d601.png)



### 4.4、添加模板消息

- 审核通过之后，我们就可以添加模板消息，进行开发了。
- 我们点击模板消息进入后，直接在模板库中选择你需要的消息模板添加就可以了，添加之后就会在我的模板中。会有一个模板id，这个模板id在我们发送消息的时候会用到。
- 模板消息如下：

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665845039761-48956aed-5183-4450-a288-312afa20db55.png)

- 我们需要模板消息：

1. 订单支付成功通知；

- 模板库中没有的模板，可以自定义模板，审核通过后可以使用。



## 5. 公众号测试号申请模板消息

### 5.1 新增测试模板

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665845848184-522b5cb8-9c7d-4227-bb3e-d592818127d0.png)

### 5.2 填写信息

#### 5.2.1 下载模板示例

```
https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Template_Message_Operation_Specifications.html
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665845258720-7aad86a1-1565-4542-8239-a2a30ff37b6f.png)

- 模板示例

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665845566196-870745ba-ff5c-4149-a1df-fbdc88eeac41.png)

#### 5.2.2 填写模板标题和模板内容

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665845368874-db801f66-fd84-4d0e-855b-8fff60d111c0.png)

```latex
{{first.DATA}}
订单编号：{{keyword1.DATA}}
订单名称：{{keyword2.DATA}}
支付时间：{{keyword3.DATA}}
支付金额：{{keyword4.DATA}}
{{remark.DATA}}
```



## 6 模板消息接口

### 6.1 追加代码 `MessageController`

```java
    @Autowired
    private MessageService messageService;

    @GetMapping("/pushPayMessage")
    public Result pushPayMessage() throws WxErrorException {
        messageService.pushPayMessage(1L);
        return Result.ok();
    }
```

### 6.2 新建服务类

```java
package com.atguigu.ggkt.wechat.service;

/**
 * 公众号消息 服务类
 *
 * @author 陈江林
 * @date 2022/10/15 23:05
 */
public interface MessageService {

    /**
     * 发送模板消息
     *
     * @param l l
     */
    void pushPayMessage(long l);

}
```

### 6.3 新建服务实现类

```java
package com.atguigu.ggkt.wechat.service.impl;

import com.atguigu.ggkt.wechat.config.WxProperties;
import com.atguigu.ggkt.wechat.service.MessageService;
import lombok.SneakyThrows;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 公众号消息 服务实现类
 *
 * @author 陈江林
 * @date 2022/10/15 23:06
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private WxProperties wxProperties;

    //TODO 暂时写成固定值测试，后续完善
    @SneakyThrows
    @Override
    public void pushPayMessage(long orderId) {
        String openid = "oWyia6Mig1f8x9QOcJigHDNHVr-I";

        // 模板id
        String templateId = "2WOzacjuyXuTWESj17xl9TwHBg0gAYlK5aG9TJj0GkM";
        // 点击模板消息要访问的网址
        String url = wxProperties.getWxMpTemplateMessageObject().get(templateId);
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                // 要发送的用户的 openid
                .toUser(openid)
                .templateId(templateId)
                .url(url + orderId)
                .build();
        // 如果是正式版发送消息，，这里需要配置你的信息
        templateMessage.addData(new WxMpTemplateData("first", "亲爱的用户：您有一笔订单支付成功。", "#272727"));
        templateMessage.addData(new WxMpTemplateData("keyword1", "1314520", "#272727"));
        templateMessage.addData(new WxMpTemplateData("keyword2", "java基础课程", "#272727"));
        templateMessage.addData(new WxMpTemplateData("keyword3", "2022-01-11", "#272727"));
        templateMessage.addData(new WxMpTemplateData("keyword4", "100", "#272727"));
        templateMessage.addData(new WxMpTemplateData("remark", "感谢你购买课程，如有疑问，随时咨询！", "#272727"));
        String msg = wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        System.out.println(msg);
    }

}
```

### 6.4 新建属性配置类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665847518849-44830e1f-fc6d-45a4-b4cd-8529ba9c02c4.png)

```java
package com.atguigu.ggkt.wechat.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author 陈江林
 * @date 2022/10/15 23:13
 */
@Data
@Component
@ConfigurationProperties("wx")
public class WxProperties {

    /**
     * 多个模板消息配置信息
     * 键（模板 id）, 值（点击模板消息要访问的网址）
     */
    private Map<String, String> wxMpTemplateMessageObject;

}
```

### 6.5 `application.yml` 配置

```yaml
wx:
  wx-mp-template-message-object: {
    "2WOzacjuyXuTWESj17xl9TwHBg0gAYlK5aG9TJj0GkM", "http://ggkt2.vipgz1.91tunnel.com/#/pay/"
  }
```



### 6.6 测试

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665848608517-275e9cd7-95d2-45a2-ac50-7ec09b18c77a.png)

```java
package com.atguigu.ggkt.wechat;

import com.atguigu.ggkt.vo.wechat.MenuVo;
import com.atguigu.ggkt.wechat.service.MenuService;
import com.atguigu.ggkt.wechat.service.MessageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 陈江林
 * @date 2022/10/13 21:29
 */
@SpringBootTest
public class ServiceWechatApplicationTest {

    @Autowired
    private MessageService messageService;

    /**
     * 测试发送模板消息
     */
    @Test
    public void TestSendMessage() {
        messageService.pushPayMessage(0L);
    }
}
```

- 依赖

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
```



### 6.7 公众号显示

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665849075720-859b08ab-5f97-4bd5-8c91-2beea77ba5bf.png)

# 十四 公众号授权

```
git checkout -b 14.0.0_wechat_oauth2
```

## 1 需求描述

- 通过公众号菜单进入的页面都要授权登录

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665900934080-4258b86b-7cc8-4d05-aa69-251a9b4a3a80.png)



### 1.1 思路

![img](https://cdn.nlark.com/yuque/__puml/fff5aef6526a6a0694be5fdd4cf71def.svg)

#### 1.1.1 第三步 - 微信端授权显示

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666102485682-0202f317-a052-4605-abfc-634565d140c2.png)



### 1.2 微信提示错误信息 10003

- 电脑显示

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666076580140-ce03dcbc-5ac4-4013-b5b5-a5892747d73f.png)

- 手机显示

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666076663117-71590075-374a-4f3e-9265-dd06ccd0d491.png)

- `10003`: `redirect_uri`域名与后台配置不一致

    - 重定向到 `userInfo` 的地址的`域名` 和 `公众号配置`的不同

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666073511570-252d9d49-a4f4-402d-ba6b-393357e11430.png)

```yaml
wx:
  # 授权回调获取用户信息的接口地址
  user-info-url: "https://www.th668.top/api/wechat/redirect/userInfo"
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666073796182-6ec911f9-bbf7-446a-93f3-7258c991a872.png)





## 2 授权登录

- 文档: `https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/Wechat_webpage_authorization.html`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665900753529-d7eda34e-6195-4d9b-9e9c-2109333e9187.png)

- `scope` 为 `snsapi_userinfo`



### 2.1 配置授权回调授权

#### 2.1.1 在公众号正式号配置

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665993675171-dfddf778-ce01-42e3-ba4d-cd3f1c515819.png)

- 在微信公众号请求用户网页授权之前, 开发者需要先到公众平台官网中的

    - `设置与开发`

        - `接口权限`

    -   - `网页服务` -> `网页授权` -> `网页授权获取用户基本信息` 的配置选项中, 修改申请回调域名

- 注意: 填写的是全域名, 不加 `http://` 等响应头
- 比如需要网页授权的域名为：`www.qq.com`

    - 配置以后此域名下面的页面 `http://www.qq.com/music.html `、 `http://www.qq.com/login.html` 都可以进行OAuth2.0鉴权。但`http://pay.qq.com` 、 `http://music.qq.com` 、 `http://qq.com` 无法进行 `OAuth2.0` 鉴权

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665904845468-6e522c02-d6e1-495d-aa67-6bf31f57d844.png)



### 2.2 部署公众号前端页面

### 2.3 前端处理

#### 2.3.1 全局处理授权登录, 处理登录页面: `/src/App.vue`

1. 访问页面时首先判断是否有 `token` 信息, 如果没有跳转到授权登录接口
2. 通过 `localStorage` 存储 `token` 信息

- 在 `H5` 中, 加入一个 `localStorage` 特性, 这个特性主要是用来作为本地存储来使用的, 解决了 `cookie` 存储空间不足的问题（`cookie` 中每条 `cookie` 的存储空间很小, 只有几 `K`）, `localStorage` 中一般浏览器支持的是 `5M` 大小，这个在不同的浏览器中 `localStorage` 会有所不同, 它只能存储字符串格式的数据, 所以最好在每次存储时把数据转换成 `JSON` 格式, 取出的时候再转换回来

#### 2.3.2 前端代码示例

```javascript
wechatLogin() {
  // 处理微信授权登录
  let token = this.getQueryString('token') || '';
  if(token != '') {
    window.localStorage.setItem('token', token);
  }

  // 所有页面都必须登录，两次调整登录, 这里与接口返回 208 状态
  token = window.localStorage.getItem('token') || '';
  if(token == '') {
    const url = window.location.href.replace('#', 'guiguketan');
    window.location = 'http://www.th668.top/api/wechat/redirect/authorize?returnUrl=' + url;
  }

  console.log('token2: ' + window.localStorage.getItem('token'));
}
```



## 3 授权登录接口

- 操作模块: `service-wechat`

### 3.1 `application.yml` 配置

```yaml
wx: 
	user-info-url: "https://www.th668.top/api/user/wechat/userInfo"
```



### 3.2 `WxProperties` 属性配置类

```java
package com.atguigu.ggkt.wechat.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author 陈江林
 * @date 2022/10/15 23:13
 */
@Data
@Component
@ConfigurationProperties("wx")
public class WxProperties {

    /**
     * 多个模板消息配置信息
     * 键（模板 id）, 值（点击模板消息要访问的网址）
     */
    private Map<String, String> wxMpTemplateMessageObject;

    /**
     * 授权回调获取用户信息的接口地址
     */
    private String userInfoUrl;
}
```



### 3.3 新建控制类 `WechatController`

```java
package com.atguigu.ggkt.wechat.controller;

import com.alibaba.fastjson.JSON;
import com.atguigu.ggkt.client.user.UserInfoFeignClient;
import com.atguigu.ggkt.model.user.UserInfo;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.util.JwtHelper;
import com.atguigu.ggkt.wechat.config.WxProperties;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.WxOAuth2UserInfo;
import me.chanjar.weixin.common.bean.oauth2.WxOAuth2AccessToken;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.util.http.URIUtil;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 公众号网页授权
 *
 * @author 陈江林
 * @date 2022/10/17 16:20
 */
@Slf4j
@Controller
@RequestMapping("/api/wechat/redirect")
public class WechatController {

    @Autowired
    private WxMpService wxService;

    @Autowired
    private WxProperties wxProperties;

    @Autowired
    private UserInfoFeignClient userInfoFeignClient;

    /**
     * 第一步 用户同意授权获取 code
     *
     * @return {@link String}
     */
    @RequestMapping("/authorize")
    public String authorize(@RequestParam String returnUrl) {
        // 构造 oauth2 授权的 url 连接
        String url = wxService.getOAuth2Service()
                .buildAuthorizationUrl(wxProperties.getUserInfoUrl(),
                        WxConsts.OAuth2Scope.SNSAPI_USERINFO,
                        URIUtil.encodeURIComponent(returnUrl.replace("guiguketan", "#")));
        // 跳转回调 redirect_uri，应当使用 https 链接来确保授权 code 的安全性
        // 重定向到用户授权界面, 如果用户同意授权，页面将跳转至 redirect_uri/?code=CODE&state=STATE。
        log.info("redirect_uri: " + url);
        return "redirect:" + url;
    }

    /**
     * 拉取用户信息
     *
     * @param code
     * @param state
     * @return {@link String}
     */
    @RequestMapping("/userInfo")
    public String userInfo(@RequestParam String code, @RequestParam String state) {
        try {
            // 第二步：通过 code 换取网页授权 access_token
            WxOAuth2AccessToken accessToken = wxService.getOAuth2Service().getAccessToken(code);
            /// 第三步：刷新access_token（如果需要）
            // 第四步：拉取用户信息(需 scope 为 snsapi_userinfo)
            WxOAuth2UserInfo user = wxService.getOAuth2Service().getUserInfo(accessToken, null);
            log.info(JSON.toJSONString(user));

            // 1. 保存用户信息
            // 1.1 检查是否已保存
            // 获取用户 openid
            String openid = user.getOpenid();
            // 根据 openid 获取用户信息

            Result<UserInfo> result = userInfoFeignClient.getUserInfoByOpenId(openid);
            if(result.getMessage().equals(Result.FAILED)){
                return null;
            }

            UserInfo userInfo = result.getData();
            if (userInfo == null) {
                // 创建用户信息对象
                userInfo = new UserInfo();
                userInfo.setOpenId(openid);
                userInfo.setNickName(user.getNickname());
                userInfo.setAvatar(user.getHeadImgUrl());
                userInfo.setSex(user.getSex());
                userInfo.setProvince(user.getProvince());
                // 保存操作
                userInfoFeignClient.save(userInfo);
            }

            // 生成 token, 按照一定规则生成字符串, 可以包含用户信息
            String token = JwtHelper.createToken(userInfo.getId(), userInfo.getNickName());
            log.info("token: " + token);
            if (!token.contains("?")) {
                return "redirect:" + state + "?token=" + token;
            } else {
                return "redirect:" + state + "&token=" + token;
            }
        } catch (WxErrorException e) {
            e.printStackTrace();
        }

        log.info("state: " + state);
        return "null";
    }

}
```



### 3.4 `service_wachet` 依赖

```xml
<!-- 远程接口 -->
<dependency>
    <groupId>com.atguigu</groupId>
    <artifactId>service_user_client</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```



### 3.5 远程接口

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666103728896-39668a8e-4069-495a-af5a-9ff5b890a348.png)

```java
package com.atguigu.ggkt.client.user;

import com.atguigu.ggkt.model.user.UserInfo;
import com.atguigu.ggkt.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 远程调用接口
 *
 * @author 陈江林
 * @date 2022/10/13 14:37
 */
@FeignClient(value = "service-user")
public interface UserInfoFeignClient {

    /**
     * 根据 id 查询用户数据
     *
     * @param id id
     * @return {@link UserInfo}
     */
    @GetMapping("/admin/user/userInfo/inner/getById/{id}")
    UserInfo getById(@PathVariable Long id);

    /**
     * 根据 openid 获取用户信息
     *
     * @param openid openid
     * @return {@link Result}<{@link UserInfo}>
     */
    @GetMapping("/admin/user/userInfo/getUserInfoByOpenId")
    Result<UserInfo> getUserInfoByOpenId(@RequestParam("openid") String openid);

    /**
     * 保存
     *
     * @param userInfo
     * @return {@link Result}
     */
    @PostMapping(value = "/admin/user/userInfo/save", consumes = "application/json")
    Result save(@RequestBody UserInfo userInfo);
}
```



### 3.6 `service_user` 控制类

```java
package com.atguigu.ggkt.user.controller;


import com.atguigu.ggkt.model.user.UserInfo;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.user.service.UserInfoService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 陈江林
 * @since 2022-10-13
 */
@Api(tags = "用户信息")
@RestController
@RequestMapping("/admin/user/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation("获取用户")
    @GetMapping("/inner/getById/{id}")
    public Result<UserInfo> getById(@PathVariable Long id) {
        UserInfo userInfo = userInfoService.getById(id);
        return Result.ok(userInfo);
    }

    @ApiOperation("根据 openid 获取用户信息")
    @GetMapping("/getUserInfoByOpenId")
    public Result<UserInfo> getUserInfoByOpenId(@RequestParam("openid") String openid) {
        LambdaQueryWrapper<UserInfo> wrapper = new LambdaQueryWrapper();
        wrapper.eq(UserInfo::getOpenId, openid);
        UserInfo userInfo = userInfoService.getOne(wrapper);
        return Result.ok(userInfo);
    }

    @ApiOperation("保存用户信息")
    @PostMapping(value = "/save", consumes = "application/json")
    public Result save(@RequestBody UserInfo userInfo) {
        userInfoService.save(userInfo);
        return Result.ok();
    }

}
```



## 4 使用 `token`

- 通过 `token` 传递用户信息

### 4.1 `JWT` 介绍

- `JWT`（`Json Web Token`）是为了在网络应用环境间传递声明而执行的一种基于 `JSON` 的开放标准
- `JWT` 的声明一般被用来在`身份提供者`和`服务提供者`间传递被认证的用户身份信息, 以便于从资源服务器获取资源

    - 比如用来用户登录上

- `JWT` 最重要的作用就是对 `token` 信息的`**防伪**`作用



### 4.2 `JWT` 的原理

- 一个 `JWT` 由三个部分组成: **公共部分、私有部分、签名部分**
- 最后由这三组合进行 `base64` 编码得到 `JWT`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665907752555-6bc975da-fb99-47db-aa60-971174a6f900.png)



#### 4.2.1 公共部分

- 主要是该 `JWT` 的相关配置参数、比如签名的加密算法、格式类型、过期时间等等



#### 4.2.2 私有部分

- 用户自定义的内容, 根据实际要真正要封装的信息
- `userInfo {用户的 id, 用户的昵称 nickName}`

#### 4.2.3 签名部分

- `SaltiP`: 当前服务器的 `IP` 地址! {`linux` 中配置代理服务器的 `IP`}
- 主要用户对 `JWT` 生成字符串的时候, 进行加密{盐值}
- `base64` 编码, 并不是加密, 只是把明文信息变成了不可见的字符串, 但是其实只要用一些工具就可以把 `base64` 编码解成明文, 所以不要在 `JWT` 中放入涉及私密的信息



### 4.3 整合 `JWT`

#### 4.3.1 在 `service_utils` 模块添加依赖

```xml
<dependencies>
	<!-- 整合 JWT -->
  <dependency>
		<groupId>org.apache.httpcomponents</groupId>
		<artifactId>httpclient</artifactId>
	</dependency>
	<dependency>
		<groupId>io.jsonwebtoken</groupId>
		<artifactId>jjwt</artifactId>
	</dependency>
	<dependency>
		<groupId>joda-time</groupId>
		<artifactId>joda-time</artifactId>
	</dependency>
</dependencies>
```



#### 4.3.2 新建 `JWT` 工具类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666077489804-4f2d5a16-a6fe-48a2-a909-572ca3e2c45f.png)

```java
package com.atguigu.ggkt.util;

import io.jsonwebtoken.*;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @author 陈江林
 * @date 2022/10/18 15:15
 */
public class JwtHelper {
    /**
     * token 字符串有效时间
     */
    private final static long TOKEN_EXPIRATION = 24 * 60 * 60 * 1000;

    /**
     * 加密编码秘钥
     */
    private final static String TOKEN_SIGN_KEY = "123456";

    /**
     * 根据 userid 和 username 生成 token 字符串
     *
     * @param userId   用户id
     * @param userName 用户名
     * @return {@link String}
     */
    public static String createToken(Long userId, String userName) {
        return Jwts.builder()
                // 设置token分类
                .setSubject("GGKT-USER")
                // token字符串有效时长
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION))
                // 私有部分（用户信息）
                .claim("userId", userId)
                .claim("userName", userName)
                // 根据秘钥使用加密编码方式进行加密，对字符串压缩
                .signWith(SignatureAlgorithm.HS512, TOKEN_SIGN_KEY)
                .compressWith(CompressionCodecs.GZIP)
                .compact();
    }

    /**
     * 从 token 字符串获取 userid
     *
     * @param token 令牌
     * @return {@link Long}
     */
    public static Long getUserId(String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }

        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(TOKEN_SIGN_KEY).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        Integer userId = (Integer) claims.get("userId");
        return userId.longValue();
    }


    /**
     * 从 token 字符串获取 getUserName
     *
     * @param token 令牌
     * @return {@link String}
     */
    public static String getUserName(String token) {
        if (StringUtils.isEmpty(token)) {
            return "";
        }

        Jws<Claims> claimsJws
                = Jwts.parser().setSigningKey(TOKEN_SIGN_KEY).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        return (String) claims.get("userName");
    }

    public static void main(String[] args) {
        String token = JwtHelper.createToken(1L, "lucy");
        System.out.println(token);
        System.out.println(JwtHelper.getUserId(token));
        System.out.println(JwtHelper.getUserName(token));
    }
}
```



## 5 新建前端项目

- `vue create vue-mobile`

    - 选择  `**Babel**`**(单选框,** `**空格**`**选择)**

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665926383097-228966ec-e14b-4953-b23b-8e7693f51438.png)

- 选择 `In dedicated config files`（对应的配置单独生成文件）
- 选择 `n` 是否保存配置

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665926571053-04f56534-49bb-4dca-baff-c86a0614f766.png)

- `public` 中的静态资源会被复制到输出目录中
- `src` 源代码

    - `assets` 静态文件
    - `components` 组件

- `.browerslistrc` 浏览器相关支持情况
- `.gitgnore` GIT 忽略的文件
- `babel.config.js` ES 语法转换



### 1.1 使用 `vue ui`

#### 1.1.1 导入项目

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665927051783-c588e927-64f3-4ac2-8cce-1a72763334af.png)



### 1.2 新建代码规范

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665927704976-727bd13c-a614-47cc-b9c8-83edc3f56c38.png)

```latex
root = true

[*]
charset = utf-8
indent_style = space
indent_size = 2
end_of_line = lf
insert_final_newline = true
trim_trailing_whitespace = true
```



### 1.3 路由

#### 1.3.1 安装路由

```
npm install vue-router@3.0.2 --save
```



#### 1.3.2 新建路由配置

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665927841440-1dd8c41a-1b20-483d-8fb8-83c1ca4eb577.png)

```javascript
import vue from 'vue'
import VueRouter from 'vue-router'

const Home = () => import('../views/home/Home')

// 1. 安装插件
vue.use(VueRouter);

// 2. 创建 router
const routes = [
  {
    path: '',
    redirect: '/home'
  },
  {
    path: '/home',
    component: Home
  }
]

const router = new VueRouter({
  routes,
  mode: 'history'
})

export default router;
```



#### 1.3.3 新建页面

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665927957445-c0e22daf-84fd-4a8a-b9da-b1c021db398e.png)

```vue
<template>
  <h1>欢迎来到硅谷课堂公众号测试平台</h1>
</template>

<script>
export default {
  name: "Home"
}
</script>

<style scoped>

</style>
```



#### 1.3.4 启用路由

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1665928030191-ece0c2e4-d6b4-446e-a36a-0394b5203a9c.png)

```javascript
import Vue from 'vue'
import App from './App.vue'
import router from "./router";

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
  router,
}).$mount('#app')
```



### 5.4 引导用户进入授权页面同意授权

#### 5.4.1 `App.js`

```vue
<template>
  <div id="app">
    <!-- 路由出口 -->
    <!-- 路由匹配到的组件将渲染在这里 -->
    <router-view></router-view>
  </div>
</template>

<script>

export default {
  name: 'App',
  created() {
    this.wechatLogin();
  },
  methods: {
    wechatLogin() {
      // 处理微信授权登录
      let token = this.getQueryString('token') || '';
      if (token !== '') {
        window.localStorage.setItem('token', token);
      }

      // 所有页面都必须登录，两次调整登录, 这里与接口返回 208 状态
      token = window.localStorage.getItem('token') || '';
      if (token === '') {
        const url = window.location.href.replace('#', 'guiguketan');
        window.location = 'http://175.178.174.83/api/wechat/redirect/authorize?returnUrl=' + url;
      }

      console.log('token2: ' + window.localStorage.getItem('token'));
    },
    getQueryString(paramName) {
      if (window.location.href.indexOf('?') === -1) return '';

      let searchString = window.location.href.split('?')[1];
      let i, val, params = searchString.split("&");

      for (i = 0; i < params.length; i++) {
        val = params[i].split("=");
        if (val[0] === paramName) {
          return val[1];
        }
      }

      return '';
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
```



## 6 测试

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666078979935-c29a14a9-0606-403e-823e-a5c556876cb1.png)

```bash
2022-10-18 15:07:53.061  INFO 7670 --- [nio-8305-exec-5] c.a.g.w.controller.WechatController      : redirect_uri: https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc2d7509ddd5c9418&redirect_uri=http%3A%2F%2F175.178.174.83%2Fapi%2Fwechat%2Fredirect%2FuserInfo&response_type=code&scope=snsapi_userinfo&state=http%3A%2F%2F175.178.174.83%2F%23%2Fhome&connect_redirect=1#wechat_redirect
2022-10-18 15:07:54.726  INFO 7670 --- [nio-8305-exec-6] c.a.g.w.controller.WechatController      : {"city":"","country":"","headImgUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/rq1WRl9DdCMBX2F5dWkdDVHlI4rvuhjIOuosfmhszqcPnyRnF0oYQuYJ4NNv7PCUEIoL2iaoHjJbhticSaUfpDqA/132","nickname":"陈江林","openid":"oWyia6Mig1f8x9QOcJigHDNHVr-I","privileges":[],"province":"","sex":0}
2022-10-18 15:07:54.726  INFO 7670 --- [nio-8305-exec-6] c.a.g.w.controller.WechatController      : state: http://175.178.174.83/#/home
```

# 十五 点播课程模块-微信支付

```
git checkout -b 15.0.0_course
```

# 1 课程列表和详情

### 1.1 目标

- 点击公众号菜单`课程->后端开发`, 显示课程列表

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666105605108-3c15e627-7dbe-467e-86fb-fdb65deff302.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666105676270-09aa7542-d4e0-4772-b5f9-29df4250fd24.png)

- 点击`去看看`, 显示课程详情

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666105706038-df278072-8742-494d-bbd1-7a91a4eab8fb.png)

### 1.2 接口

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666322582409-29645060-d6be-4744-88e3-37cbc40bd699.png)

#### 1.2.1 追加代码 `CourseApiController`控制类

```java
    @ApiOperation("根据课程分类 id 查询课程列表（分页）")
    @GetMapping("/{subjectId}/{page}/{limit}")
    public Result<Map<String, Object>> findPageCourse(
            @ApiParam(value = "课程一级分类 id", required = true)
            @PathVariable Long subjectId,
            @ApiParam(value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(value = "每页记录数", required = true)
            @PathVariable Long limit
    ) {
        Map<String, Object> map = courseService.findPage(subjectId, page, limit);
        return Result.ok(map);
    }

    @ApiOperation("根据课程 id 查询课程详情")
    @GetMapping("/getInfo/{courseId}")
    public Result<Map<String, Object>> getInfo(
            @ApiParam(value = "课程 id", required = true)
            @PathVariable Long courseId
    ) {
        Map<String, Object> map = courseService.getInfoById(courseId);
        return Result.ok(map);
    }
```



#### 1.2.2 服务接口

```java
    /**
     * 根据课程分类 id 查询课程列表（分页）
     *
     * @param subjectId 课程分类 id
     * @param page      当前页码
     * @param limit     每页记录数
     * @return {@link Map}<{@link String}, {@link Object}>
     */
    Map<String, Object> findPage(Long subjectId, Long page, Long limit);

    /**
     * 根据课程 id 查询课程详情
     *
     * @param courseId 课程 id
     * @return {@link Map}<{@link String}, {@link Object}>
     */
    Map<String, Object> getInfoById(Long courseId);
```



#### 1.2.3 服务实现类

```java
    @Override
    public Map<String, Object> findPage(Long subjectId, Long page, Long limit) {
        // 创建分页对象
        IPage<Course> coursePage = new Page<>(page, limit);
        // 创建条件对象
        LambdaQueryWrapper<Course> wrapper = new LambdaQueryWrapper();
        wrapper.eq(Course::getSubjectParentId, subjectId);
        // 分页查询
        IPage<Course> courseIPage = baseMapper.selectPage(coursePage, wrapper);


        // 每页数据集合
        List<Course> records = courseIPage.getRecords();
        records.stream().forEach(course -> {
            // 封装其他数据
            // 根据讲师 id 获取讲师对象
            Teacher teacher = teacherService.getById(course.getTeacherId());
            if (teacher != null) {
                course.getParam().put("teacherName", teacher.getName());
            }

            // 一级分类标题
            Subject subject = subjectService.getById(course.getSubjectParentId());
            if (subject != null) {
                course.getParam().put("subjectParentTitle", subject.getTitle());
            }

            // 二级分类标题
            Subject subjectTwo = subjectService.getById(course.getSubjectId());
            if (subjectTwo != null) {
                course.getParam().put("subjectTitle", subjectTwo.getTitle());
            }
        });

        // 总记录数
        long totalCount = courseIPage.getTotal();
        // 总页数
        long totalPage = courseIPage.getPages();
        // 当前页
        long currentPage = courseIPage.getCurrent();
        // 每页记录数
        long size = courseIPage.getSize();

        Map<String, Object> map = new HashMap<>();
        map.put("totalCount", totalCount);
        map.put("totalPage", totalPage);
        map.put("records", records);
        return map;
    }

    @Override
    public Map<String, Object> getInfoById(Long courseId) {
        Course course = baseMapper.selectById(courseId);
        if (course == null) {
            return null;
        }

        course.setViewCount(course.getViewCount() + 1);
        baseMapper.updateById(course);

        // 根据课程 id 查询课程详情
        CourseVo courseVo = baseMapper.selectCourseVoById(courseId);
        // 课程章节小节数据
        List<ChapterVo> chapterVoList = chapterService.getTreeList(courseId);
        // 课程描述信息
        CourseDescription courseDescription = courseDescriptionService.getById(courseId);
        // 查询所属讲师信息
        Teacher teacher = teacherService.getById(course.getTeacherId());

        // 创建 map 集合, 封装并返回数据
        Map<String, Object> map = new HashMap<>(2);
        map.put("courseVo", courseVo);
        map.put("chapterVoList", chapterVoList);
        map.put("description", null != courseDescription ? courseDescription.getDescription() : "");
        map.put("teacher", teacher);
        map.put("isBuy", false);
        return map;
    }
```



#### 1.2.4 `Mapper` 接口

```java
    /**
     * 根据课程 id 查询课程详情
     *
     * @param courseId 课程 id
     * @return {@link CourseVo}
     */
    CourseVo selectCourseVoById(Long courseId);
```



#### 1.2.5 `Mapper.xml`

```xml
    <select id="selectCourseVoById" resultType="com.atguigu.ggkt.vo.vod.CourseVo">
        SELECT c.id,
               c.title,
               c.lesson_num   AS lessonNum,
               c.price,
               c.cover,
               c.buy_count    AS buyCount,
               c.view_count   AS viewCount,
               c.status,
               c.publish_time AS publishTime,
               c.teacher_id   as teacherId,
               t.name         AS teacherName,
               s1.title       AS subjectParentTitle,
               s2.title       AS subjectTitle
        FROM course c
                 LEFT JOIN teacher t ON c.teacher_id = t.id
                 LEFT JOIN subject s1 ON c.subject_parent_id = s1.id
                 LEFT JOIN subject s2 ON c.subject_id = s2.id
        WHERE c.id = #{id}
    </select>
```



### 1.3 前端

#### 1.3.1 路由

```javascript
import vue from 'vue'
import VueRouter from 'vue-router'

// 1. 安装插件
vue.use(VueRouter);

// 2. 创建 router
const routes = [
  {
    path: '/',
    redirect: '/home'
  },
  {
    path: '/home',
    name: 'home',
    component: () => import('../views/home/Home')
  },
  {
    // 课程列表
    path: '/course/list/:subjectId',
    name: 'courseList',
    component: () => import('../views/course/List')
  },
  {
    // 课程详情
    path: '/course/detail/:courseId',
    name: 'courseDetail',
    component: () => import('../views/course/Detail')
  }
]

const router = new VueRouter({
  routes
})

export default router;
```



#### 1.3.2 页面

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666325735784-fa78279e-0eb4-473c-ad61-8a1a27523b95.png)

- `List.vue`

```vue
<template>
  <div>
    <van-image width="100%" height="200" src="https://cdn.uviewui.com/uview/swiper/1.jpg"/>
    <van-pull-refresh v-model="refreshing" @refresh="onRefresh">
      <!-- offset：滚动条与底部距离小于 offset 时触发load事件 默认300，因此要改小，否则首次进入一直触发  -->
      <van-list v-model="loading" :finished="finished" finished-text="没有更多了" offset="10" @load="onLoad">
        <van-card
          v-for="(item,index) in list" :key="index"
          :price="item.price"
          :title="item.title"
          :thumb="item.cover"
        >
          <template #tags>
            <van-tag round plain color="#ffe1e1" text-color="#ad0000">课时数：{{ item.lessonNum }}</van-tag>
            <br/>
            <van-tag round plain color="#ffe1e1" text-color="#ad0000">购买数：{{ item.buyCount }}</van-tag>
            <br/>
            <van-tag round plain color="#ffe1e1" text-color="#ad0000">访问量：{{ item.viewCount }}</van-tag>
          </template>
          <template #footer>
            <van-button size="mini" @click="info(item.id)">去看看</van-button>
          </template>
        </van-card>
      </van-list>
    </van-pull-refresh>
  </div>
</template>
<script>
import {findPage} from '@/api/course'

export default {
  name: "Course",
  data() {
    return {
      subjectParentId: 1,
      loading: false,
      finished: false,
      refreshing: false,
      pageNo: 1,
      pageSize: 5,
      pages: 1,
      list: []
    };
  },
  created() {
    this.subjectParentId = this.$route.params.subjectId;
  },
  methods: {
    onLoad() {
      this.fetchData();
    },
    onRefresh() {
      // 清空列表数据
      this.finished = false;
      this.pageNo = 1;
      // 重新加载数据
      // 将 loading 设置为 true，表示处于加载状态
      this.loading = true;
      this.fetchData();
    },
    fetchData() {
      findPage(this.subjectParentId, this.pageNo, this.pageSize).then(response => {
        console.log(response.data);
        if (this.refreshing) {
          this.list = [];
          this.refreshing = false;
        }

        this.list = response.data.records;
        this.pages = response.data.totalPage;
        this.loading = false;
        if (this.pageNo >= this.pages) {
          this.finished = true;
        }

        this.pageNo++;
      });
    },
    info(id) {
      this.$router.push({path: '/course/detail/' + id})
    }
  }
}
</script>
<style lang="scss" scoped>
.list {
  li {
    margin: 10px;
    padding-bottom: 5px;
    border-bottom: 1px solid #e5e5e5;

    h1 {
      font-size: 20px;
    }

    .list-box {
      display: flex;
      font-size: 14px;

      ul {
        flex: 1;
        margin: 0;

        li {
          margin: 0;
          border-bottom: none;
        }
      }

      p {
        margin: 0;
        width: 50px;
        align-items: center;
        align-self: flex-end;
      }
    }
  }
}
</style>
```

- `Detail.vue`

```vue
<template>
  <div>
    <van-image width="100%" height="200" :src="courseVo.cover"/>
    <van-row>
      <van-col span="8">
        <div class="course_count">
          <h1>购买数</h1>
          <p>{{ courseVo.buyCount }}</p>
        </div>
      </van-col>
      <van-col span="8">
        <div class="course_count">
          <h1>课时数</h1>
          <p>{{ courseVo.lessonNum }}</p>
        </div>
      </van-col>
      <van-col span="8">
        <div class="course_count">
          <h1>浏览数</h1>
          <p>{{ courseVo.viewCount }}</p>
        </div>
      </van-col>
    </van-row>
    <h1 class="van-ellipsis course_title">{{ courseVo.title }}</h1>
    <div class="course_teacher_price_box">
      <div class="course_teacher_price">
        <div class="course_price">价格：</div>
        <div class="course_price_number">￥{{ courseVo.price }}</div>
      </div>
      <div>
        <van-button @click="see()" v-if="isBuy || courseVo.price == '0.00'" plain type="warning" size="mini">立即观看
        </van-button>
        <van-button @click="buy" v-else plain type="warning" size="mini">立即购买</van-button>
      </div>
    </div>
    <div class="course_teacher_price_box">
      <div class="course_teacher_box">
        <div class="course_teacher">主讲： {{ teacher.name }}</div>
        <van-image :src="teacher.avatar" round width="50px" height="50px"/>
      </div>
    </div>
    <div class="course_contents">
      <div class="course_title_font">课程详情</div>
      <van-divider :style="{ margin: '5px 0 ' }"/>
      <div class="course_content" v-html="description">
      </div>
      <div class="course_title_font">课程大纲</div>
      <div class="gap"></div>
      <van-collapse v-model="activeNames">
        <van-collapse-item :title="item.title" :name="item.id" v-for="item in chapterVoList" :key="item.id">
          <ul class="course_chapter_list" v-for="child in item.children" :key="child.id">
            <h2>{{ child.title }}</h2>
            <p v-if="child.isFree == 1">
              <van-button @click="play(child)" type="warning" size="mini" plain>免费观看</van-button>
            </p>
            <p v-else>
              <van-button @click="play(child)" type="warning" size="mini" plain>观看</van-button>
            </p>
          </ul>
        </van-collapse-item>
      </van-collapse>
    </div>
    <van-loading vertical="true" v-show="loading">加载中...</van-loading>
  </div>
</template>

<script>
import {getInfo} from '@/api/course'

export default {
  data() {
    return {
      loading: false,
      courseId: null,
      courseVo: {},
      description: '',
      teacher: {},
      chapterVoList: [],
      isBuy: false,
      activeNames: ["1"]
    };
  },
  created() {
    this.courseId = this.$route.params.courseId;
    this.fetchData();
  },
  methods: {
    fetchData() {
      this.loading = true;
      getInfo(this.courseId).then(response => {
        console.log(response.data);

        this.courseVo = response.data.courseVo;
        this.description = response.data.description;
        this.isBuy = response.data.isBuy;
        this.chapterVoList = response.data.chapterVoList;
        this.teacher = response.data.teacher;

        this.loading = false;
      });
    },
    buy() {
      this.$router.push({path: '/trade/' + this.courseId})
    },
    play(video) {

    },
    see() {
      this.$router.push({path: '/play/' + this.courseId + '/0'})
    }
  }
};
</script>
<style lang="scss" scoped>
.gap {
  height: 10px;
}

::v-deep.van-image {
  display: block;
}

.course_count {
  background-color: #82848a;
  color: white;
  padding: 5px;
  text-align: center;
  border-right: 1px solid #939393;

  h1 {
    font-size: 14px;
    margin: 0;
  }

  p {
    margin: 0;
    font-size: 16px;
  }
}

.course_title {
  font-size: 20px;
  margin: 10px;
}

.course_teacher_price_box {
  margin: 10px;
  display: flex;
  justify-content: space-between;
  align-items: center;

  .course_teacher_price {
    display: flex;
    font-size: 14px;
    align-items: center;

    .course_price_number {
      color: red;
      font-size: 18px;
      font-weight: bold;
    }

    .course_teacher {
      margin-left: 20px;
    }
  }

  .course_teacher_box {
    display: flex;
    justify-content: center;
    align-items: center;

    .course_teacher {
      margin-right: 20px;
    }
  }
}

.course_contents {
  margin: 10px;

  .course_title_font {
    color: #68cb9b;
    font-weight: bold;
  }

  .course_content {
    margin-bottom: 20px;
  }
}

.course_chapter_list {
  display: flex;
  justify-content: space-between;
  align-items: center;

  h2 {
    font-size: 14px;
  }

  p {
    margin: 0;
  }
}
</style>
```



#### 1.3.3 使用  `Vant` 移动组件库

- 安装: `npm i vant@2.12.48`
- 配置:

```javascript
import Vue from 'vue'
import App from './App.vue'
import router from "./router";
import store from './store'

// 1. 引入 vant 组件
import Vant from 'vant';
// 2. 引入组件样式
import 'vant/lib/index.css';
// 3. 注册组件
Vue.use(Vant);

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
  router,
  store,
}).$mount('#app')
```



#### 1.3.4 使用 `scss`

- 安装 `npm i --save-dev sass@1.32.7 sass-loader@12.0.0`



#### 1.3.5 网络请求 `axios`

- 安装 `npm i axios@0.18.0`
- 配置

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666326028708-a43bdd34-61f7-4410-86af-21e98a578173.png)

```javascript
import axios from 'axios'
import store from '../store'

export function request(config) {
  // 1. 创建 axios 的实例
  const instance = axios.create({
    baseURL: 'https://www.th668.top',
    // 请求超时时间
    timeout: 30000
  });

  // 2. axios 的拦截器
  // 配置请求和响应拦截
  instance.interceptors.request.use(config => {
    // 1. 比如 config 中一些信息不符合服务器的要求
    // 2. 比如每次发送网络请求时, 都希望在界面中显示一个请求的图标
    console.log('来到了 request 拦截 success 中')

    //获取 localStorage 里面的 token 值
    let token = window.localStorage.getItem('token') || '';
    if (token !== '') {
      //把 token 值放到 header 里面
      config.headers['token'] = token; // 'eyJhbGciOiJIUzUxMiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAKtWKi5NUrJSCjAK0A0Ndg1S0lFKrShQsjI0MzY3MTQxMTbWUSotTi3yTAGKQZh-ibmpQB1KtQARkjypPAAAAA.B6dziXWxcc2mIYYaDQnXB1t0IHwQK-GwWNFsAQ0Z7CbCBVb11uoNjojWYotC8YEdlVW9Ahtq99LWtz1_Wbhhlw';//cookie.get('guli_token');
    }

    return config;
  }, err => {
    console.log('来到了 request 拦截 failure 中')
    return Promise.reject(err);
  })

  // 响应拦截
  instance.interceptors.response.use(res => {
    console.log('来到了 response 拦截 success 中')

    if (res.data.code === 208) {
      // 微信状态码
      // 替换# 后台获取不到#后面的参数
      let url = window.location.href.replace('#', 'guiguketan')
      window.location = store.getters.wechatPath + url;
    } else {
      if (res.data.code === 20000) {
        // 成功
        return res.data
      } else {
        // 错误
        console.log("response.data:" + JSON.stringify(res.data))
        alert(res.data.message || 'error')
        return Promise.reject(res)
      }
    }
  }, err => {
    console.log('来到了 response 拦截 failure 中')
    return Promise.reject(err);
  })

  // 3. 发送真正的网络请求
  return instance(config);
}
```



#### 1.3.6 `store`

```javascript
import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    // 微信接口
    wechatPath: "http://175.178.174.83/api/wechat/redirect/authorize?returnUrl="
  },
  getters: {
    wechatPath: state => state.wechatPath
  },
  mutations: {},
  actions: {},
  modules: {}
})
```

####  

#### 1.3.7 `API`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666326074664-e11c5296-3ae8-4de2-be5f-2f46e278209f.png)

```javascript
import {request} from '@/utils/request'

const api_name = '/api/vod/course'

// 课程分页列表
export function findPage(subjectParentId, pageNo, pageSize) {
  return request({
    url: `${api_name}/${subjectParentId}/${pageNo}/${pageSize}`,
    method: 'get'
  })
}

// 课程详情
export function getInfo(courseId) {
  return request({
    url: `${api_name}/getInfo/${courseId}`,
    method: 'get'
  })
}
```



#### 1.3.8 `App.vue` 使用 `store`

```vue
<template>
  <div id="app">
    <!-- 路由出口 -->
    <!-- 路由匹配到的组件将渲染在这里 -->
    <router-view></router-view>
  </div>
</template>

<script>
import {mapGetters} from 'vuex'

export default {
  name: 'App',
  created() {
    this.wechatLogin();
  },
  methods: {
    ...mapGetters({
      wechatPath: 'wechatPath'
    }),
    wechatLogin() {
      // 处理微信授权登录
      let token = this.getQueryString('token') || '';
      if (token !== '') {
        window.localStorage.setItem('token', token);
      }

      // 所有页面都必须登录，两次调整登录, 这里与接口返回 208 状态
      token = window.localStorage.getItem('token') || '';
      if (token === '') {
        const url = window.location.href.replace('#', 'guiguketan')
        window.location = this.wechatPath + url;
      }

      console.log('token2: ' + window.localStorage.getItem('token'));
    },
    getQueryString(paramName) {
      if (window.location.href.indexOf('?') === -1) return '';

      let searchString = window.location.href.split('?')[1];
      let i, val, params = searchString.split("&");

      for (i = 0; i < params.length; i++) {
        val = params[i].split("=");
        if (val[0] === paramName) {
          return val[1];
        }
      }

      return '';
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
```



## 2 点播视频播放

- 腾讯云视频点播示例

```html
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no">
        <title>腾讯云视频点播示例</title>
        <!-- 引入播放器 css 文件 -->
        <link href="https://cloudcache.tencent-cloud.com/open/qcloud/video/tcplayer/tcplayer.css" rel="stylesheet">
        <!-- 如需在IE8、9浏览器中初始化播放器，浏览器需支持Flash并在页面中引入 -->
        <!--[if lt IE 9]>
        <script src="https://cloudcache.tencent-cloud.com/open/qcloud/video/tcplayer/ie8/videojs-ie8.js"></script>
        <![endif]-->
        <!-- 如果需要在 Chrome 和 Firefox 等现代浏览器中通过 H5 播放 HLS 格式的视频，需要在 tcplayer.v4.1.min.js 之前引入 hls.min.0.13.2m.js -->
        <script src="https://imgcache.qq.com/open/qcloud/video/tcplayer/libs/hls.min.0.13.2m.js"></script>
        <!-- 引入播放器 js 文件 -->
        <script src="https://imgcache.qq.com/open/qcloud/video/tcplayer/tcplayer.v4.1.min.js"></script>
        <!-- 示例 CSS 样式可自行删除 -->
    </head>
    <body>
        <!-- 设置播放器容器 -->
        <video id="player-container-id" preload="auto" width="600" height="400" playsinline webkit-playsinline x5-playsinline></video>
        <!--
        注意事项：
        * 播放器容器必须为 video 标签
        * player-container-id 为播放器容器的ID，可自行设置
        * 播放器区域的尺寸请按需设置，建议通过 css 进行设置，通过css可实现容器自适应等效果
        * playsinline webkit-playsinline x5-playsinline 这几个属性是为了在标准移动端浏览器不劫持视频播放的情况下实现行内播放，此处仅作示例，请按需使用
        -->
        <script>
            var player = TCPlayer("player-container-id", { /**player-container-id 为播放器容器ID，必须与html中一致*/
                fileID: "387702307413810418", /**请传入需要播放的视频fileID 必须 */
                appID: "1301043802", /**请传入点播账号的子应用appID 必须 */
                psign: ""
                /**其他参数请在开发文档中查看 */
                });
        </script>
    </body>
</html>
```

### 2.1 目标

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666337272499-4dfbf1ec-e486-42ff-a955-287a250ea8ee.png)



### 2.2 接口

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666342103487-871c5ba3-36b3-4834-99c7-d6c77fbed0be.png)

#### 2.2.1 新建 `VodApiController` 控制类

```java
package com.atguigu.ggkt.vod.api;

import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vod.service.VodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 腾讯视频点播 控制类
 * 
 * @author 陈江林
 * @date 2022/10/21 16:29
 */
@Api(tags = "腾讯视频点播")
@RestController
@RequestMapping("/api/vod")
public class VodApiController {

    @Autowired
    private VodService vodService;

    @GetMapping("/getPlayAuth/{videoId}")
    public Result<Map<String, Object>> getPlayAuth(
            @ApiParam(value = "小节id", required = true)
            @PathVariable Long videoId) {
        return Result.ok(vodService.getPlayAuth(videoId));
    }

}
```



#### 2.2.2 服务接口

```java
    /**
     * 根据 id 获取对应的视频
     *
     * @param videoId  视频id
     * @return {@link Map}<{@link String}, {@link Object}>
     */
    Map<String, Object> getPlayAuth(Long videoId);
```



#### 2.2.3 服务实现类

```java
    @Value("${tencent.video.appid}")
    private String appid;

	@Override
    public Map<String, Object> getPlayAuth(Long videoId) {
        // 根据小节 id 获取小节对象， 获取腾讯云视频ID
        Video video = videoService.getById(videoId);
        if (video == null) {
            throw new GgktException(20001, "小节信息不存在");
        }

        Map<String, Object> map = new HashMap<>();
        map.put("videoSourceId", video.getVideoSourceId());
        map.put("appid", appid);
        return map;
    }
```



#### 2.2.4 `application.yml` 配置

```yaml
tencent:
	# 腾讯云点播
  video:
    appid: 1301043802
```



### 2.3 前端

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666342950535-6edd23d1-5046-465d-8ab9-0d3425e9a3bf.png)

#### 2.3.1 `API` 新建 `vod.js`

```javascript
import {request} from '@/utils/request'
const api_name = '/api/vod'

export default {
  // 获取播放凭证
  getPlayAuth(courseId, videoId) {
    return request({
      url: `${api_name}/getPlayAuth/${videoId}`,
      method: 'get'
    })
  }
}
```



#### 2.3.2 修改 `Detail.vue` 中 `play` 方法

```javascript
    // 视频播放
    play(video) {
      const videoId = video.id;
      this.$router.push({path: '/course/play/' + this.courseId + "/" + videoId})
    },
```



#### 2.3.3 新建页面 `play.vue`

```vue
<template>
  <div>
    <video id="player-container-id" preload="auto" width="600" height="400" playsinline webkit-playsinline x5-playsinline></video>
    <h1 class="van-ellipsis course_title">{{ courseVo.title }}</h1>

    <div class="course_teacher_price_box">
      <div class="course_teacher_price">
        <div class="course_price">价格：</div>
        <div class="course_price_number">￥{{ courseVo.price }}</div>
        <div class="course_teacher">主讲： {{ courseVo.teacherName }}</div>
      </div>
      <div>
        <van-button @click="getPlayAuth('0')" v-if="isBuy || courseVo.price == '0.00'" plain type="warning" size="mini">立即观看</van-button>
        <van-button @click="buy" v-else plain type="warning" size="mini">立即购买</van-button>
      </div>
    </div>

    <div class="course_contents">
      <div class="course_title_font">课程大纲</div>
      <div class="gap"></div>
      <van-collapse v-model="activeNames">
        <van-collapse-item :title="item.title" :name="item.id" v-for="item in chapterVoList" :key="item.id">
          <ul class="course_chapter_list" v-for="child in item.children" :key="child.id">
            <h2 :style="activeVideoId == child.id ? 'color:blue' : ''">{{child.title}}</h2>
            <p v-if="child.isFree == 1">
              <van-button @click="see(child)" type="warning" size="mini" plain>免费观看</van-button>
            </p>
            <p v-else>
              <van-button @click="see(child)" type="warning" size="mini" plain>观看</van-button>
            </p>
          </ul>
        </van-collapse-item>
      </van-collapse>
    </div>

    <van-loading vertical="true" v-show="loading">加载中...</van-loading>
  </div>
</template>

<script>
import {getInfo} from '@/api/course'
import vodApi from '@/api/vod'

// import videoVisitorApi from '@/api/videoVisitor'
export default {
  data() {
    return {
      loading: false,

      courseId: null,
      videoId: null,

      courseVo: {},
      description: '',
      chapterVoList: [],
      isBuy: false,
      // firstVideo: null,

      activeNames: ["1"],
      activeVideoId: 0, //记录当前正在播放的视频
      player: null
    };
  },

  created() {
    this.courseId = this.$route.params.courseId;
    this.videoId = this.$route.params.videoId || '0';

    this.fetchData();
    this.getPlayAuth(this.videoId);
  },

  methods: {
    fetchData() {
      this.loading = true;
      getInfo(this.courseId).then(response => {
        console.log(response.data);

        this.courseVo = response.data.courseVo;
        this.description = response.data.description;
        this.isBuy = response.data.isBuy;
        this.chapterVoList = response.data.chapterVoList;

        //获取第一个播放视频id
        // this.firstVideo = this.chapterVoList[0].children[0]
        // if(this.videoSourceId == '0') {
        //     this.see(this.firstVideo);
        // }
        this.loading = false;
      });
    },

    see(video) {
      let videoId = video.id;
      let isFree = video.isFree;
      //if(isFree === 1 || this.isBuy || this.courseVo.price == '0.00') {
      this.getPlayAuth(videoId);
      // } else {
      //     if (window.confirm("购买了才可以观看, 是否继续？")) {
      //         this.buy()
      //     }
      // }
    },

    buy() {
      this.$router.push({ path: '/trade/'+this.courseId })
    },

    getPlayAuth(videoId) {
      if (this.player != null) {
        // 是销毁之前的视频，不销毁的话，它会一直存在
        this.player.dispose();
      }

      vodApi.getPlayAuth(this.courseId, videoId).then(response => {
        console.log(response.data);
        this.play(response.data);

        //展开章节
        this.activeNames = [response.data.chapterId]
        //选中播放视频
        this.activeVideoId = response.data.videoId
      })
    },
    //视频播放
    play(data) {
      var player = TCPlayer("player-container-id", { /**player-container-id 为播放器容器ID，必须与html中一致*/
        fileID: data.videoSourceId, /**请传入需要播放的视频fileID 必须 */
        appID: data.appid, /**请传入点播账号的子应用appID 必须 */
        psign: ""
        /**其他参数请在开发文档中查看 */
      });
    }
  }
};
</script>

<style lang="scss" scoped>
.gap {
  height: 10px;
}

::v-deep.van-image {
  display: block;
}

.course_count {
  background-color: #82848a;
  color: white;
  padding: 5px;
  text-align: center;
  border-right: 1px solid #939393;

  h1 {
    font-size: 14px;
    margin: 0;
  }

  p {
    margin: 0;
    font-size: 16px;
  }
}

.course_title {
  font-size: 20px;
  margin: 10px;
}

.course_teacher_price_box {
  margin: 10px;
  display: flex;
  justify-content: space-between;
  align-items: center;

  .course_teacher_price {
    display: flex;
    font-size: 14px;
    align-items: center;

    .course_price_number {
      color: red;
      font-size: 18px;
      font-weight: bold;
    }

    .course_teacher {
      margin-left: 20px;
    }
  }
}

.course_contents {
  margin: 10px;

  .course_title_font {
    color: #68cb9b;
    font-weight: bold;
  }

  .course_content {
    margin-bottom: 20px;
  }
}

.course_chapter_list {
  display: flex;
  justify-content: space-between;
  align-items: center;

  h2 {
    font-size: 14px;
  }

  p {
    margin: 0;
  }
}
</style>
```



#### 2.3.4 对应路由

```javascript
,
  {
    // 视频播放
    path: '/course/play/:courseId/:videoId',
    name: 'coursePlay',
    component: () => import('../views/course/Play')
  }
```



#### 2.3.5 引入 `js` `css`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666342733408-01860428-e1c3-4292-8329-1a0939146f20.png)

```html
    <!-- 引入播放器 css 文件 -->
    <link href="https://cloudcache.tencent-cloud.com/open/qcloud/video/tcplayer/tcplayer.css" rel="stylesheet">
    <!-- 如需在IE8、9浏览器中初始化播放器，浏览器需支持Flash并在页面中引入 -->
    <!--[if lt IE 9]>
    <script src="https://cloudcache.tencent-cloud.com/open/qcloud/video/tcplayer/ie8/videojs-ie8.js"></script>
    <![endif]-->
    <!-- 如果需要在 Chrome 和 Firefox 等现代浏览器中通过 H5 播放 HLS 格式的视频，需要在 tcplayer.v4.1.min.js 之前引入 hls.min.0.13.2m.js -->
    <script src="https://imgcache.qq.com/open/qcloud/video/tcplayer/libs/hls.min.0.13.2m.js"></script>
    <!-- 引入播放器 js 文件 -->
    <script src="https://imgcache.qq.com/open/qcloud/video/tcplayer/tcplayer.v4.1.min.js"></script>
```





## 3 付费观看点播课程

### 3.1 目标

1. 课程详情

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666343473139-2955df54-d7d6-4916-90ac-7d8c1a89af9b.png)

1. 点击立即购买

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666343503366-c33a8776-14a6-4187-8906-24e54df6b0fa.png)

1. 点击确认下单, 生成课程订单信息





#### 3.1.1 思路

1. 微信授权成功后, 会返回 `token` 字符串（`id`和`nickname`）
2. 把返回的 `token` 放到 `localStorage`
3. 每次发送`axios`请求都会将 `token` 放到请求头中传递



### 3.2 接口

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666355680442-fca1502d-c7b5-43e1-9aa1-62f95eeeca17.png)

#### 3.2.1 新建 `OrderInfoApiController` 控制类

```java
@RestController
@RequestMapping("api/order/orderInfo")
public class OrderInfoApiController {

    @Autowired
    private OrderInfoService orderInfoService;

    @ApiOperation("新增点播课程订单")
    @PostMapping("submitOrder")
    public Result submitOrder(@RequestBody OrderFormVo orderFormVo, HttpServletRequest request) {
        //返回订单id
        Long orderId = orderInfoService.submitOrder(orderFormVo);
        return Result.ok(orderId);
    }
}	
```



#### 3.2.2 服务接口

```java
    /**
     * 新增点播课程订单
     *
     * @param orderFormVo
     * @return {@link Long} 返回订单 id
     */
    Long submitOrder(OrderFormVo orderFormVo);
```



#### 3.2.3 服务实现

```java
    @Override
    public Long submitOrder(OrderFormVo orderFormVo) {
        // 获取生成订单条件值
        if (orderFormVo == null) {
            throw new GgktException(20001, "订单条件不存在");
        }

        Long courseId = orderFormVo.getCourseId();
        Long couponId = orderFormVo.getCouponId();


        // 获取当前用户的 id
        Long userId = AuthContextHolder.getUserId();
        // 判断当前用户, 针对当前课程是否已经生成订单
        // 根据课程 id, 用户 id 查询订单
        LambdaQueryWrapper<OrderDetail> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OrderDetail::getCourseId, courseId);
        queryWrapper.eq(OrderDetail::getUserId, userId);
        OrderDetail orderDetailExist = orderDetailService.getOne(queryWrapper);
        if (orderDetailExist != null) {
            // 如果订单已存在，则直接返回订单 id
            return orderDetailExist.getId();
        }

        // 根据课程 id 查询课程信息
        Course course = courseFeignClient.getById(courseId);
        if (course == null) {
            throw new GgktException(20001, "课程不存在");
        }

        // 根据用户 id 查询用户信息
        Result<UserInfo> result = userInfoFeignClient.getById(userId);
        if (result.getMessage().equals(Result.FAILED)) {
            throw new GgktException(result.getCode(), result.getMessage());
        }

        UserInfo userInfo = result.getData();
        if (userInfo == null) {
            throw new GgktException(20001, "用户不存在");
        }

        // 优惠券金额
        BigDecimal couponReduce = new BigDecimal(0);
        // 是否拥有优惠券
        if (null != couponId) {
            // 根据优惠券 id 查询优惠券信息
            CouponInfo couponInfo = couponInfoFeignClient.getById(couponId);
            couponReduce = couponInfo.getAmount();
        }

        // 封装订单生成需要的数据到对象, 完成添加订单
        // - 封装数据到 OrderInfo 对象中, 添加订单基本信息
        // 创建订单对象
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setUserId(userId);
        orderInfo.setNickName(userInfo.getNickName());
        orderInfo.setPhone(userInfo.getPhone());
        orderInfo.setProvince(userInfo.getProvince());
        orderInfo.setOriginAmount(course.getPrice());
        orderInfo.setCouponReduce(couponReduce);
        // 订单总价格 - 优惠券减免
        orderInfo.setFinalAmount(orderInfo.getOriginAmount().subtract(orderInfo.getCouponReduce()));
        // 流水号
        orderInfo.setOutTradeNo(OrderNoUtils.getOrderNo());
        orderInfo.setTradeBody(course.getTitle());
        orderInfo.setOrderStatus("0");
        baseMapper.insert(orderInfo);

        // - 封装数据到 OrderDetail 对象中, 添加订单详情信息表
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(orderInfo.getId());
        orderDetail.setUserId(userId);
        orderDetail.setCourseId(courseId);
        orderDetail.setCourseName(course.getTitle());
        orderDetail.setCover(course.getCover());
        orderDetail.setOriginAmount(course.getPrice());
        orderDetail.setCouponReduce(new BigDecimal(0));
        orderDetail.setFinalAmount(orderDetail.getOriginAmount().subtract(orderDetail.getCouponReduce()));
        orderDetailService.save(orderDetail);

        // 更新优惠券状态
        if (null != orderFormVo.getCouponUseId()) {
            couponInfoFeignClient.updateCouponInfoUseStatus(orderFormVo.getCouponUseId(), orderInfo.getId());
        }

        // 返回订单 id
        return orderInfo.getId();
    }
```



#### 3.2.4 新建 `OrderNoUtils`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666357654079-9915f0b4-a7e4-49c3-9f49-9ab0d89f0869.png)

```java
package com.atguigu.ggkt.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 订单工具类
 *
 * @author 陈江林
 * @date 2022/10/21 21:07
 */
public class OrderNoUtils {

    /**
     * 获取订单号
     *
     * @return
     */
    public static String getOrderNo() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate = sdf.format(new Date());
        String result = "";
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            result += random.nextInt(10);
        }
        
        return newDate + result;
    }

}
```



#### 3.2.5 引入依赖

```xml
    <dependencies>
        <dependency>
            <groupId>com.atguigu</groupId>
            <artifactId>service_course_client</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>
        <dependency>
            <groupId>com.atguigu</groupId>
            <artifactId>service_user_client</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>
        <dependency>
            <groupId>com.atguigu</groupId>
            <artifactId>service_activity_client</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>
    </dependencies>
```



#### 3.2.6 主启动类添加注解

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666948587255-7e481f03-722f-45b5-ab76-071505fa0c38.png)

```java
@EnableFeignClients(basePackages = "com.atguigu")
```



### 3.3 远程接口

#### 3.3.1 根据 `ID` 查询课程

- `CourseFeignClient`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666348584530-a2d9fda9-24a2-4512-9780-5f84e43899e8.png)

```java
    /**
     * 根据ID查询课程
     *
     * @param courseId 课程 id
     * @return {@link Course}
     */
    @GetMapping("/api/vod/course/inner/getById/{courseId}")
    Course getById(@PathVariable Long courseId);
```

- `CourseApiController`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666348464090-3d3b733f-1cb1-411a-8205-7f33d15d66e9.png)

```java
    @ApiOperation("根据ID查询课程")
    @GetMapping("/inner/getById/{courseId}")
    public Course getById(
            @ApiParam(value = "课程ID", required = true)
            @PathVariable Long courseId){
        return courseService.getById(courseId);
    }
```





#### 3.3.2 优惠券远程接口

**远程接口**

- 新建 `service_activity_client` 模块

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666349176426-03cd59de-f758-4311-9a5e-e1905627b2ef.png)

- `pom.xml`

```xml
	<build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <!-- 取消查找本项目下的Main方法：为了解决Unable to find main class的问题 -->
                    <mainClass>none</mainClass>
                    <!-- 为了解决依赖模块找不到此模块中的类或属性 -->
                    <classifier>execute</classifier>
                </configuration>
                <executions>
                    <execution>
                        <goals>
                            <goal>repackage</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
```

- 新建 `CouponInfoFeignClient`接口类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666349469593-ea7702ca-0ae7-4a77-8dfb-e70f48050d78.png)

```java
package com.atguigu.ggkt.client.activity;

import com.atguigu.ggkt.model.activity.CouponInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 陈江林
 * @date 2022/10/21 18:47
 */
@FeignClient(value = "service-activity")
public interface CouponInfoFeignClient {

    /**
     * 获取优惠券
     *
     * @param couponId 优惠券 id
     * @return {@link CouponInfo}
     */
    @GetMapping(value = "/api/activity/couponInfo/inner/getById/{couponId}")
    CouponInfo getById(@PathVariable("couponId") Long couponId);

    /**
     * 更新优惠券使用状态
     *
     * @param couponUseId 优惠券使用 id
     * @param orderId     订单 id
     * @return {@link Boolean}
     */
    @GetMapping(value = "/api/activity/couponInfo/inner/updateCouponInfoUseStatus/{couponUseId}/{orderId}")
    Boolean updateCouponInfoUseStatus(@PathVariable("couponUseId") Long couponUseId, @PathVariable("orderId") Long orderId);

}
```



**对应接口**

- 新建 `CouponInfoApiController`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666348812757-72f9c5d4-92d7-458d-a565-ca102fa2dcc7.png)

```java
package com.atguigu.ggkt.activity.api;

import com.atguigu.ggkt.activity.service.CouponInfoService;
import com.atguigu.ggkt.model.activity.CouponInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 优惠券 控制类
 *
 * @author 陈江林
 * @date 2022/10/21 18:39
 */
@Api(tags = "优惠券接口")
@RestController
@RequestMapping("/api/activity/couponInfo")
public class CouponInfoApiController {

    @Autowired
    private CouponInfoService couponInfoService;

    @ApiOperation(value = "根据 id 获取优惠券对象")
    @GetMapping(value = "/inner/getById/{couponId}")
    public CouponInfo getById(@PathVariable("couponId") Long couponId) {
        return couponInfoService.getById(couponId);
    }

    @ApiOperation(value = "更新优惠券使用状态")
    @GetMapping(value = "/inner/updateCouponInfoUseStatus/{couponUseId}/{orderId}")
    public Boolean updateCouponInfoUseStatus(
            @PathVariable("couponUseId") Long couponUseId, @PathVariable("orderId") Long orderId
    ) {
        couponInfoService.updateCouponInfoUseStatus(couponUseId, orderId);
        return true;
    }

}
```

- 服务接口

```java
    /**
     * 更新优惠券使用状态
     *
     * @param couponUseId 优惠券使用id
     * @param orderId     订单id
     */
    void updateCouponInfoUseStatus(Long couponUseId, Long orderId);
```

- 服务实现

```java
    @Override
    public void updateCouponInfoUseStatus(Long couponUseId, Long orderId) {
        CouponUse couponUse = new CouponUse();
        couponUse.setId(couponUseId);
        couponUse.setOrderId(orderId);
        couponUse.setCouponStatus("1");
        couponUse.setUsingTime(new Date());
        couponUseService.updateById(couponUse);
    }
```



### 3.4 `token` 获取当前用户 `id`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666352591834-8f68cd05-6493-4d61-a796-23741a9b987f.png)

#### 3.4.1 添加依赖

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666350447489-269da5a7-5b69-4003-9df8-51f75328ecbe.png)

```xml
<!-- redis -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>

<!-- spring2.X集成redis所需common-pool2-->
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-pool2</artifactId>
    <version>2.6.0</version>
</dependency>
```



#### 3.4.2 新建 `LoginWebMvcConfigurerImpl`

```java
package com.atguigu.ggkt.util;

import com.atguigu.ggkt.interceptor.UserLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Spring Mvc 配置类
 *
 * @author 陈江林
 * @date 2022/10/21 19:12
 */
@Configuration
@EnableWebMvc
public class LoginWebMvcConfigurerImpl implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加自定义拦截器, 设置拦截路径
        registry.addInterceptor(new UserLoginInterceptor())
                .addPathPatterns("/api/**");
    }

}
```



#### 3.4.3 新建 `UserLoginInterceptor` 拦截器

```java
package com.atguigu.ggkt.interceptor;

import com.atguigu.ggkt.util.AuthContextHolder;
import com.atguigu.ggkt.util.JwtHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 陈江林
 * @date 2022/10/21 19:16
 */
@Slf4j
public class UserLoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        log.info("当前用户token：" + token);
        if (StringUtils.isEmpty(token)) {
            AuthContextHolder.setUserId(1L);
            // throw new GgktException(208, "未登录");
        } else {
            Long userId = JwtHelper.getUserId(token);
            log.info("当前用户：" + userId);
            if (StringUtils.isEmpty(userId)) {
                AuthContextHolder.setUserId(1L);
                // throw new GgktException(208, "未登录");
            } else {
                AuthContextHolder.setUserId(userId);
            }
        }

        return true;
    }

}
```



#### 3.4.4 新建 `AuthContextHolder`

```java
package com.atguigu.ggkt.util;

/**
 * 获取登录用户信息类
 *
 * @author 陈江林
 * @date 2022/10/21 19:23
 */
public class AuthContextHolder {

    /**
     * 后台管理用户id
     */
    private static ThreadLocal<Long> adminId = new ThreadLocal<>();

    /**
     * 会员用户id
     */
    private static ThreadLocal<Long> userId = new ThreadLocal<>();

    public static Long getAdminId() {
        return adminId.get();
    }

    public static void setAdminId(Long _adminId) {
        adminId.set(_adminId);
    }

    public static Long getUserId() {
        return userId.get();
    }

    public static void setUserId(Long _userId) {
        userId.set(_userId);
    }

}
```



#### 3.4.5 前端实现 <已完成>

```javascript
	// 配置请求和响应拦截
  instance.interceptors.request.use(config => {
    //获取 localStorage 里面的 token 值
    let token = window.localStorage.getItem('token') || '';
    if (token !== '') {
      //把 token 值放到 header 里面
      config.headers['token'] = token;
    }

    return config;
  }, err => {
    return Promise.reject(err);
  })
```



## 4 微信支付

### 4.1 接口文档

- `https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=7_1`



### 4.2 公众号配置

#### 4.2.1 绑定域名

- 注意: 测试号不支持支付功能, 需要使用正式号

**填写** `**JS**` **接口安全域名**

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666358710524-3d4cc108-6cd9-4c2e-9242-7e86f70c4689.png)



#### 4.2.2 商户平台配置支付目录

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666358873930-0520a48d-42c8-4a8a-9796-c8cc6b8c8bd0.png)



### 4.3 创建订单支付接口

#### 4.3.1 新建 `WXPayController`

```java
package com.atguigu.ggkt.order.api;

import com.atguigu.ggkt.order.service.WXPayService;
import com.atguigu.ggkt.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 微信支付接口 控制类
 *
 * @author 陈江林
 * @date 2022/10/21 21:30
 */
@Api(tags = "微信支付接口")
@RestController
@RequestMapping("/api/order/wxPay")
public class WXPayController {

    @Autowired
    private WXPayService wxPayService;

    @ApiOperation(value = "下单 小程序支付")
    @GetMapping("/createJsapi/{orderNo}")
    public Result<Map<String, Object>> createJsapi(
            @ApiParam(name = "orderNo", value = "订单No", required = true)
            @PathVariable("orderNo") String orderNo) {
        return Result.ok(wxPayService.createJsapi(orderNo));
    }

}
```



#### 4.3.2 新建服务接口

```java
package com.atguigu.ggkt.order.service;

import java.util.Map;

/**
 * 微信支付接口 接口类
 *
 * @author 陈江林
 * @date 2022/10/21 21:31
 */
public interface WXPayService {

    /**
     * 微信支付
     *
     * @param orderNo 订单号
     * @return {@link Map}<{@link String}, {@link Object}>
     */
    Map<String, Object> createJsapi(String orderNo);

}
```



#### 4.3.3 新建服务实现

```java
package com.atguigu.ggkt.order.service.impl;

import com.atguigu.ggkt.exception.GgktException;
import com.atguigu.ggkt.order.service.WXPayService;
import com.atguigu.ggkt.util.HttpClientUtils;
import com.github.wxpay.sdk.WXPayUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 微信支付接口 接口实现类
 *
 * @author 陈江林
 * @date 2022/10/21 21:31
 */
@Slf4j
@Service
public class WXPayServiceImpl implements WXPayService {

    @Override
    public Map<String, Object> createJsapi(String orderNo) {
        // 封装微信支付需要参数, 使用 map 集合
        Map<String, String> paramMap = new HashMap<>( );
        // 设置参数

        // 正式服务号 id
        paramMap.put("appid", "wxf913bfa3a2c7eeeb");
        // 服务号的商户号
        paramMap.put("mch_id", "1481962542");
        // 使用微信提供的工具类生成 32 位随机字符串
        paramMap.put("nonce_str", WXPayUtil.generateNonceStr());
        // 微信弹框
        paramMap.put("body", "test");
        paramMap.put("out_trade_no", orderNo);
        // 支付金额
        // 测试支付 0.01
        paramMap.put("total_fee", "1");
        // 当前支付客户端的 ip 地址
        paramMap.put("spbill_create_ip", "127.0.0.1");
        // 支付之后的跳转
        paramMap.put("notify_url", "http://glkt.atguigu.cn/api/order/wxPay/notify");

        paramMap.put("trade_type", "JSAPI");
        // 设置参数值当前微信用户 openid
        // - 根据订单号获取用户 id, 根据用户 id 获取 openid
        // - 因为当前使用测试号, 测试号不支持支付功能, 为了使用正式服务号测试, 直接设置 oQTXC56lAy3xMOCkKCImHtHoLL
        // paramMap.put("openid", "o1R-t5trto9c5sdYt6l1ncGmY5Y");
        // UserInfo userInfo = userInfoFeignClient.getById(paymentInfo.getUserId());
        // paramMap.put("openid", "oepf36SawvvS8Rdqva-Cy4flFFg");
        paramMap.put("openid", "oQTXC56lAy3xMOCkKCImHtHoLL");

        // 通过 httpclient 调用微信支付接口
        // HTTPClient 来根据URL访问第三方接口并且传递参数
        // - url: 微信固定路径
        HttpClientUtils client = new HttpClientUtils("https://api.mch.weixin.qq.com/pay/unifiedorder");

        try {
            // 设置请求参数
            // - 参数
            // key: 商户 key
            String paramXml = WXPayUtil.generateSignature(paramMap, "MXb72b9RfshXZD4FRGV5KLqmv5bx9LT9");
            client.setXmlParam(paramXml);
            client.setHttps(true);
            // 请求
            client.post();

            // 微信支付接口返回数据
            String xml = client.getContent();
            log.info("XML: " + xml);
            // xml -> map
            Map<String, String> resultMap = WXPayUtil.xmlToMap(xml);

            // 进行封装
            if (null != resultMap.get("result_code") && !"SUCCESS".equals(resultMap.get("result_code"))) {
                throw new GgktException(20001, "支付失败");
            }

            //4、再次封装参数
            Map<String, String> parameterMap = new HashMap<>();
            String prepayId = String.valueOf(resultMap.get("prepay_id"));
            String packages = "prepay_id=" + prepayId;
            parameterMap.put("appId", "wxf913bfa3a2c7eeeb");
            parameterMap.put("nonceStr", resultMap.get("nonce_str"));
            parameterMap.put("package", packages);
            parameterMap.put("signType", "MD5");
            parameterMap.put("timeStamp", String.valueOf(System.currentTimeMillis()));
            String sign = WXPayUtil.generateSignature(parameterMap, "MXb72b9RfshXZD4FRGV5KLqmv5bx9LT9");

            //返回结果
            Map<String, Object> result = new HashMap<>();
            result.put("appId", "wxf913bfa3a2c7eeeb");
            result.put("timeStamp", parameterMap.get("timeStamp"));
            result.put("nonceStr", parameterMap.get("nonceStr"));
            result.put("signType", "MD5");
            result.put("paySign", sign);
            result.put("package", packages);
            System.out.println(result);

            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
```



#### 4.3.4 新建`HttpClientUtils`

```java
package com.atguigu.ggkt.util;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * http 请求客户端
 *
 * @author 陈江林
 * @date 2022/10/21 22:33
 */
public class HttpClientUtils {

    private String url;
    private Map<String, String> param;
    private int statusCode;
    private String content;
    private String xmlParam;
    private boolean isHttps;

    public boolean isHttps() {
        return isHttps;
    }

    public void setHttps(boolean isHttps) {
        this.isHttps = isHttps;
    }

    public String getXmlParam() {
        return xmlParam;
    }

    public void setXmlParam(String xmlParam) {
        this.xmlParam = xmlParam;
    }

    public HttpClientUtils(String url, Map<String, String> param) {
        this.url = url;
        this.param = param;
    }

    public HttpClientUtils(String url) {
        this.url = url;
    }

    public void setParameter(Map<String, String> map) {
        param = map;
    }

    public void addParameter(String key, String value) {
        if (param == null)
            param = new HashMap<String, String>();
        param.put(key, value);
    }

    public void post() throws ClientProtocolException, IOException {
        HttpPost http = new HttpPost(url);
        setEntity(http);
        execute(http);
    }

    public void put() throws ClientProtocolException, IOException {
        HttpPut http = new HttpPut(url);
        setEntity(http);
        execute(http);
    }

    public void get() throws ClientProtocolException, IOException {
        if (param != null) {
            StringBuilder url = new StringBuilder(this.url);
            boolean isFirst = true;
            for (String key : param.keySet()) {
                if (isFirst) {
                    url.append("?");
                    isFirst = false;
                } else {
                    url.append("&");
                }
                url.append(key).append("=").append(param.get(key));
            }
            
            this.url = url.toString();
        }
        
        HttpGet http = new HttpGet(url);
        execute(http);
    }

    /**
     * set http post,put param
     */
    private void setEntity(HttpEntityEnclosingRequestBase http) {
        if (param != null) {
            List<NameValuePair> nvps = new LinkedList<>();
            for (String key : param.keySet()) {
                // 参数
                nvps.add(new BasicNameValuePair(key, param.get(key)));
            }

            // 设置参数
            http.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
        }
        
        if (xmlParam != null) {
            http.setEntity(new StringEntity(xmlParam, Consts.UTF_8));
        }
    }

    private void execute(HttpUriRequest http) throws ClientProtocolException,
            IOException {
        CloseableHttpClient httpClient = null;
        try {
            if (isHttps) {
                // 信任所有
                SSLContext sslContext = new SSLContextBuilder()
                        .loadTrustMaterial(null, (chain, authType) -> true).build();
                SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                        sslContext);
                httpClient = HttpClients.custom().setSSLSocketFactory(sslsf)
                        .build();
            } else {
                httpClient = HttpClients.createDefault();
            }
            
            CloseableHttpResponse response = httpClient.execute(http);
            try {
                if (response != null) {
                    if (response.getStatusLine() != null) {
                        statusCode = response.getStatusLine().getStatusCode();
                    }

                    HttpEntity entity = response.getEntity();
                    // 响应内容
                    content = EntityUtils.toString(entity, Consts.UTF_8);
                }
            } finally {
                response.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpClient.close();
        }
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getContent() throws ParseException, IOException {
        return content;
    }

}
```



### 4.4 引入依赖

```xml
<!-- 微信支付 SDK -->
<dependency>
	<groupId>com.github.wxpay</groupId>
	<artifactId>wxpay-sdk</artifactId>
	<version>0.0.3</version>
</dependency>
```



### 4.5 获取正式公众号里自己微信的`openid`（示例）

#### 4.5.1 配置文件修改为支付公众号

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666693647452-4b6d49ec-bbe7-4d18-a3e6-a67b24324661.png)

```yaml
wx: 
	mp:
    # 尚硅谷支付公众号的 appid
    app-id: wxf913bfa3a2c7eeeb
    # 尚硅谷支付公众号的 appsecret
    secret: cd360d429e5c8db0c638d5ef9df74f6d
```



#### 4.5.2 新建控制类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666695059092-34a8164c-f967-475d-af18-440da303593a.png)

```java
package com.atguigu.ggkt.wechat.api;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.WxOAuth2UserInfo;
import me.chanjar.weixin.common.bean.oauth2.WxOAuth2AccessToken;
import me.chanjar.weixin.common.util.http.URIUtil;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 示例
 * 获取 openid 控制类
 *
 * @author 陈江林
 * @date 2022/10/25 18:38
 */
@Controller
@RequestMapping("/api/wechat/openid")
public class GetOpenIdController {

    @Autowired
    private WxMpService wxMpService;

    @GetMapping("/authorize")
    public String authorize() {
        // 正式号的授权的回调域名
        // 使用尚硅谷的接口获取 openid
        String userInfoUrl = "http://glkt.atguigu.cn/api/user/openid/userInfo";

        // 构造 oauth2 授权的 url 连接
        String redirectURL = wxMpService.getOAuth2Service()
                .buildAuthorizationUrl(userInfoUrl,
                        WxConsts.OAuth2Scope.SNSAPI_USERINFO,
                        URIUtil.encodeURIComponent(""));
        // 跳转回调 redirect_uri，应当使用 https 链接来确保授权 code 的安全性
        // 重定向到用户授权界面, 如果用户同意授权，页面将跳转至 redirect_uri/?code=CODE&state=STATE。
        return "redirect:" + redirectURL;
    }

    /**
     * 获取 openid
     *
     * @param code
     * @return {@link String}
     * @throws Exception
     */
    @GetMapping("/userInfo")
    @ResponseBody
    public String userInfo(@RequestParam("code") String code) throws Exception {
        // 通过 code 换取网页授权 access_token
        WxOAuth2AccessToken accessToken = wxMpService.getOAuth2Service().getAccessToken(code);
        // 拉取用户信息(需 scope 为 snsapi_userinfo)
        WxOAuth2UserInfo user = wxMpService.getOAuth2Service().getUserInfo(accessToken, null);
        return user.getOpenid();
    }

}
```





### 4.6 路由和对应页面和对应的`API`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666833216320-3a4fa488-f6e0-4f48-a47f-61da85720609.png)

```javascript
,
  {
    // 支付下单
    path: '/trade/:courseId',
    name: 'Trade',
    component: () => import('../views/Trade')
  },
  {
    // 支付
    path: '/pay/:orderId',
    name: 'Pay',
    component: () => import('../views/Pay')
  }
```



#### 4.6.1 支付下单页面 `Trade.vue`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666948818465-09b15406-81f3-42ec-9554-4b0d5db2059e.png)

```vue
<template>

  <div>
    <van-image width="100%" height="200" :src="courseVo.cover"/>

    <h1 class="van-ellipsis course_title">{{ courseVo.title }}</h1>

    <div class="course_teacher_price_box">
      <div class="course_teacher_price">
        <div class="course_price">价格：</div>
        <div class="course_price_number">￥{{ courseVo.price }}</div>
      </div>
    </div>
    <div class="course_teacher_price_box">
      <div class="course_teacher_box">
        <div class="course_teacher">主讲： {{ teacher.name }}</div>
        <van-image :src="teacher.avatar" round width="50px" height="50px"/>
      </div>
    </div>

    <van-loading vertical="true" v-show="loading">加载中...</van-loading>

    <div style="position:fixed;left:0px;bottom:50px;width:100%;height:50px;z-index:999;">
      <!-- 优惠券单元格 -->
      <van-coupon-cell
        :coupons="coupons"
        :chosen-coupon="chosenCoupon"
        @click="showList = true"
      />
      <!-- 优惠券列表 -->
      <van-popup
        v-model="showList"
        round
        position="bottom"
        style="height: 90%; padding-top: 4px;"
      >
        <van-coupon-list
          :coupons="coupons"
          :chosen-coupon="chosenCoupon"
          :disabled-coupons="disabledCoupons"
          @change="onChange"
        />
      </van-popup>
    </div>

    <van-goods-action>
      <van-submit-bar :price="finalAmount" button-text="确认下单" @submit="sureOrder"/>
    </van-goods-action>
  </div>
</template>

<script>
import courseApi from '@/api/course'
import orderApi from '@/api/order'
import couponApi from '@/api/coupon'

export default {
  data() {
    return {
      loading: false,

      courseId: null,
      courseVo: {},
      teacher: {},

      orderId: null,

      showList: false,
      chosenCoupon: -1,
      coupons: [],
      disabledCoupons: [],
      couponId: null,
      couponUseId: null,

      couponReduce: 0,
      finalAmount: 0
    };
  },

  created() {
    this.courseId = this.$route.params.courseId;
    this.fetchData()
    this.getCouponInfo();
  },

  methods: {
    onChange(index) {
      debugger
      this.showList = false;
      this.chosenCoupon = index;

      this.couponId = this.coupons[index].id;
      this.couponUseId = this.coupons[index].couponUseId;
      this.couponReduce = this.coupons[index].value;
      this.finalAmount = parseFloat(this.finalAmount) - parseFloat(this.couponReduce)
    },

    fetchData() {
      debugger
      this.loading = true;
      courseApi.getInfo(this.courseId).then(response => {
        // console.log(response.data);
        this.courseVo = response.data.courseVo;
        this.teacher = response.data.teacher;
        //转换为分
        this.finalAmount = parseFloat(this.courseVo.price) * 100;

        this.loading = false;
      });
    },


    getCouponInfo() {
      //debugger
      couponApi.findCouponInfo().then(response => {
        // console.log(response.data);
        this.coupons = response.data.abledCouponsList;
        this.disabledCoupons = response.data.disabledCouponsList;
      });
    },

    sureOrder() {
      //debugger
      this.loading = true;
      let orderFormVo = {
        'courseId': this.courseId,
        'couponId': this.couponId,
        'couponUseId': this.couponUseId
      }
      orderApi.submitOrder(orderFormVo).then(response => {
        console.log(response.data)
        this.$router.push({path: '/pay/' + response.data})
      })
    }
  }
};
</script>

<style lang="scss" scoped>
.gap {
  height: 10px;
}

::v-deep.van-image {
  display: block;
}

.course_count {
  background-color: #82848a;
  color: white;
  padding: 5px;
  text-align: center;
  border-right: 1px solid #939393;

  h1 {
    font-size: 14px;
    margin: 0;
  }

  p {
    margin: 0;
    font-size: 16px;
  }
}

.course_title {
  font-size: 20px;
  margin: 10px;
}

.course_teacher_price_box {
  margin: 10px;
  display: flex;
  justify-content: space-between;
  align-items: center;

  .course_teacher_price {
    display: flex;
    font-size: 14px;
    align-items: center;

    .course_price_number {
      color: red;
      font-size: 18px;
      font-weight: bold;
    }
  }

  .course_teacher_box {
    display: flex;
    justify-content: center;
    align-items: center;

    .course_teacher {
      margin-right: 20px;
    }
  }
}

.course_contents {
  margin: 10px;

  .course_title_font {
    color: #68cb9b;
    font-weight: bold;
  }

  .course_content {
    margin-bottom: 20px;
  }
}

.course_chapter_list {
  display: flex;
  justify-content: space-between;
  align-items: center;

  h2 {
    font-size: 14px;
  }

  p {
    margin: 0;
  }
}
</style>
```



#### 4.6.2 支付页面 `Pay.vue`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666948800359-3723f4ba-1cc5-4e0a-bae4-170313fa7002.png)

```vue
<template>

  <div>
    <van-image width="100%" height="200" src="https://cdn.uviewui.com/uview/swiper/1.jpg"/>

    <h1 class="van-ellipsis course_title">课程名称: {{ orderInfo.courseName }}</h1>

    <div class="course_teacher_price_box">
      <div class="course_price">订单号：{{ orderInfo.outTradeNo }}</div>
    </div>
    <div class="course_teacher_price_box">
      <div class="course_price">下单时间：{{ orderInfo.createTime }}</div>
    </div>
    <div class="course_teacher_price_box">
      <div class="course_price">支付状态：{{ orderInfo.orderStatus == 'UNPAID' ? '未支付' : '已支付' }}</div>
    </div>
    <div class="course_teacher_price_box" v-if="orderInfo.orderStatus == 'PAID'">
      <div class="course_price">支付时间：{{ orderInfo.payTime }}</div>
    </div>
    <van-divider/>
    <div class="course_teacher_price_box">
      <div class="course_price">订单金额：<span style="color: red">￥{{ orderInfo.originAmount }}</span></div>
    </div>
    <div class="course_teacher_price_box">
      <div class="course_price">优惠券金额：<span style="color: red">￥{{ orderInfo.couponReduce }}</span></div>
    </div>
    <div class="course_teacher_price_box">
      <div class="course_price">支付金额：<span style="color: red">￥{{ orderInfo.finalAmount }}</span></div>
    </div>

    <van-goods-action>
      <van-goods-action-button type="danger" text="支付" @click="pay" v-if="orderInfo.orderStatus == '0'"/>
      <van-goods-action-button type="warning" text="去观看" @click="see" v-else/>
    </van-goods-action>

    <van-loading vertical="true" v-show="loading">加载中...</van-loading>
  </div>
</template>

<script>
import orderApi from '@/api/order'

export default {
  data() {
    return {
      loading: false,

      orderId: null,
      orderInfo: {},

      showList: false,
      chosenCoupon: -1,
      coupons: [],
      disabledCoupons: [],

      couponReduce: 0,
      finalAmount: 0
    };
  },

  created() {
    this.orderId = this.$route.params.orderId;

    this.fetchData();
  },

  methods: {
    fetchData() {
      this.loading = true;
      orderApi.getInfo(this.orderId).then(response => {
        this.orderInfo = response.data;
        this.finalAmount = parseFloat(this.orderInfo.finalAmount) * 100;

        this.loading = false;
      });
    },

    pay() {
      this.loading = true;
      orderApi.createJsapi(this.orderInfo.outTradeNo).then(response => {
        console.log(response.data)
        this.loading = false;
        this.onBridgeReady(response.data)
      })
    },

    onBridgeReady(data) {
      let that = this;
      console.log(data)
      WeixinJSBridge.invoke(
        'getBrandWCPayRequest', {
          'appId': data.appId,     //公众号ID，由商户传入
          'timeStamp': data.timeStamp,         //时间戳，自1970年以来的秒数
          'nonceStr': data.nonceStr, //随机串
          'package': data.package,
          'signType': data.signType,         //微信签名方式：
          'paySign': data.paySign //微信签名
        },
        function (res) {
          if (res.err_msg == 'get_brand_wcpay_request:ok') {
            // 使用以上方式判断前端返回,微信团队郑重提示：
            //res.err_msg将在用户支付成功后返回ok，但并不保证它绝对可靠。
            console.log('支付成功')
            that.queryPayStatus();
          }
        });
    },

    queryPayStatus() {
      // 回调查询
      orderApi.queryPayStatus(this.orderInfo.outTradeNo).then(response => {
        console.log(response.data)
        this.fetchData()
      })
    },

    see() {
      this.$router.push({path: '/courseInfo/' + this.orderInfo.courseId})
    }
  }
};
</script>

<style lang="scss" scoped>
.gap {
  height: 10px;
}

::v-deep.van-image {
  display: block;
}

.course_count {
  background-color: #82848a;
  color: white;
  padding: 5px;
  text-align: center;
  border-right: 1px solid #939393;

  h1 {
    font-size: 14px;
    margin: 0;
  }

  p {
    margin: 0;
    font-size: 16px;
  }
}

.course_title {
  font-size: 20px;
  margin: 10px;
}

.course_teacher_price_box {
  margin: 10px;
  display: flex;
  justify-content: space-between;
  align-items: center;

  .course_teacher_price {
    display: flex;
    font-size: 14px;
    align-items: center;

    .course_price_number {
      color: red;
      font-size: 18px;
      font-weight: bold;
    }
  }

  .course_teacher_box {
    display: flex;
    justify-content: center;
    align-items: center;

    .course_teacher {
      margin-right: 20px;
    }
  }
}

.course_contents {
  margin: 10px;

  .course_title_font {
    color: #68cb9b;
    font-weight: bold;
  }

  .course_content {
    margin-bottom: 20px;
  }
}

.course_chapter_list {
  display: flex;
  justify-content: space-between;
  align-items: center;

  h2 {
    font-size: 14px;
  }

  p {
    margin: 0;
  }
}
</style>
```



#### 4.6.3 `order.js`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666862272554-b267f141-13c7-458d-8745-840fc7d36d54.png)

```javascript
import {request} from '@/utils/request'

const api_name = '/api/order'

export default {

  // 订单支付
  createJsapi(orderNo) {
    return request({
      url: `${api_name}/wxPay/createJsapi/${orderNo}`,
      method: 'get'
    })
  },

  // 订单信息
  getInfo(orderId) {
    return request({
      url: `${api_name}/orderInfo/getInfo/${orderId}`,
      method: 'get'
    })
  },

  submitOrder(orderFormVo) {
    return request({
      url: `${api_name}/orderInfo/submitOrder`,
      method: 'post',
      data: orderFormVo
    })
  },

  queryPayStatus(orderNo) {
    return request({
      url: `${api_name}/wxPay/queryPayStatus/${orderNo}`,
      method: 'get'
    })
  },

  findListPage(pageNo, pageSize) {
    return request({
      url: `${api_name}/orderInfo/${pageNo}/${pageSize}`,
      method: 'get'
    })
  },

  findCourseListPage(pageNo, pageSize) {
    return request({
      url: `${api_name}/orderInfo/course/${pageNo}/${pageSize}`,
      method: 'get'
    })
  }
}
```



#### 4.6.4 `coupon.js`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666862296249-983e5a3b-2458-4e6c-942a-fe6f5bebf38e.png)

```javascript
import {request} from '@/utils/request'

const api_name = '/api/activity/couponInfo'

export default {

  findCouponInfo() {
    return request({
      url: `${api_name}/findCouponInfo`,
      method: 'get'
    })
  },

  findListPage(pageNo, pageSize) {
    return request({
      url: `${api_name}/${pageNo}/${pageSize}`,
      method: 'get'
    })
  }
}
```



### 4.7 订单详情接口

#### 4.7.1 追加代码 控制类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666833401391-07d9d53a-c7de-467c-98bc-a35899b4f20d.png)

```java
    @ApiOperation(value = " 获取订单信息")
    @GetMapping("/getInfo/{id}")
    public Result<OrderInfoVo> getInfo(@PathVariable Long id) {
        OrderInfoVo orderInfoVo = orderInfoService.getOrderInfoVoById(id);
        return Result.ok(orderInfoVo);
    }
```



#### 4.7.2 服务接口类

```java
    /**
     * 根据 id 获取订单信息
     *
     * @param id id
     * @return {@link OrderInfoVo}
     */
    OrderInfoVo getOrderInfoVoById(Long id);
```



#### 4.7.3 服务实现类

```java
    @Override
    public OrderInfoVo getOrderInfoVoById(Long id) {
        // 根据 id 获取订单信息
        OrderInfo orderInfo = baseMapper.selectById(id);
        // 根据 id 获取订单详情
        OrderDetail orderDetail = orderDetailService.getById(id);
        // 创建订单信息视图对象
        OrderInfoVo orderInfoVo = new OrderInfoVo();
        // 将属性复制到视图对象
        BeanUtils.copyProperties(orderInfo, orderInfoVo);
        // 设置属性值
        orderInfoVo.setCourseId(orderDetail.getCourseId());
        orderInfoVo.setCourseName(orderDetail.getCourseName());
        return orderInfoVo;
    }
```



### 4.8 查询支付结果

#### 4.8.1 追加代码 控制类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666833917632-f4765bc1-e29e-4316-a367-b24eaf58b2fa.png)

```java
    /**
     * 查询支付状态
     *
     * @param orderNo 商户订单号（对应 order_indo 表字段 out_trade_no）
     * @return {@link Result}
     */
    @ApiOperation(value = "查询支付状态")
    @GetMapping("/queryPayStatus/{orderNo}")
    public Result queryPayStatus(
            @ApiParam(name = "orderNo", value = "订单No（）", required = true)
            @PathVariable("orderNo") String orderNo) {
        // 根据订单号调用微信接口查询支付状态
        Map<String, String> resultMap = wxPayService.queryPayStatus(orderNo);

        if (resultMap == null) {
            return Result.fail(null).message("支付出错");
        }

        if ("SUCCESS".equals(resultMap.get("trade_state"))) {
            // 更改订单状态，处理支付结果
            String out_trade_no = resultMap.get("out_trade_no");
            orderInfoService.updateOrderStatus(out_trade_no);
            return Result.ok(null).message("支付成功");
        }

        return Result.ok().message("支付中");
    }
```



#### 4.8.2 服务接口类

```java
    /**
     * 根据订单号调用微信接口查询支付状态
     *
     * @param orderNo 微信订单号
     * @return {@link Map}<{@link String}, {@link String}>
     */
    Map<String, String> queryPayStatus(String orderNo);
```



#### 4.8.3 服务实现类

```java
    @Override
    public Map<String, String> queryPayStatus(String orderNo) {
        try {
            // 1、封装参数
            Map<String, String> paramMap = new HashMap<>();
            paramMap.put("appid", "wxf913bfa3a2c7eeeb");
            paramMap.put("mch_id", "1481962542");
            paramMap.put("out_trade_no", orderNo);
            paramMap.put("nonce_str", WXPayUtil.generateNonceStr());

            // 2、设置请求
            HttpClientUtils client = new HttpClientUtils("https://api.mch.weixin.qq.com/pay/orderquery");
            client.setXmlParam(WXPayUtil.generateSignedXml(paramMap, "MXb72b9RfshXZD4FRGV5KLqmv5bx9LT9"));
            client.setHttps(true);
            client.post();
            // 3、返回第三方的数据
            String xml = client.getContent();
            // 6、转成Map
            // 7、返回
            return WXPayUtil.xmlToMap(xml);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
```



#### 4.8.4 服务接口类

```java
    /**
     * 更新订单状态 - 已支付
     *
     * @param out_trade_no 商户订单号
     */
    void updateOrderStatus(String out_trade_no);
```



#### 4.8.5 服务实现类

```java
    @Override
    public void updateOrderStatus(String out_trade_no) {
        // 根据 out_trade_no 查询订单
        LambdaQueryWrapper<OrderInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(OrderInfo::getOutTradeNo, out_trade_no);
        OrderInfo orderInfo = baseMapper.selectOne(wrapper);
        // 更新订单状态 1 已经支付
        orderInfo.setOrderStatus("1");
        baseMapper.updateById(orderInfo);
    }
```


# 十六 直播管理模块和公众号观看、分享

```
git checkout -b 16.0.0_live
```



## 数据库表

```plsql
/*
SQLyog Ultimate - MySQL GUI v8.2 
MySQL - 5.7.29-32-log : Database - glkt_live
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`glkt_live` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `glkt_live`;

/*Table structure for table `live_course` */

DROP TABLE IF EXISTS `live_course`;

CREATE TABLE `live_course` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `subject_id` bigint(20) DEFAULT NULL COMMENT '分类Id',
  `course_name` varchar(64) NOT NULL DEFAULT '' COMMENT '直播名称',
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '直播开始时间',
  `end_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '直播结束时间',
  `cover` varchar(255) DEFAULT NULL,
  `course_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '课程id',
  `teacher_id` bigint(20) DEFAULT NULL COMMENT '主播老师id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COMMENT='直播课程表';

/*Data for the table `live_course` */

insert  into `live_course`(`id`,`subject_id`,`course_name`,`start_time`,`end_time`,`cover`,`course_id`,`teacher_id`,`create_time`,`update_time`,`is_deleted`) values (1,NULL,'Spring Cloud源码讲解','2021-11-07 17:00:00','2021-10-28 17:00:00','https://online-teach-file.oss-cn-beijing.aliyuncs.com/cover/2021/08/09/f5ada6ba-8d12-4c00-8ad9-6a521f71b0da.jpg',2687659,2,'2021-10-27 08:11:33','2021-11-22 13:25:21',0),(2,NULL,'大数据Spark全面分析','2021-11-27 17:00:00','2021-10-28 17:00:00','https://online-teach-file.oss-cn-beijing.aliyuncs.com/cover/2021/08/09/f5ada6ba-8d12-4c00-8ad9-6a521f71b0da.jpg',2671785,1,'2021-10-27 08:50:18','2021-11-22 13:25:27',0),(3,NULL,'微服务架构演进','2021-12-28 16:00:00','2021-10-29 16:00:00','https://online-teach-file.oss-cn-beijing.aliyuncs.com/cover/2021/08/09/f5ada6ba-8d12-4c00-8ad9-6a521f71b0da.jpg',2679789,1,'2021-10-28 07:42:04','2021-11-22 13:25:36',0),(4,NULL,'JAVA新特性全面讲解','2021-11-08 14:30:00','2021-11-09 14:30:00','https://online-teach-file.oss-cn-beijing.aliyuncs.com/cover/2021/08/09/f5ada6ba-8d12-4c00-8ad9-6a521f71b0da.jpg',2687659,4,'2021-11-08 06:00:43','2021-11-09 07:44:03',0),(5,NULL,'Spring MVC讲解','2021-11-09 15:04:00','2021-11-10 15:00:00','https://online-teach-file.oss-cn-beijing.aliyuncs.com/cover/2021/08/09/f5ada6ba-8d12-4c00-8ad9-6a521f71b0da.jpg',2689593,2,'2021-11-09 07:40:37','2021-11-22 13:31:03',0),(6,NULL,'Mysql源码级讲解','2021-11-22 21:25:00','2021-11-23 21:25:00','http://47.93.148.192:9000/gmall/20211122/1504320cbe2b246514.jpg',2709689,5,'2021-11-22 13:29:18','2021-11-22 13:30:24',0),(7,NULL,'Spark讲解','2021-11-23 18:30:00','2021-11-23 22:00:00','https://cdn.uviewui.com/uview/swiper/1.jpg',2711543,6,'2021-11-23 10:40:44','2021-11-23 10:40:44',0),(8,NULL,'11月26日晚8点电商分享','2021-11-26 17:00:00','2021-11-27 17:00:00','https://online-teach-file.oss-cn-beijing.aliyuncs.com/cover/2021/08/09/2829c8d1-f16f-44a4-96cd-d13b451a8d56.jpg',2716727,6,'2021-11-26 09:19:39','2021-11-26 09:20:58',0);

/*Table structure for table `live_course_account` */

DROP TABLE IF EXISTS `live_course_account`;

CREATE TABLE `live_course_account` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `live_course_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '直播课程id',
  `zhubo_account` varchar(20) DEFAULT NULL COMMENT '主播账号（欢拓系统的主播id）',
  `zhubo_password` varchar(32) DEFAULT NULL COMMENT '主播密码',
  `zhubo_key` varchar(64) NOT NULL DEFAULT '' COMMENT '主播登录秘钥',
  `admin_key` varchar(32) NOT NULL DEFAULT '' COMMENT '助教登录秘钥',
  `user_key` varchar(32) NOT NULL DEFAULT '' COMMENT '学生登录秘钥',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COMMENT='直播课程账号表（受保护信息）';

/*Data for the table `live_course_account` */

insert  into `live_course_account`(`id`,`live_course_id`,`zhubo_account`,`zhubo_password`,`zhubo_key`,`admin_key`,`user_key`,`create_time`,`update_time`,`is_deleted`) values (1,1,'582523',NULL,'2518','6240','8447','2021-10-27 08:11:33','2021-10-27 08:11:33',0),(2,2,'582549','000000','1325','6632','8582','2021-10-27 08:50:30','2021-10-27 08:50:30',0),(3,3,'582825','111111','1758','5167','8643','2021-10-28 07:42:04','2021-10-28 07:42:04',0),(4,4,'582549','000000','3800','4233','8874','2021-11-08 06:00:43','2021-11-08 06:04:27',0),(5,5,'582523','111111','3060','4868','8963','2021-11-09 07:40:37','2021-11-09 07:40:37',0),(6,6,'582825','111111','3977','4548','8658','2021-11-22 13:29:18','2021-11-22 13:29:18',0),(7,7,'589813','111111','1921','4328','8302','2021-11-23 10:40:44','2021-11-23 10:40:44',0),(8,8,'589813','111111','3108','6824','8717','2021-11-26 09:19:39','2021-11-26 09:19:39',0);

/*Table structure for table `live_course_config` */

DROP TABLE IF EXISTS `live_course_config`;

CREATE TABLE `live_course_config` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `live_course_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '直播课程id',
  `page_view_mode` tinyint(3) NOT NULL DEFAULT '0' COMMENT '界面模式 1全屏模式 0二分屏 2课件模式',
  `number_enable` tinyint(3) NOT NULL DEFAULT '0' COMMENT '是否开启 观看人数 0否 1是',
  `store_enable` tinyint(3) NOT NULL DEFAULT '0' COMMENT '商城是否开启 0未开启 1开启',
  `store_type` tinyint(3) NOT NULL DEFAULT '1' COMMENT '1商品列表,2商城链接,3商城二维码',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COMMENT='直播课程配置表';

/*Data for the table `live_course_config` */

insert  into `live_course_config`(`id`,`live_course_id`,`page_view_mode`,`number_enable`,`store_enable`,`store_type`,`create_time`,`update_time`,`is_deleted`) values (1,2,1,1,1,1,'2021-10-28 07:27:23','2021-10-28 07:27:23',0),(2,3,1,1,1,1,'2021-10-28 07:42:29','2021-10-28 07:42:29',0),(3,4,1,1,1,1,'2021-11-08 06:12:04','2021-11-08 06:12:04',0),(4,5,1,1,1,1,'2021-11-09 07:54:01','2021-11-09 07:54:01',0),(5,6,1,1,1,1,'2021-11-22 13:32:13','2021-11-22 13:32:13',0),(6,7,1,1,1,1,'2021-11-23 10:42:01','2021-11-23 10:42:01',0),(7,8,1,1,1,1,'2021-11-26 09:20:07','2021-11-26 09:20:07',0);

/*Table structure for table `live_course_description` */

DROP TABLE IF EXISTS `live_course_description`;

CREATE TABLE `live_course_description` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `live_course_id` bigint(20) DEFAULT NULL,
  `description` text COMMENT '课程简介',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COMMENT='课程简介';

/*Data for the table `live_course_description` */

insert  into `live_course_description`(`id`,`live_course_id`,`description`,`create_time`,`update_time`,`is_deleted`) values (1,1,'<p>本套Java视频完全针对零基础学员，课堂实录，自发布以来，好评如潮！Java视频中注重与学生互动，讲授幽默诙谐、细致入微，覆盖Java基础所有核心知识点，同类Java视频中也是代码量大、案例多、实战性强的。同时，本Java视频教程注重技术原理剖析，深入JDK源码，辅以代码实战贯穿始终，用实践驱动理论，并辅以必要的代码练习。</p>\n<p>------------------------------------</p>\n<p>视频特点：</p>\n<p>通过学习本Java视频教程，大家能够真正将Java基础知识学以致用、活学活用，构架Java编程思想，牢牢掌握\"源码级\"的Javase核心技术，并为后续JavaWeb等技术的学习奠定扎实基础。<br /><br />1.通俗易懂，细致入微：每个知识点高屋建瓴，深入浅出，简洁明了的说明问题<br />2.具实战性：全程真正代码实战，涵盖上百个企业应用案例及练习<br />3.深入：源码分析，更有 Java 反射、动态代理的实际应用等<br />4.登录尚硅谷官网，技术讲师免费在线答疑</p>\n','2021-11-08 01:42:07','2021-11-08 01:42:18',0),(2,2,'<p>本套Java视频完全针对零基础学员，课堂实录，自发布以来，好评如潮！Java视频中注重与学生互动，讲授幽默诙谐、细致入微，覆盖Java基础所有核心知识点，同类Java视频中也是代码量大、案例多、实战性强的。同时，本Java视频教程注重技术原理剖析，深入JDK源码，辅以代码实战贯穿始终，用实践驱动理论，并辅以必要的代码练习。</p>\n<p>------------------------------------</p>\n<p>视频特点：</p>\n<p>通过学习本Java视频教程，大家能够真正将Java基础知识学以致用、活学活用，构架Java编程思想，牢牢掌握\"源码级\"的Javase核心技术，并为后续JavaWeb等技术的学习奠定扎实基础。<br /><br />1.通俗易懂，细致入微：每个知识点高屋建瓴，深入浅出，简洁明了的说明问题<br />2.具实战性：全程真正代码实战，涵盖上百个企业应用案例及练习<br />3.深入：源码分析，更有 Java 反射、动态代理的实际应用等<br />4.登录尚硅谷官网，技术讲师免费在线答疑</p>\n','2021-11-08 01:42:25','2021-11-08 01:42:30',0),(14,3,'<p>本套Java视频完全针对零基础学员，课堂实录，自发布以来，好评如潮！Java视频中注重与学生互动，讲授幽默诙谐、细致入微，覆盖Java基础所有核心知识点，同类Java视频中也是代码量大、案例多、实战性强的。同时，本Java视频教程注重技术原理剖析，深入JDK源码，辅以代码实战贯穿始终，用实践驱动理论，并辅以必要的代码练习。</p>\n<p>------------------------------------</p>\n<p>视频特点：</p>\n<p>通过学习本Java视频教程，大家能够真正将Java基础知识学以致用、活学活用，构架Java编程思想，牢牢掌握\"源码级\"的Javase核心技术，并为后续JavaWeb等技术的学习奠定扎实基础。<br /><br />1.通俗易懂，细致入微：每个知识点高屋建瓴，深入浅出，简洁明了的说明问题<br />2.具实战性：全程真正代码实战，涵盖上百个企业应用案例及练习<br />3.深入：源码分析，更有 Java 反射、动态代理的实际应用等<br />4.登录尚硅谷官网，技术讲师免费在线答疑</p>\n','2021-11-08 01:42:34','2021-11-08 01:42:34',0),(15,4,'<p>本套Java视频完全针对零基础学员，课堂实录，自发布以来，好评如潮！Java视频中注重与学生互动，讲授幽默诙谐、细致入微，覆盖Java基础所有核心知识点，同类Java视频中也是代码量大、案例多、实战性强的。同时，本Java视频教程注重技术原理剖析，深入JDK源码，辅以代码实战贯穿始终，用实践驱动理论，并辅以必要的代码练习。</p>\n<p>------------------------------------</p>\n<p>视频特点：</p>\n<p>通过学习本Java视频教程，大家能够真正将Java基础知识学以致用、活学活用，构架Java编程思想，牢牢掌握\"源码级\"的Javase核心技术，并为后续JavaWeb等技术的学习奠定扎实基础。<br /><br />1.通俗易懂，细致入微：每个知识点高屋建瓴，深入浅出，简洁明了的说明问题<br />2.具实战性：全程真正代码实战，涵盖上百个企业应用案例及练习<br />3.深入：源码分析，更有 Java 反射、动态代理的实际应用等<br />4.登录尚硅谷官网，技术讲师免费在线答疑</p>','2021-11-08 06:00:43','2021-11-08 06:24:59',0),(16,5,'本套Java视频完全针对零基础学员，课堂实录，自发布以来，好评如潮！Java视频中注重与学生互动，讲授幽默诙谐、细致入微，覆盖Java基础所有核心知识点，同类Java视频中也是代码量大、案例多、实战性强的。同时，本Java视频教程注重技术原理剖析，深入JDK源码，辅以代码实战贯穿始终，用实践驱动理论，并辅以必要的代码练习。','2021-11-09 07:40:37','2021-11-09 07:40:37',0),(17,6,' 数据库就像一棵常青的技能树，无论是初级程序员还是CTO、首席架构师都能从中汲取足够的技术养料。菜鸟往往积累单点技术，如 DML、DDL、存储过程和函数、约束、索引的数据结构，老鸟则需要吃透底层原理，数据库事务ACID如何实现？锁机制与MVCC又是怎么回事？分布式场景下数据库怎么优化保持高性能？\n      知道怎么用是一方面，知道为什么则是更为稀缺的能力。程序员核心能力中至关重要的一点：精通数据库。精通意味着：第一，形成知识网，更灵活地应对突发问题；第二，懂底层原理，更自由地应对复杂多变的业务场景。','2021-11-22 13:29:18','2021-11-22 13:29:18',0),(18,7,'Spring4.0是 Spring 推出的一个重大版本升级，进一步加强了 Spring 作为 Java 领域第一开源平台的地位。Spring4.0 引入了众多 Java 开发者期盼的新特性，如泛型依赖注入、SpEL、校验及格式化框架、Rest风格的 WEB 编程模型等。这些新功能实用性强、易用性高，可大幅降低 JavaEE 开发的难度，同时有效提升应用开发的优雅性。','2021-11-23 10:40:44','2021-11-23 10:40:44',0),(19,8,' 数据库就像一棵常青的技能树，无论是初级程序员还是CTO、首席架构师都能从中汲取足够的技术养料。菜鸟往往积累单点技术，如 DML、DDL、存储过程和函数、约束、索引的数据结构，老鸟则需要吃透底层原理，数据库事务ACID如何实现？锁机制与MVCC又是怎么回事？分布式场景下数据库怎么优化保持高性能？\n      知道怎么用是一方面，知道为什么则是更为稀缺的能力。程序员核心能力中至关重要的一点：精通数据库。精通意味着：第一，形成知识网，更灵活地应对突发问题；第二，懂底层原理，更自由地应对复杂多变的业务场景。\n','2021-11-26 09:19:39','2021-11-26 09:21:18',0);

/*Table structure for table `live_course_goods` */

DROP TABLE IF EXISTS `live_course_goods`;

CREATE TABLE `live_course_goods` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `live_course_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '直播课程id',
  `goods_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '推荐点播课程id',
  `name` varchar(100) DEFAULT NULL COMMENT '商品名称',
  `img` varchar(255) DEFAULT NULL COMMENT '图片',
  `price` decimal(10,0) DEFAULT NULL COMMENT '商品现价',
  `originalPrice` decimal(10,0) DEFAULT NULL COMMENT '商品原价',
  `tab` tinyint(3) DEFAULT NULL COMMENT '商品标签',
  `url` varchar(255) DEFAULT NULL COMMENT '商品链接',
  `putaway` varchar(255) DEFAULT NULL COMMENT '商品状态：0下架，1上架，2推荐',
  `pay` tinyint(3) DEFAULT NULL COMMENT '购买模式(1,链接购买 2,二维码购买)',
  `qrcode` varchar(255) DEFAULT NULL COMMENT '商品二维码',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COMMENT='直播课程关联推荐表';

/*Data for the table `live_course_goods` */

insert  into `live_course_goods`(`id`,`live_course_id`,`goods_id`,`name`,`img`,`price`,`originalPrice`,`tab`,`url`,`putaway`,`pay`,`qrcode`,`create_time`,`update_time`,`is_deleted`) values (1,2,1,'小米1','http://47.93.148.192:9000/gmall/20211027/235.jpg','10','10',1,'http://item.atguigu.cn/1.html','1',1,'','2021-10-28 07:29:36','2021-10-28 08:54:17',0),(2,3,1,'小米2','http://47.93.148.192:9000/gmall/20211027/235.jpg','10','10',1,'http://item.atguigu.cn/2.html','1',1,'','2021-10-28 07:42:30','2021-10-28 08:52:54',0),(3,4,18,'Java精品课程','https://online-teach-file.oss-cn-beijing.aliyuncs.com/cover/2021/08/09/e4ee03d7-52bd-41ca-99f9-04dc23250a71.jpg','22800','22800',1,'http://item.gmall.com/118.html','1',1,'','2021-11-08 06:12:05','2021-11-08 06:12:05',0),(4,4,8,'大数据Scala入门到精通（新版）','https://online-teach-file.oss-cn-beijing.aliyuncs.com/cover/2021/08/10/f2cd321f-6378-4e92-8515-0b8f42f2770b.jpg','0','0',1,'http://item.gmall.com/18.html','1',1,'','2021-11-08 06:12:05','2021-11-08 06:12:05',0),(5,5,15,'  14417人 分享 收藏 SpringMVC','https://online-teach-file.oss-cn-beijing.aliyuncs.com/cover/2021/08/09/273ddd90-5ef7-40e5-9ffd-86e8175fc229.jpg','22800','22800',1,'http://glkt.atguigu.cn/#/courseInfo/15','1',1,'','2021-11-09 07:54:01','2021-11-09 07:54:01',0),(6,6,19,'JAVA之Mysql基础','http://47.93.148.192:9000/gmall/20211122/1504320cbe2b246514.jpg','1000','1000',1,'http://glkt.atguigu.cn/#/courseInfo/19','1',1,'','2021-11-22 13:32:13','2021-11-22 13:32:13',0),(7,6,18,'Java精品课程','https://online-teach-file.oss-cn-beijing.aliyuncs.com/cover/2021/08/09/e4ee03d7-52bd-41ca-99f9-04dc23250a71.jpg','22800','22800',1,'http://glkt.atguigu.cn/#/courseInfo/18','1',1,'','2021-11-22 13:32:13','2021-11-22 13:32:13',0),(8,7,19,'JAVA之Mysql基础','http://47.93.148.192:9000/gmall/20211122/1504320cbe2b246514.jpg','1000','1000',1,'http://glkt.atguigu.cn/#/courseInfo/19','1',1,'','2021-11-23 10:42:01','2021-11-23 10:42:01',0),(9,7,15,'  14417人 分享 收藏 SpringMVC','https://online-teach-file.oss-cn-beijing.aliyuncs.com/cover/2021/08/09/273ddd90-5ef7-40e5-9ffd-86e8175fc229.jpg','22800','22800',1,'http://glkt.atguigu.cn/#/courseInfo/15','1',1,'','2021-11-23 10:42:01','2021-11-23 10:42:01',0),(10,8,19,'JAVA之Mysql基础','http://47.93.148.192:9000/gmall/20211122/1504320cbe2b246514.jpg','1000','1000',1,'http://glkt.atguigu.cn/#/courseInfo/19','1',1,'','2021-11-26 09:20:07','2021-11-26 09:20:07',0),(11,8,15,'  14417人 分享 收藏 SpringMVC','https://online-teach-file.oss-cn-beijing.aliyuncs.com/cover/2021/08/09/273ddd90-5ef7-40e5-9ffd-86e8175fc229.jpg','22800','22800',1,'http://glkt.atguigu.cn/#/courseInfo/15','1',1,'','2021-11-26 09:20:07','2021-11-26 09:20:07',0);

/*Table structure for table `live_visitor` */

DROP TABLE IF EXISTS `live_visitor`;

CREATE TABLE `live_visitor` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `live_course_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '直播课程id',
  `course_name` varchar(100) DEFAULT NULL,
  `user_id` varchar(50) NOT NULL DEFAULT '0' COMMENT '来访者用户id',
  `nick_name` varchar(100) DEFAULT NULL COMMENT '昵称',
  `join_time` varchar(30) DEFAULT NULL COMMENT '进入时间',
  `leave_time` varchar(30) DEFAULT NULL COMMENT '离开的时间',
  `location` varchar(50) DEFAULT NULL COMMENT '用户地理位置',
  `duration` bigint(20) DEFAULT NULL COMMENT '用户停留的时间(单位：秒)',
  `duration_time` varchar(30) DEFAULT NULL COMMENT '用户停留时间(时分秒)',
  `live_visitor_id` varchar(50) DEFAULT NULL COMMENT '平台来访者id，去重使用',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_live_visitor_id` (`live_visitor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COMMENT='直播来访者记录表';

/*Data for the table `live_visitor` */

insert  into `live_visitor`(`id`,`live_course_id`,`course_name`,`user_id`,`nick_name`,`join_time`,`leave_time`,`location`,`duration`,`duration_time`,`live_visitor_id`,`create_time`,`update_time`,`is_deleted`) values (6,1,'Spring Cloud深入源码讲解','1','晴天','2021-11-08 14:41:43','2021-11-08 14:48:05','中国北京北京',382,'00:06:22','220172045','2021-11-11 08:01:42','2021-11-11 08:01:42',0),(7,1,'Spring Cloud深入源码讲解','zb_xid_508954845','钟老师','2021-11-08 14:41:44','2021-11-08 14:47:47','中国四川成都',363,'00:06:03','220172043','2021-11-11 08:01:42','2021-11-11 08:01:42',0),(8,1,'Spring Cloud深入源码讲解','4','晴天','2021-11-08 14:10:06','2021-11-08 14:25:23','中国四川成都',917,'00:15:17','220171079','2021-11-11 08:01:42','2021-11-11 08:01:42',0),(9,1,'Spring Cloud深入源码讲解','zb_xid_508954845','钟老师','2021-11-08 14:04:41','2021-11-08 14:35:09','中国四川成都',1828,'00:30:28','220171077','2021-11-11 08:01:42','2021-11-11 08:01:42',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
```



## 1 欢拓云直播

- 欢拓云直播平台：欢拓是一家以直播技术为核心的网络平台，旨在帮助人们通过网络也能实现真实互动通讯。
- 官网：`https://www.talk-fun.com/`
- 接口文档地址：`http://open.talk-fun.com/docs/getstartV2/document.html`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1666951226796-b769beb1-15da-45d5-9552-ec5a0d5d2213.png)



### 1.1 创建直播

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667054845082-eeaee744-86de-449e-a513-e7dbfe2a4350.png)

此处为语雀加密文本卡片，点击链接查看：https://www.yuque.com/lingchen-bf1rc/hoahc6/uvmgv5#vC9Ny



### 1.2 观看直播

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667055262482-b5de6e9c-3219-4da8-a090-ce134f483a1c.png)



![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667055292313-4f853ef9-8c20-4a47-98e7-d12f447c1c53.png)



### 1.3 获取 `open id` 和 `open taken`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667055692709-05a8a9a3-2700-4c8d-b6c1-1231368dbf84.png)



### 1.4 下载 `SDK`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667056131306-71afa34c-772d-444d-9a2b-9ab27af3e9c7.png)



## 2 新建模块 `service_live`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667057411533-d6b3c1bd-c55b-44c3-9800-95b9d7afe29d.png)

### 2.1 依赖

```xml
  	<dependencies>
			<!-- 直播  -->
			<dependency>
			    <groupId>commons-httpclient</groupId>
			    <artifactId>commons-httpclient</artifactId>
			    <version>3.0.1</version>
			</dependency>
			<dependency>
			    <groupId>net.sf.json-lib</groupId>
			    <artifactId>json-lib</artifactId>
			    <version>2.4</version>
			    <classifier>jdk15</classifier>
			</dependency>
		</dependencies>

   <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
        <resources>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.yml</include>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>false</filtering>
            </resource>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.yml</include>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>false</filtering>
            </resource>
        </resources>
    </build>
```



### 2.2 复制 `SDK` 文件到项目中

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667056403465-449428bd-23f0-4e9b-8263-545f970c7f0f.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667057691049-76b5fae5-c69c-4ed1-a5f6-276960ea3cea.png)

- 修改 `MTCloud` 中导入 `MD5Util` 的路径
- 填写`id` 和 `token`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667060381200-1bedbf6e-3733-416e-a4c9-de7a679c859e.png)

### 2.3 新建 `application.yml`

```yaml
# 服务端口
server:
  port: 8306

spring:
  application:
    name: service-live
  # 环境设置：dev、test、prod
  profiles:
    active:
      dev
  # mysql数据库连接
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://localhost:3306/glkt_live?characterEncoding=utf-8&useSSL=false
    username: root
    password: 12345678
  # 返回json的全局时间格式
  jackson:
    date-format: yyyy-MM-dd HH:mm:ss
    time-zone: GMT+8
  # nacos 地址
  cloud:
    nacos:
      discovery:
        server-addr: 127.0.0.1:8848

# mybatis 日志
mybatis-plus:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
  mapper-locations: classpath:com/atguigu/ggkt/live/mapper/xml/*.xml
```



### 2.4 启动类

```java
package com.atguigu.ggkt.live;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 陈江林
 * @date 2022/10/29 23:41
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.atguigu")
@ComponentScan(basePackages = "com.atguigu")
@MapperScan("com.atguigu.ggkt.live.mapper")
public class ServiceLiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceLiveApplication.class, args);
    }

}
```



### 2.5 生成代码

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667264905443-82f19c84-dcd9-41d9-841a-2984df51c4f7.png)

- 数据库: `glkt_live`
- 表: `strategy.setInclude("live_course", "live_course_account", "live_course_config", "live_course_description", "live_course_goods", "live_visitor");`
- 模块名: `pc.setModuleName("live");`

#### 2.5.1 修改控制层

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667266487811-3315a0ae-d589-4444-aab4-38ea4a4f8f7b.png)

- 留这两个



#### 2.5.2 删除 `entity`, 修改所有生成文件中对应 `entity`的引用



### 2.6 网关配置

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667267040089-1fb0d34d-47e5-4610-a95d-564619b4a0f7.png)

```yaml
{ id: service-live, uri: lb://service-live, predicates: Path=/**/live/** }
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667267090985-b0ba0f22-f934-4617-9cc6-906aad446f57.png)





## 3 直播课程列表

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667266925816-4b15ad67-f86a-479e-b484-cd3e4e43f954.png)

### 3.1 接口

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667270612254-7561d09d-8928-4d65-bacf-5e50a3398a66.png)

#### 3.1.1 控制层

```java
package com.atguigu.ggkt.live.controller;

import com.atguigu.ggkt.live.service.LiveCourseService;
import com.atguigu.ggkt.model.live.LiveCourse;
import com.atguigu.ggkt.result.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 直播课程表 前端控制器
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-01
 */
@Api(tags = "直播课程表")
@RestController
@RequestMapping("/admin/live/liveCourse")
public class LiveCourseController {

    @Autowired
    private LiveCourseService liveCourseService;

    @ApiOperation("直播课程列表分页数据")
    @GetMapping("/{page}/{limit}")
    public Result<IPage<LiveCourse>> list(
            @ApiParam(value = "当前页", required = true)
            @PathVariable("page") Long page,
            @ApiParam(value = "每页显示条数", required = true)
            @PathVariable("limit") Long limit
    ) {
        Page<LiveCourse> pageParam = new Page<>(page, limit);
        IPage<LiveCourse> pageModel = liveCourseService.selectPage(pageParam);
        return Result.ok(pageModel);
    }

}
```



#### 3.1.2 服务接口

```java
package com.atguigu.ggkt.live.service;

import com.atguigu.ggkt.model.live.LiveCourse;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 直播课程表 服务类
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-01
 */
public interface LiveCourseService extends IService<LiveCourse> {

    /**
     * 直播课程列表分页数据
     *
     * @param pageParam
     * @return
     */
    IPage<LiveCourse> selectPage(Page<LiveCourse> pageParam);

}
```



#### 3.1.3 服务实现类

```java
package com.atguigu.ggkt.live.service.impl;

import com.atguigu.ggkt.client.course.CourseFeignClient;
import com.atguigu.ggkt.constant.GgktConstant;
import com.atguigu.ggkt.exception.GgktException;
import com.atguigu.ggkt.live.mapper.LiveCourseMapper;
import com.atguigu.ggkt.live.service.LiveCourseService;
import com.atguigu.ggkt.model.live.LiveCourse;
import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.ggkt.result.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 直播课程表 服务实现类
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-01
 */
@Service
public class LiveCourseServiceImpl extends ServiceImpl<LiveCourseMapper, LiveCourse> implements LiveCourseService {

    @Autowired
    private CourseFeignClient courseFeignClient;

    @Override
    public IPage<LiveCourse> selectPage(Page<LiveCourse> pageParam) {
        // 分页查询
        Page<LiveCourse> liveCoursePage = baseMapper.selectPage(pageParam, Wrappers.emptyWrapper());
        // 遍历数据, 修改引用类型数据
        liveCoursePage.getRecords().forEach(liveCourse -> {
            // - 获取课程讲师信息
            //  - 获取讲师 id
            Long teacherId = liveCourse.getTeacherId();
            //  - 根据讲师 id 查询讲师信息（远程调用 vod 模块）
            Result<Teacher> teacherResult = courseFeignClient.getTeacherId(teacherId);
            if (!Result.SUCCESS_CODE.equals(teacherResult.getCode())) {
                throw new GgktException(Result.FAILED_CODE, GgktConstant.MESSAGE_METHOD_CALL);
            }

            // 得到数据
            Teacher teacher = teacherResult.getData();

            // - 向引用类型 map 中添加数据
            liveCourse.getParam().put("teacherName", teacher.getName());
            liveCourse.getParam().put("teacherLevel", teacher.getLevel());
        });

        return liveCoursePage;
    }

}
```



### 3.2 远程接口

#### 3.2.1 `service_live` 添加依赖

```xml
<!-- 远程接口 -->
<dependency>
    <groupId>com.atguigu</groupId>
    <artifactId>service_course_client</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```



#### 3.2.2 定义接口

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667268696965-63437e15-e0a6-48a8-8713-8ffc77a2f4cc.png)

```java
    /**
     * 根据 id 查询讲师
     *
     * @param id
     * @return {@link Result}<{@link Teacher}>
     */
    @GetMapping("/admin/vod/teacher/get/{id}")
    Result<Teacher> get(@PathVariable Long id);
```



### 3.3 全局统一返回结果

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667269529749-f427e9aa-f3f6-4cbf-9802-0565ea85eb00.png)

```java
package com.atguigu.ggkt.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 结果
 * 统一返回结果类, 全局统一返回结果
 *
 * @author 陈江林
 * @date 2022/10/2 09:36
 */
@ApiModel(value = "全局统一返回结果")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    public static final String SUCCESS = "成功";
    public static final String FAILED = "失败";
    public static final Integer SUCCESS_CODE = 20000;
    public static final Integer FAILED_CODE = 20001;

    /**
     * 状态码
     */
    @ApiModelProperty(value = "返回码")
    private Integer code;

    /**
     * 返回消息（成功、失败...）
     */
    @ApiModelProperty(value = "返回消息")
    private String message;

    /**
     * 返回数据
     */
    @ApiModelProperty(value = "返回数据")
    private T data;

    /**
     * 成功的方法, 没有 data 数据
     *
     * @return {@link Result}<{@link T}>
     */
    public static <T> Result<T> ok() {
        return Result.ok(null);
    }

    /**
     * 成功的方法, 有 data 数据
     *
     * @return {@link Result}<{@link T}>
     */
    public static <T> Result<T> ok(T data) {
        return new Result<>(SUCCESS_CODE, SUCCESS, data);
    }

    /**
     * 失败的方法, 没有 data 数据
     *
     * @return {@link Result}<{@link T}>
     */
    public static <T> Result<T> fail() {
        return Result.fail(null);
    }

    /**
     * 失败的方法, 有 data 数据
     *
     * @return {@link Result}<{@link T}>
     */
    public static <T> Result<T> fail(T data) {
        return new Result<>(FAILED_CODE, FAILED, data);
    }

    /**
     * 修改状态码
     *
     * @param code 状态码
     * @return {@link Result}<{@link T}>
     */
    public Result<T> code(Integer code) {
        this.setCode(code);
        return this;
    }

    /**
     * 修改消息
     *
     * @param message 消息
     * @return {@link Result}<{@link T}>
     */
    public Result<T> message(String message) {
        this.setMessage(message);
        return this;
    }

}
```



### 3.4 常量类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667270289505-88af1cec-5ff2-450e-9323-65f8984dd172.png)

```java
package com.atguigu.ggkt.constant;

/**
 * 硅谷课堂 常量类
 *
 * @author 陈江林
 * @date 2022/11/1 10:30
 */
public class GgktConstant {

    /**
     * 远程接口调用异常消息
     */
    public static final String MESSAGE_METHOD_CALL = "内部方法调用失败!";

}
```



## 4 直播课程添加

### 4.1 接口

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667270612254-7561d09d-8928-4d65-bacf-5e50a3398a66.png)

#### 4.1.1 控制类

```java
    @ApiOperation("直播课程添加")
    @PostMapping("/save")
    public Result save(
            @ApiParam(value = "直播课程表单视图对象")
            @RequestBody LiveCourseFormVo liveCourseFormVo
    ) {
        liveCourseService.saveLive(liveCourseFormVo);
        return Result.ok();
    }
```



#### 4.1.2 服务接口

```java
    /**
     * 直播课程添加
     *
     * @param liveCourseFormVo 直播课程表单视图对象
     */
    void saveLive(LiveCourseFormVo liveCourseFormVo);
```



#### 4.1.3 服务实现类

```java
    @Override
    public void saveLive(LiveCourseFormVo liveCourseFormVo) {
        if (liveCourseFormVo == null) {
            throw new GgktException(Result.FAILED_CODE, GgktConstant.MESSAGE_PARAM);
        }

        // liveCourseFormVo -> liveCourse
        // 创建直播课程对象
        LiveCourse liveCourse = new LiveCourse();
        // 复制属性
        BeanUtils.copyProperties(liveCourseFormVo, liveCourse);

        // - 获取讲师信息
        //  - 获取讲师 id
        Long teacherId = liveCourseFormVo.getTeacherId();
        //  - 根据讲师 id 查询讲师信息（远程调用 vod 模块）
        Result<Teacher> teacherResult = courseFeignClient.getTeacherId(teacherId);
        if (!Result.SUCCESS_CODE.equals(teacherResult.getCode())) {
            throw new GgktException(Result.FAILED_CODE, GgktConstant.MESSAGE_METHOD_CALL);
        }

        // 得到数据
        Teacher teacher = teacherResult.getData();

        // - 添加直播课程（第三方接口）
        //  - 创建 map 集合（其他参数）, 封装直播课程其他参数
        HashMap<Object, Object> options = new HashMap<>();
        // 直播类型。1: 教育直播，2: 生活直播。默认 1，说明：根据平台开通的直播类型填写
        options.put("scenes", 2);
        options.put("password", liveCourseFormVo.getPassword());

        try {
            String result = mtCloud.courseAdd(
                    liveCourse.getCourseName(),
                    teacher.getId().toString(),
                    new DateTime(liveCourse.getStartTime()).toString("yyyy-MM-dd HH:mm:ss"),
                    new DateTime(liveCourse.getEndTime()).toString("yyyy-MM-dd HH:mm:ss"),
                    teacher.getName(),
                    teacher.getIntro(),
                    options
            );

            // - 返回结果
            //  - 处理返回结果
            CommonResult<JSONObject> commonResult = JSON.parseObject(result, CommonResult.class);
            if (Integer.parseInt(commonResult.getCode()) != MTCloud.CODE_SUCCESS) {
                //  - 直播课程添加失败
                throw new GgktException(Result.FAILED_CODE, GgktConstant.MESSAGE_LIVE_COURSE);
            }

            //  - 直播课程添加成功
            // 得到返回数据
            JSONObject object = commonResult.getData();

            // - 添加直播基本信息
            //  - 获取直播课程 id
            Long course_id = object.getLong("course_id");
            liveCourse.setCourseId(course_id);
            // 保存信息
            baseMapper.insert(liveCourse);

            // - 添加直播描述信息
            // -- 创建直播课程描述对象
            LiveCourseDescription liveCourseDescription = new LiveCourseDescription();
            liveCourseDescription.setDescription(liveCourseFormVo.getDescription());
            liveCourseDescription.setLiveCourseId(liveCourse.getId());
            // 保存信息
            liveCourseDescriptionService.save(liveCourseDescription);

            // - 添加直播账号信息
            // -- 创建直播课程账户对象
            LiveCourseAccount liveCourseAccount = new LiveCourseAccount();
            liveCourseAccount.setLiveCourseId(liveCourse.getId());
            liveCourseAccount.setZhuboAccount(object.getString("bid"));
            liveCourseAccount.setZhuboPassword(liveCourseFormVo.getPassword());
            liveCourseAccount.setAdminKey(object.getString("admin_key"));
            liveCourseAccount.setUserKey(object.getString("user_key"));
            liveCourseAccount.setZhuboKey(object.getString("zhubo_key"));
            // 保存信息
            liveCourseAccountService.save(liveCourseAccount);
        } catch (Exception e) {
            throw new GgktException(Result.FAILED_CODE, GgktConstant.MESSAGE_LIVE_COURSE);
        }
    }
```



### 4.2 欢拓云属性配置类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667271387225-82d2bc22-6d65-4e54-b05b-e08b21393d94.png)

```java
package com.atguigu.ggkt.live.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 欢拓云 属性配置类
 *
 * @author 陈江林
 * @date 2022/11/1 10:51
 */
@Data
@Component
@ConfigurationProperties("mtcloud")
public class MTCloudProperties {

    /**
     * 合作方ID： 合作方在欢拓平台的唯一ID
     */
    private String openId;

    /**
     * 合作方秘钥： 合作方ID对应的参数加密秘钥
     */
    private String openToken;

}
```



#### 4.2.1 `application.yml` 配置

```yaml
# 欢拓云
mtcloud
  open-id: xxx
  open-token: xxx
```



### 4.3 欢拓云 `SDK` 配置类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667271626407-6e0ff9fa-d65a-4497-8d9d-14cf39287c66.png)

```java
package com.atguigu.ggkt.live.config;

import com.atguigu.ggkt.live.mtcloud.MTCloud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 欢拓云配置类
 * 
 * @author 陈江林
 * @date 2022/11/1 10:56
 */
@Configuration
public class MTCloudConfig {

    @Autowired
    private MTCloudProperties mtCloudProperties;

    @Bean
    public MTCloud mtCloudClient() {
        return new MTCloud(mtCloudProperties.getOpenId(),
                mtCloudProperties.getOpenToken());
    }

}
```



### 4.4 常量

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667274938431-73ce7a8c-ead8-416d-b7c4-941a97673c0a.png)

```java
public static final String MESSAGE_PARAM = "参数不合法!";
public static final String MESSAGE_LIVE_COURSE = "直播创建失败!";
```



## 5 直播课程删除

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667291523736-350574f4-6118-45ef-8ceb-d19b8d8a1153.png)

### 5.1 接口

#### 5.1.1 控制类

```java
@ApiOperation("直播课程删除")
@DeleteMapping("/remove/{id}")
public Result save(
        @ApiParam(value = "直播课程 id")
        @PathVariable Long id
) {
    liveCourseService.removeLiveById(id);
    return Result.ok();
}
```



#### 5.1.2 服务接口

```java
	/**
     * 直播课程删除
     *
     * @param id id
     */
    void removeLiveById(Long id);
```



#### 5.1.3 服务实现类

```java
    @Override
    public void removeLiveById(Long id) {
        // 根据 id 查询直播课程信息
        LiveCourse liveCourse = baseMapper.selectById(id);
        if (liveCourse == null) {
            throw new GgktException(Result.FAILED_CODE, GgktConstant.MESSAGE_PARAM);
        }

        // 获取直播课程 课程id
        Long courseId = liveCourse.getCourseId();
        try {
            // 删除直播课程（欢拓云接口）
            mtCloud.courseDelete(courseId.toString());
            // 删除本地数据
            // 删除直播基本信息
            baseMapper.deleteById(id);
            // - 删除直播描述信息
            //  - 创建条件对象
            LambdaQueryWrapper<LiveCourseDescription> wrapper = new LambdaQueryWrapper();
            wrapper.eq(LiveCourseDescription::getLiveCourseId, id);
            // 根据直播课程 id 删除
            liveCourseDescriptionService.remove(wrapper);

            // - 删除直播账号信息
            // 根据直播课程 id 删除
            liveCourseAccountService.remove(
                    new LambdaQueryWrapper<LiveCourseAccount>()
                            .eq(LiveCourseAccount::getLiveCourseId, id)
            );
        } catch (Exception e) {
            throw new GgktException(Result.FAILED_CODE, GgktConstant.MESSAGE_LIVE_COURSE_REMOVE);
        }
    }
```



### 5.2 常量

```java
public static final String MESSAGE_LIVE_COURSE_REMOVE = "删除直播课程失败!";
```



### 6 直播课程修改

### 6.1 接口

#### 6.1.1 控制层

```java
    @ApiOperation("直播课程修改")
    @PutMapping("/update")
    public Result update(
            @ApiParam(value = "直播课程表单视图对象")
            @RequestBody LiveCourseFormVo liveCourseFormVo
    ) {
        liveCourseService.updateLiveById(liveCourseFormVo);
        return Result.ok();
    }

    @ApiOperation("根据 id 查询直播课程信息")
    @GetMapping("/get/{id}")
    public Result<LiveCourse> get(
            @ApiParam(value = "直播课程 id")
            @PathVariable Long id
    ) {
        return Result.ok(liveCourseService.getById(id));
    }

    @ApiOperation("根据 id 查询直播课程信息和描述信息")
    @GetMapping("/getInfo/{id}")
    public Result<LiveCourseFormVo> getInfo(
            @ApiParam(value = "直播课程 id")
            @PathVariable Long id
    ) {
        return Result.ok(liveCourseService.getLiveCourseVo(id));
    }
```



#### 6.1.2 服务接口

```java
    /**
     * 根据 id 查询直播课程信息和描述信息
     *
     * @param id 课程 id
     * @return {@link LiveCourseFormVo}
     */
    LiveCourseFormVo getLiveCourseVo(Long id);

    /**
     * 直播课程修改
     *
     * @param liveCourseFormVo 直播课程表单视图对象
     */
    void updateLiveById(LiveCourseFormVo liveCourseFormVo);
```



#### 6.1.3 服务实现

```java
    @Override
    public LiveCourseFormVo getLiveCourseVo(Long id) {
        // 获取直播课程的基本信息
        LiveCourse liveCourse = baseMapper.selectById(id);

        // 获取直播课程的描述信息
        LiveCourseDescription liveCourseDescription = liveCourseDescriptionService.getOne(
                new LambdaQueryWrapper<LiveCourseDescription>()
                        .eq(LiveCourseDescription::getLiveCourseId, id)
        );

        // 创建视图对象
        LiveCourseFormVo liveCourseFormVo = new LiveCourseFormVo();
        BeanUtils.copyProperties(liveCourse, liveCourseFormVo);
        liveCourseFormVo.setDescription(liveCourseDescription.getDescription());
        return liveCourseFormVo;
    }

	@Override
    public void updateLiveById(LiveCourseFormVo liveCourseFormVo) {
        // LiveCourseFormVo -> LiveCourse
        LiveCourse liveCourse = new LiveCourse();
        BeanUtils.copyProperties(liveCourseFormVo, liveCourse);

        // 根据 id 获取直播课程基本信息
        //  - 根据讲师 id 查询讲师信息（远程调用 vod 模块）
        Result<Teacher> teacherResult = courseFeignClient.getTeacherId(liveCourseFormVo.getTeacherId());
        if (!Result.SUCCESS_CODE.equals(teacherResult.getCode())) {
            throw new GgktException(Result.FAILED_CODE, GgktConstant.MESSAGE_METHOD_CALL);
        }

        // 得到数据
        Teacher teacher = teacherResult.getData();

        HashMap<Object, Object> options = new HashMap<>();
        try {
            // 修改直播课程（欢拓云接口）
            String res = mtCloud.courseUpdate(liveCourse.getCourseId().toString(),
                    teacher.getId().toString(),
                    liveCourse.getCourseName(),
                    new DateTime(liveCourse.getStartTime()).toString("yyyy-MM-dd HH:mm:ss"),
                    new DateTime(liveCourse.getEndTime()).toString("yyyy-MM-dd HH:mm:ss"),
                    teacher.getName(),
                    teacher.getIntro(),
                    options);
            // 返回结果转换，判断是否成功
            CommonResult<JSONObject> commonResult = JSON.parseObject(res, CommonResult.class);
            if (Integer.parseInt(commonResult.getCode()) != MTCloud.CODE_SUCCESS) {
                throw new GgktException(Result.FAILED_CODE, GgktConstant.MESSAGE_LIVE_COURSE_UPDATE);
            }

            // 获取欢拓云返回结果
            JSONObject object = commonResult.getData();
            // 更新直播课程基本信息
            liveCourse.setCourseId(object.getLong("course_id"));
            baseMapper.updateById(liveCourse);
            // - 直播课程描述信息更新
            //  - 根据直播课程 id 获取直播课程描述信息
            LiveCourseDescription liveCourseDescription = liveCourseDescriptionService.getOne(
                    new LambdaQueryWrapper<LiveCourseDescription>()
                            .eq(LiveCourseDescription::getLiveCourseId, liveCourse.getId())
            );
            liveCourseDescription.setDescription(liveCourseFormVo.getDescription());
            //  - 修改操作
            liveCourseDescriptionService.updateById(liveCourseDescription);
        } catch (Exception e) {
            throw new GgktException(Result.FAILED_CODE, GgktConstant.MESSAGE_LIVE_COURSE_UPDATE);
        }
    }
```



### 6.2 常量

```java
public static final String MESSAGE_LIVE_COURSE_UPDATE = "修改直播课程失败!";
```



## 7 查看账号

### 7.1 接口

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667354048596-4b71dce7-a8cf-4979-bc65-8ccefb550b19.png)

#### 7.1.1 控制层

```java
    @Autowired
    private LiveCourseAccountService liveCourseAccountService;

    @ApiOperation("查询直播课程账号信息")
    @GetMapping("/getLiveCourseAccount/{id}")
    public Result<LiveCourseAccount> getLiveCourseAccount(
            @ApiParam(value = "直播课程 id")
            @PathVariable Long id
    ) {
        return Result.ok(liveCourseAccountService.getLiveCourseAccountByLiveCourseId(id));
    }
```



#### 7.1.2 服务接口

```java
    /**
     * 查询直播课程账号信息
     *
     * @param id 直播课程 id
     * @return {@link Object}
     */
    LiveCourseAccount getLiveCourseAccountByLiveCourseId(Long id);
```



#### 7.1.3 服务实现

```java
    @Override
    public LiveCourseAccount getLiveCourseAccountByLiveCourseId(Long id) {
        // 查询一条记录
        return baseMapper.selectOne(
                // 创建条件对象
                new LambdaQueryWrapper<LiveCourseAccount>()
                        // 直播课程 id
                        .eq(LiveCourseAccount::getLiveCourseId, id)
        );
    }
```



## 8 配置信息

### 8.1 查询配置信息

#### 8.1.1 控制层

```java
    @ApiOperation("获取直播配置信息")
    @GetMapping("/getCourseConfig/{id}")
    public Result<LiveCourseConfigVo> getCourseConfig(
            @ApiParam(value = "直播课程 id")
            @PathVariable Long id
    ) {
        return Result.ok(liveCourseService.getCourseConfigByLiveCourseId(id));
    }
```



#### 8.1.2 服务接口

```java
    /**
     * 根据直播课程 id 获取直播配置信息
     *
     * @param id 直播课程 id
     * @return {@link LiveCourseConfigVo} 直播课程配置视图对象
     */
    LiveCourseConfigVo getCourseConfigByLiveCourseId(Long id);
```



#### 8.1.3 服务实现

```java
    @Override
    public LiveCourseConfigVo getCourseConfigByLiveCourseId(Long id) {
        // 创建 LiveCourseConfigVo 直播课程配置视图对象
        LiveCourseConfigVo liveCourseConfigVo = new LiveCourseConfigVo();

        // 根据直播课程 id 查询配置信息
        LiveCourseConfig liveCourseConfig = liveCourseConfigService.getCourseConfigByLiveCourseId(id);
        if (liveCourseConfig == null) {
            // 返回空对象
            return liveCourseConfigVo;
        }

        // 将查询到的配置信息复制到视图对象中
        BeanUtils.copyProperties(liveCourseConfig, liveCourseConfigVo);
        // 根据直播课程 id 查询直播课程商品列表
        List<LiveCourseGoods> liveCourseGoodsList = liveCourseGoodsService.getLiveCourseGoodsListByLiveCourseId(id);
        // 将查询到的商品数据添加到视图对象中
        liveCourseConfigVo.setLiveCourseGoodsList(liveCourseGoodsList);

        return liveCourseConfigVo;
    }
```



#### 8.1.4 根据直播课程 id 查询配置信息

- 服务接口

```java
package com.atguigu.ggkt.live.service;

import com.atguigu.ggkt.model.live.LiveCourseConfig;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 直播课程配置表 服务类
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-01
 */
public interface LiveCourseConfigService extends IService<LiveCourseConfig> {

    /**
     * 根据直播课程 id 查询配置信息
     *
     * @param id 直播课程 id
     * @return {@link LiveCourseConfig}
     */
    LiveCourseConfig getCourseConfigByLiveCourseId(Long id);
}
```

- 服务实现

```java
package com.atguigu.ggkt.live.service.impl;

import com.atguigu.ggkt.live.mapper.LiveCourseConfigMapper;
import com.atguigu.ggkt.live.service.LiveCourseConfigService;
import com.atguigu.ggkt.model.live.LiveCourseConfig;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 直播课程配置表 服务实现类
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-01
 */
@Service
public class LiveCourseConfigServiceImpl extends ServiceImpl<LiveCourseConfigMapper, LiveCourseConfig> implements LiveCourseConfigService {

    @Override
    public LiveCourseConfig getCourseConfigByLiveCourseId(Long id) {
        return baseMapper.selectOne(
                new LambdaQueryWrapper<LiveCourseConfig>()
                        .eq(LiveCourseConfig::getLiveCourseId, id)
        );
    }

}
```



#### 8.1.5 根据直播课程 id 查询直播课程商品列表

- 服务接口

```java
package com.atguigu.ggkt.live.service;

import com.atguigu.ggkt.model.live.LiveCourseGoods;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 直播课程关联推荐表 服务类
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-01
 */
public interface LiveCourseGoodsService extends IService<LiveCourseGoods> {

    /**
     * 根据直播课程 id 查询直播课程商品列表
     *
     * @param id 直播课程 id
     * @return {@link List}<{@link LiveCourseGoods}>
     */
    List<LiveCourseGoods> getLiveCourseGoodsListByLiveCourseId(Long id) ;

}
```

- 服务实现

```java
package com.atguigu.ggkt.live.service.impl;

import com.atguigu.ggkt.live.mapper.LiveCourseGoodsMapper;
import com.atguigu.ggkt.live.service.LiveCourseGoodsService;
import com.atguigu.ggkt.model.live.LiveCourseGoods;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 直播课程关联推荐表 服务实现类
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-01
 */
@Service
public class LiveCourseGoodsServiceImpl extends ServiceImpl<LiveCourseGoodsMapper, LiveCourseGoods> implements LiveCourseGoodsService {

    @Override
    public List<LiveCourseGoods> getLiveCourseGoodsListByLiveCourseId(Long id) {
        // 查询所有记录
        return baseMapper.selectList(
                // 创建条件对象
                new LambdaQueryWrapper<LiveCourseGoods>()
                        // 直播课程 id
                        .eq(LiveCourseGoods::getLiveCourseId, id)
        );
    }

}
```



### 8.2 修改直播配置信息

#### 8.2.1 控制层

```java
    @ApiOperation("修改直播配置信息")
    @PutMapping("/updateConfig/{id}")
    public Result<LiveCourseConfigVo> updateConfig(
            @ApiParam(value = "直播课程配置视图对象")
            @PathVariable LiveCourseConfigVo liveCourseConfigVo
    ) {
        liveCourseService.updateConfig(liveCourseConfigVo);
        return Result.ok();
    }
```



#### 8.2.2 服务接口

```java
    /**
     * 修改直播配置信息
     *
     * @param liveCourseConfigVo 直播课程配置视图对象
     */
    void updateConfig(LiveCourseConfigVo liveCourseConfigVo);
```



#### 8.2.3 服务实现

```java
    @Override
    public void updateConfig(LiveCourseConfigVo liveCourseConfigVo) {
        // - 修改直播配置表
        //  - 创建直播课程配置对象
        LiveCourseConfig liveCourseConfig = new LiveCourseConfig();
        //  - 复制属性 LiveCourseConfigVo -> liveCourseConfig
        BeanUtils.copyProperties(liveCourseConfigVo, liveCourseConfig);
        //  - 判断是否有 id [{有id: 修改操作}, {无id: 添加操作}]
        /// if (liveCourseConfig.getId() != null) {
        ///     // 修改操作
        ///     liveCourseConfigService.updateById(liveCourseConfig);
        /// } else {
        ///     // 添加操作
        ///     liveCourseConfigService.save(liveCourseConfig);
        /// }
        // 简化
        liveCourseConfigService.saveOrUpdate(liveCourseConfig);

        // - 修改直播商品表
        //  - 根据直播课程 id 清空相关商品
        liveCourseGoodsService.remove(
                new LambdaQueryWrapper<LiveCourseGoods>()
                        .eq(LiveCourseGoods::getLiveCourseId, liveCourseConfigVo.getLiveCourseId())
        );

        //  - 批量添加商品
        List<LiveCourseGoods> liveCourseGoodsList = liveCourseConfigVo.getLiveCourseGoodsList();
        if (!CollectionUtils.isEmpty(liveCourseGoodsList)) {
            liveCourseGoodsService.saveBatch(liveCourseGoodsList);
        }

        // 调用欢拓云接口上传配置信息
        this.updateLifeConfig(liveCourseConfigVo);
    }

    /**
     * 上传直播配置
     *
     * @param liveCourseConfigVo
     */
    @SneakyThrows
    private void updateLifeConfig(LiveCourseConfigVo liveCourseConfigVo) {
        LiveCourse liveCourse = baseMapper.selectById(liveCourseConfigVo.getLiveCourseId());

        // 参数设置
        HashMap<Object, Object> options = new HashMap<>();
        // 界面模式
        options.put("pageViewMode", liveCourseConfigVo.getPageViewMode());
        // 观看人数开关
        JSONObject number = new JSONObject();
        number.put("enable", liveCourseConfigVo.getNumberEnable());
        options.put("number", number.toJSONString());
        // 观看人数开关
        JSONObject store = new JSONObject();
        number.put("enable", liveCourseConfigVo.getStoreEnable());
        number.put("type", liveCourseConfigVo.getStoreType());
        options.put("store", number.toJSONString());
        // 商城列表
        List<LiveCourseGoods> liveCourseGoodsList = liveCourseConfigVo.getLiveCourseGoodsList();
        if (!CollectionUtils.isEmpty(liveCourseGoodsList)) {
            List<LiveCourseGoodsView> liveCourseGoodsViewList = new ArrayList<>();
            liveCourseGoodsList.forEach(liveCourseGoods -> {
                LiveCourseGoodsView liveCourseGoodsView = new LiveCourseGoodsView();
                BeanUtils.copyProperties(liveCourseGoods, liveCourseGoodsView);
                liveCourseGoodsViewList.add(liveCourseGoodsView);
            });

            JSONObject goodsListEdit = new JSONObject();
            goodsListEdit.put("status", "0");
            options.put("goodsListEdit ", goodsListEdit.toJSONString());
            options.put("goodsList", JSON.toJSONString(liveCourseGoodsViewList));
        }

        String res = mtCloud.courseUpdateConfig(liveCourse.getCourseId().toString(), options);

        CommonResult<JSONObject> commonResult = JSON.parseObject(res, CommonResult.class);
        if (Integer.parseInt(commonResult.getCode()) != MTCloud.CODE_SUCCESS) {
            throw new GgktException(Result.FAILED_CODE, GgktConstant.MESSAGE_LIVE_Config_UPDATE);
        }
    }
```



## 9 获取最近直播课程

### 9.1 控制层

```java
    @ApiOperation("获取最近的直播")
    @GetMapping("/findLatelyList")
    public Result<List<LiveCourseVo>> getLatelyList() {
        return Result.ok(liveCourseService.getLatelyList());
    }
```



### 9.2 服务接口

```java
    /**
     * 获取最近的直播
     *
     * @return {@link List}<{@link LiveCourseVo}>
     */
    List<LiveCourseVo> getLatelyList();
```



### 9.3 服务实现

```java
    @Override
    public List<LiveCourseVo> getLatelyList() {
        return baseMapper.getLatelyList()
                .stream()
                .peek(liveCourseVo -> {
                    // 封装开始和结束时间
                    liveCourseVo.setStartTimeString(new DateTime(liveCourseVo.getStartTime()).toString("yyyy年MM月dd HH:mm"));
                    liveCourseVo.setEndTimeString(new DateTime(liveCourseVo.getEndTime()).toString("HH:mm"));

                    // 根据讲师 id 获取讲师对象
                    Long teacherId = liveCourseVo.getTeacherId();
                    Result<Teacher> teacherResult = courseFeignClient.getTeacherId(teacherId);
                    if (!Result.SUCCESS_CODE.equals(teacherResult.getCode())) {
                        throw new GgktException(Result.FAILED_CODE, GgktConstant.MESSAGE_METHOD_CALL);
                    }

                    // 得到数据
                    Teacher teacher = teacherResult.getData();
                    liveCourseVo.setTeacher(teacher);
                    // 封装直播状态 0：未开始 1：直播中 2：直播结束
                    liveCourseVo.setLiveStatus(this.getLiveStatus(liveCourseVo));
                }).collect(Collectors.toList());
    }

    /**
     * 直播状态 0：未开始 1：直播中 2：直播结束
     *
     * @param liveCourse
     * @return
     */
    private int getLiveStatus(LiveCourse liveCourse) {
        // 直播状态 0：未开始 1：直播中 2：直播结束
        int liveStatus = 0;
        Date curTime = new Date();
        if (DateUtil.dateCompare(curTime, liveCourse.getStartTime())) {
            liveStatus = 0;
        } else if (DateUtil.dateCompare(curTime, liveCourse.getEndTime())) {
            liveStatus = 1;
        } else {
            liveStatus = 2;
        }

        return liveStatus;
    }
```



### 9.4 `mapper` 接口

```java
package com.atguigu.ggkt.live.mapper;

import com.atguigu.ggkt.model.live.LiveCourse;
import com.atguigu.ggkt.vo.live.LiveCourseVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 直播课程表 Mapper 接口
 * </p>
 *
 * @author 陈江林
 * @since 2022-11-01
 */
public interface LiveCourseMapper extends BaseMapper<LiveCourse> {

    /**
     * 获取最近的直播
     *
     * @return {@link List}<{@link LiveCourseVo}>
     */
    List<LiveCourseVo> getLatelyList();

}
```



### 9.5 `mapper.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.atguigu.ggkt.live.mapper.LiveCourseMapper">

    <select id="getLatelyList" resultType="com.atguigu.ggkt.vo.live.LiveCourseVo">
        select id,
               course_id,
               course_name,
               start_time,
               end_time,
               teacher_id,
               cover,
               create_time,
               update_time,
               is_deleted
        from live_course
        where date(start_time) >= curdate() and is_deleted = 0
        order by id
        limit 5
    </select>

</mapper>
```



### 9.6 `DateUtil`

```java
package com.atguigu.ggkt.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期操作工具类
 */
public class DateUtil {

    private static final String dateFormat = "yyyy-MM-dd";
    private static final String timeFormat = "HH:mm:ss";

    /**
     * 格式化日期
     *
     * @param date
     * @return
     */
    public static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(date);

    }

    /**
     * 格式化日期
     *
     * @param date
     * @return
     */
    public static String formatTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);
        return sdf.format(date);

    }

    public static Date parseTime(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 截取比较断两个日期对象的field处的值 。
     * 如果第一个日期小于、等于、大于第二个，则对应返回负整数、0、正整数
     *
     * @param date1 第一个日期对象，非null
     * @param date2 第二个日期对象，非null
     * @param field Calendar中的阈值
     *              <p>
     *              date1 > date2  返回：1
     *              date1 = date2  返回：0
     *              date1 < date2  返回：-1
     */
//    public static int truncatedCompareTo(final Date date1, final Date date2, final int field) {
//        return DateUtils.truncatedCompareTo(date1, date2, field);
//    }

    /**
     * 比对日期与时间大小
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static boolean dateCompare(Date beginDate, Date endDate) {
        if (null == beginDate || null == endDate) return false;
        // endDate > beginDate
        if (endDate.getTime() > beginDate.getTime()) {
            return true;
        }
        return false;
    }

    /**
     * 比对日期与时间大小
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static boolean timeCompare(Date beginDate, Date endDate) {
        Calendar instance1 = Calendar.getInstance();
        //设置时间为当前时间
        instance1.setTime(beginDate);
        instance1.set(Calendar.YEAR, 0);
        instance1.set(Calendar.MONTH, 0);
        instance1.set(Calendar.DAY_OF_MONTH, 0);

        Calendar instance2 = Calendar.getInstance();
        //设置时间为当前时间
        instance2.setTime(endDate);
        instance2.set(Calendar.YEAR, 0);
        instance2.set(Calendar.MONTH, 0);
        instance2.set(Calendar.DAY_OF_MONTH, 0);
        // endDate > beginDate
//        if (DateUtil.truncatedCompareTo(instance1.getTime(), instance2.getTime(), Calendar.SECOND) == 1) {
//            return false;
//        }
        return true;
    }

}
```



## 10 获取所有课程

### 10.1 控制层

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667433353944-9d95d8a7-fd9a-4288-9d2a-0038adf91b4b.png)

```java
    @ApiOperation("查询所有课程")
    @GetMapping("/findAll")
    public Result<List<Course>> findAll() { 
        return Result.ok(courseService.findList());
    }
```



### 10.2 服务接口

```java
    /**
     * 查询所有课程
     *
     * @return {@link List}<{@link Course}>
     */
    List<Course> findList();
```



### 10.3 服务实现

```java
    @Override
    public List<Course> findList() {
        return baseMapper.selectList(null).stream().peek(course -> {
            // 封装数据
            // 根据讲师 id 获取讲师名称
            Teacher teacher = teacherService.getById(course.getTeacherId());
            if (teacher != null) {
                String name = teacher.getName();
                course.getParam().put("teacherName", name);
            }

            // 根据课程分类 id 获取课程分类名称
            Subject subjectOne = subjectService.getById(course.getSubjectParentId());
            if (subjectOne != null) {
                course.getParam().put("subjectParentTitle", subjectOne.getTitle());
            }

            Subject subjectTwo = subjectService.getById(course.getSubjectId());
            if (subjectTwo != null) {
                course.getParam().put("subjectTitle", subjectTwo.getTitle());
            }
        }).collect(Collectors.toList());
    }
```



### 10.4 后台管理系统-菜单管理-菜单列表

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667568967516-1f13effc-86c2-45b1-a359-94b41cc10d83.png)

```vue
<template>
  <div class="app-container">

    <!-- 工具条 -->
    <el-card class="operate-container" shadow="never">
      <i class="el-icon-tickets" style="margin-top: 5px"></i>
      <span style="margin-top: 5px">数据列表</span>
      <el-button class="btn-add" size="mini" @click="removeMenu" style="margin-left: 10px;">删除菜单</el-button>
      <el-button class="btn-add" size="mini" @click="syncMenu">同步菜单</el-button>
      <el-button class="btn-add" size="mini" @click="add">添 加</el-button>
    </el-card>

    <el-table
      :data="list"
      style="width: 100%;margin-bottom: 20px;"
      row-key="id"
      border
      default-expand-all
      :tree-props="{children: 'children'}">

      <el-table-column label="名称" prop="name" width="350"></el-table-column>
      <el-table-column label="类型" width="100">
        <template slot-scope="scope">
          {{ scope.row.type == 'view' ? '链接' : scope.row.type == 'click' ? '事件' : '' }}
        </template>
      </el-table-column>
      <el-table-column label="菜单URL" prop="url"></el-table-column>
      <el-table-column label="菜单KEY" prop="meunKey" width="130"></el-table-column>
      <el-table-column label="排序号" prop="sort" width="70"></el-table-column>
      <el-table-column label="操作" width="170" align="center">
        <template slot-scope="scope">
          <el-button v-if="scope.row.parentId > 0" type="text" size="mini" @click="edit(scope.row.id)">修改</el-button>
          <el-button v-if="scope.row.parentId > 0" type="text" size="mini" @click="removeDataById(scope.row.id)">删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog title="添加/修改" :visible.sync="dialogVisible" width="40%">
      <el-form ref="flashPromotionForm" label-width="150px" size="small" style="padding-right: 40px;">

        <el-form-item label="选择一级菜单">
          <el-select
            v-model="menu.parentId"
            placeholder="请选择">
            <el-option
              v-for="item in list"
              :key="item.id"
              :label="item.name"
              :value="item.id"/>
          </el-select>
        </el-form-item>
        <el-form-item v-if="menu.parentId == 1" label="菜单名称">
          <el-select
            v-model="menu.name"
            placeholder="请选择"
            @change="liveCourseChanged"
          >
            <el-option
              v-for="item in liveCourseList"
              :key="item.id"
              :label="item.courseName"
              :value="item"/>
          </el-select>
        </el-form-item>
        <el-form-item v-if="menu.parentId == 2" label="菜单名称">
          <el-select
            v-model="menu.name"
            placeholder="请选择"
            @change="subjectChanged">
            <el-option
              v-for="item in subjectList"
              :key="item.id"
              :label="item.title"
              :value="item"/>
          </el-select>
        </el-form-item>
        <el-form-item v-if="menu.parentId == 3" label="菜单名称">
          <el-input v-model="menu.name"/>
        </el-form-item>
        <el-form-item label="菜单类型">
          <el-radio-group v-model="menu.type">
            <el-radio label="view">链接</el-radio>
            <el-radio label="click">事件</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item v-if="menu.type == 'view'" label="链接">
          <el-input v-model="menu.url"/>
        </el-form-item>
        <el-form-item v-if="menu.type == 'click'" label="菜单KEY">
          <el-input v-model="menu.meunKey"/>
        </el-form-item>
        <el-form-item label="排序">
          <el-input v-model="menu.sort"/>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false" size="small">取 消</el-button>
        <el-button type="primary" @click="saveOrUpdate()" size="small">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>
<script>
import menuApi from '@/api/wechat/menu'
import liveCourseApi from '@/api/live/course'
import subjectApi from '@/api/vod/subject'

const defaultForm = {
  id: null,
  parentId: 1,
  name: '',
  nameId: null,
  sort: 1,
  type: 'view',
  meunKey: '',
  url: ''
}

export default {
  // 定义数据
  data() {
    return {
      list: [],
      liveCourseList: [],
      subjectList: [],
      dialogVisible: false,
      menu: defaultForm,
      saveBtnDisabled: false
    }
  },

  // 当页面加载时获取数据
  created() {
    this.fetchData()
    this.fetchLiveCourse()
    this.fetchSubject()
  },

  methods: {
    // 调用api层获取数据库中的数据
    fetchData() {
      console.log('加载列表')
      menuApi.findMenuInfo().then(response => {
        this.list = response.data
        console.log(this.list)
      })
    },

    fetchLiveCourse() {
      liveCourseApi.findLatelyList().then(response => {
        this.liveCourseList = response.data
        this.liveCourseList.push({'id': 0, 'courseName': '全部列表'})
      })
    },

    fetchSubject() {
      console.log('加载列表')
      subjectApi.getList(0).then(response => {
        this.subjectList = response.data
      })
    },

    removeMenu() {
      this.$confirm('你确定删除菜单吗, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        return menuApi.removeMenu();
      }).then((response) => {
        this.$message.success(response.message)
      }).catch(error => {
        console.log('error', error)
        // 当取消时会进入catch语句:error = 'cancel'
        // 当后端服务抛出异常时：error = 'error'
        if (error === 'cancel') {
          this.$message.info('取消')
        }
      })
    },

    syncMenu() {
      this.$confirm('你确定上传菜单吗, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        return menuApi.syncMenu();
      }).then((response) => {
        this.$message.success(response.message)
      }).catch(error => {
        console.log('error', error)
        // 当取消时会进入catch语句:error = 'cancel'
        // 当后端服务抛出异常时：error = 'error'
        if (error === 'cancel') {
          this.$message.info('取消上传')
        }
      })
    },

    // 根据id删除数据
    removeDataById(id) {
      // debugger
      this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => { // promise
        // 点击确定，远程调用ajax
        return menuApi.removeById(id)
      }).then((response) => {
        this.fetchData(this.page)
        if (response.code) {
          this.$message({
            type: 'success',
            message: '删除成功!'
          })
        }
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },

    // -------------
    add() {
      this.dialogVisible = true
      this.menu = Object.assign({}, defaultForm)
    },

    edit(id) {
      this.dialogVisible = true
      this.fetchDataById(id)
    },

    saveOrUpdate() {
      this.saveBtnDisabled = true // 防止表单重复提交

      if (!this.menu.id) {
        this.saveData()
      } else {
        this.updateData()
      }
    },

    // 新增
    saveData() {
      menuApi.save(this.menu).then(response => {
        if (response.code) {
          this.$message({
            type: 'success',
            message: response.message
          })

          this.dialogVisible = false;
          this.fetchData(this.page)
        }
      })
    },

    // 根据id更新记录
    updateData() {
      menuApi.updateById(this.menu).then(response => {
        if (response.code) {
          this.$message({
            type: 'success',
            message: response.message
          })
          this.dialogVisible = false;
          this.fetchData(this.page)
        }
      })
    },

    // 根据id查询记录
    fetchDataById(id) {
      menuApi.getById(id).then(response => {
        this.menu = response.data
      })
    },

    subjectChanged(item) {
      console.info(item)
      this.menu.name = item.title
      this.menu.url = '/course/' + item.id
    },

    liveCourseChanged(item) {
      console.info(item)
      this.menu.name = item.courseName
      if (item.id == 0) {
        this.menu.url = '/live'
      } else {
        this.menu.url = '/liveInfo/' + item.id
      }

    }
  }
}
</script>
```



## 11 后台管理系统-直播管理模块前端

### 11.1 配置路由

```javascript
  {
    path: '/live',
    component: Layout,
    redirect: '/live/course/list',
    name: 'Live',
    meta: {
      title: '直播管理',
      icon: 'el-icon-bangzhu'
    },
    alwaysShow: true,
    children: [
      {
        path: 'course/list',
        name: 'liveCourseList',
        component: () => import('@/views/live/course/List'),
        meta: { title: '直播列表' }
      },
      {
        path: 'course/config/:id',
        name: 'liveCourseConfig',
        component: () => import('@/views/live/course/Config'),
        meta: { title: '直播配置' },
        hidden: true
      },
      {
        path: 'visitor/list/:id',
        name: 'liveVisitor',
        component: () => import('@/views/live/visitor/List'),
        meta: { title: '观看记录' },
        hidden: true
      }
    ]
  },
```



### 11.2 新建页面

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667436433992-dc80ed7c-052d-4c7e-80d7-363de314e032.png)

#### 11.2.1 `course/List.vue`

```vue
<template>
  <div class="app-container">

    <!-- 工具条 -->
    <el-card class="operate-container" shadow="never">
      <i class="el-icon-tickets" style="margin-top: 5px"></i>
      <span style="margin-top: 5px">数据列表</span>
      <el-button class="btn-add" size="mini" @click="add">添 加</el-button>
    </el-card>

    <!-- banner列表 -->
    <el-table
      v-loading="listLoading"
      :data="list"
      stripe
      border
      style="width: 100%;margin-top: 10px;">

      <el-table-column
        label="序号"
        width="50"
        align="center">
        <template slot-scope="scope">
          {{ (page - 1) * limit + scope.$index + 1 }}
        </template>
      </el-table-column>
      <el-table-column label="封面" width="200" align="center">
        <template slot-scope="scope">
          <img :src="scope.row.cover" width="100%">
        </template>
      </el-table-column>
      <el-table-column prop="courseName" label="直播名称"/>
      <el-table-column prop="startTime" label="直播时间">
        <template slot-scope="scope">
          {{ scope.row.param.startTimeString }}至{{ scope.row.param.endTimeString }}
        </template>
      </el-table-column>
      <el-table-column prop="endTime" label="直播结束时间"/>
      <el-table-column prop="param.teacherName" label="直播老师"/>
      <el-table-column label="头衔" width="90">
        <template slot-scope="scope">
          <el-tag v-if="scope.row.param.teacherLevel === 1" type="success" size="mini">高级讲师</el-tag>
          <el-tag v-if="scope.row.param.teacherLevel === 0" size="mini">首席讲师</el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="createTime" label="创建时间"/>

      <el-table-column label="操作" width="200" align="center">
        <template slot-scope="scope">
          <el-button type="text" size="mini" @click="edit(scope.row.id)">修改</el-button>
          <el-button type="text" size="mini" @click="removeDataById(scope.row.id)">删除</el-button>
          <el-button type="text" size="mini" @click="showAccount(scope.row)">查看账号</el-button>
          <router-link :to="'/live/course/config/' + scope.row.id">
            <el-button type="text" size="mini">配置</el-button>
          </router-link>
          <router-link :to="'/live/visitor/list/' + scope.row.id">
            <el-button type="text" size="mini">观看记录</el-button>
          </router-link>
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页组件 -->
    <el-pagination
      :current-page="page"
      :total="total"
      :page-size="limit"
      :page-sizes="[5, 10, 20, 30, 40, 50, 100]"
      style="padding: 30px 0; text-align: center;"
      layout="sizes, prev, pager, next, jumper, ->, total, slot"
      @current-change="fetchData"
      @size-change="changeSize"
    />

    <el-dialog title="添加/修改" :visible.sync="dialogVisible" width="60%">
      <el-form ref="flashPromotionForm" label-width="150px" size="small" style="padding-right: 40px;">
        <!-- 课程讲师 -->
        <el-form-item label="直播讲师">
          <el-select
            v-model="liveCourse.teacherId"
            placeholder="请选择">
            <el-option
              v-for="teacher in teacherList"
              :key="teacher.id"
              :label="teacher.name"
              :value="teacher.id"/>
          </el-select>
        </el-form-item>
        <el-form-item label="直播讲师登录密码" v-if="liveCourse.id === ''">
          <el-input v-model="liveCourse.password"/>
        </el-form-item>
        <el-form-item label="直播名称">
          <el-input v-model="liveCourse.courseName"/>
        </el-form-item>
        <el-form-item label="直播开始时间">
          <el-date-picker
            v-model="liveCourse.startTime"
            type="datetime"
            placeholder="选择开始日期"
            value-format="yyyy-MM-dd HH:mm:ss"/>
        </el-form-item>
        <el-form-item label="直播结束时间">
          <el-date-picker
            v-model="liveCourse.endTime"
            type="datetime"
            placeholder="选择结束日期"
            value-format="yyyy-MM-dd HH:mm:ss"/>
        </el-form-item>
        <el-form-item label="直播封面">
          <el-upload
            :show-file-list="false"
            :on-success="handleCoverSuccess"
            :before-upload="beforeCoverUpload"
            :on-error="handleCoverError"
            :action="BASE_API+'/admin/vod/file/upload?module=cover'"
            class="cover-uploader">
            <img v-if="liveCourse.cover" :src="liveCourse.cover" width="60%">
            <i v-else class="el-icon-plus avatar-uploader-icon"/>
          </el-upload>
        </el-form-item>
        <el-form-item label="直播详情">
          <el-input v-model="liveCourse.description" type="textarea" rows="5"/>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false" size="small">取 消</el-button>
        <el-button type="primary" @click="saveOrUpdate()" size="small">确 定</el-button>
      </span>
    </el-dialog>

    <el-dialog title="查看账号" :visible.sync="accountDialogVisible" width="60%">
      <el-form ref="accountForm" label-width="150px" size="small" style="padding-right: 40px;">
        <div style="margin-left: 40px;">
          <h4>主播帮助信息</h4>
          <el-row style="height:35px;">
            <el-co>
              <span class="spd-info">主播登录链接：</span>
              <span class="spd-info">https://live.zhibodun.com/live/courseLogin.php?course_id={{
                  liveCourseAccount.courseId
                }}&role=admin</span>
            </el-co>
          </el-row>
          <el-row style="height:35px;">
            <el-col>
              <span class="spd-info">主播登录密码：{{ liveCourseAccount.zhuboKey }}</span>
            </el-col>
          </el-row>
        </div>
        <div style="margin-left: 40px;">
          <h4>主播客户端账号信息</h4>
          <el-row style="height:35px;">
            <el-col>
              <span class="spd-info">主播登录账户：{{ liveCourseAccount.zhuboAccount }}</span>
            </el-col>
          </el-row>
          <el-row style="height:35px;">
            <el-col>
              <span class="spd-info">主播登录密码：{{ liveCourseAccount.zhuboPassword }}</span>
            </el-col>
          </el-row>
        </div>

        <div style="margin-left: 40px;">
          <h4>助教信息</h4>
          <el-row style="height:35px;">
            <el-co>
              <span class="spd-info">助教登录连接：</span>
              <span class="spd-info">https://live.zhibodun.com/live/courseLogin.php?course_id={{
                  liveCourseAccount.courseId
                }}&role=admin</span>
            </el-co>
          </el-row>
          <el-row style="height:35px;">
            <el-col>
              <span class="spd-info">主播登录密码：{{ liveCourseAccount.adminKey }}</span>
            </el-col>
          </el-row>
        </div>
        <div style="margin-left: 40px;">
          <h4>学生观看信息</h4>
          <el-row style="height:35px;">
            <el-co>
              <span class="spd-info">观看连接：</span>
              <span class="spd-info">http://glkt-api.atguigu.cn/#/liveInfo/{{ liveCourseAccount.courseId }}</span>
            </el-co>
          </el-row>
          <el-row style="height:35px;">
            <el-col>
              <span class="spd-info">观看二维码：
                <!--                <img src="@/styles/qrcode.png" width="80px"/>-->
              </span>
            </el-col>
          </el-row>
        </div>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="accountDialogVisible = false" size="small">关 闭</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import api from '@/api/live/course'
import teacherApi from '@/api/vod/teacher'

const defaultForm = {
  id: '',
  courseName: '',
  startTime: '',
  endTime: '',
  teacherId: '',
  password: '',
  description: '',
  cover: 'https://cdn.uviewui.com/uview/swiper/1.jpg'
}
export default {
  data() {
    return {
      BASE_API: process.env.VUE_APP_BASE_API,
      listLoading: true, // 数据是否正在加载
      list: null, // banner列表
      total: 0, // 数据库中的总记录数
      page: 1, // 默认页码
      limit: 10, // 每页记录数
      searchObj: {}, // 查询表单对象

      teacherList: [], // 讲师列表

      dialogVisible: false,
      liveCourse: defaultForm,
      saveBtnDisabled: false,

      accountDialogVisible: false,
      liveCourseAccount: {
        courseId: ''
      }
    }
  },

  // 生命周期函数：内存准备完毕，页面尚未渲染
  created() {
    console.log('list created......')
    this.fetchData()

    // 获取讲师列表
    this.initTeacherList()
  },

  // 生命周期函数：内存准备完毕，页面渲染成功
  mounted() {
    console.log('list mounted......')
  },

  methods: {

    // 当页码发生改变的时候
    changeSize(size) {
      console.log(size)
      this.limit = size
      this.fetchData(1)
    },

    // 加载banner列表数据
    fetchData(page = 1) {
      console.log('翻页。。。' + page)
      // 异步获取远程数据（ajax）
      this.page = page

      api.getPageList(this.page, this.limit).then(
        response => {
          this.list = response.data.records
          this.total = response.data.total

          // 数据加载并绑定成功
          this.listLoading = false
        }
      )
    },

    // 获取讲师列表
    initTeacherList() {
      teacherApi.getAllTeacher().then(response => {
        this.teacherList = response.data
      })
    },

    // 重置查询表单
    resetData() {
      console.log('重置查询表单')
      this.searchObj = {}
      this.fetchData()
    },

    // 根据id删除数据
    removeDataById(id) {
      // debugger
      this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => { // promise
        // 点击确定，远程调用ajax
        return api.removeById(id)
      }).then((response) => {
        this.fetchData(this.page)
        if (response.code) {
          this.$message({
            type: 'success',
            message: '删除成功!'
          })
        }
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },

    // -------------
    add() {
      this.dialogVisible = true
      this.liveCourse = Object.assign({}, defaultForm)
    },

    edit(id) {
      this.dialogVisible = true
      this.fetchDataById(id)
    },
    //
    // fetchDataById(id) {
    //   api.getById(id).then(response => {
    //     this.liveCourse = response.data
    //   })
    // },

    saveOrUpdate() {
      this.saveBtnDisabled = true // 防止表单重复提交
      if (!this.liveCourse.id) {
        this.saveData()
      } else {
        this.updateData()
      }
    },

    // 新增
    saveData() {
      api.save(this.liveCourse).then(response => {
        if (response.code) {
          this.$message({
            type: 'success',
            message: response.message
          })
          this.dialogVisible = false
          this.fetchData(this.page)
        }
      })
    },

    // 根据id更新记录
    updateData() {
      api.updateById(this.liveCourse).then(response => {
        if (response.code) {
          this.$message({
            type: 'success',
            message: response.message
          })
          this.dialogVisible = false
          this.fetchData(this.page)
        }
      })
    },

    // 根据id查询记录
    fetchDataById(id) {
      api.getById(id).then(response => {
        this.liveCourse = response.data
      })
    },

    showAccount(row) {
      this.accountDialogVisible = true
      api.getLiveCourseAccount(row.id).then(response => {
        this.liveCourseAccount = response.data
        this.liveCourseAccount.courseId = row.courseId
      })
    },

    // ------------upload------------
    // 上传成功回调
    handleCoverSuccess(res, file) {
      this.liveCourse.cover = res.data
    },

    // 上传校验
    beforeCoverUpload(file) {
      const isJPG = file.type === 'image/jpeg'
      const isLt2M = file.size / 1024 / 1024 < 2

      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!')
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!')
      }
      return isJPG && isLt2M
    },

    // 错误处理
    handleCoverError() {
      console.log('error')
      this.$message.error('上传失败2')
    },
  }
}
</script>

<style scoped>
.cover-uploader .avatar-uploader-icon {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;

  font-size: 28px;
  color: #8c939d;
  width: 450px;
  height: 200px;
  line-height: 200px;
  text-align: center;
}

.cover-uploader .avatar-uploader-icon:hover {
  border-color: #409EFF;
}

.cover-uploader img {
  width: 450px;
  height: 200px;
  display: block;
}
</style>
```



#### 11.2.2 `Config.vue`

```vue
<template>
  <div class="app-container">
    <el-form label-width="120px" size="small">

      <div style="background-color:#E0E0E0;width: 100%;padding: 1px 10px;margin: 10px 0;"><h3>
        功能设置&nbsp;&nbsp;&nbsp;
      </h3></div>
      <el-form-item label="界面模式">
        <el-radio-group v-model="liveCourseConfigVo.pageViewMode">
          <el-radio :label="1">全屏模式</el-radio>
          <el-radio :label="0">二分屏</el-radio>
          <el-radio :label="2">课件模式</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="观看人数开关">
        <el-radio-group v-model="liveCourseConfigVo.numberEnable">
          <el-radio :label="1">是</el-radio>
          <el-radio :label="0">否</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="商城开关:">
        <el-radio-group v-model="liveCourseConfigVo.storeEnable">
          <el-radio :label="1">是</el-radio>
          <el-radio :label="0">否</el-radio>
        </el-radio-group>
      </el-form-item>

      <div style="background-color:#E0E0E0;width: 100%;padding: 1px 10px;margin: 10px 0;"><h3>
        商品列表&nbsp;&nbsp;&nbsp;
        <el-button type="" size="mini" @click="addCourse()">添加</el-button>
      </h3></div>
      <el-table
        v-loading="listLoading"
        :data="liveCourseConfigVo.liveCourseGoodsList"
        stripe
        border
        style="width: 100%;margin-top: 10px;">
        <el-table-column
          label="序号"
          width="70"
          align="center">
          <template slot-scope="scope">
            {{ scope.$index + 1 }}
          </template>
        </el-table-column>
        <el-table-column label="商品图片" width="120" align="center">
          <template slot-scope="scope">
            <img :src="scope.row.img" width="80px">
          </template>
        </el-table-column>
        <el-table-column prop="name" label="名称" width="100"/>
        <el-table-column prop="price" label="价格" width="100"/>
        <el-table-column prop="originalPrice" label="原价"/>
        <el-table-column label="操作" width="100" align="center">
          <template slot-scope="scope">
            <el-button type="text" size="mini" @click="removeCourseById(scope.$index)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>

      <el-dialog title="添加课程" :visible.sync="dialogVisible" width="50%">
        <el-form :inline="true" label-width="150px" size="small" style="padding-right: 40px;">
          <el-table
            v-loading="listLoading"
            :data="courseList"
            stripe
            border
            style="width: 100%;margin-top: 10px;"
            @selection-change="handleSelectionChange">
            <el-table-column
              type="selection"
              width="55" />
            <el-table-column
              label="序号"
              width="70"
              align="center">
              <template slot-scope="scope">
                {{ scope.$index + 1 }}
              </template>
            </el-table-column>
            <el-table-column label="分类">
              <template slot-scope="scope">
                {{ scope.row.param.subjectParentTitle }} > {{ scope.row.param.subjectTitle }}
              </template>
            </el-table-column>
            <el-table-column prop="title" label="课程名称" width="150"/>
            <el-table-column prop="lessonNum" label="课时" width="100"/>
            <el-table-column prop="param.teacherName" label="讲师"/>
          </el-table>
          <el-form-item style="margin-top: 10px;">
            <el-button type="" @click="dialogVisible = false">取消</el-button>
            <el-button type="" @click="selectCourse()">保存</el-button>
          </el-form-item>
        </el-form>
      </el-dialog>

      <br/><br/>
      <el-form-item>
        <el-button type="primary" @click="saveOrUpdate">保存</el-button>
        <el-button @click="back">返回</el-button>
      </el-form-item>
    </el-form>

  </div>
</template>

<script>
import api from '@/api/live/course'
import courseApi from '@/api/vod/course'

const defaultForm = {
  id: '',
  liveCourseId: '',
  pageViewMode: 1,
  numberEnable: 1,
  storeEnable: 1,
  storeType: 1,
  liveCourseGoodsList: []
}

export default {
  data() {
    return {
      listLoading: true, // 数据是否正在加载

      liveCourseConfigVo: defaultForm,
      saveBtnDisabled: false,

      dialogVisible: false,
      courseList: [],
      multipleSelection: [] // 批量选择中选择的记录列表
    }
  },

  // 监听器
  watch: {
    $route(to, from) {
      console.log('路由变化......')
      console.log(to)
      console.log(from)
      this.init()
    }
  },

  // 生命周期方法（在路由切换，组件不变的情况下不会被调用）
  created() {
    console.log('form created ......')
    this.init()
  },

  methods: {

    // 表单初始化
    init() {
      this.liveCourseConfigVo.liveCourseId = this.$route.params.id
      this.fetchDataById(this.liveCourseConfigVo.liveCourseId)

      this.fetchCourseList()
    },

    back() {
      this.$router.push({ path: '/live/course/list' })
    },

    // 根据id查询记录
    fetchDataById(id) {
      api.getCourseConfig(id).then(response => {
        if(null !== response.data.id) {
          this.liveCourseConfigVo = response.data
        }
        this.listLoading = false
      })
    },

    fetchCourseList() {
      courseApi.findAll().then(response => {
        //debugger
        this.courseList = response.data
      })
    },

    handleSelectionChange(selection) {
      console.log(selection)
      this.multipleSelection = selection
    },

    addCourse() {
      this.dialogVisible = true
    },

    selectCourse() {
      if (this.multipleSelection.length === 0) {
        this.$message({
          type: 'warning',
          message: '请选择对应课程!'
        })
        return
      }
      var list = []
      this.multipleSelection.forEach(item => {
        var obj = {
          liveCourseId: this.liveCourseConfigVo.liveCourseId,
          goodsId: item.id,
          name: item.title,
          img: item.cover,
          price: item.price,
          originalPrice: item.price,
          tab: '1',
          url: 'http://glkt-api.atguigu.cn/#/courseInfo/' + item.id,
          putaway: '1',
          pay: '1',
          qrcode: ''
        }
        list.push(obj)
      })
      this.liveCourseConfigVo.liveCourseGoodsList = list
      this.dialogVisible = false
    },

    removeCourseById(index) {
      this.liveCourseConfigVo.liveCourseGoodsList.splice(index, 1)
    },

    saveOrUpdate() {
      api.updateConfig(this.liveCourseConfigVo).then(response => {
        this.$message({
          type: 'success',
          message: response.message
        })

        this.$router.push({ path: '/live/course/list' })
      })
    }
  }
}
</script>

<style scoped>

.littleMarginTop {
  margin-top: 10px;
}

.paramInput {
  width: 250px;
}

.paramInputLabel {
  display: inline-block;
  width: 100px;
  text-align: right;
  padding-right: 10px
}

.cardBg {
  background: #F8F9FC;
}
</style>
```



### 11.3 `API`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667437129036-3d76341e-6ed2-42e1-a0af-2dafbaaf7fce.png)

```javascript
import request from '@/utils/request'

const api_name = '/admin/vod/course'

export default {
  //课程列表
  getPageList(page, limit, params) {
    return request({
      url: `${api_name}/${page}/${limit}`,
      method: 'get',
      params
    })
  },
  //添加课程基本信息
  saveCourseInfo(data) {
    return request({
      url: `${api_name}/save`,
      method: 'post',
      data
    })
  },
  // 根据 id 获取课程信息
  getCourseInfoById(id) {
    return request({
      url: `${api_name}/get/${id}`,
      method: 'get'
    })
  },
  // 根据 id 修改课程信息
  updateCourseInfoById(data) {
    return request({
      url: `${api_name}/update`,
      method: 'put',
      data
    })
  },
  //获取发布课程信息
  getCoursePublishById(id) {
    return request({
      url: `${api_name}/getCoursePublishVo/${id}`,
      method: 'get'
    })
  },
  //发布课程
  publishCourseById(id) {
    return request({
      url: `${api_name}/publishCourse/${id}`,
      method: 'put'
    })
  },
  // 根据 id 删除数据
  removeById(id) {
    return request({
      url: `${api_name}/remove/${id}`,
      method: 'delete'
    })
  },
  findAll() {
    return request({
      url: `${api_name}/findAll`,
      method: 'get'
    })
  }
}
```



#### 11.3.1 追加代码 `api`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667437156807-93d906a7-9131-4faf-802c-13b7c19dd747.png)

```javascript
  findAll() {
    return request({
      url: `${api_name}/findAll`,
      method: 'get'
    })
  }
```



## 12 测试直播管理模块

- 上传`gateway`网关模块
- 上传`live`模块
- 上传`vod`模块
- 上传前端

### 12.1 列表显示

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667439239404-ed69f968-0052-4b6b-b4b6-5bfd61dd3bdb.png)



### 12.2 `Bug`分页显示异常

- 点击分页`5`, 查询并且显示错误

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667439626327-dff1bf92-cecc-4b8a-983d-27f99f61d643.png)

#### 12.2.1 `Bug`修复 - `MybatisPlus` 分页插件

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667439715750-71fc30da-3b21-4a5d-85eb-4aa0c6ac6d49.png)

```java
package com.atguigu.ggkt.live.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisPlus 配置类
 * 
 * @author 陈江林
 * @date 2022/11/3 09:37
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * 版本要求：3.4.0 版本以上
     * 新的分页插件,一缓和二缓遵循 mybatis 的规则, 需要设置 MybatisConfiguration#useDeprecatedExecutor = false 避免缓存出现问题(该属性会在旧插件移除后一同移除)
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.H2));
        return interceptor;
    }

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> configuration.setUseDeprecatedExecutor(false);
    }

}
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667440527693-314e2b8d-3c8c-4306-b620-f8fd912e175b.png)



### 12.3 测试添加直播

- 添加成功

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667441150540-28d45798-736c-4541-beaa-f3a4572a13a0.png)

- 欢拓云后台显示

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667441536278-da6a3876-ac47-43aa-a63b-0915eeec465b.png)

- 时间错误

#### 12.3.1 `Bug`时间显示错误

- 注释 `@EnableWebMvc`, 它会使 `springboot`退出 `MVC`默认配置

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667476798252-d07f0671-c71f-447e-b9b3-9f159ce8f607.png)

```java
package com.atguigu.ggkt.util;

import com.atguigu.ggkt.interceptor.UserLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**JAVA
* Spring Mvc 配置类
*
* @author 陈江林
* @date 2022/10/21 19:12
*/
@Configuration
    // @EnableWebMvc
    public class LoginWebMvcConfigurerImpl implements WebMvcConfigurer {

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
        // 添加自定义拦截器, 设置拦截路径
        registry.addInterceptor(new UserLoginInterceptor())
        .addPathPatterns("/api/**");
        }

        }
```



### 12.4 修改直播

- 修改失败

#### 12.4.1 修复`Bug`

- 报空指针异常, 缺少参数`courseId`

```java
	@ApiModelProperty(value = "课程id")
	private Long courseId;
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667521665667-7fbc6165-a95c-4430-93ae-9aa7c79b19d4.png)



#### 12.4.2 修改成功

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667521754307-b220b5fc-2dd8-4406-8db2-297abdb66505.png)

- 欢拓云后台

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667521735400-07a97d47-1b55-4108-a529-f67c7d451b22.png)





## 13 微信公众号直播观看

### 13.1 欢拓云观看端集成`WebSDK`

接口文档：`https://open.talk-fun.com/docs/js/index.html`



#### 13.1.1 获取用户`access_token`

- 用户要观看直播，必须获取对应的用户`access_token`，通过`access_token` 获取观看的直播课程；
- 接口参数：直播`id`，用户`id`



- 新建 `LiveCourseApiController`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667529137717-4b235fd1-7c3d-4e6b-b7fd-79971595988d.png)

```java
package com.atguigu.ggkt.live.api;

import com.alibaba.fastjson.JSONObject;
import com.atguigu.ggkt.live.service.LiveCourseService;
import com.atguigu.ggkt.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信公众号直播观看
 *
 * @author 陈江林
 * @date 2022/11/4 10:31
 */
@Api(tags = "微信公众号直播观看")
@RestController
@RequestMapping("/api/live/liveCourse")
public class LiveCourseApiController {

    @Autowired
    private LiveCourseService liveCourseService;

    @ApiOperation(value = "获取用户 access_token")
    @GetMapping("/getPlayAuth/{id}")
    public Result<JSONObject> getPlayAuth(@PathVariable Long id) {
        return Result.ok(liveCourseService.getPlayAuth(id));
    }

}
```

- 服务接口

```java
    /**
     * 获取用户 access_token
     *
     * @param id id
     * @return {@link JSONObject}
     */
    JSONObject getPlayAuth(Long id);
```

- 服务实现

```java
    @Override
    public JSONObject getPlayAuth(Long id) {
        // 根据课程 id 获取直播课程信息
        LiveCourse liveCourse = baseMapper.selectById(id);
        // 根据用户 id 获取用户信息（远程调用）
        Result<UserInfo> userInfoResult = userInfoFeignClient.getById(AuthContextHolder.getUserId());
        if (!Result.SUCCESS_CODE.equals(userInfoResult.getCode())) {
            throw new GgktException(Result.FAILED_CODE, GgktConstant.MESSAGE_METHOD_CALL);
        }

        // 得到数据
        UserInfo userInfo = userInfoResult.getData();
        if(userInfo == null) {
            throw new GgktException(Result.FAILED_CODE, GgktConstant.MESSAGE_PARAM);
        }

        // 封装需要的参数
        HashMap<Object, Object> options = new HashMap<>();
        try {
            String res = mtCloud.courseAccess(
                    liveCourse.getCourseId().toString(),
                    AuthContextHolder.getUserId().toString(),
                    userInfo.getNickName(),
                    MTCloud.ROLE_USER,
                    3600,
                    options
            );
            // 欢拓云返回的参数
            CommonResult<JSONObject> commonResult = JSON.parseObject(res, CommonResult.class);
            log.info("欢拓云Token-code: "+commonResult.getCode());
            log.info("欢拓云Token-data" + commonResult.getData().toString());
            if (MTCloud.CODE_SUCCESS != Integer.parseInt(commonResult.getCode())) {
                throw new GgktException(Result.FAILED_CODE, GgktConstant.MESSAGE_LIVE_ACCESS_TOKEN);
            }

            return commonResult.getData();
        } catch (Exception e) {
            throw new GgktException(Result.FAILED_CODE, GgktConstant.MESSAGE_LIVE_ACCESS_TOKEN);
        }
    }
```



- 添加依赖

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667529650081-d0b72bb9-f5b5-471f-bfa6-75c174a0f627.png)

```xml
<dependency>
    <groupId>com.atguigu</groupId>
    <artifactId>service_user_client</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

#### 13.1.2 下载前端SDK

- 下载地址：`https://open.talk-fun.com/docs/js/download.html`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667528591931-cf0ecbe6-15c5-467c-8339-f7a0a18d4566.png)





#### 12.1.3 使用快捷模板

- 下载模板，修改`token`获取方式

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667528688174-6fefb4ae-8e54-40b3-bd02-f65ed25eaad7.png)



### 13.2 前端整合

#### 13.2.1 新建直播播放页面 `live.html`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667531130289-54539094-c3b1-4f7c-a597-46abedde8e90.png)

```html
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"/>
  <title>TalkFun Live QuickStart v2.2</title>
  <style type="text/css">
    * {
      margin: 0;
      padding: 0;
      list-style-type: none;
      font-family: "Microsoft YaHei", "STHeiti";
    }

    .flash-wran {
      display: none;
      position: absolute;
      top: 0;
      width: 100%;
      padding: 5px 0;
      text-align: center;
      background: #fff6a2;
      border: 1px solid #ffd913;
    }

    .flash-wran a {
      color: red;
    }

    .wrapper {
      /*display: flex;*/
      padding: 10px;
    }

    #cameraPlayer,
    #pptPlayer {
      height: auto;
      flex: 1;
      text-align: center;
      font-size: 12px;
      overflow: hidden;
    }

    #pptPlayer {
      height: 300px;
      width: 100%;
    }

    #modPptPlayer,
    #modCameraPlayer {
      margin-top: 10px;
      border: 1px solid #c7c7c7;
    }

    .chat-wrap {
      padding: 5px;
      margin: 10px;
      border: 2px solid #cccccc;
      background: #f1f1f1
    }

    .mod-chat-list {
      margin: 20px 0;
      border: 1px solid #CCCCCC;
      min-height: 100px;
      font-size: 12px;
      background: #dedede;
      padding: 5px;
      max-height: 200px;
      overflow-y: scroll;
    }

    .mod-chat-list li {
      padding: 2px 0;
      margin-bottom: 5px;
      border-bottom: 1px dotted #CCCCCC;
    }

    input {
      display: inline-block;
      width: 200px;
      padding: 5px;
    }

    button {
      display: inline-block;
      padding: 5px;
      margin-left: 5px;
    }

    #toast {
      padding: 20px;
      position: fixed;
      z-index: 100;
      display: none;
      background: rgba(212, 28, 28, 0.8);
      left: 50%;
      top: 30%;
      border-radius: 50em;
      font-size: 14px;
      color: #FFFFFF;
      box-shadow: 0 0 6px 0px #bb2d2d;
    }

    #talkfun-video-wrap, #talkfun-camera-wrap {
      position: relative;
      background: #000;
    }
  </style>
  <!-- #SDK版本 -->
  <!-- #获取最新版本 ==> http://open.talk-fun.com/docs/js/changelog/live.html -->
  <script type="text/javascript"
          src="https://static-1.talk-fun.com/open/TalkFun_SDK_Pack/v6.0/TalkFunWebSDK-6.2-2.min.js"></script>
</head>
<body>
<!-- #toast -->
<div id="toast"></div>
<!-- #wrap -->
<div class="wrapper">
  <!-- #画板播放器 -->
  <div id="pptPlayer">
    <p id="loaddoc">播放器 Loading...</p>
  </div>
  <!-- #摄像头模式 -->
  <div id="cameraPlayer">
    <p id="loadcam">摄像头 Loading...</p>
  </div>
  <!-- #桌面分享｜视频插播模式 -->
  <div id="videoPlayer">
    <p id="loadplayer">视频播放器 Loading...</p>
  </div>
</div>
<!-- #chat -->
<div class="chat-wrap">
  <h4>聊天模块</h4>
  <ul id="chat-list" class="mod-chat-list"></ul>
  <label>
    <input id="chatVal" type="text"/>
    <button id="chatSubmit">发送聊天</button>
  </label>
</div>
<script>
  // [第一步] 如何获取 access_token => http://open.talk-fun.com/docs/getstartV2/access_token.html
  // [第二步] 根据Api文档方法 监听 / 调用方法 JS Api => http://open.talk-fun.com/docs/js/sdk.js.getstart.html
  var url = window.location.search
  var token = url.split("=")[1]
  // 更多配置项 => https://open.talk-fun.com/docs/js/sdk.js.getstart.html?h=%E9%85%8D%E7%BD%AE%E9%A1%B9
  var HT = new MT.SDK.main(token, {
    config: {
      techOrder: 'FLV' // Safari 浏览器建议设置为 HLS
    }
  }, function (data) {
    console.warn('sdk加载完成', data)
  })
  // 连接状态
  HT.on('connect', function () {
    console.log('TalkFun通信 => 连接成功...')
  })
  // 课件播放器
  HT.whiteboardPlayer('pptPlayer', 'docPlayer', function (player) {
    console.log('课件播放器 => 初始化成功')
    document.querySelector('#loadplayer').innerHTML = '画板模块加载完成'
  })
  // 视频插播 | 桌面分享
  HT.videoPlayer('videoPlayer', 'modVideoplayer', function (player) {
    console.log('视频播放器 => 初始化成功')
    document.querySelector('#loadplayer').innerHTML = '视频插播加载完成'
  })
  // 摄像头播放器
  HT.camera('cameraPlayer', 'modCameraPlayer', function () {
    console.log('摄像头播放器 => 初始化成功')
    document.querySelector('#loadcam').innerHTML = '摄像头模块加载完成'
  })
  // 接收聊天
  var receivedChat = function (chat) {
    var tpl = chat.nickname + ': ' + chat.msg
    var chatItem = document.createElement('li')
    chatItem.innerHTML = tpl
    chatItem.className = 'chat-' + chat.xid
    document.querySelector('#chat-list').appendChild(chatItem)
  }
  // 接收聊天信息
  HT.on('chat:send', function (chat) {
    receivedChat(chat)
  })
  // 发送聊天信息
  document.querySelector('#chatSubmit').addEventListener('click', function () {
    var chatIpt = document.querySelector('#chatVal')
    var chatValue = chatIpt.value
    HT.emit('chat:send', {msg: chatValue}, function (res) {
      // 发送成功
      if (Number(res.code) === 0) {
        receivedChat(res.data)
        chatIpt.value = ''
      }
      // 发送失败
      else {
        console.warn(res.msg)
      }
    })
  }, false)
  // Flash插件异常
  HT.on('flash:load:error', function (obj) {
    if (!obj.flash) {
      document.querySelector('#flashTip').style.display = 'block'
    }
  })
  // 课程错误信息
  HT.on('live:course:access:error', function (res) {
    console.error('错误信息 ==>', res)
  })
  // 课程错误信息
  HT.on('system:room:error', function (res) {
    var toast = document.querySelector('#toast')
    if (typeof res === 'string') {
      toast.innerHTML = res.msg
    } else if (res.msg) {
      toast.innerHTML = res.msg
    }
    toast.style.display = 'block'
    var _left = toast.clientWidth / 2
    toast.style.marginLeft = -_left + 'px'
  })
</script>
</body>
</html>
```

- 观众在直播详情页面点击观看，获取通过接口获取`access_token`，然后带上`access_token`参数跳转到直播观看页面即可，关键代码：

```
LiveInfo.vue
play() {
  api.getPlayAuth(this.liveCourseId).then(response => {
    console.log(response.data);
    window.location = './live.html?token='+response.data.access_token;
    this.finished = true;
  });
},
```



#### 13.2.2 新建直播播放 `LiveInfo.vue`

```vue
<template>
  <div>
    <van-image width="100%" height="200" src="https://cdn.uviewui.com/uview/swiper/1.jpg"/>

    <h1 class="van-ellipsis course_title">{{ liveCourse.courseName }}</h1>

    <div class="course_teacher_price_box">
      <div class="course_teacher_price">
        <div class="course_price">直播时间：</div>
        <div class="course_price_number">
          {{ liveCourse.param.startTimeString }}至
          {{liveCourse.param.endTimeString }}
        </div>

      </div>
    </div>
    <div class="course_teacher_price_box">
      <div class="course_teacher_box">
        <div class="course_teacher">主讲： {{ teacher.name }}</div>
        <van-image :src="teacher.avatar" round width="50px" height="50px"/>
      </div>
    </div>

    <div class="course_contents">
      <div class="course_title_font">课程详情</div>
      <van-divider :style="{ margin: '5px 0 ' }"/>
      <div class="course_content" v-html="description"></div>
    </div>

    <van-goods-action>
      <van-goods-action-button type="danger" text="直播中" @click="play"/>
    </van-goods-action>

    <van-loading vertical="true" v-show="loading">加载中...</van-loading>
  </div>
</template>

<script>
import api from '@/api/live'
import shareApi from '@/api/share'
import wxShare from '@/utils/wxShare'

export default {
  data() {
    return {
      loading: false,
      liveCourseId: null,
      liveCourse: {param: {}},
      description: '',
      teacher: {},
      liveStatus: 0,
      activeNames: ["1"]
    };
  },

  created() {
    this.liveCourseId = this.$route.params.liveCourseId;
    this.fetchData();
  },

  methods: {
    fetchData() {
      this.loading = true;
      api.getInfo(this.liveCourseId).then(response => {
        console.log(response.data);

        this.liveCourse = response.data.liveCourse;
        this.description = response.data.description;
        this.teacher = response.data.teacher;
        this.liveStatus = response.data.liveStatus;

        this.loading = false;

        //分享注册
        //this.wxRegister();
      });
    },

    play() {
      api.getPlayAuth(this.liveCourseId).then(response => {
        console.log(response.data);

        //this.$router.push({ path: '/liveOnline?token='+response.data.access_token })
        window.location = './live.html?token=' + response.data.access_token;
        this.finished = true;
      });
    },

    wxRegister() {
      //说明：后台加密url必须与当前页面url一致
      let url = window.location.href.replace('#', 'guiguketan');
      shareApi.getSignature(url).then(response => {
        console.log(response.data);

        //记录分享用户
        let link = '';
        if (window.location.href.indexOf('?') !== -1) {
          link = window.location.href + '&recommend=' + response.data.userEedId;
        } else {
          link = window.location.href + '?recommend=' + response.data.userEedId;
        }

        let option = {
          'title': this.liveCourse.courseName,
          'desc': this.description,
          'link': link,
          'imgUrl': this.liveCourse.cover
        }
        wxShare.wxRegister(response.data, option);
      });
    }
  }
};
</script>

<style lang="scss" scoped>
.gap {
  height: 10px;
}

::v-deep.van-image {
  display: block;
}

.course_count {
  background-color: #82848a;
  color: white;
  padding: 5px;
  text-align: center;
  border-right: 1px solid #939393;

  h1 {
    font-size: 14px;
    margin: 0;
  }

  p {
    margin: 0;
    font-size: 16px;
  }
}

.course_title {
  font-size: 20px;
  margin: 10px;
}

.course_teacher_price_box {
  margin: 10px;
  display: flex;
  justify-content: space-between;
  align-items: center;

  .course_teacher_price {
    display: flex;
    font-size: 14px;
    align-items: center;

    .course_price_number {
      color: red;
      font-size: 18px;
      font-weight: bold;
    }

    .course_teacher {
      margin-left: 20px;
    }
  }

  .course_teacher_box {
    display: flex;
    justify-content: center;
    align-items: center;

    .course_teacher {
      margin-right: 20px;
    }
  }
}

.course_contents {
  margin: 10px;

  .course_title_font {
    color: #68cb9b;
    font-weight: bold;
  }

  .course_content {
    margin-bottom: 20px;
  }
}

.course_chapter_list {
  display: flex;
  justify-content: space-between;
  align-items: center;

  h2 {
    font-size: 14px;
  }

  p {
    margin: 0;
  }
}
</style>
```

- 对应路由

```javascript
  {
    // 直播观看
    path: '/liveInfo/:liveCourseId',
    name: 'LiveInfo',
    component: () => import('../views/LiveInfo')
  }
```



#### 13.2.3 新建 `API`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667533062720-3b5c4dfb-9310-4614-8ec6-8cf83491ea07.png)

```javascript
import {request} from '@/utils/request'

const api_name = '/api/live/liveCourse'

export default {
  // 获取 access_token
  getPlayAuth(liveCourseId) {
    return request({
      url: `${api_name}/getPlayAuth/${liveCourseId}`,
      method: 'get'
    })
  },

  // 直播详情
  getInfo(liveCourseId) {
    return request({
      url: `${api_name}/getInfo/${liveCourseId}`,
      method: 'get'
    })
  }
}
```



#### 13.2.4 新建工具 `wxShare.js`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667532005787-165c38d5-acbb-44c8-916c-c145a6864c59.png)

```javascript
/**
 * 微信js-sdk
 * 参考文档：https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141115
 */
const wxShare = {
  /**
   * [wxRegister 微信Api初始化]
   * @param  {Function} callback [ready回调函数]
   */
  wxRegister(data, option) { //data是微信配置信息，option是分享的配置内容
    wx.config({
      debug: false, // 开启调试模式
      appId: data.appId, // 必填，公众号的唯一标识
      timestamp: data.timestamp, // 必填，生成签名的时间戳
      nonceStr: data.nonceStr, // 必填，生成签名的随机串
      signature: data.signature,// 必填，签名，见附录1
      jsApiList: [
        'onMenuShareAppMessage'
      ] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
    });
    
    wx.ready(function () {
      wx.onMenuShareAppMessage({
        title: option.title, // 分享标题
        desc: option.desc, // 分享描述
        link: option.link, // 分享链接
        imgUrl: option.imgUrl, // 分享图标
        success() {
          // 用户成功分享后执行的回调函数
          //  option.success()
          console.log('ok');
        },
        cancel() {
          // 用户取消分享后执行的回调函数
          // option.error()
          console.log('cancel');
        }
      });
    });

    wx.error(function (res) {
      // config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。
      //alert('error:'+JSON.stringify(res));
    });
  }
}

export default wxShare
```



### 13.3 对应接口

#### 13.3.1 控制层

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667532610707-74257ed2-ba73-4c0d-81f7-aa9b292c7c50.png)

```java
    @ApiOperation("根据ID查询课程")
    @GetMapping("/getInfo/{courseId}")
    public Result<Map<String, Object>> getInfo(
            @ApiParam(value = "课程ID", required = true)
            @PathVariable Long courseId){
        return Result.ok(liveCourseService.getInfoById(courseId));
    }
```



#### 13.3.2 服务接口

```java
    /**
     * 根据ID查询课程
     *
     * @param courseId 课程ID
     * @return {@link Map}<{@link String}, {@link Object}>
     */
    Map<String, Object> getInfoById(Long courseId);
```



#### 13.3.3 服务实现

```java
    @Override
    public Map<String, Object> getInfoById(Long id) {
        LiveCourse liveCourse = this.getById(id);
        liveCourse.getParam().put("startTimeString", new DateTime(liveCourse.getStartTime()).toString("yyyy年MM月dd HH:mm"));
        liveCourse.getParam().put("endTimeString", new DateTime(liveCourse.getEndTime()).toString("yyyy年MM月dd HH:mm"));
        // 根据讲师 id 获取讲师对象
        Long teacherId = liveCourse.getTeacherId();
        Result<Teacher> teacherResult = courseFeignClient.getTeacherId(teacherId);
        if (!Result.SUCCESS_CODE.equals(teacherResult.getCode())) {
            throw new GgktException(Result.FAILED_CODE, GgktConstant.MESSAGE_METHOD_CALL);
        }

        // 得到数据
        Teacher teacher = teacherResult.getData();
        LiveCourseDescription liveCourseDescription = liveCourseDescriptionService.getOne(
                new LambdaQueryWrapper<LiveCourseDescription>()
                        .eq(LiveCourseDescription::getLiveCourseId, id)
        );

        Map<String, Object> map = new HashMap<>();
        map.put("liveCourse", liveCourse);
        map.put("liveStatus", this.getLiveStatus(liveCourse));
        map.put("teacher", teacher);
        if (null != liveCourseDescription) {
            map.put("description", liveCourseDescription.getDescription());
        } else {
            map.put("description", "");
        }

        return map;
    }
```



### 13.4 测试公众号直播观看

#### 13.4.1 管理后台添加直播

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667567143826-0ef75496-2729-4c28-9309-944a687f4d12.png)

- 欢拓云后台】

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667567485888-cd72f987-ee95-4a34-9a90-39020052b1ad.png)

- 数据库

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667567558698-56a5ed33-9d14-4b90-b2af-bd608544b82f.png)



#### 13.4.2 公众号设置路径

1. 添加直播

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667569793889-e536d0b3-79a1-4948-b80f-e64f306f77c2.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667569809134-c9233cb8-1f61-4938-a85e-7048110361fc.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667569831459-5dad3607-cc6d-4b15-becc-42a695df8dd2.png)

1. 同步公众号菜单

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667569843976-0970edca-c561-43b2-85b3-dbf2a4092ab8.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667569949789-7882d8be-93f4-4640-98b7-835ab354c0e9.png)



#### 13.4.3 登录开播并打开公众号点击测试直播菜单

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667570919673-5e32fc69-678b-47bd-ab7b-fa54611d8b25.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667570861186-d928f0e2-6876-446c-8b0f-dbd87e3504fa.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667574505209-0b322f48-7cb5-4b58-ab24-a22ed950723b.png)

- 公众号

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667571453466-4260b0d6-b3d1-45c0-9361-743a92f4035c.png)

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667574468022-f8f5e030-446e-461e-b39c-6e984d33084d.png)



## 14 微信网页开发-使用微信分享功能

参考文档：`https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/JS-SDK.html`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667575184701-b1643ef8-3a5f-41db-a432-2d374b81a8c6.png)

### 14.1 使用微信 `JS-SDK`

微信 JS-SDK 是[微信公众平台](https://mp.weixin.qq.com/cgi-bin/loginpage?t=wxm2-login&lang=zh_CN) 面向网页开发者提供的基于微信内的网页开发工具包。

通过使用微信JS-SDK，网页开发者可借助微信高效地使用拍照、选图、语音、位置等手机系统的能力，同时可以直接使用微信分享、扫一扫、卡券、支付等微信特有的能力，为微信用户提供更优质的网页体验。



#### 14.1.1 绑定域名

- 正式号配置

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667575218967-8832f15c-cea2-40b3-b3e1-7dbc065804d7.png)

- 测试号配置

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667575306612-b436e73c-edde-4b08-9c89-7e1370522e09.png)



#### 14.1.2 引入`JS`文件

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667575379735-e2dc1e55-c578-4da5-95bc-f1da87c0e7f9.png)

```html
<!-- 微信 -->
<script src="http://res.wx.qq.com/open/js/jweixin-1.4.0.js" type="text/javascript"></script>
```



### 14.2 新建微信配置文件 `wxShare.js`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667576384989-cadcd6e2-2ab4-41f9-8070-b32f5a7df13b.png)

```javascript
/**
 * 微信js-sdk
 * 参考文档：https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141115
 */
const wxShare = {
    /**
     * [wxRegister 微信Api初始化]
     * @param  {Function} callback [ready回调函数]
     */
    wxRegister(data,option) { //data是微信配置信息，option是分享的配置内容
        
        wx.config({
            debug: true, // 开启调试模式
            appId: data.appId, // 必填，公众号的唯一标识
            timestamp: data.timestamp, // 必填，生成签名的时间戳
            nonceStr: data.nonceStr, // 必填，生成签名的随机串
            signature: data.signature,// 必填，签名，见附录1
            jsApiList: [
                'onMenuShareAppMessage'
            ] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
        });
        wx.ready(function(){

            wx.onMenuShareAppMessage({
                title: option.title, // 分享标题
                desc: option.desc, // 分享描述
                link: option.link, // 分享链接
                imgUrl: option.imgUrl, // 分享图标
                success() {
                    // 用户成功分享后执行的回调函数
                    //  option.success()
                    console.log('ok');
                },
                cancel() {
                    // 用户取消分享后执行的回调函数
                    // option.error()
                    console.log('cancel');
                }
            });
        });

        wx.error(function(res){
          // config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。
          //alert('error:'+JSON.stringify(res));
        });
    }
}
export default wxShare
```



### 14.3 点播课程详情分享

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667576547336-1071757b-7541-4003-97a9-40d3a6aba996.png)

```vue
<template>
  <div>
    <van-image width="100%" height="200" :src="courseVo.cover"/>
    <van-row>
      <van-col span="8">
        <div class="course_count">
          <h1>购买数</h1>
          <p>{{ courseVo.buyCount }}</p>
        </div>
      </van-col>
      <van-col span="8">
        <div class="course_count">
          <h1>课时数</h1>
          <p>{{ courseVo.lessonNum }}</p>
        </div>
      </van-col>
      <van-col span="8">
        <div class="course_count">
          <h1>浏览数</h1>
          <p>{{ courseVo.viewCount }}</p>
        </div>
      </van-col>
    </van-row>
    <h1 class="van-ellipsis course_title">{{ courseVo.title }}</h1>
    <div class="course_teacher_price_box">
      <div class="course_teacher_price">
        <div class="course_price">价格：</div>
        <div class="course_price_number">￥{{ courseVo.price }}</div>
      </div>
      <div>
        <van-button @click="see()" v-if="isBuy || courseVo.price == '0.00'" plain type="warning" size="mini">立即观看
        </van-button>
        <van-button @click="buy" v-else plain type="warning" size="mini">立即购买</van-button>
      </div>
    </div>
    <div class="course_teacher_price_box">
      <div class="course_teacher_box">
        <div class="course_teacher">主讲： {{ teacher.name }}</div>
        <van-image :src="teacher.avatar" round width="50px" height="50px"/>
      </div>
    </div>
    <div class="course_contents">
      <div class="course_title_font">课程详情</div>
      <van-divider :style="{ margin: '5px 0 ' }"/>
      <div class="course_content" v-html="description">
      </div>
      <div class="course_title_font">课程大纲</div>
      <div class="gap"></div>
      <van-collapse v-model="activeNames">
        <van-collapse-item :title="item.title" :name="item.id" v-for="item in chapterVoList" :key="item.id">
          <ul class="course_chapter_list" v-for="child in item.children" :key="child.id">
            <h2>{{ child.title }}</h2>
            <p v-if="child.isFree == 1">
              <van-button @click="play(child)" type="warning" size="mini" plain>免费观看</van-button>
            </p>
            <p v-else>
              <van-button @click="play(child)" type="warning" size="mini" plain>观看</van-button>
            </p>
          </ul>
        </van-collapse-item>
      </van-collapse>
    </div>
    <van-loading vertical="true" v-show="loading">加载中...</van-loading>
  </div>
</template>

<script>
import {getInfo} from '@/api/course'
import shareApi from '@/api/share'
import wxShare from '@/utils/wxShare'

export default {
  data() {
    return {
      loading: false,
      courseId: null,
      courseVo: {},
      description: '',
      teacher: {},
      chapterVoList: [],
      isBuy: false,
      activeNames: ["1"]
    };
  },
  created() {
    this.courseId = this.$route.params.courseId;
    this.fetchData();
  },
  methods: {
    wxRegister() {
      // 说明：后台加密url必须与当前页面url一致
      let url = window.location.href.replace('#', 'guiguketan')
      shareApi.getSignature(url).then(response => {
        console.log(response.data);
        // 记录分享用户
        let link = '';
        if(window.location.href.indexOf('?') !== -1) {
          link = window.location.href + '&recommend=' + response.data.userEedId;
        } else {
          link = window.location.href + '?recommend=' + response.data.userEedId;
        }

        let option = {
          'title': this.courseVo.title,
          'desc': this.description,
          'link': link,
          'imgUrl': this.courseVo.cover
        }

        wxShare.wxRegister(response.data, option);
      });
    },
    fetchData() {
      this.loading = true;
      getInfo(this.courseId).then(response => {
        console.log(response.data);

        this.courseVo = response.data.courseVo;
        this.description = response.data.description;
        this.isBuy = response.data.isBuy;
        this.chapterVoList = response.data.chapterVoList;
        this.teacher = response.data.teacher;

        this.loading = false;

        // 微信分享注册
        this.wxRegister();
      });
    },
    buy() {
      this.$router.push({path: '/trade/' + this.courseId})
    },
    // 视频播放
    play(video) {
      const videoId = video.id;
      this.$router.push({path: '/course/play/' + this.courseId + "/" + videoId})
    },
    see() {
      this.$router.push({path: '/play/' + this.courseId + '/0'})
    }
  }
};
</script>
<style lang="scss" scoped>
.gap {
  height: 10px;
}

::v-deep.van-image {
  display: block;
}

.course_count {
  background-color: #82848a;
  color: white;
  padding: 5px;
  text-align: center;
  border-right: 1px solid #939393;

  h1 {
    font-size: 14px;
    margin: 0;
  }

  p {
    margin: 0;
    font-size: 16px;
  }
}

.course_title {
  font-size: 20px;
  margin: 10px;
}

.course_teacher_price_box {
  margin: 10px;
  display: flex;
  justify-content: space-between;
  align-items: center;

  .course_teacher_price {
    display: flex;
    font-size: 14px;
    align-items: center;

    .course_price_number {
      color: red;
      font-size: 18px;
      font-weight: bold;
    }

    .course_teacher {
      margin-left: 20px;
    }
  }

  .course_teacher_box {
    display: flex;
    justify-content: center;
    align-items: center;

    .course_teacher {
      margin-right: 20px;
    }
  }
}

.course_contents {
  margin: 10px;

  .course_title_font {
    color: #68cb9b;
    font-weight: bold;
  }

  .course_content {
    margin-bottom: 20px;
  }
}

.course_chapter_list {
  display: flex;
  justify-content: space-between;
  align-items: center;

  h2 {
    font-size: 14px;
  }

  p {
    margin: 0;
  }
}
</style>
```

#### 14.3.1 引入 `wxShare.js`

```vue
import wxShare from '@/utils/wxShare'
```



#### 14.3.2 `methods`

```javascript
    wxRegister() {
      // 说明：后台加密url必须与当前页面url一致
      let url = window.location.href.replace('#', 'guiguketan')
      shareApi.getSignature(url).then(response => {
        console.log(response.data);
        // 记录分享用户
        let link = '';
        if(window.location.href.indexOf('?') !== -1) {
          link = window.location.href + '&recommend=' + response.data.userEedId;
        } else {
          link = window.location.href + '?recommend=' + response.data.userEedId;
        }

        let option = {
          'title': this.courseVo.title,
          'desc': this.description,
          'link': link,
          'imgUrl': this.courseVo.cover
        }

        wxShare.wxRegister(response.data, option);
      });
    },
```

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667579474473-357419a6-7bda-4059-9408-468ac8fef978.png)

### 14.4 新建`API`, `share.js`

```java
/**
 * 微信js-sdk
 * 参考文档：https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141115
 */
const wxShare = {
  /**
   * [wxRegister 微信Api初始化]
   * @param  {Function} callback [ready回调函数]
   */
  wxRegister(data, option) { //data是微信配置信息，option是分享的配置内容
    wx.config({
      debug: false, // 开启调试模式
      appId: data.appId, // 必填，公众号的唯一标识
      timestamp: data.timestamp, // 必填，生成签名的时间戳
      nonceStr: data.nonceStr, // 必填，生成签名的随机串
      signature: data.signature,// 必填，签名，见附录1
      jsApiList: [
        'onMenuShareAppMessage'
      ] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
    });

    wx.ready(function () {
      wx.onMenuShareAppMessage({
        title: option.title, // 分享标题
        desc: option.desc, // 分享描述
        link: option.link, // 分享链接
        imgUrl: option.imgUrl, // 分享图标
        success() {
          // 用户成功分享后执行的回调函数
          //  option.success()
          console.log('ok');
        },
        cancel() {
          // 用户取消分享后执行的回调函数
          // option.error()
          console.log('cancel');
        }
      });
    });

    wx.error(function (res) {
      // config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。
      //alert('error:'+JSON.stringify(res));
    });
  }
}

export default wxShare
```



### 14.5 获取签名

#### 14.5.1 控制层 - 新建 `ShareController`类

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667577212689-c103d972-8187-43c2-8f9d-172e22d52e62.png)

```java
package com.atguigu.ggkt.wechat.api;

import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.util.AuthContextHolder;
import com.atguigu.ggkt.util.Base64Util;
import com.atguigu.ggkt.vo.wechat.WxJsapiSignatureVo;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.bean.WxJsapiSignature;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信 jsapi
 *
 *
 * @author 陈江林
 * @date 2022/11/4 23:52
 */
@RestController
@RequestMapping("/api/wechat/share")
@Slf4j
public class ShareController {

    @Autowired
    private WxMpService wxMpService;

    @GetMapping("/getSignature")
    public Result getSignature(@RequestParam("url") String url) throws WxErrorException {
        // 微信分享要对当前url加密处理，由于我们的url路由都是带“#”符号，服务器端接收不到，因此通过“guiguketan”单词代替了“#”
        String currentUrl = url.replace("guiguketan", "#");
        // 创建调用 jsapi 时所需要的签名
        WxJsapiSignature jsapiSignature = wxMpService.createJsapiSignature(currentUrl);

        WxJsapiSignatureVo wxJsapiSignatureVo = new WxJsapiSignatureVo();
        BeanUtils.copyProperties(jsapiSignature, wxJsapiSignatureVo);
        wxJsapiSignatureVo.setUserEedId(Base64Util.base64Encode(AuthContextHolder.getUserId() + ""));
        return Result.ok(wxJsapiSignatureVo);
    }

}
```





#### 14.5.2 新建工具类 `Base64Util`

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667592653296-811e79bd-7d6d-4178-8bc5-609aadc72391.png)

```java
package com.atguigu.ggkt.util;

import lombok.SneakyThrows;

import java.util.Base64;
import java.util.regex.Pattern;

/**
 * @author 陈江林
 * @date 2022/11/5 00:05
 */
public class Base64Util {

    /**
     * 使用Base64进行加密
     *
     * @param content 密文
     * @return
     */
    @SneakyThrows
    public static String base64Encode(String content) {
        return Base64.getEncoder().encodeToString(content.getBytes("UTF-8"));
    }

    /**
     * 使用Base64进行解密
     *
     * @param content
     * @return
     */
    @SneakyThrows
    public static String base64Decode(String content) {
        return new String(Base64.getDecoder().decode(content), "UTF-8");
    }

    public static boolean isNumeric(String str) {
        String regex = "^[1-9][0-9]*$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(str).matches();
    }

}
```



### 14.6 测试

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667592774385-141a2f3d-b816-4a4d-9c4e-58ad24401c22.png)

- 分享

![img](https://cdn.nlark.com/yuque/0/2022/png/12811585/1667592740568-a29c3343-7fb7-4ba0-93db-2baf428c0065.png)
