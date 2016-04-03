package com.ams.service.admin;

import com.ams.entities.admin.CompetitionInfo;
import com.ams.pagination.Page;

import java.util.Map;

/**
 * Created by Evan on 2016/4/3.
 */
public interface CompetitionService {

    public Page<CompetitionInfo> queryList(Map<String, Object> paramMap);

    public void saveCompetition(CompetitionInfo competition);
}
