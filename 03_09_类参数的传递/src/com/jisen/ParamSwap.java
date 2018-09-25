package com.jisen;

class Num2{
	public int num;
}


public class ParamSwap {

	/**
	 * @param
	 */
	public static void swap(int a,int b){
		a=(a+b)-(b=a);
	}
	public static void swap2(Num2 n1,Num2 n2){
		n1.num=(n1.num+n2.num)-(n2.num=n1.num);
	}
	public static void main(String[] args) {
		int a=10;
		int b=20;
		swap(a,b);
		
		Num2 n1=new Num2();
		n1.num=10;
		
		Num2 n2=new Num2();
		n2.num=20;
		swap2(n1,n2);

		System.out.println("a="+a+",b="+b);
		System.out.println("n1.num="+n1.num+",n2.num="+n2.num);
	}

}
