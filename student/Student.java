package middletest.student;

import java.util.*;

public class Student {
    private int stdNum;
    private String name;
    private Grade grade;
    private static Set<Grade> gradeList;
    private static Set<Subjects> subjectsSet;
    public Student(int stdNum, String name){
        this.stdNum=stdNum;
        this.name=name;
        gradeList = new HashSet<>();
        subjectsSet = new HashSet<>();
    }

    public int getStdNum() {
        return stdNum;
    }

    public void addStdSubjects(Subjects subject){
        subjectsSet.add(subject);
    }
    public void addStdGrade(Subjects subject, double grade){
        this.grade= new Grade(subject,grade);
        gradeList.add(this.grade);
    }
    public void deleteStdGrade(Grade grade){
        gradeList.remove(grade);
    }
    public Set<Subjects> getSubjectsSet() {
        return subjectsSet;
    }

    public Set<Grade> getGradeList() {
        return gradeList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "학번=" + stdNum +
                ", 이름='" + name + '\'' +
                '}';
    }


}
