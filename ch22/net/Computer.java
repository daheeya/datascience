package ch22.net;

public class Computer extends Device{
    @Override
    public void connect() {
        super.connect();
        System.out.println("computer connect()");
    }
    public void keyboard(boolean instance){

    }
}
