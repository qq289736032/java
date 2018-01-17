package com.jisen;

import java.util.EnumMap;
import java.util.EnumSet;

//枚举类
/*
 * 在jdk1.5之前Java可以有两种方式定义新类型：类和接口。但是在一些特殊情况下这些放法就不合适，定义一个color，
 * 它只能有Red，Green和Blue三种值。其他任何值都是非法的，通过private将构造器隐藏起来，
 * 把这个类所有可能实例都使用public static final属性来保存
 */
class Weekday{
	public static final String PI = "3.14";
	private String name;
	public Weekday(){}			//无参构造器
	public Weekday(String name){//有参构造器
		this.name=name;
	}
	@Override
	public String toString() {
		return "Weekday [name=" + name + "]";
	}
}
enum Weekday1{

	Monday(1,"星期一"),
	Tuesday(2,"星期二"),
	Wednesday(3,"星期三"),
	Thursday(4,"星期四"),
	Friday(5,"星期五"),
	Saturday(6,"星期六"),
	Sunday(7,"星期日");
	private int id;
	private String description;
	private Weekday1(int id,String description){
		this.id = id;
		this.description = description;
	}
    public static final String PI = "3.14";

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

	@Override
	public String toString() {
		return super.toString();
	}
}
//class Weekday2{
//	public static final Weekday2 Monday=new Weekday2("Monday");
//	public static final Weekday2 Tuesday=new Weekday2("Tuesday");
//	public static final Weekday2 Wednesday=new Weekday2("Wednesday");
//	public static final Weekday2 Thursday=new Weekday2("Thursday");
//	public static final Weekday2 Friday=new Weekday2("Friday");
//	public static final Weekday2 Saturday=new Weekday2("Saturday");
//	public static final Weekday2 Sunday=new Weekday2("Sunday");
//	private String name;
//
//	private Weekday2(){}
//	private Weekday2(String name){
//		this.name=name;
//	}
//	public String getName(){
//		return name;
//	}
//	@Override
//	public String toString(){
//		return getName();
//
//	}
//	public static Weekday2[] values(){
//		Weekday2[] wd=new Weekday2[7];
//				wd[0]=Monday;
//				wd[1]=Tuesday;
//				wd[2]=Wednesday;
//				wd[3]=Thursday;
//				wd[4]=Friday;
//				wd[5]=Saturday;
//				wd[6]=Sunday;
//		return wd;//返回首地址值
//	}
//}
public  class EnumerationClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Weekday monday=new Weekday("星期一");
//		System.out.println(monday);
//		System.out.println(Weekday1.Friday);
//		for(Weekday2 val:Weekday2.values()){
//			System.out.println(val.toString());
//		}

		Weekday1.Monday.name();
		Weekday1.Monday.ordinal();
		Weekday1.valueOf("Monday").getId();
		Weekday1.valueOf("Monday").getDescription();

		EnumSet<Weekday1> weekday1 = EnumSet.allOf(Weekday1.class);

		EnumMap weekday2 = new EnumMap<Weekday1,String>(Weekday1.class);



	}
}
