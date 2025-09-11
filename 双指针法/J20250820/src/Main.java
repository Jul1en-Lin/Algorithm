import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main2(String[] args) throws InterruptedException {
        AtomicInteger n = new AtomicInteger(0);
        Object locker = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (locker) {
                for (int i = 0; i < 100; i++) {
                    n.getAndIncrement();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (locker) {
                for (int i = 0; i < 100; i++) {
                    n.getAndIncrement();
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(n);
    }
    public static void main1(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new Callable<Integer>() {
            int sum = 0;
            @Override
            public Integer call() throws Exception {
                for (int i = 1; i <= 1000; i++) {
                    sum += i;
                }
                return sum;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread t = new Thread(futureTask);
        t.start();
        System.out.println(futureTask.get());
    }
}