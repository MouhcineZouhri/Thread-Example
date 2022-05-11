package example3;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Runn implements Runnable {

    private final CyclicBarrier cyclicBarrier;

    public Runn(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }


    @Override
    public void run() {
        try {
            cyclicBarrier.await();

            Thread.sleep(1000);
            System.out.println("nice " + Thread.currentThread().getName());

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
