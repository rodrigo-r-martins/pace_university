/*
Revise PersonalDataTest problem to read a list of inputs from a file.
The input file will contain two strings followed by an integer.
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadPersonalData {
    public static void main(String[] args) throws Exception {

        try {
            File file = new File("personalData.txt");
            Scanner scan = new Scanner(file);

            ArrayList<String> storeInput = new ArrayList<>();
            int i=0;
            String input = scan.nextLine();
            storeInput.add(i, input);

            while (scan.hasNextLine()) {
                i++;
		input = scan.nextLine();
		storeInput.add(i, input);
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

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
