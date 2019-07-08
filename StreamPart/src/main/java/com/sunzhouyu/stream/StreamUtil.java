package com.sunzhouyu.stream;

import java.io.*;

/**
 * @author sunyi
 * @create 2018/12/6
 */
public class StreamUtil {

    public static void main(String args[]) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);

            dataOutputStream.writeBoolean(false);
            dataOutputStream.writeFloat(123123);
            dataOutputStream.flush();
            byte[] data = byteArrayOutputStream.toByteArray();
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(data));
            System.out.println(dataInputStream.readBoolean());
            System.out.println(dataInputStream.readFloat());
            //DataInputStream dataInputStream = new DataInputStream(new FileInputStream(""));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

