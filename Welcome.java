package GroupProject;
import java.util.Scanner;
/*
 * Program with quiz main menu to read in user input and direct them to their choice
 */
public class Welcome {
    static String name;
    static Scanner keyboard=new Scanner(System.in);


    public static void main(String[] args) throws InterruptedException {
        //declare variables

        int age;
        char student;
        int choice;
        MentalHealthQuiz newQuiz = new MentalHealthQuiz();
        DailyCheckIn newcheckIn= new DailyCheckIn();
        QuizForSeniors newQuizForSeniors = new QuizForSeniors();
        Mindfulness newMindfulnessQuiz= new Mindfulness();
        Resources newResourcesPage= new Resources();

        System.out.println("-----------------------------------");
        System.out.println("Welcome to the Holistic Health Health Hub");
        System.out.println("-----------------------------------");
        System.out.println();

        System.out.println("Please enter your first name:");
        name = keyboard.next();

        System.out.println("Please enter your age:");
        age = keyboard.nextInt();

        //System.out.println("Are you a Student (Y/N):");
        //student = keyboard.nextLine().charAt(0);

        System.out.println(name + ", what would you like to do today");

        do {
            System.out.println("\n1. Holistic Health Quiz");
            System.out.println("2. Mental Health Daily Check in");
            System.out.println("3. Mindfulness Quiz");
            System.out.println("4. Quiz for Seniors");
            System.out.println("5. Exit");
            System.out.print("\nPlease enter your choice: ");
            choice = keyboard.nextInt();
            keyboard.nextLine();

            switch (choice) {
                case 1:

                    newQuiz.runQuiz();
                    break;
                case 2:
                    newcheckIn.runDailyCheckIn();
                    break;
                case 3:

                    newMindfulnessQuiz.runMindfulnessQuiz();
                    break;
                case 4:
                    QuizForSeniors.beginQuizForSeniors();
                    break;
                case 5:
                    System.out.println("\nYou have chosen to leave the Mental Health Hub. Thank you for visiting.");
                    break;
                default:
                    System.out.println("\nInvalid choice");
            }//switch
        } while (choice != 5);
    }//main
}//class