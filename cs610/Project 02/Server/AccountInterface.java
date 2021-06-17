import java.rmi.*;

public interface AccountInterface extends Remote {
    //In creating an account, it is the bank that selects an account number. In
    //our project the first new account is 100, the next is 101, next is 102, ...
    //Anyone can open a new account. It does not matter if the person has already accounts.
    public String createAccount(String name, float balance) throws RemoteException;

    //If the name with accountNo is in the bank return the person balance as a string.
    //otherwise either name has no account or his account no is wrong.
    public String getBalance(String name, int accountNo) throws RemoteException;

    // The account number with the name must be in the bank.
    // There is not enough fund return to the user a message.
    // There is enough funds. Withdraw and return the new balance.
    public String withdraw(String name, float amt,  int accountNo)throws RemoteException;

    // The account number with the name must be in the bank.
    // If account number with the name is in the bank, deposit and return the new balance.
    public String deposit(String name, float amt, int accountNo) throws RemoteException;

    // Both account numbers with the same name must be in the bank.
    // There is not enough fund in the account that is going to transfer return to the user a message.
    // There is enough funds. Withdraw and return the new balance.
    public String transfer(String name, int fromAccount,  int toAccount, float amt) throws RemoteException;


    // public String[] getAccounts() throws RemoteException;

}


