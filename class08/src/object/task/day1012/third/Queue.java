package object.task.day1012.third;

public interface Queue<T> {
    int size();
    boolean isEmpty();
    void push(T element);
    T pop();
    T peek();
}
