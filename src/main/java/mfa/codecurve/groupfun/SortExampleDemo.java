package mfa.codecurve.groupfun;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class SortExampleDemo {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>(Arrays.asList(
                new Employee(3, "Anita", "Kumar", 28, "Sales", 70000.0),
                new Employee(1, "Raj", "Verma", 35, "Tech", 120000.0),
                new Employee(2, "Asha", "Nair", 55, "HR", 90000.0),
                new Employee(5, "Meera", "Singh", 35, "Tech", 8000.0),
                new Employee(4, "Vikram", "Gupta", 31, "HR", 80000.0),
                new Employee(4, "Akram", "khan", 31, "HR", 7000.0),
                new Employee(4, "Asad", "shaikh", 31, "HR", 9000.0)
        ));


        //sort based on department
        List<Employee> empSortedByDept = employeeList.stream().sorted(comparing(emp ->
                emp.getDepartment())).collect(Collectors.toList());
       empSortedByDept.stream().forEach(System.out::println);

       //sort based on multiple key, firstname, lastname, age

        System.out.println("----------------------------------------------------------------------------------");
        List<Employee> multiKeySort = employeeList.stream().sorted(comparing(Employee::getAge).
                thenComparing(Employee::getSalary)).collect(Collectors.toList());
        multiKeySort.stream().forEach((System.out::println));

        //Top 3 highest paid employee
        Map<String, List<Employee>> highestPaid = employeeList.stream().collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.collectingAndThen(Collectors.toList(),
                list -> list.stream().sorted(comparing(Employee::getSalary).reversed()).
                        limit(3).collect(Collectors.toList()))));

        highestPaid.forEach((k,v)-> System.out.println(k+"-------------->"+v));

        //FlatMap Example
        System.out.println("FlatMap Example");
        List<List<String>> nestedList = Arrays.asList(Arrays.asList("alam", "aliza",null),
                Arrays.asList("gupta", "sameer"),null);

        List<String> flatMapList = nestedList.stream().filter(Objects::nonNull).flatMap(list -> list.stream().filter(Objects::nonNull).
                map(s -> s.toUpperCase())).collect(Collectors.toList());

        flatMapList.forEach(em-> System.out.println(em));


        //Join names by department (comma-separated)

        Map<String, String> namesSepareted = employeeList.stream().collect
                (Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getFirstName,
                        Collectors.joining(","))));

        namesSepareted.forEach((k,v)-> System.out.println(k+"--------->"+v));


    }
}
