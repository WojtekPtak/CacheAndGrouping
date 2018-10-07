package dupa.jasiu;

import dupa.jasiu.test1.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
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

        Arrays.asList("Tom Jones","Harry Major","Harry Major","Tom Jones","Tom Jones")
            .stream()
            .forEach( e -> {
                System.out.println("Searching for " + e);
                System.out.println("            znaleziony: " + empRepo.getEmployee(e));
            });

/*        Map<Department, List<Employee>> employeeMap0 = empRepo.build().getEmployeeList().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));*/

        // key as a List
        Map<List<Object>, List<Employee>> employeeMap = empRepo.getEmployeeList().stream()
                .collect(Collectors.groupingBy(r -> Arrays.asList(r.getDepartment(),r.getSex())));

        System.out.println("Employees grouped by department and sex");
        employeeMap.forEach( (key, val) ->
                System.out.println( key.get(0) + "," + key.get(1) + " -> " + Arrays.toString(val.toArray()))
        );

        // key as a String
        Map<String, List<Employee>> employeeMap2 = empRepo.getEmployeeList().stream()
                .collect(Collectors.groupingBy(r -> r.getSex()+"-"+r.getDepartment()));

        System.out.println("Employees grouped by department and sex II");
        employeeMap2.forEach( (String key, List<Employee> emps) ->
                System.out.println( Arrays.toString(key.split("-")) + " -> " + Arrays.toString(emps.toArray()))
        );

        System.out.println("Employees grouped by department and sex II - sorted");
        SortedSet<String> keys = new TreeSet<>(employeeMap2.keySet());
        keys.stream()
                .forEach(
                        k -> System.out.println(
                                Arrays.toString(k.split("-")) + " -> " + Arrays.toString(employeeMap2.get(k).toArray())
                        )
                );

        System.out.println("Employees grouped by department and sex II - sorted and avg salary");
        // again key as a String
        Map<String, EmployeeSumSalary> employeeMap3 = empRepo.getEmployeeList().stream()
                .collect(Collectors.groupingBy( r -> r.getSex()+"-"+r.getDepartment(), Collectors.summarizingDouble(Employee::getSalary)));

        employeeMap2.forEach( (String key, List<Employee> emps) ->
                System.out.println( Arrays.toString(key.split("-")) + " -> " + Arrays.toString(emps.toArray()))
        );
        SortedSet<String> keys = new TreeSet<>(employeeMap2.keySet());
        keys.stream()
                .forEach(
                        k -> System.out.println(
                                Arrays.toString(k.split("-")) + " -> " + Arrays.toString(employeeMap2.get(k).toArray())
                        )
                );

    }

}