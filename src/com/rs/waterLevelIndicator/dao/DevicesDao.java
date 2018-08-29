package com.rs.waterLevelIndicator.dao;

import com.rs.waterLevelIndicator.customView.DevTable;
import com.rs.waterLevelIndicator.model.DbPageMesReq;
import com.rs.waterLevelIndicator.model.Device;
import com.rs.waterLevelIndicator.model.SensorData;
import com.rs.waterLevelIndicator.services.DevicePageQuery;
import com.rs.waterLevelIndicator.utils.Constans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DevicesDao extends BaseDao {
    String sqlSelect = "select * from s_devices";
    String sqlInsert = "insert s_devices(id,address,devId,devDesc,dutyPerson) values(?,?,?,?,?)";
    String sqlId = "select id from s_devices";
    List<Device> devices = null;
//    PreparedStatement ps = null;
//    ResultSet resultSet = null;
    private DevTable dt= null;
    private DbPageMesReq req;
    private int id;

    public DevicesDao(DevTable dt,DbPageMesReq req){
        this.dt = dt;
        this.req = req;
    }
    public DevicesDao(){
        super();
    }

    //数据分页查询
    public List<Device>  getDevList(DbPageMesReq req){
        List<Device> Devices = new ArrayList<>();
        String sql = "select * from  s_devices order by id DESC limit ?,?";
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = con.prepareStatement(sql);
//            int startIndex = req.getStartIndex()*req.getPageSize();
            int startIndex = req.getStartIndex();
            int offsetIndex = req.getPageSize();
            ps.setInt(1,startIndex);
            ps.setInt(2,offsetIndex);

            System.out.println("recode is from :"+startIndex+"to"+(startIndex+offsetIndex));
            resultSet= ps.executeQuery();
            while (resultSet.next()){
                Device device = new Device();
                String address = resultSet.getString("address");
                String devId = resultSet.getString("devId");
                String devDesc = resultSet.getString("devDesc");
                String dutyPerson = resultSet.getString("dutyPerson");

                device.setmAddress(address);
                device.setmDevDesc(devDesc);
                device.setmDeviceId(devId);
                device.setmDutyPerson(dutyPerson);
                Devices.add(device);
            }
        }catch (SQLException e){

        }finally {
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if(ps!=null)
                {
                    try {
                        ps.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if(con!=null){
                    try {
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return Devices;
    }

    /**
     * 获得所有的设备
     */
    public List<Device> getAllDevices() throws SQLException {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = con.prepareStatement(sqlSelect);
            devices = new ArrayList<>();
            resultSet = ps.executeQuery();
            while (resultSet.next()){
                Device device = new Device();
                String address = resultSet.getString("address");
                String devId = resultSet.getString("devId");
                String devDesc = resultSet.getString("devDesc");
                String dutyPerson = resultSet.getString("dutyPerson");

                device.setmAddress(address);
                device.setmDevDesc(devDesc);
                device.setmDeviceId(devId);
                device.setmDutyPerson(dutyPerson);
                devices.add(device);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(resultSet!=null){
                resultSet.close();
            }
            if(ps !=null){
                ps.close();
            }
//            if(con !=null){
//                con.close();
//            }
        }
        return devices;
    }

    public int getTotalNum()  {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        int total = 0;
        try {
            ps = con.prepareStatement(Constans.sqlTotla+"s_devices");
            resultSet = ps.executeQuery();
            while (resultSet.next()){
                total = resultSet.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(ps !=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
//            if(con !=null){
//                con.close();
//            }
        }
        return total;
    }

    private int getId() throws SQLException {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = con.prepareStatement(sqlId);
            resultSet = ps.executeQuery();
            while (resultSet.next()){
                id = resultSet.getInt("id");
            }
//            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(resultSet!=null){
                resultSet.close();
            }
            if(ps !=null){
                ps.close();
            }
//            if(con !=null){
//                con.close();
//            }
        }
        return 0;
    }
    public Boolean insertDevice(String address,String devDesc,String devId,String dutyPerson) throws SQLException {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        boolean isSuccess = false;
        try {
            getId();
            ps = con.prepareStatement(sqlInsert);
            ps.setInt(1,++id);
            ps.setString(2,address);
            ps.setString(3,devId);
            ps.setString(4,devDesc);
            ps.setString(5,dutyPerson);
//            ps.executeQuery();
            if(!ps.execute()){
                //数据插入成功
//                id++;
                isSuccess = true;
                return isSuccess;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(resultSet!=null){
                resultSet.close();
            }
            if(ps !=null){
                ps.close();
            }
//            if(con !=null){
//                con.close();
//            }
        }
        return isSuccess;
    }

    /**
     * 通过设备id来返回设备对象
     * @param devId
     * @return  Device对象
     */
    public Device SelectDevMsg(String devId){
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Device device = null;
        String sqlSelete = "select * from s_devices where devId = ?";
        try {
            ps = con.prepareStatement(sqlSelete);
            ps.setString(1,devId);
            resultSet = ps.executeQuery();
            if(resultSet.next()){
                String address = resultSet.getString("address");
                String deviceId = resultSet.getString("devId");
                String devDesc = resultSet.getString("devDesc");
                String dutyPerson = resultSet.getString("dutyPerson");
                device = new Device();
                device.setmAddress(address);
                device.setmDeviceId(deviceId);
                device.setmDevDesc(devDesc);
                device.setmDutyPerson(dutyPerson);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return device;
    }

    public boolean deleteDevice(String devId) throws SQLException {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        String sqlDelete = "delete from s_devices where devId = ?";
        boolean isSuccess = false;
        try {
            ps = con.prepareStatement(sqlDelete);
            ps.setString(1,devId);
            if(!ps.execute()){
                isSuccess = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(resultSet!=null){
                resultSet.close();
            }
            if(ps !=null){
                ps.close();
            }
//            if(con !=null){
//                con.close();
//            }
        }
        return isSuccess;
    }

    public boolean upDateDevMsg(String address,String devName,String devId,String dutyPerson,String selected) {
        String sqlUpdate = "UPDATE s_devices SET address = ?,devId = ?,devDesc = ?,dutyPerson = ? WHERE devId = ?";
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        boolean isSuccess = false;
        try {
            ps = con.prepareStatement(sqlUpdate);
            ps.setString(1,address);
            ps.setString(2,devId);
            ps.setString(3,devName);
            ps.setString(4,dutyPerson);
            ps.setString(5,selected);
            if(!ps.execute()){
                isSuccess = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("msg is : address is :"+address+"devId:"+devId+",devName:"+devName+",dutyPerson:"+dutyPerson+",selected is:"+selected);
        return isSuccess;
    }
}
