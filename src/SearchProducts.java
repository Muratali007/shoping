import java.util.ArrayList;
import java.util.List;

public class SearchProducts implements IObservable {
    List<String> products = new ArrayList<>();

    List<IObserver> subscribers = new ArrayList<>();

    public void addProducts(String products){
        this.products.add(products);
        notifyObservers();
    }
    public void removeProducts(String products){
        this.products.remove(products);
        notifyObservers();
    }
    @Override
    public void addObserver(IObserver observer) {
        this.subscribers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        this.subscribers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(IObserver observer : subscribers){
            observer.handleEvent(this.products);
        }
    }
}

