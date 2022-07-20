package project.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jason
 * @date 2022/7/15 13:54
 * @Description
 */
public class ServerDemo {

    public static List<Socket> allOnlineSockets = new ArrayList<>();
    //使用静态变量定义线程池

    public static void main(String[] args) {
        try {

            System.out.println("=======服务端启动=========");
            //建立服务端的通信管道
            ServerSocket serverSocket = new ServerSocket(7777);

            while (true) {
                //必须调用accept方法，等待连接请求
                Socket socket = serverSocket.accept();
                System.out.println(socket.getRemoteSocketAddress() + "  上线了！");
                allOnlineSockets.add(socket);
                new ServerReaderThread(socket).start();

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class ServerReaderThread extends Thread {
private Socket socket;

public ServerReaderThread(Socket socket) {
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
                System.out.println(socket.getRemoteSocketAddress() + "说了：" + msg);
                sendMsgToAll(msg);
            }
        } catch (Exception e) {
            System.out.println(socket.getRemoteSocketAddress() + "下线了");
            ServerDemo.allOnlineSockets.remove(socket);
        }
    }

    private void sendMsgToAll(String msg) throws IOException {
        for (Socket allOnlineSocket : ServerDemo.allOnlineSockets) {
            PrintStream ps = new PrintStream(allOnlineSocket.getOutputStream());
            ps.println(msg);
            ps.flush();
        }
    }
}