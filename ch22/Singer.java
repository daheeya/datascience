package ch22;

public class Singer extends Person{
    private String bandName;
    public Singer(String name,int age, String bandName){
        super(name,age);
        this.bandName=bandName;
        System.out.println("Singer, bandName: "+ bandName);
    }

    public void singing(){
        System.out.println("singing");
    }
}

