package mfa.codecurve.streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindHighest {

    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(4, 11, 9, 1, 8);


        Integer i = list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(i);



        //{"apple", "banana", "apple", "orange", "banana}

        List<String> wordList=Arrays.asList("apple", "banana", "apple", "orange", "banana");

        Map<String, Long> collect = wordList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        collect.forEach((k,v)-> System.out.println(k+"---->"+v));

        /*
        1. Remove Duplicate from a List
        2. Find the second highest number (no duplicates)
        3. Count frequency of elements
        4. First non-repeating character in a string
        5. Reverse each word in a sentence (keep word order)
        6. Highest salary per department
        7. Join names by department (comma-separated)
        8. Partition numbers into even/odd
        9. Flatten a list of lists
        10.Find duplicate elements in a list
         */

        //Reverse Each word in String
        System.out.println("-------------------------------------------------------------------");
        List<StringBuilder> reverseWord = wordList.stream().map(s -> new StringBuilder(s).reverse()).
                collect(Collectors.toList());
        reverseWord.forEach((r)-> System.out.println(r));

    }
}
