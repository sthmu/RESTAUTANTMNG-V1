package staff;


import common.Person;

// Staff class inheriting from Person
public class Staff extends Person {
    private String role;
    private double salary;
    private String position;

    public Staff(int id, String name, String contact, String role,double salary, String position) {
        super(id, name, contact);
        this.role = role;
        this.salary=salary;
        this.position=position;
    }

    public String getRole() {
        return role;
    }
    //set role
    public void setRole(String role) {
        this.role = role;
    }

    //get salary
    public double getSalary() {
        return salary;
    }
    //set salary
    public void setSalary(double salary) {
        this.salary = salary;
    }

    //get position
    public String getPosition() {
        return position;
    }
    //set position
    public void setPosition(String position) {
        this.position = position;
    }


    @Override
    public String toString() {
        return "Employee: " + getName() + ", Position: " + position + ", Salary: " + salary;
    }
}