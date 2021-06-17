public class Bird implements Speaker, Walker {

    @Override
    public void speak() {
        System.out.println("Chirp");
    }

    @Override
    public void walk() {
        System.out.println("Fly");
    }
}
