package com.ams.service.admin.impl;

import com.ams.dao.admin.RoleMapper;
import com.ams.entities.admin.RoleInfo;
import com.ams.entities.admin.SourceDutyInfo;
import com.ams.pagination.Page;
import com.ams.service.admin.RoleService;
import com.ams.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Evan on 2016/3/30.
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {


    @Autowired
    private RoleMapper roleDao;

    @Override
    public Page<RoleInfo> queryList(Map<String, Object> paramMap) {
        Page<RoleInfo> page = (Page<RoleInfo>) paramMap.get("page");
        List<RoleInfo> result = roleDao.roleQueryPage(paramMap);
        page.setResultList(result);
        return page;
    }

    @Transactional
    public void saveRole(RoleInfo role) {
        role.setStatus(Constant.ACTIVE_STATUS);
        roleDao.insertRole(role);
    }

    @Override
    public RoleInfo getRoleById(Integer id) {
        List<RoleInfo> roleList = roleDao.getRoleById(id);
        if (roleList != null && roleList.size() > 0) {
            return roleList.get(0);
        }
        return new RoleInfo();
    }

    @Transactional
    public void updateRole(RoleInfo role) {
        roleDao.updateRole(role);
    }

    @Transactional
    public void deleteRole(Integer[] ids) {
        roleDao.deleteRole(ids);
    }

    @Override
    public List<RoleInfo> getAllRole() {
        return roleDao.findAll();
    }

    @Override
    public Map<Integer, Integer> getAccountRole(Integer acctId) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<RoleInfo> roleList = roleDao.getAccountRole(acctId);
        if(roleList != null && roleList.size() > 0) {
            for(RoleInfo role : roleList) {
                map.put(role.getId(), acctId);
            }
        }
        return map;
    }

    @Transactional
    public void saveSourceDuty(Map<String, Object> map) {
        Integer roleId = Integer.parseInt(map.get("roleId").toString());
        clearSourceDuty(roleId);
        List<SourceDutyInfo> sourceDutyList = (List<SourceDutyInfo>)map.get("sourceDuty");
        if(sourceDutyList != null && !sourceDutyList.isEmpty()) {
            insertSourceDuty(sourceDutyList);
        }
    }
    private void clearSourceDuty(Integer roleId)  {
        roleDao.deleteSourceDuty(roleId);
    }
    private void insertSourceDuty(List<SourceDutyInfo> sourceDutyList) {
        roleDao.insertSourceDuty(sourceDutyList);
    }
}
