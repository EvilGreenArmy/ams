package com.ams.service.admin.impl;

import com.ams.dao.admin.MessageMapper;
import com.ams.entities.admin.MessageInfo;
import com.ams.entities.admin.UserMessageInfo;
import com.ams.pagination.Page;
import com.ams.service.admin.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Reason on 2016/3/28.
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageDao;

    @Override
    public Page<MessageInfo> queryList(Map<String, Object> paramMap) {
        Page<MessageInfo> page = (Page<MessageInfo>)paramMap.get("page");
        List<MessageInfo> result = messageDao.messageQueryPage(paramMap);
        page.setResultList(result);
        return page;
    }

    @Override
    public Page<MessageInfo> queryFrontList(Map<String, Object> paramMap) {
        Page<MessageInfo> page = (Page<MessageInfo>)paramMap.get("page");
        List<MessageInfo> result = messageDao.messageFrontQueryPage(paramMap);
        page.setResultList(result);
        return page;
    }

    @Override
    public void saveMessage(MessageInfo message, Integer toUser) {
        messageDao.insertMessage(message);

        if(null == toUser){
            List<Integer> toUsers = messageDao.getAllUserIds();
            for(Integer id : toUsers){
                Map<String, Object> param = new HashMap<String, Object>();
                param.put("messageId",message.getId());
                param.put("toUserId",id);
                messageDao.insertUserMessage(param);
            }
        }else{
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("messageId",message.getId());
            param.put("toUserId",toUser);
            messageDao.insertUserMessage(param);
        }
    }

    @Override
    public MessageInfo getMessageById(Integer id) {
        return messageDao.getMessageById(id);
    }

    @Override
    public void setRead(Integer id) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id",id);
        paramMap.put("status","R");
        messageDao.updateStatus(paramMap);
    }

    @Override
    public Integer queryUnreadMessage(Integer id) {
        return messageDao.queryUnreadMessage(id);
    }
}
