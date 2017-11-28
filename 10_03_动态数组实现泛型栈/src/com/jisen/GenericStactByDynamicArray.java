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
//class Stack<Type>{
////	public static final int N=100;
//	private Type[] elem;	//调用无参构造器时只定义了一个该类型的数组，没有开辟该类型数组空间，因此要用有参构造器
//	private int top=-1;				//如果为-1则为满栈
//	
//	public Stack(){}			//Stack<Student>=new Stack<Student>();调用无参构造器,只定义该类型数组，但没开辟该类型数组空间
//	public Stack(Type[] elem){	//Stack<Student>=new Stack<Student>(new Student[10]);表示定义并开辟了一个10大小的该类型数组空间
//		this.elem=elem;			//elem=new Student[10],而elem是type[]型的，因此 Type[] elem=new Student[10]
//	}
//	//1、入栈
//	public void push(Type num){
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
//		Type num=elem[top];
//		top--;
//		System.out.println(num+"出栈");
//	}
//	//3、取栈顶
//	public Type getTop(){
//		if(empty()){
//			System.out.println("栈已空，不能进行取栈操作");
//			return null;
//		}
//		return elem[top];
//	}
//	//4、栈是否满了
//	public boolean full(){
//		//return top==N-1;
//		return top==elem.length-1;
//	}
//	//5、栈是否空了
//	public boolean empty(){
//		return top==-1;
//	}
//}

/*
 * 使用泛型栈存储数据，每次要new一个该类型的栈类，该栈内部实现该类型数组存储以及其他栈操作功能，可以调用该栈内部的入栈方法将该类型数据存储进去，
 * 但是如果调用的是无参构造器：Stack<Student>=new Stack<Student>();那么是不能存储数据的，因为这样在栈类内部只是定义了一个该类型数组的变量，
 * 而没有把开辟好的该类型数组的空间的首地址传进去，因此会出现空指针异常，因此要调用有参构造器
 * Stack<Student>=new Stack<Student>(new Student[1000]);调用有参构造器，实际上在外部就已经将该类型数组空间开辟好没然后将首地址传递进去，
 * 但是每次要传递进去确定的开辟的类型数组空间。 那有没有什么办法让栈能够自动的扩展空间大小呢
 * 下面将利用动态数组的方法实现这个过程
 */


class Stack<Type>{
//	public static final int N=100;
	private Object[] elem;	
	private int top=-1;				//如果为-1则为满栈
	private int init_capacity=20;				//预选分配的大小
	private int add_capacity=10;				//每次扩展的量
	public int capacity;								//扩展之后的动态容量
	private int size=0;							//栈顶指针下标计数，
	private double rate=0.8;
	
	public Stack(){			//Stack<Student>=new Stack<Student>();调用无参构造器,只定义该类型数组，但没开辟该类型数组空间，因此要做相应改动
		capacity=init_capacity;
		elem=new Object[capacity];//Cannot create a generic array of Type不能创建一个泛型数组		
	}
	
	//1、入栈
	public void push(Type num){
//		if(full()){//动态栈无需判断是否已满栈
//			System.out.println("栈已满，不能进行操作");
//		}
		top++;	//满栈，入栈先将栈顶位置加1再存储数据
		elem[size]=num;//将元素赋值
		size++;
		if(size>=capacity*rate){//判断是否达到容量预警
			capacity+=add_capacity;//是则容量+10
			Object[] e=new Object[capacity];//产生新数组
			System.arraycopy(elem, 0, e, 0, elem.length);//将原数组复制到新数组，将源数组0位置的元素开始放到b数组中0位置开始，放的长度为，a中所有元素的个数（a.length）
			elem=e;
		}
	}
	//2、出栈
	public void pop(){
		if(empty()){
			System.out.println("栈已空，不能进行操作");
		}
		Object num=elem[top];
		top--;
		System.out.println(num+"出栈");
		//动态缩小
		size--;
		if(size<=(capacity-add_capacity)*rate&&capacity>=init_capacity){
			capacity-=add_capacity;
			Object[] e=new Object[capacity];
			System.arraycopy(elem, 0, e, 0, e.length);
			elem=e;
			
		}
	}
	//3、取栈顶
	public Object getTop(){
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
public class GenericStactByDynamicArray {

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
//		Stack<Integer> s=new Stack<Integer>(new Integer[10]);
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < 100; i++) {
			s.push(i);
			System.out.print(s.getTop());
		}
		for (int i = 0; i < 50; i++) {
			s.pop();
			System.out.print(s.getTop());
		}
		
		Stack<String> st = new Stack<String>();
		for (int i = 0; i < 100; i++) {
			st.push("a"+i);
			System.out.println(st.getTop());
		}
		for (int i = 0; i < 50; i++) {
			st.pop();
			System.out.println(st.getTop());
		}
	}

}
