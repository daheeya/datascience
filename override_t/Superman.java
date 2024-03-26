package override_t;

public class Superman extends Person{
    boolean isSuperPower;

    @Override
    public void sleep() { // private 불가능. 부모의 접근제어지시자보다 높거나 같아야한다. 그래야 오버라이드가 성립된다. public 왜 한다고 했더라..
        System.out.println("superman sleep()");

    }
}
