import java.io.*;
class QuestionDataReader extends ReaderWriter{
    protected String[] questionsRead;
    protected String[] readQuestions(){
        readQuestions(fileName, null);
        return questionsRead;
    }
    public static void readQuestions(String filename, String[] questionData){
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
}
