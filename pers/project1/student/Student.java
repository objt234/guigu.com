package pers.project1.student;

import pers.project1.Course.Course;

import java.util.ArrayList;

public class Student {
    private int num; //学号
    private String name; //姓名
    private int age; //年龄
    private String dpt; //系别
    private int cls; //班级
    private String ctt; //联系方式
    ArrayList<Course> list = new ArrayList<>();

    public Student(int num, String name, int age, String dpt , int cls, String ctt) {
        this.num = num;
        this.name = name;
        this.age = age;
        this.dpt = dpt;
        this.cls = cls;
        this.ctt = ctt;
    }

    public Student(int num, String name, int age, String dpt , int cls, String ctt,ArrayList<Course> list) {
        this.num = num;
        this.name = name;
        this.age = age;
        this.dpt = dpt;
        this.cls = cls;
        this.ctt = ctt;
        this.list = new ArrayList<Course>(list);
    }

    public void outputInformation() {
        System.out.println("系别：" + dpt + "学号" + num + "姓名" + name + "年龄" + age + "班级" + cls + "联系方式" + ctt);
        int i = 0;
        for (Object o:list) {
            Course course = (Course) o;
            System.out.print(++i + ". ");
            System.out.println("名称"  + course.getName());
            System.out.println("性质" + course.getNature());
            System.out.println("学时" + course.getPeriod());
            System.out.println("学分" + course.getCredits());
            System.out.println("开课年纪" + course.getTerm());
        }
    }

    public void addList(Course course) {
        list.add(course);
    }

    public void removeList(int num) {
        list.remove(--num);
    }

    public ArrayList getList() {
        return list;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDpt() {
        return dpt;
    }

    public void setDpt(String dpt) {
        this.dpt = dpt;
    }

    public int getCls() {
        return cls;
    }

    public void setCls(int cls) {
        this.cls = cls;
    }

    public String getCtt() {
        return ctt;
    }

    public void setCtt(String ctt) {
        this.ctt = ctt;
    }
}
