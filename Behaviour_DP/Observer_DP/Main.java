//Observer desgin pattern
class Main {
    public static void main(String[] args) {
        Channel channel = new Channel("Tech Channel");
        Subscriber subscriber1 = new Subscriber("Alice", channel);
        Subscriber subscriber2 = new Subscriber("Bob", channel);

        channel.subscribe(subscriber1);
        channel.subscribe(subscriber2);

        channel.uploadVideo("Observer Pattern in Java");

        channel.unsubscribe(subscriber1);
        channel.uploadVideo("Singleton Pattern in Java");

    }
}