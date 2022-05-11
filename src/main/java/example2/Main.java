package example2;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReadWriteLock;

public class Main {

    /*
        Block Object .

        1 - synchronized keyword
        2 - Semaphore
        3 - CyclicBarrier
        4 - ReadWriteLock
        5 - CountDownLatch

     */

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);

        Runnable r1 =  new Runn(semaphore);
        Runnable r2 =  new Runn(semaphore);
        Runnable r3 =  new Runn(semaphore);
        Runnable r4 =  new Runn(semaphore);

        ExecutorService service = Executors.newFixedThreadPool(4);

        service.submit(r1);
        service.submit(r2);
        service.submit(r3);
        service.submit(r4);

        service.shutdown();

    }
}
