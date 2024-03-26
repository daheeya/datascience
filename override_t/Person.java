package override_t;

public class Person {
    protected int age; // 상속받는 애가 본인 것 처럼 쓸 수 있음.
    protected String name;

    protected void sleep(){
        System.out.println("sleep from person obj");
    }

    protected void showPersonInfo(){
        System.out.println("show person info");
    }
}
