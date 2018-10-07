package dupa.jasiu.test1;

public class Employee {
    private String name;
    private Integer age;
    private Double salary;
    private Department department;
    private String sex;

    public Employee(String name, Integer age, Double salary, Department department, String sex) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
        this.sex = sex;

    }

    // Setters/Getters for name,age,salary,department go here

    public String toString(){
        return "Employee Name:"+this.name;
    }

    //Standard equals and hashcode implementations go here


    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Double getSalary() {
        return salary;
    }

    public Department getDepartment() {
        return department;
    }

    public String getSex() {
        return sex;
    }
}