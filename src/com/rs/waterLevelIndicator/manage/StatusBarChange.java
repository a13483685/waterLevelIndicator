package com.rs.waterLevelIndicator.manage;

import com.rs.waterLevelIndicator.interfaces.StatusBarListener;
import com.rs.waterLevelIndicator.model.StatusbarEvent;

import java.util.Vector;

public class StatusBarChange {
    private String totalDevNum;

    private String SelectDev;

    private String bluethoothSelect;

    Vector listeners = new Vector();

    public void addListener(StatusBarListener l) {
        if(!listeners.contains(l))
        listeners.add(l);
    }

    //总设备数
    public void setOnlineDevNum(String onlineDevNum) {
        StatusbarEvent e = new StatusbarEvent();
        e.setOnLineDevNum(onlineDevNum);
        fireChanged(e);
    }


    //总设备数
    public void setTotalDevNum(String totalDevNum) {
        StatusbarEvent e = new StatusbarEvent();
        e.setTotalDevNum(totalDevNum);
        fireChanged(e);
    }
    //当前选中设备
    public void setSelectDev(String selectDev) {
        StatusbarEvent e = new StatusbarEvent();
        e.setSelectedDev(selectDev);
        fireChanged(e);
    }
    //设置蓝牙状态
    public void setBluethoothStatus(String bluethoothSelect) {
        StatusbarEvent e = new StatusbarEvent();
        e.setBluethoothStatus(bluethoothSelect);
        fireChanged(e);
    }
    //通知发送改变
    private void fireChanged(StatusbarEvent e) {
//        StatusbarEvent e = new StatusbarEvent();
        e.setTotalDevNum(totalDevNum);
        notifyToAll(e);
    }
    private void notifyToAll(StatusbarEvent e){
        for (int i = 0; i < listeners.size(); i++) {
            StatusBarListener l = (StatusBarListener) listeners.elementAt(i);
            l.selectChanged(e);
        }
    }
}
