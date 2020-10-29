package object.multipleThread.communication;

public class BoxDemo {
    public static void main(String[] args) {
        Box box = new Box();
        Thread productorThread = new Thread(new Productor(box));
        Thread consumerThread = new Thread(new Consumer(box));
        productorThread.start();
        consumerThread.start();
    }
}
