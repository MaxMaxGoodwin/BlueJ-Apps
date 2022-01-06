
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
 * @version 2.0    06/01/2022
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
     * Both locations need to have been created before
     * their exists are linked.
     */
    private void createLocations()
    {
        createOutside();
        createMain();
        createInstruction();
        createSpider();
        createCorridor();
        createDungeon();
        createCamp();
        createGravesite();
        //Outside, S(O)>Main room, E(MR)>Delapidated Corridor, E(DC)>Dungeon,
        //W(MR)>Instruction Room  S(MR)>Spider Nest, W(SN)>Boneyard, E(SN)>Camp,
        //S(C)>Treasure room
        currentLocation = outside;  // start game outside
    }
    
    public void createOutside()
    {
        outside = new Location("in a mystical bright green forest");
        
        outside.setExit("south", main);
        main.setExit("north", outside);
    }
    
    public void createMain()
    {
        main = new Location("in a large empty room that appears the be the main hall");
    
        main.setExit("north", outside);
        outside.setExit("south", main);
        
        main.setExit("west", instruction);
        instruction.setExit("east", main);
        
        main.setExit("south", spider);
        spider.setExit("north", main);
        
        main.setExit("east", corridor);
        corridor.setExit("west", main);
    }
    
    public void createInstruction()
    {
        instruction = new Location("in a strange room with jumbled instructions scribbled on the walls about how to escape");
        
        instruction.setExit("east", main);
        main.setExit("west", instruction);
    }
    
    public void createSpider()
    {
        spider = new Location("in a room infested with spiders ravenous for your blood");
        
        spider.setExit("north", main);
        main.setExit("south", spider);
        
        spider.setExit("east", camp);
        camp.setExit("west", spider);
        
        spider.setExit("west", gravesite);
        gravesite.setExit("east", spider);
    }
    
    public void createCorridor()
    {
        corridor = new Location("in a dusty, cracked and ruined old stone corridor");
        
        corridor.setExit("west ", main);
        main.setExit("east", corridor);
        
        corridor.setExit("east", dungeon);
        dungeon.setExit("west", corridor);
        
    }
    
    public void createDungeon()
    {
        dungeon = new Location("in an abandoned old dungeon coated in old blood stains");
        
        dungeon.setExit("west", corridor);
        corridor.setExit("east", dungeon);
    }
    
    public void createCamp()
    {
        camp = new Location("in a small room-makeshift-camp made of old rags and a fire that seems to burn forever");
        
        camp.setExit("west", spider);
        spider.setExit("east", camp);
    }
    
    public void createGravesite()
    {
        gravesite = new Location("in a dark damp room filled completely with skeletons");
        
        gravesite.setExit("east", spider);
        spider.setExit("west", gravesite);
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
