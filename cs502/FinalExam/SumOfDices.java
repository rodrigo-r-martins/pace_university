public class SumOfDices {
    public static void main(String[] args) {
	int sum=0;
        for (int d1=1; d1<=6; d1++) {
            for (int d2=1; d2<=6; d2++) {
		sum=d1+d2;
                if (sum == 7 || sum == 11) {
                    System.out.println("Dice1 = " + d1);
                    System.out.println("Dice2 = " + d2);
		    System.out.println(d1 + "+" + d2 + "= " + sum);
                }
            }
        }
    }
}
