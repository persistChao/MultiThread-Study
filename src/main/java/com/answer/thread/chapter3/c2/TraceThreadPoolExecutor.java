package com.answer.thread.chapter3.c2;



import java.util.concurrent.*;

/**
 * @author answer
 * @description
 * @create 2018/2/26 11:48
 **/
public class TraceThreadPoolExecutor extends ThreadPoolExecutor{
    public TraceThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    public void execute(Runnable task) {
        super.execute(wrap(task , clientTrace() , Thread.currentThread().getName()));
    }

    @Override
    public Future<?> submit(Runnable task) {
        return super.submit(wrap(task , clientTrace() , Thread.currentThread().getName()));
    }

    private Exception clientTrace() {
        return new Exception("Client stack trace");
    }

    private Runnable wrap(final Runnable task , final Exception clientStack, String clientThreadName) {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    task.run();
                }catch (Exception e) {
                    clientStack.printStackTrace();
                    throw e;
                }
            }
        };
    }

    public static void main(String[] args) {
        ThreadPoolExecutor pools = new TraceThreadPoolExecutor(0 , Integer.MAX_VALUE , 0L,
                TimeUnit.SECONDS , new SynchronousQueue<Runnable>());
        for (int i = 0; i < 5 ; i++) {
            //使用execute执行
            pools.execute(new DivTask(100 , i));
            //使用submit 提交任务
//            pools.submit(new DivTask(100 , i));
            //使用submit 打印的异常堆栈信息 不如 execute打印的全面
        }
    }
}
