import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * The main class
 * field students - arraylist of Student objects
 */
public class Main {

  public static ArrayList<Student> students = new ArrayList<Student>();

  /**
   * @param str - string to be checked
   * @return boolean - true if string can be parsed to an int
   */
  public static boolean isInteger(String str) {
    try {
      Integer.parseInt(str);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  /**
   * @param str - string to be checked
   * @return boolean - true if string can be parsed to a double
   */
  public static boolean isDouble(String str) {
    try {
      Double.parseDouble(str);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  /**
   * Function for creating a new student object
   * @return Student - a new student object with filled fields
   */
  public static Student createNewStudent() {
    boolean working = true;
    Scanner scan = new Scanner(System.in);
    int age = 0;
    int year = 0;
    double averageGrade = 0;
    String name = "";
    String group = "";
    while (working) {
      String input = "";
      while (age < 1 || age > 150) {
        System.out.println("Input the students age:");
        input = scan.nextLine();
        if (isInteger(input)) {
          age = Integer.parseInt(input);
        }
      }
      input = "";
      while (year < 1 || year > 6) {
        System.out.println("Input which year the student is in:");
        input = scan.nextLine();
        if (isInteger(input)) {
          year = Integer.parseInt(input);
        }
      }
      input = "";
      while (averageGrade < 0 || averageGrade > 5) {
        System.out.println("Input the students average grade:");
        input = scan.nextLine();
        if (isInteger(input)) {
          averageGrade = Integer.parseInt(input);
        }
      }
      input = "";
      while (input.isBlank()) {
        System.out.println("Input the students name:");
        input = scan.nextLine();
      }
      name = input;
      input = "";
      while (input.isBlank()) {
        System.out.println("Input the students group name:");
        input = scan.nextLine();
      }
      group = input;
      working = false;
    }
    return new Student(age, year, averageGrade, name, group);
  }
  public static void edit(Student inst){
    int chosen = 0;
    String input;
    Scanner scan = new Scanner(System.in);
    while (true) {
      while (chosen > 5 || chosen < 1){
        System.out.println("New cunny dropped \uD83D\uDE2D \uD83D\uDE2D \uD83D\uDE2D");
        input = scan.nextLine();
        if (isInteger(input)){
          chosen = Integer.parseInt(input);
        }
      }
      if (chosen == 1) {
        input = "";
        while (!isInteger(input)) {
          System.out.println("Input the students age:");
          input = scan.nextLine();
        }
        inst.setAge(Integer.parseInt(input));
      } else if (chosen == 2) {
        input = "";
        while (!isDouble(input)) {
          System.out.println("Input the students age:");
          input = scan.nextLine();
        }
        inst.setAverageGrade(Double.parseDouble(input));
      } else if (chosen == 3) {
        input = "";
        while (!isInteger(input)) {
          System.out.println("Input the students age:");
          input = scan.nextLine();
        }
        inst.setYear(Integer.parseInt(input));
      } else if (chosen == 4) {
        input = "";
        while (input.isBlank()) {
          System.out.println("Input the students group:");
          input = scan.nextLine();
        }
        inst.setName(input);
      } else {
        input = "";
        while (input.isBlank()) {
          System.out.println("Input the students group:");
          input = scan.nextLine();
        }
        inst.setGroup(input);
      }
    }
  }
  /**
   * Function implementing a text menu
   */
  public static void menu() {
    boolean res = false;
    boolean inp = false;
    int action = 0;
    Scanner scan = new Scanner(System.in);
    while (true) {
      String input = "";
      while (!(action > 0 && action < 6)) {
        System.out.println("""
            Choose an action:
             1)Add a new student.
             2)Edit a students information.
             3)See the students info and results.
             4)Sort the students.
             5)Quit""");
        input = scan.nextLine();
        if (isInteger(input)) {
          action = Integer.parseInt(input);
        }
      }
      if (action == 1) {
        inp = true;
        String choice = "";
        int chosen = 0;
        while (!(chosen == 1 || chosen == 2)) {
          System.out.println("""
              Would you like to:
               1)Add a new, empty student.
               2)Add a student with info.""");
          choice = scan.nextLine();
          if (isInteger(choice)) {
            chosen = Integer.parseInt(choice);
            if (chosen == 1) {
              students.add(new Student());
            } else if (chosen == 2) {
              students.add(createNewStudent());
            }
          }
        }
      } else if (action == 2) {
        if (inp) {
          boolean working = true;
          while (working) {
            System.out.println("Choose a student (input their ID, "
                + "you can find it by checking the students info):");
            String choice = "";
            int chosen = -1;
            while(chosen < 0 || chosen > students.size() ) {
              choice = scan.nextLine();
              if (isInteger(choice)){
                chosen = Integer.parseInt(choice);
              }
            }
            edit(students.get(chosen));
            working = false;
          }
        } else {
          System.out.println("Input some data first.");
        }
      } else if (action == 3) {
        if (inp) {
          int id = 0;
          for (Student inst: students) {
            if (inst.outOfSchool()) {
              System.out.println("ID: "
                  + id + "\n"
                  + inst.getInfo()
                  + "Straight from high school.\n");
            } else {
              System.out.println("ID: "
                  + id + "\n"
                  + inst.getInfo()
                  + "Spent some time somewhere else.\n");
            }
            id++;
          }
        } else {
          System.out.println("Input some data first.");
        }
      } else if (action == 4) {
        if (inp) {
          String choice = "";
          int chosen = 0;
          while (!(chosen > 0 && chosen < 6)) {
            System.out.println("""
              Would you like to sort the students by:
               1)Age.
               2)Year.
               3)Average grade.
               4)Name.
               5)Group name.""");
            choice = scan.nextLine();
            if (isInteger(choice)) {
              chosen = Integer.parseInt(choice);
              if (chosen == 1) {
                students.sort(Comparator.comparing(Student::getAge));
              } else if (chosen == 2) {
                students.sort(Comparator.comparing(Student::getYear));
              } else if (chosen == 3) {
                students.sort(Comparator.comparing(Student::getAverageGrade));
              } else if (chosen == 4) {
                students.sort(Comparator.comparing(Student::getName));
              } else if (chosen == 5) {
                students.sort(Comparator.comparing(Student::getGroup));
              }
              for(Student curr : students) {
                System.out.println(curr.getInfo());
              }
            }
          }

        } else {
          System.out.println("Input some data first.");
        }
      } else {
        System.out.println("Quitting...");
        break;
      }
      action = 0;
    }
  }

  /**
   * Entry point.
   * @param args - filler
   */
  public static void main(String[] args) {
    menu();
  }
}