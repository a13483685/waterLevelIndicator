package com.rs.waterLevelIndicator.utils;

import java.util.List;

public class DbPage<T> {
    private int currentPage = 1; // ��ǰҳ
    private int pageSize = 20; //ÿҳ��ʾ��¼��
    private int startRecord = 1; //��ʼ��ѯ��¼
    private int totalPage = 0; //��ҳ��
    private int totalRecord = 0; //�ܼ�¼��

    private List<T> datas;
    public DbPage(){}

    public DbPage(int currentPage, int pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        if(this.currentPage <= 0) {
            this.currentPage = 1;
        }
        if(this.pageSize <=0) {
            this.pageSize = 1;
        }
    }

    public DbPage(int currentPage, int pageSize, int totalRecord) {
        this(currentPage, pageSize);
        this.totalRecord = totalRecord;
        if(this.totalRecord <=0) {
            this.totalRecord = 1;
        }
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
    public int getTotalRecord() {
        if(totalRecord < 0) {
            return 0;
        }
        return totalRecord;
    }
    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }
    public List<T> getDatas() {
        return datas;
    }
    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public int getTotalPage() {
        if(totalRecord <= 0) {
            return 0;
        }
        int size = totalRecord / pageSize;//������/ÿҳ��ʾ������=��ҳ��
        int mod = totalRecord % pageSize;//���һҳ������
        if(mod != 0) {
            size++;
        }
        totalPage = size;
        return totalPage;
    }

    public int getStartRecord() {
        startRecord = (getCurrentPage() - 1) * pageSize;
        return startRecord;
    }

    @Override
    public String toString() {
        return "DbPage{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", startRecord=" + startRecord +
                ", totalPage=" + totalPage +
                ", totalRecord=" + totalRecord +
                ", datas=" + datas +
                '}';
    }
}
