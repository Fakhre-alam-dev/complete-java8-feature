package mfa.codecurve.upskilling2026;

public class TestThread {
    public static void main(String[] args) {
        Runnable r=()->{
            System.out.println(Thread.currentThread()+ " Thread are running");
        };
        Thread myThread=new Thread(r);
        myThread.start();
    }
}
