package com.jisen1;

import java.io.*;
import java.net.*;
import java.util.*;

class ServerRecv extends Thread{
	private Socket s;
	public ServerRecv(Socket s){
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
				System.out.println(new String(b,0,len));
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

class ServerSend extends Thread{
	private Socket s;
	public ServerSend(Socket s){
		this.s=s;
	}
	@Override
	public void run() {
		//发送客户端数据
		OutputStream os;
		try {
			os = s.getOutputStream();
			Scanner in=new Scanner(System.in);
			while(true){
				try{
					String msg=in.nextLine();
					os.write(msg.getBytes());
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
public class TestSingleChatTCPServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ServerSocket ss=null;
		try {
			//socket,bind,listen
			ss=new ServerSocket(5432, 10, InetAddress.getByName("169.254.105.153"));
			
			//accept
			Socket s=ss.accept();
			System.out.println(s.getInetAddress().getAddress()+"\t"+s.getPort()+"上线了。。。");
			
			//recv/send
			new ServerRecv(s).start();
			new ServerSend(s).start();
			
			//reveive,接收客户端数据
//			InputStream is=s.getInputStream();
//			byte[] b=new byte[1024];
//			int len=-1;
//			while((len=is.read(b))!=-1){
//				System.out.println(new String(b,0,len));
//			}
			
			//send，发送客户端数据
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
//			//close
//			s.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(ss!=null){
				try {
					//close
					ss.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
