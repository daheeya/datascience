package middletest.student.univ_mgr;

import java.util.Objects;

public class Student {
    private String name;
    private Long studentNum;

    public Student(String name){
        this(name, null);
    }

    public Student(String name, Long studentNum) {
        this.name = name;
        this.studentNum = studentNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Long studentNum) {
        this.studentNum = studentNum;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", studentNum=" + studentNum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return Objects.equals(studentNum, student.studentNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentNum);
    }
}
