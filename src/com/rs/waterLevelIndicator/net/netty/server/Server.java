package com.rs.waterLevelIndicator.net.netty.server;

import com.rs.waterLevelIndicator.utils.Constans;
import com.rs.waterLevelIndicator.view.DevManege;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * netty5服务端
 * @author -琴兽-
 *
 */
public class Server {

	public static void main() {

		Logger log = LoggerFactory.getLogger(Server.class);
		//服务类
		ServerBootstrap bootstrap = new ServerBootstrap();
		
		//boss和worker
		EventLoopGroup boss = new NioEventLoopGroup();
		EventLoopGroup worker = new NioEventLoopGroup();
		
		try {
			//设置线程池
			bootstrap.group(boss, worker);
			
			//设置socket工厂、
			bootstrap.channel(NioServerSocketChannel.class);
			
			//设置管道工厂
			bootstrap.childHandler(new ChannelInitializer<Channel>() {

				@Override
				protected void initChannel(Channel ch) throws Exception {
					ch.pipeline().addLast(new StringDecoder());
					ch.pipeline().addLast(new StringEncoder());
					ch.pipeline().addLast(new ServerHandler());
					//当客户端连接事件出现，输出客户端的远程地址
					log.info("SimpleChatClient :{}" +ch.remoteAddress() + "  channel_id :" + ch.id() + "  连接上");
//					System.out.println("SimpleChatClient:" + );
				}
			});


			//netty3中对应设置如下
			//bootstrap.setOption("backlog", 1024);
			//bootstrap.setOption("tcpNoDelay", true);
			//bootstrap.setOption("keepAlive", true);
			//设置参数，TCP参数
			bootstrap.option(ChannelOption.SO_BACKLOG, 2048);//serverSocketchannel的设置，链接缓冲池的大小
			bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);//socketchannel的设置,维持链接的活跃，清除死链接
			bootstrap.childOption(ChannelOption.TCP_NODELAY, true);//socketchannel的设置,关闭延迟发送
			
			//绑定端口
			ChannelFuture future = bootstrap.bind(6666);
			log.info("SimpleChatClient :{}" ,"服务器开始监听"+Constans.PORT+"端口.....");
			//等待服务端关闭
			future.channel().closeFuture().sync();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			//释放资源
			boss.shutdownGracefully();
			worker.shutdownGracefully();
		}
	}
}
