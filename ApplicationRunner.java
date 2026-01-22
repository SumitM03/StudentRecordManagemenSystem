import java.util.Scanner;

public class ApplicationRunner {

    public static void main(String[] args) {

        StudentRepository repo = new StudentRepository();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Record Management System  ---");
            System.out.println("1. Register Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Department");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Full Name: ");
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Department: ");
                    String dept = sc.nextLine();
                    repo.registerStudent(
                      new StudentEntity(name, email, dept));
                    break;

                case 2:
                    repo.fetchAllStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    repo.findStudentById(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Department: ");
                    repo.updateDepartment(id, sc.nextLine());
                    break;

                case 5:
                    System.out.print("Student ID: ");
                    repo.removeStudent(sc.nextInt());
                    break;

                case 6:
                    System.out.println("Application closed");
                    System.exit(0);

                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
