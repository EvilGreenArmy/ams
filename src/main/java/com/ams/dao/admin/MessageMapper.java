package com.ams.dao.admin;

import com.ams.entities.admin.MessageInfo;
import com.ams.entities.admin.UserMessageInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by Reason on 2016/3/28.
 */
public interface MessageMapper {

    public List<MessageInfo> messageQueryPage(Map map);

    public void insertMessage(MessageInfo message);

    public MessageInfo getMessageById(Integer id);

    public void updateStatus(Map map);

    public Integer queryUnreadMessage(Integer id);

    public List<Integer> getAllUserIds();

    public void insertUserMessage(Map map);

}
