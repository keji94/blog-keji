/*
Navicat MySQL Data Transfer

Source Server         : keji-blog
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : blog_keji

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-08-04 18:03:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_content_article
-- ----------------------------
DROP TABLE IF EXISTS `tb_content_article`;
CREATE TABLE `tb_content_article` (
  `article_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '文章ID',
  `article_title` varchar(50) DEFAULT NULL COMMENT '文章标题',
  `article_content` longtext COMMENT '文章内容',
  `article_status` int(1) DEFAULT '0' COMMENT '状态。可选值:0(正常),1(删除)',
  `article_is_top` int(1) DEFAULT '1' COMMENT '用于设置置顶.可选值：0(置顶)，1(不置顶)',
  `article_category_id` bigint(20) NOT NULL COMMENT '分类id，外键',
  `article_created` datetime DEFAULT NULL COMMENT '创建时间',
  `article_updated` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`article_id`),
  KEY `article_category_id` (`article_category_id`),
  CONSTRAINT `tb_content_article_ibfk_1` FOREIGN KEY (`article_category_id`) REFERENCES `tb_content_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=142 DEFAULT CHARSET=utf8 COMMENT='文章表';

-- ----------------------------
-- Records of tb_content_article
-- ----------------------------
INSERT INTO `tb_content_article` VALUES ('1', '我的第一篇博客', '123', '0', '1', '1', '2017-08-04 15:38:20', '2017-08-04 15:38:23');
INSERT INTO `tb_content_article` VALUES ('2', '我的第二篇博客', '123', '0', '1', '1', '2017-08-04 17:30:22', '2017-08-04 17:30:24');

-- ----------------------------
-- Table structure for tb_content_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_content_category`;
CREATE TABLE `tb_content_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '类目ID',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父类目ID=0时，代表的是一级的类目',
  `name` varchar(50) DEFAULT NULL COMMENT '分类名称',
  `status` int(1) DEFAULT '1' COMMENT '状态。可选值:1(正常),2(删除)',
  `sort_order` int(4) DEFAULT NULL COMMENT '排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数',
  `is_parent` tinyint(1) DEFAULT '1' COMMENT '该类目是否为父类目，1为true，0为false',
  `created` datetime DEFAULT NULL COMMENT '创建时间',
  `updated` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`,`status`) USING BTREE,
  KEY `sort_order` (`sort_order`)
) ENGINE=InnoDB AUTO_INCREMENT=145 DEFAULT CHARSET=utf8 COMMENT='内容分类';

-- ----------------------------
-- Records of tb_content_category
-- ----------------------------
INSERT INTO `tb_content_category` VALUES ('1', '0', '首页', '1', '1', '1', '2017-08-01 13:16:27', '2017-08-01 13:16:32');
INSERT INTO `tb_content_category` VALUES ('2', '1', '全部博客', '1', '2', '0', '2017-08-01 13:18:01', '2017-08-01 13:18:03');
INSERT INTO `tb_content_category` VALUES ('143', '1', '关于我', '1', '1', '0', '2017-08-02 09:52:44', '2017-08-02 09:52:44');
INSERT INTO `tb_content_category` VALUES ('144', '1', '图片', '1', '1', '0', '2017-08-04 14:17:08', '2017-08-04 14:17:08');

-- ----------------------------
-- Table structure for tb_content_picture
-- ----------------------------
DROP TABLE IF EXISTS `tb_content_picture`;
CREATE TABLE `tb_content_picture` (
  `picture_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '图片ID',
  `picture_name` varchar(50) DEFAULT NULL COMMENT '图片名称',
  `picture_source` varchar(255) NOT NULL COMMENT '图片的路径',
  `picture_status` int(1) DEFAULT '0' COMMENT '状态。可选值:0(正常),1(删除)',
  `picture_sort_order` int(4) DEFAULT NULL COMMENT '排列序号，表示同级图片的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数',
  `picture_created` datetime DEFAULT NULL COMMENT '创建时间',
  `picture_updated` datetime DEFAULT NULL COMMENT '创建时间',
  `article_id` bigint(20) NOT NULL COMMENT '文章ID',
  PRIMARY KEY (`picture_id`),
  KEY `article_id` (`article_id`),
  CONSTRAINT `tb_content_picture_ibfk_1` FOREIGN KEY (`article_id`) REFERENCES `tb_content_article` (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=152 DEFAULT CHARSET=utf8 COMMENT='图片';

-- ----------------------------
-- Records of tb_content_picture
-- ----------------------------
INSERT INTO `tb_content_picture` VALUES ('143', '首页图片轮播1', '/images/001.jpg', '0', '1', '2017-08-04 15:39:18', '2017-08-04 15:39:18', '1');
INSERT INTO `tb_content_picture` VALUES ('144', '首页图片轮播2', '/images/002.jpg', '0', '1', '2017-08-04 16:04:45', '2017-08-04 16:04:45', '1');
INSERT INTO `tb_content_picture` VALUES ('150', '首页图片轮播3', '/images/003.jpg', '0', '1', '2017-08-04 17:58:28', '2017-08-04 17:58:28', '1');
INSERT INTO `tb_content_picture` VALUES ('151', '首页图片轮播4', '/images/004.jpg', '0', '1', '2017-08-04 17:58:56', '2017-08-04 17:58:56', '1');
