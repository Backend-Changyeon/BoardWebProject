create table `view_recor`(
`id` BIGINT(20) NOT NULL auto_increment,
`board_id` BIGINT(20) not null,
`user_id` BIGINT(20) not null,
`viewd_at` timestamp default now(),
primary key (id),
foreign key (board_id) references board (id),
foreign key (user_id) references users (id)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;