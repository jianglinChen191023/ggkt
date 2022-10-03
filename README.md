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