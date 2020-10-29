package object.multipleThread.communication;

public class Box {
    private int product = 0;
    public synchronized void addProduct() {
        if (product >= 20) {
            try {
                wait();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        } else {
            product++;
            System.out.println("生产者生产了第" + product + "个产品");
            notifyAll();
        }
    }
    public synchronized void getProduct() {
        if (this.product <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("消费者取走了第" + product + "个产品");
            product--;
            notifyAll();
        }
    }

}
