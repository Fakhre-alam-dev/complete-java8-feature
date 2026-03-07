package mfa.codecurve.streamapi;



import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample_2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,5,1,6,7,8,9,10,67,55);
        List<String> names= Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Frank");

        System.out.println("------------find out all the numbers starting with 1 using Stream functions------------");
        numbers.stream().filter((num)->String.valueOf(num).startsWith("1"))
                .forEach(System.out::println);

        System.out.println("--------find duplicate elements in a given integers list in java using Stream functions-------");
        numbers.stream().filter((num)->numbers.indexOf(num)!=numbers.lastIndexOf(num)).distinct()
                .forEach(System.out::println);

        System.out.println("--------find the total number of elements present in the list using Stream-------");
        Long totalElement=numbers.stream().count();
        System.out.println("Total number of elements: "+totalElement);

        System.out.println("--------find the maximum number present in the list using Stream-------");
        numbers.stream().sorted(Comparator.reverseOrder()).findFirst().ifPresent(System.out::println);

        System.out.println("--------find the first non-repeated character in it using Stream functions-------");
        String input="swiss";
        input.chars().mapToObj((c)->(char)c).filter((s)->input.indexOf(s)==input.lastIndexOf(s)).findFirst()
                .ifPresent(System.out::println);


        System.out.println("--------find the first repeated character in it using Stream functions-------");
        String reinput ="swiss";
        reinput.chars().mapToObj((c)->(char)c).filter((s)-> reinput.indexOf(s)!= reinput.lastIndexOf(s)).findFirst()
                .ifPresent(System.out::println);


        System.out.println("--------Java 8 program to concatenate two Streams -------");
        List<Integer> numbers2 = Arrays.asList(11,22,33,44,55);
        System.out.println("Concatenated List: ");
        Stream<Integer> stream1 = numbers2.stream();
        Stream<Integer> stream2 = numbers.stream();
        Stream.concat(numbers2.stream(),numbers.stream()).forEach(System.out::println);













    }
}
