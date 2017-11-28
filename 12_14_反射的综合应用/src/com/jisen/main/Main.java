package com.jisen.main;

import com.jisen.student.Student;
import com.jisen.student.Teacher;
import com.orm.OrmHelp;

public class Main {

	/**
	 * @param args
	 * 
	 */
	
	
	public static void main(String[] args) {
		//new Student("zs",23);
		//insert into student(sname,sage) values("zs",23)
		OrmHelp.insert(new Student("zs",23));
		OrmHelp.insert(new Teacher("ls",24,5000));
	}

	

}
