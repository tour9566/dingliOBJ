package object.task.day1012.first;

public class PingpongPlayer extends Player implements Learning {

    @Override
    void study() {
        System.out.println("学习兵乓球");
    }

    @Override
    public void learnEnglish() {
        System.out.println("乒乓球运动员学习English");
    }
}
