package study.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Jason
 * @date 2022/7/14 15:40
 * @Description
 */
public class ThreadDemo3 {
    public static void main(String[] args) {
        Callable<String> callable = new MyCall(100);
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread t = new Thread(futureTask);
        t.start();

        Callable<String> call2 = new MyCall(200);
        FutureTask<String> futureTask2 = new FutureTask<>(call2);
        Thread t2 = new Thread(futureTask2);
        t2.start();

        try {
            String s = futureTask.get();
            System.out.println("第一个结果是" + s);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}

class MyCall implements Callable<String>{
    private int n;
    public MyCall(int n ){
        this.n = n;
    }
    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i+1;
        }
        return "子线程执行的结果是：" + sum;
    }
}
