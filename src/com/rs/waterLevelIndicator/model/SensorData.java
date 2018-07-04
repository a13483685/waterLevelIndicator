package com.rs.waterLevelIndicator.model;

import java.math.BigDecimal;
import java.sql.Time;

public class SensorData {
    private int dev_id;
    private BigDecimal gaokong ;
    private BigDecimal upload ;
    private BigDecimal upLimit ;
    private BigDecimal downLimit ;
    private BigDecimal watt ;
    private BigDecimal gpsSignal ;
    private BigDecimal status ;
    private Time time ;
    

    public int getDev_id() {
        return dev_id;
    }

    public void setDev_id(int dev_id) {
        this.dev_id = dev_id;
    }

    public BigDecimal getGaokong() {
        return gaokong;
    }

    public void setGaokong(BigDecimal gaokong) {
        this.gaokong = gaokong;
    }

    public BigDecimal getUpload() {
        return upload;
    }

    public void setUpload(BigDecimal upload) {
        this.upload = upload;
    }

    public BigDecimal getUpLimit() {
        return upLimit;
    }

    public void setUpLimit(BigDecimal upLimit) {
        this.upLimit = upLimit;
    }

    public BigDecimal getDownLimit() {
        return downLimit;
    }

    public void setDownLimit(BigDecimal downLimit) {
        this.downLimit = downLimit;
    }

    public BigDecimal getWatt() {
        return watt;
    }

    public void setWatt(BigDecimal watt) {
        this.watt = watt;
    }

    public BigDecimal getGpsSignal() {
        return gpsSignal;
    }

    public void setGpsSignal(BigDecimal gpsSignal) {
        this.gpsSignal = gpsSignal;
    }

    public BigDecimal getStatus() {
        return status;
    }

    public void setStatus(BigDecimal status) {
        this.status = status;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "SensorData{" +
                "dev_id=" + dev_id +
                ", gaokong=" + gaokong +
                ", upload=" + upload +
                ", upLimit=" + upLimit +
                ", downLimit=" + downLimit +
                ", watt=" + watt +
                ", gpsSignal=" + gpsSignal +
                ", status=" + status +
                ", time=" + time +
                '}';
    }
}
