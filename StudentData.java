
class StudentData {
  String studentFileName = getStudentData()
  String [][] students = new String[countLines(studentFileName)][];
  readStudents(studentFileName, students);
}