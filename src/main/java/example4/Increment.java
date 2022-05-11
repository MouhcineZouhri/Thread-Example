package example4;

import java.util.concurrent.locks.ReadWriteLock;

public class Increment implements Runnable{

    private final ReadWriteLock readWriteLock;

    public Increment( ReadWriteLock readWriteLock){
        this.readWriteLock = readWriteLock;
    }



    @Override
    public void run() {
        readWriteLock.writeLock().lock();
        try {
            Thread.sleep(1000);
            Main.integer++;
            System.out.println("Increment " + Main.integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }

    }
}
