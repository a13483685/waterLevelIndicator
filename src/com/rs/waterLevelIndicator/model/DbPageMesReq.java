package com.rs.waterLevelIndicator.model;
//分页查询数据库实体类
public class DbPageMesReq {
    private String memberId;//会员id
    private int currentPage =1;//当前页
    private int pageSize = 30;//一页多少条记录
    private int startIndex = 1;//从哪一行开始
    private int endIndex;//从哪一行结束

    private int totalPage = 0; //总页数
    private int totalRecord = 0; //总记录数

    public int getTotalPage() {
        if(totalRecord <= 0) {
            return 0;
        }
        int size = totalRecord / pageSize;//总条数/每页显示的条数=总页数
        int mod = totalRecord % pageSize;//最后一页的条数
        if(mod != 0) {
            size++;
        }
        totalPage = size;
        return totalPage;
    }


    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }


    public int getTotalRecord() {
        return totalRecord;
    }

    public int getCurrentPage() {
        if(currentPage <= 0) {
            return 1;
        }
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {

        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartIndex() {
        startIndex = (getCurrentPage() - 1) * pageSize;
        return startIndex;
    }

//    public void setStartIndex(int startIndex) {
//
//    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }
    //根据当前所在页数和每页显示记录数计算出startIndex和endIndex
    public void setStartIndexEndIndex(){
        this.startIndex=(this.getCurrentPage()-1)*this.getPageSize();
        this.endIndex= (this.getCurrentPage()-1)*this.getPageSize()+this.getPageSize();
    }

}
