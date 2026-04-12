package mfa.codecurve.upskilling2026;

public class TestSingleton {

    public static void main(String[] args) {

        /*
        Step‑by‑step:

      instance is static → shared across all threads

      volatile ensures:One thread’s change is visible to all other threads

      First if (instance == null):Avoids synchronization overhead

      synchronized block:Allows only one thread at a time
      Second null check:Prevents multiple object creation
      Constructor is private:No external creation possible
      ✅ Result: Thread‑safe Singleton
         */

        Student s1 = Student.getInstance();
        s1.setId(1);
        s1.setName("Amit");

        Student s2 = Student.getInstance();

        System.out.println(s1 == s2);   // true
        System.out.println(s2.getName()); // Amit
    }

}
