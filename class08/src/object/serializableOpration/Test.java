package object.serializableOpration;

import java.io.*;

public class Test {
    public static void main(String[] args) {
        Person tom = new Person("tom", 13);
        String path = "data.txt";
        writeObject(tom, path);
        Person person = (Person) readObject(path);
        System.out.println(person.toString());
    }

    //反序列化
    private static Object readObject(String path) {
        Object object = null;
        ObjectInputStream objectInputStream =null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(path));
            object = objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return object;
    }
    //序列化  将对象
    private static void writeObject(Object obj, String path) {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
