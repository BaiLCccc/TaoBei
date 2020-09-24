package cn.kgc.entity;

import java.util.List;

public class Page<T> {
    //索引
    private int index;
    //每页显示的条数
    private int pageSize;
    //总页数
    private int totalPage;
    //总记录数
    private int totalCount;
    //存放数据的集合
    private List<T> data;
    //当前页
    private int pageNum;

    public int getIndex() {
        return (getPageNum()-1)*getPageSize();
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        if(getTotalCount()%getPageSize()==0){
            return getTotalCount()/getPageSize();
        }else{
            return getTotalCount()/getPageSize()+1;
        }
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getPageNum() {
        if(pageNum<1){
            return 1;
        }
        if(pageNum>getTotalPage()){
            return getTotalPage();
        }
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
}
