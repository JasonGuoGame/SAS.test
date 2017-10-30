package hello.currency.sychronization;

/**
 * Created by scnyig on 10/23/2017.
 * 结果是：main thread b=1000
 *         b=1000
 *   或者: main thread b=2000
 *         b=1000
 * 主要看是main的步骤3先执行，还是m1先执行。如果m1先抢到cpu的资源执行，那么b就是1000了，如果main步骤3先执行那就是2000
 */
public class ImpleSynch implements Runnable {
    int b = 100;
    synchronized void m1() throws InterruptedException{
//        System.out.println("start m1");
        b = 1000;
        Thread.sleep(500);
//        System.out.println("end m1");
        System.out.println("b="+b);
    }

    synchronized void m2() throws InterruptedException{
//        System.out.println("start m2");
        Thread.sleep(250);
        b = 2000;
//        System.out.println("end m2");
    }

    public static void main(String[] args) throws InterruptedException{
        ImpleSynch tt = new ImpleSynch();
        Thread t = new Thread(tt);
        t.start();//1
        tt.m2();//2
        System.out.println("main thread b=" + tt.b);//3
    }

    @Override
    public void run() {
        try {
            m1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
