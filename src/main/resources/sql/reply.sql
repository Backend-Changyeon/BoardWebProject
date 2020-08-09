create table message(
`id` BIGINT(20) not null auto_increment,
`from_user_id` BIGINT(20) not null,
`to_user_id` BIGINT(20) not null,
`content` TEXT not null,
`sent_at` timestamp not null default now(),
primary key(id),
foreign key (from_user_id) references users(id),
foreign key (to_user_id) references users(id)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;