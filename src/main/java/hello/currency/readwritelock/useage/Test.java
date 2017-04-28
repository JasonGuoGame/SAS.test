package hello.currency.readwritelock.useage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by scnyig on 4/28/2017.
 */
public class Test {
    public static void main(String[] args) {
        //�����������ʵ��˻�
        MyCount myCount = new MyCount("95599200901215522", 10000);
        //����һ��������
        ReadWriteLock lock = new ReentrantReadWriteLock(false);
        //����һ���̳߳�
        ExecutorService pool = Executors.newFixedThreadPool(2);
        //����һЩ���������û���һ�����ÿ�����Ĵ棬ȡ��ȡ�������ְ�
        User u1 = new User("Jason", myCount, -4000, lock, false);
        User u2 = new User("Mary", myCount, 6000, lock, false);
        User u3 = new User("Rebecca", myCount, -8000, lock, false);
        User u4 = new User("Jason", myCount, 800, lock, false);
        User u5 = new User("Tom", myCount, 0, lock, true);
        //���̳߳���ִ�и����û��Ĳ���
        pool.execute(u1);
        pool.execute(u2);
        pool.execute(u3);
        pool.execute(u4);
        pool.execute(u5);
        //�ر��̳߳�
        pool.shutdown();
    }
}
