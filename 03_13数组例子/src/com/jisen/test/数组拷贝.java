package com.jisen.test;

import java.util.Arrays;

public class 数组拷贝 {

	/**
	 *浅拷贝：	真实数据在内存中只有一份：先声明并初始化一个数组a,将数组a中栈区保存的堆区数据首地址赋给数组b，则对数组b操作可以改变数组a，这叫数组浅拷贝，
	 *		如果a不用了那么b可以继续使用a的数据，并且堆区依然保存着数组a的数据。如果a和b都不用了那么GC就会回收堆区的数据。
	 */
	public static void main(String[] args) {
//		int[] a={1,8,3,9,2,7,5,4,6};
		
		/*	
		 *	数组的浅拷贝1:将数组a中栈区保存的堆区数据首地址赋给数组b，将b中保存的a数据首地址加3*4(即b[2]）得到a[2]的地址，并对a[2]数据进行修改；
		 *	利用Arrays.toString(a)可以将数组a的内容转换成一条字符串
		 *	结论：操作b可以改变数组a，只是把a的首地址给了b，但没有在堆区开辟新空间。实际上是通过b访问a的数据地址。因此遍历a和b元素相同
		 */	
//		int[] a={1,8,3,9,2,7,5,4,6};
//		int[] b=a;
//		b[2]=1000;
//		System.out.println(Arrays.toString(a));
//		System.out.println(Arrays.toString(b));
		
		/*
		 * 	数组的深拷贝1：数组b的声明和初始化：在堆区开辟了一个新空间，长度为a.length，然后把a中的元素一个个取出并赋给b数组。从而将a数组中的数据复制给了b数组
		 * 结论：a和b数组遍历后，a数组保持不变，b数组输出修改之后的内容。
		 */
//		int[] a={1,8,3,9,2,7,5,4,6};
//		int[] b=new int[a.length];
//		for(int i=0;i<b.length;i++)
//			b[i]=a[i];
//		b[2]=1000;
//		System.out.println(Arrays.toString(a));
//		System.out.println(Arrays.toString(b));
		
		/*
		 * 数组深拷贝2：声明并初始化数组b，其中int[] b = Arrays.copyOf(a, a.length);类比于int[] b ={1,8,3,9,2,7,5,4,6}	
		 * Arrays.copyOf(a, n)的使用，将a中的前n个元素取出赋给b,n为b数组的长度,如果n>n.length则用0填充；
		 * 结论：该复制为深拷贝，遍历a和b，a保持不变，b输出修改之后的数组
		 */
//		int[] a={1,8,3,9,2,7,5,4,6};
//		int[] b = Arrays.copyOf(a, a.length+1);
//		b[0]=5;
//		System.out.println(Arrays.toString(b));
//		System.out.println(Arrays.toString(a));
		
		
		/*
		 *  数组深拷贝3 ：声明一个数组c（未初始化），c数组长度为10（个元素）
		 * 其中System.arraycopy(a, 2, c, 1, 3);第一和二个参数表示原数组名和开始拷贝的元素位置，第三四个参数表示目标数组名和开始拷贝的位置，
		 * 第五个参数为，拷贝长度。要注意下标越界和长度越界   
		 * 结论：该拷贝为深拷贝，遍历a和c后，a保持不变，c输出修改之后的数据
		 */	
//		int[] a={1,8,3,9,2,7,5,4,6};
//		int[] c=new int[10];
//		System.arraycopy(a, 2, c, 1, 3);//表示将数组a中的数据从a[2]开始拷贝给c并且从c[1]开始存放3个元素
//		c[2]=2000;
//		System.out.println(Arrays.toString(c));
//		System.out.println(Arrays.toString(a));
	
		
		/*
		 * 数组的深拷贝4:声明一维数组d，并利用Arrays.copyOfRange(a, 2, 14);给d初始化
		 * 其中Arrays.copyOfRange(int[] original,int from,int to)表示将a中的元素从a[2]开始拷给d，数组长度为14-2=12
		 * 结论：遍历数组a和d，a保持不变，d输出修改后的数据
		 */	
//		int[] a={1,8,3,9,2,7,5,4,6};
//		int[] d=Arrays.copyOfRange(a, 2, 14);//只能考到第13号元素
//		d[0]=2000;
//		System.out.println(Arrays.toString(d));
//		System.out.println(Arrays.toString(a)); 
		
		/*
		 * 	其他一些方法的使用
		 * 1、b.hashCode()表示取数组b的哈希码，原理待研究，此处立flag
		 * 2、a.equals(b)比较堆区的数据的地址是否相同，如果两个数组元素相同，但是 元素地址不同返回值为false,
		 * 3、Arrays.equals(c,b)比较堆区的数据是否一一对应相同，如果不是则返回false
		 * a==b比较的是栈区的保存的地址是否相同
		 */
//		int[] a={2,4,5,7,9,1,3,6,8};
//		int[] b={2,4,5,7,9,1,3,6,8};
//		int[] c={2,4,5,7,9,1,3,8,6};
//		int[] d=a;
//		int[] e=a; e[0]=2000;
//		System.out.println(a.hashCode());
//		System.out.println(b.hashCode());
//		System.out.println(c.hashCode());
//		System.out.println(d.hashCode());
//		System.out.println(e.hashCode());
		
		
//		System.out.println(a.equals(b));
//		System.out.println(a.equals(c));
//		System.out.println(a.equals(d));
//		System.out.println(d.equals(b));
//		
//		System.out.println(Arrays.equals(a,b));
//		System.out.println(Arrays.equals(a,c));
//		
//		
//		System.out.println(a==b);
//		System.out.println(a==c);


		
		/*
		 * Arrays.sort(a);的用法，排序，然后按字符串型输出
		 */
//		int[] a={1,8,3,9,2,7,5,4,6};
//		Arrays.sort(a);
//		System.out.println(Arrays.toString(a));
		
		/*
		 * binarySearch的用法，如果数组没有顺序那就没有意义
		 * 该方法是根据二分法查找指定的元素，反回该指定元素的下标索引
		 * 
		 * 这里就不得不提一下二分法的执行步骤：
		 * 
		 * 先找到中间位置的元素 如果需要查找的元素比中间位置的元素小，就抛弃右边一半的元素，往左边找，然后重复第一步
		 * 如果需要查找的元素比中间位置的元素大，就抛弃左边一半的元素，往左边找，然后重复第一步
		 * 
		 * 现在是否明白为什么binarySearch方法的形参必须是有序的了呢？
		 * 
		 * 因为如果不是有序的 那么该方法查找的结果根本是没有意义的
		 * 
		 * 此外，该方法还有两个小细节：
		 * 传进去当做参数的数组必须是升序排列 如果该数组中有3个元素是相同的
		 * 而你要查找的正好是该元素，那么该方法的返回值是该3个元素的下标索引中的任意一个，这也算是该方法的一个bug
		 */
//		int[] a={1,8,3,9,2,7,5,4,6};
//		Arrays.sort(a);
//		System.out.println(Arrays.toString(a));
//		System.out.println(Arrays.binarySearch(a, 4));//表示4在数组什么位置，返回该元素下标志，结果为3
		
		/*
		 * 	6、	fill的使用,声明并开辟一个长度为10的数组，用fill将1全部填充到该数组中		
		 */
		String[] d=new String[10]; 
		Arrays.fill(d, " ┃");
		System.out.println(Arrays.toString(d));	
		
		
		
		
	}

}
