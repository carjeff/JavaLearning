package study.TCP;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Jason
 * @date 2022/7/15 13:54
 * @Description
 */
public class ClientDemo {
    public static void main(String[] args) {
        //1. 创建socket管道，
        try {
            System.out.println("=========客户端启动=========");
            Socket socket = new Socket("127.0.0.1",7777);

            OutputStream os = socket.getOutputStream();
            //把低级的字节流 打包成打印流
            PrintStream ps = new PrintStream(os);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("请说");
                String s = scanner.nextLine();
                ps.println(s);
                ps.flush();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
