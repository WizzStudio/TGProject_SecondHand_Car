CREATE TABLE `t_car` (
 
 `id` int(11) NOT NULL AUTO_INCREMENT,
 
 `pic` varchar(100) DEFAULT NULL,
 
 `brand` varchar(255) DEFAULT NULL,
 
 `_year` year(4) DEFAULT NULL,

  `publishTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 
 `price` double DEFAULT NULL,
  
`info` text,
  
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `t_manager` (
 
 `mid` int(11) NOT NULL AUTO_INCREMENT,
  
`username` varchar(20) DEFAULT NULL,
  
`password` varchar(20) DEFAULT NULL,

  `repassword` varchar(20) DEFAULT NULL,
 
 PRIMARY KEY (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8