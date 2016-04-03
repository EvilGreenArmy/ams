package com.ams.entities.admin;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Evan on 2016/4/3.
 */
public class CompetitionInfo {

    private Integer id;

    private BigDecimal comValue;

    private Date createTime;

    private UserInfo userInfo;

    private ProductInfo productInfo;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getComValue() {
        return comValue;
    }

    public void setComValue(BigDecimal comValue) {
        this.comValue = comValue;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
