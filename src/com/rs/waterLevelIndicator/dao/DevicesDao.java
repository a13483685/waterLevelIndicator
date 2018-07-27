package com.rs.waterLevelIndicator.dao;

import com.rs.waterLevelIndicator.model.DbPageMesReq;
import com.rs.waterLevelIndicator.model.Device;
import com.rs.waterLevelIndicator.model.SensorData;
import com.rs.waterLevelIndicator.utils.Constans;

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


    //数据分页查询
    public List<Device> getDevList(DbPageMesReq req){
        List<Device> Devices = new ArrayList<>();
        String sql = "select * from  s_devices limit ?,?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
//            int startIndex = req.getStartIndex()*req.getPageSize();
            int startIndex = req.getStartIndex();
            int offsetIndex = req.getPageSize();
            ps.setInt(1,startIndex);
            ps.setInt(2,offsetIndex);

            System.out.println("recode is from :"+startIndex+"to"+(startIndex+offsetIndex));
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                Device device = new Device();
                String address = resultSet.getString("address");
                String devName = resultSet.getString("devName");
                device.setmAddress(address);
                device.setmDeviceName(devName);
                Devices.add(device);
            }
        }catch (SQLException e){

        }

        return Devices;
    }

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

    public int getTotalNum(){
        int total = 0;
        try {
            ps = con.prepareStatement(Constans.sqlTotla+"s_devices");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                total = resultSet.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
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
    public Boolean insertDevice(String address,String devName){
        boolean isSuccess = false;
        try {
            getId();
            ps = con.prepareStatement(sqlInsert);
            ps.setInt(1,++id);
            ps.setString(2,address);
            ps.setString(3,devName);
//            ps.executeQuery();
            if(ps.execute()){
                //数据插入成功
//                id++;
                isSuccess = true;
                return isSuccess;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    public boolean deleteDevice(String devName){
        String sqlDelete = "delete from s_devices where devName = ?";

        try {
            ps = con.prepareStatement(sqlDelete);
            ps.setString(1,devName);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * just for test
     * @param string
     */
//    public static void main(String string[]){
//        DevicesDao devicesDao = new DevicesDao();
//        devicesDao.insertDevice();
//        devicesDao.getAllDevices();
//        devicesDao.closeDao();
//    }
}
