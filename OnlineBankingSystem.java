class InsufficientBalanceException extends Exception {

    InsufficientBalanceException(String msg) {
        super(msg);
    }
}

class BankAccount {

    private int balance = 1000;

    // Deposit Method
    synchronized void deposit(int amount) {

        balance = balance + amount;

        System.out.println(Thread.currentThread().getName()
                + " Deposited: " + amount);

        System.out.println("Current Balance: " + balance);
    }

    // Withdraw Method
    synchronized void withdraw(int amount)
            throws InsufficientBalanceException {

        if (amount > balance) {
            throw new InsufficientBalanceException(
                    "Insufficient Balance!");
        }

        balance = balance - amount;

        System.out.println(Thread.currentThread().getName()
                + " Withdrawn: " + amount);

        System.out.println("Current Balance: " + balance);
    }

    synchronized void checkBalance() {
        System.out.println("Available Balance: " + balance);
    }
}

// Thread Class
class UserTransaction extends Thread {

    BankAccount account;
    int amount;
    String type;

    UserTransaction(BankAccount account,
                    String type,
                    int amount) {

        this.account = account;
        this.type = type;
        this.amount = amount;
    }

    public void run() {

        try {

            if (type.equals("deposit")) {
                account.deposit(amount);
            }

            else if (type.equals("withdraw")) {
                account.withdraw(amount);
            }

            account.checkBalance();

        }

        catch (InsufficientBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}

// Main Class
public class OnlineBankingSystem {

    public static void main(String[] args) {

        BankAccount acc = new BankAccount();

        UserTransaction t1 =
                new UserTransaction(acc,
                        "deposit", 500);

        UserTransaction t2 =
                new UserTransaction(acc,
                        "withdraw", 700);

        UserTransaction t3 =
                new UserTransaction(acc,
                        "withdraw", 2000);

        t1.setName("User-1");
        t2.setName("User-2");
        t3.setName("User-3");

        t1.start();
        t2.start();
        t3.start();
    }
}