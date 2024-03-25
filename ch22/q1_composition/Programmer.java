package ch22.q1_composition;

public class Programmer {
    private Person person; // (합성) 참조 변수
    public Programmer(Person person){ //생성자 오버로딩 필수
        this.person=person;
        System.out.println("Programmer ()");
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void coding(){

        System.out.println("coding");
    }
}
