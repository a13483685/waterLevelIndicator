package com.rs.waterLevelIndicator.customView;

import com.rs.waterLevelIndicator.model.DbPageMesReq;
//设备管理界面中的控制条
public class DevControlBar extends ControlBar{
    DevTable devTable = null;
    public DevControlBar(DevTable jTable,DbPageMesReq req){
        super(req);
        this.devTable = jTable;
    }
    @Override
    public void refreshTable(DbPageMesReq req) {
        this.devTable.refreshTable(req);
    }
}
