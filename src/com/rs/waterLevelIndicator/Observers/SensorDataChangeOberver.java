package com.rs.waterLevelIndicator.Observers;

import java.util.Observable;
import java.util.Observer;

public class SensorDataChangeOberver extends Observable {
    //��һ������װ��Ϣ����
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
