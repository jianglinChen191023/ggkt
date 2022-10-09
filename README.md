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