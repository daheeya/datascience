package ch27;

public class Book {
    private String title;
    private Author author;

    public Book( String title, Author author){
        this.author=author;
        this.title=title;
    }
    public void something(){

    }

    // 하지만 속성이 많다면 외부로 빼는게 더 효율적이다. 왜냐하면 static 이니까!
    public static class Author{
        private String name;
        private String addr;


        public void something(){

        }
    }
}

class Main_ {
    public static void main(String[] args) {
        Book.Author dahee = new Book.Author();
        dahee.something();

        Book book = new Book("title", dahee);
    }
}