
/**
 * This class is reponsible for creating and
 * linking all the Locations in the game to
 * form a 2D or 3D network
 *
 *  [Pub]<---->[Outside]<---->[Theatre]
 *                 |
 *          [Computer Lab]<---->[Office]
 *             
 * @author Derek Peacock and Nicholas Day
 * @version 4.0    28/01/2022
 */
public class Map
{
    // Need to add a list of exits
    
    private Location outside, main, instruction, spider, corridor, dungeon, camp, gravesite;

    private Location currentLocation;

    /**
     * Constructor for objects of class Map
     */
    public Map()
    {
        createLocations();
    }

    /**
     * Create all the Locations and link their exits together.
     * Set the current location to the outside.
     */
    private void createLocations()
    {
        outside = new Location("in a mystical bright green forest");
        main = new Location("in a large empty room that appears the be the main hall");
        instruction = new Location("in a strange room with jumbled instructions scribbled on the walls about how to escape");
        spider = new Location("in a room infested with spiders ravenous for your blood");
        corridor = new Location("in a dusty, cracked and ruined old stone corridor");
        dungeon = new Location("in an abandoned old dungeon coated in old blood stains");
        camp = new Location("in a small room-makeshift-camp made of old rags and a fire that seems to burn forever");
        gravesite = new Location("in a dark damp room filled completely with skeletons");
        setExitOutside();
        setExitMain();
        setExitInstruction();
        setExitSpider();
        setExitGravesite();
        setExitCamp();
        setExitCorridor();
        setExitDungeon();
        //Outside, S(O)>Main room, E(MR)>Delapidated Corridor, E(DC)>Dungeon,
        //W(MR)>Instruction Room  S(MR)>Spider Nest, W(SN)>Boneyard, E(SN)>Camp,
        //S(C)>Treasure room
        currentLocation = outside;  // start game outside
    }
    
    /**
     * Creates the exits for Outside.
     */
    private void setExitOutside()
    {
        outside.setExit("south", main);
        main.setExit("north", outside);
    }
    
    /**
     * Creates the exits for Main Room.
     */
    private void setExitMain()
    {
        main.setExit("north", outside);
        outside.setExit("south", main);
        
        main.setExit("west", instruction);
        instruction.setExit("east", main);
        
        main.setExit("south", spider);
        spider.setExit("north", main);
        
        main.setExit("east", corridor);
        corridor.setExit("west", main);
    }
    
    /**
     * Creates the exits for Instruction Room.
     */
    private void setExitInstruction()
    {
        instruction.setExit("east", main);
        main.setExit("west", instruction);
    }
    
    /**
     * Creates the exits for Spider Nest.
     */
    private void setExitSpider()
    {
        spider.setExit("north", main);
        main.setExit("south", spider);
        
        spider.setExit("east", camp);
        camp.setExit("west", spider);
        
        spider.setExit("west", gravesite);
        gravesite.setExit("east", spider);
    }
    
    /**
     * Creates the exits for Corridor.
     */
    private void setExitCorridor()
    {
        corridor.setExit("west ", main);
        main.setExit("east", corridor);
        
        corridor.setExit("east", dungeon);
        dungeon.setExit("west", corridor);
    }
    
    /**
     * Creates the exits for Dungeon.
     */
    private void setExitDungeon()
    {        
        dungeon.setExit("west", corridor);
        corridor.setExit("east", dungeon);
    }
    
    /**
     * Creates the exits for Camp.
     */
    private void setExitCamp()
    {
        camp.setExit("west", spider);
        spider.setExit("east", camp);
        
        camp.setItem(new Item("Key", "What could this old key be for?", 100));
    }
    
    /**
     * Creates the exits for Gravesite.
     */
    private void setExitGravesite()
    {
        gravesite.setExit("east", spider);
        spider.setExit("west", gravesite);
        
        gravesite.setItem(new Item("Hammer", "This hammer could come in handy", 101));
    }
    
    public Location getCurrentLocation()
    {
        return currentLocation;
    }
    
    public void enterLocation(Location nextLocation)
    {
        currentLocation = nextLocation;
    }
}
