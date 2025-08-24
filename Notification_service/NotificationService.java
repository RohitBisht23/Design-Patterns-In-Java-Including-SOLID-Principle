//Notification Service

import java.util.ArrayList;
import java.util.List;

class NotificationService {
    private NotificationObservable observable;
    static NotificationService instance = null;
    List<INotification> notifications;

    public NotificationService() {
        observable = new NotificationObservable();
    }

    public static NotificationService getInstance() {
        if (instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }

    // Expose the observable so ubservers can attach
    NotificationObservable getObservable() {
        return observable;
    }

    // Create a new Notification and notifies observers
    void sendNotification(INotification notification) {
        if (notifications == null) {
            notifications = new ArrayList<>();
        }
        notifications.add(notification);
        observable.setNotification(notification);
    }
}