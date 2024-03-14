package ch16.enum_;

/*
class Week {
	public static final Week MONDAY = new Week("MONDAY");
	public static final Week TUESDAY = new Week("TUESDAY");

	public String name;
	public Week(String name){
		this.name = name;
	}
}
*/
enum Week{
    MON,TUE,WED,THU,FRI,SAT,SUN,
}
public class DayT {
    public static void main(String[] args) {
        Week today = null; // null은 객체만 가능 !
        today=Week.MON; // today의 타입도 Week, Mon의 타입도 Week 이니까 가능하쥬 ~?
        System.out.println(today==Week.MON); //true , == 이라는 메모리 비교 가능한 이유: static 이니까!

        var days=Week.values(); //enum 클래스에서 제공하는 메소드 !. array
        for (var week:days){ // days는 어레이이다.
            System.out.print(week+" ");
        }

        Week w=Week.TUE; //THU 는 static final 이기 때문에 THU의 메모리 주소가 w에 들어감 .!
        System.out.println();
        System.out.println(w.name()); // 값 호출
        int weekIdx = w.ordinal(); // 인덱스 호출
        System.out.println(weekIdx);

        // enum은 이미 static 이기 때문에 equals 쓸 일이 없다.
    }
}

