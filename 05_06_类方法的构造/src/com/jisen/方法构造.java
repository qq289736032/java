package com.jisen;

class Student1{
	private int no;
	private String name;
	private int age;
	private char sex;
	private int score;
	
	
	//******类的接口函数可以用generate生成*********
	public void setNo(int n){
		no=n;
	}
	public void setName(String n){
		name=n;
	}
	public void setAge(int a){
		age=a;
	}
	public void setSex(char s){
		sex=s;
	}
	public void setScore(int sc){
		score=sc;
	}
	public int getNo(){
		return no;
	}
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	public char getSex(){
		return sex;
	}
	public int getScore(){
		return score;
	}
	void talk(){
		System.out.println("我是"+name);
	}
	//*****/
	public Student1(int n, String na, int a, char s, int sc) {
		no = n;
		name = na;
		age = a;
		sex = s;
		score = sc;
		System.out.println("有参的构造器被调用");
	}

	public Student1() {
		// TODO Auto-generated constructor stub
		// 当你写了一个有参的构造器时，最好自己写一个无参的构造器
		System.out.println("无参的构造器被调用");
	}

}
public class 方法构造 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Student1 stu=new Student1();
		stu.setNo(1001);
		stu.setName("钟吉森");
		stu.setAge(22);
		stu.setSex('M');  
		stu.setScore(89);
		new Student1().setName("王大锤");//匿名对象只能使用一次
		new Student1().talk();
		//Student1 stu=new Student1(1001,"钟吉森",22,'M',98);
		
		int a=10;
		int b=10;
		System.out.println("a==b"+(a==b));
	}

}
