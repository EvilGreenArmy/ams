--创建系统表

create table B_DUTY
(
  DUTY_ID     NUMBER not null PRIMARY KEY,
  DUTY_NAME   VARCHAR2(240),
  STATUS      VARCHAR2(6) not null,
  DESCRIPTION VARCHAR2(400)
);
comment on table B_DUTY
  is '角色表';
comment on column B_DUTY.DUTY_ID
  is '角色ID';
comment on column B_DUTY.DUTY_NAME
  is '角色名称';
comment on column B_DUTY.STATUS
  is '状态(A: 可用  D: 禁用)';
comment on column B_DUTY.DESCRIPTION
  is '描述';

create table B_ACCOUNT_DUTY
(
  ACC_DUTY_ID NUMBER not null primary key,
  DUTY_ID     NUMBER not null,
  ACCT_ID     NUMBER not null
);
comment on table B_ACCOUNT_DUTY
  is '用户角色表';
comment on column B_ACCOUNT_DUTY.DUTY_ID
  is '角色ID';
comment on column B_ACCOUNT_DUTY.ACCT_ID
  is '用户ID';

create table B_DUTY_SOURCE
(
  DUTY_SOURCE_ID NUMBER not null PRIMARY KEY,
  SOURCE_ID      NUMBER not null,
  DUTY_ID        NUMBER not null
);
comment on table B_DUTY_SOURCE
  is '角色菜单权限表';
comment on column B_DUTY_SOURCE.SOURCE_ID
  is '菜单ID';
comment on column B_DUTY_SOURCE.DUTY_ID
  is '角色ID';

-- Create table
create table B_CATEGORY
(
  CATEGORY_ID   NUMBER not null,
  CATEGORY_NAME VARCHAR2(50),
  STATUS        VARCHAR2(6),
  PARENT_ID     NUMBER
);
-- Add comments to the table
comment on table B_CATEGORY
  is '数据字典';
-- Add comments to the columns
comment on column B_CATEGORY.CATEGORY_ID
  is '主键';
comment on column B_CATEGORY.CATEGORY_NAME
  is '字典名称';
comment on column B_CATEGORY.STATUS
  is '字典状态 A-可用 D-不可用';
comment on column B_CATEGORY.PARENT_ID
  is '父级主键';