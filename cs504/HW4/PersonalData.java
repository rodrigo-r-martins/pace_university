public class PersonalData {

    private String firstName;
    private String lastName;
    private int zipCode;

    PersonalData() {}

    PersonalData(String firstName, String lastName, int zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipCode = zipCode;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getZipCode() {
        return zipCode;
    }

    @Override
    public String toString() {
        return firstName + "\t" + lastName + "\t" + zipCode;
    }
}
