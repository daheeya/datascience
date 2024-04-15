package chatapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost",5000)){  // 서버 ip 와 포트는 클라이언트가 무조건 알고 있어야한다.
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);  // autoFlush : flush 할 필요 없다.
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader inputStr = new BufferedReader(new InputStreamReader(System.in));

            Thread receiveThread = new Thread(()->{
                try{
                    String serverMsg;
                    while((serverMsg=br.readLine())!=null){
                        System.out.println("Server >> " +serverMsg);
                    }
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            });
            receiveThread.start();
            String userInput;
            while((userInput=inputStr.readLine())!=null){
                out.println(userInput);

            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
