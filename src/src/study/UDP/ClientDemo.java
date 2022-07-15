package study.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author Jason
 * @date 2022/7/15 11:07
 * @Description
 */
public class ClientDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("==========客户端启动==================");
        //创建发送端对象
        DatagramSocket socket = new DatagramSocket();

        byte[] buffer = "绝世独立看就是老家来到家里".getBytes();
        DatagramPacket packet = new DatagramPacket(buffer,buffer.length, InetAddress.getLocalHost(),8888);

        //发送数据
        socket.send(packet);

        socket.close();

    }
}
