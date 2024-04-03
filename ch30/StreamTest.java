package ch30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class StreamTest {
    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5};
//
//        // IntStream 생성
//        IntStream intStream = Arrays.stream(arr);
//        // IntStream
//        //System.out.println(intStream.sum());
//        //System.out.println(intStream.sum()); // 재사용 불가
//        System.out.println(Arrays.stream(arr).sum()); // 이렇게 사용하면 됨.
//
//        OptionalInt optionalInt = Arrays.stream(arr).max();
//        optionalInt.ifPresent(m -> System.out.println(m)); // 옵션 이라는 박스 안에 실제 값이 있으면(ifPresent) 그 값을 빼서(m) sout으로 찍어줘
//        // optionalInt.ifPresent(System.out::println); // 이렇게도 가능 !!
//
//        IntStream.range(0,6).forEach(System.out::println); // 한개씩 뺀 값을 받아줌. range의 반환값은 IntStream 이네!@~!

//        List<String> stringList = Arrays.asList("1","2","3","4","5");
//        String s = stringList.get(0);
//        int i = Integer.parseInt(s);
//
//        System.out.println(stringList.stream().mapToInt(str->Integer.parseInt(str)).sum());

        List<String> animals = Arrays.asList("Animal","Cat","Tiger","Hamster");
        // 각 리스트의 엘리먼트를 출력해보자.
        animals.stream().forEach(System.out::println);
        // 각 요소의 글자길이의 평균을 출력
        System.out.println(animals.stream().mapToInt(str->str.length()).average());
        // ter 로 끝나는 글자들의 길이를 출력
        animals.stream().filter(str->str.endsWith("ter")).mapToInt(String::length).forEach(System.out::println);
        // ter 로 끝나는 글자들의 max 길이를 출력
        animals.stream().filter(str->str.endsWith("ter")).mapToInt(String::length).max().ifPresent(System.out::println);
        // ter로 끝나는 글자들의 길이가 5글자 이상인 글자 출력
        animals.stream().filter(str->str.endsWith("ter")).filter(str->str.length()>=5).forEach(System.out::println);

        List<String> resultList = animals.stream().filter(str->str.endsWith("ter")).toList();
    }
}
