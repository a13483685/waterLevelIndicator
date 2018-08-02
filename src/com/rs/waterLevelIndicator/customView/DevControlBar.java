package com.rs.waterLevelIndicator.customView;

import com.rs.waterLevelIndicator.dao.DevicesDao;
import com.rs.waterLevelIndicator.model.DbPageMesReq;
import com.rs.waterLevelIndicator.Observers.*;
import com.rs.waterLevelIndicator.services.DevicePageQuery;

//设备管理界面中的控制条
public class DevControlBar extends ControlBar implements DevDbOberver {
    int messageNum = 0;
    DevTable devTable = null;
    public DevControlBar(DevTable jTable, DbPageMesReq req){
        super(req);
        this.devTable = jTable;
    }
    @Override
    public void refreshTable(DbPageMesReq req) {
        upDate();
        this.devTable.refreshTable(req);
    }
//观察数据是否发送改变
    @Override
    public void update(boolean isSuccess) {
        System.out.println("有新的数据发生了改变");
        this.devTable.refreshTable(req);
    }
}
