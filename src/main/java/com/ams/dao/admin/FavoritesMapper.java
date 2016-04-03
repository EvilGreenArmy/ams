package com.ams.dao.admin;

import com.ams.entities.admin.FavoritesInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Evan on 2016/4/3.
 */
@Repository
public interface FavoritesMapper {

    List<FavoritesInfo> favoritesQueryPage(Map map);

    void insertFavorites(FavoritesInfo favoritesInfo);

    void deleteFavorites(Integer[] ids);
}
