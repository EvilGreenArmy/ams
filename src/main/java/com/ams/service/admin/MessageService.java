package com.ams.service.admin;

import com.ams.entities.admin.MessageInfo;
import com.ams.entities.admin.UserMessageInfo;
import com.ams.pagination.Page;

import java.util.List;

/**
 * Created by Reason on 2016/3/28.
 */
public interface MessageService {

    public Page<MessageInfo> queryList();

    public void saveMessage(MessageInfo message, Integer[] toUsers);

}
