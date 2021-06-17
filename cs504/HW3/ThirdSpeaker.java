public class ThirdSpeaker implements Speaker {

    @Override
    public void speak() {
        System.out.println("3rd speaker talking..");
    }

    @Override
    public void announce(String str) {
        System.out.println("3rd speaker announcement: " + str);
    }

}
