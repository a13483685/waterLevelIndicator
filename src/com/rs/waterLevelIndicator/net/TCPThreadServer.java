package com.rs.waterLevelIndicator.net;

import com.rs.waterLevelIndicator.interfaces.CallInsertIntoDbSensor;
import com.rs.waterLevelIndicator.interfaces.ISenserDataChange;
import com.rs.waterLevelIndicator.interfaces.InsertIntoDbSensorImp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPThreadServer implements Runnable{
    private static final int PORT = 6666;

//    public static void main(String[] args) {
//        new Thread(new TCPThreadServer()).start();
//    }

    @Override
    public void run() {
        int count = 1;
        try {
            /**
             * ����һ��ServerSocket���󣬲������ƶ�һ���˿ںţ�
             * ͨ������˿ں��������ͻ��˵����ӣ�����˽��ܿͻ������ӵ�������
             * ����ϵؽ��ܵģ����Է���˵ı��һ�㶼������ֹ������
             */
            ServerSocket ss = new ServerSocket(PORT);
            System.out.println("�������Ѿ�����������");
            while (true) {
                /**
                 * �ڷ���˵���accept()�������ܿͻ��˵����Ӷ���accept()������
                 * һ������ʽ�ķ�����һֱɵɵ�صȴ����Ƿ��пͻ�����������
                 */

                Socket s = ss.accept();//������ �����̻߳���������
                System.out.println("��" + count + "������,IP��ַ�ǣ�"
                        + s.getInetAddress());
                count++;
                /**
                 * �����ʹ�ö��̷߳����ͻ��˵�����
                 * ���ｫ����˵�socket�����ڲ��࣬����ÿ���ͻ��˶�����һ���߳�
                 */
                Thread t = new Thread(new ReceiveTCP(s));
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    class ReceiveTCP  implements Runnable {//�̳��Թ۲��ߣ�Ϊ������

        private String data;//��װ��Ϣ����
        private Socket socket = null;
        private InputStream in = null;
        private OutputStream out = null;
        private CallInsertIntoDbSensor callInsertIntoDbSensor;
        private InsertIntoDbSensorImp insertIntoDbSensorImp;
        private ISenserDataChange senserDataChange;
        public ReceiveTCP(Socket s) {
            this.socket = s;
            callInsertIntoDbSensor = new CallInsertIntoDbSensor();
        }


        @Override
        public void run() {
            try {
                //��ȡ������������Ϣ
                in = socket.getInputStream();
                //����˷��ص���Ϣ
                out = socket.getOutputStream();
                //��һ���ֽ������������Ϣ�����Ч��
                byte[] recData = new byte[1024];
                while (true)
                {
                    in.read(recData);
                    String data = new String(recData);
                    InsertInToDatabase(data);//�����ݲ��뵽���ݿ�
//                    this.mRealtimeDataPanel.
                    System.out.println("��ȡ���ͻ��˷����������ݣ�" + data);
                    //���ظ��ͻ��˵���Ϣ
                    out.write("Hello client I am server".getBytes());
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //�����ݿ��������
        private void InsertInToDatabase(String str) {

            insertIntoDbSensorImp = new InsertIntoDbSensorImp();
            callInsertIntoDbSensor.setOnCallInsertIntoDbSensor(insertIntoDbSensorImp,str);//�����ݿ��������
//        insertIntoDbSensorImp.insertInToDbSensor(str);
//        callInsertIntoDbSensor.setOnCallInsertIntoDbSensor(new IinsertIntoDbSensor() {
//            @Override
//            public void insertInToDbSensor(String SensorInfo) {
//                System.out.println("insertInToDbSensor"+SensorInfo);
//            }
//        },str);
        }
    }
}
