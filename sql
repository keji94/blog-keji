#数据库#
create database blog_keji;

#分类表#
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
) ENGINE=InnoDB AUTO_INCREMENT=142 DEFAULT CHARSET=utf8 COMMENT='内容分类';

#文章表#
CREATE TABLE `tb_content_article` (
  `article_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '文章ID',
  `article_title` varchar(50) DEFAULT NULL COMMENT '文章标题',
	`article_content` LONGTEXT DEFAULT NULL COMMENT '文章内容',
  `article_status` int(1) DEFAULT '0' COMMENT '状态。可选值:0(正常),1(删除)',
  `article_is_top` int(1) DEFAULT '1' COMMENT '用于设置置顶.可选值：0(置顶)，1(不置顶)',
  `article_category_id` bigint(20) NOT NUll COMMENT '分类id，外键' ,
  `article_created` datetime DEFAULT NULL COMMENT '创建时间',
  `article_updated` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`article_id`),
	FOREIGN KEY (article_category_id) REFERENCES tb_content_category(id)
) ENGINE=InnoDB AUTO_INCREMENT=142 DEFAULT CHARSET=utf8 COMMENT='文章表';

#图片表#
CREATE TABLE `tb_content_picture` (
  `picture_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '图片ID',
  `picture_name` varchar(50) DEFAULT NULL COMMENT '图片名称',
	`picture_source` varchar(255) NOT NULL COMMENT '图片的路径',
  `picture_status` int(1) DEFAULT '0' COMMENT '状态。可选值:0(正常),1(删除)',
  `picture_sort_order` int(4) DEFAULT NULL COMMENT '排列序号，表示同级图片的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数',
  `picture_created` datetime DEFAULT NULL COMMENT '创建时间',
  `picture_updated` datetime DEFAULT NULL COMMENT '创建时间',
	`article_id` bigint(20) NOT NULL  COMMENT '文章ID',
  PRIMARY KEY (`picture_id`),
	FOREIGN KEY (article_id) REFERENCES tb_content_article(article_id)
) ENGINE=InnoDB AUTO_INCREMENT=142 DEFAULT CHARSET=utf8 COMMENT='图片';