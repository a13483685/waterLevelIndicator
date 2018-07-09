package com.rs.waterLevelIndicator.dao;

import com.rs.waterLevelIndicator.model.SensorData;
import com.rs.waterLevelIndicator.utils.StringUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Observer;

public class SenserDataDao extends BaseDao{

//    private T t;
//    public SenserDataDao(T t) {
//        this.t = t;
//    }
    public List<SensorData> getSensorDataList(){
        List<SensorData> sensorDatas = new ArrayList<SensorData>();
        String sql = "select * from  s_sensorData";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                SensorData sd = new SensorData();
                String id = resultSet.getString("id");
                String gaokong = resultSet.getString("konggao");
                System.out.println("konggao is :"+gaokong);
                String upload = resultSet.getString("upload");
                String upLimit = resultSet.getString("upLimit");
                String dowmLimit = resultSet.getString("dowmLimit");
                String GPS_signal = resultSet.getString("GPS_signal");
                String status = resultSet.getString("comStatus");
                String watt = resultSet.getString("watt");
                System.out.println("watt is :"+watt);
                String time = resultSet.getString("time");
                String waterLevel = resultSet.getString("waterLevel");
                System.out.println("waterLevel is :"+waterLevel);
                String devStatus = resultSet.getString("devStatus");
                System.out.println("devStatus is :"+devStatus);

                sd.setDev_id(id);
                sd.setDownLimit(dowmLimit);
                sd.setGaokong(gaokong);
                sd.setGpsSignal(GPS_signal);
                sd.setTime(time);
                sd.setUpLimit(upLimit);
                sd.setUpload(upload);
                sd.setComStatus(status);
                sd.setWaterLevel(waterLevel);
                sd.setDevStatus(devStatus);
                sd.setWatt(watt);
                System.out.println("SensorData is :"+sd.toString());
                sensorDatas.add(sd);
                System.out.println("get sensordata id:"+ id +" gaokong :"+gaokong +
                " upload :"+upload + " upLimit :" + upLimit + " dowmLimit :" +dowmLimit
                +" GPS_signal :"+GPS_signal+" status :"+status+" time:"+time
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sensorDatas;
    }
//往数据库插入数据
    public void insertIntoDb(String str){

        String[] SensorInfo = str.split(",");
        SensorData sensorData = new SensorData();

        String dev_id = SensorInfo[1];
        sensorData.setDev_id(dev_id);

        String konggao = SensorInfo[3];
        sensorData.setGaokong(konggao);

        String Upload = SensorInfo[5];
        sensorData.setUpload(Upload);

        String UpLimit = SensorInfo[7];
        sensorData.setUpLimit(UpLimit);

        String DownLimit = SensorInfo[9];
        sensorData.setDownLimit(DownLimit);

        String GpsSignal = SensorInfo[11];
        sensorData.setGpsSignal(GpsSignal);

        String comStatus = SensorInfo[13];
        sensorData.setComStatus(comStatus);

        String Watt = SensorInfo[15];
        sensorData.setWatt(Watt);

        String time = SensorInfo[17];
        sensorData.setTime(time);

        String waterLevel = SensorInfo[19];
        sensorData.setWaterLevel(waterLevel);
        System.out.println("waterLevel is :"+sensorData.getWaterLevel());

        String devStatus = SensorInfo[21];
        sensorData.setDevStatus(devStatus);
        System.out.println("devStatus is :"+sensorData.getDevStatus());


        System.out.println("sensorData -----------------"+sensorData.toString());
        String sql = "insert into s_sensorData values(null,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,konggao);
            preparedStatement.setString(2,Upload);
            preparedStatement.setString(3,UpLimit);
            preparedStatement.setString(4,DownLimit);
            preparedStatement.setString(5,GpsSignal);
            preparedStatement.setString(6,comStatus);
            preparedStatement.setString(7,Watt);
            preparedStatement.setString(8,"123");
            preparedStatement.setString(9,waterLevel);
            preparedStatement.setString(10,devStatus);
            if(preparedStatement.executeUpdate() >0){//更新界面
//                //插入数据成功
//                DatabaseChangeOberver databaseChangeOberver = new DatabaseChangeOberver();
//                databaseChangeOberver.addObserver((Observer) t);//将插入成功的状态传递给观察者
//                String msg = "success";
//                databaseChangeOberver.changeValues(msg);
//                databaseChangeOberver.notifyObservers(msg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
