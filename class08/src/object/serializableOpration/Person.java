package object.serializableOpration;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID=1232312L;
    //姓名
    private String name;
    //年龄
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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
