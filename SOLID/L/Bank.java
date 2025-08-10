import java.util.*;

// Non-withdrawable accounts
interface NonWithDrawableAccounts {
    void deposit(int money);
}

// Withdrawable accounts
interface WithDrawableAccounts extends NonWithDrawableAccounts {
    void withdraw(int money);
}

// Fixed Account
class FixedAccount implements NonWithDrawableAccounts {
    private double balance;

    public FixedAccount() {
        this.balance = 0;
    }

    @Override
    public void deposit(int money) {
        balance += money;
        System.out.println("Deposited " + money + " into Fixed Account.");
    }
}

// Saving Account
class SavingAccount implements WithDrawableAccounts {
    private double balance;

    public SavingAccount() {
        this.balance = 0;
    }

    @Override
    public void deposit(int money) {
        balance += money;
        System.out.println("Deposited " + money + " into Saving Account.");
    }

    @Override
    public void withdraw(int money) {
        if (balance >= money) {
            balance -= money;
            System.out.println("Withdrew " + money + " from Saving Account.");
        } else {
            System.out.println("Insufficient balance in Saving Account.");
        }
    }
}

// Current Account
class CurrentAccount implements WithDrawableAccounts {
    private double balance;

    public CurrentAccount() {
        this.balance = 0;
    }

    @Override
    public void deposit(int money) {
        balance += money;
        System.out.println("Deposited " + money + " into Current Account.");
    }

    @Override
    public void withdraw(int money) {
        if (balance >= money) {
            balance -= money;
            System.out.println("Withdrew " + money + " from Current Account.");
        } else {
            System.out.println("Insufficient balance in Current Account.");
        }
    }
}

// Client class
class Client {
    private List<NonWithDrawableAccounts> nonWithDrawableAccounts;
    private List<WithDrawableAccounts> withDrawableAccounts;

    public Client() {
        this.nonWithDrawableAccounts = new ArrayList<>();
        this.withDrawableAccounts = new ArrayList<>();
    }

    public void createWithDrawableAccount(WithDrawableAccounts account) {
        withDrawableAccounts.add(account);
    }

    public void createNonWithDrawableAccount(NonWithDrawableAccounts account) {
        nonWithDrawableAccounts.add(account);
    }
}

// Main class
public class Bank {
    public static void main(String[] args) {
        Client client = new Client();

        // Creating accounts
        WithDrawableAccounts currentAccount = new CurrentAccount();
        NonWithDrawableAccounts fixedAccount = new FixedAccount();

        client.createWithDrawableAccount(currentAccount);
        client.createNonWithDrawableAccount(fixedAccount);

        // Using accounts
        currentAccount.deposit(1000);
        currentAccount.withdraw(300);

        fixedAccount.deposit(5000);
    }
}
