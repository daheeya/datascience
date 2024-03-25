package ch22.q1_composition;

public class AppUI {
    public static void main(String[] args) {
        new Programmer(new Person("dahee",23)).getPerson().eat();
    }
}
