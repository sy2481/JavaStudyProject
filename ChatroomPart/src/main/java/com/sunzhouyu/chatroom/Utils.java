package com.sunzhouyu.chatroom;

import java.io.Closeable;

/**
 * @author sunyi
 * @create 2018/12/25
 */
public class Utils {
    public static void release(Closeable... target) {
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
