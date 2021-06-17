public class TestingString {
    public static void main(String[] args) {
        // TEST STRING 1
        char[] email = {'j', '.', 'c', 'h', 'i', 'n', '@', 'p', 'a', 'c', 'e', '.', 'e', 'd', 'u', '.', 'u', 'k'};
        int i=0;
        while (email[i] != '@') {
            System.out.print(email[i]);
            i++;
        }
        System.out.println("\n");

        // TEST STRING 2
        String course = "CS502";
        char[] letters = course.toCharArray();
        for (int j=0; j<letters.length; j++) {
            if (letters[j] >= '0' && letters[j] <= '9') {
                System.out.print(letters[j]);
            }
        }
        System.out.println("\n");

        // TEST STRING 3
        String joe = "joe";
        String jill = "jill";
        if (joe == jill)
            System.out.println("joe = jill");
        else
            System.out.println("joe != jill");

        // TEST STRING 4
        // using char[] email = {'j', '.', 'c', 'h', 'i', 'n', '@', 'p', 'a', 'c', 'e', '.', 'e', 'd', 'u', '.', 'u', 'k'};
        int startingIndex=0;
        int endingIndex=0;
        boolean found=false;

        for (int x=0; x<email.length; x++) {
            if (email[x] == '@') {
                startingIndex = x+1;
                found=true;
            }
            if (email[x] == '.' && found) {
                endingIndex = x;
                found=false;
            }
        }

        for (int y=startingIndex; y<endingIndex; y++) {
            System.out.print(email[y]);
        }
    }
}
