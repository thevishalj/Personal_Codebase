package Model_E;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task extends Thread {
    private final int number;
    private final CountDownLatch countDownLatch;
    private final int waitTime;

    public Task(int number, CountDownLatch countDownLatch, int waitTime) {
        this.number = number;
        this.countDownLatch = countDownLatch;
        this.waitTime = waitTime;
    }

    @Override
    public void run() {
        //Thread.sleep(1000);
        System.out.println("Thread no. " + number + " Started");

        try {
            for (int i = 0; i <= number; i++) {
                System.out.println("Task " + number + "." + i + " running");
            }
            TimeUnit.SECONDS.sleep(waitTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Thread no. " + number + " Completed");
        countDownLatch.countDown();
    }
}
public class RunnableTask {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        CountDownLatch countDownLatch = new CountDownLatch(4);

        threadPool.execute(new Task(1, countDownLatch, 7));
        threadPool.execute(new Task(2, countDownLatch, 5));
        threadPool.execute(new Task(3, countDownLatch, 7));
        threadPool.execute(new Task(4, countDownLatch, 5));

        countDownLatch.await();
        threadPool.shutdown();

        System.out.println("All Concepts.Threads Completed");
    }
}
