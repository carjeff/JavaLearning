package study.thread;

/**
 * @author Jason
 * @date 2022/7/14 15:29
 * @Description
 */
public class ThreadDemo2 {
    public static void main(String[] args) {
        //任务对象
        Runnable target = new MyRunnable();
        Thread t = new Thread(target);
        t.start();


        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程执行");
            }
        };

        Thread t1 = new Thread(r);
        t1.start();


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程执行");
            }
        });

        Thread t3 = new Thread(() -> System.out.println("子线程执行"));

    }
}

class  MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程执行输出" + i);
        }
    }
}
