import java.io.*;
import java.util.Scanner;
class AnswerDataReader extends ReaderWriter{
    public AnswerDataReader(String fileName){
        this.fileName = fileName;
    }
    protected String[][] readAnswersOverseer(){
        String[][] answerData = readAnswersProcess(this.fileName);
        return answerData;
    }
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
    protected String getName(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Input the name of the file containing answer data. Include the proper path.");
        String name = reader.nextLine();
        reader.close();
        return name;
    }
}
