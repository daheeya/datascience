package middletest.student.univ_mgr;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ClassMgr {
    private static ClassMgr INSTANCE; // final : final은 생성과 동시에 초기화를 해줘야 하기 때문에 없애자.
    private Set<ClassRoom> classes;
    private ClassMgr(){
        classes = new HashSet<>();
    }
    // 싱글톤
    public static synchronized ClassMgr getInstance() {
        if(INSTANCE==null) INSTANCE= new ClassMgr();
        return INSTANCE;
    }


    public void createClass(String name){
        classes.add(new ClassRoom(name));
    }
    public ClassRoom findClass(String name){
        for(var class_:classes) {
            if (Objects.equals(class_.getName(), name)) return class_;
        } return null;
    }


}
