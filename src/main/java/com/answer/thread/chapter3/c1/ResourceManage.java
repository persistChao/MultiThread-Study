package com.answer.thread.chapter3.c1;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by chao on 2018/8/31.
 */
public class ResourceManage {
    private final Semaphore semaphore;
    private boolean resourceArray[];
    private final ReentrantLock lock;

    public ResourceManage() {
        this.resourceArray = new boolean[10];
        this.semaphore = new Semaphore(10, true);
        this.lock = new ReentrantLock();
        for (int i = 0;i < 10 ; i++) {
            resourceArray[i] = true;
        }

    }

    public void useResource(int userId) {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int id = getResourceId();
        System.out.println("userId;" + userId + "正在使用资源" + id + "\n");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();

    }

    public int getResourceId(){
        int id = -1;
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                if (resourceArray[i]) {
                    resourceArray[i] = false;
                    id = i;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return id;
    };

    public static class ResourceUser implements Runnable {
        private ResourceManage resourceManage;
        private int userId;

        public ResourceUser(ResourceManage resourceManage, int userId) {
            this.resourceManage = resourceManage;
            this.userId = userId;
        }

        @Override
        public void run() {
            System.out.println("userId:" + userId + "准备使用资源...\n");
            resourceManage.useResource(userId);
            System.out.println("userId:" + userId + "使用资源完毕...\n");
        }
    }

    public static void main(String[] args) {
        ResourceManage resourceManage = new ResourceManage();
        Thread[] threads = new Thread[100];
        for (int i = 0;i < 100;i++) {
            Thread thread = new Thread(new ResourceUser(resourceManage, i));
            threads[i] = thread;
        }
        for (int i = 0;i < 100;i++) {
            threads[i].start();
        }
    }

}
