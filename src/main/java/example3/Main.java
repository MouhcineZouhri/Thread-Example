package example3;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        Runnable r1 = new Runn(cyclicBarrier);
        Runnable r2 = new Runn(cyclicBarrier);
        Runnable r3 = new Runn(cyclicBarrier);
        Runnable r4 = new Runn(cyclicBarrier);

        // r4 will be waiting (not  execute)

        ExecutorService service = Executors.newFixedThreadPool(4);

        service.submit(r1);
        service.submit(r2);
        service.submit(r3);
        service.submit(r4);

        service.shutdown();
    }
}
