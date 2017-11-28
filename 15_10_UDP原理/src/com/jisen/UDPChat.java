package com.jisen;

import java.io.*;
import java.net.*;
import java.util.*;

class Recv extends Thread{
	private DatagramSocket ds;
	public Recv(DatagramSocket ds){
		this.ds=ds;
	}
	@Override
	public void run() {
		try {
			//recv
			while (true) {
				byte[] b = new byte[1024];
				DatagramPacket dp = new DatagramPacket(b, b.length);
				ds.receive(dp);
				System.out.println("收到来自" + dp.getAddress().getHostAddress()
						+ "[" + dp.getPort() + "] 的消息，内容："
						+ new String(dp.getData(), 0, dp.getLength()));//
			}
		} catch(IOException e){
			
		}
	}
}

//send
class Send extends Thread{
	private DatagramSocket ds;
	public Send(DatagramSocket ds){
		this.ds=ds;
	}
	@Override
	public void run() {
		try {
			Scanner in = new Scanner(System.in);
			while (true) {
				String s=null;
				try{
					s = in.nextLine();
				}catch(Exception e){
					break;
				}
				byte[] b = s.getBytes();
				DatagramPacket dp = new DatagramPacket(b, b.length,
						InetAddress.getByName(UDPChat.your_ip), UDPChat.your_port);
				ds.send(dp);
			}
			in.close();
		} catch(IOException e){
			
		}
	}
}
public class UDPChat {

	/**
	 * @param args
	 */
	public static String your_ip;
	public static int your_port;
	public static void main(String[] args) {
		if(args.length<2){
			System.out.println("USAGE : Java 主类   MyIP MyPORT YourIP YourPORT");
			System.exit(0);
		}
		
		String my_ip=args[0];
		int my_port = Integer.parseInt(args[1]);
		your_ip=args[2];
		your_port = Integer.parseInt(args[3]);
		
		//socket,bind,recvfrom,sendto,close,
		DatagramSocket ds = null;
		try {
			//socket
			ds = new DatagramSocket(null);
			//bind
			ds.bind(new InetSocketAddress(InetAddress.getByName(my_ip), my_port));
			
			//recvfrom
			Recv r = new Recv(ds);
			r.start();
			Send s = new Send(ds);
			s.start();
			r.join();
			s.join();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(ds!=null){
				ds.close();
			}
		}
	}

}
