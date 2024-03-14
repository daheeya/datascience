package ch16.search;


import ch16.search.Customer;
import ch16.search.Repository;

public class RepositoryService {

    public void addCustomer(String email){
        Repository.addCustomer(email);
    }
    public void addCustomer(String email,String name){
        Repository.addCustomer(email,name);
    }

    public Customer findCustomer(String email){
        return Repository.findCustomer(email);
    }
}
