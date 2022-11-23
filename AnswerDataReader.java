import java.io.*;
import java.util.Scanner;
class AnswerDataReader extends ReaderWriter{

    /**
     * Constructor for answerDataReader object
     * @param fileName name of the file to be read
     */
    public AnswerDataReader(String fileName){
        this.fileName = fileName;
    }

    /**
     * Runs the readAnswersProcess and
     * @return the result of the readAnswersProcess as a 2D array
     */
    protected String[][] readAnswersOverseer(){
        String[][] answerData = readAnswersProcess(this.fileName);
        return answerData;
    }

    /**
     * Reads through a given file and sorts the answer data properly
     * @param answerDataFileName the file being read
     * @return the answerData as a 2D array
     */
    public static String[][] readAnswersProcess(String answerDataFileName) {

        // String answerDataFileName = "answerData1.txt";
        int answerTotalLines = countLines(answerDataFileName);
        // System.out.println(answerTotalLines);
        String[] lines = new String[answerTotalLines];
        readLines(answerDataFileName, lines);
        String[][] answerData = new String[(answerTotalLines + 1) / 3][];

        // Loops through the lines in the answer file
        // Bundles the data into groups of 2, answer number and answer values
        for (int i = 0; i < answerTotalLines; i += 3){
            String name = lines[i];
            String answer = lines[i + 1];
            answerData[i/3] = new String[2];
            answerData[i/3][0] = name;
            answerData[i/3][1] = answer;
        }

        // printData(answerData);
        return answerData;
    }
    /**
	 * @param filename the file being read
	 * @param lines a String array used to split a line into multiple items
	 */
    public static void readLines(String filename, String[] lines){
        BufferedReader br = null;
        int count = 0;
        // System.out.println("Running readQuestions method:");
        try {
            // Put our file reader into the file given to the method upon calling
            br = new BufferedReader(new FileReader(filename));
               	//One way of reading the file
			// System.out.println("Counting the number of lines...");
			String contentLine = br.readLine();
			while (contentLine != null) {

				// System.out.println(contentLine + " " + count);
                lines[count] = contentLine;
                contentLine = br.readLine();

                count++;
			}
       	}
		catch (IOException e){
	   		e.printStackTrace();
       	}
       	finally{
	   		try {
	      		if (br != null){
					br.close();
				}
	   		}
	   		catch (IOException e) {
				System.out.println("Error in closing the BufferedReader");

	   		}
		}
    }
}
