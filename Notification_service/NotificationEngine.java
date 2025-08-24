import java.util.ArrayList;
import java.util.List;

public class NotificationEngine implements IObserver {

    private List<INotificationStrategy> notificationStrategy;
    private NotificationObservable notificationObservable;

    //When no strategy is passed
    public NotificationEngine() {
        this.notificationObservable =  NotificationService.getInstance().getObservable();
        notificationObservable.addObserver(this);
    }

    public NotificationEngine(NotificationObservable notificationObservable) {
        this.notificationObservable = notificationObservable;
    }

    // To add new new notification strategy
    public void addNotificationStrategy(INotificationStrategy notificationStrategy) {
        if (this.notificationStrategy == null) {
            this.notificationStrategy = new ArrayList<>();
        }
        this.notificationStrategy.add(notificationStrategy);
    }

    public void update() {
        String content = notificationObservable.getNotificationContent();

        for (INotificationStrategy strategy : notificationStrategy) {
            strategy.sendNotification(content);
        }
    }
}