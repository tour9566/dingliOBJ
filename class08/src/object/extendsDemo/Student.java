package object.extendsDemo;

public class Student extends Person {
    private String id;

    public Student(){
        System.out.println("调用子类Student构造方法");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
