
// Same as EmailTest.java but using ArrayList

import java.io.File;
import java.util.*;

public class EmailTest1 {
    public static void main(String[] args) throws Exception {
        try {

            File txt = new File("attendance.txt");
            Scanner scan = new Scanner(txt);
            List<String> emailStore = new ArrayList<>();
            int index = 0;

            while (scan.hasNextLine()) {
                Email email = new Email(scan.nextLine());
                String emailToPrint = email.parseCompanyName() + "\t" + email.parseEmailName();
                emailStore.add(index, emailToPrint);
                index++;
            }

            Collections.sort(emailStore);

            // GETTING ATTENDANCE in order of company name first, then in order of name.lastname
            System.out.println("=> Getting attendance:");
            for (String s : emailStore) {
                System.out.println(s);
            }

            // Creating an HISTOGRAM on the number of attendees per company for the conference
            int[] countCpny = new int[5];
            for (int i=0; i<emailStore.size(); i++) {
                String[] splitCpny = emailStore.get(i).split("\t");
                if (splitCpny[0].equals("amzn")) {
                    countCpny[0]++;
                } else if (splitCpny[0].equals("fb")) {
                    countCpny[1]++;
                } else if (splitCpny[0].equals("goog")) {
                    countCpny[2]++;
                } else if (splitCpny[0].equals("msft")) {
                    countCpny[3]++;
                } else if (splitCpny[0].equals("orcl")){
                    countCpny[4]++;
                }
            }
            System.out.println("\n=> Histogram on the number of attendees per company for the conference:");
            System.out.println("Amazon      | " + "*".repeat(countCpny[0]));
            System.out.println("Facebook    | " + "*".repeat(countCpny[1]));
            System.out.println("Google      | " + "*".repeat(countCpny[2]));
            System.out.println("Microsoft   | " + "*".repeat(countCpny[3]));
            System.out.println("Oracle      | " + "*".repeat(countCpny[4]));


            // Checking if BILL.GATES attended the conference
            boolean billIn = false;
            System.out.println("\n=> Did Bill Gates attend the conference?");

            for (int i=0; i<emailStore.size(); i++) {
                String[] splitName = emailStore.get(i).split("\t");
                if (splitName[1].equals("bill.gates")) {
                    billIn = true;
                }
            }

            if (billIn) {
                System.out.println("Yes, he did.");
            } else {
                System.out.println("No, he didn\'t.");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
