import java.util.Scanner;

public class Main {

    public static int[] a = new int[10];

    public static void main(String[] args) {
        ThreadA reader = new ThreadA();
        ThreadB write = new ThreadB();
        reader.start();
        write.start();
    }
}


class ThreadA extends Thread {
    public void run() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter 10 integers: ");
        for(int i = 0; i < 10; i++) {
            Main.a[i] = keyboard.nextInt();
        }
    }
}


class ThreadB extends Thread {
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println(Main.a[i]);
        }
    }
}


