/**
 * 合并流，
 * SequenceInputStream(InputStream s1, InputStream s2) 将两个输入流InputStream，传入进去，
 * 将按顺序读取这两个参数，先读取 s1，然后读取 s2，以提供从此 SequenceInputStream 读取的字节。
 */

package com.jisen;

import java.io.*;

public class TestSequenceInputStream2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileInputStream fis1 = null;
		FileInputStream fis2 = null;
		SequenceInputStream sis = null;
		FileOutputStream fos = null;
		try {
			fis1 = new FileInputStream("c:\\a.txt");
			fis2 = new FileInputStream("c:\\b.txt");
			sis = new SequenceInputStream(fis1, fis2);//
			fos = new FileOutputStream("c:\\ab.txt");
			byte[] b=new byte[1024];
			int len=-1;
			while((len=sis.read(b))!=-1){//有合并流表示不用分两个循环，分别读取，直接读取这个合并流的数据即可，
				fos.write(b, 0, len);
			}
			fis1.close();
			fis2.close();
			sis.close();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fis1 != null)
					fis1.close();
				if (fis2 != null)
					fis2.close();
				if (sis != null)
					sis.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
