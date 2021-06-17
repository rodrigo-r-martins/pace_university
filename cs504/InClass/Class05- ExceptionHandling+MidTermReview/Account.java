public class Account {
    private int id;
    private double balance;

    Account() {
        System.out.println("In constructor:  Account()");
        id = 0;
        balance = 0;
    }

    Account(double bal) {
        System.out.println("In constructor:  Account(double bal)");
        balance = bal;
    }

    Account(int myId, double bal) {
        System.out.println("In constructor:  Account(int myId, double bal)");
        id = myId;
        balance = bal;
    }

    public void setId(int i) {
        id = i;
    }

    public int getId() {
        return id;
    }

    public void setBalance(double amt) {
        balance = amt;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amt) {
        balance = balance + amt;
    }

    public void withdraw(int amt) throws MyException {
        if (amt <= balance) {
            balance = balance - amt;
        } else {
            throw (new MyException("Not enough balance"));
        }
    }
}
