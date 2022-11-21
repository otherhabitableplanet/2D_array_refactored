public class ResponseData{
    //grabs readResponses method, and put its data into responseData 2D array
    String [][] responseData = readResponses();

    public static String[][] compareAnswers(String [][] responseData, String [][] answerData){
        //creates 2D array to store the marks 
        String[][] marksData = new String[responseData.length - 1][5];
        //responseData length = 6
        for (int i = 1; i < responseData.length; i++){
            //array to store student names/info
            String[] student = responseData[i];
            //where to write student name and info in the marksData 2D array
            marksData[i - 1][0] = student[0];//at index [0][0], student [0] info will be written at that index
            marksData[i - 1][1] = student[1];//marksData[1][1]
            marksData[i - 1][2] = student[2];//marksData[2][2]
            marksData[i - 1][3] = student[3];//marksData[3][3] 
            int score = 0;//counter for score
            //columns; student.length = 4
            for (int j = 4; j < student.length; j++){
                String studentAnswer = student[j];
                String correctAnswer = answerData[j-4][1];
                if (studentAnswer.equals(correctAnswer)){
                    // Adds one to the score of the given student for each correct answer
                    score += 1;
                }
            }
            marksData[i - 1][4] = String.valueOf(score);
        }
        // printData(marksData);
        return marksData;
    }
}
