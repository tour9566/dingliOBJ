package object.task.day1012.third;

public class MyQueue implements Queue {
    private int maxSize;
    private int front;
    private int rear;
    private Object[] arr;

    MyQueue(int arrMaxsize) {
        maxSize = arrMaxsize;
        arr = new Object[maxSize];
        front = -1;
        rear = -1;
    }

    @Override
    public int size() {
        return rear - front;
    }

    @Override
    public boolean isEmpty() {
        return rear == front;
    }


    @Override
    public void push(Object element) {
        if(isFull()){
            System.out.println("队列已满，不能添加");
            return;
        }
        arr[++rear] = element;

    }

    @Override
    public Object pop() {
        if(isEmpty()){
            System.out.println("队列已空");
            return null;
        }
        return arr[++front];
    }

    @Override
    public Object peek() {
        return arr[front++];
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

}
