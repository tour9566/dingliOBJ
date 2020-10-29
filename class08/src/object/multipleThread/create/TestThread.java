package object.multipleThread.create;

class MyThread extends Thread {
    public MyThread(){
        super();
    }

    @Override
    public void run() {
            System.out.println("子线程开始运行");
    }
}

public class TestThread{
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("主线程");
    }
}
