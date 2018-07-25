package com.rs.waterLevelIndicator.net;

import com.rs.waterLevelIndicator.Observers.ObserverData;
import com.rs.waterLevelIndicator.Observers.ObserverDataOne;
import com.rs.waterLevelIndicator.interfaces.CallInsertIntoDbSensor;
import com.rs.waterLevelIndicator.interfaces.InsertIntoDbSensorImp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static com.rs.waterLevelIndicator.net.TcpServerNonBlockingNIO.server;


/*
 * 一、使用 NIO 完成网络通信的三个核心：
 * 
 * 1. 通道（Channel）：负责连接
 * 		
 * 	   java.nio.channels.Channel 接口：
 * 			|--SelectableChannel
 * 				|--SocketChannel
 * 				|--ServerSocketChannel
 * 				|--DatagramChannel
 * 
 * 				|--Pipe.SinkChannel
 * 				|--Pipe.SourceChannel
 * 
 * 2. 缓冲区（Buffer）：负责数据的存取
 * 
 * 3. 选择器（Selector）：是 SelectableChannel 的多路复用器。用于监控 SelectableChannel 的 IO 状况
 *
 * 4.用2个线程来管理TCP服务器，一个线程用于轮询准备就绪时间，当轮询到有设备连接，开启SelectionKey.OP_READ，然后
 * 再开启读取数据线程，避免了之前传统io写法：每来一个客户端连接，就开启一个子线程来处理数据交互，后期液位计多了
 * 可能系统就会变慢，这也是采用nio的原因
 * 
 */
public class TcpServerNonBlockingNIO {


	//服务端
//	@Test
	public static void server() throws IOException{
		//1. 获取通道
		ServerSocketChannel ssChannel = ServerSocketChannel.open();
		
		//2. 切换非阻塞模式
		ssChannel.configureBlocking(false);
		
		//3. 绑定连接
		ssChannel.bind(new InetSocketAddress(6666));
		
		//4. 获取选择器
		Selector selector = Selector.open();
		
		//5. 将通道注册到选择器上, 并且指定“监听接收事件”
		ssChannel.register(selector, SelectionKey.OP_ACCEPT);
		
		//6. 轮询式的获取选择器上已经“准备就绪”的事件

		while(selector.select() > 0){

			//7. 获取当前选择器中所有注册的“选择键(已就绪的监听事件)”
			Iterator<SelectionKey> it = selector.selectedKeys().iterator();

			while(it.hasNext()){
				//8. 获取准备“就绪”的是事件
				SelectionKey sk = it.next();

				//9. 判断具体是什么事件准备就绪
				if(sk.isAcceptable()){
//					10. 若“接收就绪”，获取客户端连接
					SocketChannel sChannel = ssChannel.accept();

					//11. 切换非阻塞模式
					sChannel.configureBlocking(false);

					//12. 将该通道注册到选择器上
					sChannel.register(selector, SelectionKey.OP_READ);
				}
				else if(sk.isReadable()){
					ReadThread run1 = new ReadThread(sk);
					Thread threadRead = new Thread(run1);
					threadRead.start();
				}
				//15. 取消选择键 SelectionKey
				it.remove();
			}
		}
	}


	public TcpServerNonBlockingNIO(){

		MyThread thread = new MyThread();
		thread.start();
		new Thread(){
			@Override
			public void run() {
				super.run();
				while (true){
					try {
						sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("test:"+new Date().toString());
				}
			}
		}.start();
	}

	public static void main(String str[]){
		MyThread thread = new MyThread();
		thread.start();
		new Thread(){
			@Override
			public void run() {
				super.run();
				while (true){
					try {
						sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("test:"+new Date().toString());
				}
			}
		}.start();
	}
}


class ReadThread implements Runnable{
	SelectionKey sk = null;
	Selector selector = null;
	List<ObserverData> observers = new ArrayList<>();

	ObserverDataOne observerDataOne = null;
	public ReadThread(SelectionKey sk){
		this.sk = sk;
		observerDataOne= new ObserverDataOne();
		observers.add(observerDataOne);
	}

	@Override
	public void run() {
		try{
			//13. 获取当前选择器上“读就绪”状态的通道
			SocketChannel sChannel = (SocketChannel) sk.channel();

			//14. 读取数据
			ByteBuffer buf = ByteBuffer.allocate(1024);

			int len = 0;
			while((len = sChannel.read(buf)) > 0 ){
				buf.flip();
				String s = new String(buf.array(), 0, len);
				System.out.println(s);
//				InsertInToDatabase(s);
				//通知观察者数据发生改变
				for (ObserverData observerData:observers){
					observerData.update(s);
				}
				buf.clear();
			}

		}catch (IOException e){
			e.printStackTrace();
		}
	}
}

class MyThread extends Thread{
	@Override
	public void run() {
		try {
			server();
		} catch (IOException e) {
			e.printStackTrace();
		}
		super.run();
	}
}
