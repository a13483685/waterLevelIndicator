package com.rs.waterLevelIndicator.interfaces;


import com.rs.waterLevelIndicator.dao.SenserDataDao;
//接口实现函数
public class InsertIntoDbSensorImp implements IinsertIntoDbSensor{
    //将接收到的传感器数据插入到数据库中
    @Override
    public void insertInToDbSensor(String SensorInfo) {
        System.out.println("SensorInfo is :"+SensorInfo);
        new SenserDataDao().insertIntoDb(SensorInfo);
    }
}
