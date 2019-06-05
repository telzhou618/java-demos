CREATE TABLE `tb_post` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `subject` varchar(100) NOT NULL DEFAULT '' COMMENT '标题',
  `body` varchar(500) NOT NULL DEFAULT '' COMMENT '内容',
  `reads` int(11) NOT NULL DEFAULT '0' COMMENT '浏览量',
  `stars` int(11) NOT NULL DEFAULT '0' COMMENT '收藏数',
  `votes` int(11) NOT NULL DEFAULT '0' COMMENT '点赞数',
  `replies` int(11) NOT NULL DEFAULT '0' COMMENT '回复数',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifyTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `remark` varchar(200) NOT NULL DEFAULT '' COMMENT '备注',
  `deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '0-正常,1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='帖子表';
