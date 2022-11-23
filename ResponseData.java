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
    }
}
