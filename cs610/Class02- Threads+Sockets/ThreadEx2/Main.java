public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread()), t2 = new Thread(new MyThread());

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch(Exception e) {
            System.out.println("Eror: " + e);
            System.exit(0);
        }
        Shared.display();
    }
}

