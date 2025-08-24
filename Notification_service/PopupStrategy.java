public class PopupStrategy implements INotificationStrategy {

    public void sendNotification(String content) {
        System.out.println("Showing Popup Notification: \n " + content);
    }
}