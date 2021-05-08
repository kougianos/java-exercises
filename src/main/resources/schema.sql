DROP TABLE IF EXISTS `dogs`;
CREATE TABLE IF NOT EXISTS `dogs` (
  `id` int NOT NULL AUTO_INCREMENT primary key,
  `name` varchar(50) DEFAULT NULL,
  `age` integer DEFAULT NULL,
  `dob` date DEFAULT NULL
);