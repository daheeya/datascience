package ch18.HandsOn;

import java.util.Objects;

public class Customer {
    // 속성 은닉
    private String name;
    private String email;
    private String nickname;
    private String address;

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.email,this.name);
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(this.email,((Customer)obj).email) && Objects.equals(this.name,((Customer)obj).name);
    }// 같은 이메일의 사람이 두명일 때

    public Customer(String email, String name){
        this.email=email;
        this.name=name;
        nickname=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
