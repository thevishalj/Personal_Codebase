package Model_E;

import java.util.concurrent.*;

class Task2 implements Callable<String> {    //it will return some string value back
    private String name;

    public Task2 (String name){
        this.name = name;
    }
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "Hello " + name;
    }
}
public class CallableTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadpool = Executors.newFixedThreadPool(2);

        Future<String> WFuture = threadpool.submit(new Task2("Vishal"));

        String value = WFuture.get();

        System.out.println("\n" + value + "\nThread completed");
    }
}
