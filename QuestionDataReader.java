import java.io.*;
class QuestionDataReader extends ReaderWriter{
    protected String[][] questionData;

	/**
	 * Constructs the questionDataReader object
	 * @param fileName name of the file to be read
	 */
	public QuestionDataReader(String fileName){
		this.fileName = fileName;
		this.questionData = new String[countLines(this.fileName)][ansLenCount(fileName)];

	}

	/**
	 * Runs the reading process and returns the result
	 * @return questionData as a 2D String array, clean and ready to be used
	 */
    protected String[][] readQuestionsOverseer(){
        readQuestionsProcess(this.fileName, this.questionData);
        return questionData;
    }

	/**
	 * Reads a given question file into a 2D String array
	 * @param filename the file being read
	 * @param questionData the end destination of the data read from the file
	 */
    public void readQuestionsProcess(String filename, String[][] questionData){
       // String answerDataFileName = "answerData1.txt";
	   int questionTotalLines = countLines(filename);
	   // System.out.println(questionTotalLines);
	   String[] lines = new String[questionTotalLines];
	   readLines(filename, lines);
	   this.questionData = new String[(questionTotalLines + 1) / 3][];

	   // Loops through the lines in the answer file
	   // Bundles the data into groups of 2, answer number and answer values
	   for (int i = 0; i < questionTotalLines; i += 3){
		   String name = lines[i];
		   String answer = lines[i + 1];
		   questionData[i/3] = new String[2];
		   questionData[i/3][0] = name;
		   questionData[i/3][1] = answer;
	   }

    }

	/**
	 * Counts the max amount of answers in a csv file, equal to max number of commas + 1
	 * @param filename the file being read
	 * @return the max number of commas/answers
	 */
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
