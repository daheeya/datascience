package ch32.HandsOn2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Car {
    public void read(String str){
        try(var br= new BufferedReader(new FileReader(str))){

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
