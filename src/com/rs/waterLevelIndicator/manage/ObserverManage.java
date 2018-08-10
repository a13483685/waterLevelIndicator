package com.rs.waterLevelIndicator.manage;

import com.rs.waterLevelIndicator.Observers.DevDbOberver;

import java.util.ArrayList;
import java.util.List;

public class ObserverManage {
    public List<DevDbOberver> observers = new ArrayList<>();

    public void atach(DevDbOberver obs){
        observers.add(obs);
    }
    public void detach(DevDbOberver obs){
        if(obs!=null)
            observers.remove(obs);
    }
    public void notifyMsg(){
        for (DevDbOberver observer:observers) {
            observer.update(true);
        }
    }
}
