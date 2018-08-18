package com.rs.waterLevelIndicator.model;

/**
 * 设备模型
 */
public class Device {
    private String mAddress;
    private String mDeviceId;
    private String mDevDesc;
    private String mDutyPerson;

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getmDeviceId() {
        return mDeviceId;
    }

    public void setmDeviceId(String mDeviceId) {
        this.mDeviceId = mDeviceId;
    }

    public String getmDevDesc() {
        return mDevDesc;
    }

    public void setmDevDesc(String mDevDesc) {
        this.mDevDesc = mDevDesc;
    }

    public String getmDutyPerson() {
        return mDutyPerson;
    }

    public void setmDutyPerson(String mDutyPerson) {
        this.mDutyPerson = mDutyPerson;
    }
    @Override
    public String toString() {
        return "Device{" +
                "mAddress='" + mAddress + '\'' +
                ", mDeviceId='" + mDeviceId + '\'' +
                ", mDevDesc='" + mDevDesc + '\'' +
                ", mDutyPerson='" + mDutyPerson + '\'' +
                '}';
    }
}
