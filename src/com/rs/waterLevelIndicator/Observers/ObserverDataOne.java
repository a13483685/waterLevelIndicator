package com.rs.waterLevelIndicator.Observers;

import com.rs.waterLevelIndicator.interfaces.CallInsertIntoDbSensor;
import com.rs.waterLevelIndicator.interfaces.InsertIntoDbSensorImp;
import com.rs.waterLevelIndicator.view.MainFrm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.applet.Main;

/**
 * �۲��Ƿ������ݽ��ܣ�����֮�����ϲ��뵽���ݿ�
 */
public class ObserverDataOne implements ObserverData{
    private CallInsertIntoDbSensor callInsertIntoDbSensor = null;
    private InsertIntoDbSensorImp insertIntoDbSensorImp;
    public  Logger log = null;
    public ObserverDataOne(){
        log = LoggerFactory.getLogger(ObserverDataOne.class);
        callInsertIntoDbSensor = new CallInsertIntoDbSensor();
    }

    //�����ݿ��������
    private void InsertInToDatabase(String str) {

        insertIntoDbSensorImp = new InsertIntoDbSensorImp();
        callInsertIntoDbSensor.setOnCallInsertIntoDbSensor(insertIntoDbSensorImp,str);//�����ݿ��������
    }
    @Override
    public void update(String string) {
        String msg = string;
        log.info("接收到客户端的数据是:{}",msg);
//        System.out.println("接收到客户端的数据是 :"+msg);
        if(string.startsWith("devid")&&string.length()>50)
        InsertInToDatabase(msg);
        //���뵽���ݿ�
    }
}
