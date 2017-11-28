package com.jisen;

import java.util.*;

//Map的本质是有很多个entry组成的Set集合

public class MapInterface {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Map<Integer, String> map=new Map<Integer, String>();//不能实例化
		Map<Integer, String> map=new HashMap<Integer, String>();//
		//Map-->Entry<Integer,String>
		map.put(1001, "张珊");//查询没有并添加，类似修改
		map.put(1002, "李四");
		map.put(1003, "王5");
		map.put(1004, "麻溜");
		
		System.out.println(map);//相当于调用toString
		
		System.out.println(map.containsKey(1001));//是否包含该关键字
		System.out.println(map.containsValue("张珊"));//是否有这个值
		
		System.out.println(map.get(1001));
		System.out.println(map.remove(1001));
		System.out.println(map);
		
		Set<Map.Entry<Integer, String>> se=map.entrySet();//Map的本质是有很多个entry组成的Set集合
		Iterator<Map.Entry<Integer, String>> it=se.iterator();//得到迭代器，得到迭代器则可以获取set的内容。
		while(it.hasNext()){
			 Map.Entry<Integer, String> e=it.next();
//			System.out.println(it.next().getValue());
			System.out.println(e.getKey()+"-->"+e.getValue());
		}
		//遍历
		for(int i=0;i<map.size();i++){
			
		}
	}

}
