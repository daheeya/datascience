package ch27;

public class StringUtil {
    public static void main(String[] args) {
        int i = 10;

        String str1 = "kim";
        String str2 = "park";
        System.out.println(str1.hashCode());

        // 문자열을 조합할 때 STring 클래스를 활용해서 + 연산자로 하면
        // 메모리 낭비 발생
        str1 += str2; //str1 = str1 + str2
        System.out.println(str1);
        System.out.println(str1.hashCode()); // 기존 메모리를 덮어 쓰는게 아니라 새로 만든다.

        // StringBuilder
        // 단일 스레드 환경에서 사용하면 좋다.
        // 단일 스레드 환경: 여러개의 실행 task들이 동시에 메소드에 진입하지 않음.
        StringBuilder stringBuilder = new StringBuilder(); // StringBuilder 은 클래스라서 인스턴스를 생성해야 한다.
        stringBuilder.append(str1);
        System.out.println(stringBuilder.hashCode());
        stringBuilder.append(str2);
        System.out.println(stringBuilder);
        System.out.println(stringBuilder.hashCode());

        // StringBuffer
        // 멀티스레드 환경에서 사용, thread safe 하다.
        // thread : 하나의 앱이 실행되면 하나의 프로세스가 생성되고 실행되기 위해서 CPU에게 메모리를 할당받는다. 그리고 그 안에서
        // synchroniazed 사용 : 속도가 느림 . 그러므로 멀티스레드 환경일 경우에만 사용하기
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("kim");
        stringBuffer.toString();


        StringUtil stringUtil = new StringUtil();
        System.out.println(stringUtil.makeString());
    }
    public String makeString(){
        StringBuilder builder = new StringBuilder();
        builder.append("kim\n");
        builder.append("min");

        return builder.toString();
    }
}
