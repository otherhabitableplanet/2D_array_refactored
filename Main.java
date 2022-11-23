import java.util.Scanner;
import java.io.*;

class Main {
    public static void main(String[] args){
        StudentData studentData = new StudentData(); // add contstructor
        String fileName = getFileName();
        AnswerData answerData;
        if(!isAnswerFile(fileName)){
            QuestionData questionData = new QuestionData(fileName); // add constructor
        }
        else{
            answerData = new AnswerData(fileName);
        }

        ResponseData responseData = new ResponseData(); // add constructor


        MarksData marksData = new MarksData();
        marksData.putlnCsv(compareAnswers.checkAnswers(responseData, answerData));

    }
    public static String getFileName(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Input the name of the file containing answer data. Include the proper path.");
        String fileName = reader.nextLine();
        reader.close();
        return fileName;
    }
    public static boolean isAnswerFile(String filename){
        BufferedReader br = null;
        boolean isAnswerFile = false;
        // System.out.println("Running readStudents method:");
        try {
            // Put our file reader into the file given to the method upon calling
            br = new BufferedReader(new FileReader(filename));
               	//One way of reading the file
			// System.out.println("Counting the number of lines...");
			String contentLine = br.readLine();
			if (contentLine.toLowerCase().startsWith("a")){
                isAnswerFile = true;
            }
            else {
                isAnswerFile = false;
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
        return isAnswerFile;
    }
}
