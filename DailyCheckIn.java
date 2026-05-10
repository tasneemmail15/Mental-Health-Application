package GroupProject;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/***
 * Created by: Amina Tasneem Anee
 * code for DailyCheckIn
 ***/

public class DailyCheckIn extends Welcome {
    static Scanner keyboard = new Scanner(System.in);
    static final int MAX = 5;
    static PrintWriter myOutFile;

    private static int total = 0;
    private static double avg = 0.0;
    protected static int[] dailyScore = new int[MAX];
    static protected String Q1 = "Q1: \"Has your mood lifted since you completed the quiz?\"";
    static protected String Q2 = "Q2: \"Do you find yourself being more active?\"";
    static protected String Q3 = "Q3: \"Does your sleep improved?\"";
    static protected String Q4 = "Q4: \"Are you eating properly?\"";
    static protected String Q5 = "Q5: \"Do you have a more positive perception of yourself?\"";
    static String[] dailyQuestions = new String[]{Q1, Q2, Q3, Q4, Q5}; //declaring array

//   keyboard = new Scanner(System.in);
//   dailyScore= new int[MAX];
//   total = 0;
//   avg = 0.0;

    public DailyCheckIn() {
        //default constructor
    }


    //method to add daily check-in score and asking user some daily check up questions
    protected static void addDailyScore() {
        for (int i = 0; i < dailyQuestions.length; i++) {
            System.out.println(dailyQuestions[i]);
            int score = keyboard.nextInt();
            dailyScore[i] = score;
            total += score;
        }//for loop for asking questions and total scores

        // to write the scores to the file
        writeInFile();
    }//addDailyScore

    //to write all the scores in a file
    private static void writeInFile() {
        boolean open;
        String myFileName = "score.txt";
        try {
            myOutFile = new PrintWriter(myFileName);
            open = true;
        }//try
        catch (FileNotFoundException error) {
            System.out.println("Error opening the file");
            open = false;
        }//catch
        try {
            if (open) {
                myOutFile.println("Daily Score");
                for (int index = 0; index < dailyScore.length; index++) {
                    myOutFile.print(dailyScore[index] + " ");
                }//for
                myOutFile.println();
                myOutFile.close();
                open = false;
            }//if
        }//try
        catch (Exception error) {
            System.out.println("Exception " + error.getMessage() + " caught");
        }//catch
    }//writeInFile

    //method to calculate the avg of last 5 inputs
    private void calculateAvg() {
        if (dailyScore.length > 0) {
            avg = (double) total / dailyScore.length;
        } else {
            System.out.println("Insufficient data to calculate average.");
        }
    }//calculateAvg

    public void printTotalAndAvg() {
        System.out.println("Total Score: " + total);
        System.out.println("Average Score: " + avg);
    }//printTotal


    //method to check if the score is low and recommend
    public void checkScore() {
        final int LIMIT1 = 25;
        final int LIMIT2 = 40;
        if (total <= LIMIT1)
            System.out.println("Low score detected! Please take a full quiz test!");
        else if ((total > LIMIT1) && (total < LIMIT2))
            System.out.println("Moderate Score!! Have some exercise daily to improve your mental health.");

        else
            System.out.println("You have no symptoms of mental illness!");

    }//checkScore

    //main method to call all the methods
    public void runDailyCheckIn (){
        System.out.print("\n========================Welcome to our Daily Check-in Quiz===================" +
                "============\nDaily checking in on your mental health starts with assessing how you are feeling.\nIf 30 days have been crossed since last checked-in, then take a full quiz, else take a daily Check-in test.\n");
        System.out.println("Please answer all daily basic questions. Use a scale of 1 to 10, and take note of how you feel each day.\n");
        System.out.println("Let's start the quiz.........");
        System.out.println("===================================================================================================");


        DailyCheckIn checkIn = new DailyCheckIn();
        addDailyScore();
        writeInFile();
        System.out.println("Scores successfully written to file and closed");
        checkIn.calculateAvg();
        checkIn.printTotalAndAvg();
        checkIn.checkScore();
        keyboard.close();//to close the scanner

    }//

}//class