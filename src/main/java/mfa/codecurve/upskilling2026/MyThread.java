package mfa.codecurve.upskilling2026;

public class MyThread extends Thread{


    public MyThread(String threadName){
        super(threadName);
    }

    @Override
    public void run() {
        System.out.println(MyThread.currentThread().getName()+ "are running");
    }

    public static void main(String[] args) throws InterruptedException {
        /*
        ✅ Key Idea to Control Thread Execution Order
           Threads normally run independently, so execution order is not guaranteed.
           To force an order, we use:
        ✅ Thread.join()
           join() makes the current thread wait until the given thread finishes.
         */




        MyThread t1=new MyThread("t1");
        MyThread t2=new MyThread("t2");
        MyThread t3=new MyThread("t3");

        t3.start();
        t3.join();

        t2.start();
        t2.join();

        t1.start();
        t1.join();


    }
}
