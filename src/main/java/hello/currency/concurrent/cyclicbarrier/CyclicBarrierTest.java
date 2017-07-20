package hello.currency.concurrent.cyclicbarrier;

/**
 * Created by scnyig on 11/2/2016.
 * http://wiki.jikexueyuan.com/project/java-concurrency/cyclicbarrier.html
 * cyclicbarrier 类似countdownlatch，希望创建一组任务，这组任务完成后再执行另外一个任务，可以多次出发另外的那个任务
 */
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    public static void main(String[] args) {
        //创建CyclicBarrier对象，
        //并设置执行完一组5个线程的并发任务后，再执行MainTask任务
        CyclicBarrier cb = new CyclicBarrier(5, new MainTask());
        new SubTask("A", cb).start();
        new SubTask("B", cb).start();
        new SubTask("C", cb).start();
        new SubTask("D", cb).start();
        new SubTask("E", cb).start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new SubTask("e", cb).start();
        new SubTask("f", cb).start();
        new SubTask("g", cb).start();
        new SubTask("h", cb).start();
        new SubTask("i", cb).start();
    }
}

/**
 * 最后执行的任务
 */
class MainTask implements Runnable {
    public void run() {
        System.out.println("......终于要执行最后的任务了......");
    }
}

/**
 * 一组并发任务
 */
class SubTask extends Thread {
    private String name;
    private CyclicBarrier cb;

    SubTask(String name, CyclicBarrier cb) {
        this.name = name;
        this.cb = cb;
    }

    public void run() {
        System.out.println("[并发任务" + name + "]  开始执行");
        for (int i = 0; i < 999999; i++) ;    //模拟耗时的任务
        System.out.println("[并发任务" + name + "]  开始执行完毕，通知障碍器");
        try {
            //每执行完一项任务就通知障碍器
            cb.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("[并发任务" + name + "]  同时执行");
    }
}
