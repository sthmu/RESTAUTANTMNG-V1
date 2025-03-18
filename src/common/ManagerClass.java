package common;

public abstract class ManagerClass {
    public static void clearConsole() {
        String os = System.getProperty("os.name").toLowerCase();
        try {
            if (os.contains("windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("Unable to clear the console.");
        }
    }


}
