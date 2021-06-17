import java.util.Scanner;
import java.util.ArrayList;

public class PersonalDataTest {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ArrayList<String> storeInput = new ArrayList<>();
        System.out.println("Enter input {firstName<tab>lastName<tab>zipCode}: ");
        String input = scan.nextLine();

        int i=0;
        while (!(input.equals("quit"))) {
            storeInput.add(i, input);

            System.out.println("Enter input {firstName<tab>lastName<tab>zipCode}: ");
            input = scan.nextLine();
            i++;
        }

        ArrayList<PersonalData> personalData = new ArrayList<>();
        String[] splitPd;

        for(int x=0; x<storeInput.size(); x++) {
            splitPd = storeInput.get(x).split("\t");
            personalData.add(x, new PersonalData(splitPd[0], splitPd[1], Integer.parseInt(splitPd[2])));
        }

        for (int x=0; x<personalData.size(); x++) {
            System.out.println(personalData.get(x).toString());
        }
    }
}
