package object.multipleThread.create;

public class MyThreadRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("子线程开始运行");
    }

    public static void main(String[] args) {
        MyThreadRunnable myThreadRunnable = new MyThreadRunnable();
        Thread mThread=new Thread(myThreadRunnable,"子线程");
        mThread.start();
        System.out.println("主线程");
    }
}
