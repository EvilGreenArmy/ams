
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