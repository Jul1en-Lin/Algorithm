public class MyThread {
    public static final Object locker1 = new Object();
    public static final Object locker2 = new Object();
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (locker1) {
                synchronized (locker2) {
                    try {
                        System.out.println("t1");
                        locker1.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (locker2) {
                synchronized (locker1) {
                    try {
                        System.out.println("t2");
                        locker2.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
