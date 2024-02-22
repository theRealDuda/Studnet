import java.util.Objects;
import java.util.Scanner;

public class Student {

  /**
   * Student class
   * has 6 fields
   * each with a setter and getter
   * interesting methods:
   * boolean outOfSchool
   *  returns true if the student started studying
   *  at 18 years old
   * String getInfo:
   *  returns a formatted string with all the fields of an instance
   */
  private int age;
  private int year;
  private double averageGrade;
  private String name;
  private String group;
  private boolean sex; //false - female, true - male
  /**
   * Default constructor for a Student object.
   */
  public Student() {
    age = 18;
    averageGrade = 0;
    year = 1;
    name = "";
    group = "";
    sex = false;
  }

  /**
   * Constructor for a Student object with arguments passed
   * @param newAge int The age for the new instance
   * @param newYear int The year for the new instance
   * @param newAverageGrade double The average grade for the new instance
   * @param name String containing the name for the new student instance
   * @param newGroup String containing the group name for the new student instance
   */
  public Student(int newAge, int newYear, double newAverageGrade, String name, String newGroup, boolean sex) {
    setAge(newAge);
    setAverageGrade(newAverageGrade);
    setName(name);
    setGroup(newGroup);
    setYear(newYear);
    setSex(sex);
  }

  /**
   * Getter for year field
   * @return int year - the year field of the student instance
   */
  public int getYear() {
    return year;
  }

  /**
   * Setter for year field
   * @param newYear int that the instances year value will be set to
   */
  public void setYear(int newYear) {
    year = newYear;
  }

  /**
   * getter for age field
   * @return int age - the age field of the instance
   */
  public int getAge() {
    return age;
  }

  /**
   * @param newAge int that the instance's age field will be set to
   * will set only if newAge is more between zero and 150 exclusive
   */
  public void setAge(int newAge) {
    if (newAge > 0 && newAge < 150) {
      age = newAge;
    }
  }

  /**
   * Getter for averageGrade
   * @return double averageGrade the average Grade of the instance in question
   */
  public double getAverageGrade() {
    return averageGrade;
  }

  /**
   * Setter for averageGrade
   * @param newAverageGrade double that the instance's averageGrade field will be set to
   * Sets only if newAverageGrade is between 0.00 and 5.00 inclusive
   */
  public void setAverageGrade(double newAverageGrade) {
    if (newAverageGrade >= 0.0 && newAverageGrade <= 5.00) {
      averageGrade = newAverageGrade;
    }
  }

  /**
   * Getter for name
   * @return String name - the instance's name field
   */
  public String getName() {
    return name;
  }

  /**
   * Setter for name
   * @param newName String The instance's name field will
   * be set to this value if the value is not blank
   */
  public void setName(String newName) {
    if (!newName.isBlank()) {
      name = newName;
    }
  }

  /**
   * Getter for group
   * @return String group - the instance's group field
   */
  public String getGroup() {
    return group;
  }

  /**
   * Setter for group
   * @param newGroup String; Will replace the instance's group field if not blank
   */
  public void setGroup(String newGroup) {
    if (!newGroup.isEmpty()) {
      group = newGroup;
    }
  }

  /**
   * Getter for sex
   * @return boolean - the sex of the student in question
   */
  public boolean getSex() {
    return sex;
  }

  /**
   * Setter for sex
   * @param newSex - the new sex for the student
   */
  public void setSex(boolean newSex) {
    sex = newSex;
  }

  /**
   * Function used to determine if the student in question started studying
   * right after graduating from high school, i.e was 18 in first year;
   * @return boolean meaning that the student started studying at 18 if true
   * else returns false
   */
  public boolean outOfSchool() {
    return age - 17 == year;
  }

  /**
   * gets a string containing info on the instance
   * @return String - formatted string containing info on the instance
   */
  public String getInfo() {
    String checkedName;
    String checkedGroup;
    String checkedSex;
    if (Objects.equals(name, "")) {
      checkedName = "No Name";
    } else {
      checkedName = name;
    }
    if (Objects.equals(group, "")) {
      checkedGroup = "No Group";
    } else {
      checkedGroup = group;
    }
    if (sex) {
      checkedSex = "Male";
    } else {
      checkedSex = "Female";
    }
    return "Age: " + age + "\n"
        + "Year: " + year + "\n"
        + "Average grade: " + averageGrade + "\n"
        + "Name: " + checkedName + "\n"
        + "Group: " + checkedGroup + "\n"
        + "Sex: " + checkedSex + "\n";
  }
}
