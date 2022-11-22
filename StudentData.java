
class StudentData {
  protected String fileName;
  // initialize 2D array for StudentData
  protected String[][] StudentData;

  // constructor for studentData
  public StudentData(){
    // takes student data from student data reader
    StudentDataReader reader = new StudentDataReader();
    // runs overseer method that stores studentData in a 2D array
    this.StudentData = reader.readStudentsOverseer();
    }
}
