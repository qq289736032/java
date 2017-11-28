package com.orm;

import java.lang.reflect.*;
import java.sql.*;


import com.jisen.annotation.FieldAnnotation;
import com.jisen.annotation.TableNameAnnotation;
import com.jisen.myenum.FieldType;

public class OrmHelp {
	public static void insert(Object obj) {
		Class<?> c=obj.getClass();
		
		StringBuilder sb=new StringBuilder();
		sb.append("insert into ");
		
		TableNameAnnotation ta=c.getAnnotation(TableNameAnnotation.class);
		sb.append(ta.tableName()+"(");
		
		Field[] fs=c.getDeclaredFields();
		Object[] fieldvalues=new Object[fs.length];
		FieldType[] fieldtypes=new FieldType[fs.length];
		for (int i=0;i<fs.length;i++) {
			FieldAnnotation fan = fs[i].getAnnotation(FieldAnnotation.class);
			sb.append(fan.fieldName() + ", ");//获取数据库中字段的名字
			fieldtypes[i]=fan.fieldtype();//获取数据库中字段的类型
			fs[i].setAccessible(true);
			try {
				fieldvalues[i]=fs[i].get(obj);//插入到数据库表中的数据
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sb.deleteCharAt(sb.length()-1);
		sb.deleteCharAt(sb.length()-1);
		
		sb.append(") values(");
		for(int i=0;i<fieldvalues.length;i++){
			switch(fieldtypes[i]){
			case varchar:
				sb.append("\'"+fieldvalues[i]+"\'"+", ");
				break;
			case number:
				sb.append(fieldvalues[i]+",");
				break;
			}
		}
		sb.deleteCharAt(sb.length()-1);
		sb.deleteCharAt(sb.length()-1);
		sb.append(")");
//		sb.append("\'"+stu.getName()+"\'");
//		sb.append(",");
//		sb.append(stu.getAge()+")");
		String sql=sb.toString();
		System.out.println("sql:"+sql);
		
		//mysql连接数据库
		try {
			Class.forName("com.mysql.jdbc.Drive");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url="jdbc:mysql://localhost:3306/smis?user=root&password=123456";
		try {
			Connection con=DriverManager.getConnection(url);
			Statement stat=con.createStatement();
			stat.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//
	}
}
