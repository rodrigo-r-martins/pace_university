import java.util.ArrayList;

public class EmployeeTest {
    public static void main(String[] args) {

        // FullTime default constructor using Employee method
        Fulltime bobFT = new Fulltime();
        bobFT.setName("Bob FT");        // Called from Employee class
        bobFT.setSalary(25000);
        System.out.println("Name=" + bobFT.getName());
        System.out.println("Salary=" + bobFT.getSalary());

        // FullTime constructor(string, int) using Employee method
        Fulltime jillFT = new Fulltime("Jill FT", 25000);
        System.out.println("\nName=" + jillFT.getName());
        System.out.println("Salary=" + jillFT.getSalary());

        // PartTime constructor (string, int, int) using Employee method
        PartTime billPT = new PartTime("Bill PT", 10, 15);
        System.out.println("\nName=" + billPT.getName());
        System.out.println("Hour=" + billPT.getHour());
        System.out.println("Rate=" + billPT.getRate());

        System.out.println("\nBob FT pay=" + bobFT.pay());
        System.out.println("Bill PT pay=" + billPT.pay());


        // Printing Object
        System.out.println("\n" + bobFT + "\n");


        // ArrayList
        ArrayList<Employee> e = new ArrayList<Employee>();
        e.add(bobFT);
        e.add(jillFT);
        e.add(billPT);

        for (int i=0; i<e.size(); i++) {
            // System.out.println("name in " + i + " is " + e.get(i).getName() + " pay= " + e.get(i).pay());
            Employee emp = e.get(i);
            if (emp instanceof Fulltime) {
                System.out.println("FullTime");
                System.out.println("salary= " + ((Fulltime)emp).getSalary());
            } else if (emp instanceof PartTime) {
                System.out.println("PartTime");
                System.out.println("rate= " + ((PartTime)emp).getRate());
            }
        }

        /*
        Employee e;
        e = bobFT;
        System.out.println(e.pay());
        e = billPT;
        System.out.println(e.pay());
         */


    }
}
