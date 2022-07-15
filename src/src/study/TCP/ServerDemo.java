package study.TCP;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * @author Jason
 * @date 2022/7/15 13:54
 * @Description
 */
public class ServerDemo {

    //使用静态变量定义线程池
    private static ExecutorService pool = new ThreadPoolExecutor(3,
            5, 6, TimeUnit.SECONDS,new ArrayBlockingQueue<>(2),
            Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        try {

            System.out.println("=======服务端启动=========");
            //建立服务端的通信管道
            ServerSocket serverSocket = new ServerSocket(7777);

            while (true) {
                //必须调用accept方法，等待连接请求
                Socket socket = serverSocket.accept();
                System.out.println(socket.getRemoteSocketAddress() + "  上线了！");
                Runnable target = new ServerReaderRunnable(socket);
                pool.execute(target);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
