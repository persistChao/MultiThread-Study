package com.answer.polymorphic;

public class TestPrint {
    public static void main(String[] args) {
        PrintA a = new PrintA();
        testPrint(a);
        System.out.println("----------------------");
        PrintB b = new PrintB();
        testPrint(b);
        System.out.println("===================华丽的分割线================");
        PrintC c = new PrintC();
        testAbstractPrint(c);
        System.out.println("----------------------");
        PrintD d = new PrintD();
        testAbstractPrint(d);
    }


    public static Object testPrint(IPrint print) {
        print.printStr();
        print.printNull();
        return print.printStr("Test Print");
    }

    public static void testAbstractPrint(AbstractPrint print) {
        print.print();
    }
}
