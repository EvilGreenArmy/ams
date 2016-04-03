package com.ams.entities.admin;

import java.util.Date;

/**
 * Created by Reason on 2016/3/28.
 */
public class MessageInfo {

    private Integer id;

    private String title;

    private String content;
    // 状态 N-未阅读 R-阅读 D-删除
    private String status;

    private UserInfo fromUser;

    private UserInfo toUser;

    private Date sendDate;

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserInfo getFromUser() { return fromUser; }

    public void setFromUser(UserInfo fromUser) { this.fromUser = fromUser; }

    public UserInfo getToUser() {
        return toUser;
    }

    public void setToUser(UserInfo toUser) {
        this.toUser = toUser;
    }

    @Override
    public String toString() {
        return "MessageInfo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                ", fromUser=" + fromUser +
                ", sendDate=" + sendDate +
                '}';
    }
}
