package com.rs.waterLevelIndicator.Observers;

import java.util.Observable;
import java.util.Observer;

public class DatabaseChangeOberver extends Observable {
    //��һ������װ��Ϣ����
    private String data;
    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
    }
    public void changeeValues(String data){
        this.data = data;
        setChanged();
    }
}
