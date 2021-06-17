class MyThread extends MyClass implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello from thread " + this.getClass());
        display("XXXXXX");
    }
}
