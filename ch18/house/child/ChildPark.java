package ch18.house.child;
import ch18.house.HousePark;

public class ChildPark extends HousePark
        // HousePark(부모)을 ChildPark(자식)이 상속한다.
        // 부모 것을 다 쓰겠다.
{
    public void test()
    {
        super.lastname = "kim";     // super : HousePark
        super.setHouse();
    }
}
/*
-> 자식이 부모를 상속받아 부모의 속성에 접근할 때에는
protected(강추) , public(위험) 상태의 속성만 접근 가능
private, 일반은 접근 불가능 오류!*/