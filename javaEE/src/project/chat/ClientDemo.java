package project.chat;

import java.io.*;
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

            //  创建一个独立的线程专门接消息
            new ClientReaderThread(socket).start();

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

class  ClientReaderThread extends Thread{
    private Socket socket;

    public ClientReaderThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            //打包成缓冲字符输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String msg;
            while ((msg = br.readLine()) != null) {
                System.out.println("收到消息：" + msg);
            }
        } catch (Exception e) {
            System.out.println("服务端把你踢出群聊了！");
        }
    }
}
