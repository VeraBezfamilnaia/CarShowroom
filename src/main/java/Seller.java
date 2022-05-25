import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Seller {
    private final Lock lock = new ReentrantLock(true);
    private final Condition condition = lock.newCondition();
    private final int WAITING = 1500;
    private final int SOLD_CAR_INDEX = 0;
    private final CarShowroom carShowroom;

    public Seller(CarShowroom carShowroom) {
        this.carShowroom = carShowroom;
    }

    public void acceptCar() {
        lock.lock();
        try {
            printMessage("Продавец принимает новый авто");
            Thread.sleep(WAITING);
            carShowroom.getCars().add(new Car());
            printMessage("Прием нового авто завершен");
            condition.signal();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void sellCar() {
        lock.lock();
        try {
            printMessage("Покупатель зашел в автосалон " + Thread.currentThread());
            while (carShowroom.getCars().size() == 0) {
                printMessage("Пока что в автосалоне машин нет");
                condition.await();
            }
            Thread.sleep(WAITING);
            printMessage("Покупатель уехал на новеньком авто " + Thread.currentThread());
            carShowroom.getCars().remove(SOLD_CAR_INDEX);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
