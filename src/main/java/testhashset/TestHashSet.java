package testhashset;

import java.util.HashSet;

public class TestHashSet {
    public static void main(String[] args) {

        HashSet<Student> students = new HashSet<>();

        Student student1 = new Student("Ivan", 21);
        Student student2 = new Student("Kolia",22);
        Student student3 = new Student("Petia",22);
        Student student4 = new Student("Ivan", 21);

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        System.out.println(students.contains(student1));
        System.out.println(students.contains(student4));

        students.stream().forEach(System.out::println);
    }


}
