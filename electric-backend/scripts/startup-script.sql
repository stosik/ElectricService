CREATE SCHEMA IF NOT EXISTS electric;
SELECT * FROM electric.role;
INSERT INTO `electric`.`role` (`role_id`, `name`) VALUES ('0', 'ROLE_USER');
INSERT INTO `electric`.`role` (`role_id`, `name`) VALUES ('1', 'ROLE_ADMIN');