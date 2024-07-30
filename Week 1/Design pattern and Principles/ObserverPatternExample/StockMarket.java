import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {
    private List<Observer> observers;
    private String stockUpdate;

    public StockMarket() {
        observers = new ArrayList<>();
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockUpdate);
        }
    }

    public void setStockUpdate(String stockUpdate) {
        this.stockUpdate = stockUpdate;
        notifyObservers();
    }
}
