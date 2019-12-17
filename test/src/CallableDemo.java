import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread implements Callable<Integer>{


    @Override
    public Integer call() throws Exception {
        System.out.println("********come in call");
        return 1024;
    }
}


public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //Thread(Callable target,String name)
        FutureTask futureTask = new FutureTask(new MyThread());
         new Thread(futureTask,"A").start();
        System.out.println(futureTask.get());

    }
}
