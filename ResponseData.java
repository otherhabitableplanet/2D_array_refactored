public class ResponseData{
    protected String fileName;
    //going to be a string list called ResponseData
    protected String[][] ResponseData;

    //constructor for ResponseData file name
    public ResponseData(){
        ResponseDataReader reader = new ResponseDataReader();
        //will take answer data file from the response reader
        //runs this as the 2D array
        this.ResponseData = reader.readResponsesOverseer();
        compareAnswers();
    }
    //grabs readResponses method, and put its data into responseData 2D array
    //String [][] responseData = readResponses();
}
