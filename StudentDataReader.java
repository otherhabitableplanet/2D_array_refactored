import java.io.*;
import java.util.Scanner;
class StudentDataReader extends ReaderWriter{
    protected String[][] studentData;
	public StudentDataReader(Scanner reader){
		this.fileName = getName(reader);
		this.studentData = new String[countLines(this.fileName)][5];
	}
    protected String[][] readStudentsOverseer(){
        readStudentsProcess(fileName, studentData);
        return studentData;
    }
    public static void readStudentsProcess(String filename, String[][] studentData){
        BufferedReader br = null;
        int count = 0;
        // System.out.println("Running readStudents method:");
        try {
            // Put our file reader into the file given to the method upon calling
            br = new BufferedReader(new FileReader(filename));
               	//One way of reading the file
			// System.out.println("Counting the number of lines...");
			String currentLine = br.readLine();
			while (currentLine != null) {

				// System.out.println(currentLine + " " + count);
                studentData[count] = currentLine.split(",");
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
	protected String getName(Scanner reader){
        System.out.println("Input the name of the file containing student data. Include the proper path.");
        String name = reader.nextLine();
        return name;
    }
}
