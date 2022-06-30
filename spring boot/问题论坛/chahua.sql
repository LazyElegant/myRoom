/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : localhost:3306
 Source Schema         : chahua

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 23/03/2022 17:29:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for classify
-- ----------------------------
DROP TABLE IF EXISTS `classify`;
CREATE TABLE `classify`  (
  `id` int(100) UNSIGNED NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `creation_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of classify
-- ----------------------------
INSERT INTO `classify` VALUES (31358197, 'EVA', '2022-03-19 10:51:51');
INSERT INTO `classify` VALUES (357113363, '原创角色', '2022-03-21 07:09:49');
INSERT INTO `classify` VALUES (684701500, '白发', '2022-03-21 07:07:00');
INSERT INTO `classify` VALUES (713688922, '赤发', '2022-03-21 07:55:54');

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect`  (
  `id` int(11) NOT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `ikon_id` int(11) NULL DEFAULT NULL,
  `collect_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES (552173210, 281942670, 749797108, '2022-03-21 07:13:24');
INSERT INTO `collect` VALUES (625426176, 1, 102902101, '2022-03-21 07:56:23');
INSERT INTO `collect` VALUES (782083107, 1, 749797108, '2022-03-20 08:15:01');
INSERT INTO `collect` VALUES (787298710, 369705934, 218531390, '2022-03-21 07:53:13');

-- ----------------------------
-- Table structure for concern
-- ----------------------------
DROP TABLE IF EXISTS `concern`;
CREATE TABLE `concern`  (
  `id` int(11) NOT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `concern_id` int(11) NULL DEFAULT NULL,
  `concern_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of concern
-- ----------------------------
INSERT INTO `concern` VALUES (35689788, 1, 281942670, '2022-03-21 07:56:33');
INSERT INTO `concern` VALUES (367597639, 1, 427738382, '2022-03-20 09:42:59');
INSERT INTO `concern` VALUES (580527938, 369705934, 281942670, '2022-03-21 07:53:08');

-- ----------------------------
-- Table structure for ikon
-- ----------------------------
DROP TABLE IF EXISTS `ikon`;
CREATE TABLE `ikon`  (
  `id` int(20) UNSIGNED NOT NULL,
  `classify_id` int(20) NULL DEFAULT 0,
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pic` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `author_id` int(11) NULL DEFAULT 0,
  `context` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `issue_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of ikon
-- ----------------------------
INSERT INTO `ikon` VALUES (70597830, 684701500, 'w day', '/img/942efc9b2a2747fcb08115a0c5dbcce5.jpg', 427738382, '', '2022-03-21 07:50:04');
INSERT INTO `ikon` VALUES (102902101, 357113363, '香烟与划痕', '/img/2cdd133229d1483ab29fd5b351980ea4.jpg', 427738382, '香烟与划痕', '2022-03-21 07:48:20');
INSERT INTO `ikon` VALUES (218531390, 31358197, '渚薰', '/img/515c27e9814442a3ab3bd1228514b46c.jpg', 281942670, '渚薰', '2022-03-21 07:26:03');
INSERT INTO `ikon` VALUES (272403935, 357113363, 'lianxi', '/img/6e248afc642440cea3aa9c7f0d5bf794.jpg', 427738382, 'lianxi', '2022-03-21 07:43:23');
INSERT INTO `ikon` VALUES (464817686, 31358197, '对面', '/img/2491cece9f7f4189b749f09450bc8d44.jpg', 281942670, '无题', '2022-03-21 07:25:44');
INSERT INTO `ikon` VALUES (749797108, 31358197, '凌波丽', '/img/b73d58807b5641e389df6c21f35b3c4b.jpg', 427738382, '凌波丽赛高', '2022-03-19 14:32:16');
INSERT INTO `ikon` VALUES (819456566, 31358197, 'Asuka', '/img/a6bb4dd5090547a090d6a6773637bc25.jpg', 281942670, 'Asuka', '2022-03-21 07:27:05');
INSERT INTO `ikon` VALUES (849638900, 31358197, '明日香', '/img/97bf3428ab59482a919cc1627d4c51f3.jpg', 281942670, '明日香', '2022-03-21 07:26:18');
INSERT INTO `ikon` VALUES (884244800, 357113363, 'ice', '/img/f402e8b17fca4a3bb7b61a33cba3a00c.jpg', 427738382, 'ice', '2022-03-21 07:45:25');
INSERT INTO `ikon` VALUES (894295404, 357113363, 'Nevermore/Aenygma project', '/img/3a2ae35a33c04a728cdb25230bb877f8.jpg', 427738382, 'Nevermore/Aenygma project', '2022-03-21 07:46:52');

-- ----------------------------
-- Table structure for painter
-- ----------------------------
DROP TABLE IF EXISTS `painter`;
CREATE TABLE `painter`  (
  `id` int(11) NOT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `registration_time` datetime NULL DEFAULT NULL,
  `status` int(255) NULL DEFAULT NULL COMMENT '0:审核中 1:未通过审核 2: 正常 3: 封号中',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of painter
-- ----------------------------
INSERT INTO `painter` VALUES (96298291, 281942670, '2022-03-21 07:13:11', 2);
INSERT INTO `painter` VALUES (149946044, 369705934, '2022-03-21 07:54:39', 3);
INSERT INTO `painter` VALUES (924761967, 427738382, '2022-03-18 12:07:03', 2);

-- ----------------------------
-- Table structure for review
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review`  (
  `id` int(20) UNSIGNED NOT NULL,
  `user_id` int(20) NULL DEFAULT 0,
  `ikon_id` int(11) NULL DEFAULT NULL,
  `context` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `review_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of review
-- ----------------------------
INSERT INTO `review` VALUES (101931214, 1, 749797108, '真漂亮~', '2022-03-19 18:17:53');
INSERT INTO `review` VALUES (307304528, 427738382, 749797108, '+1', '2022-03-20 04:37:01');
INSERT INTO `review` VALUES (334758319, 369705934, 218531390, 'saffojafaioj', '2022-03-21 07:53:02');
INSERT INTO `review` VALUES (681612566, 1, 749797108, 'dddd', '2022-03-22 08:23:09');
INSERT INTO `review` VALUES (691062748, 369705934, 749797108, 'tttt', '2022-03-22 08:24:10');

-- ----------------------------
-- Table structure for thumb
-- ----------------------------
DROP TABLE IF EXISTS `thumb`;
CREATE TABLE `thumb`  (
  `id` int(11) NOT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `Ikon_id` int(11) NULL DEFAULT NULL,
  `thumb_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of thumb
-- ----------------------------
INSERT INTO `thumb` VALUES (485380059, 1, 749797108, '2022-03-20 07:39:23');
INSERT INTO `thumb` VALUES (560026534, 281942670, 749797108, '2022-03-21 07:13:18');
INSERT INTO `thumb` VALUES (999752104, 369705934, 218531390, '2022-03-21 07:53:11');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(100) UNSIGNED NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `registration_time` datetime NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL COMMENT '0:管理员 1：用户 2：画师',
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'ma', '1', '01440227@qq.com', '2022-03-18 12:56:17', 0, '/img/e24086f37e5b46888e54b2f5235a210c.jpg');
INSERT INTO `user` VALUES (281942670, 'eva大师', 'mrwang', '933933@qq.com', '2022-03-21 07:11:46', 2, '/img/logo.png');
INSERT INTO `user` VALUES (369705934, 'myeee', '7777777', 'wjb@lmlm.cn', '2022-03-21 07:52:17', 2, '/img/016989a8dca64be1b7bfdd48c44708a4.jpg');
INSERT INTO `user` VALUES (427738382, 'wang', '123123123', '1401440047@qq.com', '2022-03-18 09:16:04', 2, '/img/logo.png');
INSERT INTO `user` VALUES (597059742, 'log', '123123', '6666@qq.com', '2022-03-18 13:38:06', 1, '/img/logo.png');

SET FOREIGN_KEY_CHECKS = 1;
