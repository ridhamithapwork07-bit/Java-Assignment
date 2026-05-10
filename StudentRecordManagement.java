import java.util.*;

// Generic Class
class Student<T> {

    T id;
    String name;
    int age;
    String department;

    // Constructor
    Student(T id, String name, int age, String department) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    // Display Method
    void display() {

        System.out.println("Student ID      : " + id);
        System.out.println("Student Name    : " + name);
        System.out.println("Student Age     : " + age);
        System.out.println("Department      : " + department);
        System.out.println("-------------------------------");
    }
}

// Main Class
public class StudentRecordManagement {

    public static void main(String[] args) {

        // Collection using ArrayList
        ArrayList<Student<Integer>> studentList =
                new ArrayList<Student<Integer>>();

        // Adding Student Records
        studentList.add(
                new Student<Integer>(
                        101,
                        "Arun",
                        20,
                        "Computer Science"));

        studentList.add(
                new Student<Integer>(
                        102,
                        "Priya",
                        21,
                        "Information Technology"));

        studentList.add(
                new Student<Integer>(
                        103,
                        "Rahul",
                        22,
                        "Electronics"));

        // Iterator to Retrieve Records
        Iterator<Student<Integer>> itr =
                studentList.iterator();

        System.out.println("STUDENT RECORDS");
        System.out.println("========================");

        // Display Student Records
        while (itr.hasNext()) {

            Student<Integer> s = itr