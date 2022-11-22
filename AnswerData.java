class AnswerData{

    protected String fileName;
    protected String[][] AnswerData;
    // constructor for answerData file name
    public AnswerData(String fileName){
        this.fileName = fileName;
        AnswerDataReader reader = new AnswerDataReader(fileName);
        this.AnswerData = reader.readAnswersOverseer();
    }
    //stores the cleaned up answer file from AnswerDataReader, and stores it into 2D array
    //String[][] answers = answers();
}
