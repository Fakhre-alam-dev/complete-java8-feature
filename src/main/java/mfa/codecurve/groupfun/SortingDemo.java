package mfa.codecurve.groupfun;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class SortingDemo {

    /*
    When to use which (cheat sheet)

Just want a list/set? → toList(), toSet()
Want a specific collection/map type? → toCollection(...), toMap(..., ..., ..., supplier)
Build a map from items? → toMap(...), toConcurrentMap(...)
Group by a property? → groupingBy(...)
Split into true/false buckets? → partitioningBy(...)
Count / sum / average / stats? → counting(), summing*, averaging*, summarizing*
Find min/max? → minBy(...), maxBy(...)
Make a string? → joining(...)
Transform while collecting? → mapping(...), collectingAndThen(...)
Need a custom fold? → reducing(...)


Common pitfalls (and fixes)

Duplicate keys in toMap → Use the 3-arg or 4-arg version with a merge function.
Need order preserved → Use LinkedHashMap::new in map supplier.
Parallel grouping → Prefer groupingByConcurrent / toConcurrentMap for speed.
Mutable results → If you want read-only, finish with collectingAndThen(..., Collections::unmodifiableList) (or ...Set, etc.).
     */



    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>(Arrays.asList(
                new Employee(3, "Anita", "Kumar", 28, "Sales", 70000.0),
                new Employee(1, "Raj", "Verma", 35, "Tech", 120000.0),
                new Employee(2, "Asha", "Nair", 55, "HR", 90000.0),
                new Employee(5, "Meera", "Singh", 35, "Tech", 8000.0),
                new Employee(4, "Vikram", "Gupta", 31, "HR", 80000.0)
        ));
        //Group employees by department and compute average salary; return map sorted by department name
        Map<String, Double> avgSalaryByDept = employeeList.stream().collect(Collectors.groupingBy((emp) -> emp.getDepartment(), TreeMap::new,
                Collectors.averagingDouble((sal) -> sal.getSalary())));
        avgSalaryByDept.forEach((k,v)-> System.out.println("Avg Salary By Department: "+k+"---->"+v));


       //Find the top 3 highest paid employees per department
        Map<String, List<Employee>> highestPaidEmp =
                employeeList.stream().collect(Collectors.
                groupingBy((emp) -> emp.getDepartment(), Collectors.collectingAndThen(Collectors.toList(),
                        list -> list.stream().
                                sorted(Comparator.comparingDouble((Employee e) -> e.getSalary()).reversed()).
                                limit(3).collect(Collectors.toList()))));

        highestPaidEmp.forEach((k,v)-> System.out.println("Department:"+k+"----------->"+v));


    //Stable distinct by a key (e.g., distinct by email), preserving order

        List<Employee> uniqueByName = employeeList.stream()
                .filter(distinctByKey(e -> e.getDepartment()))
                .collect(Collectors.toList());

        uniqueByName.forEach((emp)-> System.out.println("Distinct employee: "+emp));




        //sort by age
        List<Employee> sortByAge = employeeList.stream().sorted(Comparator.comparingInt((emp)
                -> emp.getAge())).collect(Collectors.toList());
        sortByAge.forEach((System.out::println));

    }


    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
}
