package object.multipleThread.communication;

import object.multipleThread.communication.Box;

public class Productor  implements Runnable{
    Box box;
    public Productor(Box box) {
        this.box = box;
    }
    @Override
    public void run() {
        System.out.println("生产者开始生产产品");
        while (true) {
            try {
                Thread.sleep((int) Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            box.addProduct();
        }
    }
}
