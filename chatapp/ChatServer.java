package chatapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    public static void main(String[] args) {
        try(ServerSocket serverSocket= new ServerSocket(5000)){  //client는 포트를 무조건 알아야한다.
            while(true){
                System.out.println("waiting for client...");
                Socket clientSocket = serverSocket.accept();  // 리턴타입: 소켓 (클라이언트 소켓을 리턴한다)  // waiting 한다.
                System.out.println("New Client connected: "+ clientSocket);

                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clientHandler.start();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    private static class ClientHandler extends Thread{
        private Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;
        private static List<ClientHandler> clients = new ArrayList<>();  // static 을 붙인 이유: 생성할 때 마다 정보를 저장하기 위해


        public ClientHandler(Socket socket){
            this.clientSocket=socket;
            clients.add(this);
        }

        @Override
        public void run() {
            try{
                in = new BufferedReader((new InputStreamReader(clientSocket.getInputStream())));
                out = new PrintWriter(clientSocket.getOutputStream());  // PrintWriter 은 Outputstream을 wrapping 하고 있어서 사용하기 편리다하.

                String inputline;
                while((inputline=in.readLine())!=null){
                    System.out.println("Recv Msg from client "+clientSocket+" : "+inputline);
                    broadcast(inputline);
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        private void broadcast(String msg){
            clients.forEach(c->{
                c.out.println(msg);
                c.out.flush();  // 깔끔히 지우기
            });
        }
    }
}