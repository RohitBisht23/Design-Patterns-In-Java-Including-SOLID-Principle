import java.util.ArrayList;
import java.util.List;

public class Channel implements IChannel {
    private List<ISubscriber> subscribers;
    private String name;
    private String latestVideo;

    public Channel(String name) {
        this.name = name;
        this.subscribers = new ArrayList<>(); // Initialize the list here
    }

    @Override
    public void subscribe(ISubscriber subscriber) {
        if (subscribers.size() == 0 || subscribers == null) {
            subscribers = new ArrayList<>();
        }
        if (subscribers.contains(subscriber)) {
            Exception e = new Exception("Subscriber already exists");
            return;
        }

        subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(ISubscriber subscriber) {
        if (subscribers.size() <= 0) {
            Exception e = new Exception("No subscribers to remove");
            return;
        }
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {
        for (ISubscriber subscriber : subscribers) {
            subscriber.update();
        }
    }

    public void uploadVideo(String videoName) {
        this.latestVideo = videoName;
        System.out.println("New video uploaded: " + videoName);
        notifySubscribers();
    }

    public String getLatestVideo() {
        return latestVideo;
    }

}
