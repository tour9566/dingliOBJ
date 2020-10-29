package object;

public interface Queue<T> {
        // 元素的数量
        int size();
        // 是否为空
        boolean isEmpty();
        // 入队
        void insert (T element);
        // 出队
        T remove();
        // 获取队列的头元素
        T peek();
    }
