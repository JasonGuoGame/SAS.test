package hello.currency.concurrent.cyclicbarrier;

import java.util.concurrent.CountDownLatch;

/**
 * Created by scnyig on 6/21/2017.
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start .........");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
                System.out.println("first thread finished job");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start second thread..........");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
                System.out.println("second thread finished job");
            }
        }).start();

        try {
            System.out.println("等待两个线程都要执行完");
            countDownLatch.await();
            System.out.println("执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
