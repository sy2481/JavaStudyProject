/**
 * @Author sunyi
 * @Date: 2019/6/27
 */
public class VolatileDemo {
    private int cc=11;
    private volatile int count = 0;

    public int getCount() {
        return this.count;
    }

    public void setCount() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        synchronized (this) {
            this.count++;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        VolatileDemo demo = new VolatileDemo();
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {

                    // TODO Auto-generated method stub
                    demo.setCount();
                }

            }).start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(demo.getCount());
    }
}
