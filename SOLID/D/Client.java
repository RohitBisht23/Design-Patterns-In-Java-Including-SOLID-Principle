
interface Persistance {
    void save();
}

class Application {
    Persistance p; //Dependecy injection
    public Application(Persistance p) {
        this.p = p;
    }

    public void storeData() {
        p.save();
    }
}

class SqlSB implements Persistance{
    public void save() {
        System.out.println("Data is saved into MYSQL.");
    }
}

class MongoDB implements Persistance {
    public void save() {
        System.out.println("Data is saved into MONGODB.");
    }
}


class Client {
    public static void main(String[] args) {
        Application app = new Application(new MongoDB());
        app.storeData();
    }
}