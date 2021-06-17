public class AccountTest {
    public static void main(String[] args) {
        Account joe = new Account();
        joe.deposit(100);

        System.out.println("Joe balance=" + joe.getBalance());

        Account jill = new Account(200.0);
        jill.deposit(300);
        try {
            jill.withdraw(600);     // Amount is bigger than balance
        } catch (MyException me) {
            System.out.println("caught MyException");
            System.out.println(me.getMsg());
        } finally {
            System.out.println("finally: Jill balance=" + jill.getBalance());
        }
    }
}
