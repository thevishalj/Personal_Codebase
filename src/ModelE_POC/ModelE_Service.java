package ModelE_POC;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ModelE_Service {
    public static void main(String[] args) throws InterruptedException {
        int threadCount = 10;
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        CountDownLatch latch = new CountDownLatch(threadCount);

        try {
            for(int i=1; i<=threadCount; i++){
                threadPool.submit(new ModelE_Task(i, latch, 2));
            }
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }

        latch.await();
        threadPool.shutdown();

        System.out.println("All threads ran successfully");
    }
}
