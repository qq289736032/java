package com.jisen;

import java.io.*;
import java.net.*;
import java.util.*;

//class ServerRecv extends Thread{
//	private Socket s;
//	public ServerRecv(Socket s){
//		this.s=s;
//	}
//	@Override
//	public void run() {
//		//服务器的接收数据
//		InputStream is;
//		try {
//			is = s.getInputStream();
//			byte[] b=new byte[1024];
//			int len=-1;
//			while((len=is.read(b))!=-1){
//				System.out.println(new String(b,0,len));
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}finally{
//			if(s!=null){
//				try {
//					s.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		
//	}
//}
//
//class ServerSend extends Thread{
//	private Socket s;
//	public ServerSend(Socket s){
//		this.s=s;
//	}
//	@Override
//	public void run() {
//		//发送客户端数据
//		OutputStream os;
//		try {
//			os = s.getOutputStream();
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
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}finally{
//			if(s!=null){
//				try {
//					s.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//			
//		}
//	}
//}


class DoChat extends Thread{
	private Socket s;
	public DoChat(Socket s){
		this.s=s;
	}
	@Override
	public void run() {
		//服务器的接收数据
		InputStream is;
		OutputStream os;
		try {
			is = s.getInputStream();
			byte[] b=new byte[1024];
			int len=-1;
			while((len=is.read(b))!=-1){
				String msg=new String(b,0,len);
				if(msg.equals("exit")){
					System.out.println(s.getInetAddress().getHostName()+" "+s.getPort()+"下线了。。。");
					TCPGroupChatServer.list.remove(s);
					break;
				}
				String pmsg=new String(s.getPort()+":\n\t"+msg);
				System.out.println(pmsg);
				//发送给所有客户端
//				Scanner in = new Scanner(System.in);
//				String smsg=in.nextLine();
				
				for(Socket socket:TCPGroupChatServer.list){
					os = socket.getOutputStream();
//					if(smsg!=null){
//						os.write(smsg.getBytes());
//					} 
					if (!s.equals(socket)) {
						os.write(pmsg.getBytes());
						
					}
				}
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
public class TCPGroupChatServer {

	/**
	 * @param args
	 */
	public static ArrayList<Socket> list=new ArrayList<Socket>();
	public static void main(String[] args) {
		ServerSocket ss=null;
		try {
			//socket,bind,listen
			ss=new ServerSocket(5432, 10, InetAddress.getByName("169.254.105.153"));
			
			//accept
			while (true) {

				Socket s = ss.accept();
				String tips=new String(s.getInetAddress().getHostAddress() + "\t"
						+ s.getPort() + "上线了。。。");
				System.out.println(tips);
				list.add(s);
				new DoChat(s).start();
			}
			
			//recv/send
			
			//单聊代码
//			new ServerRecv(s).start();
//			new ServerSend(s).start();
			
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
