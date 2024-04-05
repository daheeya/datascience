package ch32.HandsOn;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Wrapping { // 원기능을 감싸서 숨김. =>
    private List<String> writeList = new ArrayList<>();
    public void write(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        writeList.add(br.toString());
    }


    public void read(String str){
        try(BufferedReader br = new BufferedReader(new FileReader(str))){
            String brString;
            while((brString=br.readLine())!=null){
                System.out.println(brString);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public void save(String str){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(str))){
            for(var w:writeList){
                bw.write(w);
            }
            //bw.write(writeList.stream());
            //bw.write(writeList.stream().map(w->w.toString());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}

class AppUI_{
    public static void main(String[] args) {
        Wrapping wrapping = new Wrapping();

        wrapping.write();

    }

}
