package com.jisen;

import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class TestInetAddress {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//InetAddress ia=new InetAddress();//没有构造方法因此不能直接实例化
		try {
			InetAddress ia1=InetAddress.getLocalHost();//获取本地主机
			InetAddress ia2=InetAddress.getByName("WIN-79NR20OAA82");//通过主机名字获取对应的信息
			InetAddress ia3=InetAddress.getByName("192.168.85.1");//通过地址获取主机信息
			InetAddress ia4=InetAddress.getByName("www.baidu.com");//通过域名获取主机信息
			InetAddress ia5=InetAddress.getByName("www.ruanyifeng.com");
			List<InetAddress> hostInfo = new ArrayList<InetAddress>();
			hostInfo.add(ia1);
			hostInfo.add(ia2);
			hostInfo.add(ia3);
			hostInfo.add(ia4);
			hostInfo.add(ia5);
			for (InetAddress inetAddress : hostInfo) {
				
				System.out.println(inetAddress.getHostAddress());//获取主机地址
				System.out.println(inetAddress.getHostName());//获取主机名字
				System.out.println("++++++++++++++++++++++++++++++++++++++");//获取主机名字
			}
//						
//			byte[] b=ia.getAddress();
//			for(byte bs:b){//以字节方式显示IP地址的byte数组
//				System.out.print(bs+" ");
////			}
//			InetAddress[] ias=InetAddress.getAllByName("websocket.org");
//			for(InetAddress i:ias){
//				System.out.println(i.getHostAddress());//为什么可以获取这么多
//			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
