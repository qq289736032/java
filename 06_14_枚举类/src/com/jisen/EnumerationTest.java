package com.jisen;

import java.util.EnumMap;
import java.util.EnumSet;

//枚举类
/*
 * 在jdk1.5之前Java可以有两种方式定义新类型：类和接口。但是在一些特殊情况下这些放法就不合适，定义一个color，
 * 它只能有Red，Green和Blue三种值。其他任何值都是非法的，通过private将构造器隐藏起来，
 * 把这个类所有可能实例都使用public static final属性来保存
 */

public  class EnumerationTest {
	enum Colour{
		RED,
		BLUE,
		GREEN;

	}
	enum Weekday implements Runnable{
		//可以有枚举值
		Monday(1,"星期一"),
		Tuesday(2,"星期二"),
		Wednesday(3,"星期三"),
		Thursday(4,"星期四"),
		Friday(5,"星期五"),
		Saturday(6,"星期六"),
		Sunday(7,"星期日");
		//可以有字段
		private int id;
		private String description;
		//可以有构造方法(该构造方法仅用于内部使用:如Monday(1,"星期一")),
		private Weekday(int id,String description){
			this.id = id;
			this.description = description;
		}
		//可以有get/set
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getDescription() {
			return description;
		}
		/************************************************************/
		//可以有常量
		public static final String PI = "3.14";
		//可以有普通方法
		public void show(){
			System.out.println("这是一个复杂的枚举类");
		}
		//可以有静态代码块
		static{
			System.out.println("这是静态代码块");
		}
		//可以有普通代码块
		{
			System.out.println("可以有普通代码块");
		}
		//还可以实现接口重写方法
		@Override
		public void run() {
			System.out.println("这是枚举类实现的一个线程"+Thread.currentThread().getName());
		}
	}


	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//		Colour blue = Colour.BLUE;
//		String name = Colour.BLUE.name();
//		String string = Colour.BLUE.toString();
//		int ordinal = Colour.BLUE.ordinal();//输出BLUE的位置1,从零开始记
//		int i = Colour.RED.compareTo(Colour.GREEN);//i为-2,算法为位置相减0-2=-2
//		Colour[] values = Colour.values();//获取所有枚举值,遍历分别返回Colour的枚举值
//		Colour green = Colour.valueOf("GREEN");//注意不能把String类的GREEN写错否则不能返回GREEN枚举值
//	}
	public static void main(String[] args) {

		//大操作
		Weekday[] values = Weekday.values();//数组可遍历
		Weekday firstDay = values[0];//获取下标为0的值,Monday
		Weekday value = Weekday.valueOf("Monday");//根据key获取值

		//直接获取值
		Weekday monday = Weekday.Monday;
		String name = monday.name();//获取名称String的Monday字符串
		int mondayOrder = monday.ordinal();//monday的下标或者位置0
		String description = monday.description;//获取,描述:星期一
		int id = monday.id;//获取ID:1

		//演示get/set
		Weekday tuesday = Weekday.Tuesday;
		String tuesdayDes = tuesday.getDescription();
		int tuesdayID = tuesday.getId();
		tuesday.setDescription("这是星期二");
		String tuesdayDes2 = tuesday.getDescription();
		System.out.println(tuesdayDes+tuesdayDes2);

		//演示常量
		String pi = Weekday.PI;//3.14

		//演示普通方法
		Weekday.Tuesday.show();
		Weekday.Monday.show();

		//演示实现线程接口用Weekday.任何成员都算实例化一个类
		new Thread(Weekday.Monday).start();
		new Thread(Weekday.Monday).start();
		new Thread(Weekday.Tuesday).start();

	}
}
