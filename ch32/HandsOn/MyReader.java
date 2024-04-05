package ch32.HandsOn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MyReader implements AutoCloseable{
    private final BufferedReader bufferedReader;
    public MyReader(String fileName) throws Exception{
        bufferedReader=new BufferedReader(new FileReader(fileName));
    }

    public String read() throws Exception{
        return bufferedReader.readLine();
    }

    public List<String> getData() throws Exception{
        String data;
        var datas = new ArrayList<String>();
        while((data=bufferedReader.readLine())!=null){
            datas.add(data.trim());
        }
        return datas;
    }
    @Override
    public void close() throws Exception {
        bufferedReader.close();
    }
}
