package com.rs.waterLevelIndicator.model;

/**
 * 设备模型
 */
public class Device {
    private String mAddress;
    private String mDeviceName;

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getmDeviceName() {
        return mDeviceName;
    }

    public void setmDeviceName(String mDeviceName) {
        this.mDeviceName = mDeviceName;
    }

    @Override
    public String toString() {
        return "Devices{" +
                "mAddress='" + mAddress + '\'' +
                ", mDeviceName='" + mDeviceName + '\'' +
                '}';
    }
}
