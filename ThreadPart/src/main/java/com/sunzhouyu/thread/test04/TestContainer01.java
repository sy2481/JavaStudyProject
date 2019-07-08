/**
 * 生产者消费者
 * wait&notify
 * wait/notify都是和while配合应用的。可以避免多线程并发判断逻辑失效问题。
 */
package com.sunzhouyu.thread.test04;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class TestContainer01<E> {

    private final LinkedList<E> list = new LinkedList<>();

    private final int MAX = 1;

    private int count = 0;

    public synchronized int getCount() {
        return count;
    }

    public synchronized void put(E e) {
        while (list.size() == MAX) {
            try {
                this.wait();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }

        list.add(e);
        count++;
        this.notifyAll();
    }

    public synchronized E get() {
        E e = null;
        while (list.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
        e = list.removeFirst();
        count--;
        this.notifyAll();
        return e;
    }

    public static void main(String[] args) {
        final TestContainer01<String> c = new TestContainer01<>();
        for (int i = 0; i < 25; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 20; j++) {
                        System.out.println("get " + c.get());
                    }
                    try {
                        sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "consumer" + i).start();
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (int i = 0; i < 1; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 500; j++) {
                        System.out.println("put value " + j);
                        c.put("container value " + j);
                    }
                    try {
                        sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "producer" + i).start();
        }
    }

}