public class CheckValues {

    static int F(int num) {
        int X = 0;
        int Y = 1;
        int Z = 1;
        if (num <= 0) {
            X = 3;
        } else {
            for (int i=0; i<num; i++) {
                X = Y+Z;
                Z = Y;
                Y = X;
            }
        }
        return X;
    }

    public static void main(String[] args) {
        System.out.println(F(3));
        System.out.println(F(0));
        System.out.println(F(-1));
    }
}
