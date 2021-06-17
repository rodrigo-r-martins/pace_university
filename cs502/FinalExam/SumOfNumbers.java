public class SumOfNumbers {
    public static void main(String[] args) {
        for (int x=1; x<=4; x++) {
            for (int y=2; y<x+2; y++) {
                System.out.println(x*y);
            }
        }
    }
}
