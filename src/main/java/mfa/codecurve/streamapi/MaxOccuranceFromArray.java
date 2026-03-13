package mfa.codecurve.streamapi;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaxOccuranceFromArray {

    public static void main(String[] args) {
        //Write a java program to find String which have maximum occurence in below arr.
        String [] arr={"Alam","ab11","Alam","ab11","Alam","ab11","bc12","bc12","Alam","d14"};
        Map<String, Long> maxOccur = Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(),
                Collectors.counting()));

        Map.Entry<String, Long> stringLongEntry = maxOccur.entrySet().stream().min(Map.Entry.
                comparingByValue()).orElse(null);


        System.out.println("Frequency Map: " + maxOccur);
        System.out.println("Max Occurring: " + stringLongEntry.getKey() + " = " + stringLongEntry.getValue());



    }
}
