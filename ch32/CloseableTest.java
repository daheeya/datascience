package ch32;

public class CloseableTest implements AutoCloseable{
    private int age;
    private String name;
    public CloseableTest(int age, String name){
        this.age=age;
        this.name=name;
    }
    @Override
    public void close() throws Exception {
        System.out.println("ClosealbeTest obj close()..");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        System.out.println(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class Main{
    public static void main(String[] args) {
        try(CloseableTest c = new CloseableTest(23, "dahee")){ // try-with-Resource : try 안에 리소스 값을 넣고 리소스를 명기하면 , 리소스가 사라질 때 AutoClose가 호출됨
            c.setAge(10);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
