INSERT INTO SYS_ROLE
VALUES (1, '用户', 'ROLE_USER', 'TYPE_TRUE');
INSERT INTO `SYS_ROLE`
VALUES (2, '管理员', 'ROLE_ADMIN', 'TYPE_TRUE');

INSERT INTO `SYS_USER`
VALUES (1, 'admin', '', '$2a$10$O0IWrzzkPqupuWOwzCHwoOJvegbYA0wMD7n6pQdIhMTr2/lVLT9A.');

INSERT INTO `SYS_USER_ROLE`
VALUES (1, 1, 1);