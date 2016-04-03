package com.ams.entities.admin;

import java.util.Date;

/**
 * Created by Evan on 2016/4/3.
 */
public class CommentInfo {
    private Integer id;

    private String content;

    private UserInfo orgUser;

    private UserInfo repUser;

    private ProductInfo productInfo;

    private Date creatTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserInfo getOrgUser() {
        return orgUser;
    }

    public void setOrgUser(UserInfo orgUser) {
        this.orgUser = orgUser;
    }

    public UserInfo getRepUser() {
        return repUser;
    }

    public void setRepUser(UserInfo repUser) {
        this.repUser = repUser;
    }

    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }
}
