package com.rs.waterLevelIndicator.services;

import com.rs.waterLevelIndicator.dao.DevicesDao;
import com.rs.waterLevelIndicator.interfaces.MessageMapper;
import com.rs.waterLevelIndicator.model.DbPageMesReq;
import com.rs.waterLevelIndicator.model.Device;

import java.util.List;

public class DevicePageQuery implements MessageMapper<Device> {

    private DevicesDao devicesDao;
    public DevicePageQuery(){
        devicesDao = new DevicesDao();
    }
    @Override
    public List<Device> queryMessage(DbPageMesReq msg) {
        return devicesDao.getAllDevices();
    }

    @Override
    public int getMessageNum() {
        return devicesDao.getTotalNum();
    }

    @Override
    public void QueryClose() {
        devicesDao.closeDao();
    }
}
