import java.io.*;

class StudentDataReader extends ReaderWriter{
    protected String[][] fileBeenRead;
    protected String[][] read(){
        readStudents(fileName, fileBeenRead);
        return fileBeenRead;
    }
    public static void readStudents(String filename, String[][] studentData){
        BufferedReader br = null;
        int count = 0;
        // System.out.println("Running readStudents method:");
        try {
            // Put our file reader into the file given to the method upon calling
            br = new BufferedReader(new FileReader(filename));
               	//One way of reading the file
			// System.out.println("Counting the number of lines...");
			String contentLine = br.readLine();
			while (contentLine != null) {

				// System.out.println(contentLine + " " + count);
                studentData[count] = contentLine.split(",");
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
