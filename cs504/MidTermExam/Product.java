// Loop within a loop: What is the output of prod?

public class Product {
    public static void main(String[] args) {
        int prod = 0;
        for (int x=3; x<=6; x++) {
            for (int y=1; y<=4; y++) {
                prod = x*y;
                System.out.println(prod);
            }
        }
    }
}
