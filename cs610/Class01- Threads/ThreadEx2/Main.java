public class Main {
    public static void main(String[] args) {
        MyThread[] thrds = new MyThread[5];
        for (int i = 0; i < 5; i++) {
            thrds[i] = new MyThread();
        }

        for (int i = 0; i < 5; i++) {
            thrds[i].start();
        }

        try {
            for (int i = 0; i < 5; i++) {
                thrds[i].join();
            }
        } catch(Exception e) {
            System.out.println("Error: " + e);
            System.exit(0);
        }
        System.out.println("main method");
    }
}
