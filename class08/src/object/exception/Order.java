package object.exception;

import java.util.Date;

public class Order {
    public static void main(String[] args) {
        Object obj = new Date();
        Order order= (Order) obj;
        System.out.println(order);
    }
}
