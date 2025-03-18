package staff;

import common.TablePrinter;
import inventory.InventoryDatabaseManager;

import java.util.ArrayList;
import java.util.List;

// Manager class for handling staff operations
public class StaffManager {

    private List<Staff> staffList;

    private static StaffDatabaseManager staffDatabaseManager;


    public StaffManager() {
        staffList = new ArrayList<>();
        staffDatabaseManager=new StaffDatabaseManager();
        staffDatabaseManager.createStaffTable();

        //need to set the list from the database data
        staffList = staffDatabaseManager.viewStaff();
    }

    public void addStaff(int id, String name, String contact, String role,double salary, String position) {
        Staff toBeAdded=new Staff(id,name,contact,role,salary,position);
        staffList.add(toBeAdded);
        staffDatabaseManager.addStaff(toBeAdded);
    }

    public void removeEmployee(String name) {
        Staff foundStaff = null;
        for (Staff staff : staffList) {
            if (staff.getName().equals(name)) {
                foundStaff = staff;
                break;
            }
        }

        if (foundStaff != null) {
            System.out.println("Found Staff: " + foundStaff);
            staffDatabaseManager.removeStaff(name);
            staffList.removeIf(staff -> staff.getName().equals(name));

        } else {
            System.out.println("Staff not found.");
        }
    }

    public void viewStaff() {
        if (staffList.isEmpty()) {
            System.out.println("No staff records available.");
        } else {
            TablePrinter.printTable(staffList.toArray(new Staff[0]));
        }
    }
}
