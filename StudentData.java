import java.util.Scanner;
class StudentData {
  protected String fileName;
  // initialize 2D array for StudentData
  protected String[][] StudentData;

  // constructor for studentData
  public StudentData(Scanner reader){
    // takes student data from student data reader
    StudentDataReader sDReader = new StudentDataReader(reader);
    // runs overseer method that stores studentData in a 2D array
    this.StudentData = sDReader.readStudentsOverseer();
    }
}
