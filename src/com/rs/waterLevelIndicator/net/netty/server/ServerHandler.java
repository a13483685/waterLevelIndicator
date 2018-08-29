package com.rs.waterLevelIndicator.net.netty.server;

import com.rs.waterLevelIndicator.Observers.ObserverData;
import com.rs.waterLevelIndicator.Observers.ObserverDataOne;
import com.rs.waterLevelIndicator.dao.EventTypeDao;
import com.rs.waterLevelIndicator.manage.StatusBarChange;
import com.rs.waterLevelIndicator.model.StatusbarEvent;
import com.rs.waterLevelIndicator.utils.Constans;
import com.rs.waterLevelIndicator.utils.FunctionHelper;
import com.rs.waterLevelIndicator.utils.StringUtil;
import com.rs.waterLevelIndicator.view.DeviceMonitorJpanel;
import com.rs.waterLevelIndicator.view.MainFrm;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 服务端消息处理
 * @author -xiez-
 *
 */
public class ServerHandler extends SimpleChannelInboundHandler<String> {

	public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
	public static String mInfo = "";
	ObserverDataOne observerDataOne = null;//插入数据库
	List<ObserverData> observers = new ArrayList<>();//当有数据来，要同时给的观察者集合
	StatusBarChange registStatusbarChange =null;
	StatusbarEvent statusbarEvent = null;

	private String info;
	public Logger log = null;
	public static HashMap<String,String> members ;//用于记录设备号和通道号的对应关系
	public static int mConnectCount = 0;


	public ServerHandler(){
		statusbarEvent = new StatusbarEvent();//状态栏信息
		log = LoggerFactory.getLogger(ServerHandler.class);
		observerDataOne= new ObserverDataOne();
		observers.add(observerDataOne);
		members = new HashMap<>();
		observers.add(DeviceMonitorJpanel.mLogContent);//mLogContent 日志框
		observers.add(MainFrm.realtimeData);//realtimeData table中更新内容

		registStatusbarChange = new StatusBarChange();//状态栏
		registStatusbarChange.addListener(MainFrm.mDevStatusBar);
	}
	//2.覆盖了 handlerAdded() 事件处理方法。每当从服务端收到新的客户端连接时，客户端的 Channel 存入 ChannelGroup列表中，并通知列表中的其他客户端 Channel
	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {  // (2)
		Channel incoming = ctx.channel();
		// Broadcast a message to multiple Channels
		channels.writeAndFlush("[SERVER] - " + incoming.remoteAddress() + " channel_id :" + incoming.id() + " 加入\n");
		//添加到channelGroup 通道组
		channels.add(ctx.channel());
//		mConnectCount.get();
//		System.out.println("当前连接数："+ ++mConnectCount);
		statusbarEvent.setOnLineDevNum(String.valueOf(++mConnectCount));
		registStatusbarChange.setOnlineDevNum(statusbarEvent.getOnLineDevNum());
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		Channel incoming = ctx.channel();
		// Broadcast a message to multiple Channels
		channels.writeAndFlush("[SERVER] - " + incoming.remoteAddress() + " 离开\n");
//		mConnectCount.get();
//		System.out.println("当前连接数："+ --mConnectCount);
		statusbarEvent.setOnLineDevNum(String.valueOf(--mConnectCount));
		registStatusbarChange.setOnlineDevNum(statusbarEvent.getOnLineDevNum());
		// A closed Channel is automatically removed from ChannelGroup,
		// so there is no need to do "channels.remove(ctx.channel());"
		}

	/**
	 * 接收到数据之后的处理
 	 * @param ctx
	 * @param msg
	 * @throws Exception
	 */
	@Override
	protected void messageReceived(ChannelHandlerContext ctx, String msg) throws Exception {

		Channel incoming = ctx.channel();
		String channelId = incoming.id().asShortText();
		info = msg.trim();
		log.info("netty 接收到的数据{}",info);
		if(msg.startsWith("devid")){//处理上下线
			String[] infos = info.split(",");
			String devId = infos[1];
			if(!members.containsKey(channelId)){
				members.put(channelId, devId);
				String msgInfo = devId+",上线,"+FunctionHelper.getAllDate();
				new EventTypeDao().insertIntoDb(msgInfo);
			}
		}

		//解决接收到数据，但是不在DeviceMonitorJpanel界面的时候报空指针异常的bug
		if(DeviceMonitorJpanel.mLogContent !=null){
			if(!observers.contains(DeviceMonitorJpanel.mLogContent))
			observers.add(DeviceMonitorJpanel.mLogContent);
		}else {
			if(observers.contains(DeviceMonitorJpanel.mLogContent)){
				observers.remove(DeviceMonitorJpanel.mLogContent);
			}
		}

		if(MainFrm.realtimeData !=null){
			if(!observers.contains(MainFrm.realtimeData))
				observers.add(MainFrm.realtimeData);
		}else {
			if(observers.contains(MainFrm.realtimeData)){
				observers.remove(MainFrm.realtimeData);
			}
		}

		for (ObserverData observerData:observers){
			if(info.startsWith("head")|| info.startsWith("devid")){//客户端发送回来的消息，通知观察者
				observerData.update(info);
			}
		}



//		for (Channel channel : channels) {//遍历ChannelGroup中的channel
//			if (channel != incoming){//找到加入到ChannelGroup中的channel后，将录入的信息回写给除去发送信息的客户端
//				channel.writeAndFlush("[" + incoming.remoteAddress() + "]" + info + "\n");
//			}
//			else {
//				channel.writeAndFlush("[you]" + info + "\n");
//
//			}
//		}
		info = "";
	}

	//6.覆盖了 channelInactive() 事件处理方法。服务端监听到客户端不活动
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception { // (6)
		Channel incoming = ctx.channel();
		channels.remove(incoming);
		String  incomeId=incoming.id().asShortText();
		String devId = members.get(incomeId);
		members.remove(incomeId);
		String msg = ",掉线,";
		String date = FunctionHelper.getAllDate();
		String content = devId+msg+date;
		new EventTypeDao().insertIntoDb(content);
		System.out.println("SimpleChatClient:" + incoming.remoteAddress() + "掉线");
	}

	/**
	 * 新客户端接入
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		Channel incoming = ctx.channel();
		System.out.println("SimpleChatClient:" + incoming.remoteAddress() + "在线");
	}


	/**
	 * 异常
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		System.out.println("捕获到异常");
//		cause.printStackTrace();
//		ctx.close();
		closeOnFlush(ctx.channel());
	}

	private void closeOnFlush(Channel ch) {
		if(ch.isActive())
		ch.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
	}


	public static void sendMsgToAll(String msg){
		for (Channel channel : channels){
			channel.writeAndFlush(msg+"\n");
		}
	}
}
