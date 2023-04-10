package ModelE_POC;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ModelE_Service {
    public static void main(String[] args) throws InterruptedException {
        int models = 5;
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        CountDownLatch latch = new CountDownLatch(models);

        try {
            for(int i=1; i<=models; i++){
                threadPool.submit(new ModelE_Task(i, latch, 5));
            }
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }

        latch.await();
        threadPool.shutdown();

        System.out.println("All threads ran successfully");
    }
}
