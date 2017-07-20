package hello.currency.spinlock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by scnyig on 7/20/2017.
 */
public class ReentrantSpinLock {

    private static int count = 0;
    private static AtomicReference<Thread> ar = new AtomicReference<>();

    public void lock() {
        Thread thread = Thread.currentThread();
        if (thread == ar.get()) {
            count += 1;
            return ;
        } else {
            while (!ar.compareAndSet(null, thread)) {
                System.out.println("wait lock release " + Thread.currentThread().getName());
            }
        }
    }

    public void unlock() {
        Thread thread = Thread.currentThread();
        if (thread == ar.get()) {
            if (count > 0 ) {
                count = count-- ;
            } else {
                ar.compareAndSet(ar.get(), null);
            }
        }
    }
}
