package com.jisen;

import java.util.*;



public class CollectionInterface {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//1、实例化
//		Collection<Integer> coll1= new Collection<Integer>();//它是一个接口不能实例化  
		Collection<Integer> coll= new ArrayList<Integer>();//父类变量接收子类对象，只能看到父类的成员方法
		
		//2、方法应用
		ArrayList<Integer> coll1= new ArrayList<Integer>();

		//2.1添加元素add();
		coll1.add(1);
		coll1.add(3);
		coll1.add(3);
		coll1.add(2);
		coll1.add(4);
		coll1.add(6);
		coll1.add(5);
		System.out.println("//2.1添加元素add();\n"+coll1);
		
		//2.2addAll
		Collection<Integer> coll2=new ArrayList<Integer>();
		coll2.add(7);
		coll2.add(9);
		coll2.add(8);
		coll2.addAll(coll1);
		System.out.println("//2.2addAll\n"+coll2);//插到了coll1前面去
		
		//2.3clear，size，isEmpty()
		coll2.clear();
		System.out.println("//2.3clear，size，isEmpty()\n"+coll2.size());//删除了size为0
		System.out.println(coll2.isEmpty());//删除之后为空
		System.out.println(coll2);//输出【】没有元素
		
		//2.4 contains(3)
		System.out.println("//2.4 coll1\n"+coll1);
		System.out.println("//2.4 contains(3)\n"+coll1.contains(3));
		
		//2.5containsAll(3)
		Collection<Integer> coll3=new ArrayList<Integer>();
		coll3.add(7);
		coll3.add(9);
		coll3.add(8);
		coll3.addAll(coll1);
		System.out.println("//2.5containsAll(3)\n"+coll1+"\n"+coll3);
		System.out.println("//2.5containsAll()\n"+coll3.containsAll(coll1));
		
		//2.6remove()
		System.out.println("//2.6remove()\n"+coll3);
		System.out.println(coll3.remove(7));
		System.out.println(coll3);
		System.out.println("2.6removeAll()\n"+coll3.removeAll(coll1));
		System.out.println("2.6removeAll()\n"+coll3);
		
		//2.7retailAll(Collection<?>);//保留与传递集合相同的元素
		Collection<Integer> coll4=new ArrayList<Integer>();
		coll4.add(1);
		coll4.add(3);
		coll4.add(3);
		coll4.add(2);
		coll4.add(4);
		coll4.add(6);
		coll4.add(5);
		coll4.add(7);
		coll4.add(9);
		coll4.add(8);
		System.out.println("coll4="+coll4);
		System.out.println("retailAll(Collection<?>)\t"+coll4.retainAll(coll1));
		System.out.println("coll1="+coll1+"\ncoll4="+coll4);
		
		//2.8toArray()
		Object[] s= coll1.toArray();
		for(Object i:s)
		System.out.print(i+" ");
		System.out.println();
		
		//2.9iterator
		Iterator<Integer> it =coll1.iterator();//迭代器输出方式
		System.out.println("//2.9iterator");
		while(it.hasNext()){
			System.out.print(it.next());
		}
		
		
		for(int i=0;i<coll1.size();i++){
			System.out.println(coll1.get(i)+" ");
		}
	}

}
