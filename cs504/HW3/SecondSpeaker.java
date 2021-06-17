public class SecondSpeaker implements Speaker {

    @Override
    public void speak() {
        System.out.println("2nd speaker talking..");
    }

    @Override
    public void announce(String str) {
        System.out.println("2nd speaker announcement: " + str);
    }

}
