package com.jisen;

//class Info{
//	private int id;
//	private String name;
//	public Info(){}
//	public Info(int id,String name){
//		this.id=id;
//		this.name=name;
//	}
//	public void setId(int id){
//		this.id=id;
//	}
//	public void setName(String name){
//		this.name=name;
//	}
//	public int getId(){
//		return id;
//	}
//	public String getName(){
//		return name;
//	}
//	
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return "id:"+id+"name:"+name;
//	}
//}
class Info<T,K>{
	private T id;
	private K name;
	public Info(){}
	public Info(T id,K name){
		this.id=id;
		this.name=name;
	}
	public void setId(T id){
		this.id=id;
	}
	public void setName(K name){
		this.name=name;
	}
	public T getId(){
		return id;
	}
	public K getName(){
		return name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id:"+id+"name:"+name;
	}
}

class Sys<X>{
	private X val;
	public Sys(){}
	public Sys(X val){
		this.val=val;
	}
	public X getVal() {
		return val;
	}
	public void setVal(X val) {
		this.val = val;
	}
	@Override
	public String toString() {
		return "va=" + val ;
	}
	
}
public class GenericParameter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer i=new Integer(10);
		Sys<Integer> s=new Sys<Integer>(10);
		Info<Integer, String> info=new Info<Integer, String>(1001,"王大锤");
		
		Sys<Info<Integer, String>> siis=new Sys<Info<Integer, String>>(new Info<Integer, String>(1001,"王大锤"));
		System.out.println(siis);
	}

}
