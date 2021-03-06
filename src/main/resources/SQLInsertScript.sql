-- 初始化数据
insert into B_ACCOUNT (ACCT_ID, ACCT_NAME, USER_NAME, FULL_NAME, ACCT_PWD, STATUS, DESCRIPTION, GENDER, BIRTHDAY, EMAIL, PHONE)
values (1, 'admin', '超级管理员', null, '2C25BA49189DD3B3BDA3569CD0B07D74', 'A', '系统超级管理员', null, null, null, null);

insert into B_SOURCE (SOURCE_ID, SOURCE_NAME, SOURCE_CODE, STATUS, SOURCE_LEVEL, SOURCE_STYLE, POSITION, IS_MENU, DESCRIPTION, ICON, PARENT_ID)
values (1, '系统管理', '#', 'A', 1, '010000000000', 0, 1, null, null, null);
insert into B_SOURCE (SOURCE_ID, SOURCE_NAME, SOURCE_CODE, STATUS, SOURCE_LEVEL, SOURCE_STYLE, POSITION, IS_MENU, DESCRIPTION, ICON, PARENT_ID)
values (2, '用户管理', '/user/list.do', 'A', 1, '010100000000', 0, 1, null, null, 1);
insert into B_SOURCE (SOURCE_ID, SOURCE_NAME, SOURCE_CODE, STATUS, SOURCE_LEVEL, SOURCE_STYLE, POSITION, IS_MENU, DESCRIPTION, ICON, PARENT_ID)
values (3, '角色管理', '/duty/list.do', 'A', 1, '010200000000', 0, 1, null, null, 1);
insert into B_SOURCE (SOURCE_ID, SOURCE_NAME, SOURCE_CODE, STATUS, SOURCE_LEVEL, SOURCE_STYLE, POSITION, IS_MENU, DESCRIPTION, ICON, PARENT_ID)
values (4, '菜单管理', '/source/list.do', 'A', 1, '010300000000', 0, 1, null, null, 1);
insert into B_SOURCE (SOURCE_ID, SOURCE_NAME, SOURCE_CODE, STATUS, SOURCE_LEVEL, SOURCE_STYLE, POSITION, IS_MENU, DESCRIPTION, ICON, PARENT_ID)
values (5, '字典管理', '/category/list.do', 'A', 1, '010400000000', 0, 1, null, null, 1);


insert into B_DUTY (DUTY_ID, DUTY_NAME, STATUS, DESCRIPTION)
values (1, '管理员', 'A', '管理员');


insert into B_ACCOUNT_DUTY (ACC_DUTY_ID, DUTY_ID, ACCT_ID)
values (1, 1, 1);
insert into B_DUTY_SOURCE (DUTY_SOURCE_ID, SOURCE_ID, DUTY_ID)
values (1, 2, 1);
insert into B_DUTY_SOURCE (DUTY_SOURCE_ID, SOURCE_ID, DUTY_ID)
values (2, 3, 1);
insert into B_DUTY_SOURCE (DUTY_SOURCE_ID, SOURCE_ID, DUTY_ID)
values (3, 4, 1);
insert into B_DUTY_SOURCE (DUTY_SOURCE_ID, SOURCE_ID, DUTY_ID)
values (4, 5, 1);