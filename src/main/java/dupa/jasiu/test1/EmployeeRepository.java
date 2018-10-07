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


    EmployeeRepository() {
        System.out.println("EmployeeRepository created!");
    }

    static Integer counter = 0;
    public List<Employee> employeeList = Arrays.asList(
            new Employee("Tom Jones", 45, 12000.00, Department.MARKETING),
            new Employee("Harry Major", 26, 20000.00, Department.LEGAL),
            new Employee("Ethan Hardy", 65, 30000.00, Department.LEGAL),
            new Employee("Nancy Smith", 22, 15000.00, Department.MARKETING),
            new Employee("Catherine Jones", 21, 18000.00, Department.HR),
            new Employee("James Elliot", 58, 24000.00, Department.OPERATIONS),
            new Employee("Frank Anthony", 55, 32000.00, Department.MARKETING),
            new Employee("Michael Reeves", 40, 45000.00, Department.OPERATIONS));


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
