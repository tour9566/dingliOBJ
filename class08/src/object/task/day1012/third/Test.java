package object.task.day1012.third;

public class Test {
    public static void main(String[] args) {
        MyQueue stringMyQueue = new MyQueue(5);
        System.out.println("队列是否空" + stringMyQueue.isEmpty());
        for (int i = 1; i <= 6; i++) {
            stringMyQueue.push(i);
        }
        System.out.println("队列是否满" + stringMyQueue.isFull());
        System.out.println("队列是长度：" + stringMyQueue.size());
        for (int i = 1; i <= 6; i++) {
            System.out.print(stringMyQueue.pop()+"  ");
        }
    }
}
