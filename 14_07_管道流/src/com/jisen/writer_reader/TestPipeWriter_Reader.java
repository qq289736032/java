package com.jisen.writer_reader;

import java.io.*;

//线程1，发送者
class Sender extends Thread{//
	PipedWriter pw;
	public Sender(){}
	public Sender(PipedWriter pw){//向发送者嵌入管道对象，
		this.pw=pw;
	}
	@Override
	public void run() {
		String contents="haha,i am sender...";//要发送的内容
		char[] sz=contents.toCharArray();//将字符串变为字符数组保存早字符数组里
		try {
			pw.write(sz,0,sz.length);//将字符数组写入管道，
			pw.flush();//刷新缓存
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(pw!=null){
				try {//关闭文件
					pw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}

//
class Receiver extends Thread{
	PipedReader pr;
	public Receiver(){}
	public Receiver(PipedReader pr){
		this.pr=pr;
	}
	@Override
	public void run() {
		char[] cbuf=new char[128];
		try {
			int len=pr.read(cbuf);
			System.out.println(new String(cbuf,0,len));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(pr!=null){
				try {
					pr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
public class TestPipeWriter_Reader {

	/**
	 * 输入流输出流，从流里面写入数据叫输出流，从管道获取叫输入流，
	 */
	public static void main(String[] args) {
		PipedWriter pw=new PipedWriter();//产生了一个输出的管子
		PipedReader pr=new PipedReader();//产生一个输入的管子
		
		//建立连接
		try {
			pw.connect(pr);//连接两个管子，这样就算连接了，也不用反过来再连一次
		} catch (IOException e) {
			e.printStackTrace();
		}
		new Sender(pw).start();//将输入流接入sender
		new Receiver(pr).start();//将输出流接入receiver
	}

}

/**
 * 文件流：用于对文件进行读写
 * 内存流：用于暂时保存一些数据
 * 管道流：用于线程之间通信，（线程之间的通信是建立在同一个进程里面的线程还是可以不同进程里面的线程呢）
 * 今天我们要讲的是管道,理论上就是发送者线程，将数据写入缓存，接受者从缓存里读取数据
 * 建立线程通信的步骤
 * 1、分别建立两个线程，并利用有参构造方法，将管道对象传递进去，
 * 2、在发送者线程的run方法里把数据写入管道，在接收者线程线程读取该数据
 * 3、建立管道输出流，建立管道输入流
 * 4、连接两个管道
 * 5、启动两个线程，并将两个管子对象传递进去
 */






































