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
    public void saveMessage(MessageInfo message, Integer[] toUsers) {

        messageDao.insertMessage(message);

    }
}
