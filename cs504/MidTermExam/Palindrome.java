/*
Given an array of char, program must check if the word formed by all characters is a palindrome.
Palindrome is a word that is read the same way from one direction or another.
 */

public class Palindrome {

    static boolean isPalindrome(char[] myArray) {
        int x = 0;
        int y = myArray.length-1;

        while (x < y) {
            if (myArray[x]  != myArray[y]) {
                return false;
            }
            x++;
            y--;
        }
        return true;

        /*
        *** The way I did!

        boolean pal = false;
        String dir1 = "";
        String dir2 = "";

        for (int i=0; i<myArray.length; i++) {
            dir1 += myArray[i];
        }

        for (int i=myArray.length-1; i>=0; i--) {
            dir2 += myArray[i];
        }

        if (dir1.equals(dir2)) {        // I used (dir1 == dir2) which is not correct
            pal = true;
        }
        return pal;
        */
    }

    public static void main(String[] args) {

        char[] palin = {'R', 'A', 'C', 'E', 'C', 'A', 'R'};
        boolean palindrome = isPalindrome(palin);
        System.out.println(palindrome);
    }
}
