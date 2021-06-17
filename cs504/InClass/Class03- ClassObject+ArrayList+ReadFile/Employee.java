public class Employee {
    private String name;

    Employee() {}

    Employee(String name) {
        this.name = name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int pay() {
        return 5000;
    }

}
