package GroupProject;
import java.util.Scanner;

import static GroupProject.WriteResultsToFile.writeResult;

//AUTHOR:MONICA GAVIGAN
//CLASS DESCRIPTION: Mental health quiz. Accepting user input, generating a total score, printing recommendations to user
// and printing user's name, score and the date/time to file.

public class MentalHealthQuiz extends Welcome {


    static protected int totalScore = 0;
    static private boolean trueOrFalseAnswer = false;
    static private char Continue;
    static private int index = 0;
    static private boolean continueQuiz = true;
    static private boolean isValidAnswer; //Declaring all variables

    static Scanner keyboard = new Scanner(System.in); //Declaring scanner object

    final private static  String Q1 = "Q1: \"I often feel down or depressed\"";
    final private static  String Q2 = "Q2: \"I have little interest or pleasure in doing things I once enjoyed\"";
    final private static  String Q3 = "Q3: \"I often have trouble falling or staying asleep, or, I oversleep\"";
    final private static  String Q4 = "Q4: \"I often feel tired or lethargic\"";
    final private static  String Q5 = "Q5: \"My appetite has changed. I have little appetite, or I overeat\"";
    final private static  String Q6 = "Q6: \"I often feel like a failure, or that I am not good enough\"";
    final private static  String Q7 = "Q7: \"I often have trouble concentrating and carrying out my normal activities at school or work\"";
    final private static  String Q8 = "Q8: \"I often feel anxious, or worrisome\"";
    final private static  String Q9 = "Q9: \"I have trouble relaxing\"";
    final private static  String Q10 = "Q10: \"I often feel irritable or easily annoyed\""; //Declaring and stating all numerical qs

    final private static  String Q12 = "\"I have serious thoughts of harming myself\"";
    final private static  String Q13 = "\"I have serious thoughts of harming others\"";
    final private static  String Q14 = "\"I have made plans to end my life\""; //Declaring and stating all numerical qs


    final private static String[] numericalQuestions = new String[]{Q1, Q2, Q3, Q4, Q5, Q6, Q7, Q8, Q9, Q10}; //declaring  numericalQs array
    final private static String[] trueOrFalseQuestions = new String[]{Q12, Q13, Q14};  // declaring  true/falseQs array
    final private static int[] numericalAnswers = new int[10]; //declaring numericalAnswers array
    final private static int[] numericalWeighting = new int[]{2, 1, 2, 1, 2, 1, 2, 1, 1, 1}; //declaring weighting qs array and assigning weights to specific qs


    public MentalHealthQuiz() {
    } //Default constructor to create an object to communicate with this class

    public static void Welcome() {
//      System.out.println("Welcome to the mental health quiz. \nWhat is your name?");
//      name = keyboard.nextLine();
        System.out.println("Hi " + name + ", let's get started.\n" + "Please read the question instructions carefully\n---------------\n");
    } //end of welcome method


    private static void AskTrueFalseQuestions() throws InterruptedException {

        System.out.println("Please answer 'true' or 'false' to the next 3 questions:\n");
        Thread.sleep(2000); //the next code will wait 2secs before executing, for readability

        while ((index < trueOrFalseQuestions.length) && (continueQuiz)) {
            trueOrFalseAnswer = askQuestions(trueOrFalseQuestions[index]); //keep asking qs until the entire length of the array has been reached and continue=y


            if (trueOrFalseAnswer == true) {   //if the user answers true to any of the qs then it should stop the quiz
                System.out.println("***IT IS STRONGLY ADVISED TO PLEASE SEEK URGENT MEDICAL ATTENTION BY CALLING 999*** \n\nDo you wish to continue with the quiz?");
                Continue = keyboard.next().toUpperCase().charAt(0);
                if ((Continue != 'Y') || (Continue != 'N')) {
                    System.out.println("Sorry invalid input- please only enter 'Yes' OR 'No'");
                    keyboard.nextLine();
                    Continue = keyboard.next().toUpperCase().charAt(0);
                }
                if ((Continue == 'N')) {
                    System.out.println("Thank you for taking part, you will now return to the main menu");
                    continueQuiz = false;     //if the user says no, the quiz will end, if they say yes, it will continue

                }
            }
            index++;
        } //end of while
    } //end of method

    private static void AskNumericalQuestions()

            throws InterruptedException {

        System.out.println(" --------------------------------------\nPlease answer the following 10 questions on a scale from 1-5, with 1 being 'Totally Disagree' and 5 being 'Totally Agree':\n");
        Thread.sleep(1000); //waits 1sec before execution of next code

        for (int index = 0; index < numericalQuestions.length; index++) {
            System.out.println(numericalQuestions[index]);
            numericalAnswers[index] = keyboard.nextInt();  //asks qs and assigns answer to corresponding index in numAns array, until full

            while ((numericalAnswers[index] < 1) || (numericalAnswers[index] > 5)) {
                System.out.println("Sorry incorrect value, please enter a number between 1 and 5");
                System.out.println(numericalQuestions[index]);
                numericalAnswers[index] = keyboard.nextInt();    //if a number not between 1-5 is entered, error msg appears and same q will be asked
            } //end of while

            totalScore = totalScore + (numericalAnswers[index] * numericalWeighting[index]); //sum to generate total score

        }//end of for loop
    }//end of method


    @Override
    public String toString() {

        return ("-------------\n" + name + ", your total score for the full quiz is: " + totalScore + " points out of a possible 70");
    } //toString method to override objects information

    private static void printRecommendations() throws InterruptedException { //method to print score and recommendations based on it.

        Thread.sleep(3000); //waits 3secs before execution
        if (totalScore > 65) {
            System.out.println("It is recommended that you seek urgent medical attention");
        } else if (totalScore > 10) {
            System.out.println("It is recommended that you make an appointment with your GP or student well-being team to discuss your mental health");
        } else {
            System.out.println("It is recommended that you seek medical advice if your symptoms persist or if you see fit");
        }

        System.out.println("Please visit the Resources page for further information, or access the UU Student Well-being team here: https://www.ulster.ac.uk/wellbeing/contact \n -----------------\n\nDISCLAIMER: This application cannot provide a medical diagnosis. Please seek medical advise where necessary.");
    }//end of printRecs

    private static void returnToMainMenu() throws InterruptedException {

        Thread.sleep(3500); //waits 3.5secs before execution
        System.out.println("\n -------------------\nThank you for taking part, you will now return to the main menu. \n\n\n");
        //mainmenu();
    }

    public int getTotalScore() {
        return totalScore;
    } //method to call total score

    private static boolean askQuestions(String question) {       //method to ask true/false q, and keep asking until a valid answer has been given,
        // which is then fed to true/false q method
        isValidAnswer = false;
        do {
            System.out.println(question);

            try {
                trueOrFalseAnswer = keyboard.nextBoolean();
                isValidAnswer = true;
            } catch (Exception e) {
                System.out.println("Invalid answer, please only enter either 'true' or 'false"); //if a boolean isn't entered this msg will display, rather than the app breaking
                keyboard.nextLine(); // to flush the keyboard's last input
            }
        } while (!isValidAnswer);
        return trueOrFalseAnswer;

    }  //end of method

    public void runQuiz() throws InterruptedException {  //single method to run the quiz
        Welcome();
        AskTrueFalseQuestions();
        if (continueQuiz) {                   //if the user answers no to continue, none of the rest of the quiz will run
            AskNumericalQuestions();
            System.out.println(this);
            printRecommendations();
            returnToMainMenu();
        }//end of while
        writeResult(name, totalScore); //calls a method to write the name and score to file
    }//end of runQuiz method
} //end of  class