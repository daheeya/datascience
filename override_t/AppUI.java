package override_t;

public class AppUI {
    public static void main(String[] args) {
        Person person = new Person();
        AppUI appUI = new AppUI(); // 같은 클래스 이지만 클래스 안이기 ㄸㅐ문에 생성자 인스턴스를 만들어서 접근가능하다.
        appUI.setSleep(person);

        Person superman = new Superman();
        superman.sleep(); // 우선 부모(Person)의 sleep이 메모리를 갖고. 다음에 오버라이드 되어서 SuperMan의 sleep이 메모리를 갖는다.

        appUI.setSleep(superman); // 부모로 upcasting

        var sample1 = new Sample();
        sample1.aaa();
        var sample2 = new Sample();
        sample2.aaa();
         // sample을 아무리 생성해도 aaa() 는 하나이다.
    }
    // 다형성 활용에 많이 굉장히 억수로 많이 사용됩니다.
    public void setSleep(Person person){ // 메인 클래스 안.
        person.sleep();
    }
}
