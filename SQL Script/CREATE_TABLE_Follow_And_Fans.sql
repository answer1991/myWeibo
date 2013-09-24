delimiter $$

CREATE TABLE `follow_and_fans` (
  `user_id` int(11) NOT NULL,
  `fans_user_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`fans_user_id`),
  KEY `user_id_fk_idx` (`user_id`),
  KEY `fans_user_id_fk_idx` (`fans_user_id`),
  CONSTRAINT `user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fans_user_id_fk` FOREIGN KEY (`fans_user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

