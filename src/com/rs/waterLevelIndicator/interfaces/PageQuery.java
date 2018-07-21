package com.rs.waterLevelIndicator.interfaces;

import com.rs.waterLevelIndicator.dao.SenserDataDao;
import com.rs.waterLevelIndicator.model.DbPageMesReq;
import com.rs.waterLevelIndicator.model.SensorData;
import com.rs.waterLevelIndicator.utils.DbPage;
import org.junit.Test;

import java.util.List;

/**
 *分页查询实际类
 */
public class PageQuery implements IDbPageManager{
    private SenserDataDao messageMapper;
    @Override
    public DbPage<SensorData> queryMessage(DbPageMesReq req) {
        DbPage<SensorData> page = new DbPage<SensorData>();
        messageMapper = new SenserDataDao();
        int pageCount = messageMapper.getMessageNum();//得到总条数
        System.out.println("总数为："+pageCount);
        page = initPage(page, pageCount, req);

        List<SensorData> message= messageMapper.queryMessage(req);//分页查询
        if (!message.isEmpty()) {
            page.setDatas(message);
        }
        return page;

    }

    private DbPage<SensorData> initPage(DbPage<SensorData> page, int pageCount, DbPageMesReq req) {
        page.setTotalRecord(pageCount);
        page.setCurrentPage(req.getCurrentPage());
        page.setPageSize(req.getPageSize());
        req.setStartIndexEndIndex();
        System.out.println("page is :"+page.toString());
        return page;
    }
    @Test
    public void test(){
        DbPageMesReq dbPageMesReq = new DbPageMesReq();
        dbPageMesReq.setCurrentPage(1);
        dbPageMesReq.setStartIndex(1);
        PageQuery iDbPageManagerImp = new PageQuery();
        iDbPageManagerImp.queryMessage(dbPageMesReq);
    }
}
