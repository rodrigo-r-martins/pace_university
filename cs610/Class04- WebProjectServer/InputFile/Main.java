import java.net.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {

        try {
            URL u = new URL("http://localhost/MyWork/test.txt");
            //URL u = new URL("http://vulcan.seidenberg.pace.edu/~mbadii/test.txt");
            BufferedReader input=new BufferedReader(new InputStreamReader(u.openStream()));
            String s = input.readLine();
            while (s != null){
                System.out.println(s);
                s = input.readLine();
            }

        } catch (MalformedURLException e) {
            System.out.println(e);

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
