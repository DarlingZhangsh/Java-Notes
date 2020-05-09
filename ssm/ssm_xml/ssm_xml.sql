/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : ssm_xml

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 31/05/2019 12:30:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginacct` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userpswd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createtime` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('zsh', 1, 'zsh', 'zsh', 'darling.com', '2019-41-10');
INSERT INTO `t_user` VALUES ('zss', 2, 'zss', 'zss', 'zss.com', NULL);
INSERT INTO `t_user` VALUES ('zzy', 3, 'zzy', 'zzy', 'zzy.com', NULL);
INSERT INTO `t_user` VALUES ('w', 25, 'w', '123456', 'w', '2019-41-10');
INSERT INTO `t_user` VALUES (NULL, 30, NULL, NULL, NULL, NULL);
INSERT INTO `t_user` VALUES (NULL, 99, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
