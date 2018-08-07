package com.rs.waterLevelIndicator.Observers;

import com.rs.waterLevelIndicator.interfaces.CallInsertIntoDbSensor;
import com.rs.waterLevelIndicator.interfaces.InsertIntoDbSensorImp;

/**
 * �۲��Ƿ������ݽ��ܣ�����֮�����ϲ��뵽���ݿ�
 */
public class ObserverDataOne implements ObserverData{
    private CallInsertIntoDbSensor callInsertIntoDbSensor = null;
    private InsertIntoDbSensorImp insertIntoDbSensorImp;

    public ObserverDataOne(){
        callInsertIntoDbSensor = new CallInsertIntoDbSensor();
    }

    //�����ݿ��������
    private void InsertInToDatabase(String str) {

        insertIntoDbSensorImp = new InsertIntoDbSensorImp();
        callInsertIntoDbSensor.setOnCallInsertIntoDbSensor(insertIntoDbSensorImp,str);//�����ݿ��������
    }
    @Override
    public void update(String string) {
        System.out.println("getMsg is :"+string);
        InsertInToDatabase(string);
        //���뵽���ݿ�

    }
}
