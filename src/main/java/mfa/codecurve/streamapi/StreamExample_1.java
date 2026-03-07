package mfa.codecurve.streamapi;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamExample_1 {
    public static void main(String[] args) {

        List<Integer> numbers= Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,3,5,7);
        List<String> names= Arrays.asList("Zuveria","Alice", "Bob", "Charlie", "David", "Eve");
        //iterate over the list using streams
        names.stream().forEach((name)-> System.out.println(name));

        System.out.println("------------------------------------------------------------------");

        //filter names that start with 'C' and print them
        names.stream().filter((name)->name.startsWith("C")).forEach((name)-> System.out.println(name));

        System.out.println("------------------------------------------------------------------");
        //transform names to uppercase and print them
        names.stream().map((name)->name.toUpperCase()).forEach(System.out::println);

        System.out.println("------------------------------------------------------------------");
        //sort elements with natural sorting order and print them
        names.stream().sorted().forEach((name)->System.out.println(name));

        System.out.println("------------------------------------------------------------------");
        //collect the stream elements into a collection and print the collection
        names.stream().filter((name)->name.length()>3).map((name)->name.toUpperCase()).collect(Collectors.toList()).forEach((name)->System.out.println(name));

        System.out.println("------------------------------------------------------------------");
        //reduce the number of stream elements to a single element and print it
        int sum=  numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum of numbers: "+sum);

        System.out.println("------------------------------------------------------------------");
        //stream are immutable - original list remains unchanged
        List<String> modifyNames=names.stream().filter((name)->!name.equals("Bob")).collect(Collectors.toList());
        System.out.println("Original names list:");
        names.forEach((name)->System.out.println(name));
        System.out.println("Modified names list:");
        modifyNames.forEach((name)->System.out.println(name));
        System.out.println("------------------------------------------------------------------");
        //sum of even numbers using streams
//        int sum1 = numbers.stream().filter((num) -> num % 2 == 0).mapToInt((num) -> Integer.valueOf(num)).sum();
        Integer sum1=numbers.stream().filter((num)->num%2==0).reduce(0,Integer::sum);
        System.out.println("Sum of even numbers: " + sum1);

        //intermediate operations are lazy - they are not executed until a terminal operation is invoked
        System.out.println("------------------------------------------------------------------");
        /*
        1. filter: intermediate operation: Predicate<T> - takes a single input and returns a boolean
        2. map: intermediate operation : Function<T, R> - takes a single input and returns a single output
        3. flatMap: intermediate operation : Function<T, Stream<R>> - takes a single input and returns a stream of outputs
        4. sorted: intermediate operation : Comparator<T> - takes two inputs and returns an integer
        5. distinct: intermediate operation : distinct elements based on equals() and hashCode()
        6. limit: intermediate operation : takes a long value and returns a stream with limited number of elements
        7. skip: intermediate operation : takes a long value and returns a stream with skipped

         */
        System.out.println("FlatMap example:");
        List<List<String>> nameList = Arrays.asList(Arrays.asList("Anna", "Fahim"), Arrays.asList("Gulzar", "Rahim"), Arrays.asList("Sami", "Tariq"));
        nameList.stream().flatMap((list)->list.stream().map((s)->s.toUpperCase())).forEach(System.out::println);

        System.out.println("Distinct example: remove duplicate number based on equals() and hashCode()");
        numbers.stream().distinct().forEach(System.out::println);

        System.out.println("Limit example: limit to first 5 numbers");
        numbers.stream().limit(5).forEach(System.out::println);

        System.out.println("Skip example: skip first 5 numbers");
        numbers.stream().skip(5).forEach(System.out::println);

        System.out.println("------------------------------------------------------------------------------------");
        //terminal operations:
        /*
        1. forEach: terminal operation : Consumer<T> - takes a single input and returns void
        2. collect: terminal operation : Collector<T, A, R> - mutable reduction operation that accumulates input elements into a mutable result container
        3. reduce: terminal operation : BinaryOperator<T> - takes two inputs and returns a single output
        4. count: terminal operation : returns the count of elements in the stream
        5. anyMatch: terminal operation : Predicate<T> - returns true if any element matches the predicate
        6. allMatch: terminal operation : Predicate<T> - returns true if all elements match the predicate
        7. noneMatch: terminal operation : Predicate<T> - returns true if no elements match the predicate
        8. findFirst: terminal operation : returns the first element of the stream
        9. findAny: terminal operation : returns any element of the stream
         */

        System.out.println("Count example: count names with length greater than 3");
        long count= names.stream().filter((name)->name.length()>3).count();
        System.out.println("Count: "+count);

        System.out.println("AnyMatch example: any name starts with 'A'?");
        boolean anyMatch= names.stream().anyMatch((name)->name.startsWith("A"));
        System.out.println("AnyMatch: "+anyMatch);

        System.out.println("AllMatch example: all names length greater than 2?");
        boolean allMatch= names.stream().allMatch((name)->name.length()>3);
        System.out.println("AllMatch: "+allMatch);

        System.out.println("NoneMatch example: no name starts with 'Z'?");
        boolean noneMatch= names.stream().noneMatch((name)->name.startsWith("Z"));
        System.out.println("NoneMatch: "+noneMatch);

        System.out.println("FindFirst example: first even number in the list");
        Integer firstEven= numbers.stream().filter((num)->num%2==0).findFirst().orElse(null);
        System.out.println("First even number: "+firstEven);

        System.out.println("FindAny example: any odd number in the list");
        Integer anyOdd= numbers.stream().filter((num)->num%2!=0).findAny().orElse(null);
        System.out.println("Any odd number: "+anyOdd);

        //Functional interfaces used in stream operations:
        /*
        1. Predicate<T>: represents a boolean-valued function of one argument
        2. Function<T, R>: represents a function that takes one argument and produces a result
        3. Consumer<T>: represents an operation that takes a single input and returns no result
        4. Supplier<T>: represents a supplier of results
        5. BinaryOperator<T>: represents an operation upon two operands of the same type, producing a result of the same type
         */

        //collectors utilities in Collectors class:
        /*
        1. Collectors.toList(): collects the stream elements into a List
        2. Collectors.toSet(): collects the stream elements into a Set
        3. Collectors.toMap(): collects the stream elements into a Map
        4. Collectors.joining(): concatenates the stream elements into a single String
        5. Collectors.groupingBy(): groups the stream elements based on a classifier function
        6. Collectors.partitioningBy(): partitions the stream elements based on a predicate
         */

        //Lazy evaluation: intermediate operations are not executed until a terminal operation is invoked,
        // that will improve performance by avoiding unnecessary computations.

        System.out.println("------------------------------------------------------------------");
        //This pipeline demonstrates filtering, sorting, mapping, and collecting in one sequence

        names.stream().filter((name)->name.length()>3).sorted((Comparator.reverseOrder())).collect(Collectors.toList()).forEach(System.out::println);

        //interview question examples based on streams:
        /*
        1. Find the second highest number in a list of integers
        2. Find the first non-repeated character in a string
        3. Group a list of strings by their length
        4. Count the frequency of each character in a string
        5. Find the missing number in a list of integers from 1 to N
        6. Q: Write a program to find the duplicate characters in list of string using Stream.
           String input="Ashwini Tiwari";
         */

        System.out.println("---------------Find the second highest number in a list of integers--------------------");
        Integer secondHihest = numbers.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null);
        System.out.println("Second highest number: " + secondHihest);

        System.out.println("---------------Find the first non-repeated character in a string------------------------");
        String input = "swiss";
        Character firstNonRepeatedChar = input.chars().mapToObj((c) -> (char) c).filter((c) -> input.indexOf(c) == input.lastIndexOf(c)).
                findFirst().orElse(null);
        System.out.println("First non-repeated character: " + firstNonRepeatedChar);

        System.out.println("---------------Group a list of strings by their length------------------------");
        List<String> fruitList = Arrays.asList("apple", "banana", "car", "dog", "elephant", "frog", "goat");
        Map<Integer, List<String>> fruitcollect =fruitList.stream().collect(Collectors.groupingBy((fruit) -> fruit.length()));
        fruitcollect.forEach((l,fruit)-> System.out.println("Length: "+l+" Fruits: "+fruit));

        System.out.println("---------------Count a List of string by Length------------------------");
        List<String> cityList = Arrays.asList("London", "Paris", "New York", "Tokyo", "Berlin", "Sydney", "Cairo");
        Map<Integer, Long> citycollect =cityList.stream().collect(Collectors.groupingBy((city) -> city.length(),Collectors.counting()));
        citycollect.forEach((l,city)-> System.out.println("Length: "+l+" Count: "+city));

        System.out.println("---------------Count frequency of each character in a string------------------------");
        String sampleInput = "hello world";
        Map<Character, Long> charFrequency = sampleInput.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        charFrequency.forEach((ch, freq) -> System.out.println("Character: " + ch + " Frequency: " + freq));

        List<String> list = Arrays.asList("1one", "2two", "three", " 4four", "", " nine", null);
        System.out.println("Fetch start with numeric");
        list.stream().filter(Objects::nonNull).map((s)->s.trim()).filter((s)->!s.isEmpty() && Character.isDigit(s.charAt(0)));



    }
}
