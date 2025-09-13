package lambdas;

import java.util.*;

class Employee{
    String name;
    int salary;

    Employee(String name, int salary){
        this.name = name;
        this.salary = salary;
    }
    public String toString(){return name + " (" + salary + ") ";}
}

public class miniProject {
    public static void main(String[] args){
        List<Employee> employees = Arrays.asList(
                new Employee("emp1", 5000),
                new Employee("emp2", 8000),
                new Employee("emp3", 4000),
                new Employee("emp4", 7000)
        );

        employees.sort((e1, e2) -> e1.salary - e2.salary);
        System.out.println("sorted by salary " + employees);

        employees.stream()
                .filter(e -> e.salary > 5000)
                .forEach(e -> System.out.println("High earner: " + e));

        employees.forEach(e -> e.salary *= 1.1);
        System.out.println("After raise: " + employees);
    }
}
