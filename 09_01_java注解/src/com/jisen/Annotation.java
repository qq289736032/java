package com.jisen;

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
@SuppressWarnings(value={"all","unused"})//警告注解，
class C{
	@Deprecated
	private int mm;//声明了但未被使用，加上警告注解后警告消失
	@Deprecated
	public C(){}
}
public class Annotation {

	/**
	 * 1、会使用系统内定义的3个标准注解该如何使用，即@Override，@Deperecated，@SuppressWarning
	 * @Override:复写注解，
	 * @Deprecated：过期声明，不建议使用了
	 * @SuppressWarning：压制警告，去除警告
	 */
	@SuppressWarnings(value={"all","unused"})//警告注解，
	public static void main(String[] args) {
		int i=1;//未被使用
		int j=2;
	}

}
