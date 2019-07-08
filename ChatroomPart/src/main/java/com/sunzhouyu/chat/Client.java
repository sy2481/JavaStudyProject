package com.sunzhouyu.chat;

import java.io.*;
import java.net.Socket;

/**
 * @author sunyi
 * @create 2018/12/25
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 9999);
//        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
//        DataInputStream dis = new DataInputStream(client.getInputStream());
//        //2、客户端发送消息
//        boolean isRunning = true;
//        while (isRunning) {
//            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
//            String msg = console.readLine();
//
//            dos.writeUTF(msg);
//            dos.flush();
//            //3、获取消息
//
//            msg = dis.readUTF();
//            System.out.println(msg);
//        }
//        dos.close();
//        dis.close();
//        client.close();

        new Thread(new Channel(client)).start();
    }

    static class Channel implements Runnable {
        private DataOutputStream dos;

        private DataInputStream dis;

        private Socket client;

        private BufferedReader console;

        public Channel(Socket client) {
            try {
                console = new BufferedReader(new InputStreamReader(System.in));
                this.client = client;
                dos = new DataOutputStream(client.getOutputStream());
                dis = new DataInputStream(client.getInputStream());

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public void run() {
            boolean isRunning = true;
            while (isRunning) {

                String msg = "";
                try {
                    msg = consule();
                    send(msg);
                    //3、获取消息
                    receive();
                    //msg = dis.readUTF();
                    // System.out.println(msg);
                } catch (Exception e) {
                    release(dos, dis, client);
                }

            }

        }

        private String consule() {

            String msg = "";
            try {
                msg = console.readLine();
            } catch (Exception e) {
            }
            return msg;
        }

        private void send(String msg) {
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (Exception e) {
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

        public void release(Closeable... target) {
            for (Closeable a : target) {
                if (a != null) {
                    try {
                        a.close();
                    } catch (Exception e) {

                    }

                }
            }

        }
    }
}
