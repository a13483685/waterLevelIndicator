package com.rs.waterLevelIndicator.model;
//��ҳ��ѯ���ݿ�ʵ����
public class DbPageMesReq {
    private String memberId;//��Աid
    private int currentPage =1;//��ǰҳ
    private int pageSize = 30;//һҳ��������¼
    private int startIndex = 1;//����һ�п�ʼ
    private int endIndex;//����һ�н���

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public int getCurrentPage() {
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
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

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
