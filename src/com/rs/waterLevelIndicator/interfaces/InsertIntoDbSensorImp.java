package com.rs.waterLevelIndicator.interfaces;


import com.rs.waterLevelIndicator.dao.SenserDataDao;
//�ӿ�ʵ�ֺ���
public class InsertIntoDbSensorImp implements IinsertIntoDbSensor{
    //�����յ��Ĵ��������ݲ��뵽���ݿ���
    @Override
    public void insertInToDbSensor(String SensorInfo) {
        System.out.println("SensorInfo is :"+SensorInfo);
        new SenserDataDao().insertIntoDb(SensorInfo);
    }
}
