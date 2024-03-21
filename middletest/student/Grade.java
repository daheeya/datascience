package middletest.student;


public class Grade {
    // 성적은 학급에서 부여하고 싶었는데
    // 학생이 성적 리스트를 가지고 있어야해서.. 포기했습니다.
    private Subjects subject;
    private double grade;

    public Grade(Subjects subject, double grade){
        this.subject= subject;
        this.grade=grade;
    }

    public Subjects getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "과목=" + subject +
                ", 성적=" + grade +
                '}';
    }
}