import java.io.*;
import java.util.Scanner;
class ResponseDataReader extends ReaderWriter{
	protected String[][] responseData;

	/**
	 * The constructor for the responseDataReader object
	 * @param reader the scanner used to read user input
	 */
	public ResponseDataReader(Scanner reader){
		this.fileName = getName(reader);
		this.responseData = new String[countLines(fileName)][ansLenCount(fileName)];
	}

	/**
	 * Runs the readResponsesProcess and
	 * @return the results of the process as a 2D String array
	 */
    protected String[][] readResponsesOverseer(){
        readResponsesProcess(fileName, responseData);
        return responseData;
    }

	/**
	 * Reads the the response data file and sorts the data into a 2D String array
	 * @param filename the file being read
	 * @param responseData the end location of the data read from the file
	 */
    public static void readResponsesProcess(String filename, String[][] responseData){
        BufferedReader br = null;
        int count = 0;
        // System.out.println("Running readResponses method:");
        try {
            // Put our file reader into the file given to the method upon calling
            br = new BufferedReader(new FileReader(filename));
               	//One way of reading the file
			// System.out.println("Counting the number of lines...");
			String currentLine = br.readLine();
			while (currentLine != null) {
				// System.out.println(currentLine + " " + count);
                responseData[count] = currentLine.split(",");
                currentLine = br.readLine();
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

	/**
	 * Gets the name of the file containing response data
	 * @param reader the scanner object used to read user input
	 * @return the name of the file
	 */
	protected String getName(Scanner reader){
        System.out.println("Input the name of the file containing response data. Include the proper path.");
        String name = reader.nextLine();
        return name;
    }

	/**
	 * Counts the max amount of commas in a file which is one less than the max length of a line in the file
	 * @param filename the file being read
	 * @return the number of commas
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
}
