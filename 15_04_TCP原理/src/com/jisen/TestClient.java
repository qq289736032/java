/**
 * 
 */
package com.jisen;

import java.io.*;
import java.net.*;


public class TestClient {

	/**客户端
	 * @param args
	 */
	public static void main(String[] args) {
		Socket s =null;
		try {
			//1. socket
			//2. connect
			s = new Socket();
			s.bind(new InetSocketAddress(InetAddress.getByName("169.254.105.153"),7777));//给客户端分配一个端口号7777
			s.connect(new InetSocketAddress(InetAddress.getByName("169.254.105.153"),8888));//连接到服务器端的地址和端口号
			
			//3. send/recv
			//3.1输入流获取数据
//			InputStream is=s.getInputStream();//输入流接收信息
//			byte[] b=new byte[1024];
//			int len =is.read(b);
//			System.out.println(new String(b,0,len));
			
			//3.1输入流的包装，在屏幕中显示
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String ss=null;
			while(true){
				try {
					ss = br.readLine();//readLine()在遇到\n时表示读取截止，才会显示出来，
					if (ss == null)
						break;
					System.out.println(ss);
				} catch (Exception e) {
					break;
				}
			}
			br.close();
//			
//			//3.2从文件读取放到新文件，表示文件传输，
//			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
//			FileOutputStream foss=new FileOutputStream("c:\\a.txt");
//			String msg=null;
//			byte[] b1=new byte[1024];
//			int len=-1;
//			while((len=fis.read(b1))!=-1){
//				msg=new String(b1,0,len);
//				
//			}
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
		
		//4. close
		
	}

}
