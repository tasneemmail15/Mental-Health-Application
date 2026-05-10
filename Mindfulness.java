package GroupProject;
import java.util.Scanner;
import GroupProject.Resources;


//   public static void main(String[] args) {


/*
 * Created by Stephanie Walker
 * Program containing a quiz and read in user input and output total score
 */

public class Mindfulness extends Welcome
{

    protected static String name;
    static int totalScore;

    static Scanner keyboard = new Scanner(System.in);

    static protected String Q1 = "Q1: \"Do you often forget names immediately after being introduced to someone?\"";
    static protected String Q2 = "Q2: \"Do you drive places on automatic pilot and often forget how you got there?\"";
    static protected String Q3 = "Q3: \"Do you find yourself preoccupied with the past and future?\"";
    static protected String Q4 = "Q4: \"Do you often rush from one thing to the next?\"";
    static protected String Q5 = "Q5: \"Do you find it difficult to stay focused on the present?\"";
    static protected String Q6 = "Q6: \"Do you find it hard to relax?\"";
    static protected String Q7 = "Q7: \"Do you always have a list of things to do?\"";
    static protected String Q8 = "Q8: \"If something goes wrong I am able to move on and turn is around\"";
    static protected String Q9 = "Q9: \"Do you scroll social media all day\"";
    static protected String Q10 = "Q10: \"Do you find your thoughts wandering when you are in a conversation with someone else\"";

    static String[] numericalQuestions = new String[]{Q1, Q2, Q3, Q4, Q5, Q6, Q7, Q8, Q9, Q10}; //declaring my numericalQs array
    static int[] numericalAnswers = new int[10]; //declaring numericalAnswers array


    public Mindfulness()
    {
    }//Default constructor

    public static void AskNumericalQuestions()

            throws InterruptedException
    {

        System.out.println(" --------------------------------------\nPlease answer the following 10 questions on a scale from 1-5, with 1 being 'Totally Disagree' and 5 being 'Totally Agree':\n");
        Thread.sleep(1000);

        for (int index = 0; index < numericalQuestions.length; index++)
        {
            System.out.println(numericalQuestions[index]);
            numericalAnswers[index] = keyboard.nextInt();

            while ((numericalAnswers[index] < 1) || (numericalAnswers[index] > 5))
            {
                System.out.println("Sorry incorrect value, please try again");
                System.out.println(numericalQuestions[index]);
                numericalAnswers[index] = keyboard.nextInt();
            } //end of while

            totalScore = totalScore + (numericalAnswers[index]);

        }//end of for loop
    }//AskNumericalQuestions


    @Override
    public String toString()
    {

        return ("-------------\nYour total score for the full quiz is: " + totalScore + " points out of a possible 50\n");
    }


    public static void returnToMainMenu()
            throws InterruptedException
    {
        Thread.sleep(5000);
        System.out.println("\n -------------------\n Thank you for taking part, you will now return to the main menu.");
        Thread.sleep(5000);
        //
    }

    public int getTotalScore()
    {
        return totalScore;
    } //method if anyone needs to call total score

    public void runMindfulnessQuiz() throws InterruptedException
    {

        AskNumericalQuestions();
        System.out.println(this);
        Resources newRec = new Resources();
        newRec.printResources(getTotalScore());
        returnToMainMenu();

    }//end of runMindfulnessQuiz method
}//main