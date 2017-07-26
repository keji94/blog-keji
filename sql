#创建表#
CREATE TABLE tb_content_category(
	id BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '自定义类目id',
  gmt_create DATETIME NOT NULL COMMENT '创建时间',
  gmt_modified DATETIME NOT NULL COMMENT '修改时间',
	category_name varchar(128) NOT NULL COMMENT '自定义类目名称',
	order_no int(11) NOT NULL DEFAULT '0' COMMENT '排序号',
	del tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '状态（0：正常，1：删除）',
	PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT=980800110 DEFAULT CHARSET=utf8 COMMENT='自定义类目表'
;