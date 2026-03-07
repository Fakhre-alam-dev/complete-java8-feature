package mfa.codecurve.groupfun;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8ExampleDemo {
    public static void main(String[] args) {
        List<Integer> numList= Arrays.asList(2,3,5,1,6,16,1,3,16);
        String input="swiss";
        List<String> strList=Arrays.asList("akber","anwar","ala");

        //find Integer number that starting with 1
        List<String> numStartWith = numList.stream().map((num) ->
                String.valueOf(num)).filter((val) -> val.startsWith("1")).collect(Collectors.toList());

        System.out.println("num start with 1: "+numStartWith);



        //find Duplicate Integer number
        List<Integer> dupNumber = numList.stream().filter((num)
                ->numList.indexOf(num)!=numList.lastIndexOf(num)).distinct().collect(Collectors.toList());

        System.out.println("Duplicate number: "+dupNumber);


        //find first element of list
        Integer firstElement = numList.stream().findFirst().get();
        System.out.println("First Element: "+ firstElement);

        //find total number of element in list
        Long totalElement = numList.stream().count();
        System.out.println("First Element: "+ totalElement);


        //find max number of element in list
        Integer maxValue = numList.stream().sorted(Comparator.reverseOrder()).findFirst().get();
        System.out.println("First Element: "+ maxValue);

        //find max number of element using max fun in list
        Integer maxValuemax = numList.stream().max(Comparator.naturalOrder()).get();
        System.out.println("First Element: "+ maxValuemax);

        //first non repeated character in string
        Character nonRepeated = input.chars().mapToObj(c -> (char) c).filter((ch)
                ->input.indexOf(ch)==input.lastIndexOf(ch)).findFirst().get();
        System.out.println("non repeated char:"+nonRepeated);

        //first  repeated character in string
        Character repeated = input.chars().mapToObj(c -> (char) c).filter((ch)
                ->input.indexOf(ch)!=input.lastIndexOf(ch)).findFirst().get();
        System.out.println("repeated char:"+ repeated);

        //create Thread using Lamda
        Runnable r=()->{
            System.out.println("run");
        };
        r.run();

        //List<String> items = Arrays.asList("apple", "banana", "cherry"); [APPLE,BANANA,CHERRY]
        List<String> items = Arrays.asList("apple", "banana", "cherry");
        List<String> itemList = items.stream().map((fruit) -> fruit.toUpperCase()).collect(Collectors.toList());
        System.out.println(itemList);

        //Write a program to find the duplicate characters in list of string using Stream
        String dupStr="Ashwini Tiwari";
        List<Character> dupChar = dupStr.chars().mapToObj((ch -> (char) ch)).filter((c)
                -> dupStr.indexOf(c) != dupStr.lastIndexOf(c)).distinct().collect(Collectors.toList());
        System.out.println("dup char:"+dupChar);

        //Find square of all distinct number
        List<Double> squareOfDouble = numList.stream().distinct().map((num)
                -> Math.pow(num, num)).collect(Collectors.toList());

        System.out.println("square:"+squareOfDouble);


        //Find the Word/number got repeated by using Stream api-------------->done
        //   input:2,3,34,,5,5,4,3,3,3
        //   output:2-1,3-4,34-1,5-2,4-1

        Map<Integer, Long> repeatedNumber = numList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        repeatedNumber.forEach((k,v)-> System.out.println("repeated num " + k+"------>"+v));

        //Given a list of Strings. Convert String to uppercase and Join them with coma (,) using Stream api  (completed)
        List<String> countries=Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        String result = countries.stream().map((country)
                -> country.toUpperCase()).collect(Collectors.joining(","));
        System.out.print("convert string with joining: "+result);

        System.out.println("----------------");

        //join two stream
        List<Integer> list1 = Arrays.asList(89, 7, 9);
        List<Integer> list2 = Arrays.asList(8, 3, 1);

        Stream<Integer> stream = list2.stream();
        Stream<Integer> stream1 = list1.stream();

        Stream<Integer> concatStr = Stream.concat(stream1, stream);
        concatStr.forEach((System.out::println));


        //Given a List of Integers find total count, min, max, sum, and the average for numbers by using Stream api
        //output: count=10, sum=129, min=2, average=12.900000, max=29
        List<Integer> countList = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        long countNum = countList.stream().count();
        System.out.println("count num:"+countNum);

        Integer sumval = countList.stream().reduce(0, Integer::sum);
        System.out.println("sum val: "+sumval);

        Integer maxVal = countList.stream().max(Comparator.naturalOrder()).get();
        System.out.println("max val: "+ maxVal);

        Integer minVal = countList.stream().min(Comparator.naturalOrder()).get();
        System.out.println("min val: "+minVal);

        double asDouble = countList.stream().mapToInt(Integer::intValue).average().getAsDouble();
        System.out.println(asDouble);

        //If your list is List<Object> (mixed types)
        List<Object> data = Arrays.asList("abc123", "bca99", 123, "xyz", "Abc", "bca_test", null, "abc", 456);
        List<String> dataResult = data.stream().filter(Objects::nonNull).filter(obj -> obj instanceof String).map(
                o -> (String) o).filter(st -> st.startsWith("abc") || st.startsWith("bca"))
                .collect(Collectors.toList());

        System.out.println(dataResult);


    }
}
