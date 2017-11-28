package com.jisen;

//枚举类
/*
 * 在jdk1.5之前Java可以有两种方式定义新类型：类和接口。但是在一些特殊情况下这些放法就不合适，定义一个color，
 * 它只能有Red，Green和Blue三种值。其他任何值都是非法的，通过private将构造器隐藏起来，
 * 把这个类所有可能实例都使用public static final属性来保存
 */
class Weekday{
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
	Monday,
	Tuesday,
	Wednesday,
	Thursday,
	Friday,
	Saturday,
	Sunday;	
}
class Weekday2{
	public static final Weekday2 Monday=new Weekday2("Monday");
	public static final Weekday2 Tuesday=new Weekday2("Tuesday");
	public static final Weekday2 Wednesday=new Weekday2("Wednesday");
	public static final Weekday2 Thursday=new Weekday2("Thursday");
	public static final Weekday2 Friday=new Weekday2("Friday");
	public static final Weekday2 Saturday=new Weekday2("Saturday");
	public static final Weekday2 Sunday=new Weekday2("Sunday");
	private String name;

	private Weekday2(){}
	private Weekday2(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	@Override
	public String toString(){
		return getName(); 

	}
	public static Weekday2[] values(){
		Weekday2[] wd=new Weekday2[7];
				wd[0]=Monday;
				wd[1]=Tuesday;
				wd[2]=Wednesday;
				wd[3]=Thursday;
				wd[4]=Friday;
				wd[5]=Saturday;
				wd[6]=Sunday;
		return wd;//返回首地址值
	}
}
public  class EnumerationClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Weekday monday=new Weekday("星期一");
		System.out.println(monday);
//		System.out.println(Weekday1.Friday);
		for(Weekday2 val:Weekday2.values())
			System.out.println(val.toString());
	}		
}
