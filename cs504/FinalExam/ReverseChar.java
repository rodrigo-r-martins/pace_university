/*
Given a string and a char array of that string, It creates another char array
with same values in reverse order and print it.
*/

public class ReverseChar {

    public static void main(String[] args) {
        String word = "JimmyChin";
        System.out.println("Before reversing String:");
        System.out.println(word);
        char[] wordArr = word.toCharArray();
        char[] wordArrReverse = new char[wordArr.length];
        int i=0;

        for (int j=wordArrReverse.length-1; j>=0; j--) {
            wordArrReverse[i] = wordArr[j];
            i++;
        }

        System.out.println("After reversing String:");
        for (int x=0; x<wordArrReverse.length; x++) {
            System.out.print(wordArrReverse[x]);
        }
    }
}
