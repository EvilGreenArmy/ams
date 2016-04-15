package com.ams.entities.admin;

import java.util.Date;

/**
 * Created by Reason on 2016/3/28.
 */
public class UserMessageInfo {
    private Integer id;

    private String status;

    private Date readDate;

    private MessageInfo message;

    private UserInfo toUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getReadDate() {
        return readDate;
    }

    public void setReadDate(Date readDate) {
        this.readDate = readDate;
    }

    public MessageInfo getMessage() {
        return message;
    }

    public void setMessage(MessageInfo message) {
        this.message = message;
    }

    public UserInfo getToUser() {
        return toUser;
    }

    public void setToUser(UserInfo toUser) {
        this.toUser = toUser;
    }
}
