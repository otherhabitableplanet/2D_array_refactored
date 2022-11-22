public class AnswerData{
    //constructor for answerData file name
    public answerDataReader(){
        this.fileName = getName();
        this.AnswerData = new String[countLines(this.fileName)];
    }
    //stores the cleaned up answer file from AnswerDataReader, and stores it into 2D array
    String[][] answers = answers();
}
