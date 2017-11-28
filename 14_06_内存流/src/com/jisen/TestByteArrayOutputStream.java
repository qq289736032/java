/**
 * 内存流使用场合，此类实现了一个输出流，其中的数据被写入一个 byte 数组。缓冲区会随着数据的不断写入而自动增长。可使用 toByteArray() 和 toString() 获取数据。 
 * 关闭 ByteArrayOutputStream 无效。此类中的方法在关闭此流后仍可被调用，而不会产生任何 IOException。
 * 
 *  构造方法：
 *  ByteArrayOutputStream()建一个新的 byte 数组输出流。缓冲区的容量最初是 32 字节，如有必要可增加其大小。
 *  ByteArrayOutputStream(int size)也可指定大小
 *  
 *  功能类似一个中转容器，可写入，然后从中读出，常用于通过网络获取到的未知大小的数据，将网络获取到的未知大小的内容全部放到这个缓存里然后再取出来，就可以通过各种显示操作显示数据
 *  从一个链接中获取连接背后的内容，链接背后我们不知道有多少内容，但是我们可以将它保存在一个自动扩展大小的字节数组内存，这个过程通过一个1024字节大小的byte零食数组，通过while循环
 *  将链接里面的数据全部读取出来写到字节内存数组里
 *  
 */

package com.jisen;

import java.io.*;
import java.net.*;

public class TestByteArrayOutputStream {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
//		String s="asdfghjkl";
		//打开URL连接器
		URL url=new URL("https://g.alicdn.com/kg/??tbhome/1.4.3/lib/monitor-min.js");
		URLConnection con=url.openConnection();
		//设置头字段
		con.setRequestProperty("user-agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.76 Mobile Safari/537.36");
		//创建真正的连接
		con.connect();
		InputStream is=con.getInputStream();//从连接中获取数据
		
		ByteArrayOutputStream baos=null;
		baos=new ByteArrayOutputStream(1024);
		byte b[]=new byte[1024];
		int len=-1;
		while((len=is.read(b))!=-1){
			baos.write(b,0,len);//写入一个字节数组到baos这个缓存字节数组里
		}
		
		byte[] bs=baos.toByteArray();//将baos里面的呃字节数组放到一个新的byte数组里面。
		System.out.println(new String(bs));
		try {
			baos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
