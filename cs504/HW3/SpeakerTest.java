public class SpeakerTest {
    public static void main(String[] args) {

        Speaker spk1 = new FirstSpeaker();
        spk1.speak();
        spk1.announce("Stand clear of closing doors, please.");

        Speaker spk2 = new SecondSpeaker();
        spk2.speak();
        spk2.announce("Attention costumers! Store is closing in 15 minutes.");

        Speaker spk3 = new ThirdSpeaker();
        spk3.speak();
        spk3.announce("Train to New Haven departing from line 20.");

        Speaker spk11;
        spk11 = spk1;
        spk11.speak();
        spk11.announce("Speaker1 (1.1) announcing something...");

        Speaker spk21;
        spk21 = spk2;
        spk21.speak();
        spk21.announce("Speaker2 (2.1) announcing something...");

        Speaker spk31;
        spk31 = spk3;
        spk31.speak();
        spk31.announce("Speaker3 (3.1) announcing something...");
    }
}
