/*
Given a char array of some letters, It returns the letters that are duplicate (appear more than once)
*/

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class RepeatedChar {
    public static void main(String[] args) {

        char[] letters = {'a','b','e','f','a','h','t','o','f','s','r','e','a'};
        Set<Character> setChar = new TreeSet<>();

        System.out.print("Repeated letters: ");
        for (int i=0; i<letters.length-1; i++) {
            for (int j=i+1; j<letters.length; j++) {
                if (letters[i] == letters[j]) {
                    setChar.add(letters[j]);
                }
            }
        }

        Iterator it = setChar.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + ", ");
        }
        System.out.print("\b\b");
    }
}
