package hello.guardedblocks;

/**
 * Created by scnyig on 5/13/2016.
 */

import java.util.Random;

public class Consumer implements Runnable {
    private Drop drop;

    public Consumer(Drop drop) {
        this.drop = drop;
    }

    public void run() {
        Random random = new Random();
        for (String message = drop.take();! message.equals("DONE");message = drop.take()) {
            System.out.println("consumer waking up");
            System.out.format("MESSAGE RECEIVED: %s%n", message);
            try {
                int milsconds = random.nextInt(5000);
                System.out.println(milsconds);
//                Thread.sleep(milsconds);
            } catch (Exception e) {
                System.out.println("consumer waking up");
            }
        }
    }
}
