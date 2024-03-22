package middletest.student.post_;

public class AppUI {
    public static void main(String[] args) {
        var board = new Board("보드1");
        board.createUser("dahee@gmail.com");
        board.createUser("dahee@naver.com");

        board.createGallery("dahee@gmail.com","집가고 싶다.", "오늘따라 힘들어요.");// 화면에서 이미 이 이메일을 알기 때문에 그냥 이메일로 줄 수 있따.

        board.findGallery(0L).createComment("dahee@naver.com","나도"); // 이미 idx는 화면에서 당연히 알고 있음(숨겨져있음)

        System.out.println(board.findCommentsByEmail("dahee@naver.com"));
    }
}
