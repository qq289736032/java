package com.jisen;

import java.io.*;

public class Test {

	/**
	 * 1. 任意给定一个路径(存在的)，然后将该路径下面的所有内容输出，然后是文件的就告诉其是文件，是目录就告诉是目录
	 */
	public static void main(String[] args) {
		File f=new File("c:\\TestFile");
		File[] s=f.listFiles();
		for(int i=0;i<s.length;i++){
			if(s[i].isDirectory())
				System.out.println(s[i]+"是目录");
			else
				System.out.println(s[i]+"是文件");
		}
	}

}
