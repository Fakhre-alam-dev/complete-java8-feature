package mfa.codecurve.upskilling2026;

public class Student implements Comparable<Student> {

    private Integer id;
    private String name;
    private volatile static Student student = null;


    private Student() {
    }

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


    @Override
    public int compareTo(Student o) {
        return o.getName().compareTo(name);
    }

    public static Student getInstance() {

        if(student==null){
            synchronized (Student.class){
                if(student==null){
                    student=new Student();
                }
            }
        }


        return student;
    }
}
