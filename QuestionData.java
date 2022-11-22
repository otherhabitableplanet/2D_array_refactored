class QuestionData {
  protected String fileName;
  //initialize array 
  protected String[] questionData;
 
  // constructor for questionData
  public QuestionData(String fileName){
    //takes file name and gives it to reader
    this.fileName = fileName;
    // takes question data from question data reader
    QuestionDataReader reader = new QuestionDataReader(fileName);
    // runs overseer method that stores questionData in an array
    this.questionData = reader.readQuestionsOverseer();
  }
}
