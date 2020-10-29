package object;

import object.exception.NegativeValueException;

public class Test {
    public static void main(String[] args) {
        int i = -1;
        if (i < 0) {
            try {
                throw new NegativeValueException("半径值不能小于0");
            } catch (NegativeValueException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}
