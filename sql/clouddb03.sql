/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : clouddb03

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-03-31 01:22:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `dept_no` bigint(20) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(60) DEFAULT NULL,
  `db_source` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`dept_no`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '开发部', 'clouddb03');
INSERT INTO `dept` VALUES ('2', '人事部', 'clouddb03');
INSERT INTO `dept` VALUES ('3', '销售部', 'clouddb03');
INSERT INTO `dept` VALUES ('4', '网络部', 'clouddb03');
