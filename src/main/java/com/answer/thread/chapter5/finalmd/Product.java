package com.answer.thread.chapter5.finalmd;

/**
 * 不可变的产品对象
 * @author answer
 * @description
 * @create 2018/4/2 15:28
 **/
public class Product {
    private final String no;
    private final String name;
    private final double price;

    public  Product(String no , String name , double price) {
        this.no = no;
        this.name = name;
        this.price = price;
    }
}
