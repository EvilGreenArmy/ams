package com.ams.entities.admin;

import java.util.Date;

/**
 * 成果和专利对象
 * Created by Reason on 2016/3/26.
 */
public class ProductInfo {

    // 主键
    private Integer id;
    // 名称
    private String name;
    // 单位
    private String organization;
    // 研究开始时间
    private Date startDate;
    // 研究结束时间
    private Date endDate;
    // 通讯地址
    private String addr;
    // 联系人
    private String linkman;
    // 所在区域
    private String area;
    // 内容简介
    private String content;
    // 联系电话
    private String telephone;
    // 竞价单位
    private String priceUnit;
    // 邮编
    private String zipCode;
    // 类型 成果 | 专利
    private String type;
    // 编辑时间
    private Date editDate;



}
