package com.sunzhouyu.udp;

/**
 * @author sunyi
 * @create 2018/12/24
 */
public class TalkStudent {
    public static void main(String[] args) {
        new Thread(new TalkSend(9999,"localhost",11111)).start();
        new Thread(new TalkReceive(6666)).start();
    }
}
