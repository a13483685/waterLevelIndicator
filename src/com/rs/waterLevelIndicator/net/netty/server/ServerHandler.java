package com.rs.waterLevelIndicator.net.netty.server;

import com.rs.waterLevelIndicator.Observers.ObserverData;
import com.rs.waterLevelIndicator.Observers.ObserverDataOne;
import com.rs.waterLevelIndicator.utils.Constans;
import com.rs.waterLevelIndicator.view.DeviceMonitorJpanel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务端消息处理
 * @author -xiez-
 *
 */
public class ServerHandler extends SimpleChannelInboundHandler<String> {

	public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
	public static String mInfo = "";
	ObserverDataOne observerDataOne = null;
	List<ObserverData> observers = new ArrayList<>();
	public ServerHandler(){
		observerDataOne= new ObserverDataOne();
		observers.add(observerDataOne);
	}
	//2.覆盖了 handlerAdded() 事件处理方法。每当从服务端收到新的客户端连接时，客户端的 Channel 存入 ChannelGroup列表中，并通知列表中的其他客户端 Channel
	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {  // (2)
		Channel incoming = ctx.channel();
		// Broadcast a message to multiple Channels
		channels.writeAndFlush("[SERVER] - " + incoming.remoteAddress() + " channel_id :" + incoming.id() + " 加入\n");
		//添加到channelGroup 通道组
		channels.add(ctx.channel());
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		Channel incoming = ctx.channel();

		// Broadcast a message to multiple Channels
		channels.writeAndFlush("[SERVER] - " + incoming.remoteAddress() + " 离开\n");

		// A closed Channel is automatically removed from ChannelGroup,
		// so there is no need to do "channels.remove(ctx.channel());"
		}

	@Override
	protected void messageReceived(ChannelHandlerContext ctx, String msg) throws Exception {
		System.out.println("msg is :"+msg);
//		if(msg.startsWith("head")){
//			String[] infos = msg.split(",");
//			if(infos.length == 7){
//				if(infos[1] == Constans.HEAD_SERVER){
//					mInfo = "服务器";
//				}
//				if(infos[5] == Constans.CMD_HIGH){
//					mInfo += "配置客户端安装高度";
//				}else if(infos[5] == Constans.CMD_HIGH_LIMIT){
//					mInfo += "配置客户端水位上限报警";
//				}else if(infos[5] == Constans.CMD_DOWN_LIMIT){
//					mInfo += "配置客户端水位下线报警";
//				}
//
//				if(infos[6] == Constans.SET_RESUALT_SUCCESS){
//					mInfo += "成功！";
//				}else if(infos[6] == Constans.SET_RESUALT_FALSE){
//					mInfo += "失败！";
//				}
//			}
//			DeviceMonitorJpanel.mLogContent.setText(mInfo);
//			DeviceMonitorJpanel.mLogContent.updateUI();
//		}
		for (ObserverData observerData:observers){
//			if(msg.startsWith("devid")){
				observerData.update(msg);
//			}
		}
		Channel incoming = ctx.channel();
		for (Channel channel : channels) {//遍历ChannelGroup中的channel
			if (channel != incoming){//找到加入到ChannelGroup中的channel后，将录入的信息回写给除去发送信息的客户端
				channel.writeAndFlush("[" + incoming.remoteAddress() + "]" + msg + "\n");
			}
			else {
				channel.writeAndFlush("[you]" + msg + "\n");
			}
		}

	}

	//6.覆盖了 channelInactive() 事件处理方法。服务端监听到客户端不活动
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception { // (6)
		Channel incoming = ctx.channel();
		channels.remove(incoming);
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
		cause.printStackTrace();
	}
	public static void sendMsgToAll(String msg){
		for (Channel channel : channels){
			channel.writeAndFlush(msg+"\n");
		}
	}
	
}
