
class StudentData {
  protected String fileName;
  // initialize 2D array for StudentData
  protected String[][] StudentData;
  
  // constructor for studentData 
  public StudentData(String fileName){
    // takes file name and gives it to reader
    this.fileName = fileName;
    // takes student data from student data reader
    StudentDataReader reader = new StudentDataReader(fileName);
    // runs overseer method that stores studentData in a 2D array
    this.StudentData = reader.readStudentsOverseer();
    }
}
