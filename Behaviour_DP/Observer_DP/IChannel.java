public interface IChannel {

    public void subscribe(ISubscriber subscriber);

    public void unsubscribe(ISubscriber subscriber);

    public void notifySubscribers();

    public String getLatestVideo();
}
