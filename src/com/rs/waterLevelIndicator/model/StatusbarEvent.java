package com.rs.waterLevelIndicator.model;

public class StatusbarEvent {
    private String totalDevNum;//总设备数
    private String selectedDev;//选中设备
    private String bluethoothStatus;//蓝牙状态
    private String onLineDevNum;//在线设备数

    public String getOnLineDevNum() {
        return onLineDevNum;
    }

    public void setOnLineDevNum(String onLineDevNum) {
        this.onLineDevNum = onLineDevNum;
    }

    public String getBluethoothStatus() {
        return bluethoothStatus;
    }

    public void setBluethoothStatus(String bluethoothStatus) {
        this.bluethoothStatus = bluethoothStatus;
    }

    public String getTotalDevNum() {
        return totalDevNum;
    }

    public void setTotalDevNum(String totalDevNum) {
        this.totalDevNum = totalDevNum;
    }

    public String getSelectedDev() {
        return selectedDev;
    }

    public void setSelectedDev(String selectedDev) {
        this.selectedDev = selectedDev;
    }

//    public String getValue() {
//        return totalDevNum;
//    }
//
//    public void setValue(String totalDevNum) {
//        this.totalDevNum = totalDevNum;
//    }
}
