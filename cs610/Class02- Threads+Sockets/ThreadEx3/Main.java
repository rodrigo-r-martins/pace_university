public class Main {
    public static void main(String arg[]) {
        Object mutexX = new Object();
        Object mutexY = new Object();
        Thread threadA = new Thread(new A(mutexX,mutexY));
        Thread threadB = new Thread(new B(mutexX,mutexY));
        threadA.start();
        threadB.start();
    }
}

class A implements Runnable{
    private Object mutexX, mutexY;

    public A(Object mutexX, Object mutexY) {
        this.mutexX = mutexX;
        this. mutexY = mutexY;
    }

    public void run() {
        synchronized (mutexX) {
            System.out.println("threadA got mutexX");
            synchronized (mutexY) {
                System.out.println("threadA got mutexY");
            }
        }
    }
}

class B implements Runnable{
    private Object mutexX, mutexY;

    public B(Object mutexX, Object mutexY) {
        this.mutexX = mutexX;
        this. mutexY = mutexY;
    }

    public void run() {
        synchronized (mutexY){
            System.out.println("threadB got mutexY");
            synchronized (mutexX) {
                System.out.println("threadB got mutexX");
            }
        }
    }
}

