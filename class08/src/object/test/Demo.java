package object.test;

public class Demo {
    static int id = 10;

    public Demo() {
    }
    public void changeId() {
        id *= 2;
        System.out.println(id);
    }
    public static void main(String[] args) {
        Demo demo1 = new Demo();
        Demo demo2 = new Demo();

        demo2.id = 20;

        System.out.println("demo1的属性值：" + demo1.id);
        demo1.changeId();

        System.out.println("demo2的属性值：" + demo2.id);
        demo2.changeId();
    }

}
