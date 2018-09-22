package com.jisen.实战OutOfMemoryError异常;

/**
 * Created by jisen on 2018/6/14.
 */
public class JavaVMStackSOF {
    private int stackLength = 1;
    public void stackLeak(){
        stackLength++;
        stackLeak();//递归栈内存溢出
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try{
            oom.stackLeak();
        }catch (Throwable e){
            System.out.println("stack length:"+ oom.stackLength);
            throw e;
        }
    }
}
