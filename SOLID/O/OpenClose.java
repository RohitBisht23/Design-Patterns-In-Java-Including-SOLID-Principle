import java.util.*;
import java.time.LocalDate;
import java.time.Period;

class Product {
    double price;
    String name;
    LocalDate expiryDate;
    LocalDate creationDate;

    Product(double price, String name, Period shiftExpiryDate) {
        this.price = price;
        this.name = name;
        this.creationDate = LocalDate.now();
        this.expiryDate = creationDate.plus(shiftExpiryDate);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class ShoppingCart {
    private List<Product> products = new ArrayList<>();

    void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Product prod : products) {
            totalPrice += prod.price;
        }
        return totalPrice;
    }
}

class ShoppingCartPrinter {
    private ShoppingCart shoppingCart; // Has-A relationship

    public ShoppingCartPrinter(ShoppingCart sp) {
        this.shoppingCart = sp;
    }

    public void printInvoice() {
        System.out
                .println("------------------------------------------------------------------------------------------");

        System.out.println("\t \t \t------ Your Invoice --------- ");
        System.out.println("Dear Customer,");
        System.out.println("Thank you for choosing us.");
        System.out.println("Your total bill is :" + shoppingCart.calculateTotalPrice());
        System.out
                .println("------------------------------------------------------------------------------------------");
    }

}

interface DBPersistance {
    String saveToDB();
}

abstract class abstractDBStoreClass implements DBPersistance {
    protected ShoppingCart shoppingCart;

    public abstractDBStoreClass(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}

class SaveDataIntoSQL extends abstractDBStoreClass {

    public SaveDataIntoSQL(ShoppingCart shoppingCart) {
        super(shoppingCart);
    }

    @Override
    public String saveToDB() {
        System.out.println("Data saved into MySQL. Thank you");
        return "True";
    }
}

class SaveDataIntoMongoDB extends abstractDBStoreClass {

    public SaveDataIntoMongoDB(ShoppingCart shoppingCart) {
        super(shoppingCart);
    }

    @Override
    public String saveToDB() {
        System.out.println("Data saved into MongoDB. Thank you");
        return "True";
    }
}

class SaveDataIntoFile extends abstractDBStoreClass {

    public SaveDataIntoFile(ShoppingCart shoppingCart) {
        super(shoppingCart);
    }

    @Override
    public String saveToDB() {
        System.out.println("Data saved into Files. Thank you");
        return "True";
    }
}

class OpenClose {

    public static void main(String[] args) {
        ShoppingCart shopCart = new ShoppingCart();

        shopCart.addProduct(new Product(50, "Milk", Period.ofDays(6)));
        shopCart.addProduct(new Product(35.0, "Curd", Period.of(3, 0, 0)));

        ShoppingCartPrinter shoppingCartPrinter = new ShoppingCartPrinter(shopCart);
        DBPersistance storeIntoFile = new SaveDataIntoFile(shopCart);
        DBPersistance storeIntoSQL = new SaveDataIntoSQL(shopCart);
        DBPersistance storeIntoMongo = new SaveDataIntoMongoDB(shopCart);

        try {
            String savedIntoDB = storeIntoSQL.saveToDB();
            if ("True".equals(savedIntoDB)) {
                shoppingCartPrinter.printInvoice();
            } else {
                System.out.println("Unable to save data into DB. Try after sometime");
            }
        } catch (Exception e) {
            System.out.println("Got an error :" + e.getLocalizedMessage());
        }
    }
}
