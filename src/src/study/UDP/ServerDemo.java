package study.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author Jason
 * @date 2022/7/15 11:07
 * @Description
 */
public class ServerDemo {

    public static void main(String[] args) throws Exception {
        System.out.println("============服务端启动============");
        DatagramSocket socket = new DatagramSocket(8888);

        byte[] buffer = new byte[1024*64];
        DatagramPacket packet = new DatagramPacket(buffer,buffer.length);

        socket.receive(packet);
        int length = packet.getLength();
        String rs = new String(buffer,0,length);
        System.out.println("收到了 "+ rs);

        socket.close();
    }
}
