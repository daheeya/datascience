package middletest.student.univ_mgr;

import java.util.*;

public class ClassRoom {
    private String name;
    private static Long studentNum = 1L;
    private Set<Student> students;
    private List<Grade> grades;

    public ClassRoom(String name){
        this.name=name;
        students = new HashSet<>();
        grades = new ArrayList<>();
    }
    public void createStudent(String name){
        students.add(new Student(name, ClassRoom.studentNum++));
    }
    public Student findStudent(Long studentNum){
        for(var s : students){
            if(Objects.equals(s.getStudentNum(),studentNum)) return s;
        }
        return null;
    }
    public void setGradeStudent(Long studentNum, Subject subject, int score){
        grades.add(new Grade(studentNum,subject,score));

    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "name='" + name + '\'' +
                ", students=" + students + // student도 tostring 해주기
                ", grades=" + grades +// grade도 tostring
                '}';
    }
}
