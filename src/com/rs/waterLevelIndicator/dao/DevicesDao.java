package com.rs.waterLevelIndicator.dao;

import com.rs.waterLevelIndicator.model.Device;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DevicesDao extends BaseDao {
    String sqlSelect = "select * from s_devices";
    String sqlInsert = "insert s_devices(id,address,devName) values(?,?,?)";
    String sqlId = "select id from s_devices";
    PreparedStatement ps = null;
    List<Device> devices = null;
    private int id;

    /**
     * 获得所有的设备
     */
    public List<Device> getAllDevices(){
        try {
            ps = con.prepareStatement(sqlSelect);
            ResultSet resultSet = ps.executeQuery();
            devices = new ArrayList<>();
            while (resultSet.next()){
                Device dev = new Device();
                String address = resultSet.getString("address");
                String devName = resultSet.getString("devName");
                dev.setmAddress(address);
                dev.setmDeviceName(devName);
                System.out.println("dev is :"+dev.toString());
                devices.add(dev);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return devices;
    }

    private int getId(){
        try {
            ps = con.prepareStatement(sqlId);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                id = resultSet.getInt("id");
            }
//            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    private Boolean insertDevice(){
        try {
            getId();
            ps = con.prepareStatement(sqlInsert);
            ps.setInt(1,++id);
            ps.setString(2,"医药园");
            ps.setString(3,"no5");
//            ps.executeQuery();
            if(ps.execute()){
                //数据插入成功
//                id++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * just for test
     * @param string
     */
    public static void main(String string[]){
        DevicesDao devicesDao = new DevicesDao();
        devicesDao.insertDevice();
        devicesDao.getAllDevices();
        devicesDao.closeDao();
    }
}
