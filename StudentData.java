
class StudentData {
  protected String fileName;
  protected String[][] StudentData;
  
  // constructor for studentData 
  public StudentData(String fileName){
    this.fileName = fileName;
    StudentDataReader reader = new StudentDataReader(fileName);
    this.StudentData = reader.readStudentsOverseer();
    }
}
