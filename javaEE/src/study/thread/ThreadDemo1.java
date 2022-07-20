package study.thread;

/**
 * @author Jason
 * @date 2022/7/14 15:20
 * @Description
 */
public class ThreadDemo1{
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start();//执行的还是run方法

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程执行" + i);
        }
    }
}

class MyThread extends Thread{
    //重写run方法

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程执行输出" + i);
        };
    }
}
