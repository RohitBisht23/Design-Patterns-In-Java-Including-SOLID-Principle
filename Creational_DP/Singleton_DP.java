
class singleton {

    public static singleton instance = null;
    private  singleton() {
        System.out.println("New Object Created");
    }

    public static singleton getInstance() {
        if(instance == null) {
            synchronized (singleton.class) {
                instance = new singleton();
            }
        }
        return instance;
    }
}

public class Singleton_DP {
    public static void main(String[] args) {
        singleton s1 = singleton.getInstance();
        singleton s2 = singleton.getInstance();

        if(s1 == s2) {
            System.out.println("Same");
        }
    }
}
