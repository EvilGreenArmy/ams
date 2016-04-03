package com.ams.service.admin.impl;

import com.ams.dao.admin.CommentMapper;
import com.ams.entities.admin.CommentInfo;
import com.ams.pagination.Page;
import com.ams.service.admin.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Evan on 2016/4/3.
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper dao;

    @Override
    public Page<CommentInfo> queryList(Map<String, Object> paramMap) {
        Page<CommentInfo> page = (Page<CommentInfo>) paramMap.get("page");
        List<CommentInfo> result = dao.commentQueryPage(paramMap);
        page.setResultList(result);
        return page;
    }

    @Transactional
    public void saveComment(CommentInfo commentInfo) {
        dao.insertComment(commentInfo);
    }

    @Transactional
    public void deleteComment(Integer[] ids) {
        dao.deleteComment(ids);
    }


}
