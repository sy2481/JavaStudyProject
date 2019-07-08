package com.sunzhouyu.tcp;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author sunyi
 * @create 2018/12/24
 */
public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(9999);
        Socket socket = server.accept();
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        System.out.println( dataInputStream.readUTF());
        dataInputStream.close();
        socket.close();
        server.close();
    }
}
