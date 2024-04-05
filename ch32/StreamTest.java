package ch32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class StreamTest {
    public static void main(String[] args) { // try catch 귀찮으니까..
        // case 1 : 표준 입출력 스트림
        int i = 0;
        try(var inputStream = System.in){
            while((i=inputStream.read())!='\n'){
                System.out.println((char)i);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        try(InputStreamReader isr = new InputStreamReader(System.in)){
            while ((i=isr.read())!='\n'){
                System.out.println((char)i);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        var inputStreamReader = new InputStreamReader(System.in);

        try{
            while ((i=inputStreamReader.read())!='\n'){  // read는 하나만 읽어옴 그래서 while문을 통해서 포인터가 다음꺼 읽어오는겨
                System.out.print((char) i );
            }
            inputStreamReader.close();  // 다 읽었으니까 무조건 닫아주기 !!~!
        }catch (Exception e){
            System.out.println("에러처리");
        }


        try(BufferedReader bufferedReader1 = new BufferedReader((new InputStreamReader(System.in)))){
            System.out.println(bufferedReader1.readLine());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
