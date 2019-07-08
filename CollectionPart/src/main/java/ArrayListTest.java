import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author sunyi
 * @Date: 2019/6/21
 */
public class ArrayListTest {
//    public static void main(String[] args) {
//        ArrayList al = new ArrayList(10);
//        for(int i=0;i<10;i++){
//            al.add(i);
//        }
//        al.add(11);
//        al.add(12);
//        System.out.println();
//        al.trimToSize();
//
//        al.add(13);

//        List list = new ArrayList();
//
//
//
//        list.add(new Person());
//
//
//
//        list.add(new Person());
//
//        list.add(new Person());
//
//        Object[] ss = list.toArray();
//        for (int i = 0; i < ss.length; i++)
//
//        {
//            Person person = (Person) ss[i];
//
//            System.out.println(person);
//
//        }
    // Person[] person = (Person[]) list.toArray();

//        List list = new ArrayList();
//
//        list.add(new Person());
//
//        list.add(new Person());
//
//        list.add(new Person());
//
//        Person[] person = (Person[]) list.toArray(new Person[0]);
//        for (int i = 0; i < person.length; i++) {
//            System.out.println(person[i]);
//        }

//        System.out.println("1".hashCode());
//        System.out.println("2".hashCode());
//        System.out.println("9".hashCode());
//        System.out.println("0".hashCode());
//        System.out.println("A".hashCode());
//        System.out.println("a".hashCode());
//        System.out.println("12".hashCode());
//        System.out.println("100000000000000000000000000000000000000000000".hashCode());
//        System.out.println("100000000000000000000000000000000000000000001".hashCode());
//
//
//    }

    private static String A = "A";

    private static String B = "B";

    private static String C = "A";

    private static String D = "B";

    //    public static void main(String[] args) {
//        new ArrayListTest().deadLock();
//    }
    private void deadLock() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    try {
                        Thread.currentThread().sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (A) {
                        System.out.println("1");
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    synchronized (A) {
                        System.out.println("2");
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }

    private AtomicInteger atomicI = new AtomicInteger(0);

    private int i = 0;

//    public static void main(String[] args) {
//        final ArrayListTest cas = new ArrayListTest();
//        List<Thread> ts = new ArrayList<Thread>(600);
//        long start = System.currentTimeMillis();
//        for (int j = 0; j < 100; j++) {
//            Thread t = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    for (int i = 0; i < 10000; i++) {
//                        cas.count();
//                        cas.safeCount();
//                    }
//                }
//            });
//            ts.add(t);
//        }
//        for (Thread t : ts) {
//            t.start();
//        }
//// 􁒵􀮇􀲅􀹍􁕚􁑕􀲗􁤈􀨠􀱮
//        for (Thread t : ts) {
//            try {
//                t.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println(cas.i);
//        System.out.println(cas.atomicI.get());
//        System.out.println(System.currentTimeMillis() - start);
//    }

    /**
     * 􀖵􁊠CAS􀨫􁈿􁕚􁑕􀨞􀙂􁦇􀷄􀢏
     */
    private void safeCount() {
        for (; ; ) {
            int i = atomicI.get();
            boolean suc = atomicI.compareAndSet(i, ++i);
            if (suc) {
                break;
            }
        }
    }

    /**
     * 􁶋􁕚􁑕􀨞􀙂􁦇􀷄􀢏
     */
    private void count() {
        i++;
    }

    volatile long v = 0;

    public void set(long l) {
        v = l;
    }

    public void getAndIncrement() {
        v++;
    }

    public long get() {
        return v;
    }

    public static void main(String[] args) {
        final ArrayListTest cas = new ArrayListTest();
        for (int j = 0; j < 100; j++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        cas.set(i);

                    }
                }
            });

        }
//        for (Thread t : ts) {
//            t.start();
//        }
    }

}

