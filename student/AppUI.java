package middletest.student;

public class AppUI {
    public static void main(String[] args) {
        Class_ class1 = new Class_("데이터사이언스");
        class1.addStudent(1234,"daehee");
        class1.showStudentsList();
        class1.addStdSubject(1234,Subjects.JAVA);
        class1.setStdGrade(1234,Subjects.JAVA,3.5);
        class1.showGradeList(1234);
    }
}
