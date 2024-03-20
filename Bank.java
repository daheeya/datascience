package ch20;

import java.util.*;

public class Bank {

    // 2. 타 객체가 Bank를 여러번 생성 가능하기에 생성자 함수는 Singletone으로 구현함이 좋다.
    private static Bank bank;//
    private String name;
    private Set<Customer> customers;
    // account 수정후, 은행이 계좌를 가지니까 !
    private Set<Account> accounts;

    // 1. 생성자 함수가 없다.
    private Bank(String name){
        this.name=name;
        customers = new HashSet<>(); // 5. 이동 . customers 초기화.
        accounts=new HashSet<>();
    }
    public static Bank getInstance(){
        if(bank==null) bank=new Bank("한국은행");
        return bank;
    }//

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

//    public Bank(){
//        customers = new HashSet<>();
//
//    }

    public void registerCustomer(Customer customer) {
        customers.add(customer);
        System.out.println(name + "에 고객등록이 완료 되었습니다.");
    }
    // 7.
    public String openAccount(int money){
        var account = new Account ("000-0000-0000", money);
        accounts.add(account);

        return account.accountNum;
    }
    //

    // 9.
    public int deposit(String accountNum, int money){
        var find = findAccount(accountNum);
        if(find!=null) findAccount(accountNum).deposit(money);
        return 0;// 해당 객체 찾기
    }

    // 8. 같은 계좌 번호면 true 가 반환
    private Account findAccount(String accountNum){
        for(var account: accounts){
            if(account.accountNum.equals(accountNum)) return account;
        }
        return null;
    }

    // 16.
    public void showAccountInfo(String accountNum){
        for(var account: accounts){
            if(account.accountNum.equals(accountNum)) System.out.println(account);;
        }
    }

    // 3. inner class, private 로 숨기기
    private static class Account {
        private String accountNum;
        private int totalmoney;
        // 9. 입출금 내역 저장
        private String[] histories;
        // 10. 입출금 내역 배열 인덱스 필요
        private int historyIndex;

        // 4. 생성자 함수 !
        private Account (String accountNum,int money){
            this.accountNum = accountNum;
            this.totalmoney = money;
            // 11. 추가.
            histories=new String[10];
        }

        // 9,12. 입금+history 추가
        private int deposit(int money){
            totalmoney+=money;
            histories[historyIndex++]=new Date().toString()+": "+ money + "입금";
            return totalmoney;
        }

        // 13. 출금
        private void withdraw(int money){
            totalmoney-=money;
            histories[historyIndex++]=new Date().toString()+": "+ money + "출금";
        }
        // 15. 히스토리 보기
        public void showHistories(){
            System.out.println(Arrays.toString(histories));
            System.out.println("=====================");
            System.out.println("현재 잔고는: "+totalmoney);

        }

        // 6. 계좌를 set 할 필요가 없다.(은행에서 계좌를 set 하기 때문)
//        public void setTotalmoney(int totalmoney) {
//            this.totalmoney = totalmoney;
//        }

        // 얘도 마찬가지. inner 클래스라서 get 필요 x
//        public int getTotalmoney() {
//            return totalmoney;
//        }

        // 얘도 마찬가지.
//        public void setAccountNum(String accountNum) {
//            this.accountNum = accountNum;
//        }

        // inner 클래스라서 겟도 필요없다.
//        public String getAccountNum() {
//            return accountNum;
//        }

//        @Override
//        public String toString() {
//            return "Account{" +
//                    "accountNum='" + accountNum + '\'' +
//                    '}';
//        }
//
//        @Override
//        public boolean equals(Object obj) {
//            return Objects.equals(accountNum, ((Account)obj).accountNum);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(accountNum);
//        }
    }
//    public void printAllCustomers() {
//        if (customers.isEmpty()) {
//            System.out.println("등록된 고객 정보가 없습니다.");
//            return;
//        }
//
//        for (Customer customer : customers) {
//            Account account = customer.getAccount();
//            System.out.println("고객 이름: " + customer.getName());
//            System.out.println("계좌 번호: " + account.getAccountNum());
//            System.out.println("통장 잔고: " + account.getTotalmoney() + "원");
//            System.out.println("--------------------");
//        }
//    }
//    public void printCustomerAccount(String customerName) {
//        for (Customer customer : customers) {
//            if (customer.getName().equals(customerName)) {
//                Account account = customer.getAccount();
//                System.out.println("고객 이름: " + customer.getName());
//                System.out.println("계좌 번호: " + account.getAccountNum());
//                System.out.println("통장 잔고: " + account.getTotalmoney() + "원");
//            } else  System.out.println("일치하는 고객 정보가 없습니다.");
//        }
//    }
//    public boolean checkCustomerRegistered(Customer customer) {
//        return customers.contains(customer);
//    }
//    public boolean checkAccountNumberDuplicate(String accountNum) {
//        for (Customer customer : customers) {
//            if (customer.getAccount() != null && customer.getAccount().getAccountNum().equals(accountNum)) {
//                return true;
//            }
//        }
//        return false;
//    }

}

// 14. 타 은행에서 돈을 뽑을 때
final class Transaction{
    public static String openAccount(int money){
        return Bank.getInstance().openAccount(money);
    }

    // 주의 : 반환형 int deposit() 반환형 다 int
    public static int deposit(String accountNum, int money){
        return Bank.getInstance().deposit(accountNum,money);
    }
    //17.
    public static void showMyAccountHistory(String accountNum){
        Bank.getInstance().showAccountInfo(accountNum);
    }
} // account 는 중요한 객체라서 .!!

class Customer {
    private String name; // Customer 이름
    private String idNumber; // Customer 주민번호
    private int money; // Customer 주머니 돈
    // 26. 주머니 돈은 이해하기 좀 어려우니까
    private int balance; // customer 계좌 잔고.

    //18. Account를 직접적으로 가지는 것 보다 더 세이프
    private String accountNum; // Customer의 계좌

    //19. 생성자함수는 위로
    public Customer(String name, String idNumber) {
        this.name = name;
        this.idNumber = idNumber;
    }

    //20. String 으로 수정
    public void setAccount(String account) {
        this.accountNum = account;
    }


    // Setter start
    public void setName(String name) {
        this.name = name;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    // Setter end

    // Getter start
    public String getName() {
        return name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public int getMoney() {
        return money;
    }

    //21. 주석처리
//    public Account getAccount() {
//        return account;
//    }
// Getter end


//    @Override
//    public String toString() {
//        return "Customer{" +
//                "name='" + name + '\'' +
//                ", idNumber='" + idNumber + '\'' +
//                ", money=" + money +
//                ", accountNum=" + Bank.getInstance().getAccountNum() +
//                '}';
//    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(this.idNumber, ((Customer)obj).idNumber)
                && Objects.equals(this.name, ((Customer)obj).name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, idNumber);
    }
    // 22. 수정 (예외처리는 은행에서!)

//    public void openAccount(String accountNum, Bank bank) {

//        if (!bank.checkCustomerRegistered(this)) {
//            System.out.println("Bank 회원으로 등록되어 있지 않습니다. 먼저 회원으로 등록해주세요.");
//            return;
//        }
//
//        if (bank.checkAccountNumberDuplicate(accountNum)) {
//            System.out.println("이미 존재하는 계좌 번호입니다. 계좌 생성에 실패했습니다.");
//        }
//        else {
//            System.out.println("계좌가 개설 되었습니다. 통장 잔고 : 0원");
//            Account account = new Account();
//            account.setAccountNum(accountNum);
//            this.setAccount(account);
//            this.money -= 1000; // 계좌 개설 비용 1000원
//            System.out.println("계좌 개설 비용 1000원이 차감되었습니다.");
//            System.out.println("현재 주머니에 " + this.money + "원이 있습니다.");

//        }

    //23. 수정 account 를 호출하고 끝.
    public void openAccount(int money){
        accountNum=Transaction.openAccount(money); // transaction 통해서 !
    }

    //24. 아직 구현안해서 주석처리
//    public void withdrawMoney(Account account,int money) { // 인출
//        if (account.getTotalmoney() < money) {
//            System.out.println("통장 잔고가 부족합니다. 통장 잔고 : " + account.getTotalmoney());
//        }
//        else {
//            account.setTotalmoney(account.getTotalmoney() - money); // 인출한 금액만큼 계좌금액 감소
//            this.money += money; // 인출한 만큼 money 증가
//            System.out.println("계좌번호 " + account.getAccountNum() + "에서 " + money + "원 인출되었습니다.");
//            System.out.println("남은 통장 잔고 : " + account.getTotalmoney() + "원");
//            System.out.println();
//            System.out.println("_____________________________");
//        }
//    }

    // 25. 파라미터 money 만 받아오면 됨,
//    public void depositMoney(Account account, int money){
    public  void depositMoney(int money) { // 입금
        // 25. 고객의 동작과는 크게 관계가 없을 것 같으므로
//        if (this.money < money) {
//            System.out.println("주머니의 돈이 부족합니다. 현재 주머니에는 " + this.money + "원이 있습니다.");
//        }
//        else {
//            account.setTotalmoney(account.getTotalmoney() + money); // 입금한 금액만큼 계좌금액 증가
//            this.money -= money; // 입금한 금액만 큼  money 감소
//            System.out.println("계좌번호 " + account.getAccountNum() + "으로 " + money + "원 입금되었습니다.");
//            System.out.println("남은 통장 잔고 : " + account.getTotalmoney() + "원");
//            System.out.println();
//            System.out.println("_____________________________");
//        }
        //26. 트랜잭션 통해서 !
        balance=Transaction.deposit(accountNum,money);

    }
    public void printMoney() {
//        System.out.println("현재 내 주머니에는 " + balance + "원이 있습니다"); // 현재 소지 금액 출력
        Transaction.showMyAccountHistory(accountNum);
    }
}

class Main {
    public static void main(String[] args) {
//        Bank bank = new Bank(); // Bank 객체 생성
//        bank.setName("한국은행");; // Bank 이름 "한국은행"
//        Customer customer1 = new Customer("pyo", "123456-0000000"); // Customer 객체 생성
//        bank.registerCustomer(customer1); // 고객등록
//        customer1.setMoney(10000);
//        customer1.openAccount("000-0000-0000", bank);
//        customer1.depositMoney(customer1.getAccount(), 3000); // 입급
//        customer1.withdrawMoney(customer1.getAccount(), 2000); // 출금
//        customer1.printMoney(); // 주머니 속 돈 확인
//
//
//        Customer customer2 = new Customer("kavin", "123456-0000001");

        Customer pyo = new Customer("pyo","1234-1324");
        pyo.openAccount(10000);
        pyo.depositMoney(2000);
        pyo.printMoney();




        // *************** Test ***************//

        //  Test1 - 고객등록은 되었지만 같은 계좌번호가 이미 있을 경우
        // bank.registerCustomer(customer2);
        // customer2.openAccount("000-0000-0000",bank);


        // Test 2 - 고객등록 되어있지 않을 경우
        // customer2.openAccount("000-0000-0001", bank);

        // Test 3 - 돈이 부족하거나 통잔잔고가 부족할 때
        // customer1.withdrawMoney(customer1.getAccount(), 1000000);
        // customer1.depositMoney(customer1.getAccount(), 1000000);


        // bank.printAllCustomers(); // 등록된 모든 고객정보 출력
        // bank.printCustomerAccount("pyo"); // 고객이름으로 등록 된 고객 중 원하는 고객의 정보 출력
    }
}
