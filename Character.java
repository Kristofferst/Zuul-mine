
/**
 * Abstract class Character - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Character extends Container
{
    private int health;
    private boolean alive;
    private String name; 
    private Room currentRoom;
    
    
    /**
     *  
     * @param currentRoom Room the Character will start in.
     */
    public Character(Room currentRoom, String name)
    {
        this.currentRoom = currentRoom;
        this.name = name;
    }

    /**
     * Getter for room.
     * @return Room - that the Character is in. 
     */
    public Room getCurrentRoom()
    {
        return currentRoom;
    }
    
    /**
     * Getter for health.
     * @return int - the amount of health the Character has. 
     */
    public int getHealth()
    {
        return health;
    }
    
    public boolean isAlive()
    {
        return alive;
    }
    
    //Name
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    
    /**
     * Attempts to move character from current room in direction. 
     * @param direction String for where the character should move.
     * @return boolean - Did character sucessfully move?
     */
    public boolean move(String direction)
    {   
        Room nextRoom = getCurrentRoom().getExit(direction);
        if (nextRoom == null)
        {
            return false;
        }
        else
        {
            currentRoom = nextRoom;
            return true;
        }
        
    }
    
    public void setCurrentRoom(Room room)
    {
        currentRoom = room;
    }
}
