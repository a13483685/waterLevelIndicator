package com.rs.waterLevelIndicator.dao;

import com.rs.waterLevelIndicator.model.DbPageMesReq;
import com.rs.waterLevelIndicator.model.EventType;
import com.rs.waterLevelIndicator.model.SensorData;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventTypeDao extends BaseDao{
    String sqlInsert = "insert into s_eventtype(DevId,EventType,dateTime) values(?,?,?)";
    public void insertIntoDb(String msg){
        String[] infos = msg.split(",");
        String devId = infos[0];
        String devMsg = infos[1];
        String date = infos[2];
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sqlInsert);
            preparedStatement.setString(1,devId);
            preparedStatement.setString(2,devMsg);
            preparedStatement.setString(3,date);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeDao();
        }
    }

    //数据库分页查询
    public List<EventType> getSensorDataList(DbPageMesReq req){
        List<EventType> mEventTypeDatas = new ArrayList<>();
        String sql = "select d.address,d.devDesc,d.dutyPerson,e.DevId,e.EventType,e.dateTime from s_devices AS d,s_eventtype AS e WHERE d.devId = e.DevId LIMIT ?,? ";
        mEventTypeDatas = getSenseData(req, mEventTypeDatas, sql);
        return mEventTypeDatas;
    }

    private List<EventType> getSenseData(DbPageMesReq req, List<EventType> sensorDatas, String sql) {
        try {
            PreparedStatement ps = con.prepareStatement(sql);
//            int startIndex = req.getStartIndex()*req.getPageSize();
            int startIndex = req.getStartIndex();
            int offsetIndex = req.getPageSize();
            ps.setInt(1,startIndex);
            ps.setInt(2,offsetIndex);
            //  System.out.println("sql is :"+sql);
//            System.out.println("recode is from :"+startIndex+"to"+(startIndex+offsetIndex));
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                EventType mEventType = new EventType();
                String address = resultSet.getString("address");
                String devDesc = resultSet.getString("devDesc");
                String devId = resultSet.getString("DevId");
                String eventType = resultSet.getString("EventType");
                String dutyPerson = resultSet.getString("dutyPerson");
                String dateTime = resultSet.getString("dateTime");
                mEventType.setAddress(address);
                mEventType.setDevDesc(devDesc);
                mEventType.setmDevId(devId);
                mEventType.setmEventType(eventType);
                mEventType.setDutyPerson(dutyPerson);
                mEventType.setmTime(dateTime);
                sensorDatas.add(mEventType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeDao();
        }
        return sensorDatas;
    }

    public int getMessageNum(){
        String sql = "select count(*) as total from s_eventtype";
        PreparedStatement ps = null;
        int total = 0;
        try {
            ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                total = resultSet.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeDao();
        }
        return total;
    }
}
