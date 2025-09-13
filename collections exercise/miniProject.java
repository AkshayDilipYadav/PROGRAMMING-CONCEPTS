package collections;

import java.util.*;

class Student {
    int id;
    String name;
    double grade;

    Student(int id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public String toString() {
        return id + " - " + name + " (Grade: " + grade + ")";
    }
}


public class miniProject {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(101, "John", 85.5));
        students.add(new Student(102, "Alice", 92.0));
        students.add(new Student(103, "Bob", 76.5));
        students.add(new Student(104, "Charlie", 85.5));

        // 1. Sort students by grade
        students.sort((s1, s2) -> Double.compare(s2.grade, s1.grade));
        System.out.println("Sorted by Grade: " + students);

        // 2. Store students in a HashMap by ID
        Map<Integer, Student> studentMap = new HashMap<>();
        for (Student s : students) {
            studentMap.put(s.id, s);
        }
        System.out.println("Student Map: " + studentMap);

        // 3. Group students by grade
        Map<Double, List<Student>> gradeGroups = new HashMap<>();
        for (Student s : students) {
            gradeGroups.computeIfAbsent(s.grade, k -> new ArrayList<>()).add(s);
        }
        System.out.println("Grouped by Grade: " + gradeGroups);

        // 4. Use a Set to store unique student names
        Set<String> names = new HashSet<>();
        for (Student s : students) names.add(s.name);
        System.out.println("Unique Names: " + names);
    }
}
