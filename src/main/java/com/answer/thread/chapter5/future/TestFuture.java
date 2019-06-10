package com.answer.thread.chapter5.future;

/**
 * @author answer
 * @description
 * @create 2018/4/3 15:58
 **/
public class TestFuture {
    public static void main(String[] args) {

        Client client = new Client();
        //这里会立即返回 因为得到的是futureData 而不是RealData
        Data data = client.request("name");
        System.out.println("请求完毕");
        try {
            //这里可以用一个slee代替对其他业务逻辑的处理
            //在处理这些业务逻辑的过程中，RealData被创建，从而充分利用了等待时间
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //使用真实的数据
        System.out.println("RealdData 真实数据为 === " + data.getResult());
    }
}
