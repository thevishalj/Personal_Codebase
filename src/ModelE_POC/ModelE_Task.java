package ModelE_POC;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class ModelE_Task implements Callable {
    private final int number;
    private final CountDownLatch countDownLatch;
    private final int waitTime;

    public ModelE_Task(int number, CountDownLatch countDownLatch, int waitTime){
        this.number = number;
        this.countDownLatch = countDownLatch;
        this.waitTime = waitTime;
    }

    @Override
    public Object call() throws Exception {
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
        return null;
    }
}
