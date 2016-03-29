package com.ams.service.admin.impl;

import com.ams.dao.admin.MessageMapper;
import com.ams.entities.admin.MessageInfo;
import com.ams.entities.admin.UserMessageInfo;
import com.ams.service.admin.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Reason on 2016/3/28.
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageDao;

    @Override
    public List<MessageInfo> queryList() {
        return null;
    }

    @Override
    public void saveMessage(UserMessageInfo message) {

    }
}
