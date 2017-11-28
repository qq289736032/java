package com.jisen;

import java.io.IOException;

public class ClassOfRuntime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Runtime rt=Runtime.getRuntime();
		System.out.println(rt.maxMemory());
		System.out.println(rt.availableProcessors());
		System.out.println(rt.freeMemory());
		System.out.println(rt.totalMemory());
		try {
			rt.exec("notepad c:\\a.txt");//让它去执行某一个操作
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
