package example4;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

    static Integer integer = 0;

    public static void main(String[] args) {

        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        new Thread(new Read(readWriteLock)).start();

        new Thread(new Increment(readWriteLock)).start();

        new Thread(new Read(readWriteLock)).start();
        new Thread(new Read(readWriteLock)).start();
        new Thread(new Read(readWriteLock)).start();



    }
}
