package com.ams.dao.admin;

/**
 * Created by Reason on 2016/5/1.
 */
public interface SystemMapper {
    void updateTimeliness(Integer days);
    Integer getTimeliness();
}
