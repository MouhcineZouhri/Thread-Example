package example2;

import java.util.concurrent.Semaphore;

public class Runn implements Runnable {

    private final Semaphore semaphore;


    public Runn(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();

            Thread.sleep(1000);
            System.out.println("nice " + Thread.currentThread().getName());

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            semaphore.release();
        }
    }
}
