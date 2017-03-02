/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50537
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2017-03-01 16:24:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `content` mediumtext NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('1', 'hehe1212', 'JFinal Demo Content here');
INSERT INTO `blog` VALUES ('7', '12', '1212');
INSERT INTO `blog` VALUES ('8', '123', 'asd');
INSERT INTO `blog` VALUES ('11', '12', '1231212312312312');
INSERT INTO `blog` VALUES ('15', 'android', 'asdfsadf');
INSERT INTO `blog` VALUES ('16', '242', '2424');
INSERT INTO `blog` VALUES ('17', '12', '1212qweqwe');
INSERT INTO `blog` VALUES ('18', 'hehe', '12312312313');
INSERT INTO `blog` VALUES ('19', 'hehe', '12312312313');
INSERT INTO `blog` VALUES ('20', 'hehe', '12312312313');
INSERT INTO `blog` VALUES ('21', 'hehe', '12312312313');
INSERT INTO `blog` VALUES ('22', 'hehe', '12312312313');
INSERT INTO `blog` VALUES ('23', 'hehe', '12312312313');
INSERT INTO `blog` VALUES ('24', 'hehe', '12312312313');
INSERT INTO `blog` VALUES ('25', 'hehe', '12312312313');
INSERT INTO `blog` VALUES ('26', 'hehe', '12312312313');
INSERT INTO `blog` VALUES ('27', '1212', 'asfsdf');
INSERT INTO `blog` VALUES ('28', '1212', 'asfsdf');
INSERT INTO `blog` VALUES ('29', 'sdfsadf', 'sdaf');
INSERT INTO `blog` VALUES ('30', 'sdfsadf', 'sdaf');
INSERT INTO `blog` VALUES ('31', 'text1', 'sdf');
INSERT INTO `blog` VALUES ('32', '123', '123123');
INSERT INTO `blog` VALUES ('33', 'sdfsadf', 'sadfsadf');
INSERT INTO `blog` VALUES ('34', 'sdfsadf', 'sadfsadf');
