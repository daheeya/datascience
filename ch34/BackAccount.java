package ch34;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BackAccount {
    private int balance = 1000;

    synchronized public void deposit(int amount){
        balance+=amount;
        System.out.println("deposit: "+ amount + ", Balance: "+balance);
    }

    synchronized public void withdraw(int amount){
        if(balance>=amount) {
            balance -= amount;
            System.out.println("withdraw: " + amount + ", Balance: " + balance);
        }else System.out.println("show me the money !!");
    }

    public int getBalance() {
        return balance;
    }

}

class Back{
    public static void main(String[] args) {
       final var bankAccount = new BackAccount();
        ExecutorService executorService = Executors.newFixedThreadPool(3);  // 최대 스레드 개수 3개


        executorService.execute(()->{
            for(int i=0;i<5;i++){
                bankAccount.deposit(300);
            }
        });

        executorService.execute(()->{
            for(int i=0;i<3;i++){
                bankAccount.withdraw(200);
            }
        });

        executorService.execute(()->{
            for(int i=0;i<3;i++){
                bankAccount.withdraw(400);
            }
        });

        executorService.execute(()->{
            for(int i=0;i<3;i++){
                bankAccount.withdraw(500);
            }
        });

        executorService.execute(()->{
            bankAccount.deposit(1000);
        });

        executorService.shutdown();
    }
}
