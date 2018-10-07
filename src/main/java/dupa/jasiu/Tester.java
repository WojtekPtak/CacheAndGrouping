package dupa.jasiu;

import dupa.jasiu.test1.CachingConfig;
import dupa.jasiu.test1.Department;
import dupa.jasiu.test1.Employee;
import dupa.jasiu.test1.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class Tester {

    @Autowired
    CachingConfig cfg; // required - or error: "No CacheResolver specified, and no bean of type CacheManager found. Register a CacheManager bean or remove the @EnableCaching annotation from your configuration."

    @Autowired
    EmployeeRepository empRepo;

    Tester() {
        System.out.println("Tester created :)");
    }


    public void test() {

        Arrays.asList("Tom Jones","Harry Major","Harry Major","Tom Jones","Tom Jones").stream().forEach( e ->
        {
            System.out.println("Searching for " + e);
            System.out.println("            znaleziony: " + empRepo.getEmployee(e));
        });

        Map<Department, List<Employee>> employeeMap = empRepo.employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println("Employees grouped by department");
        employeeMap.forEach((Department key, List<Employee> empList) -> System.out.println(key + " -> " + empList));
    }

}