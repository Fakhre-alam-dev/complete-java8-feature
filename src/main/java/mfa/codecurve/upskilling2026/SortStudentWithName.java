package mfa.codecurve.upskilling2026;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortStudentWithName {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student(1, "Amit"),
                new Student(2, "Rohit"),
                new Student(3, "Neha"),
                new Student(4, "Kiran")
        );


       // students.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).forEach(System.out::println);

        Collections.sort(students);
        System.out.println(students);

    }
}
