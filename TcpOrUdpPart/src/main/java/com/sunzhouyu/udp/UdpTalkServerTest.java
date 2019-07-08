package com.sunzhouyu.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author sunyi
 * @create 2018/12/24
 */
public class UdpTalkServerTest {
    public static void main(String[] args) throws Exception {
        System.out.println("接收方启动中");
        //1.使用DatagramSocket 指定端口 创建接收端
        DatagramSocket server = new DatagramSocket(11111);
        while (true) {
            //2.准备容器 封装成DatagramPacket包裹
            byte[] container = new byte[1024 * 60];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);
            //3.阻塞式接受包裹receive （DatagramPacket）
            server.receive(packet);
            //4.分析数据
            byte[] datas = packet.getData();
            int leng = packet.getLength();
            String data = new String(datas, 0, leng);
            System.out.println(data);
            if (data.equals("bye")) {
                break;
            }
        }
        //5.释放资源
        server.close();
    }

}
