package object.exception;

public class Example {
    public static void main(String[] args) {
        int result = 0;
        result = divide(4, 0);
        System.out.println(result);
    }

    public static int divide(int x, int y) {
        if (y == 0) throw new ArithmeticException("被除数不能为0");
        int result = x / y;
        return result;
    }
}
