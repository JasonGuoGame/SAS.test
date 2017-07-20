package hello.currency.readwritelock;

/**
 * Created by scnyig on 4/28/2017.
 */
public class SampleReadWriteLock {
    private int readers = 0;
    private int writers = 0;
    private int writeRequests = 0;

    public synchronized void lockRead()
            throws InterruptedException{
        while(writers > 0 || writeRequests > 0){
            wait();
        }
        readers++;
    }

    public synchronized void unlockRead(){
        readers--;
        notifyAll();
    }

    /*
    * writeRequests 有请求写操作，就不能去读。否则会出现饥饿现象，一直读不能写。 writeRequest++后读锁就lock住不能继续读了
     */
    public synchronized void lockWrite()
            throws InterruptedException{
        writeRequests++;

        while(readers > 0 || writers > 0){
            wait();
        }
        writeRequests--;
        writers++;
    }

    /*
    * 用notifyall 不用 notify 是因为怕只唤醒了读锁，但是有writeRequest大于0，那么相当于没什么用。信号丢失
     */
    public synchronized void unlockWrite()
            throws InterruptedException{
        writers--;
        notifyAll();
    }
}
