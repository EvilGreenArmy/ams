package com.ams.tag;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Evan on 2016/3/12.
 */
public class PageBean implements Serializable {


    private int pageNo;          //页码
    private int pageSize;        //每页行数
    private int totalRows;      //总记录数
    private int totalPage;        //总页数
    private int currentPage; //当前页
    private List<?> dataList; //数据

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<?> getDataList() {
        return dataList;
    }

    public void setDataList(List<?> dataList) {
        this.dataList = dataList;
    }
}
