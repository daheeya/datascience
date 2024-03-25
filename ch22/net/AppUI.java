package ch22.net;

public class AppUI {
    public static void main(String[] args) {
        var network=new Network();
        network.connectDevice(new Computer()); //device의 connect가 오버라이딩되어서 computer의 채ㅜㅜㄷㅊㅅrk ghcnfehlsek.
        network.connectDevice(new Radio());

        // upcasting (자식이 부모로 형변환) : 컴파일러가 자동으로 해준다.
        Device device=new Computer(); // 가능하쥬? List ArrayList 처럼 !
        device.connect();// 컴퓨터의 connect가 호출된다.
        // 부모로 업캐스팅 되어서 메모리 주소는 device이지만 오버라이딩 되면서 다른 메모리주소의 connect 메소드의 호출이 된다.
        // 자바는 가장 최근에 생성한 메소드를 가진다. device.connect-> computer.connect 이렇게

        // downcasting (부모에서 자식으로 형변환) : 프로그래머가 선언
        ((Computer)device).keyboard(true); // 키보드를 쓰려면 자식의 타입으로 강제적 형변환을 해주어야 한다.
        // 부모->자식 : 강제적 형변환.

        // 이렇게 해버리면 컴파일 과정에서 사망함.
        Device device1 = new Device();
        Computer computer = (Computer) device1;
        computer.keyboard(true);

    }
}
