package object.task.day1012.second;

public class MyLinkStack<T> implements Stack {

    class Node<T> {
        private T t;
        private Node next;
    }

    private Node<T> head;

    MyLinkStack() {
        head = null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        if (head == null) return true;
        return false;
    }

    @Override
    public void push(Object element) {


    }

    @Override
    public Object pop() {
        return null;
    }

    @Override
    public Object peek() {
        return null;
    }


}
