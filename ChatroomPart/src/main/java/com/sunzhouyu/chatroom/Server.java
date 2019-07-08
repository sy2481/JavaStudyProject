package com.sunzhouyu.chatroom;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author sunyi
 * @create 2018/12/25
 */
public class Server {

    private static CopyOnWriteArrayList<Channel> all = new CopyOnWriteArrayList<Channel>();

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9999);

        boolean isrunning = true;
        while (isrunning) {

            //3、接收消息
//            dis = new DataInputStream(socket.getInputStream());
//            dos = new DataOutputStream(socket.getOutputStream());
//            String msg = dis.readUTF();
//            //4、返回消息
//
//            dos.writeUTF(msg);
//            //释放资源
//            dos.flush();
            Socket socket = serverSocket.accept();
            System.out.println("一个客户端建立了连接");
            Channel c = new Channel(socket);
            all.add(c);

            new Thread(c).start();
        }

    }

    static class Channel implements Runnable {
        private DataOutputStream dos;

        private DataInputStream dis;

        private Socket client;

        private String name;

        public Channel(Socket client) {
            try {

                this.client = client;
                dos = new DataOutputStream(client.getOutputStream());
                dis = new DataInputStream(client.getInputStream());
//获取名称
                this.name = receive();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public void run() {
            boolean isRunning = true;
            while (isRunning) {

                String msg = "";
                try {
                    //msg = consule();

                    //3、获取消息
                    msg = receive();
//                    send(msg);
                    sendOthers(msg);
                    //msg = dis.readUTF();
                    // System.out.println(msg);
                } catch (Exception e) {
                    Utils.release(dos, dis, client);
                }

            }

        }

//        private String consule() {
//
//            String msg = "";
//            try {
//                msg = console.readLine();
//            } catch (Exception e) {
//            }
//            return msg;
//        }

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
                //System.out.println(msg);
            } catch (Exception e) {
            }
            return msg;
        }

        private void sendOthers(String msg) {
            boolean isPrivate = msg.startsWith("@");

            for (Channel other : all) {
                if (other == this) { //自己
                    continue;
                } else {

                    other.send(this.name + "对所有人说:" + msg);//群聊消息
                }
            }

        }

    }

}
