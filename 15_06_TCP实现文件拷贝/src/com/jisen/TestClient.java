package com.jisen;

import java.io.*;
import java.net.*;

public class TestClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Socket s=null;
		InputStream is=null;
		FileOutputStream fos=null;
		try {
			//1、socket
			//2、connect
			s = new Socket();
			s.bind(new InetSocketAddress(InetAddress.getByName("169.254.105.153"),7777));//给客户端分配一个端口号7777
			s.connect(new InetSocketAddress(InetAddress.getByName("169.254.105.153"),8888));//连接到服务器端的地址和端口号
			//3、recv/sender
//			InputStream fis = s.getInputStream();
			is=s.getInputStream();
			 fos= new FileOutputStream("c:\\copy.txt");
			
			byte[] b =new byte[1024];
			int len=-1;
			while((len=is.read(b))!=-1){
				fos.write(b,0,len);
				fos.flush();
			}
			is.close();
			fos.close();
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
