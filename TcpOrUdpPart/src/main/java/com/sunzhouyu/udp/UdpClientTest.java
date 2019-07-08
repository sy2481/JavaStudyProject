package com.sunzhouyu.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @author sunyi
 * @create 2018/12/24
 */
public class UdpClientTest {
    public static void main(String[] args) throws Exception {
        System.out.println("发送方启动中");
        //1.使用DatagramSocket  指定端口 创建发送端
        DatagramSocket client=new DatagramSocket(9999);
        //2.准备数据 转成字节数组
        String data="式短发";
        byte[] datas=data.getBytes();
        //3.封装成DatagramPacket 包裹需要指定目的地
        DatagramPacket packet=new DatagramPacket(datas,0, datas.length,new InetSocketAddress("localhost",11111));

        //4.发布包裹send （DatagramPacket）
        client.send(packet);
        //5.释放资源
        client.close();
    }
}
