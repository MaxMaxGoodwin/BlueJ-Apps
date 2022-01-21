
/**
 * A program that takes user input data to add a new module within a
 * course which can then be printed out in the correct format.
 *
 * @author (Max Goodwin)
 * @version (v2.0 08/10/2021)
 */
//Defines class for Module
public class Module
{
    //Assigns a variable for module code as an integer 
    public String moduleCode;
    
    //Assigns a variable for module title as a string
    public String title;
    
    //Assigns a variable for credit value as an integer
    public int creditValue;
    
    //Assigns a variable for module credit as an integer
    public int modCredit;
    
    /**
     * Method which asks the user to input the value of module code
     */
    public void getModCode(String moduleCode)
    {
        this.moduleCode = moduleCode;
    }
    
    /**
     * Method which asks the user to input the string value of title
     */
    public void getTitle(String title)
    {
        this.title = title;
    }
    
    /**
     * Method which asks the user to input the value of credit value
     */
    public void getCredValue(int creditValue)
    {
        this.creditValue = creditValue;
    }
    
    /**
     * Method which asks for user input to get value of module credit
     */
    public void getModCred(int modCredit)
    {
        this.modCredit = modCredit;
    }
    
    /**
     * A method that prints out all the values of module:
     * module title, module code, credit value and module credit value
     * with a neat header.
     */
    public void printModule()
    {
        System.out.println(" --------------------------------");
        System.out.println("   Module Details:");
        System.out.println(" --------------------------------");
        System.out.println();
        System.out.println("Title: " + title);
        System.out.println("Code: " + moduleCode);
        System.out.println("Credit Value: " + creditValue);
        System.out.println("Module Credit: " + modCredit);
        System.out.println(" --------------------------------");
    }
}
