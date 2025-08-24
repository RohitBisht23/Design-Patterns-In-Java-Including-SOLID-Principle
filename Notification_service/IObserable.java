//Subject interface

import java.util.ArrayList;
import java.util.List;

interface IObserable {
    List<IObserver> observers = new ArrayList<>();

    public void addObserver(IObserver observer);

    public void removeObserver(IObserver observer);

    public void notifyObservers();
}
