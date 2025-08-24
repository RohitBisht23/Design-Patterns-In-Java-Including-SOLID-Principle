//Concrete Subject

import java.util.ArrayList;
import java.util.List;

class NotificationObservable implements IObserable {
    private List<IObserver> observers;

    private INotification currentNotification;

    public NotificationObservable() {
        observers = new ArrayList<>();
    }

    public void addObserver(IObserver observer) {
        if (observers.size() == 0) {
            observers = new ArrayList<>();
        }
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void removeObserver(IObserver observer) {
        if (!observers.contains(observer)) {
            Exception e = new Exception("Observer not found");
            e.printStackTrace();
        }
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update();
        }
    }

    public void setNotification(INotification notification) {
        if (notification == null) {
            Exception e = new Exception("Notification cannot be null");
            e.printStackTrace();
            return;
        }
        this.currentNotification = notification;
        notifyObservers();
    }

    public INotification getNotification() {
        return currentNotification;
    }

    public String getNotificationContent() {
        if (currentNotification == null) {
            return "No Notification";
        }
        return currentNotification.getContent();
    }
}