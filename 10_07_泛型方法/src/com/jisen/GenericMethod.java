package com.jisen;

		/*
		 * 修饰符<Type>返回值类型 方法名称(参数列表){}
		 */

public class GenericMethod {

	/**
	 * @param args
	 */
	
//	public static <Type> void print(Type[] a){
//		for(Type i:a){
//			System.out.print(i+" ");
//		}
//	}
	public static <Type> void print(Type... a){//其中Type...通用型，表示不确定类型？太神奇了，只在泛型方法中使用？
		for(Type i:a){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Integer a[]={1,3,5,7,9,11,13,15,17,19};
//		for(int i:a){
//			System.out.print(i+" ");
//		}
		print(a);
		System.out.println();
		String b[]={"a","b","c","d","e","f","g"};
		print(b);
		
		print(1,2,3,4);
//		print('1','2','3',4);//这时把Type当成Object
		print("a1","b2","c3","d4","e5","f6","g7");
		
	}

}
