import java.io.*;
class ResponseDataReader extends ReaderWriter{
    protected String[][] fileBeenRead;
    protected String[][] read(){
        readResponses(fileName, fileBeenRead);
        return fileBeenRead;
    }
    public static void readResponses(String filename, String[][] responseData){
        BufferedReader br = null;
        int count = 0;
        // System.out.println("Running readResponses method:");
        try {
            // Put our file reader into the file given to the method upon calling
            br = new BufferedReader(new FileReader(filename));
               	//One way of reading the file
			// System.out.println("Counting the number of lines...");
			String contentLine = br.readLine();
			while (contentLine != null) {


				// System.out.println(contentLine + " " + count);
                responseData[count] = contentLine.split(",");
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
