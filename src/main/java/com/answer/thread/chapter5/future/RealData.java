package com.answer.thread.chapter5.future;

/**
 * @author answer
 * @description
 * @create 2018/4/3 15:48
 **/
public class RealData implements Data{
    protected final String result;
    public RealData(String para) {
        //RealData的构造可能很慢，需要用户等很久，这里使用sleep模拟
        StringBuffer sb = new StringBuffer();
        for (int i = 0 ; i< 10;i++) {
            sb.append(para);
            try {
                //这里使用sleep代替一个很慢的操作过程
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        result = sb.toString();
    }

    @Override
    public String getResult() {
        return result;
    }
}
