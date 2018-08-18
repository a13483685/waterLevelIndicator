package com.rs.waterLevelIndicator.dao;

import com.rs.waterLevelIndicator.interfaces.MessageMapper;
import com.rs.waterLevelIndicator.model.DbPageMesReq;
import com.rs.waterLevelIndicator.model.WarnningType;

import java.util.List;

public class WarnningDataPageQuery implements MessageMapper<WarnningType> {
    private WarnningDao warnningDao = null;

    public WarnningDataPageQuery(){
        warnningDao = new WarnningDao();
    }

    @Override
    public List<WarnningType> queryMessage(DbPageMesReq msg) {

        return warnningDao.getWarnningDataList(msg);
    }

    @Override
    public int getMessageNum() {
        return warnningDao.getMessageNum();
    }

    @Override
    public void QueryClose() {

    }
}
