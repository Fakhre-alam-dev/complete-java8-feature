package mfa.codecurve.upskilling2026;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8CodingExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 3, 5, 7);
        List<String> names = Arrays.asList("Zuveria", "Alice", "Bob", "Charlie", "David", "Eve","Bob");
        String input = "swiss";


        System.out.println("Q3)Print duplicate elements in a given integers list in java using Stream functions? list [1,2,3,3,2,0]");

        Set<Integer> seen = new HashSet<>();

        Set<Integer> duplicates = numbers.stream()
                .filter(e -> !seen.add(e))
                .collect(Collectors.toSet());

        System.out.println(duplicates);



        System.out.println("Q2) Given a list of integers, find out all the numbers starting with 1 using Stream functions? list=[1,200,11,100]\n" +
                " ");

        numbers.stream().map((s)->String.valueOf(s)).filter(n->n.startsWith("1")).
                map((val)->Integer.valueOf(val)).collect(Collectors.toList()).forEach(System.out::println);


        System.out.println("Q4) Given the list of integers, find the first element of the list using Stream functions?");
        Integer first = numbers.stream().findFirst().get();
        System.out.println(first);


        System.out.println("Q5) Given a list of integers, find the total number of elements present in the list using Stream functions?");
        Long count = numbers.stream().count();
        System.out.println(count);


        System.out.println("Q6) Given a list of integers, find the maximum value element present in it using Stream functions? ");
        Integer max = numbers.stream().max(Integer::compareTo).orElse(null);
        System.out.println(max);


        System.out.println("Q7) Given a String, find the first non-repeated character in it using Stream functions? [A,A,B,C,D,D,E]");
        input.chars().mapToObj(c -> (char) c).filter((ch) -> input.indexOf(ch) == input.lastIndexOf(ch)).distinct()
                .collect(Collectors.toList()).forEach(System.out::println);


        System.out.println("Q8) Given a String, find the first repeated character in it using Stream functions?");
        input.chars().mapToObj(c -> (char) c).filter((ch) -> input.indexOf(ch) != input.lastIndexOf(ch)).distinct()
                .collect(Collectors.toList()).forEach(System.out::println);


        System.out.println("Q9) Given a list of integers, sort all the values present in it using Stream functions?");
        numbers.stream().sorted().collect(Collectors.toList()).forEach(System.out::println);


        System.out.println("Q10) Given a list of integers, sort all the values present in it in descending order using Stream functions?");
        numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).forEach(System.out::println);


        System.out.println("Q12 ) Write a Java 8 program to find the number of Strings in a list whose length is greater than 5?");
        names.stream().filter((s) -> s.length() > 5).collect(Collectors.toList()).forEach(System.out::println);


        System.out.println("15) Write a Java Lambda Expression to Create Thread");

        Runnable r = () -> {
            System.out.println("thread started");
        };

        Thread myThread = new Thread(r);
        myThread.start();

        System.out.println("19)Given a List of Integers find total count, min, max, sum, and the average for numbers by using Stream api");
        Integer sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        System.out.println("18)Given a list of Integer find square of all distinct numbers By using stream api\n" +
                " \n" +
                "  list=[9, 10, 3, 4, 7, 3, 4]");

        numbers.stream().distinct().map((num) -> Math.pow(num, 2)).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("17)Given a list of Strings. Convert String to uppercase and Join them with coma (,) using Stream api\n" +
                " \n" +
                "List=[\"USA\", \"Japan\", \"France\", \"Germany\", \"Italy\", \"U.K.\",\"Canada\"]");

        String result = names.stream().map(s -> s.toUpperCase()).collect(Collectors.joining(","));
        System.out.println(result);

        System.out.println("16) How Lambda Expression and Functional Interfaces are Related?");
        /*
        A functional interface is an interface that has:
       Exactly one abstract method
       It may have default and static methods
       Annotated with @FunctionalInterface (optional but recommended)


        A lambda expression is a short, anonymous implementation of a functional interface.
       ✅ It:
          Eliminates boilerplate code
          Provides implementation of the functional interface’s single abstract method
          Is mainly used for functional-style programming
         */

        System.out.println("Q14)Find the Word/number got repeated by using Stream api\n" +
                " \n" +
                "   input:2,3,34,,5,5,4,3,3,3\n" +
                " \n" +
                "   output:2-1,3-4,34-1,5-2,4-1");

        Map<Integer, Long> repeated = numbers.stream().collect(Collectors.groupingBy(Function.identity(),
                Collectors.counting()));
        repeated.forEach((k,v)-> System.out.println(k+"---->"+v));

        System.out.println("-----------word---------------");

        Map<String, Long> wordRepeated = names.stream().collect(Collectors.groupingBy(Function.identity(),
                Collectors.counting()));
        wordRepeated.forEach((k,v)-> System.out.println(k+"---->"+v));


        System.out.println("Q13) Explain StringJoiner Class in Java 8? How can we achieve joining multiple Strings\n" +
                " \n" +
                "using StringJoiner Class?");


        StringJoiner joiner = new StringJoiner(", ");

        joiner.add("Java");
        joiner.add("Python");
        joiner.add("C++");

        System.out.println(joiner.toString());

        /*
        ✅ Why was StringJoiner introduced?
           Before Java 8, developers typically used:

           StringBuilder
           Manual string concatenation in loops

           These approaches were:

           Verbose
           Error-prone (extra delimiter handling)
           Less readable

           StringJoiner solves these problems elegantly.


           ✅ Key Features of StringJoiner

              Joins strings using a delimiter
              Supports prefix and suffix
              Avoids trailing delimiters
              Works smoothly with Streams
              Immutable-like behavior for clean APIs
         */







    }
}