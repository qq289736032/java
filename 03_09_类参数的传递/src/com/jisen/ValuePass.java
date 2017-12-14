package com.jisen;
/**
 * 总结
 * 1，数组是引用被传递进去值会被改变，但是单个值传进去不会被改变
 * 2，char的数组可以直接被输出，但是其他的数组输出的是hash值
 * @author Administrator
 *
 */
public class ValuePass {
	char cr ='d';
	char[] ch = {'a','b','c'};
	int a = 1;
	int[] ach = {2,3};
	public static void main(String[] args) {
		ValuePass pass = new ValuePass();
		pass.change(pass.a, pass.ach);
		pass.change(pass.cr, pass.ch);
		
		System.out.println(pass.cr);
		System.out.println(pass.ch);
		System.out.println(pass.a);
		System.out.println(pass.ach[0]);
	}
	public void change(char cr,char ch[]){
		cr = 'e';
		ch[0] = 'f';
	}
	public void change(int a,int ach[]){
		a = 4;
		ach[0] = 5;
	}
}
