package ch20.thread_.bankhandson;

public class KoreaBank {
    private KoreaBank(){}
    private static KoreaBank INSTANCE;
    private String accountNum;
    public static synchronized KoreaBank getInstance(){
        if(INSTANCE==null) INSTANCE= new KoreaBank();
        return INSTANCE;
    }

    public Account createAccount(Customer customer, String accountNum){
        return new Account(customer,accountNum);
    }
}
