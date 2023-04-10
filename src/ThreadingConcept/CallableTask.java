package ThreadingConcept;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

class Task2 implements Callable<String> {    //it will return some string value back
    private final String name;

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
        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        Future<String> WFuture = threadPool.submit(new Task2("Vishal"));

        String value = WFuture.get();

        threadPool.shutdown();

        System.out.println("\n" + value + "\nThread completed");
    }
}
