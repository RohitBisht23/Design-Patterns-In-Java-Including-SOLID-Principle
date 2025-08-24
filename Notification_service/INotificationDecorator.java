//Decorators
public interface INotificationDecorator extends INotification {
    public static final INotification wrappee = null;

    public String getContent();
}
