import java.util.Scanner;

public class CheckVowel {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a letter: ");
        char vowel = scan.next().charAt(0);         // Reading first letter

        switch (vowel) {
            case 'a':
            case 'A':
            case 'e':
            case 'E':
            case 'i':
            case 'I':
            case 'o':
            case 'O':
            case 'u':
            case 'U':
                System.out.println("It's a vowel");
                break;
            default:
                System.out.println("It's not a vowel");
        }
    }
}
