package com.sunzhouyu.chatroom;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author sunyi
 * @create 2018/12/25
 */
public class Receive implements Runnable {
    private DataInputStream dis;

    private Socket client;

    private BufferedReader console;

    private boolean isRunning;

    public Receive(Socket client) {
        try {
            this.client = client;
            dis = new DataInputStream(client.getInputStream());
            this.isRunning = true;
        } catch (Exception e) {
        }
    }

    public void run() {

        while (isRunning) {
            receive();

        }
    }

    private String receive() {
        String msg = "";
        try {
            msg = dis.readUTF();
            System.out.println(msg);
        } catch (Exception e) {
        }
        return msg;
    }
}
