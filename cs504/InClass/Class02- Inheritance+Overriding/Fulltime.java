public class Fulltime extends Employee {
    private int salary;

    Fulltime() {
        // super("");
    }

    Fulltime(int salary) {
        // super("");
        this.salary = salary;
    }

    Fulltime(String name, int salary) {
        // super(name);
        setName(name);
        this.salary = salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public int pay() {
        return salary + super.pay();
    }
}
