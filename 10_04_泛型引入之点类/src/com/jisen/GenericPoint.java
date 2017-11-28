package com.jisen;

class Point<Type>{
	private Type x;
	private Type y;
	public Point(){}
	public Point(Type x,Type y){
		this.x=x;
		this.y=y;
	}
	
	public Type getX() {
		return x;
	}
	public void setX(Type x) {
		this.x = x;
	}
	public Type getY() {
		return y;
	}
	public void setY(Type y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "("+x+","+y+")";
	}
}

public class GenericPoint {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Point<Integer> pi=new Point<Integer>(1,2);
		System.out.println(pi.toString());
		Point<String> ps=new Point<String>("a","b");
		System.out.println(ps.toString());
		
	}

}
