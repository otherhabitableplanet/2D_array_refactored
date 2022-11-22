import java.io.*;
import java.util.Scanner;
class QuestionDataReader extends ReaderWriter{
    protected String[] questionData;
	public QuestionDataReader(String fileName){
		this.fileName = fileName;
		this.questionData = new String[countLines(this.fileName)];

	}
    protected String[] readQuestionsOverseer(){
        readQuestionsProcess(this.fileName, this.questionData);
        return questionData;
    }
    public static void readQuestionsProcess(String filename, String[] questionData){
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
                questionData[count] = contentLine;
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
        System.out.println("Input the name of the file containing question data. Include the proper path.");
        String name = reader.nextLine();
        reader.close();
        return name;
    }
}
