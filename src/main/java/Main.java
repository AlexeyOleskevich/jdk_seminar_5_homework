import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Fork[] forks = new Fork[5];
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Fork(i + 1);
        }

        CountDownLatch cdl = new CountDownLatch(5);

        Philosopher[] philosophers = new Philosopher[5];
        for (int i = 0; i < philosophers.length; i++) {
            philosophers[i] = new Philosopher("philosopher" + i, forks[i],
                    forks[(i + 1) % philosophers.length], cdl);
            philosophers[i].start();
        }

        cdl.await();
        System.out.println("All the philosophers have eaten!");

    }
}
