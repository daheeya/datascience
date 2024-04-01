package ch27.java_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Origin {
    private String name;
    private int age;

    public Origin(String name, int age){
        this.name=name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Origin{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
class Main_{
    public static void main(String[] args) {
        List<Origin> origins= new ArrayList<>(); // Collection 프레임 워크 : Collections 로 매소드 접근
        origins.add(new Origin("dahee",23));
        origins.add(new Origin("kavin",24));
        origins.add(new Origin("david",19));

        // 이름 기준 오름차순으로 정렬하기.
        // Compare 오버라이딩
        Collections.sort(origins, new Comparator<Origin>() { // 익명클래스로 사용. 정렬을 하려면 Collection 프레임워크안에 들어가있어야한다.
            @Override // 자동완성.. 재정의.
            public int compare(Origin o1, Origin o2) {
                // return 0 : 위치변동 없음
                // return 음수 : 자리바꿈을 하지 않음
                // return 양수 : 자리바꿈을 한다.
                return (o1.getName().compareTo(o2.getName())); // compareTo 로 String 비교 ! default: 오름차순 -> 내림차순 : *-1(부호변경)
                // return (o1.getAge() > o2.getAge() ? -1 : ((o1.getAge() == o2. getAge() ? 0 : 1))); // 나이로 내림차순 삼항연산자 사용
                // return Integer.compare(o1.getAge(),o2.getAge()); // 이렇게도 가능
            }
        });
        for(var o : origins){
            System.out.println(o);
        }
    }
}
