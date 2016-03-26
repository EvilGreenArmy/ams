package com.ams.entities.admin;

/**
 * Created by Evan on 2016/3/26.
 */
public class SourceInfo {
    private Integer id;

    private String name;

    private String code;

    private String status;

    private Integer level;

    private String style;

    private Integer position;

    private Integer isMenu;

    private String description;

    private String icon;

    private SourceInfo parentInfo;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(Integer isMenu) {
        this.isMenu = isMenu;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public SourceInfo getParentInfo() {
        return parentInfo;
    }

    public void setParentInfo(SourceInfo parentInfo) {
        this.parentInfo = parentInfo;
    }
}
