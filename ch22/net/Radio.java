package ch22.net;

public class Radio extends Device{
    @Override
    protected void connect() {
        super.connect();
        System.out.println("radio connect()");
    }
}
