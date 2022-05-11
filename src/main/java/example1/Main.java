package example1;

public class Main {

    static final ThreadLocal<Integer> LOCAL = new ThreadLocal();

    public static void main(String[] args) {

        Runnable r1 = () -> {
            try {
                LOCAL.set(10);
                Thread.sleep(1000);
                System.out.println(LOCAL.get() +  " " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };


        Runnable r2= () -> {
            try {
               // LOCAL.set(20);
                Thread.sleep(1000);
                System.out.println(LOCAL.get() +  " " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(r1).start();
        new Thread(r2).start();
    }
}
