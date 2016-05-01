package com.ams.dao.admin;

import com.ams.entities.admin.CompetitionInfo;
import com.ams.entities.admin.FavoritesInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Evan on 2016/4/3.
 */
@Repository
public interface CompetitionMapper {
    List<CompetitionInfo> competitionQueryPage(Map map);

    void insertCompetition(CompetitionInfo competitionInfo);

    void deleteCompetition(Integer[] ids);

}
