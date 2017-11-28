package com.jisen;

import java.net.*;

public class UDPBroadcastClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DatagramSocket ds=null;
		try {
			//socket
//			ds= new DatagramSocket(null);
//			ds.bind(new InetSocketAddress(InetAddress.getByName("169.254.105.153"),7777));
			ds= new DatagramSocket(6666,InetAddress.getByName("169.254.105.153"));
			ds.setBroadcast(true);
			
			//recrv
			byte[] b = "hello everyone".getBytes();
			ds.send(new DatagramPacket(b,b.length,InetAddress.getByName("169.254.105.255"),8888));
			//只要是169.254.105.0-255这个段的绑定的端口号是8888的所有主机都能接收到信息，
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(ds!=null){
				ds.close();
			}
		}
		
	}

}
