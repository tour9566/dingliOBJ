package object.task.day1012.first;

public class PingpongCoach extends Coach implements Learning {
    @Override
    void teach() {
        System.out.println("乒乓球教练教乒乓球");
    }

    @Override
    public void learnEnglish() {
        System.out.println("乒乓球教练学英语");
    }
}
