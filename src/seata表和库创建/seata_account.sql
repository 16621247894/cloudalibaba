use seata_account;

create table t_account
(
	id bigint(11) auto_increment primary key,
	user_id bigint(11) default null comment '用户id',
	total bigint(11) default null comment '总额度',
	used int(11) default null comment '已用余额',
	residue decimal(11,0) default null comment '剩余可用余额'
);

insert into t_account
select null,1,1000,0,1000 ;

select * from t_account;




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
