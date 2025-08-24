//Decorator to add a timestamp the content
class TimeStamDecorator implements INotificationDecorator {
    protected INotification wrappee;

    public TimeStamDecorator(INotification wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public String getContent() {
        return wrappee.getContent() + " [Time: " + System.currentTimeMillis() + "]";
    }
}
