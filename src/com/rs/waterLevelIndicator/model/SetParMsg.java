package com.rs.waterLevelIndicator.model;

import com.rs.waterLevelIndicator.utils.Constans;

public class SetParMsg {
    private String head = "head,";
    private String headVal = "";
    private String cmd = ",cmd,";
    private String cmdVal = Constans.CMD_DEFAULT;
    private String mContentVal = "";
    private String devId = " ";

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

    public String getHeadVal() {
        return headVal;
    }

    public void setHeadVal(String headVal) {
        this.headVal = headVal;
    }

    public String getCmdVal() {
        return cmdVal;
    }

    public void setCmdVal(String cmdVal) {
        this.cmdVal = cmdVal;
    }

    public String getmContentVal() {
        return mContentVal;
    }

    public void setmContentVal(String mContentVal) {
        this.mContentVal = mContentVal;
    }
    @Override
    public String toString() {
        return "head,"+getHeadVal()+",devid,"+getDevId()+",cmd,"+getCmdVal()+","+getmContentVal();
    }
}
