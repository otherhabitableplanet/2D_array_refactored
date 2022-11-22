public class ResponseData{
    protected String fileName;
    //going to be a string list called ansData
    protected String[][] ResponseData;
    
    //constructor for answerData file name
    public ResponseData(String fileName){
        //takes file name, then gives the reader
        this.fileName = fileName;
        ResponseDataReader reader = new ResponseDataReader(fileName);
        //will take answer data file from the answer reader
        //runs this as the 2D array
        this.ResponseData = reader.readAnswersOverseer();
    }
    //grabs readResponses method, and put its data into responseData 2D array
    //String [][] responseData = readResponses();
    compareAnswers();
}
