package com.rs.waterLevelIndicator.Observers;

import java.util.Observable;
import java.util.Observer;

public class SensorDataChangeOberver extends Observable {
    //第一步，封装消息数据
    private String data;
    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
    }
    public void changeValues(String data){
        this.data = data;
        setChanged();
    }
}
