package com.sunzhouyu.udp;

/**
 * @author sunyi
 * @create 2018/12/24
 */
public class TalkTeacher {
    public static void main(String[] args) {
        new Thread(new TalkSend(7777,"localhost",6666)).start();
        new Thread(new TalkReceive(11111)).start();
    }


}
