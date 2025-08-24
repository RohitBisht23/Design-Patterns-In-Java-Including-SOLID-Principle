

public class NotificationSystem {
    public static void main(String[] args) {
        //Create Notification Service
        NotificationService notificationService = NotificationService.getInstance();

        // //Create Observable
        // NotificationObservable notificationObservable = notificationService.getObservable();

        // //Create Observers
        // Logger logger = new Logger(notificationObservable);
        Logger logger = new Logger();
        //Create NotificationEngine observers
        NotificationEngine notificationEngine = new NotificationEngine();

        notificationEngine.addNotificationStrategy(new EmailStrategy("rohit.bisht@insurancedekho.com"));
        notificationEngine.addNotificationStrategy(new SMSStrategy("9876543210"));
        notificationEngine.addNotificationStrategy(new PopupStrategy());


     

        //Create a simple notification with decorators
        INotification notification1 = new SimpleNotification("Your order has been placed successfully!");
        notification1 = (INotification) new TimeStamDecorator(notification1);
        notification1 = (INotification) new SignatureDecorator(notification1);  

        notificationService.sendNotification(notification1);
    }
}