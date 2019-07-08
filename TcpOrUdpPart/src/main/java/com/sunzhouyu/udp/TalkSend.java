package com.sunzhouyu.udp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @author sunyi
 * @create 2018/12/24
 */
public class TalkSend implements Runnable {
    private DatagramSocket client;

    private BufferedReader reader;

    private String toIP;

    private int toPort;

    public TalkSend(int port, String toIP, int toPort) {
        this.toIP = toIP;
        this.toPort = toPort;
        try {
            client = new DatagramSocket(port);

        } catch (Exception e) {

        }
    }

    @Override
    public void run() {
//2.准备数据 转成字节数组
        reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                String data = reader.readLine();

                byte[] datas = data.getBytes();
                //3.封装成DatagramPacket
                DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress(toIP, toPort));

                //4.发布包裹send(DatagramPacket)
                client.send(packet);
                if (data.equals("bye")) {
                    break;
                }
            } catch (Exception e) {
            }
        }
        client.close();
    }
}
