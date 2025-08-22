//Observer desgin pattern

import java.util.ArrayList;
import java.util.List;

public class Subscriber implements ISubscriber {
    private String name;
    private IChannel channel;

    public Subscriber(String name, IChannel channel) {
        this.name = name;
        this.channel = channel;
    }

    @Override
    public void update() {
        System.out.println("Hey " + name + ", new video uploaded: " + channel.getLatestVideo());
    }
}


