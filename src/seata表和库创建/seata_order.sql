use seata_order;



create table t_order
(
	id bigint(11) auto_increment primary key,
	user_id bigint(11) default null comment '用户id',
	product_id bigint(11) default null comment '产品id',
	count int(11) default null comment '数量',
	money decimal(11,0) default null comment '金额',
	status int(11) default null comment '订单状态，0创建中 1已完结'
);


CREATE TABLE `undo_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(100) NOT NULL,
  `context` varchar(128) NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime NOT NULL,
  `log_modified` datetime NOT NULL,
  `ext` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
