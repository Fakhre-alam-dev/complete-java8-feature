package mfa.codecurve.groupfun;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsMethodDemo {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>(Arrays.asList(
                new Employee(3, "Anita", "Kumar", 28, "Sales", 70000.0),
                new Employee(1, "Raj", "Verma", 35, "Tech", 120000.0),
                new Employee(2, "Asha", "Nair", 55, "HR", 90000.0),
                new Employee(5, "Meera", "Singh", 35, "Tech", 8000.0),
                new Employee(0, "Vikram", "Gupta", 31, "HR", 80000.0),
                new Employee(6, "Vikram", "Gupta", 31, "HR", 80000.0),
                new Employee(7, "Vikram", "Gupta", 31, "HR", 80000.0)
        ));

        //Gather stream items into a List (like a basket).
        System.out.println("Gather stream items into a List (like a basket");
        employeeList.stream().map((emp)->emp.getFirstName()).collect(Collectors.toList()).forEach((System.out::println));


        //Gather stream items into a Set (like a basket).
        System.out.println("Gather stream items into a Set (like a basket");
        employeeList.stream().map((emp)->emp.getFirstName()).
                collect(Collectors.toSet()).forEach((System.out::println));

          //toCollection(Supplier<C>)
         // Choose the exact collection type (e.g., LinkedList, TreeSet).
        System.out.println("What it does: Choose the exact collection type (e.g., LinkedList, TreeSet).");
        employeeList.stream().
                collect(Collectors.toCollection(LinkedHashSet::new)).forEach((System.out::println));

        //toMap(keyMapper, valueMapper)
        //What it does: Build a Map with keys and values you choose.
        System.out.println("What it does: Build a Map with keys and values you choose.");
        employeeList.stream().
                collect(Collectors.toMap((em)->em.getId(),
                        (emp)->emp.getFirstName())).forEach((k,v)-> System.out.println(k+"---->"+v));

        //toConcurrentMap(...)
        //What it does: Like toMap but tuned for parallel streams (ConcurrentHashMap).
        System.out.println("Like toMap but tuned for parallel streams (ConcurrentHashMap)");
        employeeList.stream().collect(Collectors.toConcurrentMap(e->e.getFirstName(),
                e->e.getSalary(),Double::max)).forEach((k,v)-> System.out.println(k+"------->"+v));



        //groupingBy(classifier)
        //What it does: Group items by a key → Map<key, List<items>>.

        Map<String, List<Employee>> employeeByDept = employeeList.stream().collect(Collectors.groupingBy((emp)
                -> emp.getDepartment()));

        employeeByDept.forEach((k,v)-> System.out.println(k+"------------->"+v));

        //in Each Dept how many Employee count 
        Map<String, Long> countEmpInEachDept = employeeList.stream().collect(Collectors.groupingBy((emp)
                -> emp.getDepartment(), Collectors.counting()));

        countEmpInEachDept.forEach((k,v)-> System.out.println(k+"------>"+v));

        //average age employee in Each dept
        Map<String, Double> averageAgeByEachDept = employeeList.stream().collect(Collectors.groupingBy((emp)
                -> emp.getDepartment(), Collectors.averagingInt((em) -> em.getAge())));

        averageAgeByEachDept.forEach((k, v)-> System.out.println(k+"------>"+v));


        //divide in group based on age>30
        //partitioningBy(predicate)
        //What it does: Split into exactly two groups: true and false.
        Map<Boolean, Long> partitionByAge = employeeList.stream().collect(Collectors.partitioningBy(emp ->
                emp.getAge() > 30, Collectors.counting()));
        partitionByAge.forEach((k,v)-> System.out.println(k+"---------->"+v));




    }
}
