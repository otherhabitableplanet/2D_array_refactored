import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MarksData{
    //going to be a string list called data
    protected String[][] data;
    
    /**
     * Writes a two dimensional array into a csv file
     * @param data the 2D array that is being written into the file
     */
    public void putlnCsv(String[][] data, Scanner reader){
        try {
            // Initialize new file
            String name = getNewName(reader);
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
            }
            // If file already exists, give an appropriate warning
            else {
                System.out.println("File already exists.");
            }
        }
        catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
          }
    }
    
    //This will take the input from user and set it as the name of the new file
    //@param reader to refer to scanner
    public static String getNewName(Scanner reader){
        System.out.println("Input the name of your new file. (Include the file type ex. .txt, .csv)");
        String newName = reader.nextLine();
        return newName;
    }
}
