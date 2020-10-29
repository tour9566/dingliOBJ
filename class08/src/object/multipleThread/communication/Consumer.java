package object.multipleThread.communication;

import object.multipleThread.communication.Box;

public class Consumer implements Runnable{
    Box box;
    public Consumer(Box box) {
        this.box = box;
    }
    @Override
    public void run() {
        System.out.println("消费者开始取走产品");
        while (true) {
            try {
                Thread.sleep((int) Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            box.getProduct();
        }
    }

}
