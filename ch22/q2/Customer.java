package ch22.q2;

public class Customer {
    protected String id;
    protected String name;
    protected Grade grade;
    protected int point;
    protected int totalPayment;

    public Customer(String id, String name, Grade grade){
        this.id=id;
        this.name=name;
        this.grade=grade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public void purchase(int price){

    }
    public void setPoint(int price){

    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", point=" + point +
                '}';
    }

    public int getPoint() {
        return point;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(int totalPayment) {
        this.totalPayment = totalPayment;
    }
}
