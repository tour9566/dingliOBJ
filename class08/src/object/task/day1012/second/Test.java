package object.task.day1012.second;

public class Test {
    public static void main(String[] args) {
        MyStack myStack = new MyStack<String>();
        System.out.println("栈是否为空"+myStack.isEmpty());
        System.out.println("栈长度"+myStack.size());
        for (int i = 0; i < 100; i++) {
            myStack.push(i);
        }
        System.out.println("出栈"+myStack.pop());
        System.out.println(myStack.peek());
    }
}
