package middletest.student.univ_mgr;

public class AppUI {
    public static void main(String[] args) {
        ClassMgr.getInstance().createClass("A Class"); // 학급을 만들고

        var AClass = ClassMgr.getInstance().findClass("A Class"); // 학급을 찾아서
        AClass.createStudent("kavin");  // 학생 등록
        AClass.createStudent("david");
        AClass.setGradeStudent(2L,Subject.KOREAN,90);
        AClass.setGradeStudent(2L,Subject.KOREAN, 80);

        System.out.println(AClass);
    }
}
