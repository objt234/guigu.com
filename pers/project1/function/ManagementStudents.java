package pers.project1.function;

import pers.project1.student.Student;

import java.util.HashMap;

public class ManagementStudents {
    private static HashMap<Integer, Student> map = new HashMap<>();

    public static Student getStudent(int num) {
        Student student = map.get(num);
        return student;
    }

    public static void addStudent(int num, Student student) {
        map.put(num,student);
    }

    public static HashMap getMap() {
        return map;
    }
}
