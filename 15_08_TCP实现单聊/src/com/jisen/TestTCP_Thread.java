package com.jisen;

import java.net.*;
import java.io.*;

public class TestTCP_Thread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Socket s=null;
		InputStream is=null;
		try {
			//socket bind connect
			s=new Socket(InetAddress.getByName("169.254.105.153"),6666);
			//recv/send
			is=s.getInputStream();
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
