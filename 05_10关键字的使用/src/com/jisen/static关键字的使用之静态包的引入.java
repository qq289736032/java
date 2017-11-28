package com.jisen;

//import com.jipei.Mathoperator;
import static com.jipei.Mathoperator.*;

public class static关键字的使用之静态包的引入 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int m=13;
		int n=20;
		/*
		 * Mathoperator s=new Mathoperator();//等号左边的叫声明，等号右边的叫创建。
		 * 这句话的含义是，左边声明一个变量（在栈区开辟了一个空间，这个空间的名字叫s，该变量的数据类型是引用数据类型Mathoperator)
		 * 右边创建了一个对象空间，对象名字叫Mathoperator()，括号表示该对象下面还有成员。
		 */
		//Mathoperator s=new Mathoperator();									
		//System.out.println("m+n="+s.add(m, n));//这表明当被调用的方法没有static关键字时要先产生一个对象，再用对象来引用方法
		
		//System.out.println("m+n="+Mathoperator.add(m, n));//如果被调用的方法有static修饰时直接用该该类名引用
		System.out.println("m+n="+add(m, n));//如果在引入的包时添加static修饰，则可直接用方法名调用方法
	}

}
