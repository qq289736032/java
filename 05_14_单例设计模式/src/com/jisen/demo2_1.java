package com.jisen;

//第二步、类的封装，封装之后不能直接用对象去调用，就要提供一些接口
//当属性很多时要一个一个set和get非常麻烦，这是就用构造器代替
class Drug3 {
	private String name; // 成员1--->属性：类的静态描述 成员变量
	private float price; // 成员2
	
	public void showDrugInfo() { // 行为：//行为：类的动态描述 成员方法,可以有参数
		System.out.println("药品名：" + name + "，价格：" + price);
	}
	
	public Drug3(){}
	public Drug3(String name,float price){
		this.name=name;
		this.price=price;
	}
}

public class demo2_1 {

	/**
	 * 面向对象的四大特征 1、类的抽象 2、类的封装 3、继承 4、多态 现在第一步类的抽象
	 */
	public static void main(String[] args) {
		//当使用构造器之后就不用一个个成员去赋值
		Drug3 drug=new Drug3("罗红霉素",32.5f);
		drug.showDrugInfo();

	}

}
