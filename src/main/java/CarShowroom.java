import java.util.ArrayList;
import java.util.List;

public class CarShowroom {
    private final List<Car> cars = new ArrayList<>();
    private final Seller seller = new Seller(this);

    public void acceptCar() {
        seller.acceptCar();
    }

    public void sellCar() {
        seller.sellCar();
    }

    public List<Car> getCars() {
        return cars;
    }
}
