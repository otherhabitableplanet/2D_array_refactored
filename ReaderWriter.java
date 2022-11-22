import java.io.*;
import java.util.Scanner;

class ReaderWriter {
    // Identified upon instantiation
    protected String fileName;

    protected static int countLines(String file) {
        // Declare a file reader called br
        BufferedReader br = null;
        // Declare a counter
        int count = 0;
        try {
            // Put our file reader into the file given to the method upon calling
            br = new BufferedReader(new FileReader(file));
               	//One way of reading the file
			System.out.println("Running countLines method:");
			String currentLine = br.readLine();
			while (currentLine != null) {
                count++;
				// System.out.println(currentLine);
				currentLine = br.readLine();
			}
            return count;
       	}
		catch (IOException e){
	   		e.printStackTrace();
            return -1;
       	}
       	finally{
	   		try {
	      		if (br != null){
					br.close();
				}
	   		}
	   		catch (IOException e) {
				System.out.println("Error in closing the BufferedReader");
                return -1;
	   		}
		}
    }

    protected String fileName(){
        Scanner reader = new Scanner(System.in);
        String newName = reader.nextLine();
        reader.close();
        return newName;
    }
}
