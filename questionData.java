class QuestionData {
  
  public static void questionArray(){
    String [][] questionData = new String[countLines(this.fileName)][];
  }

  public QuestionData(String fileName){
  this.fileName = fileName;
  QuestionDataReader reader = new QuestionDataReader(fileName);
  this.QuestionData = reader.readQuestionsOverseer();
} 
}