package com.rs.waterLevelIndicator.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ReceiverUdp implements Runnable{
    DatagramSocket ds = null;

    public ReceiverUdp(DatagramSocket ds) {
        this.ds = ds;
    }

    @Override
    public void run() {

        byte[] bytes = new byte[1024];
        DatagramPacket dp =new DatagramPacket(bytes, bytes.length);
        while (true){
            try {
                ds.receive(dp);
                String id = dp.getAddress().getHostAddress();//获得ip
                int port = dp.getPort();
                String str = new String(dp.getData(), 0, dp.getLength());
                if("xie".equalsIgnoreCase(str)){
                    System.out.println("接收到数据");
                }
                System.out.println("ip:--"+id+",端口："+port+"：："+str);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main (String[] args){
        try {
            DatagramSocket receive=new DatagramSocket(7778);
            new Thread(new ReceiverUdp(receive)).start();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
