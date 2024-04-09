package ch34;

import java.util.ArrayList;
import java.util.List;

public class Ticket implements Runnable{
    int ticket=10;
    List<String> list = new ArrayList<>();

    @Override
    public void run() {

        for (int i = 0; i < ticket; i++) {
            try {
                Thread.sleep(1);
                ticketing();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
    public synchronized void ticketing(){
        ticket--;
        if(ticket<=0){
            try {
                System.out.println("["+Thread.currentThread().getName()+"]");
                System.out.println("sold out");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }else {
            System.out.println("[" + Thread.currentThread().getName() + "]");
            System.out.println("ticket = [" + ticket + "]");

            setList(Thread.currentThread().getName());
        }

    }
    public void setList(String str){
        list.add(str);
    }

    public List<String> getList() {
        return list;
    }

}
class TicketSite{
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        for(int i = 0; i<6;i++){
            new Thread(ticket,"C"+i).start();
        }

        System.out.println(ticket.getList());

    }
}

