package com.answer.thread.chapter5.future;


/**
 * @author answer
 * @description
 * @create 2018/4/3 15:54
 **/
public class Client {
    public Data request(final String queryStr) {
        final FutureData future = new FutureData();
        new Thread() {
            public void run() {
                //realData 构建很慢 所以在单独的线程中进行
                RealData realData = new RealData(queryStr);
                future.setRealData(realData);
            }
        }.start();
        //futrue 会被立即返回
        return future;
    }
}
