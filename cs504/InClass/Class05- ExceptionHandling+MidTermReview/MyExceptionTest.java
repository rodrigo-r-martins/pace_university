public class MyExceptionTest {

    static void myMethod() throws MyException {
        throw (new MyException("cs504 exception"));
    }

    public static void main(String[] args) {

        try {
            myMethod();
            System.out.println("After myMethod()");
        } catch (MyException me) {
            System.out.println(me.getMsg());
        } finally {
            System.out.println("In finally block");
        }
    }
}
