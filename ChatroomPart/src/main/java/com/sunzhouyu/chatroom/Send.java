package com.sunzhouyu.chatroom;

import javax.rmi.CORBA.Util;
import java.io.*;
import java.net.Socket;

/**
 * @author sunyi
 * @create 2018/12/25
 */
public class Send implements Runnable {
    private DataOutputStream dos;

    private BufferedReader console;

    private Socket client;

    private String name;

    private boolean isRunning;

    public Send(Socket client, String name) {
        this.isRunning = true;
        this.name = name;
        console = new BufferedReader(new InputStreamReader(System.in));
        this.client = client;
        try {

            dos = new DataOutputStream(client.getOutputStream());
            send(name);

        } catch (IOException e) {
            e.printStackTrace();
            release();
        }
    }

    public void run() {

        while (isRunning) {

            String msg = "";
            try {
                msg = consule();
                if (!msg.equals("")) {
                    send(msg);
                }
                //3、获取消息
                //receive();
                //msg = dis.readUTF();
                // System.out.println(msg);
            } catch (Exception e) {
                release();
            }

        }
    }

    private String consule() {
        String msg = "";
        try {
            msg = console.readLine();
        } catch (Exception e) {
            release();
        }
        return msg;
    }

    private void send(String msg) {
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (Exception e) {
            release();
        }

    }

    private void release() {
        this.isRunning = false;
        Utils.release(dos, client);
    }
}
