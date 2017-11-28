package com.jisen;

public class ClassOfGC {

	/**
	 * @param args
	 */
	public static ClassOfGC gc=null;//还处于创建对象状态，并未激活
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		gc=new ClassOfGC();//当new了一个新对象是表示激活状态，栈区gc存放了堆区的地址
		System.out.println(gc);
		gc=null;//当栈区的gc引用为空时，就切断了与堆区的联系所以变成去活状态
		System.out.println(gc);	
		System.gc();//通知垃圾回收机制，可以回收垃圾了（不是立马回收）
		try {		//延时2s
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(gc);	//通过finalize来重新调用之后重新激活
		//再次去活
		gc=null;
		System.out.println(gc);	
		System.gc();
		try {		//延时2s
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(gc);	//不可再次激活
	}
//Object-->equals hashCode toString clon getClass,finalize
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		gc=this;
		System.out.println("重新激活");
	}
}
