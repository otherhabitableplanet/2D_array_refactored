class QuestionData {
  protected String fileName;
  protected String[] questionData;
  public static void questionArray(){
    String [][] questionData = new String[countLines(this.fileName)][];
  }

  public QuestionData(String fileName){
    this.fileName = fileName;
    QuestionDataReader reader = new QuestionDataReader(fileName);
    this.questionData = reader.readQuestionsOverseer();
  }
}
