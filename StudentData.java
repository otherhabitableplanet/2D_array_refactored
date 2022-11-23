import java.util.Scanner;
class StudentData {
  protected String fileName;
  // initialize 2D array for StudentData
  protected String[][] StudentData;

  /**
  * Constructor for StudentData object
  * @param reader the scanner object used to read user input
  */
  public StudentData(Scanner reader){
    // takes student data from student data reader
    StudentDataReader sDReader = new StudentDataReader(reader);
    // runs overseer method that stores studentData in a 2D array
    this.StudentData = sDReader.readStudentsOverseer();
    }
}
