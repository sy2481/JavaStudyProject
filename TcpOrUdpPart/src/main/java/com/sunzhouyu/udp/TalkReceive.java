package com.sunzhouyu.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author sunyi
 * @create 2018/12/24
 */
public class TalkReceive implements Runnable {

    private DatagramSocket server;

    public TalkReceive(int port) {
        try {
            server = new DatagramSocket(port);
        } catch (Exception e) {

        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                //2.准备容器 封装成DatagramPacket包裹
                byte[] container = new byte[1024 * 60];
                DatagramPacket packet = new DatagramPacket(container, 0, container.length);
                //3.阻塞式接受包裹receive DatagramPacket
                server.receive(packet);
                //4.分析数据
                byte[] datas = packet.getData();
                int leng = packet.getLength();
                String data = new String(datas, 0, leng);
                System.out.println(data);
                if (data.equals("bye")) {
                    break;
                }
            } catch (Exception e) {
            }
            //5.释放资源

        }
        server.close();
    }
}
