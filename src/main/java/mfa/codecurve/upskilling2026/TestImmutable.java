package mfa.codecurve.upskilling2026;

public class TestImmutable {
    public static void main(String[] args) {

        /*
        In Java, an immutable class is a class whose objects cannot be modified
        after they are created. Once an immutable object is constructed,
        its state (data) remains constant for its entire lifetime.
        Examples you already know:
        String, Integer, BigDecimal, LocalDate → all are immutable.


        Immutable classes are important because they are:
       ✅ Thread-safe (no synchronization needed)
       ✅ Easy to design and debug
       ✅ Safe to share between methods and threads
       ✅ Secure (prevents accidental or malicious changes)
       ✅ Used as keys in HashMap / HashSet safely

       If your class contains mutable objects (like Date, ArrayList, etc.), you must:

       Create a copy inside the constructor
       Return a copy in getters

       This is the most important and commonly asked interview point.


       public final class Person {

       private final Date birthDate;

       public Person(Date birthDate) {
        // Create a copy
        this.birthDate = new Date(birthDate.getTime());
      }

       public Date getBirthDate() {
        // Return a copy
        return new Date(birthDate.getTime());
      }
     }


         */

        Person person=new Person(1, "alam");
        System.out.println(person);


    }
}
