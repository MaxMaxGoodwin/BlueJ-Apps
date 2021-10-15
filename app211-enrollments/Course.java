import java.util.*;

/**
 * This class contains information about an undergraduate course
 * at BNU together with a list of student who are enrolled
 *
 * @modified by Max Goodwin
 * @author Derek Peacock
 * @version v2.0   08/10/2021
 */
public class Course
{
    // A unique identifier e.g. BT1GDV1
    private String code;
    // The full title including qualification and subject
    private String title;
    //A new variable so that a module can be added to course
    private Module module;
    
    /**
     * Create a Course with a maximum number of enrolments. 
     * All other details are set to unknown values.
     */
    //Asks for user to input course code and title when creating new object
    public Course(String code, String title)
    {
        this.code = code;
        this.title = title;
    }

    //Old code for printing course details
    /**
     * Print the details of the course, the list
     * of students enrolled and the module
     
    public void print()
    {
        printHeading();
        
        System.out.println(" Course Code: " + code + ": " + title);
        System.out.println();
    }
    */
   
   
    /**
     * A method to print out all the details of course and module:
     * course code, course title, module code, module title,
     * module credit value and module credit in a neat header
     */
    public void printDetails()
    {
        System.out.println(" --------------------------------");
        System.out.println("   App211: Course Details");
        System.out.println(" --------------------------------");
        System.out.println();
        System.out.println("Course Code: " + code);
        System.out.println("Course Title: " + title);
        System.out.println();
        System.out.println("Module Code: " + module.moduleCode);
        System.out.println("Module Title: " + module.title);
        System.out.println("Module Credit Value: " + module.creditValue);
        System.out.println("Module Credit: " + module.modCredit);
    }
    
    //Method to add a new module to the course
    public void addModule(Module module)
    {
        this.module = module;
    }
    
        
    
}
