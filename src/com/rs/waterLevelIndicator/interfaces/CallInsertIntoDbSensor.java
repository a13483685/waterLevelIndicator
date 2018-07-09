package com.rs.waterLevelIndicator.interfaces;

public class CallInsertIntoDbSensor {
    IinsertIntoDbSensor insertIntoDbSensor = null;
    public void setOnCallInsertIntoDbSensor(IinsertIntoDbSensor insertIntoDbSensor,String str){
        this.insertIntoDbSensor = insertIntoDbSensor;
        this.insertIntoDbSensor.insertInToDbSensor(str);
    }
}
