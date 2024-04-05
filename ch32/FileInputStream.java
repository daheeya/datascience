package ch32;

import java.io.*;

public class FileInputStream {
    public static void main(String[] args) {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(new java.io.FileInputStream("b.txt")))){  // try with resource 썼으니까 close() 신경 X
            String str;
            while ((str = br.readLine())!= null){
                System.out.println(str);
            }
        }catch (Exception e ){
            System.out.println(e.getMessage());
        }


        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("bb.txt")))){
            bw.write("bufferWriter 입니다.");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        try(BufferedReader br = new BufferedReader(new FileReader("bb.txt"))){  // 이렇게 줄이기 가넝
            String str;
            while((str=br.readLine())!=null){
                System.out.println(str);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
