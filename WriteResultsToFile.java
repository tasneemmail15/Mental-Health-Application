package GroupProject;
import java.io.FileWriter;   // Importing  FileWriter class
import java.io.IOException;  // Importing exception class to handle errors
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class WriteResultsToFile {

    public static void writeResult(String name, int score){
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()); //importing date & time format
        try {

            FileWriter resultsWriter = new FileWriter("fullQuiz_results.txt",true); // creating results Writer obj and assigning filename

            resultsWriter.write(name + "\t"+ score + "\t"+ timeStamp+"\n" );
            resultsWriter.close();

            System.out.println("Results successfully written to file."); //msg to display that its successful

        } catch (IOException e) {
            System.out.println("An error occurred when trying to write results to file."); //msg to display that it failed
        } //end of catch

    }//end of method
}//end of class
