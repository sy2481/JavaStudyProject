package com.sunzhouyu.udp;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author sunyi
 * @create 2018/12/24
 */
public class UdpTypeServerTest {
    public static void main(String[] args) throws Exception{
        System.out.println("接收方启动中");
        //1.使用DatagramSocket 指定端口 创建接收端
        DatagramSocket server=new DatagramSocket(11111);
        //2.准备容器 封装成DatagramPacket包裹
        byte[] container=new byte[1024*60];
        DatagramPacket packet=new DatagramPacket(container,0,container.length);
        //3.阻塞式接受包裹receive （DatagramPacket）
        server.receive(packet);
        //4.分析数据
        byte[] datas=packet.getData();
        int leng=packet.getLength();
        DataInputStream dataInputStream=new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        //System.out.println(new String(datas,0,leng));

        System.out.println(dataInputStream.readUTF());
        System.out.println(dataInputStream.readInt());
        //5.释放资源
        server.close();
    }

}
