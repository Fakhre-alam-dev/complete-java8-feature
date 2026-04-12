package mfa.codecurve.groupfun;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortDemo {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(4,11,16,2,5,9,11,9);

        List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
        Stream<Integer> sorted = list.stream().sorted(Comparator.reverseOrder());

        System.out.println("Find all number start with 1");
        List<Integer> collect1 = list.stream().map((num) -> String.valueOf(num)).filter((val) -> val.startsWith("1")).map((n) -> Integer.valueOf(n)).collect(Collectors.toList());
        System.out.println(collect1);



    }
}
