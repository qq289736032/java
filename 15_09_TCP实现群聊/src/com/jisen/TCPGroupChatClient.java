package com.jisen;

import java.io.*;
import java.net.*;
import java.util.*;

class ClientSend extends Thread{
	private Socket s;
	public ClientSend(Socket s){
		this.s=s;
	}
	@Override
	public void run() {
		//发送服务器端数据
		OutputStream os;
		try {
			os = s.getOutputStream();
			Scanner in=new Scanner(System.in);
			while(true){
				try{
					String msg=in.nextLine();
					os.write(msg.getBytes());
					if(msg.equals("exit")){
						System.exit(0);
					}
				}catch(Exception e){
					System.out.println("聊天结束。。。");
					break;
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}finally{
			if(s!=null){
				try {
					s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
}

class ClientRecv extends Thread{
	private Socket s;
	public ClientRecv(Socket s){
		this.s=s;
	}
	@Override
	public void run() {
		//服务器的接收数据
		InputStream is;
		try {
			is = s.getInputStream();
			byte[] b=new byte[1024];
			int len=-1;
			while((len=is.read(b))!=-1){
				String msg=new String (b,0,len);
				System.out.println(msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(s!=null){
				try {
					s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}

public class TCPGroupChatClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//socket,bind,connect,receive/send,close,close
		Socket s=null;
		try {
			//socket,bind,connect
			s=new Socket(InetAddress.getByName("169.254.105.153"), 5432);
			
			//send/recv
			ClientRecv ct=new ClientRecv(s);
			ct.start();
			ClientSend cs=new ClientSend(s);
			cs.start();
			ct.join();
			cs.join();
			
			//send
//			OutputStream os=s.getOutputStream();
//			Scanner in=new Scanner(System.in);
//			while(true){
//				try{
//					String msg=in.nextLine();
//					os.write(msg.getBytes());
//				}catch(Exception e){
//					System.out.println("聊天结束。。。");
//					break;
//				}
//			}
			//receive/
//			InputStream is=s.getInputStream();
//			byte[] b=new byte[1024];
//			int len=-1;
//			while((len=is.read(b))!=-1){
//				System.out.println(new String(b,0,len));
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(s!=null){
				try {
					s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
