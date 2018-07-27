package com.rs.waterLevelIndicator.model;
//��ҳ��ѯ���ݿ�ʵ����
public class DbPageMesReq {
    private String memberId;//��Աid
    private int currentPage =1;//��ǰҳ
    private int pageSize = 30;//һҳ��������¼
    private int startIndex = 1;//����һ�п�ʼ
    private int endIndex;//����һ�н���

    private int totalPage = 0; //��ҳ��
    private int totalRecord = 0; //�ܼ�¼��

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


    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
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
    //���ݵ�ǰ����ҳ����ÿҳ��ʾ��¼�������startIndex��endIndex
    public void setStartIndexEndIndex(){
        this.startIndex=(this.getCurrentPage()-1)*this.getPageSize();
        this.endIndex= (this.getCurrentPage()-1)*this.getPageSize()+this.getPageSize();
    }

}
