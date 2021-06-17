public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch(Exception e) {
            System.out.println("Error: " + e);
            System.exit(0);
        }
        System.out.println("main method is terminated");
    }
}

