/*
Name: Nidhi Pandit
PRN: 23070126081
Batch:B1
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DBSetup.initializeDatabase(); // Setup DB & Table

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Data Entry System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> AddStudent.addStudent();
                case 2 -> ViewStudent.viewStudent();
                case 3 -> UpdateStudent.updateStudent();
                case 4 -> DeleteStudent.deleteStudent();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option!");
            }
        } while (choice != 5);

        sc.close();
    }
}
