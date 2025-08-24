public class EmailStrategy implements INotificationStrategy {

    private String emailId;

    public EmailStrategy(String emailId) {
        this.emailId = emailId;
    }

    public void sendNotification(String content) {
        System.out.println("Sending Email Notification: \n " + content + "\n to emailId: " + emailId);
    }
}