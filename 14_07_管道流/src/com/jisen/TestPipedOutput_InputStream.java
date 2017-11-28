package com.jisen;

import java.io.*;


//发送者
class Sender extends Thread{
	private PipedOutputStream pos; 
	public Sender(){}
	public Sender(PipedOutputStream pos){
		this.pos=pos;
	}
	@Override
	public void run() {
		String s="hello receiver...";
		byte[] b=s.getBytes();
		try {
			pos.write(b);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(pos!=null){
				try {
					pos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

//接收者
class Receiver extends Thread{
	private PipedInputStream pis;
	public Receiver(){}
	public Receiver(PipedInputStream pis){
		this.pis=pis;	
	}
	@Override
	public void run() {
		byte[] b = new byte[1024];
		try {
//			while (pis.read(b) != 0) {
				pis.read(b);
//			}
			int len = b.length;
			System.out.println(new String(b, 0, len));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pis != null) {
				try {
					pis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

public class TestPipedOutput_InputStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//产生两个管道
		PipedOutputStream pos=new PipedOutputStream();
		PipedInputStream pis=new PipedInputStream();
		
		try {
			pos.connect(pis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		new Sender(pos).start();
		new Receiver(pis).start();
		
		
	}

}
