package mfa.codecurve.upskilling2026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class SumOfEmployeeSalaryDemo {
    public static void main(String[] args) {
        System.out.println("list of employees(id,name,age),\n" +
                "  Calculate sum of those employee salary whose age > 25, using java8 stream\n" +
                "  null checks by using optional class");




        List<Employee> employees = Arrays.asList(
                new Employee(1, "Amit", 30, 50000),
                new Employee(2, "Neha", 24, 40000),
                new Employee(3, "Raj", 28, null),
                new Employee(4, "Sara", null, 60000),
                new Employee(5, "John", 35, 70000)
        );


        Integer sum = employees.stream().filter((emp) -> Optional.ofNullable(emp.getAge()).orElse(0) > 25)
                .map((empl) -> Optional.ofNullable(empl.getSalary()).orElse(0)).reduce(0, Integer::sum);


        System.out.println(sum);

    }
}
