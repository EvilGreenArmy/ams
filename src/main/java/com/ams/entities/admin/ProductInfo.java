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
    // 状态 A-可用 D-删除
    private String status;
    // 添加时间
    private Date addDate;
    // 添加用户
    private UserInfo addUser;
    // 修改时间
    private Date editDate;
    // 修改用户
    private UserInfo editUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public UserInfo getAddUser() {
        return addUser;
    }

    public void setAddUser(UserInfo addUser) {
        this.addUser = addUser;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    public UserInfo getEditUser() {
        return editUser;
    }

    public void setEditUser(UserInfo editUser) {
        this.editUser = editUser;
    }
}
