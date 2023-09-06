import java.util.Scanner;

/**
 * Write a description of class Registrar here.
 * Selina Nguyen
 * November 27, 2021
 */

public class Registrar {
  // static variable, so we can use the same keyboard for all input
  static Scanner keyboard = new Scanner(System.in);
  private static int MAX_UNI = 1000000;
  private static University[] universities = new University[MAX_UNI];
  private static int numOfUni = 0;

  // prompt user for integer and return it
  private static int getChoice(String prompt) {
    System.out.print(prompt);
    int choice = keyboard.nextInt();
    return choice;
  }

  // prompt user for String and return it
  private static String getString(String prompt) {
    System.out.print(prompt);
    String str = keyboard.next();
    return str;
  }

  /**
   * Main menu for program, asks university name.
   * Creates university object and calls universityMenu
   */
  public static void mainMenu() {
    System.out.println("Welcome to the Registrar program");
    switchUniversity();
  }

  /**
   * switches the menu for a different univerisity.
   */
  public static void switchUniversity() {
    String uniName = getString("Enter a name for University: ");
    University uni = new University(uniName);
    universityMenu(uni);
  }

  // Main university menu with registrar functions
  private static void universityMenu(University uni) {
    System.out.println("Welcome to the " + uni + " menu");
    System.out.println("1. Switch university");
    System.out.println("2. Display information about the university");
    System.out.println("3. List all courses");
    System.out.println("4. Add a course");
    System.out.println("5. Enroll a new student");
    System.out.println("6. List all students");
    System.out.println("7. Register a student for a course");
    System.out.println("8. List all students enrolled in a course");
    System.out.println("9. Drop a student from a course");
    System.out.println("10. Exit");
    int choice = getChoice("Enter command: ");
    System.out.println("Choice is " + choice);
    switch (choice) {
      case 1:
        switchUniversity();
        break;
      case 2:
        uni.information();
        break;
      case 3:
        uni.listCourses();
        break;
      case 4:
        addCourse(uni);
        break;
      case 5:
        enrollAStudent(uni);
        break;
      case 6:
        uni.listStudents();
        break;
      case 7:
        registerStudentForCourse(uni);
        break;
      case 8:
        listStudentsInCourse(uni);
        break;
      case 9:
        dropStudentFromCourse(uni);
        break;
      case 10:
        System.out.println("Thank you for using the Registrar program");
        System.exit(0);
        break;
      default:
        System.out.println("Invalid choice " + choice);
    }
    System.out.println();
    universityMenu(uni);
  }

  // checks if the course is already offered at university
  // if course is not offered, adds course
  private static void addCourse(University uni) {
    String courseName = getString("Enter a course name: ");
    // Error to print:
    // System.out.println("Already have a course named " + courseName);
    if (uni.hasCourse(courseName)) {
      System.out.println("Already have a course named " + courseName);
    }
    uni.addCourse(courseName);
    System.out.println("Added new course");
  }

  // gets name from user, creates Student object and
  // enrolls the new student at university
  private static void enrollAStudent(University uni) {
    String studName = getString("Enter student name: ");
    Student student = new Student(studName, uni);
    uni.enroll(student);
    System.out.println("Enrolled student");
  }

  // gets name from user, checks if the student with that name
  // can be found at university.
  // If student is found, gets course name
  // if course is offered at university and student is not
  // already registered for the course, add student to that course
  private static void registerStudentForCourse(University uni) {
    String studName = getString("Enter student name: ");
    if (uni.getStudent(studName) != null) {
      String courseName = getString("Enter course name: ");
      if (uni.hasCourse(courseName)) {
        Student stu = uni.getStudent(studName);
        if (stu.isRegisteredFor(courseName)) {
          System.out.println(studName + " is already registered in " + courseName);
        } else {
          stu.add(courseName);
          System.out.println("Registered student for a course");
        }
      } else {
        System.out.println(courseName + " is not one of the courses offered ");
      }

    } else {
      System.out.println("Could not find student with name " + studName);
    }

    // Error to print:
    // System.out.println("Could not find student with name " + studentName);
    // System.out.println(studentName + " is already registered in " + courseName);
    // System.out.println(courseName + " is not one of the courses offered ");
  }

  /**
   * drops students from a course they registered for.
   */
  public static void dropStudentFromCourse(University uni) {
    String studName = getString("Enter student name: ");
    if (uni.getStudent(studName) != null) {
      String courseName = getString("Enter course name: ");
      if (uni.hasCourse(courseName)) {
        Student stu = uni.getStudent(studName);
        if (stu.isRegisteredFor(courseName)) {
          stu.drop(courseName);
        } else {
          System.out.println(studName + " is not in " + courseName);
        }
      } else {
        System.out.println(courseName + " is not one of the courses offered ");
      }

    } else {
      System.out.println("Could not find student with name " + studName);
    }
  }

  // gets course name from user, if course is offered
  // prints all students taking that course
  private static void listStudentsInCourse(University uni) {
    String courseName = getString("Enter course name: ");
    if (uni.hasCourse(courseName)) {
      uni.listStudentsInCourse(courseName);
    } else {
      System.out.println(courseName + " is not one of the courses offered ");
    }

    // Error to print:
    // System.out.println(courseName + " is not one of the courses offered ");
  }

}
