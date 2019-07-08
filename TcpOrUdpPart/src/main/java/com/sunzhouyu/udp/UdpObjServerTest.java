package com.sunzhouyu.udp;

//import com.sunzhouyu.pojo.Employee;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

/**
 * @author sunyi
 * @create 2018/12/24
 */
public class UdpObjServerTest {
    public static void main(String[] args) throws Exception{
        System.out.println("接收方启动中");
        //1.使用DatagramSocket指定端口创建接收端
        DatagramSocket server=new DatagramSocket(11111);
        //2.准备容器 封装成DatagramPacket包裹
        byte[] container=new byte[1024*60];
        DatagramPacket packet=new DatagramPacket(container,0,container.length);
        //3.阻塞式接受包裹receive DatagramPacket
        server.receive(packet);
        //4.分析数据
        byte[] datas=packet.getData();
        int leng=packet.getLength();
        //读取 -->反序列化
        ObjectInputStream ois =new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        //顺序与写出一致
//        String msg = ois.readUTF();
//        int age = ois.readInt();
//        boolean flag = ois.readBoolean();
//        char ch = ois.readChar();
//        System.out.println(flag);
//        对象的数据还原
        Object str = ois.readObject();
        Object date = ois.readObject();
        Object employee = ois.readObject();

        if(str instanceof String) {
            String strObj = (String) str;
            System.out.println(strObj);
        }
        if(date instanceof Date) {
            Date dateObj = (Date) date;
            System.out.println(dateObj);
        }
//        if(employee instanceof Employee) {
//            Employee empObj = (Employee) employee;
//            System.out.println(empObj.getName()+"-->"+empObj.getSalary());
//        }

        //5.释放资源
        server.close();
    }

}
