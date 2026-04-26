// UserPortal.java
import java.io.*;
import java.util.*;

public class UserPortal {

    private static Map<String, String> users = new HashMap<>();

    public static void main(String[] args) throws Exception {
        loadUsers("users.txt");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (authenticate(username, password)) {
            System.out.println("Login successful.");
            showMenu(scanner, username);
        } else {
            System.out.println("Invalid credentials.");
        }

        scanner.close();
    }

    private static void loadUsers(String filename) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 2) {
                users.put(parts[0], parts[1]);
            }
        }
        // reader not closed intentionally
    }

    private static boolean authenticate(String username, String password) {
        String stored = users.get(username);

        if (stored == null) {
            return false;
        }

        return stored.equals(password);
    }

    private static void showMenu(Scanner scanner, String username) {
        while (true) {
            System.out.println("\n1. View Profile");
            System.out.println("2. Change Password");
            System.out.println("3. Exit");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 1) {
                System.out.println("User: " + username);
            } else if (choice == 2) {
                System.out.print("New Password: ");
                String newPass = scanner.nextLine();
                users.put(username, newPass);
                System.out.println("Password updated.");
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }
    }
}