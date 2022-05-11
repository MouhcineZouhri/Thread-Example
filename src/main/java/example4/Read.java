package example4;

import java.util.concurrent.locks.ReadWriteLock;

public class Read implements Runnable {

    private final ReadWriteLock readWriteLock;

    public Read(ReadWriteLock readWriteLock) {
        this.readWriteLock = readWriteLock;
    }

    @Override
    public void run() {
        readWriteLock.readLock().lock();
        try {
            Thread.sleep(1000);
            System.out.println("Number " + Main.integer);
            readWriteLock.readLock().unlock();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
