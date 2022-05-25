public class Seller {
    private final int WAITING = 1500;
    private final int SOLD_CAR_INDEX = 0;
    private final CarShowroom carShowroom;

    public Seller(CarShowroom carShowroom) {
        this.carShowroom = carShowroom;
    }

    public synchronized void acceptCar() {
        try {
            printMessage("Продавец принимает новый авто");
            Thread.sleep(WAITING);
            carShowroom.getCars().add(new Car());
            printMessage("Прием нового авто завершен");
            notify();

        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public synchronized void sellCar() {
        try {
            printMessage("Покупатель зашел в автосалон " + Thread.currentThread());
            while (carShowroom.getCars().size() == 0) {
                printMessage("Пока что в автосалоне машин нет");
                wait();
            }
            Thread.sleep(WAITING);
            printMessage("Покупатель уехал на новеньком авто " + Thread.currentThread());
            carShowroom.getCars().remove(SOLD_CAR_INDEX);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
