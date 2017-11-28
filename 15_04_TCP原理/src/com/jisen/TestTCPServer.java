/**
 * java.net包中定义了两个类ServerSocket和Socket，分别用来实现双向连接的server端和client端，
 * 以输入输出流来建立通信的，服务端的输出流要跟客户端的输入流连接在一起，客户端的输出流要跟服务器端的输入流连接到一起，
 * 构造方法：
 * ServerSocket() 创建非绑定服务器套接字。相当于服务器端只做了socket
 * ServerSocket(8888) 创建绑定到特定端口的服务器套接字。相当于做了socket和bind(8888,ip),listen(10)后面的ip是由系统自动分配的ip,10是默认给了一个10
 * ServerSocket(8888, 20) 相当于做了socket和bind(8888,ip),listen(20)，20是指定给定的
 * ServerSocket(8888, 20, InetAddress.getByName("192.168.0.188")),InetAddress这个类型是通过ip地址获取的
 * 等价于做了socket bind(8888,192.168.0.188) listen(20),当ip地址有多个的时候建议使用这种形式
 * 
 */

package com.jisen;

import java.io.*;
import java.net.*;


public class TestTCPServer {

	/**服务端
	 * @param args
	 */
	public static void main(String[] args) {
		
		ServerSocket ss=null;
		Socket s=null;
		try {
			//1、socket
			//2、bind
			//3.listen
			//构造器1
//			ss=new ServerSocket();
//			ss.bind(new InetSocketAddress(InetAddress.getByName("169.254.105.153"),8888));//绑定了这个IP地址和端口号，提供给给客户端识别连接
			//构造器2、
			ss=new ServerSocket(8888,10,InetAddress.getByName("169.254.105.153"));//绑定的是服务器端的地址和端口号
			
			//4. accept
			s=ss.accept();//返回一个新Socket套接字
			//4.1利用返回的新套接字，可获得客户端的主机地址，和端口号
			System.out.println(s.getInetAddress().getHostAddress()+"["+s.getPort()+"]"+"上线了");//谁上线了
			
			//5. recv/send
			//5.1发送消息要用这个新套接字获取一个输出流，再用输出流发送数据
//			OutputStream os=s.getOutputStream();
//			os.write("hello client".getBytes());
			//5.2输出流包装使其能发送字符串
//			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
//			Scanner in = new Scanner(System.in);
//			String msg=null;
//			while(true){
//				try{
//					msg=in.nextLine();
//				}catch(Exception e){
//					break;
//				}
//				bw.write(msg+"\n");//发送数据后要写一个斜杠n，表示在输入流读到这个斜杠n时相当于从缓存中打印出来，如果没有这个\n那么输入流将打印不出
//				bw.flush();
//			}
//			in.close();
//			bw.close();
			
			//5.3从文件中发送数据,发送文件
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			FileInputStream fis=new FileInputStream("c:\\a.txt");
			
			byte[] b=new byte[1024];
			int len=-1;
			while((len=fis.read(b))!=-1){//将最多b.length长度的字节写入b数组里面，返回读入缓冲区的字节总数，如果因为已经到达文件末尾而没有更多的数据，则返回 -1。
				bw.write(new String(b,0,len));
				bw.flush();
			}
			fis.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//6. close
			if(ss!=null){
				try {
					ss.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
