package com.jisen;

import com.jipei.*;

public class this关键字的使用 {

	/**
	 * 利用this关键字调用本类的属性
	 */
	public static void main(String[] args) {
		Person p=new Person(1001,"王大锤",24);
		System.out.println(p);//System.out.println(p.toString());
//		p.setNo(1001);
//		p.talk();
	}

}
