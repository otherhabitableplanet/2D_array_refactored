import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;


public class AnswerData extends AnswerDataReader{
    public static String answerDataFileName(){
        BufferedReader br = null;
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter answer file name (plus extension): ");
        String ans = reader.nextLine();
        
        try{
            String [][] answers = newString[countFileLength(ans)][];
            br = new BufferedReader(new AnswerDataReader(ans));
            int count = 0;
            String contentLine = br.readLine();
            
            while(contentLine != null){
                answers[count] = contentLine.split(",", -1);
                count++;
                contentLine = br.readerLine();
            }
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("Wrong file name");
        }
    }
    
}
