package mfa.codecurve.upskilling2026;

public class TestClone {
    public static void main(String[] args) {
        Employee employee=new Employee(1,"alam",22,2600);
        Employee employee1=employee.clone();
        System.out.println(employee1);


    }
}
