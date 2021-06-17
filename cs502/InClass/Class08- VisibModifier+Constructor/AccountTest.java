public class AccountTest {

  public static void main(String[] args) {

     Account joe = new Account();
     joe.deposit(100);

     System.out.println("Joe balance=" + joe.getBalance());

     Account jill = new Account(200.0);
     jill.deposit(300);
    
     System.out.println("Jill balance=" + jill.getBalance());

     Account bob = new Account(12,300.0);
     System.out.println("Bob balance=" + bob.getBalance());

     
  }

}