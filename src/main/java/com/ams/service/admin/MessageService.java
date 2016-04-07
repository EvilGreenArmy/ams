package com.ams.service.admin;

import com.ams.entities.admin.MessageInfo;
import com.ams.entities.admin.UserMessageInfo;
import com.ams.pagination.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by Reason on 2016/3/28.
 */
public interface MessageService {

    public Page<MessageInfo> queryList(Map<String, Object> paramMap);

    public void saveMessage(MessageInfo message, Integer[] toUsers);

    public  MessageInfo getMessageById(Integer id);

    public void setRead(Integer id);

    public Integer queryUnreadMessage(Integer id);

}
