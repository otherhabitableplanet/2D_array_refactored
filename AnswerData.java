class AnswerData{

    protected String fileName;
    protected String[][] AnswerData;
    // constructor for answerData file name
    public AnswerData(String fileName){
        //takes file name, then gives the reader
        this.fileName = fileName;
        //will take answer data file from answer reader
        AnswerDataReader reader = new AnswerDataReader(fileName);
        //runs this as the 2D array
        this.AnswerData = reader.readAnswersOverseer();
    }
    //stores the cleaned up answer file from AnswerDataReader, and stores it into 2D array
    //String[][] answers = answers();
}
