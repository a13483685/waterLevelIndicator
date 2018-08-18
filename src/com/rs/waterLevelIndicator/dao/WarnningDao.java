package com.rs.waterLevelIndicator.dao;

import com.rs.waterLevelIndicator.model.DbPageMesReq;
import com.rs.waterLevelIndicator.model.EventType;
import com.rs.waterLevelIndicator.model.WarnningType;
import jdk.nashorn.internal.runtime.regexp.joni.Warnings;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WarnningDao extends BaseDao{
    public void insertIntoWarnning(String devId,String warringType,String dataTime){
        String insertSql = "insert into s_warnning values(?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = con.prepareStatement(insertSql);
            preparedStatement.setString(1,devId);
            preparedStatement.setString(2,warringType);
            preparedStatement.setString(3,dataTime);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeDao();
        }
    }

    public List<WarnningType> getWarnningDataList(DbPageMesReq req){
        List<WarnningType> mWarnningTypeDatas = new ArrayList<>();
        String sql = "select d.address,d.devDesc,d.dutyPerson,w.devId,w.warringType ,w.dateTime from s_devices AS d,s_warnning AS w WHERE d.devId = w.devId LIMIT ?,?";
        List<WarnningType> senseData = getSenseData(req, mWarnningTypeDatas, sql);
        return senseData;
    }

    private List<WarnningType> getSenseData(DbPageMesReq req, List<WarnningType> sensorDatas, String sql) {
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
                WarnningType mWarnningType = new WarnningType();
                String address = resultSet.getString("address");
                String devDesc = resultSet.getString("devDesc");
                String devId = resultSet.getString("DevId");
                String warringType = resultSet.getString("warringType");
                String dutyPerson = resultSet.getString("dutyPerson");
                String dateTime = resultSet.getString("dateTime");
                mWarnningType.setAddress(address);
                mWarnningType.setDevDesc(devDesc);
                mWarnningType.setmDevId(devId);
                mWarnningType.setmWarnningType(warringType);
                mWarnningType.setDutyPerson(dutyPerson);
                mWarnningType.setmTime(dateTime);
                sensorDatas.add(mWarnningType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeDao();
        }
        return sensorDatas;
    }

    public int getMessageNum(){
        String sql = "select count(*) as total from s_warnning";
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
