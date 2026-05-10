package GroupProject;

/*
 * Author Stephanie Walker
 * Updated on 09-12-23
 * Program to print resources based on user quiz score
 */

public class Resources extends Welcome
{

    static int totalScore;
    //declare variable

    static String intro = "From your total score, we would suggest the following recommendations we have also included some resources for you to access services easily:\n";
    //declaring intro
    static String[] resources = {"\"You can contact the community crisis intervention services here https://www.extern.org/community-crisis-intervention-service-ccisif you are unsure where to get immediate help, they aim to be with you in 30 mins.\"" +
            "For further information please contact Action Mental Health here at https://www.amh.org.uk.",
            "You may benefit from contacting Inspire Well-being here at https://www.inspirewellbeing.org for help around available therapies, coping skills and home support",
            "If you would like further information regarding what services are available to you please click on the link https://www.nhs.uk/mental-health/\"",
            "If you would like further information around how the education system can support you please click on the link https://educationhub.blog.gov.uk/2021/09/03/mental-health-resources-for-children-parents-carers-and-school-staff/",
            "If you would like more information on steps you an take yourself to improve your well being please visit https://www.nhs.uk/mental-health/self-help/"}; //declaring my resources

    public Resources()
    {
        //default constructor
    }

    public Resources(int pScore)
    {
        totalScore = pScore;
    }
    //alternate constructor

    protected int getTotalScore()
    {
        return totalScore;
    }//getTotalScore

    protected void printResources(int pTotalScore)
    {
        totalScore = pTotalScore;
        //printResources

        if (totalScore > 35)
        {
            System.out.println(intro);
            System.out.println(resources[1]);
            System.out.println(resources[2]);
            System.out.println(resources[3]);
        }//if
        else if (totalScore > 25)
        {
            System.out.println(intro);
            ;
            System.out.println(resources[3]);
            System.out.println(resources[4]);
            System.out.println(resources[5]);

        }//elseif
        else
        {
            System.out.println(intro);
            System.out.println(resources[6]);
            System.out.println(resources[7]);
            System.out.println(resources[8]);
            System.out.println(resources[9]);
            System.out.println(resources[10]);
        }//else


    }//printResources()
}//Resources