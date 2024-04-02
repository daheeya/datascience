package ch29;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {
    public static void main(String[] args) {
        String [] strArr = {"ZZa","AAbbb","DDuu"};
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2); // default 오름차순, (내림차순 하려면 *(-1)
            }
        });

        System.out.println(Arrays.toString(strArr));
    }
}
