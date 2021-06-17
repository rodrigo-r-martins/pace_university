package com.example.firebaseemployee;

public class Employee {
    private String firstName;
    private String lastName;

    public Employee() {}

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString(String empID) {
        return "ID: '" + empID + "' {\n" +
                "\t\tfirstName: '" + firstName + "',\n" +
                "\t\tlastName: '" + lastName + "'\n" +
                "}\n";
    }
}
