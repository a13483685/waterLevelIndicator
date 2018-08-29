package com.rs.waterLevelIndicator.services;

import com.rs.waterLevelIndicator.dao.DevicesDao;
import com.rs.waterLevelIndicator.interfaces.MessageMapper;
import com.rs.waterLevelIndicator.model.DbPageMesReq;
import com.rs.waterLevelIndicator.model.Device;

import java.sql.SQLException;
import java.util.List;

public class DevicePageQuery implements MessageMapper<Device> {

    private DevicesDao devicesDao;
    public DevicePageQuery(){
        devicesDao = new DevicesDao();
    }
    @Override
    public List<Device> queryMessage(DbPageMesReq msg) {
        List<Device> allDevices = null;
        try {
             allDevices= devicesDao.getAllDevices();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allDevices;
    }

    @Override
    public int getMessageNum() {
        int totalNum = 0;
        totalNum = devicesDao.getTotalNum();
        return totalNum;
    }

    @Override
    public void QueryClose() {
        devicesDao.closeDao();
    }
}
