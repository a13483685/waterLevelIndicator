package com.rs.waterLevelIndicator.Observers;

import com.rs.waterLevelIndicator.interfaces.CallInsertIntoDbSensor;
import com.rs.waterLevelIndicator.interfaces.InsertIntoDbSensorImp;

/**
 * 观察是否有数据接受，接受之后马上插入到数据库
 */
public class ObserverDataOne implements ObserverData{
    private CallInsertIntoDbSensor callInsertIntoDbSensor = null;
    private InsertIntoDbSensorImp insertIntoDbSensorImp;

    public ObserverDataOne(){
        callInsertIntoDbSensor = new CallInsertIntoDbSensor();
    }

    //往数据库插入数据
    private void InsertInToDatabase(String str) {

        insertIntoDbSensorImp = new InsertIntoDbSensorImp();
        callInsertIntoDbSensor.setOnCallInsertIntoDbSensor(insertIntoDbSensorImp,str);//往数据库插入数据
    }
    @Override
    public void update(String string) {
        System.out.println("getMsg is :"+string);
        InsertInToDatabase(string);
        //插入到数据库

    }
}
