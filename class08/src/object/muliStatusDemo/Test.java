package object.muliStatusDemo;

public class Test {
    public static void main(String[] args) {
        Dog a = new Dog();
        Animal b = new Cat();

        a.eat();
        System.out.println(a.age);

        b.eat();
        System.out.println(b.age);

    }
}
