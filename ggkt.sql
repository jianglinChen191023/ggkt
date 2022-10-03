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