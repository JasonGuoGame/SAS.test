package hello.currency.spinlock;

/**
 * Created by scnyig on 7/20/2017.
 */
public class SpinLockDemo {
    public static void main(String[] args) {
        ReentrantSpinLock spinLock = new ReentrantSpinLock();
        for (int i = 0; i < 10; i++) {
            new ThreadTask(spinLock).start();
        }
    }
}

class ThreadTask extends Thread {
    private final ReentrantSpinLock spinLock;

    ThreadTask(ReentrantSpinLock spinLock) {
        this.spinLock = spinLock;
    }

    public void run () {
        this.spinLock.lock();

        long startTime = System.currentTimeMillis();
        System.out.println("开始往这个buff写入数据…");
        for (;;)// 模拟要处理很长时间
        {
            if (System.currentTimeMillis()
                    - startTime > Integer.MAX_VALUE) {
                break;
            }
        }
        System.out.println("终于写完了");
        System.out.println();

        this.spinLock.unlock();
    }
}

