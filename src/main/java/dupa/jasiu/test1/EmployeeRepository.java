package dupa.jasiu.test1;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@EnableCaching
public class EmployeeRepository {

    static Integer counter = 0;
    private List<Employee> employeeList;

    EmployeeRepository() {
        employeeList = Arrays.asList(
            new Employee("Tom Jones", 45, 12000.00, Department.MARKETING, "man"),
            new Employee("Harry Major", 26, 20000.00, Department.LEGAL, "man"),
            new Employee("Ethan Hardy", 65, 30000.00, Department.LEGAL, "man"),
            new Employee("Nancy Smith", 22, 15000.00, Department.MARKETING, "woman"),
            new Employee("Catherine Jones", 21, 18000.00, Department.HR, "woman"),
            new Employee("Anna Krajewska", 31, 19000.00, Department.HR, "woman"),
            new Employee("Kiejstut Byczkowski", 33, 29000.00, Department.HR, "man"),
            new Employee("James Elliot", 58, 24000.00, Department.OPERATIONS, "man"),
            new Employee("Frank Anthony", 55, 32000.00, Department.MARKETING, "man"),
            new Employee("Michael Reeves", 40, 45000.00, Department.OPERATIONS, "man"));

        System.out.println("EmployeeRepository created!");
    }


    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    @Cacheable("kesz1")
    public Employee getEmployee(String name) {
        counter += 1;
        List<Employee> retVal = new ArrayList<>();
        System.out.println("---------- #" + counter + " searching for " + name);
        employeeList.forEach( e ->
        {
            System.out.print("...");
            if(e.getName().equals(name)) {
                System.out.print(" found ");
                retVal.add(e);
            }
        });
        System.out.println("");
        System.out.println("------------- done with " + retVal.size() + " results");
        return retVal.isEmpty() ? null : retVal.get(0);
    }
}
