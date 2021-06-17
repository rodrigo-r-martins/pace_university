import java.io.File;
import java.util.Scanner;

public class FileScan {
    public static void main(String[] args) throws Exception {

        if (args.length == 1) {
            try {
                File txt = new File(args[0]);                  // Reading file from args
                Scanner scan = new Scanner(txt);               // Scanning file

                int countLines = 0;
                int countWords = 0;

                while (scan.hasNextLine()) {                   // While it has another line of text
                    String s = scan.nextLine();                // Scan each line of text
                    // System.out.println(s);                  // Print each line of text
                    countLines++;                              // Count +1 for each line

                    String[] strArr = s.split(" ");     // Split each word
                    for (int i = 0; i < strArr.length; i++) {
                        countWords++;                         // Count +1 for each word
                        // System.out.println(strArr[i]);     // Print each word
                    }
                }
                System.out.println("Analyzing " + args[0] + ":");
                System.out.println("Num of lines = " + countLines);
                System.out.println("Num of words = " + countWords);
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }

        } else {
            System.out.println("Enter a file to be analyzed");
        }
    }
}
