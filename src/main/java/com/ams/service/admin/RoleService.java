package com.ams.service.admin;

import com.ams.entities.admin.RoleInfo;
import com.ams.pagination.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by Evan on 2016/3/30.
 */
public interface RoleService {
    Page<RoleInfo> queryList(Map<String, Object> paramMap);

    public void saveRole(RoleInfo role);

    public RoleInfo getRoleById(Integer id);

    public void updateRole(RoleInfo role);

    public void deleteRole(Integer[] ids);

    public List<RoleInfo> getAllRole();

    public Map<Integer, Integer> getAccountRole(Integer acctId);
}
