package com.rs.waterLevelIndicator.dao;

import com.rs.waterLevelIndicator.interfaces.MessageMapper;
import com.rs.waterLevelIndicator.model.DbPageMesReq;
import com.rs.waterLevelIndicator.model.EventType;

import java.util.List;

public class EventDataPageQuery implements MessageMapper<EventType> {
    private EventTypeDao eventTypeDao = null;
    public EventDataPageQuery(){
        eventTypeDao = new EventTypeDao();
    }

    @Override
    public List<EventType> queryMessage(DbPageMesReq msg) {
        return eventTypeDao.getSensorDataList(msg);
    }

    @Override
    public int getMessageNum() {
        return eventTypeDao.getMessageNum();
    }

    @Override
    public void QueryClose() {
        eventTypeDao.closeDao();
    }
}
