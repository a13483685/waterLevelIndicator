package com.rs.waterLevelIndicator.customView;

import com.rs.waterLevelIndicator.dao.DevicesDao;
import com.rs.waterLevelIndicator.model.DbPageMesReq;
import com.rs.waterLevelIndicator.model.Device;
import com.rs.waterLevelIndicator.utils.BaseTableModule;

import javax.swing.*;
import java.util.List;
import java.util.Vector;

public class DevTable extends JTable{
    private JTable mDevTab= null;
    private BaseTableModule baseTableModule;
    String[] title = {"地址","设备名"};
    private Vector<Vector> mDevDatas;
    private DevicesDao devicesDao = null;
    public DevTable(){
//        initTable();
    }

    public JTable initTable(DbPageMesReq req) {
        devicesDao = new DevicesDao();
        mDevDatas = new Vector<>();
        List<Device> allDevices = devicesDao.getDevList(req);
        for(Device device:allDevices){
            Vector mItems = new Vector();
            mItems.add(device.getmAddress());
            mItems.add(device.getmDeviceName());
            mDevDatas.add(mItems);
        }
        baseTableModule = new BaseTableModule(title,mDevDatas);
        mDevTab = new JTable();
        mDevTab.setModel(baseTableModule);
        return mDevTab;
    }

    public void refreshTable(DbPageMesReq req) {
        devicesDao = new DevicesDao();
        mDevDatas = new Vector<>();
        List<Device> allDevices = devicesDao.getDevList(req);
        for(Device device:allDevices){
            Vector mItems = new Vector();
            mItems.add(device.getmAddress());
            mItems.add(device.getmDeviceName());
            mDevDatas.add(mItems);
        }
        BaseTableModule  baseTableModule = new BaseTableModule(title,mDevDatas);
        baseTableModule = baseTableModule;
        mDevTab.setModel(baseTableModule);
    }


}
