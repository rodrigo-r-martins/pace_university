public class Human implements Speaker, Walker {

    @Override
    public void speak() {
        System.out.println("Hello");
    }

    @Override
    public void walk() {
        System.out.println("2 feet");
    }

    public void talk() {
        System.out.println("Talking...");
    }
}
