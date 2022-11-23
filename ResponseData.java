import java.util.Scanner;
public class ResponseData{
    protected String fileName;
    //going to be a string list called ResponseData
    protected String[][] ResponseData;

    //constructor for ResponseData file name
    public ResponseData(Scanner reader){
        ResponseDataReader rDReader = new ResponseDataReader(reader);
        //will take answer data file from the response reader
        //runs this as the 2D array
        this.ResponseData = rDReader.readResponsesOverseer();
    }
}
