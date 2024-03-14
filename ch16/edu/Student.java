package ch16.edu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Student {
    String name;
    Subject[] subjects = new Subject[2]; // 생성자 없이 바로 초기화
    int subjectIndex=0;

    public Student(String name){
        this.name=name;
    }
    public void addSubject(Subject subject){
        subjects[subjectIndex++]=subject;
    }

    public int totalScore(){
        int sum=0;
        for (var s:subjects){
            sum+=s.score;
        }return sum;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", subjects=" + Arrays.toString(subjects) +
                ", subjectIndex=" + subjectIndex +
                '}';
    }
    //Arrays의 toString은 Array를 sTring으로 바꿔주는 메소드구나 ~ 그래서 파라미터가 Array가 들어가야한다. 얘도 static
    // 머라노. sout 안찍어도 된다고? . . ... 아하
    //Arrays.toString(subjects) 이렇게
}
