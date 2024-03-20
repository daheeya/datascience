package ch21;

import java.util.*;

public class ArrayTest {
    public static void main(String[] args) {
        //ArrayList<String> list1 = new ArrayList<>();
        // heapMemoryIssue 해결
        List<String> list1 = Collections.checkedList(new ArrayList<>(), String.class);

        list1.add("kavin");
        list1.add("david");
    }
}
