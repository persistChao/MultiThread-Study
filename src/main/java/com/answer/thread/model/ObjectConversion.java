package com.answer.thread.model;/**
 * @Author: suchao
 * @Description:
 * @Date Create in 15:25 2017/12/8
 * @Modified by:
 */

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @description
 * @create 15:25
 **/
public class ObjectConversion {

    public static void convertObject(Object source , Object toObj) throws IllegalAccessException {
        Class sc = source.getClass();
        Class tc = toObj.getClass();

        Field[] sfds = sc.getDeclaredFields();

        Map<String , Object> tempMap = new HashMap<>();
        if (sfds.length>0) {
            for (Field f : sfds) {
                f.setAccessible(true);
                tempMap.put(f.getName(),f.get(source));
            }
        }

        Field[] tfds = tc.getDeclaredFields();
        if (tfds.length>0) {
            for (Field f : tfds) {
                f.setAccessible(true);
                String name = f.getName();
                if (tempMap.containsKey(name)) {
                    f.set(toObj,tempMap.get(name));
                }
            }
        }
        System.out.println(JSONObject.toJSONString(toObj));
    }

    @Test
    public void testConvert() throws IllegalAccessException {
        User u1 = new User();
        u1.setId("11");
        u1.setName("sc");
        User2 u2 = new User2();
        convertObject(u1 , u2);
    }
}
