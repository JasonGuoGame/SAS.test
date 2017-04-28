package hello.currency.readwritelock.useage;

import java.util.concurrent.locks.ReadWriteLock;

/**
 * Created by scnyig on 4/28/2017.
 */
public class User implements Runnable {
    private String name;                 //�û���
    private MyCount myCount;         //��Ҫ�������˻�
    private int iocash;                 //�����Ľ���Ȼ������֮����
    private ReadWriteLock myLock;                 //ִ�в��������������
    private boolean ischeck;         //�Ƿ��ѯ

    User(String name, MyCount myCount, int iocash, ReadWriteLock myLock, boolean ischeck) {
        this.name = name;
        this.myCount = myCount;
        this.iocash = iocash;
        this.myLock = myLock;
        this.ischeck = ischeck;
    }

    public void run() {
        if (ischeck) {
            //��ȡ����
            myLock.readLock().lock();
            System.out.println(name + " is checking " + myCount + " account, and count is " + myCount.getCash());
            //�ͷŶ���
            myLock.readLock().unlock();
        } else {
            //��ȡд��
            myLock.writeLock().lock();
            //ִ���ֽ�ҵ��
            System.out.println("" + name + " operating " + myCount + " account, count is " + iocash +", currently is " + myCount.getCash());
            myCount.setCash(myCount.getCash() + iocash);
            System.out.println("" + name + " save " + myCount + " successful, the count is " + iocash +", currently is " + myCount.getCash());
            //�ͷ�д��
            myLock.writeLock().unlock();
        }
    }
}
