import java.util.Scanner;

public class Main {
    private static Object obj = new Object();
    public static int[] a = new int[10];

    public static void main(String[] args) {
        ThreadA reader = new ThreadA(obj);
        ThreadB write = new ThreadB(obj);
        write.start();
        reader.start();
        try {
            write.join();
            reader.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class ThreadA extends Thread {
    Object obj;

    public ThreadA(Object obj) {
        this.obj = obj;
    }
    public void run() {
        Scanner keyboard = new Scanner(System.in);
        synchronized(obj) {
            System.out.print("Please enter 10 integers: ");
            for(int i = 0; i < 10; i++) {
                Main.a[i] = keyboard.nextInt();
            }
            obj.notify();
        }
    }
}

class ThreadB extends Thread {
    Object obj;

    public ThreadB(Object obj) {
        this.obj = obj;
    }
    public void run() {
        synchronized(obj) {
            try {
                obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i = 0; i < 10; i++) {
                System.out.println(Main.a[i]);
            }
        }
    }
}

