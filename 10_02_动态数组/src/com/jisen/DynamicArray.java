package com.jisen;

/*
 * 使用泛型栈存储数据，每次要new一个该类型的栈类，该栈内部实现该类型数组存储以及其他栈操作功能，可以调用该栈内部的入栈方法将该类型数据存储进去，
 * 但是如果调用的是无参构造器：Stack<Student>=new Stack<Student>();那么是不能存储数据的，因为这样在栈类内部只是定义了一个该类型数组的变量，
 * 而没有把开辟好的该类型数组的空间的首地址传进去，因此会出现空指针异常，因此要调用有参构造器
 * Stack<Student>=new Stack<Student>(new Student[1000]);调用有参构造器，实际上在外部就已经将该类型数组空间开辟好没然后将首地址传递进去，
 * 但是每次要传递进去确定的开辟的类型数组空间。 那有没有什么办法让栈能够自动的扩展空间大小呢
 * 下面请看动态数组的实现，然后将此方法套用在栈里
 */



/*
 * 动态数组，先给一个初始容量（init_capacity=20）,然后再设定一个占空比容量预警值（rate=0.8），随着数据不断加入进去的，判断存入的数据达到当前空间大小的0.8，将容量capacity+10；
 * 依次增加，具体实现如下
 * System.arraycopy(a（源）, 0（要拷贝的源数组起始元素下标）, b（目标）, 0（从目标数组0这个位置开始放元素）, b.length);
 * src - 源数组。
 * srcPos - 源数组中的起始位置。
 * dest - 目标数组。
 * destPos - 目标数据中的起始位置。
 * length - 要复制的数组元素的数量。
 */

class AutoArray{
	private int a[];							//存储数据
	private int init_capacity=20;				//预选分配的大小
	private int add_capacity=10;				//每次扩展的量
	public int capacity;								//扩展之后的动态容量
	private int size=0;							//栈顶指针下标计数，
	private double rate=0.8;
	
	public AutoArray(){		//无参构造方法，一进来刚开始的时候开辟一个初始大小空间，只能保存20个；
		capacity =init_capacity;
		a=new int[capacity];
	}
	public void push(int elem){		//往数组里面加数据传递一个数据进去
		a[size]=elem;				//第一次将该值放到0这个位置
		size++;						//然后栈顶位值往上移一位
		if(size>=capacity*rate){	//当实际的大小大于或等于容量的0.8时，容量加10
			capacity+=add_capacity;
			int[] b=new int[capacity];//实现数组的扩展，因为原先数组大小容量已固定，
			System.arraycopy(a,0,b,0,a.length);//采用先旧数组元素复制到新数组，从a中的0位置的元素开始复制放到b中0位置开始，放的长度是a中所有元素的个数
			a=b;								//然后再将新数组的元素和空间大小返回给旧数组，
		}
	}
	public void pop(){		//出栈就是将栈顶指针往下移动
		size --;			//先将栈顶指针往下移
		//这个判断，因为数据容量总是要大于当前容量的0.8,并且等于0.8时又+10，所以无论如何实际的容量要先
		if(size<=(capacity-add_capacity)*rate&&capacity>=init_capacity){//判断容量，如果数据小于当前容量的0.8那么将容量减少10
			capacity-=add_capacity;//容量-10
			int b[]=new int[capacity];//数组容量更新
			System.arraycopy(a, 0, b, 0, b.length);//只需要将b长度大小的a元素放到b里面
			a=b;
		}
			
	}
	
}
public class DynamicArray {

	/**
	 * @param args
	 * 本质上是对数组的封装
	 */
	public static void main(String[] args) {
		AutoArray aa=new AutoArray();
		for(int i=0;i<120;i++)
			aa.push(i);
		System.out.println(aa.capacity);
		
		for(int i=0;i<100;i++)
			aa.pop();
		System.out.println(aa.capacity);
	}

}
