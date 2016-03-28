package com.ams.entities.admin;

/**
 * Created by Reason on 2016/3/27.
 */
public class CategoryInfo {
    private Integer id;

    private String name;

    // 字典状态  A - 可用  D - 删除
    private String status;

    private CategoryInfo parent;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CategoryInfo getParent() {
        return parent;
    }

    public void setParent(CategoryInfo parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "CategoryInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", parent=" + parent +
                '}';
    }
}
