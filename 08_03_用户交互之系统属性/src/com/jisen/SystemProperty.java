package com.jisen;

import java.util.*;


public class SystemProperty {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Map<String, String> map =System.getenv();//返回的是一个Map<K, V>
//		Set<Map.Entry<String, String>> set=map.entrySet();
//		Iterator<Map.Entry<String, String>> it=set.iterator();
//		while(it.hasNext()){
//			Map.Entry<String, String> mess=it.next();
//			System.out.println(mess.getKey()+"\t\t\t"+mess.getValue());
//		}
		Properties ps=System.getProperties();
//		ps.list(System.out);
		System.out.println(ps.getProperty("os.name"));
		
		Enumeration<?> en=ps.propertyNames();
		while(en.hasMoreElements()){
			String key=(String) en.nextElement();
			String value=ps.getProperty(key);
			System.out.println(key+"\n\t"+value);
		}
		
		
	}

}
