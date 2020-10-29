package object.multipleThread.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyThreadCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("子线程开始运行");
        return "子线程运行完成";
    }

    public static void main(String[] args) {
        FutureTask futureTask = new FutureTask(new MyThreadCallable());
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            System.out.println("子线程返回结果："+futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("主线程");
    }
}
