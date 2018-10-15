package com.jisen;

/**
 * Created by jisen on 2018/10/10.
 */
public class TryCatchFinally {

    public static void main(String[] args) {
        System.out.println(execute());
    }
    public static String execute(){
        try{
            System.out.println(1/0);
            return "成功";
        }catch (Exception e){
            return "失败";
        }finally {
            System.out.println("fianlly");
//            return "finally体";
        }
        //return "成功吗";
    }
}
