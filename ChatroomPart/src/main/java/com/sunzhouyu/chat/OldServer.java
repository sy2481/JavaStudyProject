package com.sunzhouyu.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author sunyi
 * @create 2018/12/25
 */
public class OldServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        System.out.println("一个客户端建立了连接");

        //3、接收消息
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        String msg = dis.readUTF();
        //4、返回消息
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF(msg);
        //释放资源
        dos.flush();
        dos.close();
        dis.close();
        socket.close();
    }

}
