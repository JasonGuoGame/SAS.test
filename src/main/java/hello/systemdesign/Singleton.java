package hello.systemdesign;

/**
 * Created by scnyig on 7/21/2017.
 */
public class Singleton {
    private static final Singleton instance = new Singleton();
    private Singleton(){

    }

    public static Singleton getInstance() {
        return instance;
    }
}

class Singleton2 {
    private static volatile Singleton2 instance;
    private Singleton2(){

    }

    public static Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}

enum Singletion3{
    INSTANCE;
    Singletion3 getInstance() {
        return INSTANCE;
    }
}
