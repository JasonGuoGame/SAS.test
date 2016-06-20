package hello.guardedblocks;

/**
 * Created by scnyig on 5/13/2016.
 */
import hello.guardedblocks.Drop;

import java.util.Random;

public class Producer implements Runnable {
    private Drop drop;

    public Producer(Drop drop) {
        this.drop = drop;
    }

    public void run() {
        String importantInfo[] = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };
        Random random = new Random();

        for (int i = 0;i < importantInfo.length; i++) {
            System.out.println("producer waking up");
            drop.put(importantInfo[i]);
            try {
                int milssecond = random.nextInt(5000);
                System.out.println(milssecond);
//                Thread.sleep(milssecond);
            } catch (Exception e) {

            }
        }
        System.out.println("producer waking up put DONE");
        drop.put("DONE");
    }
}
