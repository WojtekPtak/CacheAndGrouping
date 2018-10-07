package dupa.jasiu.test1;

import java.util.List;
import java.util.function.DoubleConsumer;

public class EmployeeSumSalary implements DoubleConsumer {

    List<Employee> employees;
    Double sumSalary;
    Department dept;

    public EmployeeSumSalary(List<Employee> employees, Department dept) {
        this.sumSalary = 0.0;
        this.employees = employees;
        this.dept = dept;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Double getSumSalary() {
        return sumSalary;
    }

    public Department getDept() {
        return dept;
    }

    @Override
    public void accept(double value) {
        sumSalary += value;
    }

    @Override
    public DoubleConsumer andThen(DoubleConsumer after) {
        return null;
    }
}
