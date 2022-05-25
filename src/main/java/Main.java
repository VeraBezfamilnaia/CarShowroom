public class Main {
    public static void main(String[] args) {
        CarShowroom carShowroom = new CarShowroom();

        new MyThread(null, carShowroom::acceptCar, "Продавец").start();
        new Thread(null, carShowroom::sellCar, "Покупатель1").start();
        new Thread(null, carShowroom::sellCar, "Покупатель2").start();
        new Thread(null, carShowroom::sellCar, "Покупатель3").start();
        new Thread(null, carShowroom::sellCar, "Покупатель4").start();
        new Thread(null, carShowroom::sellCar, "Покупатель5").start();
        new Thread(null, carShowroom::sellCar, "Покупатель6").start();
        new Thread(null, carShowroom::sellCar, "Покупатель7").start();
        new Thread(null, carShowroom::sellCar, "Покупатель8").start();
        new Thread(null, carShowroom::sellCar, "Покупатель9").start();
        new Thread(null, carShowroom::sellCar, "Покупатель10").start();
    }
}
