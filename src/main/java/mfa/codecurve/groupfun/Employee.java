package mfa.codecurve.groupfun;

import java.util.Objects;

public final class Employee {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final Integer age;      // nullable on purpose to show null-handling
    private final String department;
    private final Double salary;    // nullable too

    public Employee(int id, String firstName, String lastName, Integer age, String department, Double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    // Getters...
    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public Integer getAge() { return age; }
    public String getDepartment() { return department; }
    public Double getSalary() { return salary; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return getId() == employee.getId() && Objects.equals(getFirstName(), employee.getFirstName()) && Objects.equals(getLastName(), employee.getLastName()) && Objects.equals(getAge(), employee.getAge()) && Objects.equals(getDepartment(), employee.getDepartment()) && Objects.equals(getSalary(), employee.getSalary());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getAge(), getDepartment(), getSalary());
    }

    @Override
    public String toString() {
        return String.format("Employee{id=%d, %s %s, age=%s, dept=%s, salary=%s}",
                id, firstName, lastName, age, department, salary);
    }
}