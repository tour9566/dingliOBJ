package object.multipleThread;


class Thread1 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i += 2) {
            System.out.println("i1=" + i);
        }
    }
}

class Thread2 extends Thread {
    @Override
    public void run() {
        for (int i = 2; i <= 100; i += 2) {
            System.out.println("i2=" + i);
        }
    }
}

public class Demo {
    public static void main(String[] args) {
        Thread thread1 = new Thread1();
        Thread thread2 = new Thread2();
        thread1.start();
        thread2.start();

    }
}
