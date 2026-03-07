package mfa.codecurve.streamapi;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamExample_3 {
    public static void main(String[] args) {
        System.out.println("----------------------------------- FlatMap Example ----------------------------------");
        //Flattening a Stream of Arrays
        String[] arrayOfWords = { "Hello World", "CodeCurve", "Stream API" };
        Arrays.stream(arrayOfWords);


    }
}
