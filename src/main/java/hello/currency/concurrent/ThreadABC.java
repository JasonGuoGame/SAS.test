package hello.currency.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by scnyig on 1/18/2018.
 */
public class ThreadABC {
    private static int state = 0;

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                while (state <= 30) {
                    lock.lock();
                    if (state%3==0) {
                        System.out.println("A");
                        state++;
                    }

                    lock.unlock();
                }
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                while (state <= 30) {
                    lock.lock();
                    if (state%3==1) {
                        System.out.println("B");
                        state++;
                    }
                    lock.unlock();
                }
            }
        });

        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                while (state<=30) {
                    lock.lock();
                    if (state%3==2) {
                        System.out.println("C");
                        state++;
                    }
                    lock.unlock();
                }
            }
        });

        a.start();
        b.start();
        c.start();
    }
}
