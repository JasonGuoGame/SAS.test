package hello.guardedblocks;

import hello.guardedblocks.Consumer;
import hello.guardedblocks.Drop;
import hello.guardedblocks.Producer;

/**
 * Created by scnyig on 5/13/2016.
 */
public class ProducerConsumerExample {
    public static void main(String[] args) {
        Drop drop = new Drop();
        (new Thread(new Producer(drop))).start();
        (new Thread(new Consumer(drop))).start();
    }
}
