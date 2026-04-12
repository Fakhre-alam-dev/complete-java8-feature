package mfa.codecurve.upskilling2026;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestConcurrentModification {

    /*
     Why ConcurrentModificationException Occur?

     for-each loop internally uses an Iterator
     When you modify the list directly using list.remove()
     The iterator detects modification and fails fast


     “ConcurrentModificationException occurs when a collection is structurally
      modified while iterating using a fail‑fast iterator.
      It is avoided by using Iterator.remove() or removeIf().”

      iterator.remove() works because it modifies the collection through the same iterator that is performing the traversal,
       keeping the iterator’s internal state consistent.
       list.remove() modifies the collection outside the iterator,
       so the iterator detects this mismatch and throws ConcurrentModificationException.
     */

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(3);

        for(Integer i:list){
            if(i%2!=0){
                list.remove(i);
            }
            System.out.println(i);
        }

    }
}
