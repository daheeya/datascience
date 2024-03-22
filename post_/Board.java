package middletest.student.post_;

import java.sql.Array;
import java.util.*;

public class Board {
    private Set<User> users;
    private List<Gallery> galleries;
    private String name;
    private static Long idx=0L;
    public Board(String name){
        users=new HashSet<>();
        galleries=new ArrayList<>();
    }
    public void createUser(String email){
        users.add(new User(email));
    }
    public void createGallery(String email, String title, String content){ // static을 뺀 이유: 보드객체가 있어야지만 갤러리를 생성할 수 있게 하기 위해
        var gallery = new Gallery(email, title,content);
        gallery.setIdx(idx++);
        galleries.add(gallery);
    }
    public Gallery findGallery(Long galleryIdx){
        for(var g : galleries){
            if(Objects.equals(g.getIdx(),galleryIdx)) return g;
        }
        return null;
    }
    public List<Gallery> findCommentsByEmail(String email){
        List<Gallery> findMyGalleryWithComment = new ArrayList<>();
        for( var g : galleries){
            for(var c: g.getComments()){
                if(Objects.equals(c.getEmail(),email)) {
                    findMyGalleryWithComment.add(g);
                    break;
                }
            }
        }
        return findMyGalleryWithComment;
    }

    @Override
    public String toString() {
        return "Board{" +
                "users=" + users +
                ", galleries=" + galleries +
                ", name='" + name + '\'' +
                '}';
    }
}
