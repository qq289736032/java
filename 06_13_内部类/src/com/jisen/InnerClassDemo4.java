package com.jisen;

/*
 * 匿名内部类
 * 这种方法在Android应用非常重要，点击按钮会有一个点击按钮的响应
 */

interface I{//接口下面都是抽象方法参数都是final static abstract可省略等关键字
	public void say();
}
class C{
	class IC implements I{//实现一个接口对象
		public void say(){
			System.out.println("哈哈哈");
		}
	}
	public void fun(I i){//参数是接口类对象（因为接口必须要实例化才能应用所以这里的i是子类）
		i.say();//子类对象调用父类方法
	}
//	public void talk(){
//		fun(new IC());	//调用本类方法要传一个参数，该参数是一个接口类对象那么就要new一个接口对象而且不能new一个父类对象I，
//						//因为接口类对象必须要实例化所以在class C前面要实现一个接口继承自I
//	}
	public void talk() {					//该段的作用在于不用传入的参数不用实例化的有名称的接口对象，
		fun(new I() {						//而直接在参数里面new一个I的实现类，该类对象不是I本身，而是匿名的I子类
			public void say() {				//叫做匿名内部类
				System.out.println("哈哈哈");
			};
		});
	}
}
public class InnerClassDemo4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		C c=new C();//创建并实例化一个c对象
		c.talk();//用c调用talk（）这个过程又会调用fun（），调用fun（）参数又创建一个接口对象
	}

}
