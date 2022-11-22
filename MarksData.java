import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MarksData extends ReaderWriter{
    /*public static void main(){
        String[][] AnswerData;
        String[][] ResponseData;
        String newFileName;
    }
        */
    /**
     * Writes a two dimensional array into a csv file
     * @param data the 2D array that is being written into the file
     */
    public static void putlnCsv(String[][] data){
        try {
            // Initialize new file
            String name = getNewName();
            File myObj = new File(name);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                FileWriter writer = new FileWriter(name);
                // Loop through both axis of the array and write each section into the file
                // Separate j values with commas and i values with new lines
                for (int i = 0; i < data.length; i++){
                    for (int j = 0; j < data[i].length; j++){
                        writer.write(data[i][j]);
                        if (j < data[i].length - 1){
                            writer.write(",");
                        }
                    }
                    writer.write("\n");

                }
                writer.close();
            // If file already exists, give an appropriate warning
            } else {
                System.out.println("File already exists.");
            }
          } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
          }

    }
    public static String getNewName(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Input the name of your new file. (Include the file type ex. .txt, .csv)");
        String newName = reader.nextLine();
        reader.close();
        return newName;
    }
}
