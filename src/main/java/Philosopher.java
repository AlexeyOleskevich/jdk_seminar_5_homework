import java.util.concurrent.CountDownLatch;

public class Philosopher extends Thread{
    private String name;
    private Fork leftFork;
    private Fork rightFork;
    private CountDownLatch cdl;
    private int countEat;


    public Philosopher(String name, Fork leftFork, Fork rightFork, CountDownLatch cdl) {
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.cdl = cdl;
    }

    @Override
    public void run() {
        while (countEat < 3) {
            try {
                eat();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(name + " ate 3 times!");
        cdl.countDown();
    }

    private void eat() throws InterruptedException {
        if (leftFork.getAvailable() && rightFork.getAvailable()) {
            leftFork.setAvailable(false);
            rightFork.setAvailable(false);
            System.out.println(name + " starts to eat using forks " + leftFork + " and " + rightFork + ".");
            Thread.sleep((long)(Math.random() * 1000));
            System.out.println(name + " has just eaten.");
            leftFork.setAvailable(true);
            rightFork.setAvailable(true);
            think();
            countEat++;
        }

    }

    private void think() throws InterruptedException {
        System.out.println(name + " is thinking...");
        Thread.sleep((long)(Math.random() * 1000));
    }
}
