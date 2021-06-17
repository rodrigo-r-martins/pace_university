import java.util.ArrayList;

public class InterfaceTest {
    public static void main (String[] args) {

        // TESTING INTERFACE
        Dog d = new Dog();
        d.speak();

        Human h = new Human();
        h.speak();

        Bird c = new Bird();
        c.speak();

        Speaker s;
        s = h;
        System.out.println("Speaker is human:");
        s.speak();
        // s.talk();   // cannot be done because talk() is not in interface Speaker
        s = d;
        System.out.println("Speaker is dog:");
        s.speak();
        s = c;
        System.out.println("Speaker is bird:");
        s.speak();


        // USING ARRAY LIST TO USE METHODS FROM INTERFACE AND CLASSES
        System.out.println("\nMy Ark:");

        ArrayList<Walker> myArk = new ArrayList<Walker>();
        myArk.add(new Human());
        myArk.add(new Dog());
        myArk.add(new Bird());

        for (int i=0; i<myArk.size(); i++) {
            myArk.get(i).walk();
        }

    }
}
