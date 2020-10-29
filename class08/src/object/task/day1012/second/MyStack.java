package object.task.day1012.second;



import java.util.Arrays;

//数组实现栈
public class MyStack<T> implements Stack {

    private T[] stack;
    private int size = 0;

    MyStack() {
        stack = (T[]) new Object[5];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public void push(Object element) {
        expandCapability(size + 1);
        stack[size] = (T) element;
        size++;
    }

    private void expandCapability(int size) {
        int len = stack.length;
        if (size > len) {
            size = size * 2;
            stack = Arrays.copyOf(stack, size);
        }
    }

    @Override
    public Object pop() {
        Object object = peek();
        if (size > 0) {
            stack[size - 1] = null;
            size--;
        }
        return object;
    }

    @Override
    public Object peek() {
        Object object = null;
        if (size > 0) {
            object = stack[size - 1];
        }
        return object;
    }
}
