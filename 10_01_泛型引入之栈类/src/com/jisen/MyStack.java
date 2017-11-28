package com.jisen;
/*
 * 这个自定义的栈，只能使用于存放特定类型（int型）的数据，不满足适用性。
 * 因此要将该类变成泛型类
 */

//class Stack{
//	public static final int N=100;
//	private int[] elem=new int[N];	//栈容量
//	private int top=-1;				//如果为-1则为满栈
//	
//	//1、入栈
//	public void push(int num){
//		if(full()){
//			System.out.println("栈已满，不能进行操作");
//		}
//		top++;	//满栈，入栈先将栈顶位置加1再存储数据
//		elem[top]=num;
//	}
//	//2、出栈
//	public void pop(){
//		if(empty()){
//			System.out.println("栈已空，不能进行操作");
//		}
//		int num=elem[top];
//		top--;
//		System.out.println(num+"出栈");
//	}
//	//3、取栈顶
//	public int getTop(){
//		if(empty()){
//			System.out.println("栈已空，不能进行取栈操作");
//			return -1;
//		}
//		return elem[top];
//	}
//	//4、栈是否满了
//	public boolean full(){
//		return top==N-1;
//	}
//	//5、栈是否空了
//	public boolean empty(){
//		return top==-1;
//	}
//}
		/*
		 * 如果采用泛型解决适用性问题，
		 * 在jdk1.5之前不采用泛型，而是把数据类型用Object代替，因为Object是所有类的父类，所有遇到具体的数据类型时向下转型
		 * 在jdk1.5之后引入了泛型，泛型标记必须是类类型。e.g.Stack<Integer>
		 * 
		 * Student[] s=new Student();
		 * s
		 */
class Stack<Type>{
//	public static final int N=100;
	private Type[] elem;	//调用无参构造器时只定义了一个该类型的数组，没有开辟该类型数组空间，因此要用有参构造器
	private int top=-1;				//如果为-1则为满栈
	
	public Stack(){}			//Stack<Student>=new Stack<Student>();调用无参构造器,只定义该类型数组，但没开辟该类型数组空间
	public Stack(Type[] elem){	//Stack<Student>=new Stack<Student>(new Student[10]);表示定义并开辟了一个10大小的该类型数组空间
		this.elem=elem;			//elem=new Student[10],而elem是type[]型的，因此 Type[] elem=new Student[10]
	}
	//1、入栈
	public void push(Type num){
		if(full()){
			System.out.println("栈已满，不能进行操作");
		}
		top++;	//满栈，入栈先将栈顶位置加1再存储数据
		elem[top]=num;
	}
	//2、出栈
	public void pop(){
		if(empty()){
			System.out.println("栈已空，不能进行操作");
		}
		Type num=elem[top];
		top--;
		System.out.println(num+"出栈");
	}
	//3、取栈顶
	public Type getTop(){
		if(empty()){
			System.out.println("栈已空，不能进行取栈操作");
			return null;
		}
		return elem[top];
	}
	//4、栈是否满了
	public boolean full(){
		//return top==N-1;
		return top==elem.length-1;
	}
	//5、栈是否空了
	public boolean empty(){
		return top==-1;
	}
}

public class MyStack {

	/**
	 * @param args
	 * 栈的特点及栈的操作:封闭的开口向上的桶结构，1、先进后出2、最下面的为栈顶位置，
	 * 满栈（栈顶在最上），空栈栈顶在最下面，递减栈（存储数据时从从下往上，高地址向低地址填充），递增栈，栈区内存是以满递减堆栈的一种结构（就是），
	 * 满栈和空栈，
	 * 满栈：栈顶先指向-1的位置，存储数据时，将栈顶位置往上移到0的位置，然后将数据存在0这个位置上，此时栈顶位置指向有数据区域，所以这种栈为满栈。
	 * 空栈：栈顶先指向0的位置，存数据时，先将数据存储到0的位置，然后栈顶指针向上移一位，栈顶指向新的未存数据的区域，所以这种栈为空栈。
	 * 
	 * 1、入栈
	 * 2、出栈
	 * 3、取栈顶元素
	 * 4、判断栈满
	 * 5、判断栈空
	 * 
	 */
	public static void main(String[] args) {
		Stack<Integer> s=new Stack<Integer>(new Integer[10]);
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		System.out.println(s.getTop());
		s.pop();
		System.out.println(s.getTop());
		s.pop();
		System.out.println(s.getTop());
		s.pop();
		System.out.println(s.getTop());
		
	}

}
