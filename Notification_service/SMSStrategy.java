public class SMSStrategy implements INotificationStrategy {

    private String phoneNumber;

    public SMSStrategy(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void sendNotification(String content) {
        System.out.println("Sending SMS Notification: \n " + content + "\n to phone number: " + phoneNumber);
    }
}