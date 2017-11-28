package com.jisen;

class AAAA{
	public void fun1(int m){
		System.out.println(m);
	}
	public void fun1(double k){
		System.out.println(k);
	}
	public Object fun2(int k){	//父类如果去掉public说明子类的可见性要比父类的大，说明	一大
		return new Object();	//两小：父类方法返回值类型大，为string比Object小，放法抛出异常小。  两小
	}
}
class BBBB extends AAAA{		
	@Override					//子类的fun2与父类fun2，方法名和参数相同, 两同
	public String fun2(int o){	//子类如果去掉public说明子类的可见性要比父类的小此时报错不能构成复写，说明	一大
		return "hello";			//两小：子类方法返回值类型小，为string比Object小，放法抛出异常小。  两小
	}
}
public class 方法复写 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AAAA aaaa=new AAAA();
		aaaa.fun1(10);
		aaaa.fun1(1.9);

	}

}
