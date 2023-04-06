class A implements Runnable {
    public void run (){
        for(int i=0; i<=100; i++){
            System.out.println("Hi");
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class B implements Runnable {
    public void run (){
        for(int i=0; i<=100; i++){
            System.out.println("Hello");
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class Threads {
    public static void main(String[] args){
        A obj1 = new A();
        B obj2 = new B();

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        t2.start();
    }
}