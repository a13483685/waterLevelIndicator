package com.rs.waterLevelIndicator.model;

import java.sql.Time;

public class SensorData {
    private String dev_id;
    private String gaokong ;
    private String upload ;
    private String upLimit ;
    private String downLimit ;
    private String watt ;
    private String gpsSignal ;
    private String ComStatus ;
    private String time ;
    private String devStatus ;
    private String waterLevel ;

    public String getDevStatus() {
        return devStatus;
    }

    public void setDevStatus(String devStatus) {
        this.devStatus = devStatus;
    }

    public String getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(String waterLevel) {
        this.waterLevel = waterLevel;
    }

    public String getDev_id() {
        return dev_id;
    }

    public void setDev_id(String dev_id) {
        this.dev_id = dev_id;
    }

    public String getGaokong() {
        return gaokong;
    }

    public void setGaokong(String gaokong) {
        this.gaokong = gaokong;
    }

    public String getUpload() {
        return upload;
    }

    public void setUpload(String upload) {
        this.upload = upload;
    }

    public String getUpLimit() {
        return upLimit;
    }

    public void setUpLimit(String upLimit) {
        this.upLimit = upLimit;
    }

    public String getDownLimit() {
        return downLimit;
    }

    public void setDownLimit(String downLimit) {
        this.downLimit = downLimit;
    }

    public String getWatt() {
        return watt;
    }

    public void setWatt(String watt) {
        this.watt = watt;
    }

    public String getGpsSignal() {
        return gpsSignal;
    }

    public void setGpsSignal(String gpsSignal) {
        this.gpsSignal = gpsSignal;
    }

    public String getComStatus() {
        return ComStatus;
    }

    public void setComStatus(String ComStatus) {
        this.ComStatus = ComStatus;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "SensorData{" +
                "dev_id='" + dev_id + '\'' +
                ", gaokong='" + gaokong + '\'' +
                ", upload='" + upload + '\'' +
                ", upLimit='" + upLimit + '\'' +
                ", downLimit='" + downLimit + '\'' +
                ", watt='" + watt + '\'' +
                ", gpsSignal='" + gpsSignal + '\'' +
                ", ComStatus='" + ComStatus + '\'' +
                ", time='" + time + '\'' +
                ", devStatus='" + devStatus + '\'' +
                ", waterLevel='" + waterLevel + '\'' +
                '}';
    }
}
