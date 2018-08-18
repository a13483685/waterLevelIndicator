package com.rs.waterLevelIndicator.model;

public class WarnningType {
    String mDevId;
    String mWarnningType;
    String mTime;
    String devDesc;
    String dutyPerson;
    String address;

    public String getmDevId() {
        return mDevId;
    }

    public void setmDevId(String mDevId) {
        this.mDevId = mDevId;
    }

    public String getmWarnningType() {
        return mWarnningType;
    }

    public void setmWarnningType(String mWarnningType) {
        this.mWarnningType = mWarnningType;
    }

    public String getmTime() {
        return mTime;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }

    public String getDevDesc() {
        return devDesc;
    }

    public void setDevDesc(String devDesc) {
        this.devDesc = devDesc;
    }

    public String getDutyPerson() {
        return dutyPerson;
    }

    public void setDutyPerson(String dutyPerson) {
        this.dutyPerson = dutyPerson;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
