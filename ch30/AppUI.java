package ch30;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AppUI {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("aaagg","bbbs","ccceee");

        // 글자 길이 기준으로 오름차순으로 정렬을 해보세요.
        // 지난 시간에 배운 Comparator 사용
        Collections.sort(words, new Comparator<String>() { // 어차피 한번만 쓸건데 굳이 객체를 만들어야하나.
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(),o2.length());
            }
        });
        for (var s : words) System.out.println(s);

        // 람다식으로
        // Comparator 인터페이스도 @FunctionalInterface 이므로 객체를 만들 필요없이 람다식으로 가능
        Collections.sort(words,((o1, o2) -> Integer.compare(o1.length(),o2.length())));
        for (var s : words) System.out.println(s);

        Comparator<String> fun1=(s1,s2)->Integer.compare(s1.length(),s2.length());
    }

}


