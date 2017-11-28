package com.jisen;

import java.io.IOException;
import java.net.*;

public class TestUDPClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//socket (bind) sendto recvFrom close
		DatagramSocket ds = null;
		try {
			 ds = new DatagramSocket(null);//无参构造方法系统自动给绑定了一个端口号，所以要写null
			 ds.bind(new InetSocketAddress(InetAddress.getByName("169.254.105.153"), 5555));
			 
			 //send
			 byte[] b = "hello UDPServer..".getBytes();
			 DatagramPacket dp = new DatagramPacket(b, b.length,InetAddress.getByName("169.254.105.153"),7777);
			 ds.send(dp);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
