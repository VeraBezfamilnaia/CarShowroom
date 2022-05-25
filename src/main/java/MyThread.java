public class MyThread extends Thread {
    private int counter = 0;
    private final Runnable target;

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
       this.target = target;
    }

    @Override
    public void run() {
        while (counter < 10) {
            target.run();
            counter++;
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ignore) {}
        }
    }
}
