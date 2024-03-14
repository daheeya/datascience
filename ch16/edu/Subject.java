package ch16.edu;

public class Subject {
    Course name;
    String code;
    int score;

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", score=" + score +
                '}';
    }

    public Subject(Course name, String code){
        this.name=name;
        this.code=code;
        score=0;
    }
    public Subject(Course name, String code,int score){
        this.name=name;
        this.code=code;
        this.score=score;
    }

}
