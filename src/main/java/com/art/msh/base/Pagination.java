package com.art.msh.base;

import java.util.List;

/**
 * 项目描述:
 *
 * @Author 高小雄
 * 创建时间:2017/7/9
 * 修改时间:
 */
public class Pagination<T> {
    private int pageNo;
    private int pageSize;
    private List<Object> objList;
    private List<T> list;

    private long totalRecord; // 页面的记录

    public long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
    }

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

    public List<Object> getObjList() {
        return objList;
    }

    public void setObjList(List<Object> objList) {
        this.objList = objList;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
