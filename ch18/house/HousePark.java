package ch18.house;

import ch18.house.HouseKim;

public class HousePark
{
    protected String lastname = "park";

    public static void main(String[] args)
    {
        var kim = new HouseKim();
        // default 접근 제어지시자는 같은 패키지 house에서만 참조 가능
        System.out.println(kim.lastname);
        // "Housekim"이 같은 클래스 내에 있기 때문에 객체 생성 및 접근 가능
        // This is very dangerous
    }

    protected void setHouse() {
    }
}