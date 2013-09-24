DROP TABLE IF EXISTS `user`;

delimiter $$

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `password` varchar(30) NOT NULL,
  `is_active` enum('ACTIVE','NOT_ACTIVE') NOT NULL DEFAULT 'NOT_ACTIVE',
  `locale` varchar(10) DEFAULT NULL,
  `register_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_login_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `sex` enum('FEMALE','MALE','UNKNOWN') NOT NULL DEFAULT 'UNKNOWN',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8$$