package ch26;

interface Myjson{
    int age = 9;
    String printJson();

    default void upperString(){ // default method
        String text = printJson().toUpperCase();
        System.out.println(text);
    }
    default int jump(){
        go(); // private 클래스
        return 1;
    }
    static void myInter(){
        System.out.println(age+"my...");
    }
    private void go(){
        System.out.println("go");
    }
    private static void staticGo(){
        System.out.println("static go");
    }
}

class Impl implements Myjson{
    @Override
    public String printJson() {
        return "kim";
    }
}

class Impl2 implements Myjson{
    @Override
    public String printJson() {
        return "park";
    }
}

class Ma{
    public static void main(String[] args) {
        new Impl().upperString();
        System.out.println(new Impl().printJson());

        new Impl().jump();
        Myjson.myInter(); // static 이라서 이렇게도 접근이 된다.

    }
}

