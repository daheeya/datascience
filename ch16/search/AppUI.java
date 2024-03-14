package ch16.search;

public class AppUI {
    public static void main(String[] args) {
        var service = new RepositoryService();
        service.addCustomer("toss@gmail.com");
        System.out.println(service.findCustomer ("toss@gmail.com"));
    }

}
