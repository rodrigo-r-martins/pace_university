public class FirstSpeaker implements Speaker {

    @Override
    public void speak() {
        System.out.println("1st speaker talking..");
    }

    @Override
    public void announce(String str) {
        System.out.println("1st speaker announcement: " + str);
    }
}
