package hello.core.singletom;

public class SingletonPattern {

    private static final SingletonPattern instance = new SingletonPattern();

    public static SingletonPattern getInstance(){
        return instance;
    }

    private SingletonPattern(){

    }
}



