package object.multipleThread.ThreadSync;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest implements Runnable {
    private int ticket = 10;
    private final ReentrantLock lock = new ReentrantLock();
    public void run() {
        while (true) {
            lock.lock();
            try {
                Thread.sleep(10);//休息一段时间，让该线程没有执行完
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "售出车票，ticket号：" + ticket--);
                } else
                    break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.lock();
            }
        }
    }

    public static void main(String[] args) {
            LockTest lockTest = new LockTest();
            Thread thread1 = new Thread(lockTest,"1窗口");
            Thread thread2 = new Thread(lockTest,"2窗口");
            Thread thread3 = new Thread(lockTest,"3窗口");
            thread1.start();
            thread2.start();
            thread3.start();

    }

}
