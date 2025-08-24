//Concrete Observer

class Logger implements IObserver {
    private NotificationObservable notificationObservable;

    //When no observable is passed
    public Logger() {
        this.notificationObservable =  NotificationService.getInstance().getObservable();
        notificationObservable.addObserver(this);
    }

    public Logger(NotificationObservable notificationObservable) {
        this.notificationObservable = notificationObservable;
    }

    public void update() {
        System.out.println("Looging New Notification : \n " + notificationObservable.getNotificationContent());
    }
}