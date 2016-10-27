package hello.currency.produceconsume;

/**
 * Created by scnyig on 10/27/2016.
 */
public class Consumer implements Runnable {
    private Info info = null ;
    public Consumer(Info info){
        this.info = info ;
    }
    public void run(){
        for(int i=0;i<10;i++){
            this.info.get() ;
        }
    }
}
