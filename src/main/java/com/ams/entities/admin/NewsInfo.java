package com.ams.entities.admin;

import java.util.Date;

/**
 * Created by Evan on 2016/5/2.
 */
public class NewsInfo {

    private Integer id;

    private String title;
    //1：创新孵化服务 2：科技咨询服务 3：知识产权服务 4：科技金融服务 5：找场地 6：找资金 7：找代理 8：找培训
    private String type;

    private String content;

    private UserInfo creator;

    private Date createTime;

    private Integer total;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserInfo getCreator() {
        return creator;
    }

    public void setCreator(UserInfo creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
