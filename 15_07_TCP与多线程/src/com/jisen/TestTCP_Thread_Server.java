package com.jisen;

import java.io.*;
import java.net.*;

class DoClientConnectQuest extends Thread{
	private Socket s;
	//private DoClientConnectQuest(){}
	public DoClientConnectQuest(Socket s){
		this.s=s;
	}
	@Override
	public void run() {
		try {
			OutputStream os=this.s.getOutputStream();//
			os.write("正在处理客户端请求".getBytes());
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(s.getInetAddress().getHostAddress()+"\t"+s.getPort()+"连接成功");
			os.write("处理完毕~".getBytes());
			os.close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(this.s!=null){
				try {
					this.s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
public class TestTCP_Thread_Server {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
			// socket bind listen
			ss = new ServerSocket(6666, 10,
					InetAddress.getByName("169.254.105.153"));
			while (true) {
				Socket s = ss.accept();// 如果有多个客户端那就循环执行，接收
				new DoClientConnectQuest(s).start();
//				OutputStream os = s.getOutputStream();//
//				os.write("正在处理客户端请求".getBytes());
//				try {
//					Thread.sleep(10000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				System.out.println(s.getInetAddress().getHostAddress()+s.getPort()+"连接成功");
//				os.write("处理完毕~".getBytes());
//				
//				os.close();
//				s.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ss != null) {
				try {
					ss.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
