package com.ams.dao.admin;

import com.ams.entities.admin.RoleInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Evan on 2016/3/30.
 */
@Repository
public interface RoleMapper {
    List<RoleInfo> roleQueryPage(Map map);

    void insertRole(RoleInfo roleInfo);

    List<RoleInfo> getRoleById(Integer id);

    void updateRole(RoleInfo roleInfo);

    void deleteRole(Integer[] ids);
}
