package object.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

public class Test {
    private Class loadClass;

    public static void main(String[] args) {
        //获取加载类
        Class loadClass = getLoadClass();

        //通过反射创建对象
//        newObj(loadClass);

        //反射动态性实例
//        for (int i = 0; i <6 ; i++) {
//            dynamicProTest();
//        }

        //通过反射获取构造方法
//        getConstructor(loadClass);

        //通过反射获取属性
//        getAttr(loadClass);

        //通过反射获取方法
        getMethod(loadClass);




    }

    private static void getConstructor(Class loadClass) {
        //get
        Constructor[] constructors = loadClass.getConstructors();
        for (Constructor con:constructors) {
            System.out.println(con);
        }
        //获取某个构造函数
        try {
            Constructor constructor = loadClass.getConstructor(String.class, int.class);
            Person tom = (Person)constructor.newInstance("tom", 20);
            System.out.println(tom);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }



    //通过反射获取属性
    private static void getAttr(Class loadClass) {
        //getFields获取公有属性及父类的public属性
//        Field[] fieldsPrivate = loadClass.getFields();
//        for (Field field:fieldsPrivate) {
//            System.out.println(field);
//        }

        //getDeclaredFields获取所有包括公有和私有属性（不包含父类的属性）
        Field[] fields = loadClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        Constructor constructor = null;
        try {

            Person person = (Person) loadClass.newInstance();
            System.out.println(person.toString());

            //公有属性
            Field age = loadClass.getField("age");
            age.set(person,20);
            System.out.println(age.get(person));

            //私有属性
            Field name = loadClass.getDeclaredField("name");
            name.setAccessible(true);
            name.set(person, "tom");
            System.out.println(name.get(person));

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


    }

    private static void getMethod(Class loadClass) {
        //getMethos()获取当前类及 父类 所有的public方法
//        Method[] methods = loadClass.getMethods();
//        for (Method method : methods) {
//            System.out.println(method);
//        }
        //getDeclaredMethods()获取当前类的所有公有和私有的方法（不包含父类）
//        Method[] declaredMethods = loadClass.getDeclaredMethods();
//        for (Method method : declaredMethods) {
//            System.out.println(method);
//        }
        //调用某个方法
        try {
            //反射调用set方法
//            Method setName = loadClass.getMethod("setName", String.class);
//            Object o = loadClass.newInstance();
//            String invoke = (String)setName.invoke(o, "Tom");
//            System.out.println(o.toString());
//            System.out.println(invoke);

            //反射调用get方法
            Method getNameMethod = loadClass.getDeclaredMethod("getName");
            getNameMethod.setAccessible(true);
            Method getHelloMethod = loadClass.getMethod("Hello");

            Constructor constructor = loadClass.getConstructor(String.class, int.class);
            Person person = (Person)constructor.newInstance("tom", 20);
            String name =(String) getNameMethod.invoke(person);
            getHelloMethod.invoke(person);
            System.out.println(name);
            System.out.println(person.toString());

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void dynamicProTest() {
        Random ran = new Random();
        int num = ran.nextInt(3);
        String classPath = null;
        switch (num) {
            case 0: {
                classPath = "java.lang.Object";
                break;
            }
            case 1: {
                classPath = "java.util.Date";
                break;
            }
            case 2: {
                classPath = "class08.object.stream.reflection.Person";
                break;
            }
        }
        try {
            Class aClass = Class.forName(classPath);
            Object obj = aClass.newInstance();
            System.out.println(obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    private static void newObj(Class loadClass) {
        Person person = null;
        try {
            //newInstance调用空参构造器
            Object o = loadClass.newInstance();
            person = (Person) o;
            System.out.println(person.toString());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    private static Class getLoadClass() {
        //第一种方式 类.class
        Class clazz1 = Person.class;
        System.out.println(clazz1);

        //第二种方式 对象.getClass()
        Person person = new Person();
        Class clazz2 = person.getClass();
        System.out.println(clazz2);

        System.out.println(clazz1 == clazz2);

        //第三种方式 Class.forName("包名.类名"),推荐使用第三种。体现反射的动态性。
        Class clazz3 = null;
        try {
            clazz3 = Class.forName("class08.object.stream.reflection.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(clazz3);
        System.out.println(clazz1 == clazz3);
        return clazz1;
    }


}
