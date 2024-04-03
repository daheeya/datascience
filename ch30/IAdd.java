package ch30;

public interface IAdd {
    int add(int x, int y); // 추상화 메소드가 하나여야지만 람다형 메소드를 사용 할 수 있다!
}

class Main_{
    public static void main(String[] args) {
        IAdd iAdd = new IAdd(){ // 익명클래스
            @Override
            public int add(int x, int y) {
                return x+y;
            }
        };
        System.out.println(iAdd.add(3,4));

        // 람다식으로 바꾸면
        IAdd iAdd1 = ((x, y) -> x+y);
        var result = iAdd1.add(3,5);
        System.out.println(result);
    }
}