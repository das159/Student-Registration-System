package studentregistration.main;

import studentregistration.service.RegistrationService;
import studentregistration.model.Student;
import studentregistration.model.Course;
import studentregistration.model.Registration;

import java.util.Scanner;

public class RegistrationApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RegistrationService service = new RegistrationService();

        while (true) {
            System.out.println("\nStudent Registration System");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Register Student to Course");
            System.out.println("4. View Students");
            System.out.println("5. View Courses");
            System.out.println("6. View Registrations");
            System.out.println("7. Exit");
            System.out.print("Select option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Student ID: ");
                    String sid = scanner.nextLine();
                    System.out.print("Student Name: ");
                    String sname = scanner.nextLine();
                    service.addStudent(sid, sname);
                    System.out.println("Student added.");
                    break;

                case 2:
                    System.out.print("Course Code: ");
                    String ccode = scanner.nextLine();
                    System.out.print("Course Title: ");
                    String ctitle = scanner.nextLine();
                    service.addCourse(ccode, ctitle);
                    System.out.println("Course added.");
                    break;

                case 3:
                    System.out.print("Student ID: ");
                    String regSid = scanner.nextLine();
                    System.out.print("Course Code: ");
                    String regCcode = scanner.nextLine();
                    if (service.registerStudent(regSid, regCcode)) {
                        System.out.println("Registration successful.");
                    } else {
                        System.out.println("Student or Course not found.");
                    }
                    break;

                case 4:
                    for (Student s : service.getAllStudents()) {
                        System.out.println(s);
                    }
                    break;

                case 5:
                    for (Course c : service.getAllCourses()) {
                        System.out.println(c);
                    }
                    break;

                case 6:
                    for (Registration r : service.getAllRegistrations()) {
                        System.out.println(r);
                    }
                    break;

                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
