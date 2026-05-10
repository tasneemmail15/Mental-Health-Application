package GroupProject;

import GroupProject.Welcome;

import java.util.Scanner;

/* Created by: Niamh Browne
   Quiz for users over the age of 65
 */

public class QuizForSeniors extends Welcome {
    static Scanner keyboard = new Scanner(System.in);
    static int countTrueResponses;

    QuizForSeniors(){
        //default
    }

    public static void beginQuizForSeniors() throws InterruptedException {
        callingQuizForSeniors();
        changeInputToBoolean();
        countTrueResponses();
        changeInputToBoolean();
        returnToMainMenu();
    }// calling the method begin the quiz for seniors


    //Method to run the whole quiz - questions and responses

    //array to score the users responses
    public static void callingQuizForSeniors()
    {
        boolean[] responses = new boolean[6];

        //welcoming the user to the senior quiz and letting users know what quiz they have entered
        System.out.println("------------------");
        System.out.println("Welcome " + name + ", you have entered the Quiz for ages over 65!");
        System.out.println("Please answer the following questions with yes or no");
        System.out.println("------------------");
        //end of welcome and questions about to start

        //The questions for the user to answer by giving a yes or no answer
        System.out.println("Do you often feel lonely or isolated from others?");
        responses[0] = changeInputToBoolean();
        System.out.println("Have you experienced a loss of interest in activities you once enjoyed?");
        responses[1] = changeInputToBoolean();
        System.out.println("Have mobility changes affected your outlook on life?");
        responses[2] = changeInputToBoolean();
        System.out.println("Have you experienced any mental health changes due to chronic health conditions or pains that you might have?");
        responses[3] = changeInputToBoolean();
        System.out.println("Do you feel a sense of purpose or fulfillment in your daily activities?");
        responses[4] = changeInputToBoolean();
        System.out.println("Do you have a strong support system you can rely on? (Family/Friends)");
        responses[5] = changeInputToBoolean();
        //end of qustions

        //variables to enable code to count the number of responses

        int countTrue = countTrueResponses(responses);
        int countFalse = 6 - countTrue;

        //this will provide the user with the necessary feedback - pulling from resources class or giving answer that their scores aren't concerning - no resources needed
        if (countTrue >= 4)
        {
            System.out.println("Based on your answers, your mental health is concerning, please use the following resources to find help");
            System.out.println("- Call 988 to talk to someone");
            System.out.println("- Visit https://www.justanswer.co.uk/sip/mental-health/?r=ppc|ms|8|Health+%2D+Medical+%28Google%29+%2D+GCO+%2D+Search+%2D+UKGoogleClone|Mental+Health+Helpline+%2D+Exact&JPRC=1&JPKD=30587168790&JPDC=e&JPAD=5168122922&JPKW=Mental%20Health%20Helpline&JPRQ=mental%20health%20helpline&JPAF=txt&JPCD=20140804&JPOP=&mkwid=rKnDocWS&pcrid=5168122922&pkw=Mental%20Health%20Helpline&pmt=be&msclkid=b4df2d5f69bb1fa707914827b46c8390" + "\n for  more information on how you can get help");
        } else if (countFalse >= 3)
        {
            System.out.println("Based on your responses, your mental health relatively okay. However, if you start to feel low, please consider revisiting this quiz or seek help from your GP");
        } else
        {
            System.out.println("Your mental health state does not show any significant concern at the moment. In the future please stay aware of your mental health and if needed seek further help.");
        }

    }

    //method that will change the user answer to boolean true or false
    public static boolean changeInputToBoolean() {
        boolean validInput = false;
        boolean result = false;

        while (!validInput) {
            String input = keyboard.nextLine().trim().toLowerCase();

            if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y")) {
                result = true;
                validInput = true;
            } else if (input.equalsIgnoreCase("no") || input.equalsIgnoreCase("n")) {
                result = false;
                validInput = true;
            } else {
                System.out.println("Please answer with yes or no");
            }
            countTrueResponses++;
        }
        return result;
    }


    //method to count the number of true responses given by the user
    public static int countTrueResponses (boolean... responses) {
        int count = 0;
        for (boolean response : responses)
        {
            if (response)
            {
                count++;
            }
        }
        return count;
    }

    public static void returnToMainMenu() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("-------------------");
        System.out.println("Thank you for taking part in the quiz for seniors, you will now return to the main menu.");
        Thread.sleep(3000);

        Welcome.main(null); //invokes the main menu logic after delay
    }//method to return user to main menu

    public static void main(String [] args) {
        try {
            beginQuizForSeniors();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}