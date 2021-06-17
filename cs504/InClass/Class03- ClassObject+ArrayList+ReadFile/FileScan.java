import java.io.File;
import java.util.Scanner;

public class FileScan {
    public static void main(String[] args) throws Exception {
        File f = new File("textfile.txt");
        Scanner scan = new Scanner(f);

        int countDay = 0;
        while (scan.hasNextLine()) {
            String s = scan.nextLine();
            // System.out.println(s);
            String[] strArr = s.split(" ");

            for (int i=0; i<strArr.length; i++) {
                // System.out.println(strArr[i]);
                if (strArr[i].toLowerCase().contains("day")) {
                    countDay++;
                }
            }
        }
        System.out.println("count day = " + countDay);
    }
}
