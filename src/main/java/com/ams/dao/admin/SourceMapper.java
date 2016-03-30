package com.ams.dao.admin;

import com.ams.entities.admin.SourceInfo;
import com.ams.entities.admin.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Evan on 2016/3/27.
 */
@Repository
public interface SourceMapper {

    List<SourceInfo> sourceQueryPage(Map map);

    List<SourceInfo> getParentSource(UserInfo user);

    List<SourceInfo> getChildrenSource(UserInfo user);

    void insertSource(SourceInfo source);

    List<SourceInfo> getSourceById(Integer id);

    void updateSource(SourceInfo source);

    void deleteSource(Integer[] ids);

}
