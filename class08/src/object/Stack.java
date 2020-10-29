package object;

public interface Stack<T> {
    // 元素的数量
    int size();
    // 是否为空
    boolean isEmpty();
    // 入栈
    void push (T element);
    // 出栈
    T pop();
    // 获取栈顶的元素
    T peek();
}
