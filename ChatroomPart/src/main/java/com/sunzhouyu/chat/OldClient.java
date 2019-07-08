package com.sunzhouyu.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author sunyi
 * @create 2018/12/25
 */
public class OldClient {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 9999);

        //2、客户端发送消息
        BufferedReader console =new BufferedReader(new InputStreamReader(System.in));
        String msg = console.readLine();
        DataOutputStream dos =new DataOutputStream(client.getOutputStream());
        dos.writeUTF(msg);
        dos.flush();
        //3、获取消息
        DataInputStream dis =new DataInputStream(client.getInputStream());
        msg =dis.readUTF();
        System.out.println(msg);

        dos.close();
        dis.close();
        client.close();
    }
}

