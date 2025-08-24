//Concrete Observer
class Logger implements IObserver {
    private NotificationObservable notificationObservable;

    public Logger(NotificationObservable notificationObservable) {
        this.notificationObservable = notificationObservable;
    }

    public void update() {
        System.out.println("Looging New Notification : \n " + notificationObservable.getNotificationContent());
    }
}