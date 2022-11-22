class QuestionData {
  protected String fileName;
  protected String[] questionData;

  public QuestionData(String fileName){
    this.fileName = fileName;
    QuestionDataReader reader = new QuestionDataReader(fileName);
    this.questionData = reader.readQuestionsOverseer();
  }
}
