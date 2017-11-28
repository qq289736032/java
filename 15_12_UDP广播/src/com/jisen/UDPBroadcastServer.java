package com.jisen;

import java.net.*;

public class UDPBroadcastServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//socket
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket(null);
			ds.setReuseAddress(true);
			ds.bind(new InetSocketAddress(InetAddress.getByName("169.254.105.153"),8888));
//			ds= new DatagramSocket(8888,InetAddress.getByName("169.254.105.153"));
			
			byte[] b = new byte[1024];
			DatagramPacket dp = new DatagramPacket(b, b.length);
			ds.receive(dp);
			System.out.println(new String(dp.getData(), 0, dp.getLength()));
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(ds!=null){
				ds.close();
			}
		}
	}

}
