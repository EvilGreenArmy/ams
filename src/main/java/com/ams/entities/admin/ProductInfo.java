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
    // 中文名称
    private String chineseName;
    // 隶属省部
    private String province;
    // 单位属性
    private String organsAttribute;
    // 单位名称
    private String organization;
    // 研究开始时间
    private Date startDate;
    // 研究结束时间
    private Date endDate;
    // 所在地区
    private String area;
    // 通讯地址
    private String addr;
    // 联系人
    private String linkman;
    // 内容简介
    private String content;
    // 联系电话
    private String telephone;
    // 竞价单位
    private String priceUnit;
    // 邮编
    private String zipCode;
    // 任务来源
    private String taskSource;
    // 有无密级
    private String isSecret;
    // 密级
    private String secretLevel;
    // 技术资料目录
    private String technologyDirectory;
    // 类型 成果 | 专利
    private String type;
    // 状态 1-发布 2-申报 3-交易 4- 完成  5-竞标  6-实施  0-过期 -1 - 删除
    private String status;
    // 成交时间
    private Date transactionDate;
    // 添加用户
    private UserInfo transactionUser;
    // 添加时间
    private Date addDate;
    // 过期时间
    private Date pastDate;
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

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getOrgansAttribute() {
        return organsAttribute;
    }

    public void setOrgansAttribute(String organsAttribute) {
        this.organsAttribute = organsAttribute;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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

    public String getTaskSource() {
        return taskSource;
    }

    public void setTaskSource(String taskSource) {
        this.taskSource = taskSource;
    }

    public String getIsSecret() {
        return isSecret;
    }

    public void setIsSecret(String isSecret) {
        this.isSecret = isSecret;
    }

    public String getSecretLevel() {
        return secretLevel;
    }

    public void setSecretLevel(String secretLevel) {
        this.secretLevel = secretLevel;
    }

    public String getTechnologyDirectory() {
        return technologyDirectory;
    }

    public void setTechnologyDirectory(String technologyDirectory) {
        this.technologyDirectory = technologyDirectory;
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

    public Date getPastDate() {
        return pastDate;
    }

    public void setPastDate(Date pastDate) {
        this.pastDate = pastDate;
    }

    @Override
    public String toString() {
        return "ProductInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", organization='" + organization + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", addr='" + addr + '\'' +
                ", linkman='" + linkman + '\'' +
                ", area='" + area + '\'' +
                ", content='" + content + '\'' +
                ", telephone='" + telephone + '\'' +
                ", priceUnit='" + priceUnit + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", addDate=" + addDate +
                ", addUser=" + addUser +
                ", editDate=" + editDate +
                ", editUser=" + editUser +
                '}';
    }
}
