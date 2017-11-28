/**
 * ready()判断此流是否已经准备好用于读取。如果其输入缓冲区不为空，或者可从底层字节流读取字节，则 InputStreamReader 已做好被读取准备。
 */

package com.jisen;

import java.io.*;

public class TestFileReader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileReader fr=null;
		try {
			//打开文件
			fr=new FileReader("c:\\c.txt");
			char[] c=new char[10];//
			int len=fr.read(c);
			System.out.println(len);
			for(char t:c){
				System.out.println(t);//输出的是字符对比byte[]输出的是该自符的ASCII码
			}
			System.out.println(new String(c,0,len));
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				//关闭文件
				if(fr!=null){
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
