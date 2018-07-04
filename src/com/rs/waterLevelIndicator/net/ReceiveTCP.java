package com.rs.waterLevelIndicator.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceiveTCP implements Runnable {
    private Socket socket = null;
    private InputStream in = null;
    private OutputStream out = null;
    public ReceiveTCP(Socket s) {
        this.socket = s;
    }

    @Override
    public void run() {
        try {
            //获取服务端输入的消息
            in = socket.getInputStream();
            //服务端返回的消息
            out = socket.getOutputStream();
            //用一个字节数字来存放消息，提高效率
            byte[] recData = new byte[1024];
            while (true)
            {
                in.read(recData);
                String data = new String(recData);
                InsertInToDatabase();//将数据插入到数据库
                System.out.println("读取到客户端发送来的数据：" + data);
                //返回给客户端的消息
                out.write("Hello client I am server".getBytes());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void InsertInToDatabase() {

    }
}

class TCPThreadServerDemo implements Runnable{
    private static final int PORT = 6666;

    public static void main(String[] args) {
        new Thread(new TCPThreadServerDemo()).start();
    }

    @Override
    public void run() {
        int count = 1;
        try {
            /**
             * 创建一个ServerSocket对象，并给它制定一个端口号，
             * 通过这个端口号来监听客户端的连接，服务端接受客户端连接的请求是
             * 不间断地接受的，所以服务端的编程一般都永无休止的运行
             */
            ServerSocket ss = new ServerSocket(PORT);
            System.out.println("服务器已经启动。。。");
            while (true) {
                /**
                 * 在服务端调用accept()方法接受客户端的连接对象，accept()方法是
                 * 一个阻塞式的方法，一直傻傻地等待着是否有客户端申请连接
                 */

                Socket s = ss.accept();//阻塞了 但是线程还是在运行
                System.out.println("第" + count + "个连接,IP地址是："
                        + s.getInetAddress());
                count++;
                /**
                 * 服务端使用多线程方便多客户端的连接
                 * 这里将服务端的socket传给内部类，方便每个客户端都创建一个线程
                 */
                Thread t = new Thread(new ReceiveUDP(s));
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}