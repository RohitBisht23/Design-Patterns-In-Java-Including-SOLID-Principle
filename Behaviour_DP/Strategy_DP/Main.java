//Strategy Design Pattern
//It define the family of algorithms, puts them in separate classes so that 
//they can be changed at run time.
interface Walkable {
    public String walk();
}


class normalWalk implements Walkable {
    public String walk() {
        return "This is normal walk";
    }
}

class fastWalk implements Walkable {
    public String walk() {
        return "Fast walk";
    }
}


interface Talkable {
    public String talk();
}

class normalTalk implements Talkable {
    public String talk() {
        return "Normal Talk";
    }
}

class extraTalk implements Talkable {
    public String talk() {
        return "Extra talk";
    }
}

interface Flyable {
    public String fly();
}

class wingFly implements Flyable {
    public String fly() {
        return "Fly with wings";
    }
}

class jetksi implements Flyable {
    public String fly() {
        return "Fly with jetski";
    }
}

abstract class Robot {
    private Talkable  talkBehaviour;
    private Walkable walkBehaviour;
    private Flyable flyBehaviour;

    public Robot(Talkable t, Walkable w, Flyable f) {
        this.flyBehaviour = f;
        this.talkBehaviour = t;
        this.walkBehaviour = w;
    }

    public String walk() {
        return walkBehaviour.walk();
    }

    public String talk() {
        return talkBehaviour.talk();
    }

    public String fly() {
        return flyBehaviour.fly();
    }

    public abstract void Projection();

}


class componiunRobot extends Robot {
    public componiunRobot(Walkable w, Talkable t, Flyable f) {
        super(t, w, f);
    }

    public void Projection() {
        System.out.println("This is ComponiunRobot projection");
    }
}

class AutoMaticRobot extends Robot {
    public AutoMaticRobot(Walkable w, Talkable t, Flyable f) {
        super(t, w, f);
    }

    public void Projection() {
        System.out.println("This is ComponiunRobot projection");
    }
}

public class Main {
    public static void main(String[] args) {
        
        componiunRobot robot1 = new componiunRobot(new normalWalk(), new extraTalk(), new wingFly());
        System.out.println(robot1.walk());
        System.out.println(robot1.talk());
        System.out.println(robot1.fly());
        
        AutoMaticRobot robot2 = new AutoMaticRobot(new fastWalk(), new normalTalk(), new jetksi());
        System.out.println(robot2.walk());
        System.out.println(robot2.talk());
        System.out.println(robot2.fly());
    }
}

