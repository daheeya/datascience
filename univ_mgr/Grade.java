package middletest.student.univ_mgr;

public class Grade {
    private Long studentNum;
    private Subject subject;
    private int score;

    public Grade(Long studentNum, Subject subject, int score){
        this.studentNum=studentNum;
        this.subject = subject;
        this.score = score;
    }

    public Long getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Long studentNum) {
        this.studentNum = studentNum;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "studentNum=" + studentNum +
                ", subject=" + subject +
                ", score=" + score +
                '}';
    }
}
