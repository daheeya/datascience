package ch32.HandsOn;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class MyWriter implements AutoCloseable {
    private BufferedWriter bufferedWriter;

    public MyWriter(String fileName) throws Exception {
        bufferedWriter = new BufferedWriter(new FileWriter(fileName));
    }

    public void write(String str) throws Exception {
        bufferedWriter.write(str);
        bufferedWriter.newLine();
    }

    @Override
    public void close() throws Exception {
        bufferedWriter.close();
    }
}
