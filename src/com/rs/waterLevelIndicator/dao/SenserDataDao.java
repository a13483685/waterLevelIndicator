package com.rs.waterLevelIndicator.dao;

import com.rs.waterLevelIndicator.model.SensorData;
import com.rs.waterLevelIndicator.utils.StringUtil;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class SenserDataDao extends BaseDao{

    public List<SensorData> getSensorDataList(){
        List<SensorData> sensorDatas = new ArrayList<SensorData>();
        String sql = "select * from  s_sensorData";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                SensorData sd = new SensorData();
                int id = resultSet.getInt("id");
                BigDecimal gaokong = resultSet.getBigDecimal("gaokong");
                System.out.println("gaokong is :"+gaokong);
                BigDecimal upload = resultSet.getBigDecimal("upload");
                BigDecimal upLimit = resultSet.getBigDecimal("upLimit");
                BigDecimal dowmLimit = resultSet.getBigDecimal("dowmLimit");
                BigDecimal GPS_signal = resultSet.getBigDecimal("GPS_signal");
                BigDecimal status = resultSet.getBigDecimal("status");
                Time time = resultSet.getTime("time");
                sd.setDev_id(id);
                sd.setDownLimit(dowmLimit);
                sd.setGaokong(gaokong);
                sd.setGpsSignal(GPS_signal);
                sd.setTime(time);
                sd.setUpLimit(upLimit);
                sd.setUpload(upload);
                sd.setStatus(status);
                System.out.println("SensorData is :"+sd.toString());
                sensorDatas.add(sd);
//                System.out.println("get sensordata id:"+ id +" gaokong :"+gaokong +
//                " upload :"+upload + " upLimit :" + upLimit + " dowmLimit :" +dowmLimit
//                +" GPS_signal :"+GPS_signal+" status :"+status+" time:"+time
//                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sensorDatas;
    }
}
