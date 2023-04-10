package Model_E;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task extends Thread {
    private int number;

    public Task(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        //Thread.sleep(1000);
        System.out.println("Thread no. " + number + " Started");

        for (int i = 0; i <= number; i++) {
            System.out.println("Task " + number + "." + i + " running");
        }

        System.out.println("Thread no. " + number + " Completed");
    }
}
public class RunnableTask {
    public static void main(String[] args){
        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        threadPool.execute(new Task(1));
        threadPool.execute(new Task(2));
        threadPool.execute(new Task(3));
        threadPool.execute(new Task(4));

        threadPool.shutdown();
    }
}
