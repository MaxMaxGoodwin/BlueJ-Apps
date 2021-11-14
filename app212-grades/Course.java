import java.util.ArrayList;
/**
 * This class stores information about a course
 * that enrolled students may want to complete
 *
 * @author Derek Peacock and Nicholas Day
 * @version 4.0   5/11/2021
 */
public class Course
{
    public final static int MAXN_MODULES = 4;
    
    public ArrayList<Module> modules;
    
    private String code;
    private String title;
    
    private Grades finalGrade;
    
    public String enrolList;
     
    /** A quick way to assign a
     * course for testing purposes.
     */
    public Course()
    {
        this("BT1GDV1", "Games Development");
    }
    
    /**
     * Constructor for objects of class Course
     */
    public Course(String code, String title)
    {
        // initialise instance variables
        this.code = code;
        this.title = title;
        
        modules  = new ArrayList<Module>();
        
        createModules();
    }
    
    /** Method to print the list of
     * enrolled students on a course
     * for testing and practical purposes (doesn't work).
     */
    /**public void printEnrolList(Course course)
    {
        this.print();
        course.print();
        
    }*/
   
    /**
     * Create four modules and add them to the
     * modules list for testing purposes.  These
     * must be your four modules.
     */
    public void createModules()
    {
        Module co450 = new Module ("CO450", "Computer Architecture");
        Module co452 = new Module ("CO452", "Programming Concepts");
        Module co459 = new Module ("CO459", "Game Design\t");
        Module co461 = new Module ("CO461", "3D Modelling\t");
        addModule(co450);
        addModule(co452);
        addModule(co459);
        addModule(co461);
    }
    
    /** Adds a module and
     * checks whether that increment has
     * exceeded the max number.
     */
    public void addModule(Module module)
    {
        if(modules.size() < MAXN_MODULES)
        {
            modules.add(module);
        }
    }
    
    /**Calculates the grade based on
     *the mark of each module for the
     *course the student is enrolled on.
     */
    public Grades convertToGrade(int mark)
    {
        if(mark >= 0 && mark <= 39)
            return Grades.F;  
        else if(mark <= 49)
            return Grades.D;  
        else if(mark <= 59)
            return Grades.C;  
        else if(mark <= 69)
            return Grades.B;
        else if(mark <= 100)
            return Grades.A;   
        else
            return Grades.NS;
    }
    
    /**
     * Calculate the average mark from the four module marks
     * and convert that into a final grade.
     */
    public Grades calculateGrade(ArrayList<ModuleMark> marks)
    {
        int total = 0;
        int finalMark = 0;
        
        for(ModuleMark mark : marks)
        {
            total = total + mark.getValue();
        }
        
        finalMark = total / MAXN_MODULES;
        finalGrade = convertToGrade(finalMark);
        
        return finalGrade;
    }
    
    /**Prints the final course grade based
     *on the finalGrade calculated above (calculateGrade)
     */
    public void printCourseGrade()
    {
        System.out.println("Final Course Grade: " + finalGrade);
    }
    
    /**
     * Prints out the details of a course and the
     * four modules
     */
    public void print()
    {
        System.out.println();
        System.out.println(" Course " + code + ": " + title);
        //System.out.println();
        
        printModules();
    }
    
    /**
     * Print the course's four modules
     */
    public void printModules()
    {
        for (Module module:  modules)
        {
            module.print();
            module.printCredit();
        }
    }
}
