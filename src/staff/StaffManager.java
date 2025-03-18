package staff;

import common.TablePrinter;

import java.util.ArrayList;
import java.util.List;

// Manager class for handling staff operations
public class StaffManager {

    private List<Staff> staffList;

    public StaffManager() {
        staffList = new ArrayList<>();
    }

    public void addStaff(int id, String name, String contact, String role,double salary, String position) {
        staffList.add(new Staff(id,name,contact,role,salary,position));
    }

    public void removeEmployee(String name) {
        staffList.removeIf(staff -> staff.getName().equals(name));
    }

    public void viewStaff() {
        if (staffList.isEmpty()) {
            System.out.println("No staff records available.");
        } else {
            TablePrinter.printTable(staffList.toArray(new Staff[0]));


            for (Staff staff : staffList) {
                System.out.println(staff);
            }
        }
    }
}
