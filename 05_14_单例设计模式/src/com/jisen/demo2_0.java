package com.jisen;

//第二步、类的封装，封装之后不能直接用对象去调用，就要提供一些接口
class Drug2 {
	private String name; // 成员1--->属性：类的静态描述 成员变量
	private float price; // 成员2
	
	public void showDrugInfo() { // 行为：//行为：类的动态描述 成员方法,可以有参数
		System.out.println("药品名：" + name + "，价格：" + price);
	}
	
	public void setName(String name){
		this.name=name;
	}
	public void setPrice(float price){
		this.price=price;
	}
	public String getName(){
		return this.name;
	}
	public float getPrice(){
		return this.price;
	}
}

public class demo2_0 {

	/**
	 */
	public static void main(String[] args) {
		//成员属性被私有之后，用一个方法建立一个窗口，供外界读写
		Drug2 drug = new Drug2();
		// 其次、要用对象去调用成员变量（属性及行为（成员变量和成员方法））
		drug.setName("罗红霉素");
		drug.setPrice(32.5f);
		drug.showDrugInfo();

	}

}
