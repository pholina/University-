/**
 * Write a description of class University here.
 * Selina Nguyen
 * November 28, 2021
 */

public class University {
  private static int MAX_COURSES = 100; // max courses at university
  private static int MAX_STUDENTS = 1000; // max students at university

  private String[] courses; // courses currently offered
  private int numberOfCourses; // number of courses currently on offer
  private Student[] students; // students enrolled at university
  private int numberOfStudents; // number of students currently enrolled
  private String name; // name of university

  // constructor -- set name of university
  // initialize courses array,
  // initialize students array
  // initialize numberOfCourses, numberOfStudents
  /**
   * University contructor.
   */
  public University(String newName) {
    name = newName;
    courses = new String[MAX_COURSES];
    students = new Student[MAX_STUDENTS];
    numberOfCourses = 0;
    numberOfStudents = 0;
  }

  // return true if a course with the given name is offered
  /**
   * returns true if a course is offered.
   */
  public boolean hasCourse(String courseName) {
    for (int i = 0; i < courses.length - 1; i++) {
      if (courses[i] != null) {
        if (courseName.equals(courses[i])) {
          return true;
        }
      }
    }
    return false;
  }

  // print out all courses offered
  /**
   * prints out courses that university offers.
   */
  public void listCourses() {
    System.out.println("Courses are: ");
    for (int i = 0; i < courses.length; i++) {
      if (courses[i] != null) {
        System.out.println(courses[i]);
      }
    }

    // TODO
  }

  // add a new course to courses[]
  /**
   * adds a new course to the course array.
   */
  public void addCourse(String courseName) {
    courses[numberOfCourses] = courseName;
    numberOfCourses++;
  }

  // print out all students enrolled at university
  /**
   * prints out students who are enrolled at university.
   */
  public void listStudents() {
    System.out.println("Students are:");
    for (Student hasStudent : students) {
      if (hasStudent != null) {
        System.out.println(hasStudent.getName());
      }
    }
    // TODO
  }

  // print out all students enrolled in this course
  /**
   * prints out students enrolled in course.
   */
  public void listStudentsInCourse(String courseName) {
    System.out.println("Students in " + courseName + " are:");
    for (Student hasStudent : students) {
      if (hasStudent != null) {
        if (hasStudent.isRegisteredFor(courseName)) {
          System.out.println(hasStudent.getName());
        }
      }
    }
  }

  // return a Student object based on name
  // if no student with that name found, return null
  /**
   * returns name of student if the student is found, if not, returns nothing.
   */
  public Student getStudent(String name) {
    for (Student studentHere : students) {
      if (studentHere != null) {
        if (name.equals(studentHere.getName())) {
          return studentHere;
        }
      }
    }
    return null;
  }

  // enroll a student at university
  public void enroll(Student student) {
    students[numberOfStudents] = student;
    numberOfStudents++;
  }

  // display information about university
  public void information() {
    System.out.println(name + " has " + numberOfCourses + " courses and "
        + numberOfStudents + " students");
  }

  // short string when university object is printed
  public String toString() {
    return "<" + name + ">";
  }

}