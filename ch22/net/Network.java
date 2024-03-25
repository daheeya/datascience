package ch22.net;

import java.util.ArrayList;
import java.util.List;

public class Network {
    List<Device> devices;
    public Network(){
        devices= new ArrayList<>();
    }
    public void connectDevice(Device device){
        device.connect();
    }
}
