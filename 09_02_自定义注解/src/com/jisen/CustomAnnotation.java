package com.jisen;

import com.jisen.en.MyEnum;

class A{
	public void fun(){
		
	}
}

class B extends A{
	@Override//复写注解	表示一个方法声明打算重写超类（父类）中的另一个方法声明。如果方法利用此注释类型进行注解但没有重写超类方法，则编译器会生成一条错误消息。
	public void fun(){
		
	}
}
@Deprecated//过期声明，不建议使用，但是可以用
@SuppressWarnings(value = { "unused" })
class C{
	@Deprecated
	private int mm;
	@Deprecated
	public C(){}
}
@MyAnno(value = "王大锤", age = 23,e=MyEnum.AAA)//使用自定义注解，注解里面含3个参数
public class CustomAnnotation {

	/**
	 * @param args
	 */
	
	@SuppressWarnings(value={"all","unused"})//警告注解，
	public static void main(String[] args) {
		int i=1;
		int j=2;
	}

}
