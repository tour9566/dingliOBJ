package object.multipleThread.ThreadSync;

import java.util.concurrent.locks.ReentrantLock;

class Ticket implements Runnable {
    private int ticket = 10;
    public synchronized void run() {
        while (true) {
            try {
                Thread.sleep(10);//休息一段时间，让该线程没有执行完
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "售出车票，ticket号：" + ticket--);
                } else
                    break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


public class Sync {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread thread1 = new Thread(ticket,"1窗口");
        Thread thread2 = new Thread(ticket,"2窗口");
        Thread thread3 = new Thread(ticket,"3窗口");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
