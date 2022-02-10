package pers.project1.function;

import pers.project1.Course.Course;
import pers.project1.student.Student;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagementFunctions {
    Student student;

    public ManagementFunctions(Student student) {
        this.student = student;
    }

    public ManagementFunctions() {
        readFile();
    }

    public void readFile() {
        System.out.println("读取文件中");
        try {
            File file = new File("E:\\test.txt");
            BufferedReader br = new BufferedReader(new FileReader("E:\\test.txt"));
            String s;
            while ((s = br.readLine()) != null) {
                int num = 0; //学号
                String name = null; //姓名
                int age = 0; //年龄
                String dpt = null; //系别
                int cls = 0; //班级
                String ctt = null; //联系方式
                ArrayList<Course> list = new ArrayList<>();
                Course course = new Course();

                for (int i = 0; i < s.length(); i++) {
                    int site = s.indexOf(" ",i);
                    String s2 = s.substring(i,site);
                    i = site;
                    if (num == 0) {
                        num = Integer.parseInt(s2);
                        continue;
                    }
                    if (name == null) {
                        name = s2;
                        continue;
                    }
                    if (age == 0) {
                        age = Integer.parseInt(s2);
                        continue;
                    }
                    if (dpt == null) {
                        dpt = s2;
                        continue;
                    }
                    if (cls == 0) {
                        cls = Integer.parseInt(s2);
                        continue;
                    }
                    if (ctt == null) {
                        ctt = s2;
                        continue;
                    }
                    if (course.getName() == null) {
                        course.setName(s2);
                        continue;
                    }
                    if (course.getNature() == null) {
                        course.setNature(s2);
                        continue;
                    }
                    if (course.getPeriod() == 0) {
                        course.setPeriod(Integer.parseInt(s2));
                        continue;
                    }
                    if (course.getCredits() == 0) {
                        course.setCredits(Integer.parseInt(s2));
                        continue;
                    }
                    if (course.getTerm() == 0) {
                        course.setTerm(Integer.parseInt(s2));
                    }
                    list.add(course);
                    course = new Course();
                }
                Student student = new Student(num,name,age,dpt,cls,ctt,list);
                ManagementStudents.addStudent(num,student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void outputFile() {
        try {
            FileOutputStream fo = new FileOutputStream("E:\\test.txt");
            for (Object o:ManagementStudents.getMap().keySet()) {
                Student student = ManagementStudents.getStudent(Integer.parseInt(o.toString()));
                fo.write(String.valueOf(student.getNum()).getBytes(StandardCharsets.UTF_8));
                fo.write(" ".getBytes(StandardCharsets.UTF_8));
                fo.write(student.getName().getBytes(StandardCharsets.UTF_8));
                fo.write(" ".getBytes(StandardCharsets.UTF_8));
                fo.write(String.valueOf(student.getAge()).getBytes(StandardCharsets.UTF_8));
                fo.write(" ".getBytes(StandardCharsets.UTF_8));
                fo.write(student.getDpt().getBytes(StandardCharsets.UTF_8));
                fo.write(" ".getBytes(StandardCharsets.UTF_8));
                fo.write(String.valueOf(student.getCls()).getBytes(StandardCharsets.UTF_8));
                fo.write(" ".getBytes(StandardCharsets.UTF_8));
                fo.write(student.getCtt().getBytes(StandardCharsets.UTF_8));
                fo.write(" ".getBytes(StandardCharsets.UTF_8));
                for (Object value : student.getList()) {
                    Course course = (Course) value;
                    fo.write(course.getName().getBytes(StandardCharsets.UTF_8));
                    fo.write(" ".getBytes(StandardCharsets.UTF_8));
                    fo.write(course.getNature().getBytes(StandardCharsets.UTF_8));
                    fo.write(" ".getBytes(StandardCharsets.UTF_8));
                    fo.write(String.valueOf(course.getPeriod()).getBytes(StandardCharsets.UTF_8));
                    fo.write(" ".getBytes(StandardCharsets.UTF_8));
                    fo.write(String.valueOf(course.getCredits()).getBytes(StandardCharsets.UTF_8));
                    fo.write(" ".getBytes(StandardCharsets.UTF_8));
                    fo.write(String.valueOf(course.getTerm()).getBytes(StandardCharsets.UTF_8));
                    fo.write(" ".getBytes(StandardCharsets.UTF_8));
                }
                fo.write("\n".getBytes(StandardCharsets.UTF_8));
            }
            fo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addCourse() {
        Scanner scanner = new Scanner(System.in);
        Course course = new Course();
        System.out.println("输入添加课程名称");
        course.setName(scanner.next());
        System.out.println("输入课程性质");
        course.setNature(scanner.next());
        System.out.println("输入学时");
        course.setPeriod(scanner.nextInt());
        System.out.println("输入学分");
        course.setCredits(scanner.nextInt());
        System.out.println("输入开课学期");
        course.setTerm(scanner.nextInt());
        student.addList(course);
        outputFile();
    }

    public void removeCourse() {
        student.outputInformation();
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入删除课程序号");
        int num = scanner.nextInt();
        student.removeList(num);
        System.out.println("删除完毕");
        outputFile();
    }

    public void modifyCourse() {
        
    }
}
