package staff;



public class Staff  {
    private int id;
    private String name;
    private String contact;
    private String role;
    private double salary;
    private String position;

    public Staff(int id, String name, String contact, String role, double salary, String position) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.role = role;
        this.salary = salary;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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
        return "Employee: " + name + ", Position: " + position + ", Salary: " + salary;
    }
}