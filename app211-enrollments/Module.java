
/**
 * A program that takes user input data to add a new module within a
 * course which can then be printed out in the correct format.
 *
 * @author (Max Goodwin)
 * @version (v1.0 07/10/2021)
 */
//Defines class for Module
public class Module
{
    //Assigns a variable for module code as an integer
    private int moduleCode;
    
    //Assigns a variable for module title as a string
    private String title;
    
    //Assigns a variable for credit value as an integer
    private int creditValue;
    
    //Assigns a variable for module credit as an integer
    private int modCredit;
    
    //Method which asks for user input to get values of code, title and credit value
    public void getValues(int moduleCode, String title, int creditValue)
    {
        this.moduleCode = moduleCode;
        this.title = title;
        this.creditValue = creditValue;
    }
    
    //Method which asks for user input to get value of module credit
    public void setModCred(int modCredit)
    {
        this.modCredit = modCredit;
    }
    
    //Method that prints out the values of title, code, credit value and module credit
    public void printModule()
    {
        System.out.println("Title: " + title);
        System.out.println("Code: " + moduleCode);
        System.out.println("Credit Value: " + creditValue);
        System.out.println("Module Credit: " + modCredit);
    }
}
