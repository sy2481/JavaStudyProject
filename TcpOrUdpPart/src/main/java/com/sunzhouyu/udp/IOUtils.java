package com.sunzhouyu.udp;

import java.io.*;

/**
 * @author sunyi
 * @create 2018/12/24
 */
public class IOUtils {

    public static byte[] fileToByteArray(String filePath){
        //1、创建源与目的地
        File src=new File(filePath);
        byte[] dest=null;
        //2、选择流
        InputStream is =null;
        ByteArrayOutputStream baos =null;
        try {
            is =new FileInputStream(src);
            baos = new ByteArrayOutputStream();
            //3、操作(分段读取)
            byte[] flush = new byte[1024*10]; //缓冲容器
            int len = -1; //接收长度
            while((len=is.read(flush))!=-1) {
                baos.write(flush,0,len);		 //写出到字节数组中
            }
            baos.flush();
            return baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4、释放资源
            try {
                if(null!=is) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 2、字节数组写出到图片
     * 1)、字节数组到程序 ByteArrayInputStream
     * 2)、程序到文件 FileOutputStream
     */
    public static void byteArrayToFile(byte[] src,String filePath) {
        //1、创建源
        File dest = new File(filePath);
        //2、选择流
        InputStream  is =null;
        OutputStream os =null;
        try {
            is =new ByteArrayInputStream(src);
            os = new FileOutputStream(dest);
            //3、操作 (分段读取)
            byte[] flush = new byte[5]; //缓冲容器
            int len = -1; //接收长度
            while((len=is.read(flush))!=-1) {
                os.write(flush,0,len);			//写出到文件
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4、释放资源
            try {
                if (null != os) {
                    os.close();
                }
            } catch (Exception e) {
            }
        }
    }
}
