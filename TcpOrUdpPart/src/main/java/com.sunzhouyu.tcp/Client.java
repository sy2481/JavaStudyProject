package com.sunzhouyu.tcp;

import java.io.DataOutputStream;
import java.net.Socket;

/**
 * @author sunyi
 * @create 2018/12/24
 */
public class Client {
    public static void main(String[] args) throws Exception{
        Socket socket=new Socket("localhost",9999);
        DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());
        String data="hello";
        dataOutputStream.writeUTF(data);
        dataOutputStream.flush();
        dataOutputStream.close();
        socket.close();
    }

}
