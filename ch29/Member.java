package ch29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Member implements Comparable<Member>{
    private String name;
    private int age;
    public Member(String name,int age){
        this.name= name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Member o) {
        // return Integer.compare(this.age,o.getAge())*(-1); // int 형 compare
        return this.name.compareTo(o.getName())*(-1);
    }
}
class Main_{
    public static void main(String[] args) {
        var members = new ArrayList<Member>();
        members.add(new Member("kavin",23));
        members.add(new Member("david",30));
        members.add(new Member("steve",15));
        members.add(new Member("dahee",23));

        Collections.sort(members);
        System.out.println(members);
    }
}
