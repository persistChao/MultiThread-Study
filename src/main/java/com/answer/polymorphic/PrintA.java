package com.answer.polymorphic;

public class PrintA implements IPrint {

    @Override
    public String printStr() {
        String result = "This is PrintA printStr()......";
        System.out.println(result);
        return result;
    }

    @Override
    public void printNull() {
        System.out.println("This is PrintA no param method......");
    }

    @Override
    public String printStr(String str) {
        System.out.println("This is PrintA a String param " + str );
        return  "This is PrintA a String param str....";
    }
}
