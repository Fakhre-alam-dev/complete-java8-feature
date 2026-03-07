package mfa.codecurve.groupfun;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WrapperClassDemo {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3, 1, 7, 9);


       //Sum a list using method references (Integer / Double)
        Integer total = nums.stream().reduce(0, Integer::sum);
        System.out.println("Integer sum method total:"+total);

        //Sort with Integer.compare and avoid overflow
        nums.sort(Integer::compare);
        System.out.println("after sort:"+nums);

        //get the element which start with numeric
        List<String> strList=Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");
        List<String> result = strList.stream()
                .filter(s -> Character.isDigit(s.charAt(0)))
                .collect(Collectors.toList());

        System.out.println("digit "  +result); // [2wo, 3hree, 5ive]


        //use regx
        //get the element which start with numeric
        List<String> resultRegex = strList.stream()
                .filter(s ->s.matches("^[0-9].*"))
                .collect(Collectors.toList());

        System.out.println("digit regx "  +resultRegex); // [2wo, 3hree, 5ive]

        //get  abc and bca
        List<String> bcList = Arrays.asList("abc", "bca", "123", "456");
        List<String> bca = bcList.stream().filter((s) -> !Character.isDigit(s.charAt(0))).
                collect(Collectors.toList());
        System.out.println(bca);


    }
}
