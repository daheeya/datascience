package middletest.student.post_;

import java.util.ArrayList;
import java.util.List;

public class Gallery {
    private String title;
    private String content;
    private String email;
    private List<Comment> comments;
    private Long idx; // long 이 아니라 객체 Long 을 쓴 이유 : 없으면 0이 아니라 null 이 되아야 하기 때문
    public Gallery(String email, String title, String content){
        this.title=title;
        this.email=email;
        this.content=content;
        comments=new ArrayList<>();
    }
    public void createComment(String email, String content){
        comments.add(new Comment(email,content));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return "Gallery{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", email='" + email + '\'' +
                ", comments=" + comments +
                ", idx=" + idx +
                '}';
    }
}
