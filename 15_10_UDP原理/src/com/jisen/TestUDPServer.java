package com.jisen;

import java.io.IOException;
import java.net.*;

public class TestUDPServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DatagramSocket ds=null;
		try {
			//1、socket
			ds=new DatagramSocket(null);
			
			//2、bind
			ds.bind(new InetSocketAddress(InetAddress.getByName("169.254.105.153"),7777));//绑定一个服务器地址和端口，
			
			//3、receive
			byte[] b = new byte[1024];
			DatagramPacket dp = new DatagramPacket(b, b.length);
			ds.receive(dp);
			System.out.println("接收到的数据为"+new String(dp.getData(),0,dp.getLength()));//
			System.out.println("数据长度为："+dp.getLength());
			System.out.println("ip: "+dp.getAddress().getHostAddress());
			System.out.println("port: "+dp.getPort());
			
			//4、send
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//5、close
			if(ds!=null){
				ds.close();
			}
		}
		
		//6、
	}

}
