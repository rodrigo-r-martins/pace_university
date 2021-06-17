// Creating a nested for loop that I should've guess the output

public class CheckOutput {
    public static void main(String[] args) {

        int prod;
        for (int i=3; i<=5; i++) {
            for (int j=1; j<=4; j++) {
                prod = i*j;
                if (prod % 3 == 0) {
                    System.out.print(prod + " ");   // 3 6 9 12 12 15
                }
            }
        }
    }
}
