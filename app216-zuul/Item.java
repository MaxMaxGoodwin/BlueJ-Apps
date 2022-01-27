
/**
 * A class for defining items in the game.
 *
 * @author (Max Goodwin)
 * @version 1.0     27/01/2022
 */
public class Item

{
    String name;
    String description;
    int id;
    
    public Item(String  name, String description, int id)
    {
        this.name = name;
        this.description = description;
        this.id = id;
    }
    
    public void getShortDescription()
    {
        System.out.println(name);
    }
    
    public void getLongDescription()
    {
        System.out.println(name + " " + description);
    }
}
