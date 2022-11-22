class RealMain {
    public static void main(String[] args){

        System.out.println("Input the name of the file containing the student data. (Be sure to include the proper path)");
        String studentDataFileName = reader.nextLine();
        StudentData studentData = new StudentData(); // add contstructor

        System.out.println("Input the name of the file containing the question data. (Be sure to include the proper path)");
        String answerDataFileName = reader.nextLine();
        AnswerData answerData = new AnswerData(); // add constructor
        // Find out if its question or answer file

        System.out.println("Input the name of the file containing the response data. (Be sure to include the proper path)");
        String responseDataFileName = reader.nextLine();
        ResponseData responseData = new ResponseData(); // add constructor

        System.out.println(responseDataFileName);


        reader.close();
    }
}
