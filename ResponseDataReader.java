import java.io.*;
import java.util.Scanner;
class ResponseDataReader extends ReaderWriter{
	protected String[][] responseData;
	public ResponseDataReader(){
		this.fileName = getName();
		this.responseData = new String[countLines(fileName)][ansLenCount(fileName)];
	}
    protected String[][] readResponsesOverseer(){
        readResponsesProcess(fileName, responseData);
        return responseData;
    }
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
}
