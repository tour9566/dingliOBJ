package object.task.day1012.second;

public interface Stack<T> {
    int size();
    boolean isEmpty();
    void push(T element);
    T pop();
    T peek();
}
