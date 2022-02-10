package pers.project1.Course;

public class Course {
    String name; //名字
    String nature ; //性质
    int period; //学时
    int credits; //学分
    int term; //学期

    public Course() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public Course(String name, String nature, int period, int credits, int term) {
        this.name = name;
        this.nature = nature;
        this.period = period;
        this.credits = credits;
        this.term = term;
    }
}
