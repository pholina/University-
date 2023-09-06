import java.nio.channels.NetworkChannel;

/**
 * Write a description of class Student here.
 * Selina Nguyen
 * November 28, 2021
 */
public class Student {
  private static int MAX_REGISTERED_COURSES = 4; // max number of courses a student can enroll

  private String name; // name of student
  private String[] registeredCourses; // list of currently registered courses
  private int numberOfRegisteredCourses; // number of courses currently registered
  private University university; // university student belongs to

  // constructor -- create a new student at this university
  /**
   * Student class constructor.
   */
  public Student(String newName, University uni) {
    name = newName;
    university = uni;
    registeredCourses = new String[MAX_REGISTERED_COURSES];
    numberOfRegisteredCourses = 0;

  }

  // return the name of student
  // name is a private variable, so need getter method
  public String getName() {
    return this.name;
  }

  // return true if student is registered for the given course
  /**
   * checks if student is registered for certain course.
   */
  public boolean isRegisteredFor(String courseName) {
    for (int i = 0; i < registeredCourses.length; i++) {
      if (registeredCourses[i] != null) {
        if (registeredCourses[i].equals(courseName)) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Add the course to the list of registeredCourses. Display message if
   * University
   * does not offer this course. Display message if student already registered for
   * this course.
   */
  public void add(String courseName) {
    if (university.hasCourse(courseName)) {
      if (isRegisteredFor(courseName)) {
        System.out.println("Already registered for " + courseName);
      } else {
        registeredCourses[numberOfRegisteredCourses] = courseName;
        numberOfRegisteredCourses++;
        System.out.println(name + " is now registered for " + courseName);
      }
    } else {
      System.out.println("There is no course named " + courseName);
    }
  }

  // list all courses that student is registered for
  /**
   * list all courses that student is enrolled in.
   */
  private void listCourses() {
    for (int i = 0; i < registeredCourses.length; i++) {
      if (registeredCourses[i] != null) {
        System.out.println(registeredCourses[i]);
      }
    }
  }

  /**
   * method used to drop student from class.
   */
  public void drop(String courseName) {
    // HARD
    // Bonus question
    String[] newArr = new String[MAX_REGISTERED_COURSES];
    int track = 0;
    for (int i = 0; i < registeredCourses.length; i++) {
      if (!courseName.equals(registeredCourses[i])) {
        newArr[track] = registeredCourses[i];
        track++;
      }
    }
    registeredCourses = newArr;
  }
}