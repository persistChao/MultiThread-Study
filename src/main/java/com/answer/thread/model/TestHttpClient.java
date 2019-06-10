package com.answer.thread.model;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.junit.Test;

import java.io.IOException;

public class TestHttpClient {

    @Test
    public void testHttp() {
        HttpClient client = new HttpClient();
        String url = "http://192.168.152.8:8080/data-client/SystemController/queryGooods";
        PostMethod post = new PostMethod(url);
        post.setParameter("shopId" , "10002");
        post.setParameter("dataId" , "100001");
//        post.setRequestHeader();

        try {
            client.executeMethod(post);
            String result = post.getResponseBodyAsString();
            System.out.println(JSONObject.toJSONString(result));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
