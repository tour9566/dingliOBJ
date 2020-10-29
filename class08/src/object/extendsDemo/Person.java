package object.extendsDemo;

public class Person {
    private  String name;//姓名
    private int age;//年龄

    public Person(){
        System.out.println("调用父类的无参构造方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
