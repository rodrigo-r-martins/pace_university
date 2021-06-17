/*
1) The attached file (attendance.txt) is a list of email addresses you collected for a conference your company hosted.
Create a program that will parse each email address by its name and company. (Note: email parser object below)
The company should be sorted in the first column and the person’s name associated with the company should be sorted
in the second column; separated with tab character.
(First sort is by company; secondary sort is by firstname.lastname)

2) Create a histogram on the number of attendees per company for the conference.

3) Check if bill.gates attended the conference.
Output that Bill Gates attended conference.

4) Create an output text file for the output above so that it can be imported in Excel for further analysis.
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class EmailTest {
    public static void main(String[] args) throws Exception {
        try {

            File txt = new File("attendance.txt");                  // Reading file to get data
            Scanner scan = new Scanner(txt);                                 // Scanning file
            Map<String, ArrayList<String>> emailStore = new TreeMap<>();     // Map Object to store data

            while (scan.hasNextLine()) {
                Email email = new Email(scan.nextLine());       // For each email is created an Object Email
                String key = email.parseCompanyName();          // Getting company name
                String value = email.parseEmailName();          // Getting name
                ArrayList<String> al;                           // ArrayList to get the list of names

                if (emailStore.containsKey(key)) {
                    al = emailStore.get(key);                   // Checking if company has already been added
                    al.add(value);                              // Adding attendee's names
                } else {
                    al = new ArrayList<>();                     // Adding company if it hasn't been added
                    al.add(value);                              // Adding attendee's names
                }
                emailStore.put(key, al);                        // Storing key and value to the Map
                Collections.sort(al);                           // Sorting ArrayList to get names in order as well
            }

            int[] counter = new int[emailStore.size()];                        // Used to print histogram
            boolean billIn = false;                                            // Used to check Bill Gates attendance
            File file = new File("attendanceData.txt");              // Creating a file
            BufferedWriter output = new BufferedWriter(new FileWriter(file));  // Writing in the created file

            // Printing attendance of conference
            System.out.println("=> Getting attendance of the conference:");

            Iterator it = emailStore.entrySet().iterator();              // Using iterator to iterate over Map
            while (it.hasNext()) {
                Map.Entry<String, ArrayList<String>> pair = (Map.Entry) it.next();
                String k = pair.getKey();                               // Getting the key of Map
                ArrayList<String> t = pair.getValue();                    // Getting values of Map

                for (String s : t) {            // Checking each value separated

                    // Printing ATTENDANCE in order of company name first + <tab> + name.lastname
                    System.out.print(k + "\t");
                    System.out.println(s);

                    // Storing HISTOGRAM data of the number of attendees per company for the conference
                    if (k.equals("amzn")) {
                        counter[0]++;
                    } else if (k.equals("fb")) {
                        counter[1]++;
                    } else if (k.equals("goog")) {
                        counter[2]++;
                    } else if (k.equals("msft")) {
                        counter[3]++;
                    } else if (k.equals("orcl")) {
                        counter[4]++;
                    }

                    // Checking if BILL.GATES attended the conference
                    if (s.equals("bill.gates")) {
                        billIn = true;
                    }

                    // Creating an OUTPUT TEXT FILE of attendance in order of company + <tab> + name.lastname,
                    // so that it can be imported in Excel for further analysis
                    String text = k + "\t" + s;
                    output.write(text);
                    output.newLine();
                }
            }
            output.close();  // Need to close file that had been written before

            // Printing HISTOGRAM
            System.out.println("\n=> Histogram with the number of attendees per company for the conference:");
            System.out.println("Amazon      | " + "*".repeat(counter[0]));
            System.out.println("Facebook    | " + "*".repeat(counter[1]));
            System.out.println("Google      | " + "*".repeat(counter[2]));
            System.out.println("Microsoft   | " + "*".repeat(counter[3]));
            System.out.println("Oracle      | " + "*".repeat(counter[4]));

            // Printing If Bill Gates attended the conference
            System.out.println("\n=> Did Bill Gates attend the conference?");
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
