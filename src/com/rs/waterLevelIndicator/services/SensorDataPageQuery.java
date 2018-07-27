package com.rs.waterLevelIndicator.services;

import com.rs.waterLevelIndicator.dao.SenserDataDao;
import com.rs.waterLevelIndicator.interfaces.MessageMapper;
import com.rs.waterLevelIndicator.model.DbPageMesReq;
import com.rs.waterLevelIndicator.model.SensorData;
import com.rs.waterLevelIndicator.utils.DbPage;
import org.junit.Test;

import java.util.List;

/**
 *分页查询实际类
 */
public class SensorDataPageQuery implements MessageMapper<SensorData> {

    private SenserDataDao senserDataDao;
    public SensorDataPageQuery(){
        senserDataDao = new SenserDataDao();
    }
    @Override
    public List<SensorData> queryMessage(DbPageMesReq msg) {
        return  senserDataDao.getSensorDataList(msg);
    }

    @Override
    public int getMessageNum() {
        return senserDataDao.getMessageNum();
    }

    @Override
    public void QueryClose() {
        senserDataDao.closeDao();
    }

//    //    初始化页数
//    private DbPage<SensorData> initPage(DbPage<SensorData> page, int pageCount, DbPageMesReq req) {
//        page.setTotalRecord(pageCount);
//        page.setCurrentPage(req.getCurrentPage());
//        page.setPageSize(req.getPageSize());
//        req.setStartIndexEndIndex();
//        System.out.println("page is :"+page.toString());
//        return page;
//    }
//    @Test
//    public void test(){
//        DbPageMesReq dbPageMesReq = new DbPageMesReq();
//        dbPageMesReq.setCurrentPage(1);
//        dbPageMesReq.setStartIndex(1);
//        PageQuery iDbPageManagerImp = new PageQuery();
//        iDbPageManagerImp.queryMessage(dbPageMesReq);
//    }
}
