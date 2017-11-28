package com.jisen;

public class Printf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double d=10000/3.0;//整数与整数相除得到整数3，然后强制将int型的值3转化为double型3.0，所以输出结果是3.0
		System.out.println(d);//为什么不是得到3.33333..分母不写3.0 
		System.out.printf("%f\n",d);//默认都有6位小数
		System.out.printf("%e\n",d);
		System.out.printf("%8.2f\n",d);//沿用C语言的格式化输入输出//8位宽度2位小数
		System.out.printf("%08.2f\n",d);//八位中前面空格补0
		System.out.printf("%-8.2f\n",d);//八位左对齐
		System.out.printf("%e\n",d);
//		String s=String.valueOf(d);
//		System.out.println(s);
//		int index=s.indexOf('.');//获取String类型数组的的下标
//		System.out.println(index);
//		int num=2;
//		String ss=s.substring(0, index+num+1);
//		System.out.println(ss);
		
		boolean b=true;
		System.out.println(b);
		System.out.printf("%b\n",b);
		
		String s="asdfghjkl";
		System.out.println(s);
		System.out.printf("%s\n",s);
		System.out.printf("%10s\n",s);
		System.out.printf("%5s\n",s);
		
		int x=1234;
		System.out.println(x);
		System.out.println("0x"+Integer.toHexString(x));
		System.out.printf("%#x\n",x);
		System.out.printf("%s\n",x);
		System.out.printf("%d\n",x);
		System.out.printf("%f\n",(float)x);
		
	}

}
