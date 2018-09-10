package com.jisen.工厂模式;

interface Person{
	public void doWork();
}
class Student implements Person{

	public void doWork() {
		System.out.println("学生在做作业");
	}
}
class Teacher implements Person{

	public void doWork() {
		System.out.println("老师在批改作业");
	}
}
interface PersonFactory{
	public Person getPerson();
}
class StudentFactory implements PersonFactory{
	public Person getPerson(){
		return new Student();
	}
}
class TeacherFactory implements PersonFactory{
	public Person getPerson(){
		return new Teacher();
	}
}
public class Factory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PersonFactory pf=new StudentFactory();
		pf.getPerson().doWork();
		pf.getPerson().doWork();
		PersonFactory pf2=new TeacherFactory();
		pf2.getPerson().doWork();
	}

}
