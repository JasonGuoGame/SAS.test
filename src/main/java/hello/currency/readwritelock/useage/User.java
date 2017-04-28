package hello.currency.readwritelock.useage;

import java.util.concurrent.locks.ReadWriteLock;

/**
 * Created by scnyig on 4/28/2017.
 */
public class User implements Runnable {
    private String name;                 //用户名
    private MyCount myCount;         //所要操作的账户
    private int iocash;                 //操作的金额，当然有正负之分了
    private ReadWriteLock myLock;                 //执行操作所需的锁对象
    private boolean ischeck;         //是否查询

    User(String name, MyCount myCount, int iocash, ReadWriteLock myLock, boolean ischeck) {
        this.name = name;
        this.myCount = myCount;
        this.iocash = iocash;
        this.myLock = myLock;
        this.ischeck = ischeck;
    }

    public void run() {
        if (ischeck) {
            //获取读锁
            myLock.readLock().lock();
            System.out.println(name + " is checking " + myCount + " account, and count is " + myCount.getCash());
            //释放读锁
            myLock.readLock().unlock();
        } else {
            //获取写锁
            myLock.writeLock().lock();
            //执行现金业务
            System.out.println("" + name + " operating " + myCount + " account, count is " + iocash +", currently is " + myCount.getCash());
            myCount.setCash(myCount.getCash() + iocash);
            System.out.println("" + name + " save " + myCount + " successful, the count is " + iocash +", currently is " + myCount.getCash());
            //释放写锁
            myLock.writeLock().unlock();
        }
    }
}
