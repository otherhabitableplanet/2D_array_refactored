import java.io.*;
import java.util.Scanner;
class QuestionDataReader extends ReaderWriter{
    protected String[][] questionData;
	public QuestionDataReader(String fileName){
		this.fileName = fileName;
		this.questionData = new String[countLines(this.fileName)][ansLenCount(fileName)];

	}
    protected String[][] readQuestionsOverseer(){
        readQuestionsProcess(this.fileName, this.questionData);
        return questionData;
    }
    public void readQuestionsProcess(String filename, String[][] questionData){
       // String answerDataFileName = "answerData1.txt";
	   int answerTotalLines = countLines(filename);
	   // System.out.println(answerTotalLines);
	   String[] lines = new String[answerTotalLines];
	   readLines(filename, lines);
	   this.questionData = new String[(answerTotalLines + 1) / 3][];

	   // Loops through the lines in the answer file
	   // Bundles the data into groups of 2, answer number and answer values
	   for (int i = 0; i < answerTotalLines; i += 3){
		   String name = lines[i];
		   String answer = lines[i + 1];
		   questionData[i/3] = new String[2];
		   questionData[i/3][0] = name;
		   questionData[i/3][1] = answer;
	   }

    }
	protected String getName(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Input the name of the file containing question data. Include the proper path.");
        String name = reader.nextLine();
        reader.close();
        return name;
    }
	protected int ansLenCount(String filename){
        BufferedReader br = null;
        int answerLength = 0;
        System.out.println("Running ansLenCount method:");
        try {
            // System.out.println("Hit the try:");
            // Put our file reader into the file given to the method upon calling
            br = new BufferedReader(new FileReader(filename));
               	//One way of reading the file
			// System.out.println("Counting the number of lines...");
			String contentLine = br.readLine();
			for (int i = 0; i < contentLine.length(); i++){
                if (contentLine.charAt(i) == ','){
                    answerLength++;
                }
                else {
                    continue;
                }
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
            return answerLength;
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
}
