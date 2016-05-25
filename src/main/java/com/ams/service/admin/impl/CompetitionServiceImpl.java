package com.ams.service.admin.impl;

import com.ams.dao.admin.CompetitionMapper;
import com.ams.entities.admin.CompetitionInfo;
import com.ams.pagination.Page;
import com.ams.service.admin.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Evan on 2016/4/3.
 */
@Service("competitionService")
public class CompetitionServiceImpl implements CompetitionService {


    @Autowired
    private CompetitionMapper dao;

    @Override
    public Page<CompetitionInfo> queryList(Map<String, Object> paramMap) {
        Page<CompetitionInfo> page = (Page<CompetitionInfo>) paramMap.get("page");
        List<CompetitionInfo> result = dao.competitionQueryPage(paramMap);
        page.setResultList(result);
        return page;
    }

    @Transactional
    public void saveCompetition(CompetitionInfo competition) {
        dao.insertCompetition(competition);
    }

    @Transactional
    public void deleteCompetition(Integer[] ids) {
        dao.deleteCompetition(ids);
    }
    @Transactional
    public void updateCompetition(Integer id) {
        dao.updateCompetition(id);
    }
}
