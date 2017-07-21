package hello.systemdesign.dp;

/**
 * Created by scnyig on 7/21/2017.
 */
public class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton(){

    }

    public static Singleton getInstance() {
        return instance;
    }
}

class Singleton2 {
    private static Singleton2 instance;
    private Singleton2(){

    }

    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
