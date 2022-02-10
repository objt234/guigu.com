package pers.project1.function;

import pers.project1.student.Student;

import java.util.Scanner;

public class Menu {
    private Student student;
    private int num; //学号
    private String name; //姓名
    private int age; //年龄
    private String dpt; //系别
    private int cls; //班级
    private String ctt; //联系方式

    Scanner scanner = new Scanner(System.in);
    public Menu() {
        ManagementFunctions mf2 = new ManagementFunctions();
        mf2.readFile();
        while (true) {
            System.out.println("1. 登录");
            System.out.println("2. 注册");
            System.out.println("3. 退出");
            int options = scanner.nextInt();
            switch (options) {
                case 1:
                    System.out.println("输入学号");
                    num = scanner.nextInt();
                    student = ManagementStudents.getStudent(num);
                    if (student != null) {
                        student.outputInformation();
                        while (true) {
                            int options2;
                            ManagementFunctions mf = new ManagementFunctions(student);
                            System.out.println("1. 添加课程");
                            System.out.println("2. 查询信息");
                            System.out.println("3. 删除课程");
                            System.out.println("4. 修改课程");
                            options2 = scanner.nextInt();
                            switch (options2) {
                                case 1:
                                    mf.addCourse();
                                    break;
                                case 2:
                                    student.outputInformation();
                                    break;
                                case 3:
                                    mf.removeCourse();
                                    break;
                                case 4:
                                    mf.modifyCourse();
                                    break;
                                default:
                                    System.out.println("未知");
                                    break;
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("请输入学号");
                    num = scanner.nextInt();
                    System.out.println("请输入姓名");
                    name = scanner.next();
                    System.out.println("请输入年龄");
                    age = scanner.nextInt();
                    while (true) {
                        if (age > 0) break;
                        System.out.println("输入有误请重新输入");
                        System.out.println("请输入年龄");
                        age = scanner.nextInt();
                    }

                    System.out.println("请输入系别");
                    dpt = scanner.next();
                    System.out.println("请输入班级（0 - 5班）");
                    cls = scanner.nextInt();
                    while (true) {
                        if (cls < 5 && cls > 0) break;
                        System.out.println("输入有误请重新输入");
                        System.out.println("请输入班级（0 - 5班）");
                        cls = scanner.nextInt();
                    }

                    System.out.println("请输入联系方式");
                    ctt = scanner.next();

                    student = new Student(num,name,age,dpt,cls,ctt);
                    ManagementStudents.addStudent(num,student);
                    System.out.println("注册成功");
                    mf2.outputFile();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("未知");
                    break;
            }
        }
    }
}
