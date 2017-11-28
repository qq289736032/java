package com.jisen;

//如果把构造器也私有化，那就不能再主类main方法中实例化，普通方法私有化可以用创建public方法窗口来访问，但是构造方法不能。
class Drug4 {
	private String name; // 成员1--->属性：类的静态描述 成员变量
	private float price; // 成员2
	
	public void showDrugInfo() { // 行为：//行为：类的动态描述 成员方法,可以有参数
		System.out.println("药品名：" + name + "，价格：" + price);
	}
	
	private Drug4(){}							//为什么无参构造器和有参构造器要同时写？
	private Drug4(String name,float price){		//因为，既然写出来了有参构造器，那系统的隐形的无参构造器就会自动失效，所以要写出来两者皆可用
		this.name=name;
		this.price=price;
	}
	/*****************************************************
	//既然构造器在主类main方法中不可见，那么就无法利用构造器产生一个对象，根据以往的经验要建立一个窗口方法（因为private修饰的变量在本类成员中可见），
	//既然无法调用构造器那我就写个对外的方法来调用构造器
	public void init(String name,float price){
		//Drug4(name,price);//构造器不能被调用
	}
	***************************************************/
	
	public static Drug4 init(String name,float price){//被修饰成public static方便于直接用类名调用；
		return new Drug4(name,price);//构造器在本类中其他方法可见且被调用
	}
}
public class demo3 {

	/**
	 * 面向对象的四大特征 1、类的抽象 2、类的封装 3、继承 4、多态 现在第一步类的抽象
	 */
	public static void main(String[] args) {
		
		Drug4 drug=Drug4.init("罗红霉素",32.5f);
		drug.showDrugInfo();

	}

}
