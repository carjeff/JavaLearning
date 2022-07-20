package study.threadPool;

/**
 * @author Jason
 * @date 2022/7/14 17:09
 * @Description
 */
public class MyRun implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "输入了：hello world");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
