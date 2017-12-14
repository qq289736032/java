package com.jisen;

class Num{
	public int num;
}


public class PassValue {

	/**
	 * @param args
	 */
	public static void swap(int a,int b){
		a=(a+b)-(b=a);
	}
	public static void swap(Num n1,Num n2){
		n1.num=(n1.num+n2.num)-(n2.num=n1.num);
	}
	public static void main(String[] args) {
		int a=10;
		int b=20;
		swap(a,b);
		
		Num n1=new Num();
		n1.num=10;
		
		Num n2=new Num();
		n2.num=20;
		swap(n1,n2);

		System.out.println("a="+a+",b="+b);
		System.out.println("n1.num="+n1.num+",n2.num="+n2.num);
	}

}
