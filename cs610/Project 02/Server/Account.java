public class Account {
    private String name;
    private float balance;
    private int accountNo;

    Account() {
        name = "";
        balance = 0;
        accountNo = 0;
    }

    Account(float balance) {
        this.balance = balance;
    }

    Account(String name, float balance) {
        this.name = name;
        this.balance = balance;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getName () {
        return name;
    }

    public void setBalance(float amt) {
        balance = amt;
    }

    public float getBalance() {
        return balance;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public int getAccountNo() {
        return accountNo;
    }
}