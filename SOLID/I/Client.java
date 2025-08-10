interface TwoDShape {
    public String area();
}

interface ThreeDShape {
    public String area();

    public String volume();
}

class Square implements TwoDShape {
    public String area() {
        return "Area of 2D shape";
    }
}

class Cube implements ThreeDShape {
    public String area() {
        return "3D shape area";
    }

    public String volume() {
        return "3D shape volume";
    }
}

class Client {
    public static void main(String[] args) {
        TwoDShape shape = new Square();
        System.out.println(shape.area());

        ThreeDShape threeDShape = new Cube();
        System.out.println(threeDShape.volume());
    }
}
