package com.rs.waterLevelIndicator.interfaces;


import com.rs.waterLevelIndicator.dao.SenserDataDao;
import com.rs.waterLevelIndicator.model.SensorData;

//接口实现函数
public class InsertIntoDbSensorImp implements IinsertIntoDbSensor{
    //将接收到的传感器数据插入到数据库中
    @Override
    public void insertInToDbSensor(String msg) {
        String[] infos = msg.split(",");
        SensorData sensorData = new SensorData();

        String dev_id = infos[1];
        sensorData.setDev_id(dev_id);

        String konggao = infos[3];
        sensorData.setGaokong(konggao);

        String Upload = infos[5];

        sensorData.setUpload(Upload);

        String UpLimit = infos[7];

        sensorData.setUpLimit(UpLimit);

        String DownLimit = infos[9];

        sensorData.setDownLimit(DownLimit);

        String Watt = infos[11];

        sensorData.setWatt(Watt);

        String GpsSignal = infos[13];
        sensorData.setComStatus(GpsSignal);

        String comStatus = infos[15];

        sensorData.setGpsSignal(comStatus);
//        System.out.println("GpsSignal is :"+sensorData.getGpsSignal());


//        System.out.println("comStatus is :"+sensorData.getComStatus());


//        System.out.println("Watt is :"+sensorData.getWatt());

        String time = infos[17];
        sensorData.setTime(time);

        String waterLevel = infos[19];
        sensorData.setWaterLevel(waterLevel);
//        System.out.println("waterLevel is :"+sensorData.getWaterLevel());

        String devStatus = infos[21];
        sensorData.setDevStatus(devStatus);
        
//        System.out.println("infos is :"+infos);
        new SenserDataDao().insertIntoDb(sensorData);
    }
}
