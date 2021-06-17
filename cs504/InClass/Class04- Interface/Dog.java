public class Dog implements Speaker, Walker {

    @Override
    public void speak() {
        System.out.println("Woof");
    }

    @Override
    public void walk() {
        System.out.println("4 feet");
    }
}
