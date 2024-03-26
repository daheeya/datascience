package override_t;

import java.util.ArrayList;
import java.util.List;

class Device{
    protected String brand;
    public Device(String brand){
        this.brand=brand;
    }
    public void turnOn(){
        System.out.println(brand+"device is turn on!");
    }

    public void turnOff(){
        System.out.println(brand+"device is turn off!");
    }

}
class Notebook extends Device{
    protected String model;
    public Notebook(String brand, String model){
        super(brand);
        this.model=model;
    }
    public void open(){
        System.out.println(brand+" "+model+" is open.");
    }
    public void close(){
        System.out.println(brand+" "+model+ " is close.");
    }

}
public class MacBook extends Notebook{
    private String brand;
    private String model;

    public MacBook(String brand, String model){
        super(brand,model);
    }

    @Override
    public void open() {
        System.out.println("mac book open custom");
    }

    public void runMacOS(){
        System.out.println("Running macOS on "+brand+" "+ model);
    }
}
class GalaxyBook extends Notebook{
    private String brand;
    private String model;

    public GalaxyBook(String brand, String model){
        super(brand, model);
    }

    public void runAndroidOS(){
        System.out.println("Running AndroidOS on "+brand+" "+ model);
    }
}

class AppleWatch extends Device{
    private String model;

    public AppleWatch(String brand, String model){
        super(brand);
        this.model=model;
    }
    public void trackingMove(){
        System.out.println("watch tracking on ...");
    }
}
class MyDevice{
    List<Device> devices;
    public MyDevice(){
        devices=new ArrayList<>();
    }
    public void addDevice(Device device){
        devices.add(device);
    }
    public void runNow(Device device){
        if(device instanceof MacBook) ((MacBook)device).runMacOS();
        else if (device instanceof GalaxyBook) ((GalaxyBook)device).runAndroidOS();
        else((AppleWatch)device).trackingMove();
        }

    public List<Device> getDevices() {
        return devices;
    }

}


class Main{
    public static void main(String[] args) {
        var myDevice = new MyDevice();

        Device device = new MacBook("Samsung","book_pro");
        //myDevice.addDevice(device);

        myDevice.addDevice(new MacBook("Apple","pro2"));
        myDevice.addDevice(new GalaxyBook("Samsung","pro"));
        myDevice.addDevice(new AppleWatch("Apple","SE"));

        for ( var d:myDevice.getDevices()){
            myDevice.runNow(d);
        }
    }
}