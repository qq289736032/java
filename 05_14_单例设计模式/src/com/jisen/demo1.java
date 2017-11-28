package com.jisen;

//第一步、类的抽象
class Drug {
	String name; // 成员1--->属性：类的静态描述 成员变量
	float price; // 成员2

	public void showDrugInfo() { // 行为：//行为：类的动态描述 成员方法,可以有参数
		System.out.println("药品名：" + name + "，价格：" + price);
	}
}

public class demo1 {

	/**
	 * 面向对象的四大特征 1、类的抽象 2、类的封装 3、继承 4、多态 现在第一步类的抽象
	 */
	public static void main(String[] args) {
		// 有了类之后是如何定义变量的呢？
		// 首先、要实例化一个对象“drug”，在堆区开辟一个对象空间,该空间首地址放在名为drug的栈区空间里
		//为什么我没有构造器也可以实例化对象？因为，系统默认一个隐形的无参构造器，所以new一个空间之后括号不能写入参数
		Drug drug = new Drug();
		// 其次、要用对象去调用成员变量（属性及行为（成员变量和成员方法））
		drug.name = "罗红霉素";
		drug.price = 32.5f;
		drug.showDrugInfo();

	}

}
