package com.ams.entities.admin;

/**
 * Created by Reason on 2016/3/28.
 */
public class UserMessageInfo {
    private Integer id;

    private MessageInfo message;

    private UserInfo toUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "UserMessageInfo{" +
                "id=" + id +
                ", message=" + message +
                ", toUser=" + toUser +
                '}';
    }
}
