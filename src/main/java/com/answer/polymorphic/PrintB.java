package com.answer.polymorphic;

public class PrintB implements IPrint{
    @Override
    public String printStr() {
        String result = "This is PrintB printStr()......";
        System.out.println(result);
        return result;
    }

    @Override
    public void printNull() {
        System.out.println("This is PrintB no param method......");
    }

    @Override
    public String printStr(String str) {
        System.out.println("This is PrintB a String param " + str );
        return  "This is PrintB a String param str....";
    }
}
