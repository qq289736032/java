package com.jisen.TestFinal;

/**
 * @Desc TODO
 * @Author Administrator
 * @Date 2018/12/26 15:27
 */
public final class TestFinal {
    /**
     * final修饰类,不允许被继承
     * final修饰静态字段,直接用子类可以获取,不允许有set方法,即不允许被改变
     * final修饰普通字段,可以用子类获取
     * final修饰方法,不允许被重写,子类可以获取到
     * 在string中的表现则原对象不被修改,替换为新对象
     */
    public static void main(String[] args) {
        FinalClass finalClass = new FinalClass();
        FinalClass finalClass2 = new FinalClass2();

        //子类可以访问到final修饰的字段,说明字段可以被继承
        System.out.println(FinalClass2.getMaxValue());
        System.out.println(FinalClass2.MAX_VALUE);

        //
        System.out.println(finalClass.getName());
        System.out.println(finalClass2.getName());

    }

}
