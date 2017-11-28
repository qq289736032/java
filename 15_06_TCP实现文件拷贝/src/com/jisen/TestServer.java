package com.jisen;

import java.io.*;
import java.net.*;

public class TestServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ServerSocket ss=null;
		Socket s=null;
		try {
			//1、socket
			//2、bind
			//3、listen
//			 ss= new ServerSocket(8888, 10, InetAddress.getByName("169.254.105.153"));
			 ss=new ServerSocket(8888,10,InetAddress.getByName("169.254.105.153"));//绑定的是服务器端的地址和端口号
			//4、accept
			s=ss.accept();
			System.out.println(s.getInetAddress().getHostName()+s.getPort()+"上线了");
			
			//5、received/send
			FileInputStream fis=new FileInputStream("c:\\a.txt");
			OutputStream fos=s.getOutputStream();
			byte[] b=new byte[1024];
			int len=-1;
			while((fis.read(b))!=-1){
				fos.write(b,0,len);
				fos.flush();
			}
			fis.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(ss!=null);{
				try {
					ss.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		//6、close
		//7、close
	}

}
