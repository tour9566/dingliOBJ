package object.exception;

public class IndexOutExp {
    public static void main(String[] args) {

            travelArr();

    }

    private static void travelArr() throws IndexOutOfBoundsException{
        String arr[] = { "lisa", "bily", "kessy" };
        for (int i = 0; i < 5; i++) {
            System.out.println(arr[i]); // arr[4]?
        }
        System.out.println("this is the end");
    }
}
