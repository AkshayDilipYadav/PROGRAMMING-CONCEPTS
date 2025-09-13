package streams;

import java.util.*;
import java.util.stream.*;

class Employee{
    String name;
    String department;
    int salary;

    Employee(String name, String department, int salary){
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String toString(){return name + " - " + department + " - " + salary;}
}

public class miniProject {

    public static void main(String[] args){
        List<Employee> employees = Arrays.asList(
                new Employee("emp1", "it", 6000),
                new Employee("emp2", "finance", 8000),
                new Employee("emp3", "it", 4000),
                new Employee("emp4", "hr", 7000),
                new Employee("emp5", "finance", 9000)
        );

        // 1. find all employees in IT

        employees.stream()
                .filter(e -> e.department.equals("it"))
                .forEach(System.out::println);

        // 2. List of all salaries > 5000

        List<Integer> highSalaries = employees.stream()
                .map(e -> e.salary)
                .filter(s -> s>5000)
                .toList();

        //3. Find average salary

        double avg = employees.stream()
                .mapToInt(e -> e.salary)
                .average()
                .orElse(0);
        System.out.println("Average Salary: " + avg);

        // 4. Group employees by department
        Map<String, List<Employee>> byDept = employees.stream()
                .collect(Collectors.groupingBy(e -> e.department));
        System.out.println("Grouped by Dept: " + byDept);

        // 5. Find highest paid employee
        employees.stream()
                .max(Comparator.comparingInt(e -> e.salary))
                .ifPresent(e -> System.out.println("Highest Paid: " + e));


    }
}
