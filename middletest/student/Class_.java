package middletest.student;

import java.util.ArrayList;
import java.util.List;

public class Class_ {
    private String className;
    private static List<Student> stdList;
    private boolean isStudent;
    private int stdIdx;
    public Class_(String className){
        this.className=className;
        stdList=new ArrayList<>();
        isStudent=false;
        stdIdx=0;
    }

    // 해당 학급에 학생 추가
    public void addStudent(int stdNum, String name){
        Student student = new Student(stdNum,name);
        stdList.add(student);
    }
    // 학생 수강 과목 추가
    public void addStdSubject(int stdNum, Subjects subject){
        for (var s: stdList){
            if(s.getStdNum()==stdNum) {
                s.addStdSubjects(subject);
            }
        }
    }
    // 학생 리스트 출력
    public void showStudentsList(){
        for ( var s:stdList){
            System.out.println(s);
        }
    }
    // 학생 성적출력
    public void showGradeList(int stdNum){
        findStudent(stdNum);
        if(isStudent)
            System.out.println(stdList.get(stdIdx).getGradeList());
    }
    // 성적추가
    public void setStdGrade(int stdNum, Subjects subject, double grade){
        findStudent(stdNum);
        if(isStudent) {
            findSubject(stdNum,subject);
            stdList.get(stdIdx).addStdGrade(subject,grade);
        }
    }
    private void findStudent(int stdNum){
        stdIdx=0;
        for (var s : stdList){
            if(s.getStdNum() == stdNum) isStudent=true;
            else stdIdx++;
        }
    }
    private void findSubject(int stdNum, Subjects subjects){
        findStudent(stdNum);
        if(isStudent){
            stdIdx=0;
            for(var g: stdList.get(stdIdx).getGradeList()){
                if (g.getSubject()==subjects) stdList.get(stdNum).deleteStdGrade(g);
            }
        }
    }
}
