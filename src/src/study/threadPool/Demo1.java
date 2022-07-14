package study.threadPool;

import java.util.concurrent.*;

/**
 * @author Jason
 * @date 2022/7/14 17:05
 * @Description
 */
public class Demo1 {
    public static void main(String[] args) {
        /*
         创建线程池对象
             public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              ThreadFactory threadFactory,
                              RejectedExecutionHandler handler) {
         */
        ExecutorService pool = new ThreadPoolExecutor(3,5,5, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        MyRun target = new MyRun();
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
    }
}
